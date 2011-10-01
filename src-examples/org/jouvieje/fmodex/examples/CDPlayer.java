/*===============================================================================================
CDPlayer Example
Copyright (c), Firelight Technologies Pty, Ltd 2004-2010.

This example shows how to play CD tracks digitally and generate a CDDB query
===============================================================================================*/

package org.jouvieje.fmodex.examples;

import static org.jouvieje.fmodex.defines.FMOD_INITFLAGS.FMOD_INIT_NORMAL;
import static org.jouvieje.fmodex.defines.FMOD_MODE.FMOD_OPENONLY;
import static org.jouvieje.fmodex.defines.FMOD_TIMEUNIT.FMOD_TIMEUNIT_MS;
import static org.jouvieje.fmodex.defines.FMOD_TIMEUNIT.FMOD_TIMEUNIT_RAWBYTES;
import static org.jouvieje.fmodex.defines.FMOD_TIMEUNIT.FMOD_TIMEUNIT_SENTENCE_MS;
import static org.jouvieje.fmodex.defines.FMOD_TIMEUNIT.FMOD_TIMEUNIT_SENTENCE_SUBSOUND;
import static org.jouvieje.fmodex.defines.VERSIONS.FMOD_VERSION;
import static org.jouvieje.fmodex.defines.VERSIONS.NATIVEFMODEX_JAR_VERSION;
import static org.jouvieje.fmodex.defines.VERSIONS.NATIVEFMODEX_LIBRARY_VERSION;
import static org.jouvieje.fmodex.enumerations.FMOD_CHANNELINDEX.FMOD_CHANNEL_FREE;
import static org.jouvieje.fmodex.enumerations.FMOD_RESULT.FMOD_OK;
import static org.jouvieje.fmodex.enumerations.FMOD_TAGDATATYPE.FMOD_TAGDATATYPE_CDTOC;
import static org.jouvieje.fmodex.utils.BufferUtils.newByteBuffer;
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
import org.jouvieje.fmodex.exceptions.InitException;
import org.jouvieje.fmodex.structures.FMOD_CDTOC;
import org.jouvieje.fmodex.structures.FMOD_TAG;
import org.jouvieje.libloader.LibLoader;

/**
 * Based on FMOD Ex C++ example. Ported to Java with NativeFmodEx by Jérôme JOUVIE (Jouvieje.
 * 
 * @author Jérôme JOUVIE (Jouvieje)
 * @site   http://jerome.jouvie.free.fr/
 * @mail   jerome.jouvie@gmail.com
 */
