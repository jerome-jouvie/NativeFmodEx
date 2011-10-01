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

public class FMOD_EVENT_SYSTEMINFO extends Pointer {
	/**
	 * Create a view of the <code>Pointer</code> object as a <code>FMOD_EVENT_SYSTEMINFO</code> object.<br>
	 * This view is valid only if the memory holded by the <code>Pointer</code> holds a FMOD_EVENT_SYSTEMINFO object.
	 */
	public static FMOD_EVENT_SYSTEMINFO asFMOD_EVENT_SYSTEMINFO(Pointer pointer) {
		long address = Pointer.getPointer(pointer);
		if(address == 0) return null;
		return new FMOD_EVENT_SYSTEMINFO(address);
	}
	/**
	 * Allocate a new <code>FMOD_EVENT_SYSTEMINFO</code>.<br>
	 * The call <code>isNull()</code> on the object created will return false.<br>
	 * <pre><code>  FMOD_EVENT_SYSTEMINFO obj = FMOD_EVENT_SYSTEMINFO.allocate();
	 *  (obj == null) <=> obj.isNull() <=> false
	 * </code></pre>
	 */
	public static FMOD_EVENT_SYSTEMINFO allocate() {
		final long pointer = StructureJNI.FMOD_EVENT_SYSTEMINFO_new();
		if(pointer == 0) throw new OutOfMemoryError();
		return new FMOD_EVENT_SYSTEMINFO(pointer);
	}

	protected FMOD_EVENT_SYSTEMINFO(long pointer) {
		super(pointer);
	}

	/**
	 * Create an object that holds a null <code>FMOD_EVENT_SYSTEMINFO</code>.<br>
	 * The call <code>isNull()</code> on the object created will returns true.<br>
	 * <pre><code>  FMOD_EVENT_SYSTEMINFO obj = new FMOD_EVENT_SYSTEMINFO();
	 *  (obj == null) <=> false
	 *  obj.isNull() <=> true
	 * </code></pre>
	 * To creates a new <code>FMOD_EVENT_SYSTEMINFO</code>, use the static "constructor" :
	 * <pre><code>  FMOD_EVENT_SYSTEMINFO obj = FMOD_EVENT_SYSTEMINFO.allocate();</code></pre>
	 * @see FMOD_EVENT_SYSTEMINFO#allocate()
	 */
	public FMOD_EVENT_SYSTEMINFO() {
		super();
	}

	public void release() {
		if(pointer != 0) {
			StructureJNI.FMOD_EVENT_SYSTEMINFO_delete(pointer);
		}
		pointer = 0;
	}

	/**
	 * [out] Total number of events in all event groups in this event system.
	 */
	public int getNumEvents() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_EVENT_SYSTEMINFO_get_numevents(pointer);
		return javaResult;
	}

	/**
	 * [out] Total number of event instances in all event groups in this event system.
	 */
	public int getNumInstances() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_EVENT_SYSTEMINFO_get_numinstances(pointer);
		return javaResult;
	}

	/**
	 * [in/out] Out, number of wavebanks loaded by the EventSystem.  In. Maximum size of array of wavebankinfo structures supplied by user.  Optional.
	 */
	public int getMaxWaveBanks() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_EVENT_SYSTEMINFO_get_maxwavebanks(pointer);
		return javaResult;
	}

	/**
	 * [in] Pointer to array FMOD_EVENT_WAVEBANKINFO structures (max size defined by maxwavebanks).  FMOD will fill these in with detailed information on each wave bank. Optional.
	 */
	public FMOD_EVENT_WAVEBANKINFO[] getWavebankInfo() {
		if(pointer == 0) throw new NullPointerException();
		long javaResult = StructureJNI.FMOD_EVENT_SYSTEMINFO_get_wavebankinfo(pointer);
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
		StructureJNI.FMOD_EVENT_SYSTEMINFO_set_wavebankinfo(pointer, (wavebankInfo == null) ? 0 : Pointer.getPointer(wavebankInfo[0]), (wavebankInfo == null) ? 0 : wavebankInfo.length);
	}

	/**
	 * [in/out] On entry, maximum number of entries in playingevents array. On exit, actual number of entries in playingevents array, or if playingevents is null, then it is just the number of currently playing events. Optional.
	 */
	public int getNumPlayingEvents() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_EVENT_SYSTEMINFO_get_numplayingevents(pointer);
		return javaResult;
	}

	/**
	 * [in/out] Pointer to an array that will be filled with the event handles of all playing events. Optional. Specify 0 if not needed. Must be used in conjunction with numplayingevents.
	 */
	public Event[] getPlayingEvents() {
		if(pointer == 0) throw new NullPointerException();
		Event[] javaResult = StructureJNI.FMOD_EVENT_SYSTEMINFO_get_playingevents(pointer);
		return javaResult;
	}
	/**
	 * [in/out] Pointer to an array that will be filled with the event handles of all playing events. Optional. Specify 0 if not needed. Must be used in conjunction with numplayingevents.
	 */
	public void setPlayingEvents(Event[] playingEvents) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_EVENT_SYSTEMINFO_set_playingevents(pointer, playingEvents);
	}

}
