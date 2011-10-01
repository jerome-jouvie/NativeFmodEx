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

public class FMOD_MUSIC_SAMPLE_INFO extends Pointer {
	/**
	 * Create a view of the <code>Pointer</code> object as a <code>FMOD_MUSIC_SAMPLE_INFO</code> object.<br>
	 * This view is valid only if the memory holded by the <code>Pointer</code> holds a FMOD_MUSIC_SAMPLE_INFO object.
	 */
	public static FMOD_MUSIC_SAMPLE_INFO asFMOD_MUSIC_SAMPLE_INFO(Pointer pointer) {
		long address = Pointer.getPointer(pointer);
		if(address == 0) return null;
		return new FMOD_MUSIC_SAMPLE_INFO(address);
	}
	/**
	 * Allocate a new <code>FMOD_MUSIC_SAMPLE_INFO</code>.<br>
	 * The call <code>isNull()</code> on the object created will return false.<br>
	 * <pre><code>  FMOD_MUSIC_SAMPLE_INFO obj = FMOD_MUSIC_SAMPLE_INFO.allocate();
	 *  (obj == null) <=> obj.isNull() <=> false
	 * </code></pre>
	 */
	public static FMOD_MUSIC_SAMPLE_INFO allocate() {
		final long pointer = StructureJNI.FMOD_MUSIC_SAMPLE_INFO_new();
		if(pointer == 0) throw new OutOfMemoryError();
		return new FMOD_MUSIC_SAMPLE_INFO(pointer);
	}

	protected FMOD_MUSIC_SAMPLE_INFO(long pointer) {
		super(pointer);
	}

	/**
	 * Create an object that holds a null <code>FMOD_MUSIC_SAMPLE_INFO</code>.<br>
	 * The call <code>isNull()</code> on the object created will returns true.<br>
	 * <pre><code>  FMOD_MUSIC_SAMPLE_INFO obj = new FMOD_MUSIC_SAMPLE_INFO();
	 *  (obj == null) <=> false
	 *  obj.isNull() <=> true
	 * </code></pre>
	 * To creates a new <code>FMOD_MUSIC_SAMPLE_INFO</code>, use the static "constructor" :
	 * <pre><code>  FMOD_MUSIC_SAMPLE_INFO obj = FMOD_MUSIC_SAMPLE_INFO.allocate();</code></pre>
	 * @see FMOD_MUSIC_SAMPLE_INFO#allocate()
	 */
	public FMOD_MUSIC_SAMPLE_INFO() {
		super();
	}

	public void release() {
		if(pointer != 0) {
			StructureJNI.FMOD_MUSIC_SAMPLE_INFO_delete(pointer);
		}
		pointer = 0;
	}

	/**
	 * The ID of the parent segment.
	 */
	public int getSegmentId() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_MUSIC_SAMPLE_INFO_get_segment_id(pointer);
		return javaResult;
	}
	/**
	 * The ID of the parent segment.
	 */
	public void setSegmentId(int segmentId) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_MUSIC_SAMPLE_INFO_set_segment_id(pointer, segmentId);
	}

	/**
	 * The index of the sample within the parent segment.
	 */
	public int getIndex() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_MUSIC_SAMPLE_INFO_get_index(pointer);
		return javaResult;
	}
	/**
	 * The index of the sample within the parent segment.
	 */
	public void setIndex(int index) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_MUSIC_SAMPLE_INFO_set_index(pointer, index);
	}

	/**
	 * The filename of the sample.<br/> <b>Note:</b> If the sample was built by a version of FMOD Designer before 4.29.09, this field will be 0.
	 */
	public String getFileName() {
		if(pointer == 0) throw new NullPointerException();
		String javaResult = StructureJNI.FMOD_MUSIC_SAMPLE_INFO_get_filename(pointer);
		return javaResult;
	}
	/**
	 * The filename of the sample.<br/> <b>Note:</b> If the sample was built by a version of FMOD Designer before 4.29.09, this field will be 0.
	 */
	public void setFileName(String fileName) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_MUSIC_SAMPLE_INFO_set_filename(pointer, fileName == null ? null : fileName.getBytes());
	}

}
