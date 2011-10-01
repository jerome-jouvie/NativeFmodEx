package org.jouvieje.fmodex.examples;

import static org.jouvieje.fmodex.defines.FMOD_INITFLAGS.FMOD_INIT_NORMAL;
import static org.jouvieje.fmodex.defines.FMOD_MODE.FMOD_DEFAULT;
import static org.jouvieje.fmodex.defines.FMOD_MODE.FMOD_LOOP_NORMAL;
import static org.jouvieje.fmodex.defines.FMOD_MODE.FMOD_SOFTWARE;
import static org.jouvieje.fmodex.defines.VERSIONS.FMOD_VERSION;
import static org.jouvieje.fmodex.defines.VERSIONS.NATIVEFMODEX_JAR_VERSION;
import static org.jouvieje.fmodex.defines.VERSIONS.NATIVEFMODEX_LIBRARY_VERSION;
import static org.jouvieje.fmodex.enumerations.FMOD_CHANNELINDEX.FMOD_CHANNEL_FREE;
import static org.jouvieje.fmodex.utils.BufferUtils.newByteBuffer;
import static org.jouvieje.fmodex.utils.BufferUtils.SIZEOF_INT;

import java.nio.ByteBuffer;

import javax.swing.JPanel;

import org.jouvieje.fmodex.Channel;
import org.jouvieje.fmodex.FmodEx;
import org.jouvieje.fmodex.Init;
import org.jouvieje.fmodex.Sound;
import org.jouvieje.fmodex.System;

import org.jouvieje.fmodex.enumerations.FMOD_RESULT;
import org.jouvieje.fmodex.examples.utils.ConsoleGUI;
import org.jouvieje.fmodex.examples.utils.FmodExExampleFrame;
import org.jouvieje.fmodex.exceptions.InitException;

/**
 * Based on FMOD Ex C++ example. Ported to Java with NativeFmodEx by Jérôme JOUVIE (Jouvieje.
 * 
 * @author Jérôme JOUVIE (Jouvieje)
 * @site   http://jerome.jouvie.free.fr/
 * @mail   jerome.jouvie@gmail.com
 */
public class CodecRawMain extends ConsoleGUI {
	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args) {
		new FmodExExampleFrame(new CodecRawMain());
	}

	private boolean init = false;
	private boolean deinit = false;

	private System system = new System();
	private Sound sound = new Sound();

	public CodecRawMain() {
		super();
		initialize();
	}

	public JPanel getPanel() {
		return this;
	}

	public String getTitle() {
		return "FMOD Ex CodecRaw example.";
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
		int version;

		ByteBuffer buffer = newByteBuffer(SIZEOF_INT);

		printf("===================================================================\n");
		printf("CODEC_RAW.DLL  Copyright (c), Firelight Technologies Pty, Ltd 2005.\n");
		printf("===================================================================\n");
		printf("Usage:    CodecRaw <filename>.raw\n");
		printf("examples: CodecRaw output.raw\n");
		printf("(output.raw can be generate with 'OfflineDecoding' examples)\n\n");
		resetInput();
		setInput("output.raw");
		while(!keyHit()) {
			Thread.yield();
		}
		String path = getInput();

		/*
		 * Global Settings
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

		errorCheck(system.createCodec(CodecRaw.FMODGetCodecDescription(), 0)); //Platform INDependant way [Preferred - Pack your plugins in jar instead of library]
//		errorCheck(system.loadPlugin("lib/codec_raw.dll", null, null);		//Platform Dependant way
		
		errorCheck(system.createSound(path, FMOD_DEFAULT | FMOD_SOFTWARE | FMOD_LOOP_NORMAL, null, sound));
		
		errorCheck(system.playSound(FMOD_CHANNEL_FREE, sound, false, channel));
		
		printf("Press 'ENTER' to quit\n");
		printf("\n");

		/*
		 * Main loop.
		 */
		resetInput();
		do {
			system.update();

			try {
				Thread.sleep(10);
			}
			catch(InterruptedException e1) {}
		}
		while(!keyHit() && !deinit);

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
		if(!sound.isNull()) {
			errorCheck(sound.release());
		}
		if(!system.isNull()) {
			errorCheck(system.close());
			errorCheck(system.release());
		}

		printExit("Shutdown\n");
	}
}