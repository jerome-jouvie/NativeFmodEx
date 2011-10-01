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
 * 'Event' API
 */
public class Event extends Pointer {
	/**
	 * Create a view of the <code>Pointer</code> object as a <code>Event</code> object.<br>
	 * This view is valid only if the memory holded by the <code>Pointer</code> holds a Event object.
	 */
	public static Event asEvent(Pointer pointer) {
		long address = Pointer.getPointer(pointer);
		if(address == 0) return null;
		return new Event(address);
	}
	private Event(long pointer) {
		super(pointer);
	}

	public Event() {
		super(0);
	}

	/**
	 * Allocate and initialize a new <code>Event[]</code>.<br>
	 * @param length length of the array returned.
	 */
	public static Event[] allocate(int length) {
		if(length <= 0) {
			return null;
		}
		long pointer = FmodDesignerJNI.Event_newArray(length);
		if(pointer == 0) throw new OutOfMemoryError();
		return allocate(pointer, length);
	}
	/**
	 * Allocate and initialize a new <code>Event[]</code>.<br>
	 * @param pointer strart address.
	 * @param length length of the array returned.
	 */
	protected static Event[] allocate(long pointer, int length) {
		if((pointer == 0) || (length <= 0)) {
			return null;
		}
		final long SIZEOF_Event = FmodDesignerJNI.Event_SIZEOF();
		final Event[] array = new Event[length];
		for(int i = 0; i < length; i++) {
			array[i] = new Event(pointer + i * SIZEOF_Event);
		}
		return array;
	}

