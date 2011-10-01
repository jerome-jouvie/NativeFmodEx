/*===============================================================================================
User Created Sound Example
Copyright (c), Firelight Technologies Pty, Ltd 2004-2010.

This example shows how create a sound with data filled by the user.
It shows a user created static sample, followed by a user created stream.
The former allocates all memory needed for the sound and is played back as a static sample, 
while the latter streams the data in chunks as it plays, using far less memory.
===============================================================================================*/

package org.jouvieje.fmodex.examples;

import static java.lang.Math.sin;
import static org.jouvieje.fmodex.defines.FMOD_INITFLAGS.FMOD_INIT_NORMAL;
import static org.jouvieje.fmodex.defines.FMOD_MODE.FMOD_2D;
import static org.jouvieje.fmodex.defines.FMOD_MODE.FMOD_CREATESTREAM;
import static org.jouvieje.fmodex.defines.FMOD_MODE.FMOD_HARDWARE;
import static org.jouvieje.fmodex.defines.FMOD_MODE.FMOD_LOOP_NORMAL;
import static org.jouvieje.fmodex.defines.FMOD_MODE.FMOD_OPENUSER;
import static org.jouvieje.fmodex.defines.FMOD_TIMEUNIT.FMOD_TIMEUNIT_MS;
import static org.jouvieje.fmodex.defines.VERSIONS.FMOD_VERSION;
import static org.jouvieje.fmodex.defines.VERSIONS.NATIVEFMODEX_JAR_VERSION;
import static org.jouvieje.fmodex.defines.VERSIONS.NATIVEFMODEX_LIBRARY_VERSION;
import static org.jouvieje.fmodex.enumerations.FMOD_CHANNELINDEX.FMOD_CHANNEL_FREE;
import static org.jouvieje.fmodex.enumerations.FMOD_RESULT.FMOD_ERR_CHANNEL_STOLEN;
import static org.jouvieje.fmodex.enumerations.FMOD_RESULT.FMOD_ERR_INVALID_HANDLE;
import static org.jouvieje.fmodex.enumerations.FMOD_RESULT.FMOD_OK;
import static org.jouvieje.fmodex.enumerations.FMOD_SOUND_FORMAT.FMOD_SOUND_FORMAT_PCM16;
import static org.jouvieje.fmodex.utils.BufferUtils.newByteBuffer;
import static org.jouvieje.fmodex.utils.BufferUtils.SIZEOF_INT;
import static org.jouvieje.fmodex.utils.BufferUtils.SIZEOF_SHORT;

import java.nio.ByteBuffer;

import javax.swing.JPanel;

import org.jouvieje.fmodex.Channel;
import org.jouvieje.fmodex.FmodEx;
import org.jouvieje.fmodex.Init;
import org.jouvieje.fmodex.Sound;
import org.jouvieje.fmodex.System;
import org.jouvieje.fmodex.callbacks.FMOD_SOUND_PCMREADCALLBACK;
import org.jouvieje.fmodex.callbacks.FMOD_SOUND_PCMSETPOSCALLBACK;

import org.jouvieje.fmodex.enumerations.FMOD_RESULT;
import org.jouvieje.fmodex.examples.utils.ConsoleGUI;
import org.jouvieje.fmodex.examples.utils.FmodExExampleFrame;
import org.jouvieje.fmodex.exceptions.InitException;
import org.jouvieje.fmodex.structures.FMOD_CREATESOUNDEXINFO;

/**
 * Based on FMOD Ex C++ example. Ported to Java with NativeFmodEx by J�r�me JOUVIE (Jouvieje.
 * 
 * @author J�r�me JOUVIE (Jouvieje)
 * @site   http://jerome.jouvie.free.fr/
 * @mail   jerome.jouvie@gmail.com
 */
