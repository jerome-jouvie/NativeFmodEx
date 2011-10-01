/*===============================================================================================
Multi Speaker Output Example
Copyright (c), Firelight Technologies Pty, Ltd 2004-2010.

This example shows how to play sounds in multiple speakers, and also how to even assign 
sound subchannels, such as those in a stereo sound to different individual speakers.
===============================================================================================*/

package org.jouvieje.fmodex.examples;

import static org.jouvieje.fmodex.defines.FMOD_INITFLAGS.FMOD_INIT_NORMAL;
import static org.jouvieje.fmodex.defines.FMOD_MODE.FMOD_2D;
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
import static org.jouvieje.fmodex.enumerations.FMOD_SPEAKER.FMOD_SPEAKER_FRONT_CENTER;
import static org.jouvieje.fmodex.enumerations.FMOD_SPEAKER.FMOD_SPEAKER_FRONT_LEFT;
import static org.jouvieje.fmodex.enumerations.FMOD_SPEAKER.FMOD_SPEAKER_FRONT_RIGHT;
import static org.jouvieje.fmodex.enumerations.FMOD_SPEAKERMODE.FMOD_SPEAKERMODE_5POINT1;
import static org.jouvieje.fmodex.enumerations.FMOD_SPEAKERMODE.FMOD_SPEAKERMODE_7POINT1;
import static org.jouvieje.fmodex.enumerations.FMOD_SPEAKERMODE.FMOD_SPEAKERMODE_MONO;
import static org.jouvieje.fmodex.enumerations.FMOD_SPEAKERMODE.FMOD_SPEAKERMODE_QUAD;
import static org.jouvieje.fmodex.enumerations.FMOD_SPEAKERMODE.FMOD_SPEAKERMODE_STEREO;
import static org.jouvieje.fmodex.enumerations.FMOD_SPEAKERMODE.FMOD_SPEAKERMODE_SURROUND;
import static org.jouvieje.fmodex.utils.BufferUtils.newByteBuffer;
import static org.jouvieje.fmodex.utils.BufferUtils.SIZEOF_FLOAT;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

import javax.swing.JPanel;

import org.jouvieje.fmodex.Channel;
import org.jouvieje.fmodex.FmodEx;
import org.jouvieje.fmodex.Init;
import org.jouvieje.fmodex.Sound;
import org.jouvieje.fmodex.System;

