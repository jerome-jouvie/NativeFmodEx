/*===============================================================================================
 Custom DSP Example
 Copyright (c), Firelight Technologies Pty, Ltd 2004-2010.

 This example shows how to add a user created DSP callback to process audio data.
 A read callback is generated at runtime, and can be added anywhere in the DSP network.

===============================================================================================*/

package org.jouvieje.fmodex.examples;

import static org.jouvieje.fmodex.defines.FMOD_INITFLAGS.FMOD_INIT_NORMAL;
import static org.jouvieje.fmodex.defines.FMOD_MODE.FMOD_LOOP_NORMAL;
import static org.jouvieje.fmodex.defines.FMOD_MODE.FMOD_OPENMEMORY;
import static org.jouvieje.fmodex.defines.FMOD_MODE.FMOD_SOFTWARE;
import static org.jouvieje.fmodex.defines.VERSIONS.FMOD_VERSION;
import static org.jouvieje.fmodex.defines.VERSIONS.NATIVEFMODEX_JAR_VERSION;
import static org.jouvieje.fmodex.defines.VERSIONS.NATIVEFMODEX_LIBRARY_VERSION;
import static org.jouvieje.fmodex.enumerations.FMOD_CHANNELINDEX.FMOD_CHANNEL_FREE;
import static org.jouvieje.fmodex.enumerations.FMOD_RESULT.FMOD_OK;
import static org.jouvieje.fmodex.utils.BufferUtils.newByteBuffer;
import static org.jouvieje.fmodex.utils.BufferUtils.SIZEOF_INT;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

import javax.swing.JPanel;

import org.jouvieje.fmodex.Channel;
import org.jouvieje.fmodex.DSP;
import org.jouvieje.fmodex.FmodEx;
import org.jouvieje.fmodex.Init;
import org.jouvieje.fmodex.Sound;
import org.jouvieje.fmodex.System;
import org.jouvieje.fmodex.callbacks.FMOD_DSP_READCALLBACK;

import org.jouvieje.fmodex.enumerations.FMOD_RESULT;
import org.jouvieje.fmodex.examples.utils.ConsoleGUI;
import org.jouvieje.fmodex.examples.utils.FmodExExampleFrame;
import org.jouvieje.fmodex.examples.utils.Medias;
import org.jouvieje.fmodex.exceptions.InitException;
import org.jouvieje.fmodex.utils.BufferUtils;
import org.jouvieje.fmodex.structures.FMOD_CREATESOUNDEXINFO;
import org.jouvieje.fmodex.structures.FMOD_DSP_DESCRIPTION;
import org.jouvieje.fmodex.structures.FMOD_DSP_STATE;

/**
 * Based on FMOD Ex C++ example. Ported to Java with NativeFmodEx by Jérôme JOUVIE (Jouvieje.
 * 
 * @author Jérôme JOUVIE (Jouvieje)
 * @site   http://jerome.jouvie.free.fr/
 * @mail   jerome.jouvie@gmail.com
 */
public class DspCustom extends ConsoleGUI {
	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args) {
		new FmodExExampleFrame(new DspCustom());
	}

	private boolean init = false;
	private boolean deinit = false;

	public DspCustom() {
		super();
		initialize();
	}

	public JPanel getPanel() {
		return this;
	}

	public String getTitle() {
		return "FMOD Ex DspCustom example.";
	}

	private void errorCheck(FMOD_RESULT result) {
		if(result != FMOD_RESULT.FMOD_OK) {
			printfExit("FMOD error! (%d) %s\n", result.asInt(), FmodEx.FMOD_ErrorString(result));
		}
	}

	private boolean active = false;

	private System system = new System();
	private Sound sound = new Sound();
	private DSP mydsp = new DSP();

	private FMOD_DSP_READCALLBACK myDSPCallback = new FMOD_DSP_READCALLBACK(){
		ByteBuffer nameBuffer = newByteBuffer(256);

		public FMOD_RESULT FMOD_DSP_READCALLBACK(FMOD_DSP_STATE dsp_state, FloatBuffer inbuffer, FloatBuffer outbuffer,
				int length, int inchannels, int outchannels) {
			DSP thisdsp = dsp_state.getInstance();

			/*
			 * This redundant call just shows using the instance parameter of FMOD_DSP_STATE and using it to 
			 * call a DSP information function. 
			 */
			thisdsp.getInfo(nameBuffer, null, null, null, null);
			String name = BufferUtils.toString(nameBuffer);

			/*
			 * This loop assumes inchannels = outchannels, which it will be if the DSP is created with '0' 
			 * as the number of channels in FMOD_DSP_DESCRIPTION.  
			 * Specifying an actual channel count will mean you have to take care of any number of channels coming in,
			 * but outputting the number of channels specified.  Generally it is best to keep the channel 
			 * count at 0 for maximum compatibility.
			 */
			for(int sample = 0; sample < length; sample++) {
				/*
				 * Feel free to unroll this.
				 */
				for(int channel = 0; channel < inchannels; channel++) {
					/*
					 * This DSP filter just halves the volume! 
					 * Input is modified, and sent to output.
					 */
					/*
					 * Jouvieje note:
					 *  this is valide only if inchannels == outchannels
					 */
					outbuffer.put(inbuffer.get() * 0.2f);
					//Otherwise use :
//					outbuffer.put((sample * outchannels) + channel, inbuffer.get() * 0.2f);
				}
			}
			inbuffer.rewind();
			outbuffer.rewind();

			return FMOD_OK;
		}
	};

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
		int version;

		ByteBuffer buffer = newByteBuffer(SIZEOF_INT);

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
		errorCheck(system.createSound(soundBuffer, FMOD_SOFTWARE | FMOD_LOOP_NORMAL | FMOD_OPENMEMORY, exinfo, sound));
		exinfo.release();

		printf("===============================================================================\n");
		printf("Custom DSP example. Copyright (c) Firelight Technologies 2004-2009.\n");
		printf("===============================================================================\n");
		printf("Press 'f' to activate, deactivate user filter\n");
		printf("Press 'e' to quit\n");
		printf("\n");

		errorCheck(system.playSound(FMOD_CHANNEL_FREE, sound, false, channel));
		
		/*
		 * Create the DSP effects.
		 */
		{
			FMOD_DSP_DESCRIPTION dspdesc = FMOD_DSP_DESCRIPTION.allocate();

			dspdesc.setName("My first DSP unit");
			dspdesc.setChannels(0); // 0 = whatever comes in, else specify. 
			dspdesc.setRead(myDSPCallback);

			errorCheck(system.createDSP(dspdesc, mydsp));
		}

		/*
		 * Inactive by default.
		 */
		mydsp.setBypass(true);

		errorCheck(system.addDSP(mydsp, null));

		/*
		 * Main loop.
		 */
		boolean exit = false;
		do {
			switch(getKey()) {
				case 'f':
				case 'F':
					mydsp.setBypass(active);
					active = !active;
					break;
				case 'e':
				case 'E':
					exit = true;
					break;
			}

			system.update();

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

		/*
		 * Shut down
		 */
		if(!sound.isNull()) {
			errorCheck(sound.release());
		}
		if(!mydsp.isNull()) {
			errorCheck(mydsp.release());
		}

		if(!system.isNull()) {
			errorCheck(system.close());
			errorCheck(system.release());
		}

		printExit("Shutdown\n");
	}
}