/*===============================================================================================
NetStream Example
Copyright (c), Firelight Technologies Pty, Ltd 2004-2010.

This example shows how to play streaming audio from the internet
===============================================================================================*/

package org.jouvieje.fmodex.examples;

import static org.jouvieje.fmodex.defines.FMOD_INITFLAGS.FMOD_INIT_NORMAL;
import static org.jouvieje.fmodex.defines.FMOD_MODE.FMOD_2D;
import static org.jouvieje.fmodex.defines.FMOD_MODE.FMOD_HARDWARE;
import static org.jouvieje.fmodex.defines.FMOD_MODE.FMOD_MPEGSEARCH;
import static org.jouvieje.fmodex.defines.FMOD_MODE.FMOD_NONBLOCKING;
import static org.jouvieje.fmodex.defines.FMOD_TIMEUNIT.FMOD_TIMEUNIT_MS;
import static org.jouvieje.fmodex.defines.FMOD_TIMEUNIT.FMOD_TIMEUNIT_RAWBYTES;
import static org.jouvieje.fmodex.defines.VERSIONS.FMOD_VERSION;
import static org.jouvieje.fmodex.defines.VERSIONS.NATIVEFMODEX_JAR_VERSION;
import static org.jouvieje.fmodex.defines.VERSIONS.NATIVEFMODEX_LIBRARY_VERSION;
import static org.jouvieje.fmodex.enumerations.FMOD_CHANNELINDEX.FMOD_CHANNEL_FREE;
import static org.jouvieje.fmodex.enumerations.FMOD_OPENSTATE.FMOD_OPENSTATE_BUFFERING;
import static org.jouvieje.fmodex.enumerations.FMOD_OPENSTATE.FMOD_OPENSTATE_CONNECTING;
import static org.jouvieje.fmodex.enumerations.FMOD_OPENSTATE.FMOD_OPENSTATE_READY;
import static org.jouvieje.fmodex.enumerations.FMOD_RESULT.FMOD_ERR_INVALID_HANDLE;
import static org.jouvieje.fmodex.enumerations.FMOD_RESULT.FMOD_OK;
import static org.jouvieje.fmodex.enumerations.FMOD_TAGDATATYPE.FMOD_TAGDATATYPE_STRING;
import static org.jouvieje.fmodex.utils.BufferUtils.newByteBuffer;
import static org.jouvieje.fmodex.utils.BufferUtils.SIZEOF_INT;

import java.nio.ByteBuffer;

import javax.swing.JPanel;

import org.jouvieje.fmodex.Channel;
import org.jouvieje.fmodex.FmodEx;
import org.jouvieje.fmodex.Init;
import org.jouvieje.fmodex.Sound;
import org.jouvieje.fmodex.System;

import org.jouvieje.fmodex.enumerations.FMOD_OPENSTATE;
import org.jouvieje.fmodex.enumerations.FMOD_RESULT;
import org.jouvieje.fmodex.examples.utils.ConsoleGUI;
import org.jouvieje.fmodex.examples.utils.FmodExExampleFrame;
import org.jouvieje.fmodex.exceptions.InitException;
import org.jouvieje.fmodex.structures.FMOD_TAG;

/**
 * Based on FMOD Ex C++ example. Ported to Java with NativeFmodEx by Jérôme JOUVIE (Jouvieje.
 * 
 * @author Jérôme JOUVIE (Jouvieje)
 * @site   http://jerome.jouvie.free.fr/
 * @mail   jerome.jouvie@gmail.com
 */
