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

package org.jouvieje.fmodex.structures;

import org.jouvieje.fmodex.*;
import org.jouvieje.fmodex.exceptions.*;
import org.jouvieje.fmodex.callbacks.*;
import org.jouvieje.fmodex.*;
import org.jouvieje.fmodex.defines.*;
import org.jouvieje.fmodex.enumerations.*;
import org.jouvieje.fmodex.structures.*;
import java.nio.*;
import org.jouvieje.fmodex.utils.*;
import org.jouvieje.fmodex.System;

public class FMOD_ASYNCREADINFO extends Pointer {
	/**
	 * Create a view of the <code>Pointer</code> object as a <code>FMOD_ASYNCREADINFO</code> object.<br>
	 * This view is valid only if the memory holded by the <code>Pointer</code> holds a FMOD_ASYNCREADINFO object.
	 */
	public static FMOD_ASYNCREADINFO asFMOD_ASYNCREADINFO(Pointer pointer) {
		long address = Pointer.getPointer(pointer);
		if(address == 0) return null;
		return new FMOD_ASYNCREADINFO(address);
	}
	/**
	 * Allocate a new <code>FMOD_ASYNCREADINFO</code>.<br>
	 * The call <code>isNull()</code> on the object created will return false.<br>
	 * <pre><code>  FMOD_ASYNCREADINFO obj = FMOD_ASYNCREADINFO.allocate();
	 *  (obj == null) <=> obj.isNull() <=> false
	 * </code></pre>
	 */
	public static FMOD_ASYNCREADINFO allocate() {
		final long pointer = StructureJNI.FMOD_ASYNCREADINFO_new();
		if(pointer == 0) throw new OutOfMemoryError();
		return new FMOD_ASYNCREADINFO(pointer);
	}

	protected FMOD_ASYNCREADINFO(long pointer) {
		super(pointer);
	}

	/**
	 * Create an object that holds a null <code>FMOD_ASYNCREADINFO</code>.<br>
	 * The call <code>isNull()</code> on the object created will returns true.<br>
	 * <pre><code>  FMOD_ASYNCREADINFO obj = new FMOD_ASYNCREADINFO();
	 *  (obj == null) <=> false
	 *  obj.isNull() <=> true
	 * </code></pre>
	 * To creates a new <code>FMOD_ASYNCREADINFO</code>, use the static "constructor" :
	 * <pre><code>  FMOD_ASYNCREADINFO obj = FMOD_ASYNCREADINFO.allocate();</code></pre>
	 * @see FMOD_ASYNCREADINFO#allocate()
	 */
	public FMOD_ASYNCREADINFO() {
		super();
	}

	public void release() {
		if(pointer != 0) {
			StructureJNI.FMOD_ASYNCREADINFO_delete(pointer);
		}
		pointer = 0;
	}

	/**
	 * [r] The file handle that was filled out in the open callback.
	 */
	public Pointer getHandle() {
		if(pointer == 0) throw new NullPointerException();
		long javaResult = StructureJNI.FMOD_ASYNCREADINFO_get_handle(pointer);
		return javaResult == 0 ? null : Pointer.newPointer(javaResult);
	}

	/**
	 * [r] Seek position, make sure you read from this file offset.
	 */
	public int getOffset() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_ASYNCREADINFO_get_offset(pointer);
		return javaResult;
	}

	/**
	 * [r] how many bytes requested for read.
	 */
	public int getSizeBytes() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_ASYNCREADINFO_get_sizebytes(pointer);
		return javaResult;
	}

	/**
	 * [r] 0 = low importance.  100 = extremely important (ie 'must read now or stuttering may occur')
	 */
	public int getPriority() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_ASYNCREADINFO_get_priority(pointer);
		return javaResult;
	}

	/**
	 * [w] Buffer to read file data into.
	 */
	public Pointer getBuffer() {
		if(pointer == 0) throw new NullPointerException();
		long javaResult = StructureJNI.FMOD_ASYNCREADINFO_get_buffer(pointer);
		return javaResult == 0 ? null : Pointer.newPointer(javaResult);
	}
	/**
	 * [w] Buffer to read file data into.
	 */
	public void setBuffer(Pointer buffer) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_ASYNCREADINFO_set_buffer(pointer, Pointer.getPointer(buffer));
	}

	/**
	 * [w] Fill this in before setting result code to tell FMOD how many bytes were read.
	 */
	public int getBytesRead() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_ASYNCREADINFO_get_bytesread(pointer);
		return javaResult;
	}
	/**
	 * [w] Fill this in before setting result code to tell FMOD how many bytes were read.
	 */
	public void setBytesRead(int bytesRead) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_ASYNCREADINFO_set_bytesread(pointer, bytesRead);
	}

	/**
	 * [r/w] Result code, FMOD_OK tells the system it is ready to consume the data.  Set this last!  Default value = FMOD_ERR_NOTREADY.
	 */
	public FMOD_RESULT getResult() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_ASYNCREADINFO_get_result(pointer);
		return FMOD_RESULT.get(javaResult);
	}
	/**
	 * [r/w] Result code, FMOD_OK tells the system it is ready to consume the data.  Set this last!  Default value = FMOD_ERR_NOTREADY.
	 */
	public void setResult(FMOD_RESULT result) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_ASYNCREADINFO_set_result(pointer, result.asInt());
	}

	/**
	 * [r] User data pointer.
	 */
	public Pointer getUserData() {
		if(pointer == 0) throw new NullPointerException();
		long javaResult = StructureJNI.FMOD_ASYNCREADINFO_get_userdata(pointer);
		return javaResult == 0 ? null : Pointer.newPointer(javaResult);
	}

}
