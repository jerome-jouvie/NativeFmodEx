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

public class FMOD_EVENT_WAVEBANKINFO extends Pointer {
	/**
	 * Create a view of the <code>Pointer</code> object as a <code>FMOD_EVENT_WAVEBANKINFO</code> object.<br>
	 * This view is valid only if the memory holded by the <code>Pointer</code> holds a FMOD_EVENT_WAVEBANKINFO object.
	 */
	public static FMOD_EVENT_WAVEBANKINFO asFMOD_EVENT_WAVEBANKINFO(Pointer pointer) {
		long address = Pointer.getPointer(pointer);
		if(address == 0) return null;
		return new FMOD_EVENT_WAVEBANKINFO(address);
	}
	/**
	 * Allocate and initialize a new <code>FMOD_EVENT_WAVEBANKINFO[]</code>.<br>
	 * @param length length of the array returned.
	 */
	public static FMOD_EVENT_WAVEBANKINFO[] allocate(int length) {
		if(length <= 0) {
			 return null;
		}
		long first = StructureJNI.FMOD_EVENT_WAVEBANKINFO_newArray(length);
		if(first == 0) throw new OutOfMemoryError();
		
		final long sizeOf = StructureJNI.FMOD_EVENT_WAVEBANKINFO_SIZEOF();
		FMOD_EVENT_WAVEBANKINFO[] array = new FMOD_EVENT_WAVEBANKINFO[length];
		for(int i = 0; i < length; i++) {
			array[i] = new FMOD_EVENT_WAVEBANKINFO(first + i * sizeOf);
		}
		return array;
	}

	/**
	 * Allocate a new <code>FMOD_EVENT_WAVEBANKINFO</code>.<br>
	 * The call <code>isNull()</code> on the object created will return false.<br>
	 * <pre><code>  FMOD_EVENT_WAVEBANKINFO obj = FMOD_EVENT_WAVEBANKINFO.allocate();
	 *  (obj == null) <=> obj.isNull() <=> false
	 * </code></pre>
	 */
	public static FMOD_EVENT_WAVEBANKINFO allocate() {
		final long pointer = StructureJNI.FMOD_EVENT_WAVEBANKINFO_new();
		if(pointer == 0) throw new OutOfMemoryError();
		return new FMOD_EVENT_WAVEBANKINFO(pointer);
	}

	protected FMOD_EVENT_WAVEBANKINFO(long pointer) {
		super(pointer);
	}

	/**
	 * Create an object that holds a null <code>FMOD_EVENT_WAVEBANKINFO</code>.<br>
	 * The call <code>isNull()</code> on the object created will returns true.<br>
	 * <pre><code>  FMOD_EVENT_WAVEBANKINFO obj = new FMOD_EVENT_WAVEBANKINFO();
	 *  (obj == null) <=> false
	 *  obj.isNull() <=> true
	 * </code></pre>
	 * To creates a new <code>FMOD_EVENT_WAVEBANKINFO</code>, use the static "constructor" :
	 * <pre><code>  FMOD_EVENT_WAVEBANKINFO obj = FMOD_EVENT_WAVEBANKINFO.allocate();</code></pre>
	 * @see FMOD_EVENT_WAVEBANKINFO#allocate()
	 */
	public FMOD_EVENT_WAVEBANKINFO() {
		super();
	}

	public void release() {
		if(pointer != 0) {
			StructureJNI.FMOD_EVENT_WAVEBANKINFO_delete(pointer);
		}
		pointer = 0;
	}

	/**
	 * [out] Name of this wave bank.
	 */
	public CharBuffer getName() {
		if(pointer == 0) throw new NullPointerException();
		ByteBuffer javaResult = StructureJNI.FMOD_EVENT_WAVEBANKINFO_get_name(pointer);
		if(javaResult == null) { return null; }
		javaResult.order(ByteOrder.nativeOrder());
		return javaResult.asCharBuffer();
	}

	/**
	 * [out] Number of stream references to this wave bank made by events in this event system.
	 */
	public int getStreamRefCnt() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_EVENT_WAVEBANKINFO_get_streamrefcnt(pointer);
		return javaResult;
	}

	/**
	 * [out] Number of sample references to this wave bank made by events in this event system.
	 */
	public int getSampleRefCnt() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_EVENT_WAVEBANKINFO_get_samplerefcnt(pointer);
		return javaResult;
	}

	/**
	 * [out] Number of times this wave bank has been opened for streaming.
	 */
	public int getNumStreams() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_EVENT_WAVEBANKINFO_get_numstreams(pointer);
		return javaResult;
	}

	/**
	 * [out] Maximum number of times this wave bank will be opened for streaming.
	 */
	public int getMaxStreams() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_EVENT_WAVEBANKINFO_get_maxstreams(pointer);
		return javaResult;
	}

	/**
	 * [out] Number of streams currently in use.
	 */
	public int getStreamSinuse() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_EVENT_WAVEBANKINFO_get_streamsinuse(pointer);
		return javaResult;
	}

	/**
	 * [out] Amount of memory (in bytes) used by streams.
	 */
	public int getStreamMemory() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_EVENT_WAVEBANKINFO_get_streammemory(pointer);
		return javaResult;
	}

	/**
	 * [out] Amount of memory (in bytes) used by samples.
	 */
	public int getSampleMemory() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_EVENT_WAVEBANKINFO_get_samplememory(pointer);
		return javaResult;
	}

	/**
	 * [out] 0 = stream from disk, 1 = load into memory, 2 = decompress into memory.
	 */
	public int getType() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_EVENT_WAVEBANKINFO_get_type(pointer);
		return javaResult;
	}

}
