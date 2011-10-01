/*===============================================================================================
MusicSystem Example
Copyright (c), Firelight Technologies Pty, Ltd 2004-2010.

Demonstrates basic usage of FMOD's data-driven event library (fmod_event.dll)
===============================================================================================*/

package org.jouvieje.fmoddesigner.examples;

import java.nio.ByteBuffer;

import javax.swing.JPanel;

import static org.jouvieje.fmoddesigner.defines.FMOD_EVENT_INITFLAGS.FMOD_EVENT_INIT_NORMAL;
import static org.jouvieje.fmoddesigner.defines.VERSIONS.NATIVEFMODDESIGNER_JAR_VERSION;
import static org.jouvieje.fmoddesigner.defines.VERSIONS.NATIVEFMODDESIGNER_LIBRARY_VERSION;
import static org.jouvieje.fmodex.defines.FMOD_INITFLAGS.FMOD_INIT_NORMAL;
import static org.jouvieje.fmodex.defines.VERSIONS.NATIVEFMODEX_JAR_VERSION;
import static org.jouvieje.fmodex.defines.VERSIONS.NATIVEFMODEX_LIBRARY_VERSION;
import static org.jouvieje.fmodex.utils.BufferUtils.newByteBuffer;
import static org.jouvieje.fmodex.utils.BufferUtils.SIZEOF_FLOAT;

import org.jouvieje.fmodex.utils.JARFileSystem;
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

/**
 * Based on FMOD Ex C++ example. Ported to Java with NativeFmodEx by Jérôme JOUVIE (Jouvieje.
 * 
 * @author Jérôme JOUVIE (Jouvieje)
 * @site   http://jerome.jouvie.free.fr/
 * @mail   jerome.jouvie@gmail.com
 */
public class MusicSystem_ extends ConsoleGUI {
	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args) {
		new FmodExExampleFrame(new MusicSystem_());
	}

	private boolean init = false;
	private boolean deinit = false;

	private EventSystem eventsystem = new EventSystem();

	private final int MUSICCUE_EXAMPLES_COUNTRY_ARENA = 22;
	private final int MUSICCUE_EXAMPLES_STEALTH_ARENA = 19;
	private final int MUSICCUE_EXAMPLES_RETRO_ROCK_ARENA = 30;
	private final int MUSICPARAM_EXAMPLES_RETRO_ROCK_INTENSITY = 8;

	public MusicSystem_() {
		super();
		initialize();
	}

	public JPanel getPanel() {
		return this;
	}

	public String getTitle() {
		return "FMOD Designer MusicSystem example.";
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

	    MusicSystem musicsystem = new MusicSystem();
	    MusicPrompt country = new MusicPrompt();
	    MusicPrompt stealth = new MusicPrompt();
	    MusicPrompt retrorock = new MusicPrompt();
	    
	    ByteBuffer buffer = newByteBuffer(SIZEOF_FLOAT);

		printf("======================================================================\n");
		printf("Music System Example.  Copyright (c) Firelight Technologies 2004-2009.\n");
		printf("======================================================================\n");
		printf("Press '1'       to activate/deactivate country cue.\n");
		printf("Press '2'       to activate/deactivate stealth cue.\n");
		printf("Press '3'       to activate/deactivate retro rock cue.\n");
		printf("Press '<' / '>' to decrease/increase retro rock intensity parameter.\n");
		printf("Press 'z'       Exit\n");
		printf("======================================================================\n");

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
		
		errorCheck(eventsystem.getMusicSystem(musicsystem));

		errorCheck(musicsystem.prepareCue(MUSICCUE_EXAMPLES_COUNTRY_ARENA, country));
		errorCheck(musicsystem.prepareCue(MUSICCUE_EXAMPLES_STEALTH_ARENA, stealth));
		errorCheck(musicsystem.prepareCue(MUSICCUE_EXAMPLES_RETRO_ROCK_ARENA, retrorock));
		
	    /*
	     * Start off with country cue active
	     */
		errorCheck(country.begin());

		boolean exit = false;
		do {
			boolean active = false;
			switch(getKey()) {
				case '1':
				{
					errorCheck(country.isActive(buffer));
					active = buffer.get(0) != 0;
					if(!active) {
						errorCheck(country.begin());
						printf("Country cue begin\n");
					}
					else {
						errorCheck(country.end());
						printf("Country cue end\n");
					}
				}
				break;
				case '2':
				{
					errorCheck(stealth.isActive(buffer));
					active = buffer.get(0) != 0;
					if(!active) {
						errorCheck(stealth.begin());
						printf("Stealth cue begin\n");
					}
					else {
						errorCheck(stealth.end());
						printf("Stealth cue end\n");
					}
				}
				break;
				case '3':
				{
					errorCheck(retrorock.isActive(buffer));
					active = buffer.get(0) != 0;
					if(!active) {
						errorCheck(retrorock.begin());
						printf("Retro rock cue begin\n");
					}
					else {
						errorCheck(retrorock.end());
						printf("Retro rock cue end\n");
					}
				}
				break;
				case '<':
				case ',':
				{
					errorCheck(musicsystem.getParameterValue(MUSICPARAM_EXAMPLES_RETRO_ROCK_INTENSITY, buffer.asFloatBuffer()));
					float intensity = buffer.getFloat(0);

					intensity -= 3.3f;
					if(intensity < 0.0f) {
						intensity = 0.0f;
					}

					errorCheck(musicsystem.setParameterValue(MUSICPARAM_EXAMPLES_RETRO_ROCK_INTENSITY, intensity));
				}
				break;
				case '>': case ';':
				{
					errorCheck(musicsystem.getParameterValue(MUSICPARAM_EXAMPLES_RETRO_ROCK_INTENSITY, buffer.asFloatBuffer()));
					float intensity = buffer.getFloat(0);

					intensity += 3.3f;
					if(intensity > 9.9f) {
						intensity = 9.9f;
					}

					errorCheck(musicsystem.setParameterValue(MUSICPARAM_EXAMPLES_RETRO_ROCK_INTENSITY, intensity));
				}
					break;

				case 'e':
				case 'E':
					exit = true;
					break;
			}

			errorCheck(eventsystem.update());

			try {
				Thread.sleep(15);
			}
			catch(InterruptedException e) {}
			
            musicsystem.getParameterValue(MUSICPARAM_EXAMPLES_RETRO_ROCK_INTENSITY, buffer.asFloatBuffer());
            final float intensity = buffer.getFloat(0);
            printfr("retro rock intensity : %.02f", intensity);
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

		printExit("Shutdown\n");
	}
}