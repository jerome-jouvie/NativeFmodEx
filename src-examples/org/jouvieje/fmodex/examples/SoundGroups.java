/*===============================================================================================
soundgroups Example
Copyright (c), Firelight Technologies Pty, Ltd 2004-2010.

This example shows how to use the sound group behavior modes
===============================================================================================*/
package org.jouvieje.fmodex.examples;

import static org.jouvieje.fmodex.defines.FMOD_INITFLAGS.FMOD_INIT_NORMAL;
import static org.jouvieje.fmodex.defines.FMOD_MODE.FMOD_LOOP_NORMAL;
import static org.jouvieje.fmodex.defines.FMOD_MODE.FMOD_OPENMEMORY;
import static org.jouvieje.fmodex.defines.FMOD_MODE.FMOD_HARDWARE;
import static org.jouvieje.fmodex.defines.VERSIONS.FMOD_VERSION;
import static org.jouvieje.fmodex.defines.VERSIONS.NATIVEFMODEX_JAR_VERSION;
import static org.jouvieje.fmodex.defines.VERSIONS.NATIVEFMODEX_LIBRARY_VERSION;
import static org.jouvieje.fmodex.enumerations.FMOD_CHANNELINDEX.FMOD_CHANNEL_FREE;
import static org.jouvieje.fmodex.enumerations.FMOD_RESULT.*;
import static org.jouvieje.fmodex.enumerations.FMOD_SOUNDGROUP_BEHAVIOR.*;
import static org.jouvieje.fmodex.utils.BufferUtils.newByteBuffer;
import static org.jouvieje.fmodex.utils.BufferUtils.SIZEOF_INT;

import java.nio.ByteBuffer;
import javax.swing.JPanel;

import org.jouvieje.fmodex.Channel;
import org.jouvieje.fmodex.FmodEx;
import org.jouvieje.fmodex.Init;
import org.jouvieje.fmodex.Sound;
import org.jouvieje.fmodex.SoundGroup;
import org.jouvieje.fmodex.System;

