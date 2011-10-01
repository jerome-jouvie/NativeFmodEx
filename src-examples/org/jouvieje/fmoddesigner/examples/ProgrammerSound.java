/*===============================================================================================
 programmer_sound Example
 Copyright (c), Firelight Technologies Pty, Ltd 2006-2009.

 Demonstrates how to use the "programmer sound" feature of the FMOD event system
===============================================================================================*/

package org.jouvieje.fmoddesigner.examples;

import java.nio.ByteBuffer;
import java.util.Arrays;

import javax.swing.JPanel;

import static org.jouvieje.fmoddesigner.defines.FMOD_EVENT_INITFLAGS.FMOD_EVENT_INIT_NORMAL;
import static org.jouvieje.fmoddesigner.defines.FMOD_EVENT_MODE.FMOD_EVENT_DEFAULT;
import static org.jouvieje.fmoddesigner.defines.VERSIONS.NATIVEFMODDESIGNER_JAR_VERSION;
import static org.jouvieje.fmoddesigner.defines.VERSIONS.NATIVEFMODDESIGNER_LIBRARY_VERSION;
import static org.jouvieje.fmoddesigner.enumerations.FMOD_EVENT_CALLBACKTYPE.FMOD_EVENT_CALLBACKTYPE_SOUNDDEF_CREATE;
import static org.jouvieje.fmoddesigner.enumerations.FMOD_EVENT_CALLBACKTYPE.FMOD_EVENT_CALLBACKTYPE_SOUNDDEF_RELEASE;
import static org.jouvieje.fmodex.defines.FMOD_INITFLAGS.FMOD_INIT_NORMAL;
import static org.jouvieje.fmodex.defines.FMOD_MODE.FMOD_2D;
import static org.jouvieje.fmodex.defines.FMOD_MODE.FMOD_SOFTWARE;
import static org.jouvieje.fmodex.defines.FMOD_MODE.FMOD_NONBLOCKING;
import static org.jouvieje.fmodex.defines.VERSIONS.NATIVEFMODEX_JAR_VERSION;
import static org.jouvieje.fmodex.defines.VERSIONS.NATIVEFMODEX_LIBRARY_VERSION;
import static org.jouvieje.fmodex.enumerations.FMOD_OPENSTATE.FMOD_OPENSTATE_READY;
import static org.jouvieje.fmodex.enumerations.FMOD_RESULT.FMOD_OK;
import static org.jouvieje.fmodex.enumerations.FMOD_RESULT.FMOD_ERR_SUBSOUNDS;

import org.jouvieje.fmodex.utils.JARFileSystem;
import org.jouvieje.fmoddesigner.Event;
import org.jouvieje.fmoddesigner.EventGroup;
import org.jouvieje.fmoddesigner.EventSystem;
import org.jouvieje.fmoddesigner.FmodDesigner;
import org.jouvieje.fmoddesigner.InitFmodDesigner;
import org.jouvieje.fmoddesigner.callbacks.FMOD_EVENT_CALLBACK;
import org.jouvieje.fmoddesigner.enumerations.FMOD_EVENT_CALLBACKTYPE;
import org.jouvieje.fmoddesigner.structures.FMOD_EVENT_LOADINFO;
import org.jouvieje.fmodex.FmodEx;
import org.jouvieje.fmodex.Init;
import org.jouvieje.fmodex.Sound;
import org.jouvieje.fmodex.System;

import org.jouvieje.fmodex.enumerations.FMOD_OPENSTATE;
import org.jouvieje.fmodex.enumerations.FMOD_RESULT;
import org.jouvieje.fmodex.examples.utils.ConsoleGUI;
import org.jouvieje.fmodex.examples.utils.FmodExExampleFrame;
import org.jouvieje.fmodex.examples.utils.Medias;
import org.jouvieje.fmodex.exceptions.InitException;
import org.jouvieje.fmodex.utils.BufferUtils;
import org.jouvieje.fmodex.utils.Pointer;

/**
 * Based on FMOD Ex C++ example. Ported to Java with NativeFmodEx by Jérôme JOUVIE (Jouvieje.
 * 
 * @author Jérôme JOUVIE (Jouvieje)
 * @site   http://jerome.jouvie.free.fr/
 * @mail   jerome.jouvie@gmail.com
 */