	/**
	 * 
	 */
	public FMOD_RESULT release(boolean freeeventdata, boolean waituntilready) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.Event_release(pointer, freeeventdata, waituntilready);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT start() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.Event_start(pointer);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT stop(boolean immediate) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.Event_stop(pointer, immediate);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT getInfo(IntBuffer index, Pointer name, FMOD_EVENT_INFO info) {
		if(pointer == 0) throw new NullPointerException();
		if(index != null && !index.isDirect()) {
			throw new NonDirectBufferException();
		}
		int javaResult = FmodDesignerJNI.Event_getInfo(pointer, index, BufferUtils.getPositionInBytes(index), name, Pointer.getPointer(info));
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
		int javaResult = FmodDesignerJNI.Event_getState(pointer, state, BufferUtils.getPositionInBytes(state));
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT getParentGroup(EventGroup group) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.Event_getParentGroup(pointer, group);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT getChannelGroup(ChannelGroup channelgroup) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.Event_getChannelGroup(pointer, channelgroup);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT setCallback(FMOD_EVENT_CALLBACK callback, Pointer userdata) {
		if(pointer == 0) throw new NullPointerException();
		CallbackManager.addCallback(1, callback, pointer);
		CallbackManager.addOwner(callback == null ? 0 : pointer, pointer);
		int javaResult = FmodDesignerJNI.Event_setCallback(pointer, callback == null ? false : true, Pointer.getPointer(userdata));
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT getParameter(String name, EventParameter parameter) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.Event_getParameter(pointer, name == null ? null : name.getBytes(), parameter);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT getParameterByIndex(int index, EventParameter parameter) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.Event_getParameterByIndex(pointer, index, parameter);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT getNumParameters(IntBuffer numparameters) {
		if(pointer == 0) throw new NullPointerException();
		if(numparameters != null && !numparameters.isDirect()) {
			throw new NonDirectBufferException();
		}
		int javaResult = FmodDesignerJNI.Event_getNumParameters(pointer, numparameters, BufferUtils.getPositionInBytes(numparameters));
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT getProperty(String propertyname, Pointer value, boolean this_instance) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.Event_getProperty(pointer, propertyname == null ? null : propertyname.getBytes(), Pointer.getPointer(value), this_instance);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT getPropertyByIndex(int propertyindex, Pointer value, boolean this_instance) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.Event_getPropertyByIndex(pointer, propertyindex, Pointer.getPointer(value), this_instance);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT setProperty(String propertyname, Pointer value, boolean this_instance) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.Event_setProperty(pointer, propertyname == null ? null : propertyname.getBytes(), Pointer.getPointer(value), this_instance);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT setPropertyByIndex(int propertyindex, Pointer value, boolean this_instance) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.Event_setPropertyByIndex(pointer, propertyindex, Pointer.getPointer(value), this_instance);
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
		int javaResult = FmodDesignerJNI.Event_getNumProperties(pointer, numproperties, BufferUtils.getPositionInBytes(numproperties));
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT getPropertyInfo(IntBuffer propertyindex, Pointer propertyname, FMOD_EVENTPROPERTY_TYPE[] type) {
		if(pointer == 0) throw new NullPointerException();
		if(propertyindex != null && !propertyindex.isDirect()) {
			throw new NonDirectBufferException();
		}
		IntBuffer typePointer = BufferUtils.newIntBuffer(1);
		int javaResult = FmodDesignerJNI.Event_getPropertyInfo(pointer, propertyindex, BufferUtils.getPositionInBytes(propertyindex), propertyname, typePointer);
		if(type != null) {
			type[0] = FMOD_EVENTPROPERTY_TYPE.get(typePointer.get(0));
		}
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT getCategory(EventCategory category) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.Event_getCategory(pointer, category);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT setVolume(float volume) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.Event_setVolume(pointer, volume);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT getVolume(FloatBuffer volume) {
		if(pointer == 0) throw new NullPointerException();
		if(volume != null && !volume.isDirect()) {
			throw new NonDirectBufferException();
		}
		int javaResult = FmodDesignerJNI.Event_getVolume(pointer, volume, BufferUtils.getPositionInBytes(volume));
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT setPitch(float pitch, FMOD_EVENT_PITCHUNITS units) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.Event_setPitch(pointer, pitch, units.asInt());
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT getPitch(FloatBuffer pitch, FMOD_EVENT_PITCHUNITS units) {
		if(pointer == 0) throw new NullPointerException();
		if(pitch != null && !pitch.isDirect()) {
			throw new NonDirectBufferException();
		}
		int javaResult = FmodDesignerJNI.Event_getPitch(pointer, pitch, BufferUtils.getPositionInBytes(pitch), units.asInt());
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT setPaused(boolean paused) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.Event_setPaused(pointer, paused);
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
		int javaResult = FmodDesignerJNI.Event_getPaused(pointer, paused, BufferUtils.getPositionInBytes(paused));
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT setMute(boolean mute) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.Event_setMute(pointer, mute);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT getMute(ByteBuffer mute) {
		if(pointer == 0) throw new NullPointerException();
		if(mute != null && !mute.isDirect()) {
			throw new NonDirectBufferException();
		}
		int javaResult = FmodDesignerJNI.Event_getMute(pointer, mute, BufferUtils.getPositionInBytes(mute));
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT set3DAttributes(FMOD_VECTOR position, FMOD_VECTOR velocity, FMOD_VECTOR orientation) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.Event_set3DAttributes(pointer, Pointer.getPointer(position), Pointer.getPointer(velocity), Pointer.getPointer(orientation));
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT get3DAttributes(FMOD_VECTOR position, FMOD_VECTOR velocity, FMOD_VECTOR orientation) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.Event_get3DAttributes(pointer, Pointer.getPointer(position), Pointer.getPointer(velocity), Pointer.getPointer(orientation));
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT set3DOcclusion(float directocclusion, float reverbocclusion) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.Event_set3DOcclusion(pointer, directocclusion, reverbocclusion);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT get3DOcclusion(FloatBuffer directocclusion, FloatBuffer reverbocclusion) {
		if(pointer == 0) throw new NullPointerException();
		if(directocclusion != null && !directocclusion.isDirect()) {
			throw new NonDirectBufferException();
		}
		if(reverbocclusion != null && !reverbocclusion.isDirect()) {
			throw new NonDirectBufferException();
		}
		int javaResult = FmodDesignerJNI.Event_get3DOcclusion(pointer, directocclusion, BufferUtils.getPositionInBytes(directocclusion), reverbocclusion, BufferUtils.getPositionInBytes(reverbocclusion));
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT setReverbProperties(FMOD_REVERB_CHANNELPROPERTIES props) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.Event_setReverbProperties(pointer, Pointer.getPointer(props));
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT getReverbProperties(FMOD_REVERB_CHANNELPROPERTIES props) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.Event_getReverbProperties(pointer, Pointer.getPointer(props));
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT setUserData(Pointer userdata) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.Event_setUserData(pointer, Pointer.getPointer(userdata));
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT getUserData(Pointer userdata) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.Event_getUserData(pointer, userdata);
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
		int javaResult = FmodDesignerJNI.Event_getMemoryInfo(pointer, memorybits, event_memorybits, memoryused, BufferUtils.getPositionInBytes(memoryused), Pointer.getPointer(memoryused_details));
		return FMOD_RESULT.get(javaResult);
	}

}
