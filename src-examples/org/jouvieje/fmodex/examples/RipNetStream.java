/*===============================================================================================
RipNetStream Example
Copyright (c), Firelight Technologies Pty, Ltd 2004-2010.

This example shows how to rip streaming audio from the internet to local files, using
System::attachFileSystem.

This example also uses tags from the net stream to name the files as they are ripped.

Some internet radio station only broadcast new tag information on fixed intervals.  This 
means that the rip might not be exactly in line with the filenames that are produced.  
For example if a radio station only broadcast the track name every 10 seconds, and the 
music changed half way inbetween this period, then the first file would contain 5 seconds 
of the new song, and the second song would be missing  the first 5 seconds of the track.
Silence detection might help this problem, but most radio stations do not offer silence 
between  tracks.
===============================================================================================*/

package org.jouvieje.fmodex.examples;

import static org.jouvieje.fmodex.defines.FMOD_INITFLAGS.FMOD_INIT_NORMAL;
import static org.jouvieje.fmodex.defines.FMOD_MODE.FMOD_2D;
import static org.jouvieje.fmodex.defines.FMOD_MODE.FMOD_HARDWARE;
import static org.jouvieje.fmodex.defines.FMOD_MODE.FMOD_NONBLOCKING;
import static org.jouvieje.fmodex.defines.FMOD_TIMEUNIT.FMOD_TIMEUNIT_MS;
import static org.jouvieje.fmodex.defines.FMOD_TIMEUNIT.FMOD_TIMEUNIT_RAWBYTES;
import static org.jouvieje.fmodex.defines.VERSIONS.FMOD_VERSION;
import static org.jouvieje.fmodex.defines.VERSIONS.NATIVEFMODEX_JAR_VERSION;
import static org.jouvieje.fmodex.defines.VERSIONS.NATIVEFMODEX_LIBRARY_VERSION;
import static org.jouvieje.fmodex.enumerations.FMOD_CHANNELINDEX.FMOD_CHANNEL_FREE;
import static org.jouvieje.fmodex.enumerations.FMOD_OPENSTATE.FMOD_OPENSTATE_ERROR;
import static org.jouvieje.fmodex.enumerations.FMOD_OPENSTATE.FMOD_OPENSTATE_READY;
import static org.jouvieje.fmodex.enumerations.FMOD_RESULT.FMOD_ERR_FILE_NOTFOUND;
import static org.jouvieje.fmodex.enumerations.FMOD_RESULT.FMOD_ERR_INVALID_PARAM;
import static org.jouvieje.fmodex.enumerations.FMOD_RESULT.FMOD_OK;
import static org.jouvieje.fmodex.enumerations.FMOD_SOUND_TYPE.FMOD_SOUND_TYPE_MPEG;
import static org.jouvieje.fmodex.enumerations.FMOD_SOUND_TYPE.FMOD_SOUND_TYPE_OGGVORBIS;
import static org.jouvieje.fmodex.enumerations.FMOD_TAGDATATYPE.FMOD_TAGDATATYPE_STRING;
import static org.jouvieje.fmodex.utils.BufferUtils.newByteBuffer;
import static org.jouvieje.fmodex.utils.BufferUtils.SIZEOF_INT;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import javax.swing.JPanel;

import org.jouvieje.fmodex.Channel;
import org.jouvieje.fmodex.FmodEx;
import org.jouvieje.fmodex.Init;
import org.jouvieje.fmodex.Sound;
import org.jouvieje.fmodex.System;
import org.jouvieje.fmodex.callbacks.FMOD_FILE_CLOSECALLBACK;
import org.jouvieje.fmodex.callbacks.FMOD_FILE_OPENCALLBACK;
import org.jouvieje.fmodex.callbacks.FMOD_FILE_READCALLBACK;

