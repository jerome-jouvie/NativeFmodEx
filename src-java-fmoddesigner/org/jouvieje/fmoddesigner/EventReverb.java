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
 * 'EventReverb ' API
 */
public class EventReverb extends Pointer {
	/**
	 * Create a view of the <code>Pointer</code> object as a <code>EventReverb</code> object.<br>
	 * This view is valid only if the memory holded by the <code>Pointer</code> holds a EventReverb object.
	 */
	public static EventReverb asEventReverb(Pointer pointer) {
		long address = Pointer.getPointer(pointer);
		if(address == 0) return null;
		return new EventReverb(address);
	}
	private EventReverb(long pointer) {
		super(pointer);
	}

	public EventReverb() {
		super(0);
	}

	/**
	 * 
	 */
	public FMOD_RESULT release() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.EventReverb_release(pointer);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT set3DAttributes(FMOD_VECTOR position, float mindistance, float maxdistance) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.EventReverb_set3DAttributes(pointer, Pointer.getPointer(position), mindistance, maxdistance);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT get3DAttributes(FMOD_VECTOR position, FloatBuffer mindistance, FloatBuffer maxdistance) {
		if(pointer == 0) throw new NullPointerException();
		if(mindistance != null && !mindistance.isDirect()) {
			throw new NonDirectBufferException();
		}
		if(maxdistance != null && !maxdistance.isDirect()) {
			throw new NonDirectBufferException();
		}
		int javaResult = FmodDesignerJNI.EventReverb_get3DAttributes(pointer, Pointer.getPointer(position), mindistance, BufferUtils.getPositionInBytes(mindistance), maxdistance, BufferUtils.getPositionInBytes(maxdistance));
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT setProperties(FMOD_REVERB_PROPERTIES props) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.EventReverb_setProperties(pointer, Pointer.getPointer(props));
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT getProperties(FMOD_REVERB_PROPERTIES props) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.EventReverb_getProperties(pointer, Pointer.getPointer(props));
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT setActive(boolean active) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.EventReverb_setActive(pointer, active);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT getActive(ByteBuffer active) {
		if(pointer == 0) throw new NullPointerException();
		if(active != null && !active.isDirect()) {
			throw new NonDirectBufferException();
		}
		int javaResult = FmodDesignerJNI.EventReverb_getActive(pointer, active, BufferUtils.getPositionInBytes(active));
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT setUserData(Pointer userdata) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.EventReverb_setUserData(pointer, Pointer.getPointer(userdata));
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT getUserData(Pointer userdata) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.EventReverb_getUserData(pointer, userdata);
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
		int javaResult = FmodDesignerJNI.EventReverb_getMemoryInfo(pointer, memorybits, event_memorybits, memoryused, BufferUtils.getPositionInBytes(memoryused), Pointer.getPointer(memoryused_details));
		return FMOD_RESULT.get(javaResult);
	}

}
