/*===============================================================================================
Real-time stitching example
Copyright (c), Firelight Technologies Pty, Ltd 2004-2010.

This example shows how you can create your own multi-subsound stream, then in realtime replace
each the subsound as it plays them.  Using a looping sentence, it will seamlessly stich between
2 subsounds in this example, and each time it switches to a new sound, it will replace the old
one with another sound in our list.

These sounds can go on forever as long as they are the same bitdepth (when decoded) and number
of channels (ie mono / stereo).  The reason for this is the hardware channel cannot change 
formats mid sentence, and using different hardware channels would mean it wouldn't be gapless.

===============================================================================================*/

package org.jouvieje.fmodex.examples;

import static org.jouvieje.fmodex.defines.FMOD_INITFLAGS.FMOD_INIT_NORMAL;
import static org.jouvieje.fmodex.defines.FMOD_MODE.FMOD_DEFAULT;
import static org.jouvieje.fmodex.defines.FMOD_MODE.FMOD_LOOP_NORMAL;
import static org.jouvieje.fmodex.defines.FMOD_MODE.FMOD_OPENMEMORY;
import static org.jouvieje.fmodex.defines.FMOD_MODE.FMOD_OPENUSER;
import static org.jouvieje.fmodex.defines.FMOD_TIMEUNIT.FMOD_TIMEUNIT_BUFFERED;
import static org.jouvieje.fmodex.defines.FMOD_TIMEUNIT.FMOD_TIMEUNIT_SENTENCE_SUBSOUND;
import static org.jouvieje.fmodex.defines.VERSIONS.FMOD_VERSION;
import static org.jouvieje.fmodex.defines.VERSIONS.NATIVEFMODEX_JAR_VERSION;
import static org.jouvieje.fmodex.defines.VERSIONS.NATIVEFMODEX_LIBRARY_VERSION;
import static org.jouvieje.fmodex.enumerations.FMOD_CHANNELINDEX.FMOD_CHANNEL_FREE;
import static org.jouvieje.fmodex.enumerations.FMOD_SOUND_FORMAT.FMOD_SOUND_FORMAT_PCM16;
import static org.jouvieje.fmodex.utils.BufferUtils.newByteBuffer;
import static org.jouvieje.fmodex.utils.BufferUtils.newIntBuffer;
import static org.jouvieje.fmodex.utils.BufferUtils.SIZEOF_INT;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

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
 * Based on FMOD Ex C++ example. Ported to Java with NativeFmodEx by Jérôme JOUVIE (Jouvieje.
 * 
 * @author Jérôme JOUVIE (Jouvieje)
 * @site   http://jerome.jouvie.free.fr/
 * @mail   jerome.jouvie@gmail.com
 */
public class RealtimeStitching extends ConsoleGUI {
	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args) {
		new FmodExExampleFrame(new RealtimeStitching());
	}

	private boolean init = false;
	private boolean deinit = false;

	private System system = new System();
	private Sound sound = new Sound();
	private ByteBuffer[] soundBuffer = new ByteBuffer[2];

	private static String c = "/Media/c.ogg";
	private static String d = "/Media/d.ogg";
	private static String e = "/Media/e.ogg";
	private static String[] soundname = new String[]{e, /* Ma-    */
	d, /* ry     */
	c, /* had    */
	d, /* a      */
	e, /* lit-   */
	e, /* tle    */
	e, /* lamb,  */
	e, /* .....  */
	d, /* lit-   */
	d, /* tle    */
	d, /* lamb,  */
	d, /* .....  */
	e, /* lit-   */
	e, /* tle    */
	e, /* lamb,  */
	e, /* .....  */

	e, /* Ma-    */
	d, /* ry     */
	c, /* had    */
	d, /* a      */
	e, /* lit-   */
	e, /* tle    */
	e, /* lamb,  */
	e, /* its    */
	d, /* fleece */
	d, /* was    */
	e, /* white  */
	d, /* as     */
	c, /* snow.  */
	c, /* .....  */
	c, /* .....  */
	c, /* .....  */
	};

	public RealtimeStitching() {
		super();
		initialize();
	}

	public JPanel getPanel() {
		return this;
	}

	public String getTitle() {
		return "FMOD Ex RealtimeStitching example.";
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
		Sound[] subsound = new Sound[2];
		subsound[0] = new Sound();
		subsound[1] = new Sound();
		FMOD_CREATESOUNDEXINFO exinfo;
		FMOD_RESULT result;

		ByteBuffer buffer = newByteBuffer(SIZEOF_INT);

		/*
		 * Create a System object and initialize.
		 */
		result = FmodEx.System_Create(system);
		errorCheck(result);

		result = system.getVersion(buffer.asIntBuffer());
		errorCheck(result);
		int version = buffer.getInt(0);

		if(version < FMOD_VERSION) {
			printfExit("Error!  You are using an old version of FMOD %08x.  This program requires %08x\n", version,
					FMOD_VERSION);
			return;
		}

		result = system.init(1, FMOD_INIT_NORMAL, null);
		errorCheck(result);

		/*
		 * Set up the FMOD_CREATESOUNDEXINFO structure for the user stream with room for 2 subsounds. (our subsound double buffer)
		 */
		exinfo = FMOD_CREATESOUNDEXINFO.allocate();
		exinfo.setDefaultFrequency(44100);
		exinfo.setNumSubsounds(2);
		exinfo.setNumChannels(1);
		exinfo.setFormat(FMOD_SOUND_FORMAT_PCM16);

		/*
		 * Create the 'parent' stream that contains the substreams.  Set it to loop so that it loops between subsound 0 and 1.
		 */
		result = system.createStream((String)null, FMOD_LOOP_NORMAL | FMOD_OPENUSER, exinfo, sound);
		errorCheck(result);
		exinfo.release();

		/*
		 * Add 2 of our streams as children of the parent.  They should be the same format (ie mono/stereo and bitdepth) as the parent sound.
		 * When subsound 0 has finished and it is playing subsound 1, we will swap subsound 0 with a new sound, and the same for when subsound 1 has finished,
		 * causing a continual double buffered flip, which means continuous sound.
		 */
		soundBuffer[0] = Medias.loadMediaIntoMemory(soundname[0]);
		exinfo = FMOD_CREATESOUNDEXINFO.allocate();
		exinfo.setLength(soundBuffer[0].capacity());
		result = system.createStream(soundBuffer[0], FMOD_DEFAULT | FMOD_OPENMEMORY, exinfo, subsound[0]);
		errorCheck(result);
		exinfo.release();

		soundBuffer[1] = Medias.loadMediaIntoMemory(soundname[1]);
		exinfo = FMOD_CREATESOUNDEXINFO.allocate();
		exinfo.setLength(soundBuffer[1].capacity());
		result = system.createStream(soundBuffer[1], FMOD_DEFAULT | FMOD_OPENMEMORY, exinfo, subsound[1]);
		errorCheck(result);
		exinfo.release();

		result = sound.setSubSound(0, subsound[0]);
		errorCheck(result);

		result = sound.setSubSound(1, subsound[1]);
		errorCheck(result);

		/*
		 * Set up the gapless sentence to contain these first 2 streams.
		 */
		{
			IntBuffer soundlist = newIntBuffer(2);
			soundlist.put(0);
			soundlist.put(1);
			soundlist.rewind();

			result = sound.setSubSoundSentence(soundlist, 2);
			errorCheck(result);
		}

		int subsoundid = 0;
		int sentenceid = 2; /* The next sound to be appeneded to the stream. */

		printf("=============================================================================\n");
		printf("Real-time stitching example.  Copyright (c) Firelight Technologies 2004-2009.\n");
		printf("=============================================================================\n");
		printf("\n");
		printf("Press space to pause, e to quit\n");
		printf("Press Enter to validate your choice\n");
		printf("\n");

		printf("Inserted subsound %d / 2 with sound %d / %d\n", 0, 0, soundname.length);
		printf("Inserted subsound %d / 2 with sound %d / %d\n", 1, 1, soundname.length);

		/*
		 * Play the sound.
		 */
		result = system.playSound(FMOD_CHANNEL_FREE, sound, false, channel);
		errorCheck(result);

		/*
		 * Main loop.
		 */
		boolean exit = false;
		do {
			switch(getKey()) {
				case ' ':
					channel.getPaused(buffer);
					channel.setPaused(buffer.get(0) == 0);
					break;
				case 'e':
				case 'E':
					exit = true;
					break;
			}

			system.update();

			/*
			 * Replace the subsound that just finished with a new subsound, to create endless seamless stitching!
			 * 
			 * Note that this polls the currently playing subsound using the FMOD_TIMEUNIT_BUFFERED flag.  
			 * Remember streams are decoded / buffered ahead in advance! 
			 * Don't use the 'audible time' which is FMOD_TIMEUNIT_SENTENCE_SUBSOUND by itself.  When streaming, sound is 
			 * processed ahead of time, and things like stream buffer / sentence manipulation (as done below) is required 
			 * to be in 'buffered time', or else there will be synchronization problems and you might end up releasing a
			 * sub-sound that is still playing!
			 */
			result = channel
					.getPosition(buffer.asIntBuffer(), FMOD_TIMEUNIT_SENTENCE_SUBSOUND | FMOD_TIMEUNIT_BUFFERED);
			errorCheck(result);
			int currentsubsoundid = buffer.getInt(0);

			if(currentsubsoundid != subsoundid) {
				/* 
				 * Release the sound that isn't playing any more. 
				 */
				result = subsound[subsoundid].release();
				errorCheck(result);

				/* 
				 * Replace it with a new sound in our list.
				 */
				soundBuffer[subsoundid] = Medias.loadMediaIntoMemory(soundname[sentenceid]);
				exinfo = FMOD_CREATESOUNDEXINFO.allocate();
				exinfo.setLength(soundBuffer[subsoundid].capacity());
				result = system.createStream(soundBuffer[subsoundid], FMOD_DEFAULT | FMOD_OPENMEMORY, exinfo,
						subsound[subsoundid]);
				errorCheck(result);
				exinfo.release();

				result = sound.setSubSound(subsoundid, subsound[subsoundid]);
				errorCheck(result);

				printf("Replacing subsound %d / 2 with sound %d / %d\n", subsoundid, sentenceid, soundname.length);

				sentenceid++;
				if(sentenceid >= soundname.length) {
					sentenceid = 0;
				}

				subsoundid = currentsubsoundid;
			}

			try {
				Thread.sleep(50);
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
		 *  Shut down
		 */
		FMOD_RESULT result;
		if(!sound.isNull()) {
			result = sound.release(); /* Freeing a parent subsound also frees its children. */
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