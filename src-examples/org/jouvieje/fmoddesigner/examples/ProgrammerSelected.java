/*=============================================================================
 Programmer Selected Sound Definition Example
 Copyright (c), Firelight Technologies Pty, Ltd 2007.

 Demonstrates how to use the "programmer selected sound definition" feature of
 the FMOD event system
=============================================================================*/

package org.jouvieje.fmoddesigner.examples;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import javax.swing.JPanel;

import static org.jouvieje.fmoddesigner.defines.FMOD_EVENT_INITFLAGS.FMOD_EVENT_INIT_NORMAL;
import static org.jouvieje.fmoddesigner.defines.FMOD_EVENT_MODE.FMOD_EVENT_DEFAULT;
import static org.jouvieje.fmoddesigner.defines.VERSIONS.NATIVEFMODDESIGNER_JAR_VERSION;
import static org.jouvieje.fmoddesigner.defines.VERSIONS.NATIVEFMODDESIGNER_LIBRARY_VERSION;
import static org.jouvieje.fmoddesigner.enumerations.FMOD_EVENT_CALLBACKTYPE.FMOD_EVENT_CALLBACKTYPE_SOUNDDEF_SELECTINDEX;
import static org.jouvieje.fmodex.defines.FMOD_INITFLAGS.FMOD_INIT_NORMAL;
import static org.jouvieje.fmodex.defines.VERSIONS.NATIVEFMODEX_JAR_VERSION;
import static org.jouvieje.fmodex.defines.VERSIONS.NATIVEFMODEX_LIBRARY_VERSION;
import static org.jouvieje.fmodex.enumerations.FMOD_RESULT.FMOD_OK;
import static org.jouvieje.fmodex.utils.BufferUtils.SIZEOF_INT;

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
import org.jouvieje.fmodex.System;

import org.jouvieje.fmodex.enumerations.FMOD_RESULT;
import org.jouvieje.fmodex.examples.utils.ConsoleGUI;
import org.jouvieje.fmodex.examples.utils.FmodExExampleFrame;
import org.jouvieje.fmodex.examples.utils.Medias;
import org.jouvieje.fmodex.exceptions.InitException;
import org.jouvieje.fmodex.utils.Pointer;

/**
 * Based on FMOD Ex C++ example. Ported to Java with NativeFmodEx by Jérôme JOUVIE (Jouvieje.
 * 
 * @author Jérôme JOUVIE (Jouvieje)
 * @site   http://jerome.jouvie.free.fr/
 * @mail   jerome.jouvie@gmail.com
 */
public class ProgrammerSelected extends ConsoleGUI {
	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args) {
		new FmodExExampleFrame(new ProgrammerSelected());
	}

	private boolean init = false;
	private boolean deinit = false;

	private EventSystem eventsystem = new EventSystem();

	private int g_sounddef_entry_index = 0;

	public ProgrammerSelected() {
		super();
		initialize();
	}

	public JPanel getPanel() {
		return this;
	}

	public String getTitle() {
		return "FMOD Designer ProgrammeSelected example.";
	}

	private void errorCheck(FMOD_RESULT result) {
		if(result != FMOD_RESULT.FMOD_OK) {
			printfExit("FMOD error! (%d) %s\n", result.asInt(), FmodEx.FMOD_ErrorString(result));
		}
	}

	private FMOD_EVENT_CALLBACK eventcallback = new FMOD_EVENT_CALLBACK(){
		public FMOD_RESULT FMOD_EVENT_CALLBACK(Event event, FMOD_EVENT_CALLBACKTYPE type, Pointer param1,
				Pointer param2, Pointer userdata) {
			if(type == FMOD_EVENT_CALLBACKTYPE_SOUNDDEF_SELECTINDEX) {
				String name = param1.asString(); // [in]  (char *) name of sound definition
				IntBuffer indexBuf = param2.asByteBuffer(0, SIZEOF_INT).asIntBuffer(); // [out] (int *) the sounddef entry index to use

				int index = indexBuf.get(0);
				index = g_sounddef_entry_index < index ? g_sounddef_entry_index : index - 1;
				indexBuf.put(0, index);

				printf("FMOD_EVENT_CALLBACKTYPE_SOUNDDEF_SELECTINDEX '%s': %d\n", name, index);
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

		FMOD_RESULT result;
		EventGroup eventgroup = new EventGroup();
		Event event = new Event();

		errorCheck(result = FmodDesigner.EventSystem_Create(eventsystem));
		errorCheck(result = eventsystem.init(64, FMOD_INIT_NORMAL, null, FMOD_EVENT_INIT_NORMAL));
//		errorCheck(result = eventsystem.setMediaPath("DesignerMedia"));
//		errorCheck(result = eventsystem.load("examples.fev", null, null));
		{
			//Load fev in memory
			ByteBuffer fevBuffer = Medias.loadMediaIntoMemory("/DesignerMedia/examples.fev");
			FMOD_EVENT_LOADINFO info = FMOD_EVENT_LOADINFO.allocate();
			info.setLoadFromMemoryLength(fevBuffer.capacity());
			errorCheck(result = eventsystem.load(fevBuffer, info, null));
			info.release();
		}
		{
			//Attach a JAR file system
			System system = new System();
			eventsystem.getSystemObject(system);
			JARFileSystem fileSystem = new JARFileSystem("/DesignerMedia/");
			errorCheck(result = system.setFileSystem(fileSystem.jarOpen, fileSystem.jarClose, fileSystem.jarRead, fileSystem.jarSeek, fileSystem.jarAsyncRead, fileSystem.jarAsyncCancel, -1));
		}
		errorCheck(result = eventsystem.getGroup("examples/FeatureDemonstration/SequencingAndStitching", FMOD_EVENT_DEFAULT != 0, eventgroup));

		printf("======================================================================\n");
		printf("Programmer Selected Sound Definition.\n");
		printf("Copyright (c) Firelight Technologies 2006-2009.\n");
		printf("----------------------------------------------------------------------\n");
		printf("Press 's'        to start a 'Programmer Selected' event\n");
		printf("Press '>' or '.' to increase sound definition entry index\n");
		printf("Press '<' or ',' to decrease sound definition entry index\n");
		printf("Press 'E'        to quit\n");
		printf("======================================================================\n");
		printf("Sound definition entry index = %d\n", g_sounddef_entry_index);

		boolean exit = false;
		do {
			switch(getKey()) {
				case 's': case 'S': {
					result = eventgroup.getEvent("ProgrammerSelected", FMOD_EVENT_DEFAULT, event);
					if(result == FMOD_OK) {
						errorCheck(result = event.setCallback(eventcallback, null));
						errorCheck(result = event.start());
					}
				} break;
				case '>': case '.': {
					++g_sounddef_entry_index;
					printf("Sound definition entry index = %d\n", g_sounddef_entry_index);
				} break;
				case '<': case ',': {
					--g_sounddef_entry_index;
					g_sounddef_entry_index = g_sounddef_entry_index < 0 ? 0 : g_sounddef_entry_index;
					printf("Sound definition entry index = %d\n", g_sounddef_entry_index);
				} break;
				case 'e': case 'E': {
					exit = true;
				} break;
			}

			errorCheck(result = eventsystem.update());

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

		if(!eventsystem.isNull()) {
			System system = new System();
			eventsystem.getSystemObject(system);
			system.setFileSystem(null, null, null, null, null, null, -1);

			errorCheck(eventsystem.unload());
			errorCheck(eventsystem.release());
		}

		printExit("Shutdown\n");
	}
}