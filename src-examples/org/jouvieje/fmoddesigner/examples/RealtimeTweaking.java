/*===============================================================================================
 realtime_tweaking Example
 Copyright (c), Firelight Technologies Pty, Ltd 2004-2010.

 Demonstrates basic usage of FMOD's network data-driven event library (fmod_event_net.dll)
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
import static org.jouvieje.fmoddesigner.enumerations.FMOD_EVENT_CALLBACKTYPE.FMOD_EVENT_CALLBACKTYPE_NET_MODIFIED;
import static org.jouvieje.fmoddesigner.enumerations.FMOD_EVENT_PROPERTY.FMOD_EVENTPROPERTY_PITCH;
import static org.jouvieje.fmoddesigner.enumerations.FMOD_EVENT_PROPERTY.FMOD_EVENTPROPERTY_VOLUME;
import static org.jouvieje.fmodex.defines.FMOD_INITFLAGS.FMOD_INIT_NORMAL;
import static org.jouvieje.fmodex.defines.VERSIONS.NATIVEFMODEX_JAR_VERSION;
import static org.jouvieje.fmodex.defines.VERSIONS.NATIVEFMODEX_LIBRARY_VERSION;
import static org.jouvieje.fmodex.enumerations.FMOD_RESULT.FMOD_OK;
import static org.jouvieje.fmodex.utils.BufferUtils.newIntBuffer;
import org.jouvieje.fmodex.utils.JARFileSystem;
import org.jouvieje.fmoddesigner.Event;
import org.jouvieje.fmoddesigner.EventGroup;
import org.jouvieje.fmoddesigner.EventSystem;
import org.jouvieje.fmoddesigner.FmodDesigner;
import org.jouvieje.fmoddesigner.InitFmodDesigner;
import org.jouvieje.fmoddesigner.callbacks.FMOD_EVENT_CALLBACK;
import org.jouvieje.fmoddesigner.enumerations.FMOD_EVENT_CALLBACKTYPE;
import org.jouvieje.fmoddesigner.enumerations.FMOD_EVENT_PROPERTY;
import org.jouvieje.fmoddesigner.structures.FMOD_EVENT_LOADINFO;
import org.jouvieje.fmodex.FmodEx;
import org.jouvieje.fmodex.Init;
import org.jouvieje.fmodex.System;

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
public class RealtimeTweaking extends ConsoleGUI {
	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args) {
		new FmodExExampleFrame(new RealtimeTweaking());
	}

	private boolean init = false;
	private boolean deinit = false;

	private EventSystem eventsystem = new EventSystem();

	private final static int NUM_EVENTS = 3;

	public RealtimeTweaking() {
		super();
		initialize();
	}

	public JPanel getPanel() {
		return this;
	}

	public String getTitle() {
		return "FMOD Designer RealtimeTweaking example.";
	}

	private void errorCheck(FMOD_RESULT result) {
		if(result != FMOD_RESULT.FMOD_OK) {
			printfExit("FMOD error! (%d) %s\n", result.asInt(), FmodEx.FMOD_ErrorString(result));
		}
	}

	private FMOD_EVENT_CALLBACK eventcallback = new FMOD_EVENT_CALLBACK(){
		public FMOD_RESULT FMOD_EVENT_CALLBACK(Event event, FMOD_EVENT_CALLBACKTYPE type, Pointer param1,
				Pointer param2, Pointer userdata) {
			if(type == FMOD_EVENT_CALLBACKTYPE_NET_MODIFIED) {
				/*
				 * From FMOD Ex doc :
				 * When the event callback is called. 'param1' and 'param2' mean different things depending on the type of callback.
				 * Here the contents of param1 and param2 are listed.
				 * The parameters are void *, but should be cast to the listed C type to get the correct value.
				 *  - FMOD_EVENT_CALLBACKTYPE_NET_MODIFIED
				 *     param1 = (EVENT_PROPERTY) which property was modified.
				 *     param2 = (float) the new property value. 
				 */
				FMOD_EVENT_PROPERTY eventProperty = FMOD_EVENT_PROPERTY.get(param1);
				float t = param2 == null ? 0.0f : param2.asFloat();
				printf("%s %f (%d)\n",
						eventProperty == FMOD_EVENTPROPERTY_VOLUME ? "volume" :
							eventProperty == FMOD_EVENTPROPERTY_PITCH ? "pitch" :
								"???", t, userdata.asInt());
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
		Event[] event = new Event[NUM_EVENTS];
		IntBuffer userdata = newIntBuffer(1);
		String[] event_name = new String[] {
			"Basics/SimpleEventWithLooping",
			"SequencingAndStitching/LoopLogic",
			"3D Events/2D-3DPanMorph"
		};

		printf("======================================================================\n");
		printf("Realtime Tweaking. Copyright (c) Firelight Technologies 2004-2009.\n");
		printf("======================================================================\n");
		printf("This example shows how to initialize the FMOD Net Event System so that\n");
		printf("FMOD Designer can connect to your game and tweak events as they're\n");
		printf("playing.\n");
		printf("Start some events then connect to this app using the Audition menu\n");
		printf("in FMOD Designer. You can use 127.0.0.1 for the IP address if you\n");
		printf("don't want to use two machines. Load tutorials.fdp and change the \n");
		printf("volume of the playing events using the volume slider in the event\n");
		printf("property sheet\n");
		printf("======================================================================\n\n");

		errorCheck(FmodDesigner.EventSystem_Create(eventsystem));

		IntBuffer version = newIntBuffer(1);
		errorCheck(eventsystem.getVersion(version));
		if(version.get(0) < FMOD_EVENT_VERSION) {
			printfExit("Error!  You are using an old version of FMOD EVENT %08x.  This program requires %08x\n", version.get(0), FMOD_EVENT_VERSION);
			return;
		}

		errorCheck(FmodDesigner.NetEventSystem_Init(eventsystem));
		errorCheck(eventsystem.init(64, FMOD_INIT_NORMAL, null, FMOD_EVENT_INIT_NORMAL));
//		errorCheck(eventsystem.setMediaPath("DesignerMedia"));
//		errorCheck(eventsystem.load("examples.fev", null, null));
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
		errorCheck(eventsystem.getGroup("examples/FeatureDemonstration", false, eventgroup));

		for(int i = 0; i < NUM_EVENTS; i++) {
			event[i] = new Event();
		}

		printf("======================================================================\n");
		printf("Press 1 - 3  to start/stop events\n");
		printf("Press e      to quit\n");
		printf("======================================================================\n");

		boolean exit = false;
		do {
			char c = getKey();
			if(c == 'e' || c == 'E') {
				exit = true;
			}
			else if((c >= '1') && (c <= '3')) {
				int i = c - '1';

				if(!event[i].isNull()) {
					errorCheck(event[i].stop(false));
					event[i] = new Event();
					printf("Stopping '%s'\n", event_name[i]);
				}
				else {
					errorCheck(eventgroup.getEvent(event_name[i], FMOD_EVENT_DEFAULT, event[i]));
					userdata.put(0, userdata.get(0) + 1);
					errorCheck(event[i].setCallback(eventcallback, BufferUtils.asPointer(userdata)));

					errorCheck(event[i].start());
					printf("Starting '%s'\n", event_name[i]);
				}
			}

			errorCheck(eventsystem.update());
			errorCheck(FmodDesigner.NetEventSystem_Update());

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

			errorCheck(eventsystem.release());
		}
		errorCheck(FmodDesigner.NetEventSystem_Shutdown());

		printExit("Shutdown\n");
	}
}