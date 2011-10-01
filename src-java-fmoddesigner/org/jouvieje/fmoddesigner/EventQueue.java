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
 * 'EventQueue' API
 */
public class EventQueue extends Pointer {
	/**
	 * Create a view of the <code>Pointer</code> object as a <code>EventQueue</code> object.<br>
	 * This view is valid only if the memory holded by the <code>Pointer</code> holds a EventQueue object.
	 */
	public static EventQueue asEventQueue(Pointer pointer) {
		long address = Pointer.getPointer(pointer);
		if(address == 0) return null;
		return new EventQueue(address);
	}
	private EventQueue(long pointer) {
		super(pointer);
	}

	public EventQueue() {
		super(0);
	}

	/**
	 * Allocate and initialize a new <code>EventQueue[]</code>.<br>
	 * @param length length of the array returned.
	 */
	public static EventQueue[] allocate(int length) {
		if(length <= 0) {
			return null;
		}
		long pointer = FmodDesignerJNI.EventQueue_newArray(length);
		if(pointer == 0) throw new OutOfMemoryError();
		return allocate(pointer, length);
	}
	/**
	 * Allocate and initialize a new <code>EventQueue[]</code>.<br>
	 * @param pointer strart address.
	 * @param length length of the array returned.
	 */
	protected static EventQueue[] allocate(long pointer, int length) {
		if((pointer == 0) || (length <= 0)) {
			return null;
		}
		final long SIZEOF_EventQueue = FmodDesignerJNI.EventQueue_SIZEOF();
		final EventQueue[] array = new EventQueue[length];
		for(int i = 0; i < length; i++) {
			array[i] = new EventQueue(pointer + i * SIZEOF_EventQueue);
		}
		return array;
	}

	/**
	 * 
	 */
	public FMOD_RESULT release() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.EventQueue_release(pointer);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT add(EventQueueEntry entry, boolean allow_duplicates) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.EventQueue_add(pointer, Pointer.getPointer(entry), allow_duplicates);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT remove(EventQueueEntry entry) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.EventQueue_remove(pointer, Pointer.getPointer(entry));
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT removeHead() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.EventQueue_removeHead(pointer);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT clear(boolean stopallevents) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.EventQueue_clear(pointer, stopallevents);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT findFirstEntry(EventQueueEntry entry) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.EventQueue_findFirstEntry(pointer, entry);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT findNextEntry(EventQueueEntry entry) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.EventQueue_findNextEntry(pointer, entry);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT setPaused(boolean paused) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.EventQueue_setPaused(pointer, paused);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT getPaused(ByteBuffer paused) {
		if(pointer == 0) throw new NullPointerException();
		if(paused != null && !paused.isDirect()) {
			throw new NonDirectBufferException();
		}
		int javaResult = FmodDesignerJNI.EventQueue_getPaused(pointer, paused, BufferUtils.getPositionInBytes(paused));
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT includeDuckingCategory(EventCategory category, float ducked_volume, float unducked_volume, int duck_time, int unduck_time) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.EventQueue_includeDuckingCategory(pointer, Pointer.getPointer(category), ducked_volume, unducked_volume, duck_time, unduck_time);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT excludeDuckingCategory(EventCategory category) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.EventQueue_excludeDuckingCategory(pointer, Pointer.getPointer(category));
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT setCallback(FMOD_EVENTQUEUE_CALLBACK callback, Pointer callbackuserdata) {
		if(pointer == 0) throw new NullPointerException();
		CallbackManager.addCallback(0, callback, pointer);
		CallbackManager.addOwner(callback == null ? 0 : pointer, pointer);
		int javaResult = FmodDesignerJNI.EventQueue_setCallback(pointer, callback == null ? false : true, Pointer.getPointer(callbackuserdata));
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT setUserData(Pointer userdata) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.EventQueue_setUserData(pointer, Pointer.getPointer(userdata));
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT getUserData(Pointer userdata) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.EventQueue_getUserData(pointer, userdata);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT dump() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.EventQueue_dump(pointer);
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
		int javaResult = FmodDesignerJNI.EventQueue_getMemoryInfo(pointer, memorybits, event_memorybits, memoryused, BufferUtils.getPositionInBytes(memoryused), Pointer.getPointer(memoryused_details));
		return FMOD_RESULT.get(javaResult);
	}

}
