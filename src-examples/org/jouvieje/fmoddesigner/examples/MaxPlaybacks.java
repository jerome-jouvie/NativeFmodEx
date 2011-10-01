/*=============================================================================
 Max Playbacks Example
 Copyright (c), Firelight Technologies Pty, Ltd 2004-2010.

 Demonstrates basic usage of event max playbacks behaviour.
=============================================================================*/

package org.jouvieje.fmoddesigner.examples;

import java.nio.ByteBuffer;

import javax.swing.JPanel;

import static org.jouvieje.fmoddesigner.defines.FMOD_EVENT_INITFLAGS.FMOD_EVENT_INIT_NORMAL;
import static org.jouvieje.fmoddesigner.defines.FMOD_EVENT_MODE.FMOD_EVENT_DEFAULT;
import static org.jouvieje.fmoddesigner.defines.FMOD_EVENT_MODE.FMOD_EVENT_INFOONLY;
import static org.jouvieje.fmoddesigner.defines.VERSIONS.NATIVEFMODDESIGNER_JAR_VERSION;
import static org.jouvieje.fmoddesigner.defines.VERSIONS.NATIVEFMODDESIGNER_LIBRARY_VERSION;
import static org.jouvieje.fmodex.defines.FMOD_INITFLAGS.FMOD_INIT_NORMAL;
import static org.jouvieje.fmodex.defines.VERSIONS.NATIVEFMODEX_JAR_VERSION;
import static org.jouvieje.fmodex.defines.VERSIONS.NATIVEFMODEX_LIBRARY_VERSION;
import static org.jouvieje.fmodex.enumerations.FMOD_RESULT.FMOD_OK;

import org.jouvieje.fmodex.utils.JARFileSystem;
import org.jouvieje.fmodex.System;
import org.jouvieje.fmoddesigner.Event;
import org.jouvieje.fmoddesigner.EventGroup;
import org.jouvieje.fmoddesigner.EventParameter;
import org.jouvieje.fmoddesigner.EventSystem;
import org.jouvieje.fmoddesigner.FmodDesigner;
import org.jouvieje.fmoddesigner.InitFmodDesigner;
import org.jouvieje.fmoddesigner.structures.FMOD_EVENT_LOADINFO;
import org.jouvieje.fmodex.FmodEx;
import org.jouvieje.fmodex.Init;

import org.jouvieje.fmodex.enumerations.FMOD_RESULT;
import org.jouvieje.fmodex.examples.utils.ConsoleGUI;
import org.jouvieje.fmodex.examples.utils.FmodExExampleFrame;
import org.jouvieje.fmodex.examples.utils.Medias;
import org.jouvieje.fmodex.exceptions.InitException;
import org.jouvieje.fmodex.structures.FMOD_VECTOR;

/**
 * Based on FMOD Ex C++ example. Ported to Java with NativeFmodEx by Jérôme JOUVIE (Jouvieje.
 * 
 * @author Jérôme JOUVIE (Jouvieje)
 * @site   http://jerome.jouvie.free.fr/
 * @mail   jerome.jouvie@gmail.com
 */