public class ProgrammerSound extends ConsoleGUI {
	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args) {
		new FmodExExampleFrame(new ProgrammerSound());
	}

	private boolean init = false;
	private boolean deinit = false;

	private EventSystem eventsystem = new EventSystem();

	private transient int g_sound_index = 0;
	private transient int[] g_index_map = new int[4];

	private Sound fsb;
	private System sys;

	public ProgrammerSound() {
		super();
		initialize();
	}

	public JPanel getPanel() {
		return this;
	}

	public String getTitle() {
		return "FMOD Designer ProgrammerSound example.";
	}

	private void errorCheck(FMOD_RESULT result) {
		if(result != FMOD_RESULT.FMOD_OK) {
			printfExit("FMOD error! (%d) %s\n", result.asInt(), FmodEx.FMOD_ErrorString(result));
		}
	}

	private void initIndexMap(Sound fsb) {
		ByteBuffer buffer = BufferUtils.newByteBuffer(100);

		/* Sounds aren't in a logical order in the FSB, so we need to iterate
		   through and assign the appropriate filenames to the index map
		 */

		FMOD_OPENSTATE[] openstate = new FMOD_OPENSTATE[1];
		do {
			fsb.getOpenState(openstate, null, null);
		} while(openstate[0] != FMOD_OPENSTATE_READY);

		errorCheck(fsb.getNumSubSounds(buffer.asIntBuffer()));
		int numSubsounds = buffer.getInt(0);

		Arrays.fill(g_index_map, -1);

		for(int i = 0; i < numSubsounds; ++i) {
			Sound sound = new Sound();

			errorCheck(fsb.getSubSound(i, sound));

			do {
				fsb.getOpenState(openstate, null, null);
			} while(openstate[0] != FMOD_OPENSTATE_READY);

			errorCheck(sound.getName(buffer, buffer.capacity()));

			final String name = BufferUtils.toString(buffer);
			if(name.equals("sequence-one.ogg")) {
				g_index_map[0] = i;
			}
			else if(name.equals("sequence-two.ogg")) {
				g_index_map[1] = i;
			}
			else if(name.equals("sequence-three.ogg")) {
				g_index_map[2] = i;
			}
			else if(name.equals("sequence-four.ogg")) {
				g_index_map[3] = i;
			}
		}
	}

	private FMOD_EVENT_CALLBACK eventcallback = new FMOD_EVENT_CALLBACK(){
		private ByteBuffer soundName = BufferUtils.newByteBuffer(128);

		public FMOD_RESULT FMOD_EVENT_CALLBACK(Event event, FMOD_EVENT_CALLBACKTYPE type, Pointer param1, Pointer param2, Pointer userdata) {
			FMOD_RESULT result;
			if(type == FMOD_EVENT_CALLBACKTYPE_SOUNDDEF_CREATE) {
				Sound s = new Sound();

				errorCheck(result = (g_index_map[g_sound_index] >= 0) ? FMOD_OK : FMOD_ERR_SUBSOUNDS);

				result = fsb.getSubSound(g_index_map[g_sound_index], s);
				if(result != FMOD_OK) {
					printf("FMOD_EVENT_CALLBACKTYPE_SOUNDDEF_CREATE: %d: sound not ready, retry next frame\n", g_index_map[g_sound_index]);
					return result;
				}
				param2.shareMemory(s); // [out] (FMOD::Sound **) a valid lower level API FMOD Sound handle
				
				result = s.getName(soundName, soundName.capacity());
				if(result != FMOD_OK) {
					printf("FMOD_EVENT_CALLBACKTYPE_SOUNDDEF_CREATE: %d: sound not ready, retry next frame\n", g_index_map[g_sound_index]);
					return result;
				}
				printf("FMOD_EVENT_CALLBACKTYPE_SOUNDDEF_CREATE '%s' (%d)\n", BufferUtils.toString(soundName), g_index_map[g_sound_index]);
			}
			else if(type == FMOD_EVENT_CALLBACKTYPE_SOUNDDEF_RELEASE) {
				Sound s = Sound.asSound(param2); // [in]  (FMOD::Sound *) the FMOD sound handle that was previously created in FMOD_EVENT_CALLBACKTYPE_SOUNDDEF_CREATE

				errorCheck(result = s.getName(soundName, soundName.capacity()));

				printf("FMOD_EVENT_CALLBACKTYPE_SOUNDDEF_RELEASE '%s'\n", BufferUtils.toString(soundName));
			}
			return FMOD_OK;
		}
	};

	public void init() {
		/*
		 * NativeFmodEx/NativeFmodDesigner Init
		 */
		try {
			Init.loadLibraries();
			InitFmodDesigner.loadLibraries();
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
		/*
		 * Checking NativeFmodDesigner version
		 */
		if(NATIVEFMODDESIGNER_LIBRARY_VERSION != NATIVEFMODDESIGNER_JAR_VERSION) {
			printfExit("Error!  NativeFmodDesigner library version (%08x) is different to jar version (%08x)\n",
					NATIVEFMODDESIGNER_LIBRARY_VERSION, NATIVEFMODDESIGNER_JAR_VERSION);
			return;
		}

		/*==================================================*/

		init = true;
	}

	public void run() {
		if(!init) return;

		EventGroup eventgroup = new EventGroup();
		Event event = new Event();
		sys = new System();
		fsb = new Sound();

		print("======================================================================\n");
		print("Programmer Sound. Copyright (c) Firelight Technologies 2006-2009.\n");
		print("======================================================================\n");

		errorCheck(FmodDesigner.EventSystem_Create(eventsystem));
		errorCheck(eventsystem.init(64, FMOD_INIT_NORMAL, null, FMOD_EVENT_INIT_NORMAL));
//	    errorCheck(eventsystem.setMediaPath("DesignerMedia"));
//	    errorCheck(eventsystem.load("examples.fev", null, null));
		{
			//Load fev in memory
			ByteBuffer fevBuffer = Medias.loadMediaIntoMemory("/DesignerMedia/examples.fev");
			FMOD_EVENT_LOADINFO info = FMOD_EVENT_LOADINFO.allocate();
			info.setLoadFromMemoryLength(fevBuffer.capacity());
			errorCheck(eventsystem.load(fevBuffer, info, null));
			info.release();
		}
		{
			//Attach a JAR file system
			System system = new System();
			eventsystem.getSystemObject(system);
			JARFileSystem fileSystem = new JARFileSystem("/DesignerMedia/");
			errorCheck(system.setFileSystem(fileSystem.jarOpen, fileSystem.jarClose, fileSystem.jarRead, fileSystem.jarSeek, fileSystem.jarAsyncRead, fileSystem.jarAsyncCancel, -1));
		}
		errorCheck(eventsystem.getGroup("examples/FeatureDemonstration/SequencingAndStitching", FMOD_EVENT_DEFAULT != 0, eventgroup));

		errorCheck(eventsystem.getSystemObject(sys));
		errorCheck(sys.createStream("tutorial_bank.fsb", FMOD_2D | FMOD_NONBLOCKING | FMOD_SOFTWARE, null, fsb));

		initIndexMap(fsb);

	    print("======================================================================\n");
	    print("Press 'Space' to start the 'Programmer Sound' event\n");
	    print("Press '>' ';' to increase sound index\n");
	    print("Press '<' ',' to decrease sound index\n");
	    print("Press 'E'     to quit\n");
	    print("======================================================================\n");
	    printf("Sound index = %d\n", g_sound_index + 1);

		boolean exit = false;
		do {
			switch(getKey()) {
				case ' ':
					errorCheck(eventgroup.getEvent("ProgrammerSounds", FMOD_EVENT_DEFAULT, event));
					errorCheck(event.setCallback(eventcallback, null));
					errorCheck(event.start());
					break;
				case '>':
				case ';':
					++g_sound_index;
					g_sound_index = g_sound_index > 3 ? 3 : g_sound_index;
					printf("Subsound index = %d\n", g_sound_index + 1);
					break;
				case '<':
				case ',':
					--g_sound_index;
					g_sound_index = g_sound_index < 0 ? 0 : g_sound_index;
					printf("Subsound index = %d\n", g_sound_index + 1);
					break;
				case 'e':
				case 'E':
					exit = true;
					break;
			}

			errorCheck(eventsystem.update());

			try {
				Thread.sleep(10);
			} catch(InterruptedException e) {}
		}
		while(!exit && !deinit);

		stop();
	}

	public boolean isRunning() { return deinit; }
	public void stop() {
		if(!init || deinit) return;
		deinit = true;

		print("\n");

		if(!eventsystem.isNull()) {
			System system = new System();
			eventsystem.getSystemObject(system);
			system.setFileSystem(null, null, null, null, null, null, -1);

			errorCheck(eventsystem.unload());
		}
		if(!fsb.isNull()) {
			errorCheck(fsb.release());
		}
		if(!eventsystem.isNull()) {
			errorCheck(eventsystem.release());
		}

		printExit("Shutdown\n");
	}
}