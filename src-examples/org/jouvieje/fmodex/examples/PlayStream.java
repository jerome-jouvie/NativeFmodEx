/*===============================================================================================
PlayStream Example
Copyright (c), Firelight Technologies Pty, Ltd 2004-2010.

This example shows how to simply play a stream, such as an mp3 or wav.
The stream behaviour is achieved by specifying FMOD_CREATESTREAM in the call to 
System::createSound.
This makes FMOD decode the file in realtime as it plays, instead of loading it all at once.
This uses far less memory, in exchange for a small runtime cpu hit.
===============================================================================================*/

package org.jouvieje.fmodex.examples;

import static org.jouvieje.fmodex.defines.FMOD_INITFLAGS.FMOD_INIT_NORMAL;
import static org.jouvieje.fmodex.defines.FMOD_MODE.FMOD_2D;
import static org.jouvieje.fmodex.defines.FMOD_MODE.FMOD_HARDWARE;
import static org.jouvieje.fmodex.defines.FMOD_MODE.FMOD_LOOP_NORMAL;
import static org.jouvieje.fmodex.defines.FMOD_MODE.FMOD_OPENMEMORY;
import static org.jouvieje.fmodex.defines.FMOD_TIMEUNIT.FMOD_TIMEUNIT_MS;
import static org.jouvieje.fmodex.defines.VERSIONS.FMOD_VERSION;
import static org.jouvieje.fmodex.defines.VERSIONS.NATIVEFMODEX_JAR_VERSION;
import static org.jouvieje.fmodex.defines.VERSIONS.NATIVEFMODEX_LIBRARY_VERSION;
import static org.jouvieje.fmodex.enumerations.FMOD_CHANNELINDEX.FMOD_CHANNEL_FREE;
import static org.jouvieje.fmodex.enumerations.FMOD_RESULT.FMOD_ERR_INVALID_HANDLE;
import static org.jouvieje.fmodex.enumerations.FMOD_RESULT.FMOD_OK;
import static org.jouvieje.fmodex.utils.BufferUtils.newByteBuffer;
import static org.jouvieje.fmodex.utils.BufferUtils.SIZEOF_INT;

import java.nio.ByteBuffer;

import javax.swing.JPanel;

import org.jouvieje.fmodex.Channel;
import org.jouvieje.fmodex.ChannelGroup;
import org.jouvieje.fmodex.FmodEx;
import org.jouvieje.fmodex.Init;
import org.jouvieje.fmodex.Sound;
import org.jouvieje.fmodex.System;

import org.jouvieje.fmodex.enumerations.FMOD_RESULT;
import org.jouvieje.fmodex.examples.utils.ConsoleGUI;
import org.jouvieje.fmodex.examples.utils.FmodExExampleFrame;
import org.jouvieje.fmodex.examples.utils.Medias;
import org.jouvieje.fmodex.exceptions.InitException;
import org.jouvieje.fmodex.structures.FMOD_CREATESOUNDEXINFO;

/**
 * Based on FMOD Ex C++ example. Ported to Java with NativeFmodEx by Jérôme JOUVIE (Jouvieje.
 * 
 * @author Jérôme JOUVIE (Jouvieje)
 * @site   http://jerome.jouvie.free.fr/
 * @mail   jerome.jouvie@gmail.com
 */
