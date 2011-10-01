package org.jouvieje.fmodex.examples;

import static org.jouvieje.fmodex.defines.FMOD_INITFLAGS.FMOD_INIT_NORMAL;
import static org.jouvieje.fmodex.defines.FMOD_MODE.FMOD_DEFAULT;
import static org.jouvieje.fmodex.defines.FMOD_MODE.FMOD_LOOP_NORMAL;
import static org.jouvieje.fmodex.defines.FMOD_MODE.FMOD_OPENMEMORY;
import static org.jouvieje.fmodex.defines.FMOD_MODE.FMOD_SOFTWARE;
import static org.jouvieje.fmodex.defines.VERSIONS.FMOD_VERSION;
import static org.jouvieje.fmodex.defines.VERSIONS.NATIVEFMODEX_JAR_VERSION;
import static org.jouvieje.fmodex.defines.VERSIONS.NATIVEFMODEX_LIBRARY_VERSION;
import static org.jouvieje.fmodex.enumerations.FMOD_CHANNELINDEX.FMOD_CHANNEL_FREE;
import static org.jouvieje.fmodex.utils.BufferUtils.newByteBuffer;
import static org.jouvieje.fmodex.utils.BufferUtils.newFloatBuffer;
import static org.jouvieje.fmodex.utils.BufferUtils.SIZEOF_INT;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

import javax.swing.JPanel;

import org.jouvieje.fmodex.Channel;
import org.jouvieje.fmodex.DSP;
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
public class DspGainMain extends ConsoleGUI {
	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args) {
		new FmodExExampleFrame(new DspGainMain());
	}

	private boolean init = false;
	private boolean deinit = false;

	private System system = new System();
	private Sound sound = new Sound();

	public DspGainMain() {
		super();
		initialize();
	}

	public JPanel getPanel() {
		return this;
	}

	public String getTitle() {
		return "FMOD Ex DspGain example.";
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
		int version;

		ByteBuffer buffer = newByteBuffer(SIZEOF_INT);

		/*
		 * Global Settings
		 */
		errorCheck(FmodEx.System_Create(system));

		errorCheck(system.getVersion(buffer.asIntBuffer()));
		version = buffer.getInt(0);

		if(version < FMOD_VERSION) {
			printfExit("Error!  You are using an old version of FMOD %08x.  This program requires %08x\n", version,
					FMOD_VERSION);
			return;
		}

		errorCheck(system.init(32, FMOD_INIT_NORMAL, null));

		/**
		 * Jouvieje comment :
		 *  Creates our DSP Unit
		 */
		DSP myDsp = new DSP();
		errorCheck(system.createDSP(DspGain.FMODGetDSPDescription(), myDsp));

		/**
		 * Jouvieje comment :
		 *  Get dspGain min and max
		 */
		FloatBuffer gainMin = newFloatBuffer(1);
		FloatBuffer gainMax = newFloatBuffer(1);
		myDsp.getParameterInfo(0, null, null, null, 0, gainMin, gainMax);

		/**
		 * Jouvieje comment :
		 *  Set the wanted DSP Gain
		 */
		float dspGain = 0.5f;
		myDsp.setParameter(0, dspGain);

		if(true) {
			/**
			 * Jouvieje comment :
			 *  Insert DSP unit at the head of the DSP chain.
			 */
			errorCheck(system.addDSP(myDsp, null));

			/**
			 * Jouvieje comment :
			 *  FMOD_SOFTWARE to use DSP
			 */
			soundBuffer = Medias.loadMediaIntoMemory("/Media/wave.mp3");
			exinfo = FMOD_CREATESOUNDEXINFO.allocate();
			exinfo.setLength(soundBuffer.capacity());
			errorCheck(system.createSound(soundBuffer, FMOD_DEFAULT | FMOD_SOFTWARE | FMOD_LOOP_NORMAL | FMOD_OPENMEMORY, exinfo, sound));
			exinfo.release();

			errorCheck(system.playSound(FMOD_CHANNEL_FREE, sound, false, channel));
		}
		else {
			soundBuffer = Medias.loadMediaIntoMemory("/Media/wave.mp3");
			exinfo = FMOD_CREATESOUNDEXINFO.allocate();
			exinfo.setLength(soundBuffer.capacity());
			errorCheck(system.createSound(soundBuffer, FMOD_DEFAULT | FMOD_SOFTWARE | FMOD_LOOP_NORMAL | FMOD_OPENMEMORY, exinfo, sound));
			exinfo.release();

			errorCheck(system.playSound(FMOD_CHANNEL_FREE, sound, true, channel));

			errorCheck(myDsp.setActive(true));

			errorCheck(channel.addDSP(myDsp, null));

			errorCheck(channel.setPaused(false));
		}

		printf("===================================================================\n");
		printf("DSP_GAIN.DLL.  Copyright (c) Firelight Technologies 2004-2009.\n");
		printf("===================================================================\n");
		printf("Press '+' to increase DSP Gain\n");
		printf("Press '-' to decrease DSP Gain\n");
		printf("Press 'E' to quit\n");
		printf("\n");

		/*
		 * Main loop.
		 */
		boolean exit = false;
		do {
			switch(getKey()) {
				case '+':
					dspGain += 0.1f;
					if(dspGain > gainMax.get(0)) {
						dspGain = gainMax.get(0);
					}
					myDsp.setParameter(0, dspGain);
					break;
				case '-':
					dspGain -= 0.1f;
					if(dspGain < gainMin.get(0)) {
						dspGain = gainMin.get(0);
					}
					myDsp.setParameter(0, dspGain);
					break;
				case 'e':
				case 'E':
					exit = true;
					break;
			}

			system.update();

			printfr("DSP Gain = %1.1f", dspGain);

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
		if(!sound.isNull()) {
			errorCheck(sound.release());
		}
		if(!system.isNull()) {
			errorCheck(system.close());
			errorCheck(system.release());
		}

		printExit("Shutdown\n");
	}
}