/*===============================================================================================
LoadData Example
Copyright (c), Firelight Technologies Pty, Ltd 2004-2010.

Demonstrates basic usage of FMOD's data-driven event library (fmod_event.dll)
===============================================================================================*/

package org.jouvieje.fmoddesigner.examples;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import javax.swing.JPanel;

import static org.jouvieje.fmoddesigner.defines.FMOD_EVENT_INITFLAGS.FMOD_EVENT_INIT_NORMAL;
import static org.jouvieje.fmoddesigner.defines.FMOD_EVENT_MODE.FMOD_EVENT_DEFAULT;
import static org.jouvieje.fmoddesigner.defines.VERSIONS.NATIVEFMODDESIGNER_JAR_VERSION;
import static org.jouvieje.fmoddesigner.defines.VERSIONS.NATIVEFMODDESIGNER_LIBRARY_VERSION;
import static org.jouvieje.fmoddesigner.enumerations.FMOD_EVENT_RESOURCE.FMOD_EVENT_RESOURCE_STREAMS_AND_SAMPLES;
import static org.jouvieje.fmodex.defines.FMOD_INITFLAGS.FMOD_INIT_NORMAL;
import static org.jouvieje.fmodex.defines.VERSIONS.NATIVEFMODEX_JAR_VERSION;
import static org.jouvieje.fmodex.defines.VERSIONS.NATIVEFMODEX_LIBRARY_VERSION;
import static org.jouvieje.fmodex.enumerations.FMOD_RESULT.FMOD_ERR_INVALID_HANDLE;
import static org.jouvieje.fmodex.utils.BufferUtils.newIntBuffer;

import org.jouvieje.fmodex.utils.JARFileSystem;
import org.jouvieje.fmoddesigner.Event;
import org.jouvieje.fmoddesigner.EventGroup;
import org.jouvieje.fmoddesigner.EventSystem;
import org.jouvieje.fmoddesigner.FmodDesigner;
import org.jouvieje.fmoddesigner.InitFmodDesigner;
import org.jouvieje.fmoddesigner.structures.FMOD_EVENT_LOADINFO;
import org.jouvieje.fmodex.FmodEx;
import org.jouvieje.fmodex.Init;
import org.jouvieje.fmodex.System;

import org.jouvieje.fmodex.enumerations.FMOD_RESULT;
import org.jouvieje.fmodex.examples.utils.ConsoleGUI;
import org.jouvieje.fmodex.examples.utils.FmodExExampleFrame;
import org.jouvieje.fmodex.examples.utils.Medias;
import org.jouvieje.fmodex.exceptions.InitException;

/**
 * Based on FMOD Ex C++ example. Ported to Java with NativeFmodEx by Jérôme JOUVIE (Jouvieje.
 * 
 * @author Jérôme JOUVIE (Jouvieje)
 * @site   http://jerome.jouvie.free.fr/
 * @mail   jerome.jouvie@gmail.com
 */
public class LoadData extends ConsoleGUI {
	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args) {
		new FmodExExampleFrame(new LoadData());
	}

	private boolean init = false;
	private boolean deinit = false;

	private EventSystem eventsystem = new EventSystem();
	private EventGroup eventgroup = new EventGroup();
	
	public LoadData() {
		super();
		initialize();
	}

	public JPanel getPanel() {
		return this;
	}

	public String getTitle() {
		return "FMOD Designer LoadData example.";
	}

	private void errorCheck(FMOD_RESULT result) {
		if(result != FMOD_RESULT.FMOD_OK) {
			printfExit("FMOD error! (%d) %s\n", result.asInt(), FmodEx.FMOD_ErrorString(result));
		}
	}
	
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
		Event event = new Event();
		IntBuffer memory_current = newIntBuffer(1);
		IntBuffer memory_max = newIntBuffer(1);

	    printf("======================================================================\n");
	    printf("Load Event Data Example.  Copyright (c) Firelight Technologies 2004-2009.\n");
	    printf("==============================-------=================================\n");
	    printf("This demonstrates loading and unloading of event data per event and\n");
	    printf("per group.\n");
	    printf("======================================================================\n\n");
	    
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
			errorCheck(result = system.setFileSystem(
				fileSystem.jarOpen, fileSystem.jarClose, fileSystem.jarRead, fileSystem.jarSeek, fileSystem.jarAsyncRead, fileSystem.jarAsyncCancel,
				-1));
		}
		errorCheck(result = eventsystem.getGroup("examples/FeatureDemonstration/Basics", FMOD_EVENT_DEFAULT != 0, eventgroup));

	    printf("======================================================================\n");
	    printf("Press 'e'        to load event data\n");
	    printf("Press 'E'        to unload event data\n");
	    printf("Press 'g'        to load group data\n");
	    printf("Press 'G'        to unload group data\n");
	    printf("Press 'q'        to quit\n");
	    printf("======================================================================\n");
	    
		boolean exit = false;
		do {
			switch(getKey()) {
				case 'e': {
					errorCheck(result = eventgroup.getEvent("SimpleEvent", FMOD_EVENT_DEFAULT, event));
					printf("Event data loaded\n");
				} break;
				case 'E': {
					if(!event.isNull()) {
						result = eventgroup.freeEventData(event, true);
						if(result != FMOD_ERR_INVALID_HANDLE) {
							errorCheck(result);
							printf("Event data unloaded\n");
						}
						event = new Event();
					}
				} break;
				case 'g': {
					errorCheck(result = eventgroup.loadEventData(FMOD_EVENT_RESOURCE_STREAMS_AND_SAMPLES, FMOD_EVENT_DEFAULT));
					printf("Event group data loaded\n");
				} break;
				case 'G': {
					errorCheck(result = eventgroup.freeEventData(null, true));
					printf("Event group data unloaded\n");
				} break;
				
				case 'q': case 'Q': {
					exit = true;
				} break;
			}

			{
				errorCheck(result = FmodEx.Memory_GetStats(memory_current, memory_max, true));
				printfr("Memory usage: current = %10d, max = %10d", memory_current.get(0), memory_max.get(0));
			}
		
			errorCheck(result = eventsystem.update());

			try {
				Thread.sleep(15);
			} catch(InterruptedException e) {}
		} while(!exit && !deinit);

		stop();
	}

	public boolean isRunning() { return deinit; }
	public void stop() {
		if(!init || deinit) return;
		deinit = true;

		print("\n");

		if(!eventgroup.isNull()) {
			errorCheck(eventgroup.freeEventData(null, true));
		}
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