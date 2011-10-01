/*==================================================================================================
 3D Reverb Example
 Copyright (c), Firelight Technologies Pty, Ltd 2005-2010.

 Example to demonstrate 3d reverb spheres, global reverb, multiple reverb instances and music reverb
===================================================================================================*/

package org.jouvieje.fmoddesigner.examples;

import static org.jouvieje.fmoddesigner.defines.FMOD_EVENT_INITFLAGS.FMOD_EVENT_INIT_NORMAL;
import static org.jouvieje.fmoddesigner.defines.FMOD_EVENT_MODE.FMOD_EVENT_DEFAULT;
import static org.jouvieje.fmoddesigner.defines.FMOD_EVENT_STATE.FMOD_EVENT_STATE_PLAYING;
import static org.jouvieje.fmoddesigner.defines.VERSIONS.NATIVEFMODDESIGNER_JAR_VERSION;
import static org.jouvieje.fmoddesigner.defines.VERSIONS.NATIVEFMODDESIGNER_LIBRARY_VERSION;
import static org.jouvieje.fmodex.defines.FMOD_INITFLAGS.FMOD_INIT_3D_RIGHTHANDED;
import static org.jouvieje.fmodex.defines.FMOD_REVERB_PRESETS.*;
import static org.jouvieje.fmodex.defines.FMOD_REVERB_CHANNELFLAGS.*;
import static org.jouvieje.fmodex.defines.VERSIONS.NATIVEFMODEX_JAR_VERSION;
import static org.jouvieje.fmodex.defines.VERSIONS.NATIVEFMODEX_LIBRARY_VERSION;
import static org.jouvieje.fmodex.utils.BufferUtils.newByteBuffer;
import static org.jouvieje.fmodex.utils.SizeOfPrimitive.SIZEOF_FLOAT;

import java.nio.ByteBuffer;

import javax.swing.JPanel;

import org.jouvieje.fmoddesigner.Event;
import org.jouvieje.fmoddesigner.EventReverb;
import org.jouvieje.fmoddesigner.EventSystem;
import org.jouvieje.fmoddesigner.FmodDesigner;
import org.jouvieje.fmoddesigner.InitFmodDesigner;
import org.jouvieje.fmoddesigner.MusicPrompt;
import org.jouvieje.fmoddesigner.MusicSystem;
import org.jouvieje.fmoddesigner.structures.FMOD_EVENT_LOADINFO;
import org.jouvieje.fmodex.FmodEx;
import org.jouvieje.fmodex.Init;
import org.jouvieje.fmodex.System;
import org.jouvieje.fmodex.enumerations.FMOD_RESULT;
import org.jouvieje.fmodex.examples.utils.ConsoleGUI;
import org.jouvieje.fmodex.examples.utils.FmodExExampleFrame;
import org.jouvieje.fmodex.examples.utils.Medias;
import org.jouvieje.fmodex.exceptions.InitException;
import org.jouvieje.fmodex.structures.FMOD_REVERB_CHANNELPROPERTIES;
import org.jouvieje.fmodex.structures.FMOD_REVERB_PROPERTIES;
import org.jouvieje.fmodex.structures.FMOD_VECTOR;
import org.jouvieje.fmodex.utils.JARFileSystem;

/**
 * Based on FMOD Ex C++ example. Ported to Java with NativeFmodEx by Jérôme JOUVIE (Jouvieje.
 * 
 * @author Jérôme JOUVIE (Jouvieje)
 * @site   http://jerome.jouvie.free.fr/
 * @mail   jerome.jouvie@gmail.com
 */
