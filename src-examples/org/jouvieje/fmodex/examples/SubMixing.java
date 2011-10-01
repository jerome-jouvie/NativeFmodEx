/*===============================================================================================
Submixing Example
Copyright (c), Firelight Technologies Pty, Ltd 2004-2010.

This example shows how to put channels into channel groups, so that you can affect a group
of channels at a time instead of just one channel at a time.
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
import static org.jouvieje.fmodex.enumerations.FMOD_DSP_FLANGE.FMOD_DSP_FLANGE_RATE;
import static org.jouvieje.fmodex.enumerations.FMOD_DSP_LOWPASS.FMOD_DSP_LOWPASS_CUTOFF;
import static org.jouvieje.fmodex.enumerations.FMOD_DSP_TYPE.FMOD_DSP_TYPE_FLANGE;
import static org.jouvieje.fmodex.enumerations.FMOD_DSP_TYPE.FMOD_DSP_TYPE_LOWPASS;
import static org.jouvieje.fmodex.enumerations.FMOD_DSP_TYPE.FMOD_DSP_TYPE_REVERB;
import static org.jouvieje.fmodex.utils.BufferUtils.newByteBuffer;
import static org.jouvieje.fmodex.utils.BufferUtils.SIZEOF_INT;

import java.nio.ByteBuffer;

import javax.swing.JPanel;

import org.jouvieje.fmodex.Channel;
import org.jouvieje.fmodex.ChannelGroup;
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
public class SubMixing extends ConsoleGUI {
	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args) {
		new FmodExExampleFrame(new SubMixing());
	}

	private boolean init = false;
	private boolean deinit = false;

	private System system = new System();
	private Sound[] sounds = new Sound[5];
	private DSP dspreverb = new DSP();
	private DSP dspflange = new DSP();
	private DSP dsplowpass = new DSP();
	private ChannelGroup groupA = new ChannelGroup();
	private ChannelGroup groupB = new ChannelGroup();

	public SubMixing() {
		super();
		initialize();
	}

	public JPanel getPanel() {
		return this;
	}

	public String getTitle() {
		return "FMOD Ex SubMixing example.";
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
		Channel[] channels = new Channel[5];
		ChannelGroup masterGroup = new ChannelGroup();
		FMOD_RESULT result;
		int version;

		ByteBuffer buffer = newByteBuffer(SIZEOF_INT);

		for(int i = 0; i < sounds.length; i++)
			sounds[i] = new Sound();
		for(int i = 0; i < channels.length; i++)
			channels[i] = new Channel();

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

		soundBuffer = Medias.loadMediaIntoMemory("/Media/drumloop.wav");
		exinfo = FMOD_CREATESOUNDEXINFO.allocate();
		exinfo.setLength(soundBuffer.capacity());
		result = system.createSound(soundBuffer, FMOD_SOFTWARE | FMOD_LOOP_NORMAL | FMOD_OPENMEMORY, exinfo, sounds[0]);
		errorCheck(result);
		soundBuffer = null;
		exinfo.release();

		soundBuffer = Medias.loadMediaIntoMemory("/Media/jaguar.wav");
		exinfo = FMOD_CREATESOUNDEXINFO.allocate();
		exinfo.setLength(soundBuffer.capacity());
		result = system.createSound(soundBuffer, FMOD_SOFTWARE | FMOD_LOOP_NORMAL | FMOD_OPENMEMORY, exinfo, sounds[1]);
		errorCheck(result);
		soundBuffer = null;
		exinfo.release();

		soundBuffer = Medias.loadMediaIntoMemory("/Media/c.ogg");
		exinfo = FMOD_CREATESOUNDEXINFO.allocate();
		exinfo.setLength(soundBuffer.capacity());
		result = system.createSound(soundBuffer, FMOD_SOFTWARE | FMOD_LOOP_NORMAL | FMOD_OPENMEMORY, exinfo, sounds[2]);
		errorCheck(result);
		soundBuffer = null;
		exinfo.release();

		soundBuffer = Medias.loadMediaIntoMemory("/Media/d.ogg");
		exinfo = FMOD_CREATESOUNDEXINFO.allocate();
		exinfo.setLength(soundBuffer.capacity());
		result = system.createSound(soundBuffer, FMOD_SOFTWARE | FMOD_LOOP_NORMAL | FMOD_OPENMEMORY, exinfo, sounds[3]);
		errorCheck(result);
		soundBuffer = null;
		exinfo.release();

		soundBuffer = Medias.loadMediaIntoMemory("/Media/e.ogg");
		exinfo = FMOD_CREATESOUNDEXINFO.allocate();
		exinfo.setLength(soundBuffer.capacity());
		result = system.createSound(soundBuffer, FMOD_SOFTWARE | FMOD_LOOP_NORMAL | FMOD_OPENMEMORY, exinfo, sounds[4]);
		errorCheck(result);
		soundBuffer = null;
		exinfo.release();

		result = system.createChannelGroup("Group A", groupA);
		errorCheck(result);

		result = system.createChannelGroup("Group B", groupB);
		errorCheck(result);

		result = system.getMasterChannelGroup(masterGroup);
		errorCheck(result);

		result = masterGroup.addGroup(groupA);
		errorCheck(result);

		result = masterGroup.addGroup(groupB);
		errorCheck(result);

		printf("======================================================================\n");
		printf("Sub-mixing example.  Copyright (c) Firelight Technologies 2004-2009.  \n");
		printf("======================================================================\n");
		printf("                                                       (drumloop.wav) \n");
		printf("                                                      /               \n");
		printf("                                              (groupA)                \n");
		printf("                                     (reverb)/        \\              \n");
		printf("                                    /                  (jaguar.wav)   \n");
		printf("(soundcard)--(lowpass)--(mastergroup)                                 \n");
		printf("                                    \\                  (c.ogg)       \n");
		printf("                                     (flange)         /               \n");
		printf("                                             \\(groupB)--(d.ogg)      \n");
		printf("                                                      \\              \n");
		printf("                                                       (e.ogg)        \n");
		printf("Press 'A' to mute/unmute group A\n");
		printf("Press 'B' to mute/unmute group B\n");
		printf("\n");
		printf("Press 'R' to place reverb on group A\n");
		printf("Press 'F' to place flange on group B\n");
		printf("Press 'L' to place lowpass on master group (everything)\n");
		printf("Press 'E' to quit\n");
		printf("\n");

		/*
		 * Start all the sounds!
		 */

		for(int i = 0; i < 5; i++) {
			result = system.playSound(FMOD_CHANNEL_FREE, sounds[i], true, channels[i]);
			errorCheck(result);
			if(i < 2) {
				result = channels[i].setChannelGroup(groupA);
			}
			else {
				result = channels[i].setChannelGroup(groupB);
			}
			errorCheck(result);
			result = channels[i].setPaused(false);
			errorCheck(result);
		}

		/*
		 * Create the DSP effects we want to apply to our submixes.
		 */
		result = system.createDSPByType(FMOD_DSP_TYPE_REVERB, dspreverb);
		errorCheck(result);

		result = system.createDSPByType(FMOD_DSP_TYPE_FLANGE, dspflange);
		errorCheck(result);
		result = dspflange.setParameter(FMOD_DSP_FLANGE_RATE.asInt(), 1.0f);
		errorCheck(result);

		result = system.createDSPByType(FMOD_DSP_TYPE_LOWPASS, dsplowpass);
		errorCheck(result);
		result = dsplowpass.setParameter(FMOD_DSP_LOWPASS_CUTOFF.asInt(), 500.0f);
		errorCheck(result);

		boolean muteA = true;
		boolean muteB = true;
		boolean reverbA = true;
		boolean flangeB = true;
		boolean lowpass = true;

		/*
		 * Main loop.
		 */
		boolean exit = false;
		do {
			switch(getKey()) {
				case 'a':
				case 'A':
					groupA.setMute(muteA);

					muteA = !muteA;
					break;
				case 'b':
				case 'B':
					groupB.setMute(muteB);

					muteB = !muteB;
					break;
				case 'r':
				case 'R':

					if(reverbA) {
						groupA.addDSP(dspreverb, null);
					}
					else {
						dspreverb.remove();
					}

					reverbA = !reverbA;
					break;
				case 'f':
				case 'F':
					if(flangeB) {
						groupB.addDSP(dspflange, null);
					}
					else {
						dspflange.remove();
					}

					flangeB = !flangeB;
					break;
				case 'l':
				case 'L':
					if(lowpass) {
						masterGroup.addDSP(dsplowpass, null);
					}
					else {
						dsplowpass.remove();
					}

					lowpass = !lowpass;
					break;
				case 'e':
				case 'E':
					exit = true;
					break;
			}

			system.update();

			{
				system.getChannelsPlaying(buffer.asIntBuffer());
				int channelsplaying = buffer.getInt(0);

				printfr("Channels Playing %2d", channelsplaying);
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
		for(int i = 0; i < 5; i++) {
			if(!sounds[i].isNull()) {
				result = sounds[i].release();
				errorCheck(result);
			}
		}

		if(!dspreverb.isNull()) {
			result = dspreverb.release();
			errorCheck(result);
		}
		if(!dspflange.isNull()) {
			result = dspflange.release();
			errorCheck(result);
		}
		if(!dsplowpass.isNull()) {
			result = dsplowpass.release();
			errorCheck(result);
		}

		if(!groupA.isNull()) {
			result = groupA.release();
			errorCheck(result);
		}
		if(!groupB.isNull()) {
			result = groupB.release();
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