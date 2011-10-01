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

package org.jouvieje.fmoddesigner.structures;

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

public class FMOD_EVENT_INFO extends Pointer {
	/**
	 * Create a view of the <code>Pointer</code> object as a <code>FMOD_EVENT_INFO</code> object.<br>
	 * This view is valid only if the memory holded by the <code>Pointer</code> holds a FMOD_EVENT_INFO object.
	 */
	public static FMOD_EVENT_INFO asFMOD_EVENT_INFO(Pointer pointer) {
		long address = Pointer.getPointer(pointer);
		if(address == 0) return null;
		return new FMOD_EVENT_INFO(address);
	}
	/**
	 * Allocate a new <code>FMOD_EVENT_INFO</code>.<br>
	 * The call <code>isNull()</code> on the object created will return false.<br>
	 * <pre><code>  FMOD_EVENT_INFO obj = FMOD_EVENT_INFO.allocate();
	 *  (obj == null) <=> obj.isNull() <=> false
	 * </code></pre>
	 */
	public static FMOD_EVENT_INFO allocate() {
		final long pointer = StructureJNI.FMOD_EVENT_INFO_new();
		if(pointer == 0) throw new OutOfMemoryError();
		return new FMOD_EVENT_INFO(pointer);
	}

	protected FMOD_EVENT_INFO(long pointer) {
		super(pointer);
	}

	/**
	 * Create an object that holds a null <code>FMOD_EVENT_INFO</code>.<br>
	 * The call <code>isNull()</code> on the object created will returns true.<br>
	 * <pre><code>  FMOD_EVENT_INFO obj = new FMOD_EVENT_INFO();
	 *  (obj == null) <=> false
	 *  obj.isNull() <=> true
	 * </code></pre>
	 * To creates a new <code>FMOD_EVENT_INFO</code>, use the static "constructor" :
	 * <pre><code>  FMOD_EVENT_INFO obj = FMOD_EVENT_INFO.allocate();</code></pre>
	 * @see FMOD_EVENT_INFO#allocate()
	 */
	public FMOD_EVENT_INFO() {
		super();
	}

	public void release() {
		if(pointer != 0) {
			StructureJNI.FMOD_EVENT_INFO_delete(pointer);
		}
		pointer = 0;
	}

