/*===============================================================================================
PlayList Example
Copyright (c), Firelight Technologies Pty, Ltd 2004-2010.

This example shows how to load a playlist and play the sounds in a playlist.
===============================================================================================*/

package org.jouvieje.fmodex.examples;

import static org.jouvieje.fmodex.defines.FMOD_INITFLAGS.FMOD_INIT_NORMAL;
import static org.jouvieje.fmodex.defines.FMOD_MODE.FMOD_DEFAULT;
import static org.jouvieje.fmodex.defines.FMOD_MODE.FMOD_LOOP_NORMAL;
import static org.jouvieje.fmodex.defines.FMOD_MODE.FMOD_OPENMEMORY;
import static org.jouvieje.fmodex.defines.FMOD_TIMEUNIT.FMOD_TIMEUNIT_MS;
import static org.jouvieje.fmodex.defines.VERSIONS.FMOD_VERSION;
import static org.jouvieje.fmodex.defines.VERSIONS.NATIVEFMODEX_JAR_VERSION;
import static org.jouvieje.fmodex.defines.VERSIONS.NATIVEFMODEX_LIBRARY_VERSION;
import static org.jouvieje.fmodex.enumerations.FMOD_CHANNELINDEX.FMOD_CHANNEL_FREE;
import static org.jouvieje.fmodex.enumerations.FMOD_RESULT.FMOD_ERR_CHANNEL_STOLEN;
import static org.jouvieje.fmodex.enumerations.FMOD_RESULT.FMOD_ERR_INVALID_HANDLE;
import static org.jouvieje.fmodex.enumerations.FMOD_RESULT.FMOD_OK;
import static org.jouvieje.fmodex.enumerations.FMOD_SOUND_TYPE.FMOD_SOUND_TYPE_PLAYLIST;
import static org.jouvieje.fmodex.utils.BufferUtils.newByteBuffer;
import static org.jouvieje.fmodex.utils.BufferUtils.SIZEOF_INT;

import java.nio.ByteBuffer;

import javax.swing.JPanel;

import org.jouvieje.fmodex.Channel;
import org.jouvieje.fmodex.FmodEx;
import org.jouvieje.fmodex.Init;
import org.jouvieje.fmodex.Sound;
import org.jouvieje.fmodex.System;

import org.jouvieje.fmodex.enumerations.FMOD_RESULT;
import org.jouvieje.fmodex.enumerations.FMOD_SOUND_TYPE;
import org.jouvieje.fmodex.examples.utils.ConsoleGUI;
import org.jouvieje.fmodex.examples.utils.FmodExExampleFrame;
import org.jouvieje.fmodex.examples.utils.Medias;
import org.jouvieje.fmodex.exceptions.InitException;
import org.jouvieje.fmodex.structures.FMOD_CREATESOUNDEXINFO;
import org.jouvieje.fmodex.structures.FMOD_TAG;

/**
 * Based on FMOD Ex C++ example. Ported to Java with NativeFmodEx by J�r�me JOUVIE (Jouvieje.
 * 
 * @author J�r�me JOUVIE (Jouvieje)
 * @site   http://jerome.jouvie.free.fr/
 * @mail   jerome.jouvie@gmail.com
 */
