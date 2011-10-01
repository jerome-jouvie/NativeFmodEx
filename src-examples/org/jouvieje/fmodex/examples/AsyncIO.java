/* $LICENSE$ */
package org.jouvieje.fmodex.examples;

import static org.jouvieje.fmodex.defines.FMOD_INITFLAGS.FMOD_INIT_NORMAL;
import static org.jouvieje.fmodex.defines.FMOD_MODE.*;
import static org.jouvieje.fmodex.defines.FMOD_TIMEUNIT.*;
import static org.jouvieje.fmodex.defines.VERSIONS.FMOD_VERSION;
import static org.jouvieje.fmodex.defines.VERSIONS.NATIVEFMODEX_JAR_VERSION;
import static org.jouvieje.fmodex.defines.VERSIONS.NATIVEFMODEX_LIBRARY_VERSION;
import static org.jouvieje.fmodex.enumerations.FMOD_CHANNELINDEX.FMOD_CHANNEL_FREE;
import static org.jouvieje.fmodex.enumerations.FMOD_RESULT.FMOD_ERR_FILE_BAD;
import static org.jouvieje.fmodex.enumerations.FMOD_RESULT.FMOD_ERR_FILE_EOF;
import static org.jouvieje.fmodex.enumerations.FMOD_RESULT.FMOD_ERR_FILE_NOTFOUND;
import static org.jouvieje.fmodex.enumerations.FMOD_RESULT.FMOD_ERR_INVALID_PARAM;
import static org.jouvieje.fmodex.enumerations.FMOD_RESULT.FMOD_ERR_MEMORY;
import static org.jouvieje.fmodex.enumerations.FMOD_RESULT.FMOD_OK;
import static org.jouvieje.fmodex.utils.BufferUtils.newByteBuffer;
import static org.jouvieje.fmodex.utils.SizeOfPrimitive.SIZEOF_INT;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.JPanel;

import org.jouvieje.fmodex.Channel;
import org.jouvieje.fmodex.FmodEx;
import org.jouvieje.fmodex.Init;
import org.jouvieje.fmodex.Sound;
import org.jouvieje.fmodex.System;
import org.jouvieje.fmodex.callbacks.FMOD_FILE_ASYNCCANCELCALLBACK;
import org.jouvieje.fmodex.callbacks.FMOD_FILE_ASYNCREADCALLBACK;
import org.jouvieje.fmodex.callbacks.FMOD_FILE_CLOSECALLBACK;
import org.jouvieje.fmodex.callbacks.FMOD_FILE_OPENCALLBACK;
import org.jouvieje.fmodex.callbacks.FMOD_FILE_READCALLBACK;
import org.jouvieje.fmodex.callbacks.FMOD_FILE_SEEKCALLBACK;
import org.jouvieje.fmodex.enumerations.FMOD_OPENSTATE;
import org.jouvieje.fmodex.enumerations.FMOD_RESULT;
import org.jouvieje.fmodex.examples.utils.ConsoleGUI;
import org.jouvieje.fmodex.examples.utils.FmodExExampleFrame;
import org.jouvieje.fmodex.exceptions.InitException;
import org.jouvieje.fmodex.structures.FMOD_ASYNCREADINFO;
import org.jouvieje.fmodex.utils.ObjectPointer;
import org.jouvieje.fmodex.utils.Pointer;

/**
 * Based on FMOD Ex C++ example. Ported to Java with NativeFmodEx by Jérôme JOUVIE (Jouvieje.
 * 
 * @author Jérôme JOUVIE (Jouvieje)
 * @site   http://jerome.jouvie.free.fr/
 * @mail   jerome.jouvie@gmail.com
 */
