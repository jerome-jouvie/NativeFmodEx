/*===============================================================================================
 DSP Effect per speaker Example
 Copyright (c), Firelight Technologies Pty, Ltd 2004-2010.

 This example shows how to manipulate a DSP network and as an example, creates 2 dsp effects,
 and splits a single sound into 2 audio paths, which it then filters seperately.
 To only have each audio path come out of one speaker each, DSPConnection::setLevels is used just
 before the 2 branches merge back together again.

 For more speakers:
 1. Use System::setSpeakerMode or System::setOutputFormat.
 2. Create more effects, currently 2 for stereo (lowpass and chorus), create one per speaker.
 3. Under the 'Now connect the 2 effects to channeldsp head.' section, connect the extra effects
    by duplicating the code more times.
 4. Filter each effect to each speaker by calling DSP::setInputLevels.  Expand the existing code
    by extending the level arrays from 2 to the number of speakers you require, and change the
    numlevels parameter in DSP::setInputLevels from 2 to the correct number accordingly.

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
import static org.jouvieje.fmodex.enumerations.FMOD_DSP_TYPE.FMOD_DSP_TYPE_CHORUS;
import static org.jouvieje.fmodex.enumerations.FMOD_DSP_TYPE.FMOD_DSP_TYPE_LOWPASS;
import static org.jouvieje.fmodex.enumerations.FMOD_SPEAKER.FMOD_SPEAKER_FRONT_LEFT;
import static org.jouvieje.fmodex.enumerations.FMOD_SPEAKER.FMOD_SPEAKER_FRONT_RIGHT;
import static org.jouvieje.fmodex.utils.BufferUtils.newByteBuffer;
import static org.jouvieje.fmodex.utils.BufferUtils.newFloatBuffer;
import static org.jouvieje.fmodex.utils.BufferUtils.SIZEOF_INT;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

import javax.swing.JPanel;

import org.jouvieje.fmodex.Channel;
import org.jouvieje.fmodex.DSP;
import org.jouvieje.fmodex.DSPConnection;
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
public class DspEffectPerSpeaker extends ConsoleGUI {
	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args) {
		new FmodExExampleFrame(new DspEffectPerSpeaker());
	}

	private boolean init = false;
	private boolean deinit = false;

	private boolean lowpass = false;
	private boolean chorus = false;

	private System system = new System();
	private Sound sound = new Sound();
	private DSP dsplowpass = new DSP();
	private DSP dspchorus = new DSP();

	public DspEffectPerSpeaker() {
		super();
		initialize();
	}

	public JPanel getPanel() {
		return this;
	}

	public String getTitle() {
		return "FMOD Ex DspEffectPerSpeaker example.";
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
		DSPConnection dsplowpassconnection = new DSPConnection();
		DSPConnection dspchorusconnection = new DSPConnection();
		Channel channel = new Channel();
		DSP dsphead = new DSP();
		DSP dspchannelmixer = new DSP();
		int version;
		float pan = 0;

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

		errorCheck(system.init(32, FMOD_INIT_NORMAL, null));

		soundBuffer = Medias.loadMediaIntoMemory("/Media/drumloop.wav");
		exinfo = FMOD_CREATESOUNDEXINFO.allocate();
		exinfo.setLength(soundBuffer.capacity());
		errorCheck(system.createSound(soundBuffer, FMOD_SOFTWARE | FMOD_LOOP_NORMAL | FMOD_OPENMEMORY, exinfo, sound));
		exinfo.release();

		printf("===============================================================================\n");
		printf("DSP effect per speaker example. Copyright (c) Firelight Technologies 2004-2009.\n");
		printf("===============================================================================\n");
		printf("Press 'L' to toggle lowpass on/off on left speaker only\n");
		printf("Press 'R' to toggle chorus on/off on right speaker only\n");
		printf("Press '[' to pan sound left\n");
		printf("Press ']' to pan sound right\n");
		printf("Press 'E' to quit\n");
		printf("\n");

		errorCheck(system.playSound(FMOD_CHANNEL_FREE, sound, false, channel));

		/*
		 * Create the DSP effects.
		 */
		errorCheck(system.createDSPByType(FMOD_DSP_TYPE_LOWPASS, dsplowpass));
		errorCheck(system.createDSPByType(FMOD_DSP_TYPE_CHORUS, dspchorus));

		/*
		 * Connect up the DSP network
		 */

		/*
		 * When a sound is played, a subnetwork is set up in the DSP network which looks like this.
		 * Wavetable is the drumloop sound, and it feeds its data from right to left.
		 * 
		 * [DSPHEAD]<------------[DSPCHANNELMIXER]
		 */
		errorCheck(system.getDSPHead(dsphead));
		errorCheck(dsphead.getInput(0, dspchannelmixer, null));

		/*
		 * Now disconnect channeldsp head from wavetable to look like this.
		 * 
		 * [DSPHEAD]           [DSPCHANNELMIXER]
		 */
		errorCheck(dsphead.disconnectFrom(dspchannelmixer));

		/*
		 * Now connect the 2 effects to channeldsp head.  
		 * Store the 2 connections this makes so we can set their speakerlevels later.
		 * 
		 *          [DSPLOWPASS]
		 *         /x           
		 * [DSPHEAD]           [DSPCHANNELMIXER]
		 *         \y           
		 *          [DSPCHORUS]
		 */
		errorCheck(dsphead.addInput(dsplowpass, dsplowpassconnection)); //x = dsplowpassconnection
		errorCheck(dsphead.addInput(dspchorus, dspchorusconnection)); //y = dspchorusconnection

		/*
		 * Now connect the wavetable to the 2 effects
		 * 
		 *          [DSPLOWPASS]
		 *         /x          \ 
		 * [DSPHEAD]           [DSPCHANNELMIXER]
		 *         \y          /
		 *          [DSPCHORUS]
		 */
		errorCheck(dsplowpass.addInput(dspchannelmixer, null)); //Null for connection - we dont care about it.
		errorCheck(dspchorus.addInput(dspchannelmixer, null)); //Null for connection - we dont care about it.
		
		/*
		 * Now the drumloop will be twice as loud, because it is being split into 2, then recombined at the end.
		 * What we really want is to only feed the dspchannelmixer->dsplowpass through the left speaker, and 
		 * dspchannelmixer->dspchorus to the right speaker.
		 * We can do that simply by setting the pan, or speaker levels of the connections.
		 *          [DSPLOWPASS]
		 *         /x=1,0      \ 
		 * [DSPHEAD]           [DSPCHANNELMIXER]
		 *         \y=0,1      /
		 *          [DSPCHORUS]
		 */
		{
			FloatBuffer leftinputon = newFloatBuffer(2);
			leftinputon.put(0, 1.0f);
			leftinputon.put(1, 0.0f);
			FloatBuffer rightinputon = newFloatBuffer(2);
			rightinputon.put(0, 0.0f);
			rightinputon.put(1, 1.0f);
			FloatBuffer inputsoff = newFloatBuffer(2);
			inputsoff.put(0, 0.0f);
			inputsoff.put(1, 0.0f);

			errorCheck(dsplowpassconnection.setLevels(FMOD_SPEAKER_FRONT_LEFT, leftinputon, 2));
			errorCheck(dsplowpassconnection.setLevels(FMOD_SPEAKER_FRONT_RIGHT, inputsoff, 2));

			errorCheck(dspchorusconnection.setLevels(FMOD_SPEAKER_FRONT_LEFT, inputsoff, 2));
			errorCheck(dspchorusconnection.setLevels(FMOD_SPEAKER_FRONT_RIGHT, rightinputon, 2));
		}

		errorCheck(dsplowpass.setBypass(true));
		errorCheck(dspchorus.setBypass(true));

		errorCheck(dsplowpass.setActive(true));
		errorCheck(dspchorus.setActive(true));

		/*
		 * Main loop.
		 */
		boolean exit = false;
		do {
			switch(getKey()) {
				case 'l':
				case 'L': {
					dsplowpass.setBypass(lowpass);

					lowpass = !lowpass;
					break;
				}
				case 'r':
				case 'R': {
					dspchorus.setBypass(chorus);

					chorus = !chorus;
					break;
				}
				case '[': {
					channel.getPan(buffer.asFloatBuffer());
					pan = buffer.getFloat(0);

					pan -= 0.1f;
					if(pan < -1) {
						pan = -1;
					}
					channel.setPan(pan);
					break;
				}
				case ']': {
					channel.getPan(buffer.asFloatBuffer());
					pan = buffer.getFloat(0);

					pan += 0.1f;
					if(pan > 1) {
						pan = 1;
					}
					channel.setPan(pan);
					break;
				}
				case 'e':
				case 'E':
					exit = true;
					break;
			}

			system.update();

			{
				system.getChannelsPlaying(buffer.asIntBuffer());
				int channelsplaying = buffer.getInt(0);

				printfr("Channels Playing %2d : Pan = %.02f", channelsplaying, pan);
			}

			try {
				Thread.sleep(10);
			}
			catch(InterruptedException e) {}
		}
		while(!exit && !deinit);

		stop();
	}

	public boolean isRunning() {
		return deinit;
		}
	public void stop() {
		if(!init || deinit) {
			return;
		}
		deinit = true;

		print("\n");

		/*
		 * Shut down
		 */
		if(!sound.isNull()) {
			errorCheck(sound.release());
		}

		if(!dsplowpass.isNull()) {
			errorCheck(dsplowpass.release());
		}
		if(!dspchorus.isNull()) {
			errorCheck(dspchorus.release());
		}

		if(!system.isNull()) {
			errorCheck(system.close());
			errorCheck(system.release());
		}

		printExit("Shutdown\n");
	}
}