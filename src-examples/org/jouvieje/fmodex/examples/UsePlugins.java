/*===============================================================================================
Use Plugins Example
Copyright (c), Firelight Technologies Pty, Ltd 2004-2010.

This example shows how to use FMODEXP.DLL and its associated plugins.
The example lists the available plugins, and loads a new plugin that isnt normally included
with FMOD Ex, which is output_mp3.dll.  When this is loaded, it can be chosen as an output
mode, for realtime encoding of audio output into the mp3 format.
===============================================================================================*/

package org.jouvieje.fmodex.examples;

import static org.jouvieje.fmodex.defines.FMOD_INITFLAGS.FMOD_INIT_NORMAL;
import static org.jouvieje.fmodex.defines.FMOD_MODE.FMOD_OPENMEMORY;
import static org.jouvieje.fmodex.defines.FMOD_MODE.FMOD_SOFTWARE;
import static org.jouvieje.fmodex.defines.FMOD_TIMEUNIT.FMOD_TIMEUNIT_MS;
import static org.jouvieje.fmodex.defines.VERSIONS.FMOD_VERSION;
import static org.jouvieje.fmodex.defines.VERSIONS.NATIVEFMODEX_JAR_VERSION;
import static org.jouvieje.fmodex.defines.VERSIONS.NATIVEFMODEX_LIBRARY_VERSION;
import static org.jouvieje.fmodex.enumerations.FMOD_CHANNELINDEX.FMOD_CHANNEL_FREE;
import static org.jouvieje.fmodex.enumerations.FMOD_PLUGINTYPE.FMOD_PLUGINTYPE_CODEC;
import static org.jouvieje.fmodex.enumerations.FMOD_PLUGINTYPE.FMOD_PLUGINTYPE_DSP;
import static org.jouvieje.fmodex.enumerations.FMOD_PLUGINTYPE.FMOD_PLUGINTYPE_OUTPUT;
import static org.jouvieje.fmodex.enumerations.FMOD_RESULT.FMOD_ERR_CHANNEL_STOLEN;
import static org.jouvieje.fmodex.enumerations.FMOD_RESULT.FMOD_ERR_INVALID_HANDLE;
import static org.jouvieje.fmodex.enumerations.FMOD_RESULT.FMOD_OK;

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
import org.jouvieje.fmodex.utils.BufferUtils;
import org.jouvieje.fmodex.structures.FMOD_CREATESOUNDEXINFO;
import org.jouvieje.libloader.LibLoader;

/**
 * Based on FMOD Ex C++ example. Ported to Java with NativeFmodEx by Jérôme JOUVIE (Jouvieje.
 * 
 * @author Jérôme JOUVIE (Jouvieje)
 * @site   http://jerome.jouvie.free.fr/
 * @mail   jerome.jouvie@gmail.com
 */
