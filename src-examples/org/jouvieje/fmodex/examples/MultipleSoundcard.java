/*===============================================================================================
MultipleSoundCard Example
Copyright (c), Firelight Technologies Pty, Ltd 2004-2010.

This example shows how to play sounds on 2 different sound cards from the same application.
It creates 2 FMOD::System objects, selects a different sound device for each, then allows
the user to play 1 sound on 1 soundcard and another sound on another soundcard.

Note that sounds created on device A cannot be played on device B and vice versa.
You will have to each sound separately for each sound card.  Device A might load the sound
into its own memory so obviously device B wouldnt be able to play it.
===============================================================================================*/

package org.jouvieje.fmodex.examples;

import static org.jouvieje.fmodex.defines.FMOD_INITFLAGS.FMOD_INIT_NORMAL;
import static org.jouvieje.fmodex.defines.FMOD_MODE.FMOD_HARDWARE;
import static org.jouvieje.fmodex.defines.FMOD_MODE.FMOD_LOOP_OFF;
import static org.jouvieje.fmodex.defines.FMOD_MODE.FMOD_OPENMEMORY;
import static org.jouvieje.fmodex.defines.VERSIONS.FMOD_VERSION;
import static org.jouvieje.fmodex.defines.VERSIONS.NATIVEFMODEX_JAR_VERSION;
import static org.jouvieje.fmodex.defines.VERSIONS.NATIVEFMODEX_LIBRARY_VERSION;
import static org.jouvieje.fmodex.enumerations.FMOD_CHANNELINDEX.FMOD_CHANNEL_FREE;

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

/**
 * Based on FMOD Ex C++ example. Ported to Java with NativeFmodEx by Jérôme JOUVIE (Jouvieje.
 * 
 * @author Jérôme JOUVIE (Jouvieje)
 * @site   http://jerome.jouvie.free.fr/
 * @mail   jerome.jouvie@gmail.com
 */