import org.jouvieje.fmodex.enumerations.FMOD_OPENSTATE;
import org.jouvieje.fmodex.enumerations.FMOD_RESULT;
import org.jouvieje.fmodex.enumerations.FMOD_SOUND_TYPE;
import org.jouvieje.fmodex.examples.utils.ConsoleGUI;
import org.jouvieje.fmodex.examples.utils.FmodExExampleFrame;
import org.jouvieje.fmodex.exceptions.InitException;
import org.jouvieje.fmodex.utils.Pointer;
import org.jouvieje.fmodex.structures.FMOD_TAG;

/**
 * Based on FMOD Ex C++ example. Ported to Java with NativeFmodEx by Jérôme JOUVIE (Jouvieje.
 * 
 * @author Jérôme JOUVIE (Jouvieje)
 * @site   http://jerome.jouvie.free.fr/
 * @mail   jerome.jouvie@gmail.com
 */
public class RipNetStream extends ConsoleGUI {
	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args) {
		new FmodExExampleFrame(new RipNetStream());
	}

	private boolean init = false;
	private boolean deinit = false;

	private System system = new System();
	private Sound sound = new Sound();

	private FMOD_SOUND_TYPE gSoundType/*          = FMOD_SOUND_TYPE_MPEG*/;
	private int gFileBufferSize = 128 * 1024;
	private String gCurrentTrackArtist = "";
	private String gCurrentTrackTitle = "";
	private boolean gUpdateFileName = false;
	private String gOutputFileName = "output.mp3"; /* Start off like this then rename if a title tag comes along */
	private RandomAccessFile gFileHandle = null;

	public RipNetStream() {
		super();
		initialize();
	}

	public JPanel getPanel() {
		return this;
	}

	public String getTitle() {
		return "FMOD Ex RipNetStream example.";
	}

	private void errorCheck(FMOD_RESULT result) {
		if(result != FMOD_RESULT.FMOD_OK) {
			printfExit("FMOD error! (%d) %s\n", result.asInt(), FmodEx.FMOD_ErrorString(result));
		}
	}

	/*
	 * File callbacks
	 */
	private FMOD_FILE_OPENCALLBACK myopen = new FMOD_FILE_OPENCALLBACK(){
		public FMOD_RESULT FMOD_FILE_OPENCALLBACK(String name, int unicode, IntBuffer filesize, Pointer handle,
				Pointer userdata) {
			try {
				gFileHandle = new RandomAccessFile(gOutputFileName, "rw");
			}
			catch(FileNotFoundException e) {
				return FMOD_ERR_FILE_NOTFOUND;
			}
			return FMOD_OK;
		}
	};

	private FMOD_FILE_CLOSECALLBACK myclose = new FMOD_FILE_CLOSECALLBACK(){
		public FMOD_RESULT FMOD_FILE_CLOSECALLBACK(Pointer handle, Pointer userdata) {
			if(gFileHandle == null) {
				return FMOD_ERR_INVALID_PARAM;
			}

			try {
				gFileHandle.close();
			}
			catch(IOException e) {
				return FMOD_ERR_INVALID_PARAM;
			}

			return FMOD_OK;
		}
	};

	private FMOD_FILE_READCALLBACK myread = new FMOD_FILE_READCALLBACK(){
		public FMOD_RESULT FMOD_FILE_READCALLBACK(Pointer handle, ByteBuffer buffer, int sizebytes,
				IntBuffer bytesread, Pointer userdata) {
			if(gFileHandle == null) {
				return FMOD_ERR_INVALID_PARAM;
			}

			/*
			 * If the main thread detected a new tag name for artist / title, close the file and open a new one with the new name.
			 */
			if(gUpdateFileName) {
				gUpdateFileName = false;

				try {
					gFileHandle.close();
				}
				catch(IOException e2) {
					return FMOD_ERR_INVALID_PARAM;
				}

				String ext;
				if(gSoundType == FMOD_SOUND_TYPE_MPEG) /* MP2/MP3 */
				ext = ".mp3";
				else if(gSoundType == FMOD_SOUND_TYPE_OGGVORBIS) /* Ogg vorbis */
				ext = ".ogg";
				else ext = ".unknown";

				try {
					/*
					 * If it is the 'temp file name' then rename the file and append to it instead of starting a new file
					 */
					if(gOutputFileName.equals("output.mp3")) {
						gOutputFileName = gCurrentTrackArtist + (gCurrentTrackTitle.length() != 0 ? " - " : "")
								+ gCurrentTrackTitle + ext;
						new File("output.mp3").renameTo(new File(gOutputFileName));
						gFileHandle = new RandomAccessFile(gOutputFileName, "rw");
					}
					else {
						gOutputFileName = gCurrentTrackArtist + (gCurrentTrackTitle.length() != 0 ? " - " : "")
								+ gCurrentTrackTitle + ext;
						gFileHandle = new RandomAccessFile(gOutputFileName, "rw");
					}
				}
				catch(FileNotFoundException e1) {
					return FMOD_ERR_FILE_NOTFOUND;
				}
			}

			try {
				gFileHandle.getChannel().write(buffer);
			}
			catch(IOException e) {
				return FMOD_ERR_INVALID_PARAM;
			}

			return FMOD_OK;
		}
	};

	public void init() {
		/*
		 * NativeFmodEx Init
		 */
		try {
			Init.loadLibraries();
		}
		catch(InitException e) {
			printfExit("NativeFmodEx error! %s\n", e.getMessage());
			return;
		}

		/*
		 * Checking NativeFmodEx version
		 */
		if(NATIVEFMODEX_LIBRARY_VERSION != NATIVEFMODEX_JAR_VERSION) {
			printfExit("Error!  NativeFmodEx library version (%08x) is different to jar version (%08x)\n",
					NATIVEFMODEX_LIBRARY_VERSION, NATIVEFMODEX_JAR_VERSION);
			return;
		}

		/*==================================================*/

		init = true;
	}

	public void run() {
		if(!init) return;

		Channel channel = new Channel();
		FMOD_RESULT result;
		int version;

		ByteBuffer buffer = newByteBuffer(SIZEOF_INT);

		printf("======================================================================\n");
		printf("RipNetStream Example.  Copyright (c) Firelight Technologies 2004-2009.\n");
		printf("======================================================================\n\n");
		printf("Usage:   ripnetstream <url>\n");
		printf("Example: ripnetstream http://www.fmod.org/stream.mp3\n");
		printf("Example: ripnetstream http://jerome.jouvie.free.fr/downloads/NativeFmodEx/jules.mp3\n\n");
		resetInput();
		setInput("http://www.fmod.org/stream.mp3");
		while(!keyHit()) {
			Thread.yield();
		}
		String url = getInput().trim();

		gSoundType = FMOD_SOUND_TYPE_MPEG;

		/*
		 * Create a System object and initialize.
		 */
		result = FmodEx.System_Create(system);
		errorCheck(result);

		result = system.getVersion(buffer.asIntBuffer());
		version = buffer.getInt(0);
		errorCheck(result);

		if(version < FMOD_VERSION) {
			printfExit("Error!  You are using an old version of FMOD %08x.  This program requires %08x\n", version,
					FMOD_VERSION);
			return;
		}

		result = system.init(100, FMOD_INIT_NORMAL, null);
		errorCheck(result);

		result = system.setStreamBufferSize(gFileBufferSize, FMOD_TIMEUNIT_RAWBYTES);
		errorCheck(result);

		result = system.attachFileSystem(myopen, myclose, myread, null);
		errorCheck(result);

		printf("Buffering...\n\n");

		result = system.createStream(url, FMOD_HARDWARE | FMOD_2D | FMOD_NONBLOCKING, null, sound);
		errorCheck(result);

		/*
		 * Main loop
		 */
		boolean exit = false;
		do {
			if(!sound.isNull() && channel.isNull()) {
				result = system.playSound(FMOD_CHANNEL_FREE, sound, false, channel);
			}

			switch(getKey()) {
				case ' ': {
					if(!channel.isNull()) {
						channel.getPaused(buffer);
						boolean paused = buffer.get(0) != 0;
						channel.setPaused(!paused);
					}
					break;
				}
				case 'm':
				case 'M': {
					if(!channel.isNull()) {
						channel.getMute(buffer);
						boolean mute = buffer.get(0) != 0;
						channel.setMute(!mute);
					}
					break;
				}
				case 'e':
				case 'E':
					exit = true;
					break;
			}

			system.update();

			if(!channel.isNull()) {
				int ms = 0;
				boolean playing = false;
				boolean paused = false;
				int tagsupdated = 0;

				sound.getNumTags(null, buffer.asIntBuffer());
				tagsupdated = buffer.getInt(0);

				if(tagsupdated != 0) {
					printf("\n");
					printf("\n");
					for(;;) {
						FMOD_TAG tag = new FMOD_TAG();

						if(sound.getTag(null, -1, tag) != FMOD_OK) {
							break;
						}

						if(tag.getDataType() == FMOD_TAGDATATYPE_STRING) {
							String tagData = tag.getData().asString();
							String tagName = tag.getName(); //Call getName one time for speed
							printf("[%-11s] %s (%d bytes)\n", tagName, tagData, tag.getDataLen());

							FMOD_SOUND_TYPE[] openstatearray = new FMOD_SOUND_TYPE[1];
							sound.getFormat(openstatearray, null, null, null);
							gSoundType = openstatearray[0];

							if(tagName.equals("ARTIST")) {
								if(!gCurrentTrackArtist.equals(tagData)) {
									gCurrentTrackArtist = tagData;
									gUpdateFileName = true;
								}
							}
							else if(tagName.equals("TITLE")) {
								if(!gCurrentTrackTitle.equals(tagData)) {
									gCurrentTrackTitle = tagData;
									gUpdateFileName = true;
								}
							}
						}
					}
					printf("\n");
				}

				result = channel.isPlaying(buffer);
				playing = buffer.get(0) != 0;
				if(result != FMOD_OK || !playing) {
					sound.release();
					sound = new Sound();
					channel = new Channel();
				}
				else {
					result = channel.getPaused(buffer);
					paused = buffer.get(0) != 0;
					result = channel.getPosition(buffer.asIntBuffer(), FMOD_TIMEUNIT_MS);
					ms = buffer.getInt(0);
					printfr("Time %02d:%02d:%02d : %s : Press SPACE to pause. 'm' to mute. 'E' to quit.",
							ms / 1000 / 60, ms / 1000 % 60, ms / 10 % 100, paused ? "Paused " : playing ? "Playing"
									: "Stopped");
				}
			}

			if(!sound.isNull()) {
				FMOD_OPENSTATE openstate = FMOD_OPENSTATE_READY;

				FMOD_OPENSTATE[] openstatearray = new FMOD_OPENSTATE[1];
				sound.getOpenState(openstatearray, null, null);
				openstate = openstatearray[0];

				if(openstate == FMOD_OPENSTATE_ERROR) {
					sound.release();
					sound = new Sound();
					channel = new Channel();
				}
			}

			if(sound.isNull()) {
				printf("\n");
				printf("Error occurred or stream ended.  Restarting stream..\n");

				result = system.createStream(url, FMOD_HARDWARE | FMOD_2D | FMOD_NONBLOCKING, null, sound);
				errorCheck(result);

				try {
					Thread.sleep(1000);
				}
				catch(InterruptedException e1) {}
			}

			try {
				Thread.sleep(10);
			}
			catch(InterruptedException e1) {}
		}
		while(!exit && !deinit);

		stop();
	}

	public boolean isRunning() { return deinit; }
	public void stop() {
		if(!init || deinit) return;
		deinit = true;

		print("\n");

		/*
		 * Shut down
		 */
		FMOD_RESULT result;
		if(!sound.isNull()) {
			result = sound.release();
			errorCheck(result);
		}
		if(!system.isNull()) {
			result = system.close();
			errorCheck(result);
			result = system.release();
			errorCheck(result);
		}

		printExit("Shutdown\n");
	}
}