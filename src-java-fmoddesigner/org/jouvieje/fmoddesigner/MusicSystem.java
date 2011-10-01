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
 * 'MusicSystem' API
 */
public class MusicSystem extends Pointer {
	/**
	 * Create a view of the <code>Pointer</code> object as a <code>MusicSystem</code> object.<br>
	 * This view is valid only if the memory holded by the <code>Pointer</code> holds a MusicSystem object.
	 */
	public static MusicSystem asMusicSystem(Pointer pointer) {
		long address = Pointer.getPointer(pointer);
		if(address == 0) return null;
		return new MusicSystem(address);
	}
	private MusicSystem(long pointer) {
		super(pointer);
	}

	public MusicSystem() {
		super(0);
	}

	/**
	 * Allocate and initialize a new <code>MusicSystem[]</code>.<br>
	 * @param length length of the array returned.
	 */
	public static MusicSystem[] allocate(int length) {
		if(length <= 0) {
			return null;
		}
		long pointer = FmodDesignerJNI.MusicSystem_newArray(length);
		if(pointer == 0) throw new OutOfMemoryError();
		return allocate(pointer, length);
	}
	/**
	 * Allocate and initialize a new <code>MusicSystem[]</code>.<br>
	 * @param pointer strart address.
	 * @param length length of the array returned.
	 */
	protected static MusicSystem[] allocate(long pointer, int length) {
		if((pointer == 0) || (length <= 0)) {
			return null;
		}
		final long SIZEOF_MusicSystem = FmodDesignerJNI.MusicSystem_SIZEOF();
		final MusicSystem[] array = new MusicSystem[length];
		for(int i = 0; i < length; i++) {
			array[i] = new MusicSystem(pointer + i * SIZEOF_MusicSystem);
		}
		return array;
	}

	/**
	 * 
	 */
	public FMOD_RESULT reset() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.MusicSystem_reset(pointer);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT setVolume(float volume) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.MusicSystem_setVolume(pointer, volume);
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
		int javaResult = FmodDesignerJNI.MusicSystem_getVolume(pointer, volume, BufferUtils.getPositionInBytes(volume));
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT setReverbProperties(FMOD_REVERB_CHANNELPROPERTIES props) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.MusicSystem_setReverbProperties(pointer, Pointer.getPointer(props));
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT getReverbProperties(FMOD_REVERB_CHANNELPROPERTIES props) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.MusicSystem_getReverbProperties(pointer, Pointer.getPointer(props));
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT setPaused(boolean paused) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.MusicSystem_setPaused(pointer, paused);
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
		int javaResult = FmodDesignerJNI.MusicSystem_getPaused(pointer, paused, BufferUtils.getPositionInBytes(paused));
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT setMute(boolean mute) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.MusicSystem_setMute(pointer, mute);
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
		int javaResult = FmodDesignerJNI.MusicSystem_getMute(pointer, mute, BufferUtils.getPositionInBytes(mute));
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT getInfo(FMOD_MUSIC_INFO info) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.MusicSystem_getInfo(pointer, Pointer.getPointer(info));
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT promptCue(int id) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.MusicSystem_promptCue(pointer, id);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT prepareCue(int id, MusicPrompt prompt) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.MusicSystem_prepareCue(pointer, id, prompt);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT getParameterValue(int id, FloatBuffer parameter) {
		if(pointer == 0) throw new NullPointerException();
		if(parameter != null && !parameter.isDirect()) {
			throw new NonDirectBufferException();
		}
		int javaResult = FmodDesignerJNI.MusicSystem_getParameterValue(pointer, id, parameter, BufferUtils.getPositionInBytes(parameter));
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT setParameterValue(int id, float parameter) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.MusicSystem_setParameterValue(pointer, id, parameter);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT getCues(FMOD_MUSIC_ITERATOR it, String filter) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.MusicSystem_getCues(pointer, Pointer.getPointer(it), filter == null ? null : filter.getBytes());
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT getNextCue(FMOD_MUSIC_ITERATOR it) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.MusicSystem_getNextCue(pointer, Pointer.getPointer(it));
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT getParameters(FMOD_MUSIC_ITERATOR it, String filter) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.MusicSystem_getParameters(pointer, Pointer.getPointer(it), filter == null ? null : filter.getBytes());
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT getNextParameter(FMOD_MUSIC_ITERATOR it) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.MusicSystem_getNextParameter(pointer, Pointer.getPointer(it));
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT loadSoundData(FMOD_EVENT_RESOURCE resource, int mode) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.MusicSystem_loadSoundData(pointer, resource.asInt(), mode);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT freeSoundData(boolean waituntilready) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodDesignerJNI.MusicSystem_freeSoundData(pointer, waituntilready);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT setCallback(FMOD_MUSIC_CALLBACK callback, Pointer userdata) {
		if(pointer == 0) throw new NullPointerException();
		CallbackManager.addCallback(2, callback, pointer);
		CallbackManager.addOwner(callback == null ? 0 : pointer, pointer);
		int javaResult = FmodDesignerJNI.MusicSystem_setCallback(pointer, callback == null ? false : true, Pointer.getPointer(userdata));
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
		int javaResult = FmodDesignerJNI.MusicSystem_getMemoryInfo(pointer, memorybits, event_memorybits, memoryused, BufferUtils.getPositionInBytes(memoryused), Pointer.getPointer(memoryused_details));
		return FMOD_RESULT.get(javaResult);
	}

}
