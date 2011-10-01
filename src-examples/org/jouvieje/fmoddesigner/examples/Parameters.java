/*===============================================================================================
Parameters Example
Copyright (c), Firelight Technologies Pty, Ltd 2004-2010.

Demonstrates basic usage of FMOD's data-driven event library (fmod_event.dll)
===============================================================================================*/

package org.jouvieje.fmoddesigner.examples;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

import javax.swing.JPanel;

import static org.jouvieje.fmoddesigner.defines.FMOD_EVENT_INITFLAGS.FMOD_EVENT_INIT_NORMAL;
import static org.jouvieje.fmoddesigner.defines.FMOD_EVENT_MODE.FMOD_EVENT_DEFAULT;
import static org.jouvieje.fmoddesigner.defines.VERSIONS.NATIVEFMODDESIGNER_JAR_VERSION;
import static org.jouvieje.fmoddesigner.defines.VERSIONS.NATIVEFMODDESIGNER_LIBRARY_VERSION;
import static org.jouvieje.fmodex.defines.FMOD_INITFLAGS.FMOD_INIT_NORMAL;
import static org.jouvieje.fmodex.defines.VERSIONS.NATIVEFMODEX_JAR_VERSION;
import static org.jouvieje.fmodex.defines.VERSIONS.NATIVEFMODEX_LIBRARY_VERSION;
import static org.jouvieje.fmodex.utils.BufferUtils.newByteBuffer;
import static org.jouvieje.fmodex.utils.BufferUtils.newFloatBuffer;

import org.jouvieje.fmodex.utils.JARFileSystem;
import org.jouvieje.fmoddesigner.Event;
import org.jouvieje.fmoddesigner.EventCategory;
import org.jouvieje.fmoddesigner.EventGroup;
import org.jouvieje.fmoddesigner.EventParameter;
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
public class Parameters extends ConsoleGUI {
	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args) {
		new FmodExExampleFrame(new Parameters());
	}

	private boolean init = false;
	private boolean deinit = false;

	private EventSystem eventsystem = new EventSystem();
	
	private final float UPDATE_INTERVAL = 100.0f;

	public Parameters() {
		super();
		initialize();
	}

	public JPanel getPanel() {
		return this;
	}

	public String getTitle() {
		return "FMOD Designer Parameters example.";
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
		
		EventGroup eventgroup = new EventGroup();
		EventCategory mastercategory = new EventCategory();
		Event car = new Event();
		EventParameter rpm = new EventParameter();
		EventParameter load = new EventParameter();

		ByteBuffer buff = newByteBuffer(1);
		FloatBuffer buff1 = newFloatBuffer(1);
		FloatBuffer buff2 = newFloatBuffer(1);
		
		float rpm_val, rpm_min, rpm_max, rpm_increment, load_val, load_min, load_max, load_increment;

		printf("======================================================================\n");
		printf("Parameters Example.  Copyright (c) Firelight Technologies 2004-2009.\n");
		printf("==============================-------=================================\n");
		printf("This demonstrates the use of FMOD event parameters. It simply plays an\n");
		printf("event, retrieves the parameters and allows the user to adjust them.\n");
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

		errorCheck(eventsystem.getGroup("examples/AdvancedTechniques", FMOD_EVENT_DEFAULT != 0, eventgroup));
		errorCheck(eventgroup.getEvent("car", FMOD_EVENT_DEFAULT, car));

		errorCheck(eventsystem.getCategory("master", mastercategory));

		errorCheck(car.getParameter("load", load));
		errorCheck(load.getRange(buff1, buff2)); load_min = buff1.get(0); load_max = buff2.get(0);
		errorCheck(load.setValue(load_max));

		errorCheck(car.getParameterByIndex(0, rpm));
		errorCheck(rpm.getRange(buff1, buff2)); rpm_min = buff1.get(0); rpm_max = buff2.get(0);
		errorCheck(rpm.setValue(1000.0f));

		errorCheck(car.start());

		printf("======================================================================\n");
		printf("Press '<' or ',' to decrease RPM\n");
		printf("Press '>' or '.' to increase RPM\n");
		printf("Press '-' or '_' to decrease load\n");
		printf("Press '+' or '=' to increase load\n");
		printf("Press 'e'        to quit\n");
		printf("======================================================================\n");

		rpm_increment = (rpm_max - rpm_min) / UPDATE_INTERVAL;
		errorCheck(rpm.getValue(buff1)); rpm_val = buff1.get(0);
		load_increment = (load_max - load_min) / UPDATE_INTERVAL;
		errorCheck(load.getValue(buff1)); load_val = buff1.get(0);

		boolean exit = false;
		do {
			switch(getKey()) {
				case '<': case ',':
				{
					rpm_val -= rpm_increment;
					if(rpm_val < rpm_min) {
						rpm_val = rpm_min;
					}

					errorCheck(rpm.setValue(rpm_val));
				}
				break;
				case '>': case ';':
				{
					rpm_val += rpm_increment;
					if(rpm_val > rpm_max) {
						rpm_val = rpm_max;
					}

					errorCheck(rpm.setValue(rpm_val));
				}
				break;
				case'-': case '_':
				{
					load_val -= load_increment;
					if (load_val < load_min) {
						load_val = load_min;
					}

					errorCheck(load.setValue(load_val));
				}
				break;
				case '+': case '=':
				{
					load_val += load_increment;
					if (load_val > load_max) {
						load_val = load_max;
					}

					errorCheck(load.setValue(load_val));
				}
				break;
				case ' ':
				{
					errorCheck(mastercategory.getPaused(buff));
					boolean paused = !(buff.get(0) != 0);
					errorCheck(mastercategory.setPaused(paused));
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

			printfr("RPM = %.4f, load = %.4f", rpm_val, load_val);
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