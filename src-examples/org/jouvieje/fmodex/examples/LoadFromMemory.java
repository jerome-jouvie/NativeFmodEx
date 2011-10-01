/*===============================================================================================
 Load from memory example
 Copyright (c), Firelight Technologies Pty, Ltd 2004-2010.

 This example is simply a variant of the play sound example, but it loads the data into memory
 then uses the 'load from memory' feature of System::createSound.
===============================================================================================*/

package org.jouvieje.fmodex.examples;

import static org.jouvieje.fmodex.defines.FMOD_INITFLAGS.FMOD_INIT_NORMAL;
import static org.jouvieje.fmodex.defines.FMOD_MODE.FMOD_HARDWARE;
import static org.jouvieje.fmodex.defines.FMOD_MODE.FMOD_LOOP_OFF;
import static org.jouvieje.fmodex.defines.FMOD_MODE.FMOD_OPENMEMORY;
import static org.jouvieje.fmodex.defines.FMOD_MODE.FMOD_SOFTWARE;
import static org.jouvieje.fmodex.defines.FMOD_TIMEUNIT.FMOD_TIMEUNIT_MS;
import static org.jouvieje.fmodex.defines.VERSIONS.FMOD_VERSION;
import static org.jouvieje.fmodex.defines.VERSIONS.NATIVEFMODEX_JAR_VERSION;
import static org.jouvieje.fmodex.defines.VERSIONS.NATIVEFMODEX_LIBRARY_VERSION;
import static org.jouvieje.fmodex.enumerations.FMOD_CHANNELINDEX.FMOD_CHANNEL_FREE;
import static org.jouvieje.fmodex.enumerations.FMOD_RESULT.FMOD_ERR_CHANNEL_STOLEN;
import static org.jouvieje.fmodex.enumerations.FMOD_RESULT.FMOD_ERR_INVALID_HANDLE;
import static org.jouvieje.fmodex.enumerations.FMOD_RESULT.FMOD_OK;
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
import org.jouvieje.fmodex.examples.utils.ConsoleGUI;
import org.jouvieje.fmodex.examples.utils.FmodExExampleFrame;
import org.jouvieje.fmodex.examples.utils.Medias;
import org.jouvieje.fmodex.exceptions.InitException;
import org.jouvieje.fmodex.structures.FMOD_CREATESOUNDEXINFO;

/**
 * Based on FMOD Ex C++ example. Ported to Java with NativeFmodEx by J�r�me JOUVIE (Jouvieje.
 * 
 * @author J�r�me JOUVIE (Jouvieje)
 * @site   http://jerome.jouvie.free.fr/
 * @mail   jerome.jouvie@gmail.com
 */
