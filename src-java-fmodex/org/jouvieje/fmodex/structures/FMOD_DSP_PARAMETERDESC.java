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

public class FMOD_DSP_PARAMETERDESC extends Pointer {
	/**
	 * Create a view of the <code>Pointer</code> object as a <code>FMOD_DSP_PARAMETERDESC</code> object.<br>
	 * This view is valid only if the memory holded by the <code>Pointer</code> holds a FMOD_DSP_PARAMETERDESC object.
	 */
	public static FMOD_DSP_PARAMETERDESC asFMOD_DSP_PARAMETERDESC(Pointer pointer) {
		long address = Pointer.getPointer(pointer);
		if(address == 0) return null;
		return new FMOD_DSP_PARAMETERDESC(address);
	}
	/**
	 * Allocate and initialize a new <code>FMOD_DSP_PARAMETERDESC[]</code>.<br>
	 * @param length length of the array returned.
	 */
	public static FMOD_DSP_PARAMETERDESC[] allocate(int length) {
		if(length <= 0) {
			 return null;
		}
		long first = StructureJNI.FMOD_DSP_PARAMETERDESC_newArray(length);
		if(first == 0) throw new OutOfMemoryError();
		
		final long sizeOf = StructureJNI.FMOD_DSP_PARAMETERDESC_SIZEOF();
		FMOD_DSP_PARAMETERDESC[] array = new FMOD_DSP_PARAMETERDESC[length];
		for(int i = 0; i < length; i++) {
			array[i] = new FMOD_DSP_PARAMETERDESC(first + i * sizeOf);
		}
		return array;
	}

	/**
	 * Allocate a new <code>FMOD_DSP_PARAMETERDESC</code>.<br>
	 * The call <code>isNull()</code> on the object created will return false.<br>
	 * <pre><code>  FMOD_DSP_PARAMETERDESC obj = FMOD_DSP_PARAMETERDESC.allocate();
	 *  (obj == null) <=> obj.isNull() <=> false
	 * </code></pre>
	 */
	public static FMOD_DSP_PARAMETERDESC allocate() {
		final long pointer = StructureJNI.FMOD_DSP_PARAMETERDESC_new();
		if(pointer == 0) throw new OutOfMemoryError();
		return new FMOD_DSP_PARAMETERDESC(pointer);
	}

	protected FMOD_DSP_PARAMETERDESC(long pointer) {
		super(pointer);
	}

	/**
	 * Create an object that holds a null <code>FMOD_DSP_PARAMETERDESC</code>.<br>
	 * The call <code>isNull()</code> on the object created will returns true.<br>
	 * <pre><code>  FMOD_DSP_PARAMETERDESC obj = new FMOD_DSP_PARAMETERDESC();
	 *  (obj == null) <=> false
	 *  obj.isNull() <=> true
	 * </code></pre>
	 * To creates a new <code>FMOD_DSP_PARAMETERDESC</code>, use the static "constructor" :
	 * <pre><code>  FMOD_DSP_PARAMETERDESC obj = FMOD_DSP_PARAMETERDESC.allocate();</code></pre>
	 * @see FMOD_DSP_PARAMETERDESC#allocate()
	 */
	public FMOD_DSP_PARAMETERDESC() {
		super();
	}

	public void release() {
		if(pointer != 0) {
			StructureJNI.FMOD_DSP_PARAMETERDESC_delete(pointer);
		}
		pointer = 0;
	}

	/**
	 * [w] Minimum value of the parameter (ie 100.0).
	 */
	public float getMin() {
		if(pointer == 0) throw new NullPointerException();
		float javaResult = StructureJNI.FMOD_DSP_PARAMETERDESC_get_min(pointer);
		return javaResult;
	}
	/**
	 * [w] Minimum value of the parameter (ie 100.0).
	 */
	public void setMin(float min) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_DSP_PARAMETERDESC_set_min(pointer, min);
	}

	/**
	 * [w] Maximum value of the parameter (ie 22050.0).
	 */
	public float getMax() {
		if(pointer == 0) throw new NullPointerException();
		float javaResult = StructureJNI.FMOD_DSP_PARAMETERDESC_get_max(pointer);
		return javaResult;
	}
	/**
	 * [w] Maximum value of the parameter (ie 22050.0).
	 */
	public void setMax(float max) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_DSP_PARAMETERDESC_set_max(pointer, max);
	}

	/**
	 * [w] Default value of parameter.
	 */
	public float getDefaultVal() {
		if(pointer == 0) throw new NullPointerException();
		float javaResult = StructureJNI.FMOD_DSP_PARAMETERDESC_get_defaultval(pointer);
		return javaResult;
	}
	/**
	 * [w] Default value of parameter.
	 */
	public void setDefaultVal(float defaultVal) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_DSP_PARAMETERDESC_set_defaultval(pointer, defaultVal);
	}

	/**
	 * [w] Name of the parameter to be displayed (ie "Cutoff frequency").
	 */
	public String getName() {
		if(pointer == 0) throw new NullPointerException();
		String javaResult = StructureJNI.FMOD_DSP_PARAMETERDESC_get_name(pointer);
		return javaResult;
	}
	/**
	 * [w] Name of the parameter to be displayed (ie "Cutoff frequency").
	 */
	public void setName(String name) {
		if(pointer == 0) throw new NullPointerException();
		if((name != null) && (name.length() > 16)) {
			throw new IndexOutOfBoundsException();
		}
		StructureJNI.FMOD_DSP_PARAMETERDESC_set_name(pointer, name == null ? null : name.getBytes());
	}

	/**
	 * [w] Short string to be put next to value to denote the unit type (ie "hz").
	 */
	public String getLabel() {
		if(pointer == 0) throw new NullPointerException();
		String javaResult = StructureJNI.FMOD_DSP_PARAMETERDESC_get_label(pointer);
		return javaResult;
	}
	/**
	 * [w] Short string to be put next to value to denote the unit type (ie "hz").
	 */
	public void setLabel(String label) {
		if(pointer == 0) throw new NullPointerException();
		if((label != null) && (label.length() > 16)) {
			throw new IndexOutOfBoundsException();
		}
		StructureJNI.FMOD_DSP_PARAMETERDESC_set_label(pointer, label == null ? null : label.getBytes());
	}

	/**
	 * [w] Description of the parameter to be displayed as a help item / tooltip for this parameter.
	 */
	public String getDescription() {
		if(pointer == 0) throw new NullPointerException();
		String javaResult = StructureJNI.FMOD_DSP_PARAMETERDESC_get_description(pointer);
		return javaResult;
	}
	/**
	 * [w] Description of the parameter to be displayed as a help item / tooltip for this parameter.
	 */
	public void setDescription(String description) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_DSP_PARAMETERDESC_set_description(pointer, description == null ? null : description.getBytes());
	}

}