public class MaxPlaybacks extends ConsoleGUI {
	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args) {
		new FmodExExampleFrame(new MaxPlaybacks());
	}

	private boolean init = false;
	private boolean deinit = false;

	private EventSystem eventsystem = new EventSystem();

	private float g_distance = 2.0f;
	private float g_sound = 0.0f;
	
	enum EventBehavior {
		StealOldest,
		StealNewest,
		StealQuietest,
		JustFail,
		JustFailIfQuietest
    }
    
	public MaxPlaybacks() {
		super();
		initialize();
	}

	public JPanel getPanel() {
		return this;
	}

	public String getTitle() {
		return "FMOD Designer MaxPlaybacks example.";
	}

	private void errorCheck(FMOD_RESULT result) {
		if(result != FMOD_RESULT.FMOD_OK) {
			printfExit("FMOD error! (%d) %s\n", result.asInt(), FmodEx.FMOD_ErrorString(result));
		}
	}

	private void setupEvent(Event event) {
		FMOD_VECTOR pos = FMOD_VECTOR.allocate(0, 0, g_distance);
		EventParameter param = new EventParameter();
		
		errorCheck(event.set3DAttributes(pos, null, null));
		errorCheck(event.getParameter("sound", param));
		errorCheck(param.setValue(g_sound));
		pos.release();
	}
	
	private void stopAllEvents(EventGroup eventgroup) {
		errorCheck(eventgroup.freeEventData(null, true));
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
		EventGroup eventgroup = new EventGroup();
		Event event = new Event();

		errorCheck(result = FmodDesigner.EventSystem_Create(eventsystem));
		errorCheck(result = eventsystem.init(64, FMOD_INIT_NORMAL, null, FMOD_EVENT_INIT_NORMAL));
//	    errorCheck(result = eventsystem.setMediaPath("DesignerMedia"));
//	    errorCheck(result = eventsystem.load("examples.fev", info, null));
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

		errorCheck(result = eventsystem.getGroup("examples/FeatureDemonstration/MaxPlayback", FMOD_EVENT_DEFAULT != 0, eventgroup));

		printf("======================================================================\n");
		printf("Max Playbacks Example.  Copyright (c) Firelight Technologies 2004-2009.\n");
		printf("----------------------------------------------------------------------\n");
	    printf("Press '1'     to select 'Steal oldest' behaviour\n");
	    printf("Press '2'     to select 'Steal newest' behaviour\n");
	    printf("Press '3'     to select 'Steal quietest' behaviour\n");
	    printf("Press '4'     to select 'Just fail' behaviour\n");
	    printf("Press '5'     to select 'Just fail if quietest' behaviour\n");
	    printf("Press Space   to start an event\n");
	    printf("Press 's'     to stop all events\n");
	    printf("Press '>' ';' to increase event distance\n");
	    printf("Press '<' ',' to decrease event distance\n");
	    printf("Press 'e' to quit\n");
		printf("======================================================================\n");

	    EventBehavior event_behaviour = EventBehavior.StealOldest;
	    
		boolean exit = false;
		do {
			switch(getKey()) {
                case '1' : // 'Steal oldest'
                    event_behaviour = EventBehavior.StealOldest;
                    stopAllEvents(eventgroup);
                    break;

                case '2' : // 'Steal newest'
                    event_behaviour = EventBehavior.StealNewest;
                    stopAllEvents(eventgroup);
                    break;

                case '3' : // 'Steal quietest'
                    event_behaviour = EventBehavior.StealQuietest;
                    stopAllEvents(eventgroup);
                    break;

                case '4' : // 'Just fail'
                    event_behaviour = EventBehavior.JustFail;
                    stopAllEvents(eventgroup);
                    break;

                case '5' : // 'Just fail if quietest'
                    event_behaviour = EventBehavior.JustFailIfQuietest;
                    stopAllEvents(eventgroup);
                    break;
					
                case ' ': // Play an event
                	String name = null;
					switch(event_behaviour) {
						case StealOldest:
							name = "MaxPlay-StealOldest";
							break;

						case StealNewest:
							name = "MaxPlay-StealNewest";
							break;

						case StealQuietest:
							name = "MaxPlay-StealQuietest";
							break;

						case JustFail:
							name = "MaxPlay-JustFail";
							break;

						case JustFailIfQuietest:
							name = "MaxPlay-JustFailIfQuietest";
							break;
					}

					// Clear the line
					printfr("");

					if(event_behaviour == EventBehavior.JustFailIfQuietest) {
						/* The 'Just fail if quietest' behaviour calculates the expected
						 * volume of the event based on the properties of the info-only
						 * event, so we have to get the info-only event first and set it*
						 * up appropriately.
						 */

						// get the info-only event to set up for volume calculation
						errorCheck(result = eventgroup.getEvent(name, FMOD_EVENT_INFOONLY, event));

						/* set the desired properties on the info-only event
						 * Notes:
						 * - distances below the event's 3D Min Distance all give the
						 *   same volume; in this case, getEvent will just fail
						 * - we could set other volume-affecting properties here as
						 *   well (e.g. orientation if the event has a falloff cone)
						 */
						setupEvent(event);

						// attempt to get a real event instance
						result = eventgroup.getEvent(name, FMOD_EVENT_DEFAULT, event);
						if(result == FMOD_OK) {
							printf("getEvent(\"%s\") succeeded\n", name);

							/*
							 * we don't need to set the position of the instance,
							 * as it is copied from the info-only event, but we
							 * do need to set the parameter value.
							 */
							EventParameter param = new EventParameter();
							errorCheck(result = event.getParameter("sound", param));
							errorCheck(result = param.setValue(g_sound));
							errorCheck(result = event.start());
						}
						else {
							printf("getEvent(\"%s\") failed\n", name);
						}
					}
					else {
						result = eventgroup.getEvent(name, FMOD_EVENT_DEFAULT, event);
						if(result == FMOD_OK) {
							printf("getEvent(\"%s\") succeeded\n", name);
							setupEvent(event);
							errorCheck(result = event.start());
						}
						else {
							printf("getEvent(\"%s\") failed\n", name);
						}
					}

					++g_sound;
					if(g_sound > 3) {
						g_sound = 0;
					}

					break;
                    
				case 's': case 'S':
					stopAllEvents(eventgroup);
					break;
					
				case '>' : case ';' :
                    g_distance += 0.1f;
					break;
				case '<' : case ',' :
                    g_distance -= 0.1f;
                    g_distance = (g_distance < 0.0f) ? 0.0f : g_distance;
                    break;
                    
				case 'e':
				case 'E':
					exit = true;
					break;
			}

			String name = null;
            switch(event_behaviour) {
				case StealOldest:
					name = "Steal oldest";
					break;

				case StealNewest:
					name = "Steal newest";
					break;

				case StealQuietest:
					name = "Steal quietest";
					break;

				case JustFail:
					name = "Just fail";
					break;

				case JustFailIfQuietest:
					name = "Just fail if quietest";
					break;
			}

            printfr("Sound = %1.0f, Distance = %4.1f, Behaviour = %s", g_sound, g_distance, name);

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