public class LoadFromMemory extends ConsoleGUI {
	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args) {
		new FmodExExampleFrame(new LoadFromMemory());
	}

	private boolean init = false;
	private boolean deinit = false;

	System system = new System();
	Sound sound1 = new Sound();
	Sound sound2 = new Sound();
	Sound sound3 = new Sound();

	public LoadFromMemory() {
		super();
		initialize();
	}

	public JPanel getPanel() {
		return this;
	}

	public String getTitle() {
		return "FMOD Ex LoadFromMemory example.";
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

		Channel channel = new Channel();
		FMOD_RESULT result;
		int version;
		FMOD_CREATESOUNDEXINFO exinfo;

		ByteBuffer buffer = newByteBuffer(SIZEOF_INT);

		/*
		 * Create a System object and initialize.
		 */
		result = FmodEx.System_Create(system);
		errorCheck(result);

		result = system.getVersion(buffer.asIntBuffer());
		errorCheck(result);
		version = buffer.getInt(0);

		if(version < FMOD_VERSION) {
			printfExit("Error!  You are using an old version of FMOD %08x.  This program requires %08x\n", version,
					FMOD_VERSION);
			return;
		}

		result = system.init(32, FMOD_INIT_NORMAL, null);
		errorCheck(result);

		ByteBuffer buff = Medias.loadMediaIntoMemory("/Media/drumloop.wav");
		exinfo = FMOD_CREATESOUNDEXINFO.allocate();
		exinfo.setLength(buff.capacity());

		result = system.createSound(buff, FMOD_HARDWARE | FMOD_OPENMEMORY, exinfo, sound1);
		errorCheck(result);
		result = sound1.setMode(FMOD_LOOP_OFF);
		errorCheck(result);
		buff = null; //don't need the original memory any more.  Note!  If loading as a stream, the memory must remain valid during playback!
		exinfo.release();

		buff = Medias.loadMediaIntoMemory("/Media/jaguar.wav");
		exinfo = FMOD_CREATESOUNDEXINFO.allocate();
		exinfo.setLength(buff.capacity());
		result = system.createSound(buff, FMOD_SOFTWARE | FMOD_OPENMEMORY, exinfo, sound2);
		errorCheck(result);
		buff = null; //don't need the original memory any more.  Note!  If loading as a stream, the memory must remain valid during playback!
		exinfo.release();

		buff = Medias.loadMediaIntoMemory("/Media/swish.wav");
		exinfo = FMOD_CREATESOUNDEXINFO.allocate();
		exinfo.setLength(buff.capacity());
		result = system.createSound(buff, FMOD_HARDWARE | FMOD_OPENMEMORY, exinfo, sound3);
		errorCheck(result);
		buff = null; //don't need the original memory any more.  Note!  If loading as a stream, the memory must remain valid during playback!
		exinfo.release();

		printf("==========================================================================\n");
		printf("Load from memory example.  Copyright (c) Firelight Technologies 2004-2009.\n");
		printf("==========================================================================\n");
		printf("\n");
		printf("Press '1' to play a mono sound using hardware mixing\n");
		printf("Press '2' to play a mono sound using software mixing\n");
		printf("Press '3' to play a stereo sound using hardware mixing\n");
		printf("Press 'E' to quit\n");
		printf("\n");

		/*
		 * Main loop.
		 */
		boolean exit = false;
		do {
			switch(getKey()) {
				case '1': {
					result = system.playSound(FMOD_CHANNEL_FREE, sound1, false, channel);
					errorCheck(result);
					break;
				}
				case '2': {
					result = system.playSound(FMOD_CHANNEL_FREE, sound2, false, channel);
					errorCheck(result);
					break;
				}
				case '3': {
					result = system.playSound(FMOD_CHANNEL_FREE, sound3, false, channel);
					errorCheck(result);
					break;
				}
				case 'e':
				case 'E':
					exit = true;
					break;
			}

			system.update();

			{
				int ms = 0;
				int lenms = 0;
				boolean playing = false;
				boolean paused = false;
				int channelsplaying = 0;

				if(!channel.isNull()) {
					Sound currentsound = new Sound();

					result = channel.isPlaying(buffer);
					if((result != FMOD_OK) && (result != FMOD_ERR_INVALID_HANDLE)
							&& (result != FMOD_ERR_CHANNEL_STOLEN)) {
						errorCheck(result);
					}
					playing = buffer.get(0) != 0;

					result = channel.getPaused(buffer);
					if((result != FMOD_OK) && (result != FMOD_ERR_INVALID_HANDLE)
							&& (result != FMOD_ERR_CHANNEL_STOLEN)) {
						errorCheck(result);
					}
					paused = buffer.get(0) != 0;

					result = channel.getPosition(buffer.asIntBuffer(), FMOD_TIMEUNIT_MS);
					if((result != FMOD_OK) && (result != FMOD_ERR_INVALID_HANDLE)
							&& (result != FMOD_ERR_CHANNEL_STOLEN)) {
						errorCheck(result);
					}
					ms = buffer.getInt(0);

					channel.getCurrentSound(currentsound);
					if(!currentsound.isNull()) {
						result = currentsound.getLength(buffer.asIntBuffer(), FMOD_TIMEUNIT_MS);
						if((result != FMOD_OK) && (result != FMOD_ERR_INVALID_HANDLE)
								&& (result != FMOD_ERR_CHANNEL_STOLEN)) {
							errorCheck(result);
						}
						lenms = buffer.getInt(0);
					}
				}

				system.getChannelsPlaying(buffer.asIntBuffer());
				channelsplaying = buffer.getInt(0);

				printfr("Time %02d:%02d:%02d/%02d:%02d:%02d : %s : Channels Playing %2d", ms / 1000 / 60,
						ms / 1000 % 60, ms / 10 % 100, lenms / 1000 / 60, lenms / 1000 % 60, lenms / 10 % 100,
						paused ? "Paused " : playing ? "Playing" : "Stopped", channelsplaying);
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
		if(!sound1.isNull()) {
			result = sound1.release();
			errorCheck(result);
		}
		if(!sound2.isNull()) {
			result = sound2.release();
			errorCheck(result);
		}
		if(!sound3.isNull()) {
			result = sound3.release();
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