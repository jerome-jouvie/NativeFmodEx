/*===============================================================================================
InfoData Example
Copyright (c), Firelight Technologies Pty, Ltd 2004-2010.

Demonstrates basic usage of FMOD's data-driven event library (fmod_event.dll)
===============================================================================================*/

package org.jouvieje.fmoddesigner.examples;

import java.nio.ByteBuffer;
import javax.swing.JPanel;

import static org.jouvieje.fmoddesigner.defines.FMOD_EVENT_INITFLAGS.FMOD_EVENT_INIT_NORMAL;
import static org.jouvieje.fmoddesigner.defines.FMOD_EVENT_MODE.FMOD_EVENT_DEFAULT;
import static org.jouvieje.fmoddesigner.defines.VERSIONS.NATIVEFMODDESIGNER_JAR_VERSION;
import static org.jouvieje.fmoddesigner.defines.VERSIONS.NATIVEFMODDESIGNER_LIBRARY_VERSION;
import static org.jouvieje.fmoddesigner.defines.FMOD_EVENT_STATE.FMOD_EVENT_STATE_PLAYING;
import static org.jouvieje.fmoddesigner.defines.FMOD_EVENT_MODE.FMOD_EVENT_INFOONLY;
import static org.jouvieje.fmodex.defines.FMOD_INITFLAGS.FMOD_INIT_NORMAL;
import static org.jouvieje.fmodex.defines.VERSIONS.NATIVEFMODEX_JAR_VERSION;
import static org.jouvieje.fmodex.defines.VERSIONS.NATIVEFMODEX_LIBRARY_VERSION;
import static org.jouvieje.fmodex.enumerations.FMOD_RESULT.FMOD_OK;
import static org.jouvieje.fmodex.enumerations.FMOD_RESULT.FMOD_ERR_INVALID_HANDLE;
import static org.jouvieje.fmodex.utils.BufferUtils.newByteBuffer;
import static org.jouvieje.fmodex.utils.BufferUtils.SIZEOF_FLOAT;

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
public class InfoOnly extends ConsoleGUI {
	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args) {
		new FmodExExampleFrame(new InfoOnly());
	}

	private boolean init = false;
	private boolean deinit = false;

	private EventSystem eventsystem = new EventSystem();
	private EventGroup eventgroup = new EventGroup();
	
	public InfoOnly() {
		super();
		initialize();
	}

	public JPanel getPanel() {
		return this;
	}

	public String getTitle() {
		return "FMOD Designer InfoOnly example.";
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

		Event event = new Event();

		ByteBuffer buffer = newByteBuffer(SIZEOF_FLOAT);
		ByteBuffer buffer2 = newByteBuffer(SIZEOF_FLOAT);
		
	    printf("======================================================================\n");
	    printf("Info-only Event Example.  Copyright (c) Firelight Technologies 2004-2009.\n");
	    printf("==============================-------=================================\n");
	    printf("This demonstrates usage and functionality of info-only events.\n");
	    printf("======================================================================\n\n");

		errorCheck(FmodDesigner.EventSystem_Create(eventsystem));
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

		errorCheck(eventsystem.getGroup("examples/FeatureDemonstration/Basics", false, eventgroup));
		
	    printf("======================================================================\n");
	    printf("Press 'i'        to get an info-only event\n");
	    printf("Press 'o'        to get an event instance\n");
	    printf("Press 'u'        to unload all event data\n");
	    printf("Press '0' - '9'  to set event volume between 10%% - 100%%\n");
	    printf("Press Space      to start/stop the current event\n");
	    printf("Press 'e'        to quit\n");
	    printf("======================================================================\n");

		boolean exit = false;
		do {
			boolean state_changed = false;
			
			char key = getKey();
			switch(key) {
				case 'i': case 'I':
				{
					/* Get an info-only event.
					 * Notes:
					 * - This is the parent from which all instances of the
					 *   specified event are derived.
					 * - This call will not allocate memory for event instances or
					 *   load sample data.
					 * - The resulting event cannot be played, it simply allows
					 *   querying and setting of event properties.
					 * - Any properties which are set on the info-only event will be
					 *   copied to all instances which are retrieved from then on.
					 */
					errorCheck(eventgroup.getEvent("SimpleEventWithLooping", FMOD_EVENT_INFOONLY, event));
					printf("getEvent(FMOD_EVENT_INFOONLY) succeeded\n");
					state_changed = true;
				}
				break;
				case 'o': case 'O':
				{
					/* Get an event instance.
					 * Notes:
					 * - This call will allocate memory for event instances and
					 *   load sample data if required.
					 * - The resulting event can be played.
					 * - Any properties which have been set on the info-only event
					 *   will be copied to this instance.
					 */
					errorCheck(eventgroup.getEvent("SimpleEventWithLooping", FMOD_EVENT_DEFAULT, event));
					printf("getEvent(FMOD_EVENT_DEFAULT) succeeded\n");
					state_changed = true;
				}
				break;
				case ' ':
				{
					if(!event.isNull()) {
						FMOD_RESULT result = event.getState(buffer.asIntBuffer());
						final int state = buffer.getInt(0);
						if(result != FMOD_ERR_INVALID_HANDLE) {
							errorCheck(result);
						}

						if((state & FMOD_EVENT_STATE_PLAYING) != 0) {
							/* Attempt to stop the event.
							 * - This will fail if the event is info-only.
							 */
							result = event.stop(false);
							if(result == FMOD_OK) {
								printf("event.stop() succeeded\n");
								state_changed = true;
								
							}
							else {
								printf("event.stop() returned an error:\n\t(%d) %s\n",
										result.asInt(), FmodEx.FMOD_ErrorString(result));
							}
						}
						else {
							/* Attempt to start the event.
							   - This will fail if the event is info-only.
							 */
							result = event.start();
							if(result == FMOD_OK) {
								printf("event.start() succeeded\n");
								state_changed = true;
							}
							else {
								printf("event.start() returned an error:\n\t(%d) %s\n",
										result.asInt(), FmodEx.FMOD_ErrorString(result));
							}
						}
					}
				}
				break;
				case '0': case '1': case '2': case '3': case '4': case '5': case '6': case '7': case '8': case '9':
				{
					if(!event.isNull()) {
						/* Attempt to set the event's volume.
						 * - This will succeed on both info-only events and instances.
						 * - Volume set on the info-only event will be copied to
						 *   all instances retrieved from now on.
						 * - Volume set on an instance will only apply to that instance.
						 */
						float volume = (float)(key - '0');

						if(volume == 0) {
							volume = 10.0f;
						}

						volume /= 10.0f;

						FMOD_RESULT result = event.setVolume(volume);
						if(result == FMOD_OK) {
							printf("event.setVolume() succeeded\n");
							state_changed = true;
						}
						else {
							printf("event.setVolume() returned an error:\n\t(%d) %s\n",
									result.asInt(), FmodEx.FMOD_ErrorString(result));
						}
					}
				}
				break;
				case 'u':
				{
					errorCheck(eventgroup.freeEventData(null, true));
					printf("Event data unloaded\n");
					state_changed = true;
				}
				break;

				case 'e':
				case 'E':
					exit = true;
					break;
			}

			if (state_changed) {
				errorCheck(FmodEx.Memory_GetStats(buffer.asIntBuffer(), buffer2.asIntBuffer(), true));
				final int memory_current = buffer.getInt(0);
				final int memory_max = buffer2.getInt(0);

				printf("Memory usage: current = %10d, max = %10d\n", memory_current, memory_max);

				if (!event.isNull()) {
					/* Attempt to get the event's volume.
					 *  - This will succeed on both info-only events and instances.
					 */
					FMOD_RESULT result = event.getVolume(buffer.asFloatBuffer());
					float volume = buffer.getFloat(0);
					if (result != FMOD_ERR_INVALID_HANDLE) {
						errorCheck(result);
						printf("Volume: %.2f\n", volume);
					}
				}
				
				state_changed = false;
			}
	        
			errorCheck(eventsystem.update());

			try {
				Thread.sleep(15);
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

		if(!eventgroup.isNull()) {
			errorCheck(eventgroup.freeEventData(null, true));
		}
		if(!eventsystem.isNull()) {
			System system = new System();
			eventsystem.getSystemObject(system);
			system.setFileSystem(null, null, null, null, null, null, -1);

			errorCheck(eventsystem.release());
		}

		printExit("Shutdown\n");
	}
}