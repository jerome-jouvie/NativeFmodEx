/**
 * 			NativeFmodEx Project
 *
 * Want to use FMOD Ex API (www.fmod.org) in the Java language ? NativeFmodEx is made for you.
 * Copyright © 2005-2010 Jérôme JOUVIE (Jouvieje)
 *
 * Created on 23 feb. 2005
 * @version file v1.5.0
 * @author Jérôme JOUVIE (Jouvieje)
 * @site   http://jerome.jouvie.free.fr/
 * @mail   jerome.jouvie@gmail.com
 * 
 * INTRODUCTION
 * FMOD Ex is a music and sound effects system, by Firelight Technologies Pty, Ltd.
 * More informations can be found at:
 * 		http://www.fmod.org/
 * The aim of this project is to provide a java interface for this amazing sound API.
 * 
 * 
 * GNU LESSER GENERAL PUBLIC LICENSE
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public License
 * as published by the Free Software Foundation; either version 2.1 of the License,
 * or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library; if not, write to the
 * Free Software Foundation, Inc.,
 * 59 Temple Place, Suite 330,
 * Boston, MA 02111-1307 USA 
 */

package org.jouvieje.fmoddesigner;

import org.jouvieje.fmoddesigner.*;
import org.jouvieje.fmodex.exceptions.*;
import org.jouvieje.fmoddesigner.callbacks.*;
import org.jouvieje.fmoddesigner.*;
import org.jouvieje.fmoddesigner.defines.*;
import org.jouvieje.fmoddesigner.enumerations.*;
import org.jouvieje.fmoddesigner.structures.*;
import java.nio.*;
import org.jouvieje.fmodex.*;
import org.jouvieje.fmodex.System;
import org.jouvieje.fmodex.enumerations.*;
import org.jouvieje.fmodex.structures.*;
import org.jouvieje.fmodex.utils.*;

/**
 * 'EventSystem' API
 */
public class EventSystem extends Pointer {
	/**
	 * Create a view of the <code>Pointer</code> object as a <code>EventSystem</code> object.<br>
	 * This view is valid only if the memory holded by the <code>Pointer</code> holds a EventSystem object.
	 */
	public static EventSystem asEventSystem(Pointer pointer) {
		long address = Pointer.getPointer(pointer);
		if(address == 0) return null;
		return new EventSystem(address);
	}
	private EventSystem(long pointer) {
		super(pointer);
	}

	public EventSystem() {
		super(0);
	}

