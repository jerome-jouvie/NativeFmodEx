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

public class FMOD_EVENT_LOADINFO extends Pointer {
	/**
	 * Create a view of the <code>Pointer</code> object as a <code>FMOD_EVENT_LOADINFO</code> object.<br>
	 * This view is valid only if the memory holded by the <code>Pointer</code> holds a FMOD_EVENT_LOADINFO object.
	 */
	public static FMOD_EVENT_LOADINFO asFMOD_EVENT_LOADINFO(Pointer pointer) {
		long address = Pointer.getPointer(pointer);
		if(address == 0) return null;
		return new FMOD_EVENT_LOADINFO(address);
	}
	/**
	 * Allocate a new <code>FMOD_EVENT_LOADINFO</code>.<br>
	 * The call <code>isNull()</code> on the object created will return false.<br>
	 * <pre><code>  FMOD_EVENT_LOADINFO obj = FMOD_EVENT_LOADINFO.allocate();
	 *  (obj == null) <=> obj.isNull() <=> false
	 * </code></pre>
	 */
	public static FMOD_EVENT_LOADINFO allocate() {
		final long pointer = StructureJNI.FMOD_EVENT_LOADINFO_new();
		if(pointer == 0) throw new OutOfMemoryError();
		return new FMOD_EVENT_LOADINFO(pointer);
	}

	protected FMOD_EVENT_LOADINFO(long pointer) {
		super(pointer);
	}

	/**
	 * Create an object that holds a null <code>FMOD_EVENT_LOADINFO</code>.<br>
	 * The call <code>isNull()</code> on the object created will returns true.<br>
	 * <pre><code>  FMOD_EVENT_LOADINFO obj = new FMOD_EVENT_LOADINFO();
	 *  (obj == null) <=> false
	 *  obj.isNull() <=> true
	 * </code></pre>
	 * To creates a new <code>FMOD_EVENT_LOADINFO</code>, use the static "constructor" :
	 * <pre><code>  FMOD_EVENT_LOADINFO obj = FMOD_EVENT_LOADINFO.allocate();</code></pre>
	 * @see FMOD_EVENT_LOADINFO#allocate()
	 */
	public FMOD_EVENT_LOADINFO() {
		super();
	}

	public void release() {
		if(pointer != 0) {
			StructureJNI.FMOD_EVENT_LOADINFO_delete(pointer);
		}
		pointer = 0;
	}

	/**
	 * [in] Size of this structure.  This is used so the structure can be expanded in the future and still work on older versions of FMOD Ex.
	 */
	public int getSize() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_EVENT_LOADINFO_get_size(pointer);
		return javaResult;
	}
	/**
	 * [in] Size of this structure.  This is used so the structure can be expanded in the future and still work on older versions of FMOD Ex.
	 */
	public void setSize(int size) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_EVENT_LOADINFO_set_size(pointer, size);
	}

	/**
	 * [in] Optional. Specify 0 to ignore. Key, or 'password' to decrypt a bank.  A sound designer may have encrypted the audio data to protect their sound data from 'rippers'.
	 */
	public String getEncryptionKey() {
		if(pointer == 0) throw new NullPointerException();
		String javaResult = StructureJNI.FMOD_EVENT_LOADINFO_get_encryptionkey(pointer);
		return javaResult;
	}
	/**
	 * [in] Optional. Specify 0 to ignore. Key, or 'password' to decrypt a bank.  A sound designer may have encrypted the audio data to protect their sound data from 'rippers'.
	 */
	public void setEncryptionKey(String encryptionKey) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_EVENT_LOADINFO_set_encryptionkey(pointer, encryptionKey == null ? null : encryptionKey.getBytes());
	}

	/**
	 * [in] Optional. Specify 0 to ignore. A value between 0 -> 1 that is multiplied with the number of sound definition entries in each sound definition in the project being loaded in order to programmatically reduce the number of sound definition entries used at runtime.
	 */
	public float getSoundDefEntryLimit() {
		if(pointer == 0) throw new NullPointerException();
		float javaResult = StructureJNI.FMOD_EVENT_LOADINFO_get_sounddefentrylimit(pointer);
		return javaResult;
	}
	/**
	 * [in] Optional. Specify 0 to ignore. A value between 0 -> 1 that is multiplied with the number of sound definition entries in each sound definition in the project being loaded in order to programmatically reduce the number of sound definition entries used at runtime.
	 */
	public void setSoundDefEntryLimit(float soundDefEntryLimit) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_EVENT_LOADINFO_set_sounddefentrylimit(pointer, soundDefEntryLimit);
	}

	/**
	 * [in] Optional. Specify 0 to ignore. Length of memory buffer pointed to by name_or_data parameter passed to EventSystem::load. If this field is non-zero then the name_or_data parameter passed to EventSystem::load will be interpreted as a pointer to a memory buffer containing the .fev data to load. If this field is zero the name_or_data parameter is interpreted as the filename of the .fev file to load.
	 */
	public int getLoadFromMemoryLength() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_EVENT_LOADINFO_get_loadfrommemory_length(pointer);
		return javaResult;
	}
	/**
	 * [in] Optional. Specify 0 to ignore. Length of memory buffer pointed to by name_or_data parameter passed to EventSystem::load. If this field is non-zero then the name_or_data parameter passed to EventSystem::load will be interpreted as a pointer to a memory buffer containing the .fev data to load. If this field is zero the name_or_data parameter is interpreted as the filename of the .fev file to load.
	 */
	public void setLoadFromMemoryLength(int loadFromMemoryLength) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_EVENT_LOADINFO_set_loadfrommemory_length(pointer, loadFromMemoryLength);
	}

	/**
	 * [in] Optional. If this member is set to true, newly-loaded categories will impart their properties (volume, pitch etc.) to existing categories of the same name.
	 */
	public boolean getOverrideCategoryVals() {
		if(pointer == 0) throw new NullPointerException();
		boolean javaResult = StructureJNI.FMOD_EVENT_LOADINFO_get_override_category_vals(pointer);
		return javaResult;
	}
	/**
	 * [in] Optional. If this member is set to true, newly-loaded categories will impart their properties (volume, pitch etc.) to existing categories of the same name.
	 */
	public void setOverrideCategoryVals(boolean overrideCategoryVals) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_EVENT_LOADINFO_set_override_category_vals(pointer, overrideCategoryVals);
	}

	/**
	 * [in] Optional. Specify 0 to ignore. If this value is non-zero, FMOD will create an instance pool for simple events with "sizeof_instancepool_simple" entries. Note: Event instance pools currently work for simple events only. Complex events will behave as normal and not be pooled.
	 */
	public int getSizeofInstancePoolSimple() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_EVENT_LOADINFO_get_sizeof_instancepool_simple(pointer);
		return javaResult;
	}
	/**
	 * [in] Optional. Specify 0 to ignore. If this value is non-zero, FMOD will create an instance pool for simple events with "sizeof_instancepool_simple" entries. Note: Event instance pools currently work for simple events only. Complex events will behave as normal and not be pooled.
	 */
	public void setSizeofInstancePoolSimple(int sizeofInstancePoolSimple) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_EVENT_LOADINFO_set_sizeof_instancepool_simple(pointer, sizeofInstancePoolSimple);
	}

}