public class UsePlugins extends ConsoleGUI {
	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args) {
		new FmodExExampleFrame(new UsePlugins());
	}

	private boolean init = false;
	private boolean deinit = false;

	private System system = new System();
	private Sound sound = new Sound();
	private ByteBuffer soundBuffer = null;

	public UsePlugins() {
		super();
		initialize();
	}

	public JPanel getPanel() {
		return this;
	}

	public String getTitle() {
		return "FMOD Ex UsePlugins example.";
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
		boolean playing = false;
		int version;

		ByteBuffer buffer = BufferUtils.newByteBuffer(256);

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

		/*
		 * Set the source directory for all of the FMOD plugins.
		 */
		result = system.setPluginPath("Plugins");
		errorCheck(result);

		final int platform = LibLoader.getPlatform();
		if(platform == LibLoader.PLATFORM_WINDOWS) {
			/*
			 * Load up an extra plugin that is not normally used by FMOD.
			 */
			result = system.loadPlugin("output_mp3.dll", null, 0);
			errorCheck(result);
		}

		/*
		 * Display plugins
		 */
		{
			int num;

			printf("Codec plugins\n");
			printf("--------------\n");
			result = system.getNumPlugins(FMOD_PLUGINTYPE_CODEC, buffer.asIntBuffer());
			errorCheck(result);
			num = buffer.getInt(0);
			for(int i = 0; i < num; i++) {
				result = system.getPluginHandle(FMOD_PLUGINTYPE_CODEC, i, buffer.asIntBuffer());
				errorCheck(result);
				int handle = buffer.get(0);

				result = system.getPluginInfo(handle, null, buffer, buffer.capacity(), null);
				errorCheck(result);
				String name = BufferUtils.toString(buffer);

				printf("%2d - %-30s", i + 1, name);

				if((i % 2) != 0) {
					printf("\n");
				}
			}
			printf("\n");
			if(((num - 1) % 2) == 0) {
				printf("\n");
			}

			printf("DSP plugins\n");
			printf("--------------\n");
			result = system.getNumPlugins(FMOD_PLUGINTYPE_DSP, buffer.asIntBuffer());
			errorCheck(result);
			num = buffer.getInt(0);
			for(int i = 0; i < num; i++) {
				result = system.getPluginHandle(FMOD_PLUGINTYPE_DSP, i, buffer.asIntBuffer());
				errorCheck(result);
				int handle = buffer.get(0);

				result = system.getPluginInfo(handle, null, buffer, buffer.capacity(), null);
				errorCheck(result);
				String name = BufferUtils.toString(buffer);

				printf("%2d - %-30s", i + 1, name);

				if((i % 2) != 0) {
					printf("\n");
				}
			}
			printf("\n");
			if(((num - 1) % 2) == 0) {
				printf("\n");
			}

			printf("Output plugins\n");
			printf("--------------\n");
			result = system.getNumPlugins(FMOD_PLUGINTYPE_OUTPUT, buffer.asIntBuffer());
			errorCheck(result);
			num = buffer.getInt(0);
			for(int i = 0; i < num; i++) {
				result = system.getPluginHandle(FMOD_PLUGINTYPE_OUTPUT, i, buffer.asIntBuffer());
				errorCheck(result);
				int handle = buffer.get(0);

				result = system.getPluginInfo(handle, null, buffer, buffer.capacity(), null);
				errorCheck(result);
				String name = BufferUtils.toString(buffer);

				printf("%2d - %-30s", i + 1, name);

				if((i % 2) != 0) {
					printf("\n");
				}
			}
			if(((num - 1) % 2) == 0) {
				printf("\n");
			}
		}

		/*
		 * System initialization
		 */
		printf("---------------------------------------------------------------------\n"); // print driver names
		printf("Press a corresponding number for an OUTPUT PLUGIN to use or E to quit\n");

		int output = -1;
		while(output < 0) {
			try {
				output = Integer.parseInt(getInput());
			}
			catch(Exception e) {
				output = -1;
			}
			Thread.yield();
		}

		result = system.getPluginHandle(FMOD_PLUGINTYPE_OUTPUT, output - 1, buffer.asIntBuffer());
		errorCheck(result);
		int outputPluginHandle = buffer.getInt(0);

		result = system.setOutputByPlugin(outputPluginHandle);
		errorCheck(result);

		/*
		 * Loads the dependant library : lame_enc.dll or the equivalent for your platform
		 * 
		 * Jouvieje note: 
		 *  output_mp3.dll requieres this library. If this library is not loaded, it
		 *  will be loaded by the system. If it is stored into java.library.path,
		 *  the system will not be able to find it.
		 *  So, we load the library here. You can use 'java.lang.System.loadLibrary',
		 *  but this will not work if the library is in a jar. In this case, use LibLoader library.
		 */
		if(output == 10) {
			try {
				LibLoader.loadLibrary("lame_enc", false); //Platform independant loading & Compatible with 'Classic' Applications, JWS Applications & Applets
				print("Info: lame_enc library sucessfully loaded.\n");
			}
			catch(UnsatisfiedLinkError e) {
				print("Info: lame_enc library not loaded.\n");
			}
		}

		result = system.init(32, FMOD_INIT_NORMAL, null);
		errorCheck(result);

		soundBuffer = Medias.loadMediaIntoMemory("/Media/wave.mp3");
		FMOD_CREATESOUNDEXINFO exinfo = FMOD_CREATESOUNDEXINFO.allocate();
		exinfo.setLength(soundBuffer.capacity());
		result = system.createStream(soundBuffer, FMOD_SOFTWARE | FMOD_OPENMEMORY, exinfo, sound);
		errorCheck(result);
		exinfo.release();

		printf("Press a key to play sound to output device.\n");

		result = system.playSound(FMOD_CHANNEL_FREE, sound, false, channel);
		errorCheck(result);

		/*
		 * Main loop.
		 */
		resetInput();
		do {
			int ms = 0, lenms = 0;
			boolean paused = false;
			int channelsplaying = 0;
			Sound currentsound = new Sound();

			system.update();

			playing = false;

			result = channel.isPlaying(buffer);
			if((result != FMOD_OK) && (result != FMOD_ERR_INVALID_HANDLE) && (result != FMOD_ERR_CHANNEL_STOLEN)) errorCheck(result);
			playing = buffer.get(0) != 0;

			result = channel.getPaused(buffer);
			if((result != FMOD_OK) && (result != FMOD_ERR_INVALID_HANDLE) && (result != FMOD_ERR_CHANNEL_STOLEN)) errorCheck(result);
			paused = buffer.get(0) != 0;

			result = channel.getPosition(buffer.asIntBuffer(), FMOD_TIMEUNIT_MS);
			if((result != FMOD_OK) && (result != FMOD_ERR_INVALID_HANDLE) && (result != FMOD_ERR_CHANNEL_STOLEN)) errorCheck(result);
			ms = buffer.getInt(0);

			channel.getCurrentSound(currentsound);
			if(!currentsound.isNull()) {
				result = currentsound.getLength(buffer.asIntBuffer(), FMOD_TIMEUNIT_MS);
				if((result != FMOD_OK) && (result != FMOD_ERR_INVALID_HANDLE) && (result != FMOD_ERR_CHANNEL_STOLEN)) errorCheck(result);
				lenms = buffer.getInt(0);
			}

			system.getChannelsPlaying(buffer.asIntBuffer());
			channelsplaying = buffer.getInt(0);

			printfr("Time %02d:%02d:%02d/%02d:%02d:%02d : %s : Channels Playing %2d", ms / 1000 / 60, ms / 1000 % 60,
					ms / 10 % 100, lenms / 1000 / 60, lenms / 1000 % 60, lenms / 10 % 100, paused ? "Paused "
							: playing ? "Playing" : "Stopped", channelsplaying);

			try {
				Thread.sleep(5);
			}
			catch(InterruptedException e1) {}
		}
		while(!keyHit() && !deinit);

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