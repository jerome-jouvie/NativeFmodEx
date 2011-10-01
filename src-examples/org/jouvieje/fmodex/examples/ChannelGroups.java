/*===============================================================================================
ChannelGroups Example
Copyright (c), Firelight Technologies Pty, Ltd 2004-2010.

This example shows how to put channels into channel groups, so that you can affect a group
of channels at a time instead of just one channel at a time.
===============================================================================================*/

package org.jouvieje.fmodex.examples;

import static org.jouvieje.fmodex.defines.FMOD_INITFLAGS.FMOD_INIT_NORMAL;
import static org.jouvieje.fmodex.defines.FMOD_MODE.FMOD_LOOP_NORMAL;
import static org.jouvieje.fmodex.defines.FMOD_MODE.FMOD_OPENMEMORY;
import static org.jouvieje.fmodex.defines.VERSIONS.FMOD_VERSION;
import static org.jouvieje.fmodex.defines.VERSIONS.NATIVEFMODEX_JAR_VERSION;
import static org.jouvieje.fmodex.defines.VERSIONS.NATIVEFMODEX_LIBRARY_VERSION;
import static org.jouvieje.fmodex.enumerations.FMOD_CHANNELINDEX.FMOD_CHANNEL_FREE;
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
public class ChannelGroups extends ConsoleGUI {
	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args) {
		new FmodExExampleFrame(new ChannelGroups());
	}

	private boolean init = false;
	private boolean deinit = false;

	System system = new System();
	Sound[] sounds = new Sound[6];
	ChannelGroup groupA = new ChannelGroup();
	ChannelGroup groupB = new ChannelGroup();

	public ChannelGroups() {
		super();
		initialize();
	}

	public JPanel getPanel() {
		return this;
	}

	public String getTitle() {
		return "FMOD Ex ChannelGroups example.";
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
		Channel[] channels = new Channel[6];
		ChannelGroup masterGroup = new ChannelGroup();
		int version;

		ByteBuffer buffer = newByteBuffer(SIZEOF_INT * 1);

		for(int i = 0; i < sounds.length; i++)
			sounds[i] = new Sound();
		for(int i = 0; i < channels.length; i++)
			channels[i] = new Channel();

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
		errorCheck(system.createSound(soundBuffer, FMOD_LOOP_NORMAL | FMOD_OPENMEMORY, exinfo, sounds[0]));
		soundBuffer = null;
		exinfo.release();

		soundBuffer = Medias.loadMediaIntoMemory("/Media/jaguar.wav");
		exinfo = FMOD_CREATESOUNDEXINFO.allocate();
		exinfo.setLength(soundBuffer.capacity());
		errorCheck(system.createSound(soundBuffer, FMOD_LOOP_NORMAL | FMOD_OPENMEMORY, exinfo, sounds[1]));
		soundBuffer = null;
		exinfo.release();

		soundBuffer = Medias.loadMediaIntoMemory("/Media/swish.wav");
		exinfo = FMOD_CREATESOUNDEXINFO.allocate();
		exinfo.setLength(soundBuffer.capacity());
		errorCheck(system.createSound(soundBuffer, FMOD_LOOP_NORMAL | FMOD_OPENMEMORY, exinfo, sounds[2]));
		soundBuffer = null;
		exinfo.release();

		soundBuffer = Medias.loadMediaIntoMemory("/Media/c.ogg");
		exinfo = FMOD_CREATESOUNDEXINFO.allocate();
		exinfo.setLength(soundBuffer.capacity());
		errorCheck(system.createSound(soundBuffer, FMOD_LOOP_NORMAL | FMOD_OPENMEMORY, exinfo, sounds[3]));
		soundBuffer = null;
		exinfo.release();

		soundBuffer = Medias.loadMediaIntoMemory("/Media/d.ogg");
		exinfo = FMOD_CREATESOUNDEXINFO.allocate();
		exinfo.setLength(soundBuffer.capacity());
		errorCheck(system.createSound(soundBuffer, FMOD_LOOP_NORMAL | FMOD_OPENMEMORY, exinfo, sounds[4]));
		soundBuffer = null;
		exinfo.release();

		soundBuffer = Medias.loadMediaIntoMemory("/Media/e.ogg");
		exinfo = FMOD_CREATESOUNDEXINFO.allocate();
		exinfo.setLength(soundBuffer.capacity());
		errorCheck(system.createSound(soundBuffer, FMOD_LOOP_NORMAL | FMOD_OPENMEMORY, exinfo, sounds[5]));
		soundBuffer = null;
		exinfo.release();

		errorCheck(system.createChannelGroup("Group A", groupA));
		errorCheck(system.createChannelGroup("Group B", groupB));
		errorCheck(system.getMasterChannelGroup(masterGroup));

		printf("===================================================================\n");
		printf("ChannelGroups Example.  Copyright (c) Firelight Technologies 2004-2009.\n");
		printf("===================================================================\n");
		printf("\n");
		printf("Group A : drumloop.wav, jaguar.wav, swish.wav\n");
		printf("Group B : c.ogg, d.ogg, e.ogg\n");
		printf("\n");
		printf("Press 'A' to mute/unmute group A\n");
		printf("Press 'B' to mute/unmute group B\n");
		printf("Press 'C' to mute/unmute group A and B (master group)\n");
		printf("Press 'E' to quit\n");
		printf("\n");

		/*
		 * Instead of being independent, set the group A and B to be children of the master group.
		 */
		errorCheck(masterGroup.addGroup(groupA));
		errorCheck(masterGroup.addGroup(groupB));

		/*
		 * Start all the sounds!
		 */
		for(int i = 0; i < 6; i++) {
			errorCheck(system.playSound(FMOD_CHANNEL_FREE, sounds[i], true, channels[i]));
			if(i < 3) {
				errorCheck(channels[i].setChannelGroup(groupA));
			}
			else {
				errorCheck(channels[i].setChannelGroup(groupB));
			}
			errorCheck(channels[i].setPaused(false));
		}

		/*
		 * Change the volume of each group, just because we can!  (And makes it less noise).
		 */
		errorCheck(groupA.setVolume(0.5f));
		errorCheck(groupB.setVolume(0.5f));

		/*
		 * Main loop.
		 */
		boolean muteA = true;
		boolean muteB = true;
		boolean muteMaster = true;

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
				case 'c':
				case 'C':
					masterGroup.setMute(muteMaster);

					muteMaster = !muteMaster;
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

		printf("\n");

		/*
		 * A little fade  (over 2 seconds)
		 */
		printf("Goodbye!\n");
		{
			float pitch = 1.0f;
			float vol = 1.0f;

			for(int i = 0; i < 200; i++) {
				masterGroup.setPitch(pitch);
				masterGroup.setVolume(vol);

				vol -= (1.0f / 200.0f);
				pitch -= (0.5f / 200.0f);

				try {
					Thread.sleep(10);
				}
				catch(InterruptedException e) {}
			}
		}

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
		for(int i = 0; i < 6; i++) {
			if(!sounds[i].isNull()) {
				errorCheck(sounds[i].release());
			}
		}

		if(!groupA.isNull()) {
			errorCheck(groupA.release());
		}
		if(!groupB.isNull()) {
			errorCheck(groupB.release());
		}

		if(!system.isNull()) {
			errorCheck(system.close());
			errorCheck(system.release());
		}

		printExit("Shutdown\n");
	}
}