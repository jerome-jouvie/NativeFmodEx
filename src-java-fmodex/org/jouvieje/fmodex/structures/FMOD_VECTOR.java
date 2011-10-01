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

public class FMOD_VECTOR extends Pointer {
	/**
	 * Create a new <code>FMOD_VECTOR</code>.<br>
	 * The call <code>isNull()</code> on the object created will return false.<br>
	 * <pre><code>  FMOD_VECTOR obj = FMOD_VECTOR.allocate();
	 *  (obj == null) <=> obj.isNull() <=> false
	 * </code></pre>
	 * @param x X co-ordinate in 3D space.
	 * @param y Y co-ordinate in 3D space.
	 * @param z Z co-ordinate in 3D space.
	 */
	public static FMOD_VECTOR allocate(float x, float y, float z) {
		return new FMOD_VECTOR(StructureJNI.FMOD_VECTOR_allocate(x, y, z));
	}

	/**
	 * Create a view of the <code>Pointer</code> object as a <code>FMOD_VECTOR</code> object.<br>
	 * This view is valid only if the memory holded by the <code>Pointer</code> holds a FMOD_VECTOR object.
	 */
	public static FMOD_VECTOR asFMOD_VECTOR(Pointer pointer) {
		long address = Pointer.getPointer(pointer);
		if(address == 0) return null;
		return new FMOD_VECTOR(address);
	}
	/**
	 * Allocate and initialize a new <code>FMOD_VECTOR[]</code>.<br>
	 * @param length length of the array returned.
	 */
	public static FMOD_VECTOR[] allocate(int length) {
		if(length <= 0) {
			 return null;
		}
		long first = StructureJNI.FMOD_VECTOR_newArray(length);
		if(first == 0) throw new OutOfMemoryError();
		
		final long sizeOf = StructureJNI.FMOD_VECTOR_SIZEOF();
		FMOD_VECTOR[] array = new FMOD_VECTOR[length];
		for(int i = 0; i < length; i++) {
			array[i] = new FMOD_VECTOR(first + i * sizeOf);
		}
		return array;
	}

	/**
	 * Allocate a new <code>FMOD_VECTOR</code>.<br>
	 * The call <code>isNull()</code> on the object created will return false.<br>
	 * <pre><code>  FMOD_VECTOR obj = FMOD_VECTOR.allocate();
	 *  (obj == null) <=> obj.isNull() <=> false
	 * </code></pre>
	 */
	public static FMOD_VECTOR allocate() {
		final long pointer = StructureJNI.FMOD_VECTOR_new();
		if(pointer == 0) throw new OutOfMemoryError();
		return new FMOD_VECTOR(pointer);
	}

	protected FMOD_VECTOR(long pointer) {
		super(pointer);
	}

	/**
	 * Create an object that holds a null <code>FMOD_VECTOR</code>.<br>
	 * The call <code>isNull()</code> on the object created will returns true.<br>
	 * <pre><code>  FMOD_VECTOR obj = new FMOD_VECTOR();
	 *  (obj == null) <=> false
	 *  obj.isNull() <=> true
	 * </code></pre>
	 * To creates a new <code>FMOD_VECTOR</code>, use the static "constructor" :
	 * <pre><code>  FMOD_VECTOR obj = FMOD_VECTOR.allocate();</code></pre>
	 * @see FMOD_VECTOR#allocate()
	 */
	public FMOD_VECTOR() {
		super();
	}

	public void release() {
		if(pointer != 0) {
			StructureJNI.FMOD_VECTOR_delete(pointer);
		}
		pointer = 0;
	}

	/**
	 * X co-ordinate in 3D space.
	 */
	public float getX() {
		if(pointer == 0) throw new NullPointerException();
		float javaResult = StructureJNI.FMOD_VECTOR_get_x(pointer);
		return javaResult;
	}
	/**
	 * X co-ordinate in 3D space.
	 */
	public void setX(float x) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_VECTOR_set_x(pointer, x);
	}

	/**
	 * Y co-ordinate in 3D space.
	 */
	public float getY() {
		if(pointer == 0) throw new NullPointerException();
		float javaResult = StructureJNI.FMOD_VECTOR_get_y(pointer);
		return javaResult;
	}
	/**
	 * Y co-ordinate in 3D space.
	 */
	public void setY(float y) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_VECTOR_set_y(pointer, y);
	}

	/**
	 * Z co-ordinate in 3D space.
	 */
	public float getZ() {
		if(pointer == 0) throw new NullPointerException();
		float javaResult = StructureJNI.FMOD_VECTOR_get_z(pointer);
		return javaResult;
	}
	/**
	 * Z co-ordinate in 3D space.
	 */
	public void setZ(float z) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_VECTOR_set_z(pointer, z);
	}

	/**
	 * X, Y & Z co-ordinate in 3D space.
	 */
	public void set(FMOD_VECTOR vector) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_VECTOR_set_xyz(pointer, Pointer.getPointer(vector));
	}
	
	/**
	 * X, Y & Z co-ordinate in 3D space.
	 */
	public void set(float x, float y, float z) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_VECTOR_set_xyz(pointer, x, y, z);
	}
}