public class PlayStream extends ConsoleGUI {
	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args) throws Exception {
		new FmodExExampleFrame(new PlayStream());
	}

	private boolean init = false;
	private boolean deinit = false;

	private System system = new System();
	private Sound sound = new Sound();
	private ByteBuffer soundBuffer = null;

	public PlayStream() {
		super();
		initialize();
	}

	public JPanel getPanel() {
		return this;
	}

	public String getTitle() {
		return "FMOD Ex PlayStream example.";
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

		FMOD_CREATESOUNDEXINFO exinfo;
		Channel channel = new Channel();
		FMOD_RESULT result;
		int version;

		/*
		 * Buffer used to store all datas received from FMOD.
		 */
		ByteBuffer buffer = newByteBuffer(SIZEOF_INT);

		/*
		 * Create a System object and initialize.
		 */
		errorCheck(FmodEx.System_Create(system));

		errorCheck(system.getVersion(buffer.asIntBuffer()));
		version = buffer.getInt(0);

		if(version < FMOD_VERSION) {
			printfExit("Error!  You are using an old version of FMOD %08x.  This program requires %08x\n", version,
					FMOD_VERSION);
			return;
		}

		result = system.init(1, FMOD_INIT_NORMAL, null);
		errorCheck(result);

		soundBuffer = Medias.loadMediaIntoMemory("/Media/wave.mp3");
		exinfo = FMOD_CREATESOUNDEXINFO.allocate();
		exinfo.setLength(soundBuffer.capacity());
		result = system.createStream(soundBuffer, FMOD_HARDWARE | FMOD_LOOP_NORMAL | FMOD_2D | FMOD_OPENMEMORY, exinfo, sound);
		errorCheck(result);
		exinfo.release();
		//soundBuffer must remain valid during playback (because of createStream),
		//use createSound if you don't want this behavior.

		printf("====================================================================\n");
		printf("PlayStream Example.  Copyright (c) Firelight Technologies 2004-2009.\n");
		printf("====================================================================\n");
		printf("\n");
		printf("Press SPACE to pause, E to quit\n");
		printf("\n");

		/*
		 * Play the sound.
		 */
		result = system.playSound(FMOD_CHANNEL_FREE, sound, false, channel);
		errorCheck(result);

		/*
		 * Main loop.
		 */
		boolean exit = false;
		do {
			{
				boolean paused;
				switch(getKey()) {
					case ' ':
						channel.getPaused(buffer);
						paused = buffer.get(0) != 0;
						channel.setPaused(!paused);
						break;
					case 'p':
					case 'P':
						ChannelGroup masterGroup = new ChannelGroup();
						system.getMasterChannelGroup(masterGroup);
						if(!masterGroup.isNull()) {
							masterGroup.getPaused(buffer);
							paused = buffer.get(0) != 0;
							masterGroup.setPaused(!paused);
						}
						break;
					case 'e':
					case 'E':
						exit = true;
						break;
				}
			}

			system.update();

			if(!channel.isNull()) {
				int ms = 0, lenMs = 0;
				boolean playing = false;
				boolean paused = false;

				result = channel.isPlaying(buffer);
				if((result != FMOD_OK) && (result != FMOD_ERR_INVALID_HANDLE)) errorCheck(result);
				playing = buffer.get(0) != 0;

				result = channel.getPaused(buffer);
				if((result != FMOD_OK) && (result != FMOD_ERR_INVALID_HANDLE)) errorCheck(result);
				paused = buffer.get(0) != 0;

				result = channel.getPosition(buffer.asIntBuffer(), FMOD_TIMEUNIT_MS);
				if((result != FMOD_OK) && (result != FMOD_ERR_INVALID_HANDLE)) errorCheck(result);
				ms = buffer.getInt(0);

				result = sound.getLength(buffer.asIntBuffer(), FMOD_TIMEUNIT_MS);
				if((result != FMOD_OK) && (result != FMOD_ERR_INVALID_HANDLE)) errorCheck(result);
				lenMs = buffer.getInt(0);

				printfr("Time %02d:%02d:%02d/%02d:%02d:%02d : %s", ms / 1000 / 60, ms / 1000 % 60, ms / 10 % 100,
						lenMs / 1000 / 60, lenMs / 1000 % 60, lenMs / 10 % 100, paused ? "Paused "
								: playing ? "Playing" : "Stopped");
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
		if(!system.isNull()) {
			result = system.close();
			errorCheck(result);
			result = system.release();
			errorCheck(result);
		}

		printExit("Shutdown\n");
	}
}