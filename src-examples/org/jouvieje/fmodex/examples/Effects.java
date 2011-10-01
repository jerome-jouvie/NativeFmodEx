/*===============================================================================================
Effects Example
Copyright (c), Firelight Technologies Pty, Ltd 2004-2010.

This example shows how to apply some of the built in software effects to sounds. 
This example filters the global mix.  All software sounds played here would be filtered in the 
same way.
To filter per channel, and not have other channels affected, simply replace system->addDSP with
channel->addDSP.
Note in this example you don't have to add and remove units each time, you could simply add them 
all at the start then use DSP::setActive to toggle them on and off.
===============================================================================================*/

package org.jouvieje.fmodex.examples;

import static org.jouvieje.fmodex.defines.FMOD_INITFLAGS.FMOD_INIT_NORMAL;
import static org.jouvieje.fmodex.defines.FMOD_MODE.FMOD_LOOP_NORMAL;
import static org.jouvieje.fmodex.defines.FMOD_MODE.FMOD_OPENMEMORY;
import static org.jouvieje.fmodex.defines.FMOD_MODE.FMOD_SOFTWARE;
import static org.jouvieje.fmodex.defines.VERSIONS.FMOD_VERSION;
import static org.jouvieje.fmodex.defines.VERSIONS.NATIVEFMODEX_JAR_VERSION;
import static org.jouvieje.fmodex.defines.VERSIONS.NATIVEFMODEX_LIBRARY_VERSION;
import static org.jouvieje.fmodex.enumerations.FMOD_CHANNELINDEX.FMOD_CHANNEL_FREE;
import static org.jouvieje.fmodex.enumerations.FMOD_DSP_DISTORTION.FMOD_DSP_DISTORTION_LEVEL;
import static org.jouvieje.fmodex.enumerations.FMOD_DSP_ECHO.FMOD_DSP_ECHO_DELAY;
import static org.jouvieje.fmodex.enumerations.FMOD_DSP_PARAMEQ.FMOD_DSP_PARAMEQ_CENTER;
import static org.jouvieje.fmodex.enumerations.FMOD_DSP_PARAMEQ.FMOD_DSP_PARAMEQ_GAIN;
import static org.jouvieje.fmodex.enumerations.FMOD_DSP_TYPE.FMOD_DSP_TYPE_CHORUS;
import static org.jouvieje.fmodex.enumerations.FMOD_DSP_TYPE.FMOD_DSP_TYPE_DISTORTION;
import static org.jouvieje.fmodex.enumerations.FMOD_DSP_TYPE.FMOD_DSP_TYPE_ECHO;
import static org.jouvieje.fmodex.enumerations.FMOD_DSP_TYPE.FMOD_DSP_TYPE_FLANGE;
import static org.jouvieje.fmodex.enumerations.FMOD_DSP_TYPE.FMOD_DSP_TYPE_HIGHPASS;
import static org.jouvieje.fmodex.enumerations.FMOD_DSP_TYPE.FMOD_DSP_TYPE_LOWPASS;
import static org.jouvieje.fmodex.enumerations.FMOD_DSP_TYPE.FMOD_DSP_TYPE_PARAMEQ;
import static org.jouvieje.fmodex.enumerations.FMOD_RESULT.FMOD_ERR_CHANNEL_STOLEN;
import static org.jouvieje.fmodex.enumerations.FMOD_RESULT.FMOD_ERR_INVALID_HANDLE;
import static org.jouvieje.fmodex.enumerations.FMOD_RESULT.FMOD_OK;
import static org.jouvieje.fmodex.utils.BufferUtils.newByteBuffer;
import static org.jouvieje.fmodex.utils.BufferUtils.SIZEOF_INT;