import org.jouvieje.fmodex.enumerations.FMOD_RESULT;
import org.jouvieje.fmodex.enumerations.FMOD_SPEAKERMODE;
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
public class MultiSpeakerOutput extends ConsoleGUI {
	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args) {
		new FmodExExampleFrame(new MultiSpeakerOutput());
	}

	private boolean init = false;
	private boolean deinit = false;

	private System system = new System();
	private Sound sound1 = new Sound();
	private Sound sound2 = new Sound();

	public MultiSpeakerOutput() {
		super();
		initialize();
	}

	public JPanel getPanel() {
		return this;
	}

	public String getTitle() {
		return "FMOD Ex MultiSpeakerOutput example.";
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
		FMOD_SPEAKERMODE[] speakermode = new FMOD_SPEAKERMODE[1];
		int version;

		ByteBuffer buffer = newByteBuffer(2 * SIZEOF_FLOAT);

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
		   Choose the speaker mode selected by the Windows control panel.
		*/
		result = system.getDriverCaps(0, null, null, null, speakermode);
		errorCheck(result);

		result = system.setSpeakerMode(speakermode[0]);
		errorCheck(result);

		result = system.init(32, FMOD_INIT_NORMAL, null);
		errorCheck(result);

		soundBuffer = Medias.loadMediaIntoMemory("/Media/drumloop.wav");
		exinfo = FMOD_CREATESOUNDEXINFO.allocate();
		exinfo.setLength(soundBuffer.capacity());
		result = system.createSound(soundBuffer, FMOD_SOFTWARE | FMOD_2D | FMOD_OPENMEMORY, exinfo, sound1);
		errorCheck(result);
		result = sound1.setMode(FMOD_LOOP_OFF);
		errorCheck(result);
		soundBuffer = null;
		exinfo.release();

		soundBuffer = Medias.loadMediaIntoMemory("/Media/stereo.ogg");
		exinfo = FMOD_CREATESOUNDEXINFO.allocate();
		exinfo.setLength(soundBuffer.capacity());
		result = system.createSound(soundBuffer, FMOD_SOFTWARE | FMOD_2D | FMOD_OPENMEMORY, exinfo, sound2);
		errorCheck(result);
		soundBuffer = null;
		exinfo.release();

		printf("==============================================================================\n");
		printf("Multi Speaker Output Example.  Copyright (c) Firelight Technologies 2004-2009.\n");
		printf("==============================================================================\n");
		printf("\n");
		if(speakermode[0] == FMOD_SPEAKERMODE_MONO) {
			printf("Using control panel speaker mode : MONO.\n");
			printf("\n");
			printf("Note! This output mode is very limited in its capability.\n");
			printf("Most functionality of this demo is only realized with at least FMOD_SPEAKERMODE_QUAD\n");
			printf("and above.\n");
		}
		else if(speakermode[0] == FMOD_SPEAKERMODE_STEREO) {
			printf("Using control panel speaker mode : STEREO.\n");
			printf("\n");
			printf("Note! This output mode is very limited in its capability.\n");
			printf("Most functionality of this demo is only realized with FMOD_SPEAKERMODE_QUAD\n");
			printf("and above.\n");
		}
		else if(speakermode[0] == FMOD_SPEAKERMODE_QUAD) {
			printf("Using control panel speaker mode : QUAD.\n");
			printf("Side left, side right, center and subwoofer mix will be disabled.\n");
		}
		else if(speakermode[0] == FMOD_SPEAKERMODE_SURROUND) {
			printf("Using control panel speaker mode : SURROUND.\n");
			printf("Side left, side right and subwoofer mix will be disabled.\n");
		}
		else if(speakermode[0] == FMOD_SPEAKERMODE_5POINT1) {
			printf("Using control panel speaker mode : 5.1 surround.\n");
			printf("Side left and right mix will be disabled..\n");
		}
		else if(speakermode[0] == FMOD_SPEAKERMODE_7POINT1) {
			printf("Using control panel speaker mode : 7.1 surround.\n");
			printf("Full capability.\n");
		}
		printf("\n");

		printf("Press '1' to play a mono sound on the FRONT LEFT speaker.\n");
		printf("Press '2' to play a mono sound on the FRONT RIGHT speaker.\n");
		if(speakermode[0].asInt() >= FMOD_SPEAKERMODE_SURROUND.asInt()) {
			printf("Press '3' to play a mono sound on the CENTER speaker.\n");
		}
		else {
			printf("- CENTER Disabled\n");
		}
		if(speakermode[0].asInt() >= FMOD_SPEAKERMODE_QUAD.asInt()) {
			printf("Press '4' to play a mono sound on the REAR LEFT speaker.\n");
			printf("Press '5' to play a mono sound on the REAR RIGHT speaker.\n");
		}
		else {
			printf("- REAR LEFT Disabled\n");
			printf("- REAR RIGHT Disabled\n");
		}
		if(speakermode[0].asInt() >= FMOD_SPEAKERMODE_7POINT1.asInt()) {
			printf("Press '6' to play a mono sound on the SIDE LEFT speaker.\n");
			printf("Press '7' to play a mono sound on the SIDE RIGHT speaker.\n");
		}
		else {
			printf("- SIDE LEFT Disabled\n");
			printf("- SIDE RIGHT Disabled\n");
		}

		printf("\n");
		printf("Press '8' to play a stereo sound on the front speakers.\n");
		printf("Press '9' to play a stereo sound on the front speakers but channel swapped.\n");
		if(speakermode[0].asInt() >= FMOD_SPEAKERMODE_SURROUND.asInt()) {
			printf("Press '0' to play the right part of a stereo sound on the CENTER speaker.\n");
		}
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

					result = channel.setSpeakerMix(1.0f, 0, 0, 0, 0, 0, 0, 0);
					errorCheck(result);

					result = channel.setPaused(false);
					errorCheck(result);
					break;
				}
				case '2': {
					result = system.playSound(FMOD_CHANNEL_FREE, sound1, true, channel);
					errorCheck(result);

					result = channel.setSpeakerMix(0, 1.0f, 0, 0, 0, 0, 0, 0);
					errorCheck(result);

					result = channel.setPaused(false);
					errorCheck(result);
					break;
				}
				case '3': {
					if(speakermode[0].asInt() >= FMOD_SPEAKERMODE_SURROUND.asInt()) /* All formats that have a center speaker. */
					{
						result = system.playSound(FMOD_CHANNEL_FREE, sound1, true, channel);
						errorCheck(result);

						result = channel.setSpeakerMix(0, 0, 1.0f, 0, 0, 0, 0, 0);
						errorCheck(result);

						result = channel.setPaused(false);
						errorCheck(result);
					}
					break;
				}
				case '4': {
					if(speakermode[0].asInt() >= FMOD_SPEAKERMODE_QUAD.asInt()) {
						result = system.playSound(FMOD_CHANNEL_FREE, sound1, true, channel);
						errorCheck(result);

						result = channel.setSpeakerMix(0, 0, 0, 0, 1.0f, 0, 0, 0);
						errorCheck(result);

						result = channel.setPaused(false);
						errorCheck(result);
					}
					break;
				}
				case '5': {
					if(speakermode[0].asInt() >= FMOD_SPEAKERMODE_QUAD.asInt()) {
						result = system.playSound(FMOD_CHANNEL_FREE, sound1, true, channel);
						errorCheck(result);

						result = channel.setSpeakerMix(0, 0, 0, 0, 0, 1.0f, 0, 0);
						errorCheck(result);

						result = channel.setPaused(false);
						errorCheck(result);
					}
					break;
				}
				case '6': {
					if(speakermode[0].asInt() >= FMOD_SPEAKERMODE_7POINT1.asInt()) {
						result = system.playSound(FMOD_CHANNEL_FREE, sound1, true, channel);
						errorCheck(result);

						result = channel.setSpeakerMix(0, 0, 0, 0, 0, 0, 1.0f, 0);
						errorCheck(result);

						result = channel.setPaused(false);
						errorCheck(result);
					}
					break;
				}
				case '7': {
					if(speakermode[0].asInt() >= FMOD_SPEAKERMODE_7POINT1.asInt()) {
						result = system.playSound(FMOD_CHANNEL_FREE, sound1, true, channel);
						errorCheck(result);

						result = channel.setSpeakerMix(0, 0, 0, 0, 0, 0, 0, 1.0f);
						errorCheck(result);

						result = channel.setPaused(false);
						errorCheck(result);
					}
					break;
				}
				case '8': {
					result = system.playSound(FMOD_CHANNEL_FREE, sound2, true, channel);
					errorCheck(result);

					/*
					 * By default a stereo sound would play in all right and all left speakers, so this forces it to just the front.
					 */
					result = channel.setSpeakerMix(1.0f, 1.0f, 0, 0, 0, 0, 0, 0);
					errorCheck(result);

					result = channel.setPaused(false);
					errorCheck(result);

					break;
				}
				case '9': {
					result = system.playSound(FMOD_CHANNEL_FREE, sound2, true, channel);
					errorCheck(result);

					/*
					 * Clear out all speakers first.
					 */
					result = channel.setSpeakerMix(0, 0, 0, 0, 0, 0, 0, 0);
					errorCheck(result);

					/*
					 * Put the left channel of the sound in the right speaker.
					 */
					{
						/* This array represents the source stereo sound.  l/r */
						FloatBuffer levels = buffer.asFloatBuffer();
						levels.put(0, 0);
						levels.put(1, 1.0f);

						result = channel.setSpeakerLevels(FMOD_SPEAKER_FRONT_LEFT, levels, 2);
						errorCheck(result);
					}
					/*
					 * Put the right channel of the sound in the left speaker.
					 */
					{
						/* This array represents the source stereo sound.  l/r */
						FloatBuffer levels = buffer.asFloatBuffer();
						levels.put(0, 1.0f);
						levels.put(1, 0);

						result = channel.setSpeakerLevels(FMOD_SPEAKER_FRONT_RIGHT, levels, 2);
						errorCheck(result);
					}

					result = channel.setPaused(false);
					errorCheck(result);

					break;
				}
				case '0': {
					if(speakermode[0].asInt() >= FMOD_SPEAKERMODE_SURROUND.asInt()) /* All formats that have a center speaker. */
					{
						result = system.playSound(FMOD_CHANNEL_FREE, sound2, true, channel);
						errorCheck(result);

						/*
						 * Clear out all speakers first.
						 */
						result = channel.setSpeakerMix(0, 0, 0, 0, 0, 0, 0, 0);
						errorCheck(result);

						/*
						 *  Put the left channel of the sound in the right speaker.
						 */
						{
							/* This array represents the source stereo sound.  l/r */
							FloatBuffer levels = buffer.asFloatBuffer();
							levels.put(0, 0);
							levels.put(1, 1.0f);

							result = channel.setSpeakerLevels(FMOD_SPEAKER_FRONT_CENTER, levels, 2);
							errorCheck(result);
						}

						result = channel.setPaused(false);
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
				int ms = 0, lenms = 0;
				boolean playing = false;
				boolean paused = false;
				int channelsplaying = 0;

				if(channel != null && !channel.isNull()) {
					Sound currentsound = new Sound();

					result = channel.isPlaying(buffer);
					if((result != FMOD_OK) && (result != FMOD_ERR_INVALID_HANDLE)
							&& (result != FMOD_ERR_CHANNEL_STOLEN)) errorCheck(result);
					playing = buffer.get(0) != 0;

					result = channel.getPaused(buffer);
					if((result != FMOD_OK) && (result != FMOD_ERR_INVALID_HANDLE)
							&& (result != FMOD_ERR_CHANNEL_STOLEN)) errorCheck(result);
					paused = buffer.get(0) != 0;

					result = channel.getPosition(buffer.asIntBuffer(), FMOD_TIMEUNIT_MS);
					if((result != FMOD_OK) && (result != FMOD_ERR_INVALID_HANDLE)
							&& (result != FMOD_ERR_CHANNEL_STOLEN)) errorCheck(result);
					ms = buffer.getInt(0);

					channel.getCurrentSound(currentsound);
					if(!currentsound.isNull()) {
						result = currentsound.getLength(buffer.asIntBuffer(), FMOD_TIMEUNIT_MS);
						if((result != FMOD_OK) && (result != FMOD_ERR_INVALID_HANDLE)
								&& (result != FMOD_ERR_CHANNEL_STOLEN)) errorCheck(result);
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
		if(!sound1.isNull()) {
			result = sound1.release();
			errorCheck(result);
		}
		if(!sound2.isNull()) {
			result = sound2.release();
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