public class CDPlayer extends ConsoleGUI {
	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args) {
		new FmodExExampleFrame(new CDPlayer());
	}

	private boolean init = false;
	private boolean deinit = false;

	private System system = new System();
	private Sound cdsound = new Sound();

	public CDPlayer() {
		super();
		initialize();
	}

	public JPanel getPanel() {
		return this;
	}

	public String getTitle() {
		return "FMOD Ex CDPlayer example.";
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
		int numtracks, currenttrack = 0;
		int version;

		ByteBuffer buffer = newByteBuffer(SIZEOF_INT);

		printf("==================================================================\n");
		printf("CDPlayer Example.  Copyright (c) Firelight Technologies 2004-2009.\n");
		printf("==================================================================\n");
		printf("Usage:              CDPlayer <cd_drive>\n");
		printf("Example(Windows)  : CDPlayer e\n");
		printf("Example(Linux/Mac): CDPlayer /dev/cdrom1\n\n");
		resetInput();
		setInput("e");
		while(!keyHit()) {
			Thread.yield();
		}
		String path = getInput();

		final int platform = LibLoader.getPlatform();
		if(platform == LibLoader.PLATFORM_WINDOWS) {
			path += ":";
		}

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

		errorCheck(system.init(1, FMOD_INIT_NORMAL, null));

		/*
		 * Bump up the file buffer size a bit from the 16k default for CDDA, because it is a slower medium.
		 */
		errorCheck(system.setStreamBufferSize(64 * 1024, FMOD_TIMEUNIT_RAWBYTES));

		printf("Opening '%s' cd drive, please wait ...", path);
		errorCheck(system.createStream(path, FMOD_OPENONLY, null, cdsound));

		errorCheck(cdsound.getNumSubSounds(buffer.asIntBuffer()));
		numtracks = buffer.getInt(0);

		try {
			Thread.sleep(2000);
		}
		catch(InterruptedException e) {}

		for(;;) {
			FMOD_TAG tag = FMOD_TAG.allocate();
			if(cdsound.getTag(null, -1, tag) != FMOD_OK) {
				break;
			}
			if(tag.getDataType() == FMOD_TAGDATATYPE_CDTOC) {
				dump_cddb_query(FMOD_CDTOC.asFMOD_CDTOC(tag.getData()));
			}
			tag.release();
		}

		printf("\n========================================\n");
		printf("Press SPACE to pause\n");
		printf("      n     previous track\n");
		printf("      n     to skip to next track\n");
		printf("      <     re-wind 10 seconds\n");
		printf("      >     fast-forward 10 seconds\n");
		printf("      E     to exit\n");
		printf("========================================\n\n");

		/*
		 * Print out length of entire CD.  Did you know you can also play 'cdsound' and it will play the whole CD without gaps?
		 */
		{
			errorCheck(cdsound.getLength(buffer.asIntBuffer(), FMOD_TIMEUNIT_MS));
			int lenms = buffer.getInt(0);

			printf("Total CD length %02d:%02d\n\n", lenms / 1000 / 60, lenms / 1000 % 60, lenms / 10 % 100);
		}

		/*
		 * Play whole CD
		 */
		errorCheck(system.playSound(FMOD_CHANNEL_FREE, cdsound, false, channel));

		/*
		 * Main loop
		 */
		boolean exit = false;
		do {
			switch(getKey()) {
				case ' ': {
					channel.getPaused(buffer);
					boolean paused = buffer.get(0) != 0;
					channel.setPaused(!paused);
				} break;
				case '<': {
					channel.getPosition(buffer.asIntBuffer(), FMOD_TIMEUNIT_SENTENCE_MS);

					int ms = buffer.getInt(0);
					if(ms >= 10000) ms -= 10000;
					else ms = 0;

					channel.setPosition(ms, FMOD_TIMEUNIT_SENTENCE_MS);
				} break;
				case '>': {
					channel.getPosition(buffer.asIntBuffer(), FMOD_TIMEUNIT_SENTENCE_MS);

					int ms = buffer.getInt(0);
					ms += 10000;

					channel.setPosition(ms, FMOD_TIMEUNIT_SENTENCE_MS);
				} break;
				case 'n': {
					channel.getPosition(buffer.asIntBuffer(), FMOD_TIMEUNIT_SENTENCE_SUBSOUND);
					currenttrack = buffer.getInt(0);

					currenttrack++;
					if(currenttrack >= numtracks) {
						currenttrack = 0;
					}

					errorCheck(channel.setPosition(currenttrack, FMOD_TIMEUNIT_SENTENCE_SUBSOUND));
				} break;
				case 'p': {
					channel.getPosition(buffer.asIntBuffer(), FMOD_TIMEUNIT_SENTENCE_SUBSOUND);
					currenttrack = buffer.getInt(0);

					currenttrack--;
					if(currenttrack < 0) {
						currenttrack = 0;
					}

					errorCheck(channel.setPosition(currenttrack, FMOD_TIMEUNIT_SENTENCE_SUBSOUND));
				} break;
				
				case 'e': case 'E': {
					exit = true;
				} break;
			}

			system.update();

			if(/*channel != null && */!channel.isNull()) {
				int ms, lenms;
				boolean playing;
				boolean paused;
				int busy;

				errorCheck(channel.getPaused(buffer));
				paused = buffer.get(0) != 0;
				errorCheck(channel.isPlaying(buffer));
				playing = buffer.get(0) != 0;
				errorCheck(channel.getPosition(buffer.asIntBuffer(), FMOD_TIMEUNIT_SENTENCE_MS));
				ms = buffer.getInt(0);
				//FIXME Not supported in FMOD Ex 4.31.02
				/*errorCheck(*/cdsound.getLength(buffer.asIntBuffer(), FMOD_TIMEUNIT_SENTENCE_MS)/*)*/;
				lenms = buffer.getInt(0);

				errorCheck(FmodEx.File_GetDiskBusy(buffer.asIntBuffer()));
				busy = buffer.getInt(0);

				printfr("Track %d/%d : %02d:%02d:%02d/%02d:%02d:%02d : %s (%s)", currenttrack + 1, numtracks,
						ms / 1000 / 60, ms / 1000 % 60, ms / 10 % 100, lenms / 1000 / 60, lenms / 1000 % 60,
						lenms / 10 % 100, paused ? "Paused " : playing ? "Playing" : "Stopped", busy != 0 ? "*" : " ");
			}

			try {
				Thread.sleep(50);
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
		if(!cdsound.isNull()) {
			errorCheck(cdsound.release());
		}
		if(!system.isNull()) {
			errorCheck(system.close());
			errorCheck(system.release());
		}

		printExit("Shutdown\n");
	}

	/*==================================================*/

	private int cddb_sum(int n) {
		int ret = 0;

		while(n > 0) {
			ret += (n % 10);
			n /= 10;
		}

		return ret;
	}

	private int cddb_discid(FMOD_CDTOC toc) {
		int n = 0;

		IntBuffer min = toc.getMin();
		IntBuffer sec = toc.getSec();
		int numTracks = toc.getNumTracks();

		for(int i = 0; i < numTracks; i++) {
			n += cddb_sum((min.get(i) * 60) + sec.get(i));
		}

		int t = ((min.get(numTracks) * 60) + sec.get(numTracks)) - ((min.get(0) * 60) + sec.get(0));

		return ((n % 0xff) << 24 | t << 8 | numTracks);
	}

	private void dump_cddb_query(FMOD_CDTOC toc) {
		printf("cddb query %08x %d", cddb_discid(toc), toc.getNumTracks());

		IntBuffer min = toc.getMin();
		IntBuffer sec = toc.getSec();
		IntBuffer frame = toc.getFrame();
		int numTracks = toc.getNumTracks();

		for(int i = 0; i < numTracks; i++) {
			printf(" %d", (min.get(i) * (60 * 75)) + (sec.get(i) * 75) + frame.get(i));
		}

		printf(" %d\n", (min.get(numTracks)) * 60 + sec.get(numTracks));
	}
}