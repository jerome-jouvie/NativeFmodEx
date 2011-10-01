/*===============================================================================================
SimpleEvent Example
Copyright (c), Firelight Technologies Pty, Ltd 2004-2010.

Demonstrates basic usage of FMOD's data-driven event library (fmod_event.dll)
===============================================================================================*/

package org.jouvieje.fmoddesigner.examples;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import javax.swing.JPanel;

import static org.jouvieje.fmoddesigner.defines.FMOD_EVENT_INITFLAGS.FMOD_EVENT_INIT_NORMAL;
import static org.jouvieje.fmoddesigner.defines.FMOD_EVENT_MODE.FMOD_EVENT_DEFAULT;
import static org.jouvieje.fmoddesigner.defines.VERSIONS.FMOD_EVENT_VERSION;
import static org.jouvieje.fmoddesigner.defines.VERSIONS.NATIVEFMODDESIGNER_JAR_VERSION;
import static org.jouvieje.fmoddesigner.defines.VERSIONS.NATIVEFMODDESIGNER_LIBRARY_VERSION;
import static org.jouvieje.fmoddesigner.defines.FMOD_EVENT_STATE.FMOD_EVENT_STATE_PLAYING;
import static org.jouvieje.fmodex.defines.FMOD_INITFLAGS.FMOD_INIT_NORMAL;
import static org.jouvieje.fmodex.defines.VERSIONS.NATIVEFMODEX_JAR_VERSION;
import static org.jouvieje.fmodex.defines.VERSIONS.NATIVEFMODEX_LIBRARY_VERSION;
import static org.jouvieje.fmodex.utils.BufferUtils.newIntBuffer;
import static org.jouvieje.fmodex.utils.BufferUtils.SIZEOF_INT;

import org.jouvieje.fmodex.utils.JARFileSystem;
import org.jouvieje.fmoddesigner.Event;
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
public class SimpleEvent extends ConsoleGUI {
	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args) {
		new FmodExExampleFrame(new SimpleEvent());
	}

	private boolean init = false;
	private boolean deinit = false;

	private EventSystem eventSystem = new EventSystem();
	private Event event = new Event();

	public SimpleEvent() {
		super();
		initialize();
	}

	public JPanel getPanel() {
		return this;
	}

	public String getTitle() {
		return "FMOD Designer SimpleEvent example.";
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
		
		int version;

		IntBuffer intBuffer = newIntBuffer(SIZEOF_INT);

		printf("======================================================================\n");
		printf("Simple Event Example.  Copyright (c) Firelight Technologies 2004-2009.\n");
		printf("==============================-------=================================\n");
		printf("This example plays an event created with the FMOD Designer sound \n");
		printf("designer tool.  It simply plays an event, retrieves the parameters\n");
		printf("and allows the user to adjust them.\n");
		printf("======================================================================\n\n");

		errorCheck(FmodDesigner.EventSystem_Create(eventSystem));

		errorCheck(eventSystem.getVersion(intBuffer));
		version = intBuffer.get(0);
		if(version < FMOD_EVENT_VERSION) {
			printfExit("Error!  You are using an old version of FMOD EVENT %08x. This program requires %08x\n", version, FMOD_EVENT_VERSION);
			return;
		}

		errorCheck(eventSystem.init(64, FMOD_INIT_NORMAL, null, FMOD_EVENT_INIT_NORMAL));

//		errorCheck(eventsystem.setMediaPath("DesignerMedia"));
//		errorCheck(eventsystem.load("examples.fev", null, null));
		{
			//Load fev in memory
			ByteBuffer fevBuffer = Medias.loadMediaIntoMemory("/DesignerMedia/examples.fev");
			FMOD_EVENT_LOADINFO info = FMOD_EVENT_LOADINFO.allocate();
			info.setLoadFromMemoryLength(fevBuffer.capacity());
			errorCheck(eventSystem.load(fevBuffer, info, null));
			info.release();
		}
		{
			//Attach a JAR file system
			System system = new System();
			eventSystem.getSystemObject(system);
			JARFileSystem fileSystem = new JARFileSystem("/DesignerMedia/");
			errorCheck(system.setFileSystem(fileSystem.jarOpen, fileSystem.jarClose, fileSystem.jarRead, fileSystem.jarSeek, fileSystem.jarAsyncRead, fileSystem.jarAsyncCancel, -1));
		}
		
		errorCheck(eventSystem.getEvent("examples/FeatureDemonstration/Basics/SimpleEvent", FMOD_EVENT_DEFAULT, event));
		
		printf("======================================================================\n");
	    printf("Press SPACE to play the event.\n");
	    printf("Press e     to quit\n");
		printf("======================================================================\n");

		boolean exit = false;
		do {
			char c = getKey();
			if(c == 'e' || c == 'E') {
				exit = true;
			}
			else if(c == ' ') {
				errorCheck(event.start());
			}

			errorCheck(eventSystem.update());

			try {
				Thread.sleep(15);
			}
			catch(InterruptedException e) {}

			errorCheck(event.getState(intBuffer));
			int state = intBuffer.get(0);
			printfr("Event is %s", ((state & FMOD_EVENT_STATE_PLAYING) != 0) ? "playing" : "stopped");
		}
		while(!exit && !deinit);

		stop();
	}

	public boolean isRunning() { return deinit; }
	public void stop() {
		if(!init || deinit) return;
		deinit = true;

		print("\n");
		
		if(!eventSystem.isNull()) {
			System system = new System();
			eventSystem.getSystemObject(system);
			system.setFileSystem(null, null, null, null, null, null, -1);

			errorCheck(eventSystem.release());
		}

		printExit("Shutdown\n");
	}
}