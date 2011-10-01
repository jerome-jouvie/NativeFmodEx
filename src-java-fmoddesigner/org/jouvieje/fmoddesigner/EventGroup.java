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
 * 'EventGroup' API
 */
public class EventGroup extends Pointer {
	/**
	 * Create a view of the <code>Pointer</code> object as a <code>EventGroup</code> object.<br>
	 * This view is valid only if the memory holded by the <code>Pointer</code> holds a EventGroup object.
	 */
	public static EventGroup asEventGroup(Pointer pointer) {
		long address = Pointer.getPointer(pointer);
		if(address == 0) return null;
		return new EventGroup(address);
	}
	private EventGroup(long pointer) {
		super(pointer);
	}

	public EventGroup() {
		super(0);
	}

	/**
	 * 
	 */
	public FMOD_RESULT getInfo(IntBuffer index, Pointer name) {
		if(pointer == 0) throw new NullPointerException();
		if(index != null && !index.isDirect()) {
			throw new NonDirectBufferException();
		}
		int javaResult = FmodDesignerJNI.EventGroup_getInfo(pointer, index, BufferUtils.getPositionInBytes(index), name);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT loadEventData(FMOD_EVENT_RESOURCE resource, int mode) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.EventGroup_loadEventData(pointer, resource.asInt(), mode);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT freeEventData(Event event, boolean waituntilready) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.EventGroup_freeEventData(pointer, Pointer.getPointer(event), waituntilready);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT getGroup(String name, boolean cacheevents, EventGroup group) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.EventGroup_getGroup(pointer, name == null ? null : name.getBytes(), cacheevents, group);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT getGroupByIndex(int index, boolean cacheevents, EventGroup group) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.EventGroup_getGroupByIndex(pointer, index, cacheevents, group);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT getParentGroup(EventGroup group) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.EventGroup_getParentGroup(pointer, group);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT getParentProject(EventProject project) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.EventGroup_getParentProject(pointer, project);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT getNumGroups(IntBuffer numgroups) {
		if(pointer == 0) throw new NullPointerException();
		if(numgroups != null && !numgroups.isDirect()) {
			throw new NonDirectBufferException();
		}
		int javaResult = FmodDesignerJNI.EventGroup_getNumGroups(pointer, numgroups, BufferUtils.getPositionInBytes(numgroups));
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT getEvent(String name, int mode, Event event) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.EventGroup_getEvent(pointer, name == null ? null : name.getBytes(), mode, event);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT getEventByIndex(int index, int mode, Event event) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.EventGroup_getEventByIndex(pointer, index, mode, event);
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
		int javaResult = FmodDesignerJNI.EventGroup_getNumEvents(pointer, numevents, BufferUtils.getPositionInBytes(numevents));
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT getProperty(String propertyname, Pointer value) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.EventGroup_getProperty(pointer, propertyname == null ? null : propertyname.getBytes(), Pointer.getPointer(value));
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT getPropertyByIndex(int propertyindex, Pointer value) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.EventGroup_getPropertyByIndex(pointer, propertyindex, Pointer.getPointer(value));
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT getNumProperties(IntBuffer numproperties) {
		if(pointer == 0) throw new NullPointerException();
		if(numproperties != null && !numproperties.isDirect()) {
			throw new NonDirectBufferException();
		}
		int javaResult = FmodDesignerJNI.EventGroup_getNumProperties(pointer, numproperties, BufferUtils.getPositionInBytes(numproperties));
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT getState(IntBuffer state) {
		if(pointer == 0) throw new NullPointerException();
		if(state != null && !state.isDirect()) {
			throw new NonDirectBufferException();
		}
		int javaResult = FmodDesignerJNI.EventGroup_getState(pointer, state, BufferUtils.getPositionInBytes(state));
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT setUserData(Pointer userdata) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.EventGroup_setUserData(pointer, Pointer.getPointer(userdata));
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT getUserData(Pointer userdata) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.EventGroup_getUserData(pointer, userdata);
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
		int javaResult = FmodDesignerJNI.EventGroup_getMemoryInfo(pointer, memorybits, event_memorybits, memoryused, BufferUtils.getPositionInBytes(memoryused), Pointer.getPointer(memoryused_details));
		return FMOD_RESULT.get(javaResult);
	}

}
