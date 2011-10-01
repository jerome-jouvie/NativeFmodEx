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
 * 'EventCategory' API
 */
public class EventCategory extends Pointer {
	/**
	 * Create a view of the <code>Pointer</code> object as a <code>EventCategory</code> object.<br>
	 * This view is valid only if the memory holded by the <code>Pointer</code> holds a EventCategory object.
	 */
	public static EventCategory asEventCategory(Pointer pointer) {
		long address = Pointer.getPointer(pointer);
		if(address == 0) return null;
		return new EventCategory(address);
	}
	private EventCategory(long pointer) {
		super(pointer);
	}

	public EventCategory() {
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
		int javaResult = FmodDesignerJNI.EventCategory_getInfo(pointer, index, BufferUtils.getPositionInBytes(index), name);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT getCategory(String name, EventCategory category) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.EventCategory_getCategory(pointer, name == null ? null : name.getBytes(), category);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT getCategoryByIndex(int index, EventCategory category) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.EventCategory_getCategoryByIndex(pointer, index, category);
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
		int javaResult = FmodDesignerJNI.EventCategory_getNumCategories(pointer, numcategories, BufferUtils.getPositionInBytes(numcategories));
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT getEventByIndex(int index, int mode, Event event) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.EventCategory_getEventByIndex(pointer, index, mode, event);
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
		int javaResult = FmodDesignerJNI.EventCategory_getNumEvents(pointer, numevents, BufferUtils.getPositionInBytes(numevents));
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT getParentCategory(EventCategory category) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.EventCategory_getParentCategory(pointer, category);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT stopAllEvents() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.EventCategory_stopAllEvents(pointer);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT setVolume(float volume) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.EventCategory_setVolume(pointer, volume);
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
		int javaResult = FmodDesignerJNI.EventCategory_getVolume(pointer, volume, BufferUtils.getPositionInBytes(volume));
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT setPitch(float pitch, FMOD_EVENT_PITCHUNITS units) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.EventCategory_setPitch(pointer, pitch, units.asInt());
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
		int javaResult = FmodDesignerJNI.EventCategory_getPitch(pointer, pitch, BufferUtils.getPositionInBytes(pitch), units.asInt());
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT setPaused(boolean paused) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.EventCategory_setPaused(pointer, paused);
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
		int javaResult = FmodDesignerJNI.EventCategory_getPaused(pointer, paused, BufferUtils.getPositionInBytes(paused));
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT setMute(boolean mute) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.EventCategory_setMute(pointer, mute);
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
		int javaResult = FmodDesignerJNI.EventCategory_getMute(pointer, mute, BufferUtils.getPositionInBytes(mute));
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT getChannelGroup(ChannelGroup channelgroup) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.EventCategory_getChannelGroup(pointer, channelgroup);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT setUserData(Pointer userdata) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.EventCategory_setUserData(pointer, Pointer.getPointer(userdata));
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT getUserData(Pointer userdata) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.EventCategory_getUserData(pointer, userdata);
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
		int javaResult = FmodDesignerJNI.EventCategory_getMemoryInfo(pointer, memorybits, event_memorybits, memoryused, BufferUtils.getPositionInBytes(memoryused), Pointer.getPointer(memoryused_details));
		return FMOD_RESULT.get(javaResult);
	}

}