	/**
	 * This member has been deprecated.
	 */
	public int getMemoryUsed() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_EVENT_INFO_get_memoryused(pointer);
		return javaResult;
	}
	/**
	 * This member has been deprecated.
	 */
	public void setMemoryUsed(int memoryUsed) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_EVENT_INFO_set_memoryused(pointer, memoryUsed);
	}

	/**
	 * [out] Time passed in playback of this event instance in milliseconds.
	 */
	public int getPositionMs() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_EVENT_INFO_get_positionms(pointer);
		return javaResult;
	}

	/**
	 * [out] Length in milliseconds of this event. Note: lengthms will be -1 if the length of the event can't be determined i.e. if it has looping sounds.
	 */
	public int getLengthMs() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_EVENT_INFO_get_lengthms(pointer);
		return javaResult;
	}

	/**
	 * [out] Number of channels currently playing in this event instance.
	 */
	public int getChannelsPlaying() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_EVENT_INFO_get_channelsplaying(pointer);
		return javaResult;
	}

	/**
	 * [out] Number of event instances currently in use.
	 */
	public int getInstancesActive() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_EVENT_INFO_get_instancesactive(pointer);
		return javaResult;
	}

	/**
	 * [in/out] Out, number of wavebanks refered to by this event.  In. Maximum size of array of wavebankinfo structures supplied by user.  Optional.
	 */
	public int getMaxWaveBanks() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_EVENT_INFO_get_maxwavebanks(pointer);
		return javaResult;
	}

	/**
	 * [in] Pointer to array FMOD_EVENT_WAVEBANKINFO structures (max size defined by maxwavebanks).  FMOD will fill these in with detailed information on each wave bank. Optional.
	 */
	public FMOD_EVENT_WAVEBANKINFO[] getWavebankInfo() {
		if(pointer == 0) throw new NullPointerException();
		long javaResult = StructureJNI.FMOD_EVENT_INFO_get_wavebankinfo(pointer);
		int wavebankinfoLength = getMaxWaveBanks();
		if(wavebankinfoLength <= 0 || javaResult == 0) return null;
		FMOD_EVENT_WAVEBANKINFO[] wavebankinfoArray = new FMOD_EVENT_WAVEBANKINFO[wavebankinfoLength];
		int SIZEOF_FMOD_EVENT_WAVEBANKINFO = StructureJNI.FMOD_EVENT_WAVEBANKINFO_SIZEOF();
		for(int i = 0; i < wavebankinfoArray.length; i++) {
			wavebankinfoArray[i] = new FMOD_EVENT_WAVEBANKINFO(javaResult + i * SIZEOF_FMOD_EVENT_WAVEBANKINFO);
		}
		return wavebankinfoArray;
	}
	/**
	 * [in] Pointer to array FMOD_EVENT_WAVEBANKINFO structures (max size defined by maxwavebanks).  FMOD will fill these in with detailed information on each wave bank. Optional.
	 */
	public void setWavebankInfo(FMOD_EVENT_WAVEBANKINFO[] wavebankInfo) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_EVENT_INFO_set_wavebankinfo(pointer, (wavebankInfo == null) ? 0 : Pointer.getPointer(wavebankInfo[0]), (wavebankInfo == null) ? 0 : wavebankInfo.length);
	}

	/**
	 * [out] The runtime 'EventProject' wide unique identifier for this event.
	 */
	public int getProjectId() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_EVENT_INFO_get_projectid(pointer);
		return javaResult;
	}

	/**
	 * [out] The runtime 'EventSystem' wide unique identifier for this event.  This is calculated when single or multiple projects are loaded.
	 */
	public int getSystemId() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_EVENT_INFO_get_systemid(pointer);
		return javaResult;
	}

	/**
	 * [out] current audibility of event.
	 */
	public float getAudibility() {
		if(pointer == 0) throw new NullPointerException();
		float javaResult = StructureJNI.FMOD_EVENT_INFO_get_audibility(pointer);
		return javaResult;
	}

	/**
	 * [in/out] On entry, maximum number of entries in instances array. On exit, actual number of entries in instances array, or if instances is null, then it is just the number of instances of this event. Optional.
	 */
	public int getNumInstances() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_EVENT_INFO_get_numinstances(pointer);
		return javaResult;
	}

	/**
	 * [in/out] Pointer to an array that will be filled with the current reference-counted event handles of all instances of this event. Optional. Specify 0 if not needed. Must be used in conjunction with numinstances. Note: Due to reference counting, the event instance handles returned here may be different between subsequent calls to this function. If you use these event handles, make sure your code is prepared for them to be invalid!
	 */
	public Event[] getInstances() {
		if(pointer == 0) throw new NullPointerException();
		Event[] javaResult = StructureJNI.FMOD_EVENT_INFO_get_instances(pointer);
		return javaResult;
	}
	/**
	 * [in/out] Pointer to an array that will be filled with the current reference-counted event handles of all instances of this event. Optional. Specify 0 if not needed. Must be used in conjunction with numinstances. Note: Due to reference counting, the event instance handles returned here may be different between subsequent calls to this function. If you use these event handles, make sure your code is prepared for them to be invalid!
	 */
	public void setInstances(Event[] instances) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_EVENT_INFO_set_instances(pointer, instances);
	}

	/**
	 * [out] Pointer to a structure that will be filled with the event's GUID. Optional. Specify 0 if not needed.
	 */
	public FMOD_GUID getGuid() {
		if(pointer == 0) throw new NullPointerException();
		long javaResult = StructureJNI.FMOD_EVENT_INFO_get_guid(pointer);
		return javaResult == 0 ? null : FMOD_GUID.asFMOD_GUID(Pointer.newPointer(javaResult));
	}

}