	/**
	 * 
	 */
	public FMOD_RESULT init(int maxchannels, int flags, Pointer extradriverdata, int eventflags) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.EventSystem_init(pointer, maxchannels, flags, Pointer.getPointer(extradriverdata), eventflags);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT release() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.EventSystem_release(pointer);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT update() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.EventSystem_update(pointer);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT setMediaPath(String path) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.EventSystem_setMediaPath(pointer, path == null ? null : path.getBytes());
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT setPluginPath(String path) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.EventSystem_setPluginPath(pointer, path == null ? null : path.getBytes());
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT getVersion(IntBuffer version) {
		if(pointer == 0) throw new NullPointerException();
		if(version != null && !version.isDirect()) {
			throw new NonDirectBufferException();
		}
		int javaResult = FmodDesignerJNI.EventSystem_getVersion(pointer, version, BufferUtils.getPositionInBytes(version));
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT getInfo(FMOD_EVENT_SYSTEMINFO info) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.EventSystem_getInfo(pointer, Pointer.getPointer(info));
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT getSystemObject(System system) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.EventSystem_getSystemObject(pointer, system);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT getMusicSystem(MusicSystem musicsystem) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.EventSystem_getMusicSystem(pointer, musicsystem);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT load(String name_or_data, FMOD_EVENT_LOADINFO loadinfo, EventProject project) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.EventSystem_load(pointer, name_or_data == null ? null : name_or_data.getBytes(), Pointer.getPointer(loadinfo), project);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT load(ByteBuffer name_or_data, FMOD_EVENT_LOADINFO loadinfo, EventProject project) {
		if(pointer == 0) throw new NullPointerException();
		if(name_or_data != null && !name_or_data.isDirect()) {
			throw new NonDirectBufferException();
		}
		int javaResult = FmodDesignerJNI.EventSystem_load(pointer, name_or_data, BufferUtils.getPositionInBytes(name_or_data), Pointer.getPointer(loadinfo), project);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT unload() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.EventSystem_unload(pointer);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT getProject(String name, EventProject project) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.EventSystem_getProject(pointer, name == null ? null : name.getBytes(), project);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT getProjectByIndex(int index, EventProject project) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.EventSystem_getProjectByIndex(pointer, index, project);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT getNumProjects(IntBuffer numprojects) {
		if(pointer == 0) throw new NullPointerException();
		if(numprojects != null && !numprojects.isDirect()) {
			throw new NonDirectBufferException();
		}
		int javaResult = FmodDesignerJNI.EventSystem_getNumProjects(pointer, numprojects, BufferUtils.getPositionInBytes(numprojects));
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT getCategory(String name, EventCategory category) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.EventSystem_getCategory(pointer, name == null ? null : name.getBytes(), category);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT getCategoryByIndex(int index, EventCategory category) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.EventSystem_getCategoryByIndex(pointer, index, category);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT getMusicCategory(EventCategory category) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.EventSystem_getMusicCategory(pointer, category);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT getNumCategories(IntBuffer numcategories) {
		if(pointer == 0) throw new NullPointerException();
		if(numcategories != null && !numcategories.isDirect()) {
			throw new NonDirectBufferException();
		}
		int javaResult = FmodDesignerJNI.EventSystem_getNumCategories(pointer, numcategories, BufferUtils.getPositionInBytes(numcategories));
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT getGroup(String name, boolean cacheevents, EventGroup group) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.EventSystem_getGroup(pointer, name == null ? null : name.getBytes(), cacheevents, group);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT getEvent(String name, int mode, Event event) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.EventSystem_getEvent(pointer, name == null ? null : name.getBytes(), mode, event);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT getEventBySystemID(int systemid, int mode, Event event) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.EventSystem_getEventBySystemID(pointer, systemid, mode, event);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT getEventByGUID(FMOD_GUID guid, int mode, Event event) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.EventSystem_getEventByGUID(pointer, Pointer.getPointer(guid), mode, event);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT getEventByGUIDString(String guid, int mode, Event event) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.EventSystem_getEventByGUIDString(pointer, guid == null ? null : guid.getBytes(), mode, event);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT getNumEvents(IntBuffer numevents) {
		if(pointer == 0) throw new NullPointerException();
		if(numevents != null && !numevents.isDirect()) {
			throw new NonDirectBufferException();
		}
		int javaResult = FmodDesignerJNI.EventSystem_getNumEvents(pointer, numevents, BufferUtils.getPositionInBytes(numevents));
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT setReverbProperties(FMOD_REVERB_PROPERTIES props) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.EventSystem_setReverbProperties(pointer, Pointer.getPointer(props));
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT getReverbProperties(FMOD_REVERB_PROPERTIES props) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.EventSystem_getReverbProperties(pointer, Pointer.getPointer(props));
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT getReverbPreset(String name, FMOD_REVERB_PROPERTIES props, IntBuffer index) {
		if(pointer == 0) throw new NullPointerException();
		if(index != null && !index.isDirect()) {
			throw new NonDirectBufferException();
		}
		int javaResult = FmodDesignerJNI.EventSystem_getReverbPreset(pointer, name == null ? null : name.getBytes(), Pointer.getPointer(props), index, BufferUtils.getPositionInBytes(index));
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT getReverbPresetByIndex(int index, FMOD_REVERB_PROPERTIES props, Pointer name) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.EventSystem_getReverbPresetByIndex(pointer, index, Pointer.getPointer(props), name);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT getNumReverbPresets(IntBuffer numpresets) {
		if(pointer == 0) throw new NullPointerException();
		if(numpresets != null && !numpresets.isDirect()) {
			throw new NonDirectBufferException();
		}
		int javaResult = FmodDesignerJNI.EventSystem_getNumReverbPresets(pointer, numpresets, BufferUtils.getPositionInBytes(numpresets));
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT createReverb(EventReverb reverb) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.EventSystem_createReverb(pointer, reverb);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT setReverbAmbientProperties(FMOD_REVERB_PROPERTIES props) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.EventSystem_setReverbAmbientProperties(pointer, Pointer.getPointer(props));
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT getReverbAmbientProperties(FMOD_REVERB_PROPERTIES props) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.EventSystem_getReverbAmbientProperties(pointer, Pointer.getPointer(props));
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT createEventQueue(EventQueue queue) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.EventSystem_createEventQueue(pointer, queue);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT createEventQueueEntry(Event event, EventQueueEntry entry) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.EventSystem_createEventQueueEntry(pointer, Pointer.getPointer(event), entry);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT set3DNumListeners(int numlisteners) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.EventSystem_set3DNumListeners(pointer, numlisteners);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT get3DNumListeners(IntBuffer numlisteners) {
		if(pointer == 0) throw new NullPointerException();
		if(numlisteners != null && !numlisteners.isDirect()) {
			throw new NonDirectBufferException();
		}
		int javaResult = FmodDesignerJNI.EventSystem_get3DNumListeners(pointer, numlisteners, BufferUtils.getPositionInBytes(numlisteners));
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT set3DListenerAttributes(int listener, FMOD_VECTOR pos, FMOD_VECTOR vel, FMOD_VECTOR forward, FMOD_VECTOR up) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.EventSystem_set3DListenerAttributes(pointer, listener, Pointer.getPointer(pos), Pointer.getPointer(vel), Pointer.getPointer(forward), Pointer.getPointer(up));
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT get3DListenerAttributes(int listener, FMOD_VECTOR pos, FMOD_VECTOR vel, FMOD_VECTOR forward, FMOD_VECTOR up) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.EventSystem_get3DListenerAttributes(pointer, listener, Pointer.getPointer(pos), Pointer.getPointer(vel), Pointer.getPointer(forward), Pointer.getPointer(up));
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT setUserData(Pointer userdata) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.EventSystem_setUserData(pointer, Pointer.getPointer(userdata));
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT getUserData(Pointer userdata) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.EventSystem_getUserData(pointer, userdata);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT preloadFSB(String filename, int streaminstance, Sound sound) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.EventSystem_preloadFSB(pointer, filename == null ? null : filename.getBytes(), streaminstance, Pointer.getPointer(sound));
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT unloadFSB(String filename, int streaminstance) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.EventSystem_unloadFSB(pointer, filename == null ? null : filename.getBytes(), streaminstance);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT getMemoryInfo(int memorybits, int event_memorybits, IntBuffer memoryused, FMOD_MEMORY_USAGE_DETAILS memoryused_details) {
		if(pointer == 0) throw new NullPointerException();
		if(memoryused != null && !memoryused.isDirect()) {
			throw new NonDirectBufferException();
		}
		int javaResult = FmodDesignerJNI.EventSystem_getMemoryInfo(pointer, memorybits, event_memorybits, memoryused, BufferUtils.getPositionInBytes(memoryused), Pointer.getPointer(memoryused_details));
		return FMOD_RESULT.get(javaResult);
	}

}