public class _3dReverb extends ConsoleGUI {
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		new FmodExExampleFrame(new _3dReverb());
	}

	private boolean init = false;
	private boolean deinit = false;

	private EventSystem eventsystem = new EventSystem();
	private Event event = new Event();
	private MusicSystem musicsystem = new MusicSystem();
	private MusicPrompt musicprompt = new MusicPrompt();
	private EventReverb eventreverb1 = new EventReverb();
	private EventReverb eventreverb2 = new EventReverb();

	private final int   INTERFACE_UPDATETIME = 80; // 80ms update for interface
	private final float DISTANCEFACTOR = 1.0f;     // Units per meter.  I.e feet would = 3.28
	
	private final int MUSICCUE_EXAMPLES_ENTER_MENU__VIBES_ = 24;

	public _3dReverb() {
		super();
		initialize();
	}

	public JPanel getPanel() {
		return this;
	}

	public String getTitle() {
		return "FMOD Designer 3D Reverb example.";
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

		ByteBuffer buffer = newByteBuffer(SIZEOF_FLOAT);
		
		printf("======================================================================\n");
		printf("3D Reverb Example.  Copyright (c) Firelight Technologies 2004-2010.\n");
		printf("======================================================================\n");
		printf("This demonstrates 3d reverb spheres as well as global reverb,\n");
		printf("multiple reverb instances and music reverb\n");
		printf("======================================================================\n\n");

		/*
	        Create a event system object and initialize.
		 */
		errorCheck(FmodDesigner.EventSystem_Create(eventsystem));
		errorCheck(eventsystem.init(64, FMOD_INIT_3D_RIGHTHANDED, null, FMOD_EVENT_INIT_NORMAL));
//	    errorCheck(eventsystem.setMediaPath("/DesignerMedia/"));
//	    errorCheck(eventsystem.load("examples.fev", 0, 0));
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

		errorCheck(eventsystem.getEvent("examples/FeatureDemonstration/Basics/SimpleEvent", FMOD_EVENT_DEFAULT, event));
//		errorCheck(eventsystem.getEvent("examples/FeatureDemonstration/Basics/FootStep", FMOD_EVENT_DEFAULT, event));
		errorCheck(eventsystem.getMusicSystem(musicsystem));
		errorCheck(musicsystem.prepareCue(MUSICCUE_EXAMPLES_ENTER_MENU__VIBES_, musicprompt));
		errorCheck(eventsystem.createReverb(eventreverb1));
		errorCheck(eventsystem.createReverb(eventreverb2));

		/*
	        Initialize 3D reverb objects
	        (uses global reverb instance #0)
		 */    
		FMOD_VECTOR reverbposition = FMOD_VECTOR.allocate();
		
		FMOD_REVERB_PROPERTIES sphere1reverb = FMOD_REVERB_PROPERTIES.create(FMOD_PRESET_PSYCHOTIC);
		reverbposition.setX(-10.0f);
		reverbposition.setY(0);
		reverbposition.setZ(0);
		float mindistance = 10.0f;
		float maxdistance = 20.0f;
		errorCheck(eventreverb1.setProperties(sphere1reverb));
		errorCheck(eventreverb1.set3DAttributes(reverbposition, mindistance, maxdistance));
		errorCheck(eventreverb1.setActive(true));

		FMOD_REVERB_PROPERTIES sphere2reverb = FMOD_REVERB_PROPERTIES.create(FMOD_PRESET_SEWERPIPE);
		reverbposition.setX(10.0f);
		reverbposition.setY(0);
		reverbposition.setZ(0);
		mindistance = 10.0f;
		maxdistance = 20.0f;
		errorCheck(eventreverb2.setProperties(sphere2reverb));
		errorCheck(eventreverb2.set3DAttributes(reverbposition, mindistance, maxdistance));
		errorCheck(eventreverb2.setActive(true));
		
		reverbposition.release(); reverbposition = null;

		/*
	        Setup ambient reverb
		 */
		FMOD_REVERB_PROPERTIES ambientreverb = FMOD_REVERB_PROPERTIES.create(FMOD_PRESET_ROOM);
		errorCheck(eventsystem.setReverbAmbientProperties(ambientreverb));

		/*
	        Setup global reverb instance #1 for music
		 */
		FMOD_REVERB_PROPERTIES musicreverb = FMOD_REVERB_PROPERTIES.create(FMOD_PRESET_GENERIC);
		musicreverb.setRoom(0);
		musicreverb.setInstance(1);
		errorCheck(eventsystem.setReverbProperties(musicreverb));

		/*
	        Turn off global reverb instance #1 for event
		 */
		FMOD_REVERB_CHANNELPROPERTIES reverbchannelproperties = FMOD_REVERB_CHANNELPROPERTIES.allocate();
		reverbchannelproperties.setFlags(FMOD_REVERB_CHANNELFLAGS_INSTANCE1);
		errorCheck(event.getReverbProperties(reverbchannelproperties));
		reverbchannelproperties.setRoom(-10000);                                          // wet level -10000 sets instance #1 off for this event
		errorCheck(event.setReverbProperties(reverbchannelproperties));

		/*
	        Start music and event
		 */
		errorCheck(musicprompt.begin());
		errorCheck(musicsystem.setVolume(0.5f));

		FMOD_VECTOR eventposition = FMOD_VECTOR.allocate(0, 0, 5.0f);
		FMOD_VECTOR eventvelocity = FMOD_VECTOR.allocate(0, 0, 0);
		errorCheck(event.set3DAttributes(eventposition, eventvelocity, null));
		errorCheck(event.start());
		eventposition.release();
		eventvelocity.release();


		printf("======================================================================\n");
		printf("Press 'm'           to activate/deactivate music.\n");
		printf("Press '+' / '-'     to decrease/increase music reverb wet level.\n");
		printf("Press 's'           to activate/deactivate event.\n");
		printf("Press ' '           to toggle auto listener update mode.\n");
		printf("Press '<' / '>'     to move listener while in auto update mode.\n");
		printf("Press E to quit\n");
		printf("----------------------------------------------------------------------\n");
		printf("1, 2 : centre of sphere; m : minimum distance; x : maximum distance   \n");
		printf("======================================================================\n\n");

		float t = 0;
		final FMOD_VECTOR listenerpos = FMOD_VECTOR.allocate(0.0f, 0.0f, 0.0f * DISTANCEFACTOR);
		final FMOD_VECTOR lastpos = FMOD_VECTOR.allocate(0.0f, 0.0f, 0.0f);
		final FMOD_VECTOR forward = FMOD_VECTOR.allocate(0.0f, 0.0f, 1.0f);
		final FMOD_VECTOR up      = FMOD_VECTOR.allocate(0.0f, 1.0f, 0.0f);
		final FMOD_VECTOR vel     = FMOD_VECTOR.allocate();
		boolean listenerflag = true;

		/*
		 * Main loop
		 */
		boolean exit = false;
		do {
			char key = getKey();
			switch(key) {
				case 's': case 'S': { // Toggle event on and off
					errorCheck(event.getState(buffer.asIntBuffer()));
					final int state = buffer.getInt(0);
					if ((state & FMOD_EVENT_STATE_PLAYING) != 0) {
						errorCheck(event.stop(true));
					}
					else {
						errorCheck(event.start());
					}
				} break;

				case 'm': case 'M': { // Toggle music on and off
					errorCheck(musicprompt.isActive(buffer));
					boolean active = (buffer.get(0) != 0);
					if (active) {
						errorCheck(musicprompt.end());
						errorCheck(musicsystem.reset());
					}
					else {
						errorCheck(musicprompt.begin());
					}
				} break;

				case '+': case '=': { // Increase music reverb
					reverbchannelproperties.setFlags(FMOD_REVERB_CHANNELFLAGS_INSTANCE1);
					errorCheck(musicsystem.getReverbProperties(reverbchannelproperties));

					reverbchannelproperties.setRoom(reverbchannelproperties.getRoom() + 100);
					if (reverbchannelproperties.getRoom() > 0) {
						reverbchannelproperties.setRoom(0);
					}

					errorCheck(musicsystem.setReverbProperties(reverbchannelproperties));
				} break;

				case '-': case '_': { // Decrease music reverb
					reverbchannelproperties.setFlags(FMOD_REVERB_CHANNELFLAGS_INSTANCE1);
					errorCheck(musicsystem.getReverbProperties(reverbchannelproperties));

					reverbchannelproperties.setRoom(reverbchannelproperties.getRoom() - 100);
					if (reverbchannelproperties.getRoom() < -2000) {
						reverbchannelproperties.setRoom(-2000);
					}

					errorCheck(musicsystem.setReverbProperties(reverbchannelproperties));
				} break;

				case ' ': { // Toggle listener update
					listenerflag = !listenerflag;
				} break;

				case '<': case ',': {
					if (!listenerflag) {
						listenerpos.setX(listenerpos.getX() - 1.0f * DISTANCEFACTOR);
						if (listenerpos.getX() < -35 * DISTANCEFACTOR) {
							listenerpos.setX(-35 * DISTANCEFACTOR);
						}
					}
				} break;

				case '>': case '.': {
					if (!listenerflag) {
						listenerpos.setX(listenerpos.getX() + 1.0f * DISTANCEFACTOR);
						if (listenerpos.getX() > 36 * DISTANCEFACTOR) {
							listenerpos.setX(36 * DISTANCEFACTOR);
						}
					}
				} break;

				case 'e': case 'E':
					exit = true;
					break;
			}

			// ==========================================================================================
			// UPDATE THE LISTENER
			// ==========================================================================================
			{
				if (listenerflag) {
					listenerpos.setX((float)Math.sin(t * 0.05f) * 33.0f * DISTANCEFACTOR); // left right pingpong
				}

				// vel = how far we moved last FRAME (m/f), then time compensate it to SECONDS (m/s).
				vel.setX((listenerpos.getX() - lastpos.getX()) * (1000 / INTERFACE_UPDATETIME));
				vel.setY((listenerpos.getY() - lastpos.getY()) * (1000 / INTERFACE_UPDATETIME));
				vel.setZ((listenerpos.getZ() - lastpos.getZ()) * (1000 / INTERFACE_UPDATETIME));

				// store pos for next time
				lastpos.set(listenerpos);

				errorCheck(eventsystem.set3DListenerAttributes(0, listenerpos, vel, forward, up));

				t += (30 * (1.0f / INTERFACE_UPDATETIME));    // t is just a time value .. it increments in 30m/s steps in this example

				// print out a small visual display
				{
					byte[] s = ".....x.........m.........1.........|.........2.........m.........x.......".getBytes();
					s[(int)(listenerpos.getX() / DISTANCEFACTOR) + 35] = 'L';
					printfr("%s", new String(s));
				}
			}

			errorCheck(eventsystem.update());

			try {
				Thread.sleep(INTERFACE_UPDATETIME - 1);
			} catch(InterruptedException e) {}
		}
		while(!exit && !deinit);

		reverbchannelproperties.release();
		
		listenerpos.release();
		lastpos.release();
		forward.release();
		up.release();
		vel.release();

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

		printExit("Shutdown\n");
	}
}