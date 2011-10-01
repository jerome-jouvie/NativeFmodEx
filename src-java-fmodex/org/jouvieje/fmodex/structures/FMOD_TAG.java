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

public class FMOD_TAG extends Pointer {
	/**
	 * Create a view of the <code>Pointer</code> object as a <code>FMOD_TAG</code> object.<br>
	 * This view is valid only if the memory holded by the <code>Pointer</code> holds a FMOD_TAG object.
	 */
	public static FMOD_TAG asFMOD_TAG(Pointer pointer) {
		long address = Pointer.getPointer(pointer);
		if(address == 0) return null;
		return new FMOD_TAG(address);
	}
	/**
	 * Allocate a new <code>FMOD_TAG</code>.<br>
	 * The call <code>isNull()</code> on the object created will return false.<br>
	 * <pre><code>  FMOD_TAG obj = FMOD_TAG.allocate();
	 *  (obj == null) <=> obj.isNull() <=> false
	 * </code></pre>
	 */
	public static FMOD_TAG allocate() {
		final long pointer = StructureJNI.FMOD_TAG_new();
		if(pointer == 0) throw new OutOfMemoryError();
		return new FMOD_TAG(pointer);
	}

	protected FMOD_TAG(long pointer) {
		super(pointer);
	}

	/**
	 * Create an object that holds a null <code>FMOD_TAG</code>.<br>
	 * The call <code>isNull()</code> on the object created will returns true.<br>
	 * <pre><code>  FMOD_TAG obj = new FMOD_TAG();
	 *  (obj == null) <=> false
	 *  obj.isNull() <=> true
	 * </code></pre>
	 * To creates a new <code>FMOD_TAG</code>, use the static "constructor" :
	 * <pre><code>  FMOD_TAG obj = FMOD_TAG.allocate();</code></pre>
	 * @see FMOD_TAG#allocate()
	 */
	public FMOD_TAG() {
		super();
	}

	public void release() {
		if(pointer != 0) {
			StructureJNI.FMOD_TAG_delete(pointer);
		}
		pointer = 0;
	}

	/**
	 * [r] The type of this tag.
	 */
	public FMOD_TAGTYPE getType() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_TAG_get_type(pointer);
		return FMOD_TAGTYPE.get(javaResult);
	}

	/**
	 * [r] The type of data that this tag contains
	 */
	public FMOD_TAGDATATYPE getDataType() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_TAG_get_datatype(pointer);
		return FMOD_TAGDATATYPE.get(javaResult);
	}

	/**
	 * [r] The name of this tag i.e. "TITLE", "ARTIST" etc.
	 */
	public String getName() {
		if(pointer == 0) throw new NullPointerException();
		String javaResult = StructureJNI.FMOD_TAG_get_name(pointer);
		return javaResult;
	}

	/**
	 * [r] Pointer to the tag data - its format is determined by the datatype member
	 */
	public Pointer getData() {
		if(pointer == 0) throw new NullPointerException();
		long javaResult = StructureJNI.FMOD_TAG_get_data(pointer);
		return javaResult == 0 ? null : Pointer.newPointer(javaResult);
	}

	/**
	 * [r] Length of the data contained in this tag
	 */
	public int getDataLen() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_TAG_get_datalen(pointer);
		return javaResult;
	}

	/**
	 * [r] True if this tag has been updated since last being accessed with Sound::getTag
	 */
	public boolean getUpdated() {
		if(pointer == 0) throw new NullPointerException();
		boolean javaResult = StructureJNI.FMOD_TAG_get_updated(pointer);
		return javaResult;
	}

}