import java.nio.ByteBuffer;

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
public class Effects extends ConsoleGUI {
	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args) {
		new FmodExExampleFrame(new Effects());
	}

	private boolean init = false;
	private boolean deinit = false;

	private System system = new System();
	private Sound sound = new Sound();

	public Effects() {
		super();
		initialize();
	}

	public JPanel getPanel() {
		return this;
	}

	public String getTitle() {
		return "FMOD Ex Effects example.";
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
		DSP dsplowpass = new DSP();
		DSP dsphighpass = new DSP();
		DSP dspecho = new DSP();
		DSP dspflange = new DSP();
		DSP dspdistortion = new DSP();
		DSP dspchorus = new DSP();
		DSP dspparameq = new DSP();
		FMOD_RESULT result;
		int version;

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

		soundBuffer = Medias.loadMediaIntoMemory("/Media/drumloop.wav");
		exinfo = FMOD_CREATESOUNDEXINFO.allocate();
		exinfo.setLength(soundBuffer.capacity());
		result = system.createSound(soundBuffer, FMOD_SOFTWARE | FMOD_LOOP_NORMAL | FMOD_OPENMEMORY, exinfo, sound);
		errorCheck(result);
		exinfo.release();

		printf("===================================================================\n");
		printf("Effects Example.  Copyright (c) Firelight Technologies 2004-2009.\n");
		printf("===================================================================\n");
		printf("\n");
		printf("Press SPACE to paused/unpause sound.\n");
		printf("Press 1 to toggle dsplowpass effect.\n");
		printf("Press 2 to toggle dsphighpass effect.\n");
		printf("Press 3 to toggle dspecho effect.\n");
		printf("Press 4 to toggle dspflange effect.\n");
		printf("Press 5 to toggle dspdistortion effect.\n");
		printf("Press 6 to toggle dspchorus effect.\n");
		printf("Press 7 to toggle dspparameq effect.\n");
		printf("Press e to quit\n");
		printf("\n");

		result = system.playSound(FMOD_CHANNEL_FREE, sound, false, channel);
		errorCheck(result);

		/*
		 * Create some effects to play with.
		 */
		result = system.createDSPByType(FMOD_DSP_TYPE_LOWPASS, dsplowpass);
		errorCheck(result);
		result = system.createDSPByType(FMOD_DSP_TYPE_HIGHPASS, dsphighpass);
		errorCheck(result);
		result = system.createDSPByType(FMOD_DSP_TYPE_ECHO, dspecho);
		errorCheck(result);
		result = system.createDSPByType(FMOD_DSP_TYPE_FLANGE, dspflange);
		errorCheck(result);
		result = system.createDSPByType(FMOD_DSP_TYPE_DISTORTION, dspdistortion);
		errorCheck(result);
		result = system.createDSPByType(FMOD_DSP_TYPE_CHORUS, dspchorus);
		errorCheck(result);
		result = system.createDSPByType(FMOD_DSP_TYPE_PARAMEQ, dspparameq);
		errorCheck(result);

		/*
		 * Main loop.
		 */
		boolean exit = false;
		do {
			switch(getKey()) {
				case ' ': {
					channel.getPaused(buffer);
					errorCheck(result);
					boolean paused = buffer.get(0) != 0;

					result = channel.setPaused(!paused);
					errorCheck(result);
					break;
				}
				case '1': {
					result = dsplowpass.getActive(buffer);
					errorCheck(result);
					boolean active = buffer.get(0) != 0;

					if(active) {
						result = dsplowpass.remove();
						errorCheck(result);
					}
					else {
						result = system.addDSP(dsplowpass, null);
						errorCheck(result);
					}
					break;
				}
				case '2': {
					result = dsphighpass.getActive(buffer);
					errorCheck(result);
					boolean active = buffer.get(0) != 0;

					if(active) {
						result = dsphighpass.remove();
						errorCheck(result);
					}
					else {
						result = system.addDSP(dsphighpass, null);
						errorCheck(result);
					}
					break;
				}
				case '3': {
					result = dspecho.getActive(buffer);
					errorCheck(result);
					boolean active = buffer.get(0) != 0;

					if(active) {
						result = dspecho.remove();
						errorCheck(result);
					}
					else {
						result = system.addDSP(dspecho, null);
						errorCheck(result);

						result = dspecho.setParameter(FMOD_DSP_ECHO_DELAY.asInt(), 50.0f);
						errorCheck(result);
					}
					break;
				}
				case '4': {
					result = dspflange.getActive(buffer);
					errorCheck(result);
					boolean active = buffer.get(0) != 0;

					if(active) {
						result = dspflange.remove();
						errorCheck(result);
					}
					else {
						result = system.addDSP(dspflange, null);
						errorCheck(result);
					}
					break;
				}
				case '5': {
					result = dspdistortion.getActive(buffer);
					errorCheck(result);
					boolean active = buffer.get(0) != 0;

					if(active) {
						result = dspdistortion.remove();
						errorCheck(result);
					}
					else {
						result = system.addDSP(dspdistortion, null);
						errorCheck(result);

						result = dspdistortion.setParameter(FMOD_DSP_DISTORTION_LEVEL.asInt(), 0.8f);
						errorCheck(result);
					}
					break;
				}
				case '6': {
					result = dspchorus.getActive(buffer);
					errorCheck(result);
					boolean active = buffer.get(0) != 0;

					if(active) {
						result = dspchorus.remove();
						errorCheck(result);
					}
					else {
						result = system.addDSP(dspchorus, null);
						errorCheck(result);
					}
					break;
				}
				case '7': {
					result = dspparameq.getActive(buffer);
					errorCheck(result);
					boolean active = buffer.get(0) != 0;

					if(active) {
						result = dspparameq.remove();
						errorCheck(result);
					}
					else {
						result = system.addDSP(dspparameq, null);
						errorCheck(result);

						result = dspparameq.setParameter(FMOD_DSP_PARAMEQ_CENTER.asInt(), 5000.0f);
						errorCheck(result);
						result = dspparameq.setParameter(FMOD_DSP_PARAMEQ_GAIN.asInt(), 0.0f);
						errorCheck(result);
					}
					break;
				}
				case 'e':
				case 'E':
					exit = true;
					break;
			}

			system.update();

			{
				boolean paused = false;

				dsplowpass.getActive(buffer);
				boolean dsplowpass_active = buffer.get(0) != 0;
				dsphighpass.getActive(buffer);
				boolean dsphighpass_active = buffer.get(0) != 0;
				dspecho.getActive(buffer);
				boolean dspecho_active = buffer.get(0) != 0;
				dspflange.getActive(buffer);
				boolean dspflange_active = buffer.get(0) != 0;
				dspdistortion.getActive(buffer);
				boolean dspdistortion_active = buffer.get(0) != 0;
				dspchorus.getActive(buffer);
				boolean dspchorus_active = buffer.get(0) != 0;
				dspparameq.getActive(buffer);
				boolean dspparameq_active = buffer.get(0) != 0;

				if(channel != null && !channel.isNull()) {
					result = channel.getPaused(buffer);
					if((result != FMOD_OK) && (result != FMOD_ERR_INVALID_HANDLE)
							&& (result != FMOD_ERR_CHANNEL_STOLEN)) errorCheck(result);
					paused = buffer.get(0) != 0;
				}

				printfr("%s : lowpass[%c] highpass[%c] echo[%c] flange[%c] dist[%c] chorus[%c] parameq[%c]",
						paused ? "Paused " : "Playing", dsplowpass_active ? 'x' : ' ', dsphighpass_active ? 'x' : ' ',
						dspecho_active ? 'x' : ' ', dspflange_active ? 'x' : ' ', dspdistortion_active ? 'x' : ' ',
						dspchorus_active ? 'x' : ' ', dspparameq_active ? 'x' : ' ');
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