public class PlayList extends ConsoleGUI {
	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args) {
		new FmodExExampleFrame(new PlayList());
	}

	private boolean init = false;
	private boolean deinit = false;

	private System system = new System();
	private Sound playlist = new Sound();
	private Sound sound = new Sound();
	private boolean isplaylist = false;

	public PlayList() {
		super();
		initialize();
	}

	public JPanel getPanel() {
		return this;
	}

	public String getTitle() {
		return "FMOD Ex PlayList example.";
	}

	private void errorCheck(FMOD_RESULT result) {
		if(result != FMOD_RESULT.FMOD_OK) {
			printfExit("FMOD error! (%d) %s\n", result.asInt(), FmodEx.FMOD_ErrorString(result));
		}
	}

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

		ByteBuffer soundBuffer;
		FMOD_CREATESOUNDEXINFO exinfo;
		Channel channel = new Channel();
		FMOD_RESULT result;
		FMOD_TAG tag = FMOD_TAG.allocate();
		FMOD_SOUND_TYPE[] soundtype = new FMOD_SOUND_TYPE[1];
		String title = "";
		int version;
		int count = 0;

		ByteBuffer buffer = newByteBuffer(SIZEOF_INT);

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

		result = system.init(32, FMOD_INIT_NORMAL, null);
		errorCheck(result);

		soundBuffer = Medias.loadMediaIntoMemory("/Media/playlist.m3u");
		exinfo = FMOD_CREATESOUNDEXINFO.allocate();
		exinfo.setLength(soundBuffer.capacity());
		result = system.createSound(soundBuffer, FMOD_DEFAULT | FMOD_OPENMEMORY, exinfo, playlist);
		errorCheck(result);
		soundBuffer = null;
		exinfo.release();

		result = playlist.getFormat(soundtype, null, null, null);
		errorCheck(result);

		isplaylist = (soundtype[0] == FMOD_SOUND_TYPE_PLAYLIST);

		printf("===================================================================\n");
		printf("PlayList Example.  Copyright (c) Firelight Technologies 2004-2009.\n");
		printf("===================================================================\n");
		printf("\n");
		printf("Press 'n'     to play next sound in playlist\n");
		printf("Press 'space' to pause/unpause current sound\n");
		printf("Press 'e'   to quit\n");
		printf("Press Enter to validate your choice\n");
		printf("\n");

		if(isplaylist) {
			printf("PLAYLIST loaded.\n");
			/*
			 * Get the first song in the playlist, create the sound and then play it.
			 */
			result = playlist.getTag("FILE", count, tag);
			errorCheck(result);

			/*
			 * Jouvieje note:
			 *  In case of a relative path, we must specify the parent directory of the file
			 *  ie the folder in which the playlist file is.
			 */
			soundBuffer = Medias.loadMediaIntoMemory("/Media/" + tag.getData().asString());
			exinfo = FMOD_CREATESOUNDEXINFO.allocate();
			exinfo.setLength(soundBuffer.capacity());
			result = system.createSound(soundBuffer, FMOD_DEFAULT | FMOD_OPENMEMORY, exinfo, sound);
			errorCheck(result);
			soundBuffer = null;
			exinfo.release();

			result = system.playSound(FMOD_CHANNEL_FREE, sound, false, channel);
			errorCheck(result);

			playlist.getTag("TITLE", count, tag);
			title = tag.getData().asString();

			count++;
		}
		else {
			printf("SOUND loaded.\n");

			/*
			 * This is just a normal sound, so just play it.
			 */
			sound = playlist;

			result = sound.setMode(FMOD_LOOP_NORMAL);
			errorCheck(result);

			result = system.playSound(FMOD_CHANNEL_FREE, sound, false, channel);
			errorCheck(result);
		}

		printf("\n");

		/*
		 *  Main loop.
		 */
		boolean exit = false;
		do {
			boolean isplaying = false;

			if(!channel.isNull() && isplaylist) {
				/*
				 * When sound has finished playing, play the next sound in the playlist
				 */

				channel.isPlaying(buffer);
				isplaying = buffer.get(0) != 0;
				if(!isplaying) {
					if(!sound.isNull()) {
						sound.release();
						sound = new Sound();
					}

					result = playlist.getTag("FILE", count, tag);
					if(result != FMOD_OK) {
						count = 0;
					}
					else {
						printr("playing next song in playlist...\n");

						/*
						 * Jouvieje note:
						 *  Same remark than above.
						 */
						soundBuffer = Medias.loadMediaIntoMemory("/Media/" + tag.getData().asString());
						exinfo = FMOD_CREATESOUNDEXINFO.allocate();
						exinfo.setLength(soundBuffer.capacity());
						result = system.createSound(soundBuffer, FMOD_DEFAULT | FMOD_OPENMEMORY, exinfo, sound);
						errorCheck(result);
						soundBuffer = null;
						exinfo.release();

						result = system.playSound(FMOD_CHANNEL_FREE, sound, false, channel);
						errorCheck(result);

						playlist.getTag("TITLE", count, tag);
						title = tag.getData().asString();

						count++;
					}
				}
			}

			switch(getKey()) {
				case 'n':
					/*
					 * Play the next song in the playlist
					 */
					if(!channel.isNull() && isplaylist) {
						channel.stop();
					}
					break;
				case ' ':
					if(!channel.isNull()) {
						channel.getPaused(buffer);
						boolean paused = buffer.get(0) != 0;
						channel.setPaused(!paused);
					}
					break;
				case 'e':
				case 'E':
					exit = true;
					break;
			}

			system.update();

			{
				int ms = 0;
				int lenms = 0;
				boolean paused = false;

				if(!channel.isNull()) {
					if(!sound.isNull()) {
						result = sound.getLength(buffer.asIntBuffer(), FMOD_TIMEUNIT_MS);
						lenms = buffer.getInt(0);
						if((result != FMOD_OK) && (result != FMOD_ERR_INVALID_HANDLE)
								&& (result != FMOD_ERR_CHANNEL_STOLEN)) {
							errorCheck(result);
						}
					}

					result = channel.getPaused(buffer);
					paused = buffer.get(0) != 0;
					if((result != FMOD_OK) && (result != FMOD_ERR_INVALID_HANDLE)
							&& (result != FMOD_ERR_CHANNEL_STOLEN)) {
						errorCheck(result);
					}

					result = channel.getPosition(buffer.asIntBuffer(), FMOD_TIMEUNIT_MS);
					ms = buffer.getInt(0);
					if((result != FMOD_OK) && (result != FMOD_ERR_INVALID_HANDLE)
							&& (result != FMOD_ERR_CHANNEL_STOLEN)) {
						errorCheck(result);
					}
				}

				printfr("Time %02d:%02d:%02d/%02d:%02d:%02d : %s : %s", ms / 1000 / 60, ms / 1000 % 60, ms / 10 % 100,
						lenms / 1000 / 60, lenms / 1000 % 60, lenms / 10 % 100, paused ? "Paused " : "Playing ", title);
			}

			try {
				Thread.sleep(10);
			}
			catch(InterruptedException e) {}
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
		if(isplaylist) {
			if(!playlist.isNull()) {
				result = playlist.release();
				errorCheck(result);
			}
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