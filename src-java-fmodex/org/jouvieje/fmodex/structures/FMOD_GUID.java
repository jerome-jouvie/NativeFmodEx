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

public class FMOD_GUID extends Pointer {
	/**
	 * Create a view of the <code>Pointer</code> object as a <code>FMOD_GUID</code> object.<br>
	 * This view is valid only if the memory holded by the <code>Pointer</code> holds a FMOD_GUID object.
	 */
	public static FMOD_GUID asFMOD_GUID(Pointer pointer) {
		long address = Pointer.getPointer(pointer);
		if(address == 0) return null;
		return new FMOD_GUID(address);
	}
	/**
	 * Allocate a new <code>FMOD_GUID</code>.<br>
	 * The call <code>isNull()</code> on the object created will return false.<br>
	 * <pre><code>  FMOD_GUID obj = FMOD_GUID.allocate();
	 *  (obj == null) <=> obj.isNull() <=> false
	 * </code></pre>
	 */
	public static FMOD_GUID allocate() {
		final long pointer = StructureJNI.FMOD_GUID_new();
		if(pointer == 0) throw new OutOfMemoryError();
		return new FMOD_GUID(pointer);
	}

	protected FMOD_GUID(long pointer) {
		super(pointer);
	}

	/**
	 * Create an object that holds a null <code>FMOD_GUID</code>.<br>
	 * The call <code>isNull()</code> on the object created will returns true.<br>
	 * <pre><code>  FMOD_GUID obj = new FMOD_GUID();
	 *  (obj == null) <=> false
	 *  obj.isNull() <=> true
	 * </code></pre>
	 * To creates a new <code>FMOD_GUID</code>, use the static "constructor" :
	 * <pre><code>  FMOD_GUID obj = FMOD_GUID.allocate();</code></pre>
	 * @see FMOD_GUID#allocate()
	 */
	public FMOD_GUID() {
		super();
	}

	public void release() {
		if(pointer != 0) {
			StructureJNI.FMOD_GUID_delete(pointer);
		}
		pointer = 0;
	}

	/**
	 * Specifies the first 8 hexadecimal digits of the GUID
	 */
	public int getData1() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_GUID_get_Data1(pointer);
		return javaResult;
	}
	/**
	 * Specifies the first 8 hexadecimal digits of the GUID
	 */
	public void setData1(int data1) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_GUID_set_Data1(pointer, data1);
	}

	/**
	 * Specifies the first group of 4 hexadecimal digits.
	 */
	public short getData2() {
		if(pointer == 0) throw new NullPointerException();
		short javaResult = StructureJNI.FMOD_GUID_get_Data2(pointer);
		return javaResult;
	}
	/**
	 * Specifies the first group of 4 hexadecimal digits.
	 */
	public void setData2(short data2) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_GUID_set_Data2(pointer, data2);
	}

	/**
	 * Specifies the second group of 4 hexadecimal digits.
	 */
	public short getData3() {
		if(pointer == 0) throw new NullPointerException();
		short javaResult = StructureJNI.FMOD_GUID_get_Data3(pointer);
		return javaResult;
	}
	/**
	 * Specifies the second group of 4 hexadecimal digits.
	 */
	public void setData3(short data3) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_GUID_set_Data3(pointer, data3);
	}

	/**
	 * Array of 8 bytes. The first 2 bytes contain the third group of 4 hexadecimal digits. The remaining 6 bytes contain the final 12 hexadecimal digits.
	 */
	public CharBuffer getData4() {
		if(pointer == 0) throw new NullPointerException();
		ByteBuffer javaResult = StructureJNI.FMOD_GUID_get_Data4(pointer);
		if(javaResult == null) { return null; }
		javaResult.order(ByteOrder.nativeOrder());
		return javaResult.asCharBuffer();
	}
	/**
	 * Array of 8 bytes. The first 2 bytes contain the third group of 4 hexadecimal digits. The remaining 6 bytes contain the final 12 hexadecimal digits.
	 */
	public void setData4(String data4) {
		if(pointer == 0) throw new NullPointerException();
		if((data4 != null) && (data4.length() > 8)) {
			throw new IndexOutOfBoundsException();
		}
		StructureJNI.FMOD_GUID_set_Data4(pointer, data4 == null ? null : data4.getBytes());
	}

}