public class MultipleSoundcard extends ConsoleGUI {
	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args) {
		new FmodExExampleFrame(new MultipleSoundcard());
	}

	private boolean init = false;
	private boolean deinit = false;

	private System systemA = new System();
	private System systemB = new System();
	private Sound soundA = new Sound();
	private Sound soundB = new Sound();

	public MultipleSoundcard() {
		super();
		initialize();
	}

	public JPanel getPanel() {
		return this;
	}

	public String getTitle() {
		return "FMOD Ex MultipleSoundcard example.";
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
		Channel channelA = new Channel();
		Channel channelB = new Channel();
		FMOD_RESULT result;
		int numdrivers, driver;
		int version;

		ByteBuffer buffer = BufferUtils.newByteBuffer(256);

		/*
		 * Create Sound Card A
		 */
		result = FmodEx.System_Create(systemA);
		errorCheck(result);

		result = systemA.getVersion(buffer.asIntBuffer());
		errorCheck(result);
		version = buffer.getInt(0);

		if(version < FMOD_VERSION) {
			printfExit("Error!  You are using an old version of FMOD %08x.  This program requires %08x\n", version,
					FMOD_VERSION);
			return;
		}

		result = systemA.getNumDrivers(buffer.asIntBuffer());
		errorCheck(result);
		numdrivers = buffer.getInt(0);

		printf("---------------------------------------------------------\n");
		printf("Select soundcard A\n");
		printf("---------------------------------------------------------\n");
		for(int i = 0; i < numdrivers; i++) {
			result = systemA.getDriverInfo(i, buffer, buffer.capacity(), null);
			errorCheck(result);
			String name = BufferUtils.toString(buffer);

			printf("%d : %s\n", i + 1, name);
		}
		printf("---------------------------------------------------------\n");
		printf("Press a corresponding number or E to quit\n");

		driver = -1;
		while(driver < 0 || driver >= numdrivers) {
			try {
				driver = Integer.parseInt("" + getKey()) - 1;
			}
			catch(NumberFormatException e) {
				driver = -1;
			}
			Thread.yield();
		}

		printf("\n");

		result = systemA.setDriver(driver);
		errorCheck(result);

		result = systemA.init(32, FMOD_INIT_NORMAL, null);
		errorCheck(result);

		/*
		 * Create Sound Card B
		 */
		result = FmodEx.System_Create(systemB);
		errorCheck(result);

		result = systemB.getVersion(buffer.asIntBuffer());
		errorCheck(result);
		version = buffer.getInt(0);

		if(version < FMOD_VERSION) {
			printfExit("Error!  You are using an old version of FMOD %08x.  This program requires %08x\n", version,
					FMOD_VERSION);
			return;
		}

		result = systemB.getNumDrivers(buffer.asIntBuffer());
		errorCheck(result);
		numdrivers = buffer.getInt(0);

		printf("---------------------------------------------------------\n");
		printf("Select soundcard B\n");
		printf("---------------------------------------------------------\n");
		for(int i = 0; i < numdrivers; i++) {
			result = systemB.getDriverInfo(i, buffer, buffer.capacity(), null);
			errorCheck(result);
			String name = BufferUtils.toString(buffer);

			printf("%d : %s\n", i + 1, name);
		}
		printf("---------------------------------------------------------\n");
		printf("Press a corresponding number or E to quit\n");

		driver = -1;
		while(driver < 0 || driver >= numdrivers) {
			try {
				driver = Integer.parseInt("" + getKey()) - 1;
			}
			catch(NumberFormatException e) {
				driver = -1;
			}
			Thread.yield();
		}

		printf("\n");

		result = systemB.setDriver(driver);
		errorCheck(result);

		result = systemB.init(32, FMOD_INIT_NORMAL, null);
		errorCheck(result);

		/*
		 * Load 1 sample into each soundcard.
		 */
		soundBuffer = Medias.loadMediaIntoMemory("/Media/drumloop.wav");
		exinfo = FMOD_CREATESOUNDEXINFO.allocate();
		exinfo.setLength(soundBuffer.capacity());
		result = systemA.createSound(soundBuffer, FMOD_HARDWARE | FMOD_OPENMEMORY, exinfo, soundA);
		errorCheck(result);
		result = soundA.setMode(FMOD_LOOP_OFF);
		errorCheck(result);
		soundBuffer = null;
		exinfo.release();

		soundBuffer = Medias.loadMediaIntoMemory("/Media/jaguar.wav");
		exinfo = FMOD_CREATESOUNDEXINFO.allocate();
		exinfo.setLength(soundBuffer.capacity());
		result = systemB.createSound(soundBuffer, FMOD_HARDWARE | FMOD_OPENMEMORY, exinfo, soundB);
		errorCheck(result);
		soundBuffer = null;
		exinfo.release();

		printf("===========================================================================\n");
		printf("MultipleSoundCard Example.  Copyright (c) Firelight Technologies 2004-2009.\n");
		printf("===========================================================================\n");
		printf("\n");
		printf("Press '1' to play a sound on soundcard A\n");
		printf("Press '2' to play a sound on soundcard B\n");
		printf("Press 'E' to quit\n");
		printf("Press Enter to validate your choice\n");
		printf("\n");

		/*
		 * Main loop.
		 */
		boolean exit = false;
		do {
			int channelsplayingA = 0;
			int channelsplayingB = 0;

			switch(getKey()) {
				case '1':
					result = systemA.playSound(FMOD_CHANNEL_FREE, soundA, false, channelA);
					errorCheck(result);
					break;
				case '2':
					result = systemB.playSound(FMOD_CHANNEL_FREE, soundB, false, channelB);
					errorCheck(result);
					break;
				case 'e':
				case 'E':
					exit = true;
					break;
			}

			systemA.update();
			systemB.update();

			systemA.getChannelsPlaying(buffer.asIntBuffer());
			channelsplayingA = buffer.getInt(0);
			systemB.getChannelsPlaying(buffer.asIntBuffer());
			channelsplayingB = buffer.getInt(0);

			printfr("Channels Playing on A %2d.   Channels Playing on B %2d.", channelsplayingA, channelsplayingB);

			try {
				Thread.sleep(100);
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
		if(!soundA.isNull()) {
			result = soundA.release();
			errorCheck(result);
		}
		if(!systemA.isNull()) {
			result = systemA.close();
			errorCheck(result);
			result = systemA.release();
			errorCheck(result);
		}

		if(!soundB.isNull()) {
			result = soundB.release();
			errorCheck(result);
		}
		if(!systemB.isNull()) {
			result = systemB.close();
			errorCheck(result);
			result = systemB.release();
			errorCheck(result);
		}

		printExit("Shutdown\n");
	}
}