import org.jouvieje.fmodex.enumerations.FMOD_RESULT;
import org.jouvieje.fmodex.enumerations.FMOD_SOUNDGROUP_BEHAVIOR;
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
public class SoundGroups extends ConsoleGUI {
	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args) {
		new FmodExExampleFrame(new SoundGroups());
	}

	private boolean init = false;
	private boolean deinit = false;

	public SoundGroups() {
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

		System system = new System();
		Sound sound1 = new Sound();
		Sound sound2 = new Sound();
		Sound sound3 = new Sound();
		SoundGroup soundgroup = new SoundGroup();
		Channel[] channel = new Channel[3];
		FMOD_RESULT result;
		int version;

		ByteBuffer buffer = newByteBuffer(SIZEOF_INT);

		printf("======================================================================\n");
		printf("soundgroups Example.  Copyright (c) Firelight Technologies 2004-2009.\n");
		printf("======================================================================\n");
		printf("This example plays 3 sounds in a sound group, demonstrating the effect\n");
		printf("of the three different sound group behavior modes\n");
		printf("======================================================================\n\n");

		/*
		    Create a System object and initialize.
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

		result = system.init(100, FMOD_INIT_NORMAL, null);
		errorCheck(result);

		/*
		    Load some sound files from the hard disk.
		 */
		{
			ByteBuffer soundBuffer;
			FMOD_CREATESOUNDEXINFO exinfo;

			soundBuffer = Medias.loadMediaIntoMemory("/Media/drumloop.wav");
			exinfo = FMOD_CREATESOUNDEXINFO.allocate();
			exinfo.setLength(soundBuffer.capacity());
			result = system
					.createSound(soundBuffer, FMOD_HARDWARE | FMOD_LOOP_NORMAL | FMOD_OPENMEMORY, exinfo, sound1);
			errorCheck(result);
			soundBuffer = null;
			exinfo.release();

			soundBuffer = Medias.loadMediaIntoMemory("/Media/jaguar.wav");
			exinfo = FMOD_CREATESOUNDEXINFO.allocate();
			exinfo.setLength(soundBuffer.capacity());
			result = system
					.createSound(soundBuffer, FMOD_HARDWARE | FMOD_LOOP_NORMAL | FMOD_OPENMEMORY, exinfo, sound2);
			errorCheck(result);
			soundBuffer = null;
			exinfo.release();

			soundBuffer = Medias.loadMediaIntoMemory("/Media/swish.wav");
			exinfo = FMOD_CREATESOUNDEXINFO.allocate();
			exinfo.setLength(soundBuffer.capacity());
			result = system
					.createSound(soundBuffer, FMOD_HARDWARE | FMOD_LOOP_NORMAL | FMOD_OPENMEMORY, exinfo, sound3);
			errorCheck(result);
			soundBuffer = null;
			exinfo.release();
		}

		/* 
		    Create the sound group with the following attributes:
		      Name       = MyGroup
		      MaxAudible = 1
		      Behavior   = Mute 
		 */
		result = system.createSoundGroup("MyGroup", soundgroup);
		errorCheck(result);

		result = soundgroup.setMaxAudible(1);
		errorCheck(result);

		result = soundgroup.setMaxAudibleBehavior(FMOD_SOUNDGROUP_BEHAVIOR_MUTE);
		errorCheck(result);

		result = soundgroup.setMuteFadeSpeed(2);
		errorCheck(result);

		/*
		    Put the sounds in the sound group
		 */
		result = sound1.setSoundGroup(soundgroup);
		errorCheck(result);

		result = sound2.setSoundGroup(soundgroup);
		errorCheck(result);

		result = sound3.setSoundGroup(soundgroup);
		errorCheck(result);

		/*
		    Play the sounds (two will be muted because of the behavior mode)
		 */
		channel[0] = new Channel();
		result = system.playSound(FMOD_CHANNEL_FREE, sound1, false, channel[0]);
		errorCheck(result);

		channel[1] = new Channel();
		result = system.playSound(FMOD_CHANNEL_FREE, sound2, false, channel[1]);
		errorCheck(result);

		channel[2] = new Channel();
		result = system.playSound(FMOD_CHANNEL_FREE, sound3, false, channel[2]);
		errorCheck(result);

		/*
		    Display help
		 */
		printf("=========================================================================\n");
		printf("Press 1        BEAVIOR_FAIL \n");
		printf("      2        BEAVIOR_MUTE \n");
		printf("      3        BEAVIOR_STEALLOWEST\n");
		printf("      Q        Play/stop drumloop sound\n");
		printf("      W        Play/stop Jaguar sound\n");
		printf("      R        Play/stop shwish sound\n");
		printf("      E        Quit\n");
		printf("=========================================================================\n");

		boolean exit = false;
		do {
			float audibility;
			int index;

			switch(getKey()) {
				case '1': {
					result = soundgroup.setMaxAudibleBehavior(FMOD_SOUNDGROUP_BEHAVIOR_FAIL);
					errorCheck(result);
				}
					break;
				case '2': {
					result = soundgroup.setMaxAudibleBehavior(FMOD_SOUNDGROUP_BEHAVIOR_MUTE);
					errorCheck(result);
				}
					break;
				case '3': {
					result = soundgroup.setMaxAudibleBehavior(FMOD_SOUNDGROUP_BEHAVIOR_STEALLOWEST);
					errorCheck(result);
				}
					break;
				case 'q':
				case 'Q': {
					channel[0].getIndex(buffer.asIntBuffer());
					index = buffer.getInt(0);
					if(index == 0) {
						result = system.playSound(FMOD_CHANNEL_FREE, sound1, false, channel[0]);
						if(result != FMOD_ERR_MAXAUDIBLE) {
							errorCheck(result);
						}
					}
					else {
						result = channel[0].stop();
						errorCheck(result);
					}
				}
					break;
				case 'w':
				case 'W': {
					channel[1].getIndex(buffer.asIntBuffer());
					index = buffer.getInt(0);
					if(index == 0) {
						result = system.playSound(FMOD_CHANNEL_FREE, sound2, false, channel[1]);
						if(result != FMOD_ERR_MAXAUDIBLE) {
							errorCheck(result);
						}
					}
					else {
						result = channel[1].stop();
						errorCheck(result);
					}
				}
					break;
				case 'r':
				case 'R': {
					channel[2].getIndex(buffer.asIntBuffer());
					index = buffer.getInt(0);
					if(index == 0) {
						result = system.playSound(FMOD_CHANNEL_FREE, sound3, false, channel[2]);
						if(result != FMOD_ERR_MAXAUDIBLE) {
							errorCheck(result);
						}
					}
					else {
						result = channel[2].stop();
						errorCheck(result);
					}
				}
					break;
				case 'e':
				case 'E': {
					exit = true;
				}
					break;
			}

			// print out a small visual display
			{
				String s1;
				String[] s2 = new String[3];
				int i;

				FMOD_SOUNDGROUP_BEHAVIOR behavior;
				FMOD_SOUNDGROUP_BEHAVIOR[] behaviors = new FMOD_SOUNDGROUP_BEHAVIOR[1];
				soundgroup.getMaxAudibleBehavior(behaviors);
				behavior = behaviors[0];

				if(behavior == FMOD_SOUNDGROUP_BEHAVIOR_FAIL) {
					s1 = "FAIL";
				}
				else if(behavior == FMOD_SOUNDGROUP_BEHAVIOR_MUTE) {
					s1 = "MUTE";
				}
				else if(behavior == FMOD_SOUNDGROUP_BEHAVIOR_STEALLOWEST) {
					s1 = "STEAL";
				}
				else {
					s1 = "";
				}

				for(i = 0; i < 3; i++) {
					channel[i].getAudibility(buffer.asFloatBuffer());
					audibility = buffer.getFloat(0);

					if(audibility == 0) {
						channel[i].getIndex(buffer.asIntBuffer());
						index = buffer.getInt(0);
						if(index == 0) {
							s2[i] = "STOP";
						}
						else {
							s2[i] = "MUTE";
						}
					}
					else {
						s2[i] = "PLAY";
					}
				}

				printfr("MODE:%6s      | SOUND1: %s | SOUND2: %s | SOUND3: %s |", s1, s2[0], s2[1], s2[2]);
			}

			result = system.update();
			errorCheck(result);

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

		printExit("Shutdown\n");
	}
}
