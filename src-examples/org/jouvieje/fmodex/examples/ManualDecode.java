/*===============================================================================================
 ManualDecode Example
 Copyright (c), Firelight Technologies Pty, Ltd 2004-2010.

 Sound played here decoded in realtime by the user with a 'decoder sound'    
 The mp3 is created as a stream opened with FMOD_OPENONLY. This is the       
 'decoder sound'.  The playback sound is a 16bit PCM FMOD_OPENUSER created   
 sound with a pcm read callback.  When the callback happens, we call readData
 on the decoder sound and use the pcmreadcallback data pointer as the parameter.
===============================================================================================*/
package org.jouvieje.fmodex.examples;

import static org.jouvieje.fmodex.defines.FMOD_INITFLAGS.FMOD_INIT_NORMAL;
import static org.jouvieje.fmodex.defines.FMOD_MODE.*;
import static org.jouvieje.fmodex.defines.FMOD_TIMEUNIT.*;
import static org.jouvieje.fmodex.defines.VERSIONS.FMOD_VERSION;
import static org.jouvieje.fmodex.defines.VERSIONS.NATIVEFMODEX_JAR_VERSION;
import static org.jouvieje.fmodex.defines.VERSIONS.NATIVEFMODEX_LIBRARY_VERSION;
import static org.jouvieje.fmodex.enumerations.FMOD_SOUND_FORMAT.FMOD_SOUND_FORMAT_PCM16;
import static org.jouvieje.fmodex.enumerations.FMOD_CHANNELINDEX.FMOD_CHANNEL_FREE;
import static org.jouvieje.fmodex.enumerations.FMOD_RESULT.FMOD_ERR_INVALID_HANDLE;
import static org.jouvieje.fmodex.enumerations.FMOD_RESULT.*;
import static org.jouvieje.fmodex.utils.BufferUtils.newByteBuffer;
import static org.jouvieje.fmodex.utils.SizeOfPrimitive.SIZEOF_INT;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

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
import org.jouvieje.fmodex.examples.utils.Medias;
import org.jouvieje.fmodex.exceptions.InitException;
import org.jouvieje.fmodex.structures.FMOD_CREATESOUNDEXINFO;
import org.jouvieje.fmodex.utils.BufferUtils;

/**
 * Based on FMOD Ex C++ example. Ported to Java with NativeFmodEx by Jérôme JOUVIE (Jouvieje.
 * 
 * @author Jérôme JOUVIE (Jouvieje)
 * @site   http://jerome.jouvie.free.fr/
 * @mail   jerome.jouvie@gmail.com
 */
