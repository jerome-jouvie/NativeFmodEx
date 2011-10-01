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
 * 'EventParameter' API
 */
public class EventParameter extends Pointer {
	/**
	 * Create a view of the <code>Pointer</code> object as a <code>EventParameter</code> object.<br>
	 * This view is valid only if the memory holded by the <code>Pointer</code> holds a EventParameter object.
	 */
	public static EventParameter asEventParameter(Pointer pointer) {
		long address = Pointer.getPointer(pointer);
		if(address == 0) return null;
		return new EventParameter(address);
	}
	private EventParameter(long pointer) {
		super(pointer);
	}

	public EventParameter() {
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
		int javaResult = FmodDesignerJNI.EventParameter_getInfo(pointer, index, BufferUtils.getPositionInBytes(index), name);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT getRange(FloatBuffer rangemin, FloatBuffer rangemax) {
		if(pointer == 0) throw new NullPointerException();
		if(rangemin != null && !rangemin.isDirect()) {
			throw new NonDirectBufferException();
		}
		if(rangemax != null && !rangemax.isDirect()) {
			throw new NonDirectBufferException();
		}
		int javaResult = FmodDesignerJNI.EventParameter_getRange(pointer, rangemin, BufferUtils.getPositionInBytes(rangemin), rangemax, BufferUtils.getPositionInBytes(rangemax));
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT setValue(float value) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.EventParameter_setValue(pointer, value);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT getValue(FloatBuffer value) {
		if(pointer == 0) throw new NullPointerException();
		if(value != null && !value.isDirect()) {
			throw new NonDirectBufferException();
		}
		int javaResult = FmodDesignerJNI.EventParameter_getValue(pointer, value, BufferUtils.getPositionInBytes(value));
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT setVelocity(float value) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.EventParameter_setVelocity(pointer, value);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT getVelocity(FloatBuffer value) {
		if(pointer == 0) throw new NullPointerException();
		if(value != null && !value.isDirect()) {
			throw new NonDirectBufferException();
		}
		int javaResult = FmodDesignerJNI.EventParameter_getVelocity(pointer, value, BufferUtils.getPositionInBytes(value));
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT setSeekSpeed(float value) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.EventParameter_setSeekSpeed(pointer, value);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT getSeekSpeed(FloatBuffer value) {
		if(pointer == 0) throw new NullPointerException();
		if(value != null && !value.isDirect()) {
			throw new NonDirectBufferException();
		}
		int javaResult = FmodDesignerJNI.EventParameter_getSeekSpeed(pointer, value, BufferUtils.getPositionInBytes(value));
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT setUserData(Pointer userdata) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.EventParameter_setUserData(pointer, Pointer.getPointer(userdata));
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT getUserData(Pointer userdata) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.EventParameter_getUserData(pointer, userdata);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT keyOff() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.EventParameter_keyOff(pointer);
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
		int javaResult = FmodDesignerJNI.EventParameter_getMemoryInfo(pointer, memorybits, event_memorybits, memoryused, BufferUtils.getPositionInBytes(memoryused), Pointer.getPointer(memoryused_details));
		return FMOD_RESULT.get(javaResult);
	}

}