public class NetStream extends ConsoleGUI {
	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args) {
		new FmodExExampleFrame(new NetStream());
	}

	private boolean init = false;
	private boolean deinit = false;

	private System system = new System();
	private Sound sound = new Sound();

	public NetStream() {
		super();
		initialize();
	}

	public JPanel getPanel() {
		return this;
	}

	public String getTitle() {
		return "FMOD Ex NetStream example.";
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
		long version;

		ByteBuffer buffer = newByteBuffer(SIZEOF_INT);

		printf("===================================================================\n");
		printf("NetStream Example.  Copyright (c) Firelight Technologies 2004-2009.\n");
		printf("===================================================================\n\n");
		printf("Usage:   netstream <url>\n");
		printf("Example: netstream http://www.fmod.org/stream.mp3\n");
		printf("Example: netstream http://jerome.jouvie.free.fr/downloads/NativeFmodEx/jules.mp3\n\n");
		resetInput();
		setInput("http://www.fmod.org/stream.mp3");
		while(!keyHit()) {
			Thread.yield();
		}
		String url = getInput();

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

		result = system.init(1, FMOD_INIT_NORMAL, null);
		errorCheck(result);

		/*
		 * Bump up the file buffer size a little bit for netstreams (to account for lag).
		 */
		result = system.setStreamBufferSize(64 * 1024, FMOD_TIMEUNIT_RAWBYTES);
		errorCheck(result);

		printf("Buffering...\n\n");

		result = system.createStream(url, FMOD_HARDWARE | FMOD_2D | FMOD_MPEGSEARCH | FMOD_NONBLOCKING, null, sound);
		errorCheck(result);

		printf("Press space to pause, E to quit\n");
		printf("\n");

		/*
		 * Main loop
		 */
		boolean exit = false;
		do {
			int ms = 0, percent = 0;
			boolean playing = false;
			boolean paused = false;
			boolean starving = false;
			FMOD_OPENSTATE openstate;

			if(channel.isNull()) {
				result = system.playSound(FMOD_CHANNEL_FREE, sound, false, channel);
			}

			switch(getKey()) {
				case ' ':
					if(!channel.isNull()) {
						channel.getPaused(buffer);
						boolean pause = buffer.get(0) != 0;
						channel.setPaused(!pause);
					}
				case 'e':
				case 'E':
					exit = true;
					break;
			}

			system.update();

			for(;;) {
				FMOD_TAG tag = FMOD_TAG.allocate();
				if(sound.getTag(null, -1, tag) != FMOD_OK) {
					break;
				}
				if(tag.getDataType() == FMOD_TAGDATATYPE_STRING) {
					printf("%s = %s (%d bytes)       \n", tag.getName(), tag.getData().asString(), tag.getDataLen());
				}
				tag.release();
			}

			FMOD_OPENSTATE[] openstateArray = new FMOD_OPENSTATE[1];
			ByteBuffer starvingBuffer = newByteBuffer(1);
			result = sound.getOpenState(openstateArray, buffer.asIntBuffer(), starvingBuffer);
			errorCheck(result);
			openstate = openstateArray[0];
			percent = buffer.getInt(0);
			starving = starvingBuffer.get(0) != 0;

			if(!channel.isNull()) {
				result = channel.getPaused(buffer);
				if(result == FMOD_ERR_INVALID_HANDLE) { //Added to shutdown nicely
					break;
				}
				errorCheck(result);
				paused = buffer.get(0) != 0;
				result = channel.isPlaying(buffer);
				errorCheck(result);
				playing = buffer.get(0) != 0;
				result = channel.getPosition(buffer.asIntBuffer(), FMOD_TIMEUNIT_MS);
				errorCheck(result);
				ms = buffer.getInt(0);
				result = channel.setMute(starving);
				errorCheck(result);
			}

			printfr("Time %02d:%02d:%02d : %s : (%3d%%) %s", ms / 1000 / 60, ms / 1000 % 60, ms / 10 % 100,
					openstate == FMOD_OPENSTATE_BUFFERING ? "Buffering..."
							: openstate == FMOD_OPENSTATE_CONNECTING ? "Connecting..." : paused ? "Paused       "
									: playing ? "Playing      " : "Stopped      ", percent, starving ? "STARVING"
							: "        ");

			try {
				Thread.sleep(10);
			}
			catch(InterruptedException e1) {}
		}
		while(!exit && !deinit);

		printf("\n");

		printf("Shutting down.\n");

		if(!channel.isNull()) {
			result = channel.stop();
			errorCheck(result);
		}

		/*
		 * If we pressed escape before it is ready, wait for it to finish opening before we release it.
		 */
		do {
			FMOD_OPENSTATE[] openstate = new FMOD_OPENSTATE[1];
			result = sound.getOpenState(openstate, null, null);
			errorCheck(result);

			if(openstate[0] == FMOD_OPENSTATE_READY) {
				break;
			}

			printfr("Waiting for sound to finish opening before trying to release it....");

			try {
				Thread.sleep(10);
			}
			catch(InterruptedException e1) {}
		}
		while(true);

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