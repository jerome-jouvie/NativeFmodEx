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
 * 'EventQueueEntry' API
 */
public class EventQueueEntry extends Pointer {
	/**
	 * Create a view of the <code>Pointer</code> object as a <code>EventQueueEntry</code> object.<br>
	 * This view is valid only if the memory holded by the <code>Pointer</code> holds a EventQueueEntry object.
	 */
	public static EventQueueEntry asEventQueueEntry(Pointer pointer) {
		long address = Pointer.getPointer(pointer);
		if(address == 0) return null;
		return new EventQueueEntry(address);
	}
	private EventQueueEntry(long pointer) {
		super(pointer);
	}

	public EventQueueEntry() {
		super(0);
	}

	/**
	 * 
	 */
	public FMOD_RESULT release() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.EventQueueEntry_release(pointer);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT getInfoOnlyEvent(Event infoonlyevent) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.EventQueueEntry_getInfoOnlyEvent(pointer, infoonlyevent);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT getRealEvent(Event realevent) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.EventQueueEntry_getRealEvent(pointer, realevent);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT setPriority(char priority) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.EventQueueEntry_setPriority(pointer, priority);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT getPriority(ByteBuffer priority) {
		if(pointer == 0) throw new NullPointerException();
		if(priority != null && !priority.isDirect()) {
			throw new NonDirectBufferException();
		}
		int javaResult = FmodDesignerJNI.EventQueueEntry_getPriority(pointer, priority, BufferUtils.getPositionInBytes(priority));
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT setExpiryTime(int expirytime) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.EventQueueEntry_setExpiryTime(pointer, expirytime);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT getExpiryTime(IntBuffer expirytime) {
		if(pointer == 0) throw new NullPointerException();
		if(expirytime != null && !expirytime.isDirect()) {
			throw new NonDirectBufferException();
		}
		int javaResult = FmodDesignerJNI.EventQueueEntry_getExpiryTime(pointer, expirytime, BufferUtils.getPositionInBytes(expirytime));
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT setDelayTime(int delay) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.EventQueueEntry_setDelayTime(pointer, delay);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT getDelayTime(IntBuffer delay) {
		if(pointer == 0) throw new NullPointerException();
		if(delay != null && !delay.isDirect()) {
			throw new NonDirectBufferException();
		}
		int javaResult = FmodDesignerJNI.EventQueueEntry_getDelayTime(pointer, delay, BufferUtils.getPositionInBytes(delay));
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT setInterrupt(boolean interrupt) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.EventQueueEntry_setInterrupt(pointer, interrupt);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT getInterrupt(ByteBuffer interrupt) {
		if(pointer == 0) throw new NullPointerException();
		if(interrupt != null && !interrupt.isDirect()) {
			throw new NonDirectBufferException();
		}
		int javaResult = FmodDesignerJNI.EventQueueEntry_getInterrupt(pointer, interrupt, BufferUtils.getPositionInBytes(interrupt));
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT setCrossfadeTime(int crossfade) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.EventQueueEntry_setCrossfadeTime(pointer, crossfade);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT getCrossfadeTime(IntBuffer crossfade) {
		if(pointer == 0) throw new NullPointerException();
		if(crossfade != null && !crossfade.isDirect()) {
			throw new NonDirectBufferException();
		}
		int javaResult = FmodDesignerJNI.EventQueueEntry_getCrossfadeTime(pointer, crossfade, BufferUtils.getPositionInBytes(crossfade));
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT setUserData(Pointer userdata) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.EventQueueEntry_setUserData(pointer, Pointer.getPointer(userdata));
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT getUserData(Pointer userdata) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.EventQueueEntry_getUserData(pointer, userdata);
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
		int javaResult = FmodDesignerJNI.EventQueueEntry_getMemoryInfo(pointer, memorybits, event_memorybits, memoryused, BufferUtils.getPositionInBytes(memoryused), Pointer.getPointer(memoryused_details));
		return FMOD_RESULT.get(javaResult);
	}

}