public class UserCreatedSound extends ConsoleGUI {
	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args) {
		new FmodExExampleFrame(new UserCreatedSound());
	}

	private boolean init = false;
	private boolean deinit = false;

	private System system = new System();
	private Sound sound = new Sound();

	private FMOD_SOUND_PCMREADCALLBACK pcmreadcallback = new FMOD_SOUND_PCMREADCALLBACK(){
		private float t1 = 0, t2 = 0; // time
		private float v1 = 0, v2 = 0; // velocity

		public FMOD_RESULT FMOD_SOUND_PCMREADCALLBACK(Sound sound, ByteBuffer data, int datalen) {
			for(int i = 0; i < datalen >> 2; i++) // >>2 = 16bit stereo (4 bytes per sample)
			{
				data.putShort((short)(sin(t1) * 32767.0f)); // left channel
				data.putShort((short)(sin(t2) * 32767.0f)); // right channel

				t1 += 0.01f + v1;
				t2 += 0.0142f + v2;
				v1 += (float)(sin(t1) * 0.002f);
				v2 += (float)(sin(t2) * 0.002f);
			}
			data.rewind(); //This is not necessary, because we don't use data after ...

			return FMOD_OK;
		}
	};

	private FMOD_SOUND_PCMSETPOSCALLBACK pcmsetposcallback = new FMOD_SOUND_PCMSETPOSCALLBACK(){

		public FMOD_RESULT FMOD_SOUND_PCMSETPOSCALLBACK(Sound sound, int subsound, int position, int postype) {
			/*
			 * This is useful if the user calls Sound::setPosition and you want to seek your data accordingly.
			 */

			return FMOD_OK;
		}
	};

	public UserCreatedSound() {
		super();
		initialize();
	}

	public JPanel getPanel() {
		return this;
	}

	public String getTitle() {
		return "FMOD Ex UserCreatedSound example.";
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
		int mode = FMOD_2D | FMOD_OPENUSER | FMOD_LOOP_NORMAL | FMOD_HARDWARE;
		int channels = 2;
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

		printf("============================================================================\n");
		printf("User Created Sound Example.  Copyright (c) Firelight Technologies 2004-2009.\n");
		printf("============================================================================\n");
		printf("Sound played here is generated in realtime.  It will either play as a stream\n");
		printf("which means it is continually filled as it is playing, or it will play as a \n");
		printf("static sample, which means it is filled once as the sound is created, then  \n");
		printf("when played it will just play that short loop of data.                      \n");
		printf("============================================================================\n");
		printf("Press 1 to play as a runtime decoded stream. (will carry on infinitely)\n");
		printf("Press 2 to play as a static in memory sample. (loops a short block of data)\n");
		printf("Press E to quit.\n\n");

		char c = ' ';
		while(c != '1' && c != '2') {
			c = getKey();
			if(c == 'e') {
				stop();
				return;
			}
			Thread.yield();
		}

		if(c == '1') {
			mode |= FMOD_CREATESTREAM;
		}

		FMOD_CREATESOUNDEXINFO createsoundexinfo = FMOD_CREATESOUNDEXINFO.allocate();
		createsoundexinfo.setDecodeBufferSize(44100); /* Chunk size of stream update in samples.  This will be the amount of data passed to the user callback. */
		createsoundexinfo.setLength(44100 * channels * SIZEOF_SHORT * 5); /* Length of PCM data in bytes of whole song (for Sound::getLength) */
		createsoundexinfo.setNumChannels(channels); /* Number of channels in the sound. */
		createsoundexinfo.setDefaultFrequency(44100); /* Default playback rate of sound. */
		createsoundexinfo.setFormat(FMOD_SOUND_FORMAT_PCM16); /* Data format of sound. */
		createsoundexinfo.setPcmReadCallback(pcmreadcallback); /* User callback for reading. */
		createsoundexinfo.setPcmSetPosCallback(pcmsetposcallback); /* User callback for seeking. */

		result = system.createSound((String)null, mode, createsoundexinfo, sound);
		errorCheck(result);

		printf("Press space to pause, E to quit\n");
		printf("Press Enter to validate your choice\n");
		printf("\n");

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
					boolean paused = buffer.get(0) != 0;
					channel.setPaused(!paused);
				case 'e':
				case 'E':
					exit = true;
					break;
			}

			system.update();

			if(!channel.isNull()) {
				long ms;
				long lenms;
				boolean playing;
				boolean paused;

				channel.isPlaying(buffer);
				if((result != FMOD_OK) && (result != FMOD_ERR_INVALID_HANDLE) && (result != FMOD_ERR_CHANNEL_STOLEN)) errorCheck(result);
				playing = buffer.get(0) != 0;

				result = channel.getPaused(buffer);
				if((result != FMOD_OK) && (result != FMOD_ERR_INVALID_HANDLE) && (result != FMOD_ERR_CHANNEL_STOLEN)) errorCheck(result);
				paused = buffer.get(0) != 0;

				result = channel.getPosition(buffer.asIntBuffer(), FMOD_TIMEUNIT_MS);
				if((result != FMOD_OK) && (result != FMOD_ERR_INVALID_HANDLE) && (result != FMOD_ERR_CHANNEL_STOLEN)) errorCheck(result);
				ms = buffer.getInt(0);

				result = sound.getLength(buffer.asIntBuffer(), FMOD_TIMEUNIT_MS);
				if((result != FMOD_OK) && (result != FMOD_ERR_INVALID_HANDLE) && (result != FMOD_ERR_CHANNEL_STOLEN)) errorCheck(result);
				lenms = buffer.getInt(0);

				printfr("Time %02d:%02d:%02d/%02d:%02d:%02d : %s", ms / 1000 / 60, ms / 1000 % 60, ms / 10 % 100,
						lenms / 1000 / 60, lenms / 1000 % 60, lenms / 10 % 100, paused ? "Paused "
								: playing ? "Playing" : "Stopped");
			}

			try {
				Thread.sleep(20);
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