public class ManualDecode extends ConsoleGUI {
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) throws Exception {
		new FmodExExampleFrame(new ManualDecode());
	}

	private boolean init = false;
	private boolean deinit = false;

	private System system = new System();
	private Sound decodeSound = new Sound();
	private final Object decodeSoundLock = new Object();
	private Sound sound = new Sound();
	private ByteBuffer soundBuffer;

	public ManualDecode() {
		super();
		initialize();
	}

	public JPanel getPanel() {
		return this;
	}

	public String getTitle() {
		return "FMOD Ex Manual Decode example.";
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

	private final FMOD_SOUND_PCMREADCALLBACK pcmreadcallback = new FMOD_SOUND_PCMREADCALLBACK() {
		private final IntBuffer readIB = BufferUtils.newIntBuffer(1);
		public FMOD_RESULT FMOD_SOUND_PCMREADCALLBACK(Sound sound, ByteBuffer data, int datalen) {
			FMOD_RESULT result;

			synchronized(decodeSoundLock) {
				final Sound decodeSound = ManualDecode.this.decodeSound;
				if (decodeSound == null || decodeSound.isNull()) {
					return FMOD_ERR_FILE_EOF;
				}

				result = decodeSound.readData(data, datalen, readIB);
				int read = readIB.get(0);
				
				if (result == FMOD_ERR_FILE_EOF) { /* Handle looping. */
					decodeSound.seekData(0);

					datalen -= read;

					data.position(read);
					result = decodeSound.readData(data, datalen, readIB);
					data.rewind();
				}
			}

			return FMOD_OK;
		}
	};

	FMOD_SOUND_PCMSETPOSCALLBACK pcmsetposcallback = new FMOD_SOUND_PCMSETPOSCALLBACK() {
		public FMOD_RESULT FMOD_SOUND_PCMSETPOSCALLBACK(Sound sound, int subsound, int position, int postype) {
			/*
			 * The timeunit will usually be FMOD_TIMEUNIT_PCM, as FMOD will convert the user's timeunit to pcm for the codec.
			 * If it is not, do the necessary conversion of whatever is coming in, to PCM samples for Sound::seekData.
			 */
			decodeSound.seekData(position);

			return FMOD_OK;
		}
	};

	public void run() {
		if(!init) return;

		Channel channel = new Channel();
		int version, decodesound_lengthbytes = 0;
		int decodesound_channels;
		float decodesound_rate;

		ByteBuffer buffer = newByteBuffer(SIZEOF_INT);

		/*
		 * Create a System object and initialize.
		 */
		errorCheck(FmodEx.System_Create(system));

		errorCheck(system.getVersion(buffer.asIntBuffer()));
		version = buffer.getInt(0);

		if (version < FMOD_VERSION) {
			printf("Error!  You are using an old version of FMOD %08x.  This program requires %08x\n", version, FMOD_VERSION);
			stop();
			return;
		}

		errorCheck(system.init(32, FMOD_INIT_NORMAL, null));

		/*
		 * First create the 'decoder sound'.  Note it is a stream that does not initially read any data, because FMOD_OPENONLY has been specified.
		 * We could use createSound instead of createStream but that would allocate memory for the whole sound which is a waste.
		 */
		soundBuffer = Medias.loadMediaIntoMemory("/Media/wave.mp3");
		FMOD_CREATESOUNDEXINFO exinfo = FMOD_CREATESOUNDEXINFO.allocate();
		exinfo.setLength(soundBuffer.capacity());
		errorCheck(system.createStream(soundBuffer, FMOD_OPENONLY | FMOD_LOOP_NORMAL | FMOD_LOWMEM | FMOD_CREATESTREAM | FMOD_OPENMEMORY, exinfo, decodeSound));
		exinfo.release();

		errorCheck(decodeSound.getLength(buffer.asIntBuffer(), FMOD_TIMEUNIT_PCMBYTES));
		decodesound_lengthbytes = buffer.getInt(0);

		errorCheck(decodeSound.getFormat(null, null, buffer.asIntBuffer(), null));
		decodesound_channels = buffer.getInt(0);

		errorCheck(decodeSound.getDefaults(buffer.asFloatBuffer(), null, null, null));
		decodesound_rate = buffer.getFloat(0);

		/*
		 * Now create a user created PCM stream that we will feed data into, and play.
		 */
		FMOD_CREATESOUNDEXINFO createsoundexinfo = FMOD_CREATESOUNDEXINFO.allocate();
		createsoundexinfo.setDecodeBufferSize(44100);                 /* Chunk size of stream update in samples.  This will be the amount of data passed to the user callback. */
		createsoundexinfo.setNumChannels(decodesound_channels);       /* Number of channels in the sound. */
		createsoundexinfo.setLength(decodesound_lengthbytes);         /* Length of PCM data in bytes of whole song.  -1 = infinite. */
		createsoundexinfo.setDefaultFrequency((int)decodesound_rate); /* Default playback rate of sound. */
		createsoundexinfo.setFormat(FMOD_SOUND_FORMAT_PCM16);         /* Data format of sound. */
		createsoundexinfo.setPcmReadCallback(pcmreadcallback);        /* User callback for reading. */
		createsoundexinfo.setPcmSetPosCallback(pcmsetposcallback);    /* User callback for seeking. */
		errorCheck(system.createStream((ByteBuffer)null, FMOD_2D | FMOD_OPENUSER | FMOD_LOOP_NORMAL, createsoundexinfo, sound));

		printf("============================================================================\n");
		printf("Manual Decode example.  Copyright (c) Firelight Technologies 2004-2010.\n");
		printf("============================================================================\n");
		printf("Sound played here decoded in realtime by the user with a 'decoder sound'    \n");
		printf("The mp3 is created as a stream opened with FMOD_OPENONLY. This is the       \n");
		printf("'decoder sound'.  The playback sound is a 16bit PCM FMOD_OPENUSER created   \n");
		printf("sound with a pcm read callback.  When the callback happens, we call readData\n");
		printf("on the decoder sound and use the pcmreadcallback data pointer as the parameter.\n");
		printf("============================================================================\n");
		printf("\n");
		printf("Press space to pause, Esc to quit\n");
		printf("Press '<' to rewind 1 second.\n");
		printf("Press '>' to fast forward 1 second.\n");
		printf("Press 'e' Exit.\n");
		printf("\n");

		/*
		 * Play the sound.
		 */

		errorCheck(system.playSound(FMOD_CHANNEL_FREE, sound, false, channel));

		/*
		 * Main loop.
		 */
		boolean exit = false;
		do {
			switch(getKey()) {
				case ' ' : {
					channel.getPaused(buffer);
					boolean paused = (buffer.get() != 0);
					channel.setPaused(!paused);
				} break;

				case '<' : {
					channel.getPosition(buffer.asIntBuffer(), FMOD_TIMEUNIT_MS);
					int position = buffer.getInt(0);
					if (position >= 1000) {
						position -= 1000;
					}
					channel.setPosition(position, FMOD_TIMEUNIT_MS);
				} break;

				case '>' : {
					channel.getPosition(buffer.asIntBuffer(), FMOD_TIMEUNIT_MS);
					int position = buffer.getInt(0);
					position += 1000;
					channel.setPosition(position, FMOD_TIMEUNIT_MS);
				} break;

				case 'e': case 'E': {
					exit = true;
				} break;
			}

			system.update();

			if(!channel.isNull()) {
				int ms = 0, lenMs = 0;
				boolean playing = false;
				boolean paused = false;
				FMOD_RESULT result;

				result = channel.isPlaying(buffer);
				if((result != FMOD_OK) && (result != FMOD_ERR_INVALID_HANDLE)) {
					errorCheck(result);
				}
				playing = buffer.get(0) != 0;

				result = channel.getPaused(buffer);
				if((result != FMOD_OK) && (result != FMOD_ERR_INVALID_HANDLE)) {
					errorCheck(result);
				}
				paused = buffer.get(0) != 0;

				result = channel.getPosition(buffer.asIntBuffer(), FMOD_TIMEUNIT_MS);
				if((result != FMOD_OK) && (result != FMOD_ERR_INVALID_HANDLE)) {
					errorCheck(result);
				}
				ms = buffer.getInt(0);

				result = sound.getLength(buffer.asIntBuffer(), FMOD_TIMEUNIT_MS);
				if((result != FMOD_OK) && (result != FMOD_ERR_INVALID_HANDLE)) {
					errorCheck(result);
				}
				lenMs = buffer.getInt(0);

				printfr("Time %02d:%02d:%02d/%02d:%02d:%02d : %s", ms / 1000 / 60, ms / 1000 % 60, ms / 10 % 100,
						lenMs / 1000 / 60, lenMs / 1000 % 60, lenMs / 10 % 100, paused ? "Paused " : playing ? "Playing" : "Stopped");
			}

			try {
				Thread.sleep(20);
			} catch(InterruptedException e) {}
		} while(!exit && !deinit);

		stop();
	}

	public boolean isRunning() { return deinit; }
	public void stop() {
		if(!init || deinit) return;
		deinit = true;

		print("\n");

		synchronized(decodeSoundLock) {
			/*
			 * Remove the sound - wait! it might be still in use!
			 * Instead of releasing the decode sound first we could release it last, but this protection is here to make the issue obvious.
			 */
			errorCheck(decodeSound.release());
			decodeSound = null;    /* This will make the read callback fail from now on. */
		}

		/*
		 * Shut down
		 */
		FMOD_RESULT result;
		if(!sound.isNull()) {
			errorCheck(sound.release());
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