public class AsyncIO extends ConsoleGUI {
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) throws Exception {
		new FmodExExampleFrame(new AsyncIO());
	}

	private boolean init = false;
	private boolean deinit = false;

	private System system = new System();
	private Sound sound = new Sound();
	private final Object lock = new Object();
	private final Queue<FMOD_ASYNCREADINFO> queuehead = new LinkedList<FMOD_ASYNCREADINFO>();
	private ByteBuffer soundBuffer;
	
	private transient boolean gThreadQuit = false;
	private transient boolean gSleepBreak = false;

	public AsyncIO() {
		super();
		initialize();
	}

	public JPanel getPanel() {
		return this;
	}

	public String getTitle() {
		return "FMOD Ex Async IO example.";
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

	/*
	 * File callbacks
	 */
	public final FMOD_FILE_OPENCALLBACK myopen = new FMOD_FILE_OPENCALLBACK() {
		public FMOD_RESULT FMOD_FILE_OPENCALLBACK(String name, int unicode, IntBuffer filesize, Pointer handle, Pointer userdata) {
			if(name != null) {
				try {
					RandomAccessFile file = new RandomAccessFile(new File(name), "r");

					filesize.put(0, (int)file.length());

					handle.shareMemory(ObjectPointer.allocate(file));
				} catch(FileNotFoundException e) {
					return FMOD_ERR_FILE_NOTFOUND;
				} catch(IOException e) {
					return FMOD_ERR_FILE_BAD;
				}
			}
			return FMOD_OK;
		}
	};

	private final FMOD_FILE_CLOSECALLBACK myclose = new FMOD_FILE_CLOSECALLBACK(){
		public FMOD_RESULT FMOD_FILE_CLOSECALLBACK(Pointer handle, Pointer userdata) {
			if(handle.isNull()) {
				return FMOD_ERR_INVALID_PARAM;
			}

			try {
				RandomAccessFile file = handleToFile(handle);
				file.close();

				ObjectPointer.asObjectPointer(handle).release();
			} catch(IOException e) {
				return FMOD_ERR_INVALID_PARAM;
			}

			return FMOD_OK;
		}
	};

	private final FMOD_FILE_READCALLBACK myread = new FMOD_FILE_READCALLBACK(){
		public FMOD_RESULT FMOD_FILE_READCALLBACK(Pointer handle, ByteBuffer buffer, int sizebytes, IntBuffer bytesread, Pointer userdata) {
			if(handle.isNull()) {
				return FMOD_ERR_INVALID_PARAM;
			}

			if(bytesread != null) {
				final int read;
				try {
					RandomAccessFile file = handleToFile(handle);

					read = file.getChannel().read(buffer);
					bytesread.put(0, read);
					buffer.rewind();
				} catch(IOException e) {
					return FMOD_ERR_FILE_BAD;
				}

				if(read < sizebytes) {
					return FMOD_ERR_FILE_EOF;
				}
			}

			return FMOD_OK;
		}
	};

	private final FMOD_FILE_SEEKCALLBACK myseek = new FMOD_FILE_SEEKCALLBACK(){
		public FMOD_RESULT FMOD_FILE_SEEKCALLBACK(Pointer handle, int pos, Pointer userdata) {
			printf("************ seek to %d\n", pos);
			if(handle.isNull()) {
				return FMOD_ERR_INVALID_PARAM;
			}

			try {
				RandomAccessFile file = handleToFile(handle);
				file.seek(pos);
			} catch(IOException e) {
				return FMOD_ERR_FILE_BAD;
			}

			return FMOD_OK;
		}
	};

	private final FMOD_FILE_ASYNCREADCALLBACK myasyncread = new FMOD_FILE_ASYNCREADCALLBACK() {
		public FMOD_RESULT FMOD_FILE_ASYNCREADCALLBACK(FMOD_ASYNCREADINFO info, Pointer userdata) {
			printf("REQUESTING %5d bytes from offset %5d PRIORITY = %d.\n", info.getSizeBytes(), info.getOffset(), info.getPriority());

			synchronized(lock) {
				if(!queuehead.offer(info)) {
					return FMOD_ERR_MEMORY;
				}
				if (info.getPriority() > 50) {
					gSleepBreak = true;     /* Tell file thread to stop sleeping, we have an urgent request here! */
				}
			}

			return FMOD_OK;
		}
	};

	private final FMOD_FILE_ASYNCCANCELCALLBACK myasynccancel = new FMOD_FILE_ASYNCCANCELCALLBACK() {
		public FMOD_RESULT FMOD_FILE_ASYNCCANCELCALLBACK(Pointer handle, Pointer userdata) {
			synchronized(lock) {
				queuehead.clear();
			}

			return FMOD_OK;
		}
	};

	private final Thread t = new Thread("ProcessQueue") {
		public void run() {
			while (!gThreadQuit) {
				synchronized(lock) {
					while(!queuehead.isEmpty()) {
						FMOD_ASYNCREADINFO asyncReadInfo = queuehead.poll();
						
						int toread = asyncReadInfo.getSizeBytes();
						if (toread > 32768) {
							toread = 32768;     /* For fun - Let's deprive the read of the whole block.  Only give 32kb at a time to make it re-ask for more later. */
						}           
						
						try {
							RandomAccessFile file = handleToFile(asyncReadInfo.getHandle());
							file.seek(asyncReadInfo.getOffset());
							ByteBuffer buffer = asyncReadInfo.getBuffer().asByteBuffer(0, toread);
							int read = file.getChannel().read(buffer);
							asyncReadInfo.setBytesRead(read);
							buffer.rewind();
						} catch(IOException e) {
							e.printStackTrace();
						}

						if (asyncReadInfo.getBytesRead() < toread) {
							printf("FED        %5d bytes from offset %5d (* EOF)\n", asyncReadInfo.getBytesRead(), asyncReadInfo.getOffset());
							asyncReadInfo.setResult(FMOD_ERR_FILE_EOF);
						}
						else {
							printf("FED        %5d bytes from offset %5d\n", asyncReadInfo.getBytesRead(), asyncReadInfo.getOffset());
							asyncReadInfo.setResult(FMOD_OK);
						}
					}
				}

				for (int i = 0; i < 100; i++) {
					try {
						Thread.sleep(10);
					} catch(Throwable t) {}
					
					if (gSleepBreak) {
						printf("URGENT REQUEST - reading now!\n");
						gSleepBreak = false;
						break;
					}
				}
			}
		};
	};
	
	private final RandomAccessFile handleToFile(Pointer handle) {
		final ObjectPointer objectPointer = ObjectPointer.asObjectPointer(handle);
		final RandomAccessFile file = (RandomAccessFile)objectPointer.getObject();
		return file;
	}

	public void run() {
		if(!init) return;

		Channel channel = new Channel();

		ByteBuffer buffer = newByteBuffer(SIZEOF_INT);

		/*
		 * Create a System object and initialize.
		 */
		errorCheck(FmodEx.System_Create(system));

		errorCheck(system.getVersion(buffer.asIntBuffer()));
		final int version = buffer.getInt(0);
		if (version < FMOD_VERSION) {
			printf("Error!  You are using an old version of FMOD %08x.  This program requires %08x\n", version, FMOD_VERSION);
			stop();
			return;
		}

		// Start async file read
		t.start();
		
		errorCheck(system.init(1, FMOD_INIT_NORMAL, null));

		errorCheck(system.setStreamBufferSize(65536, FMOD_TIMEUNIT_RAWBYTES));

		errorCheck(system.setFileSystem(myopen, myclose, myread, myseek, myasyncread, myasynccancel, 2048));

		printf("====================================================================\n");
		printf("Stream IO Example.  Copyright (c) Firelight Technologies 2004-2010.\n");
		printf("====================================================================\n");
		printf("\n");
		printf("\n");
		printf("====================== CALLING CREATESOUND ON MP3 =======================\n");

		errorCheck(system.createStream("./Media/wave.mp3", FMOD_SOFTWARE | FMOD_LOOP_NORMAL | FMOD_2D | FMOD_IGNORETAGS, null, sound));
		
		printf("====================== CALLING PLAYSOUND ON MP3 =======================\n");

		errorCheck(system.playSound(FMOD_CHANNEL_FREE, sound, false, channel));

		/*
		 * Main loop.
		 */
		boolean exit = false;
		do {
			if (sound != null && !sound.isNull()) {
				FMOD_OPENSTATE[] openstatearray = new FMOD_OPENSTATE[1];
				sound.getOpenState(openstatearray, null, buffer);
				FMOD_OPENSTATE openstate = openstatearray[0];
				boolean starving = buffer.get(0) != 0;

				if (starving) {
					errorCheck(channel.setMute(true));
				}
				else {
					errorCheck(channel.setMute(false));
				}
			}

			switch(getKey()) {
				case ' ' : {
					FMOD_RESULT result = sound.release();
					if (result == FMOD_OK) {
						sound = null;
						printf("Released sound.\n");
					}
				} break;

				case 'e': case 'E': {
					exit = true;
				} break;
			}
		} while(!exit && !deinit);

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
		gThreadQuit = true;

		printExit("Shutdown\n");
	}
}
