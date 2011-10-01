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

public class FMOD_MUSIC_ENTITY extends Pointer {
	/**
	 * Create a view of the <code>Pointer</code> object as a <code>FMOD_MUSIC_ENTITY</code> object.<br>
	 * This view is valid only if the memory holded by the <code>Pointer</code> holds a FMOD_MUSIC_ENTITY object.
	 */
	public static FMOD_MUSIC_ENTITY asFMOD_MUSIC_ENTITY(Pointer pointer) {
		long address = Pointer.getPointer(pointer);
		if(address == 0) return null;
		return new FMOD_MUSIC_ENTITY(address);
	}
	/**
	 * Allocate a new <code>FMOD_MUSIC_ENTITY</code>.<br>
	 * The call <code>isNull()</code> on the object created will return false.<br>
	 * <pre><code>  FMOD_MUSIC_ENTITY obj = FMOD_MUSIC_ENTITY.allocate();
	 *  (obj == null) <=> obj.isNull() <=> false
	 * </code></pre>
	 */
	public static FMOD_MUSIC_ENTITY allocate() {
		final long pointer = StructureJNI.FMOD_MUSIC_ENTITY_new();
		if(pointer == 0) throw new OutOfMemoryError();
		return new FMOD_MUSIC_ENTITY(pointer);
	}

	protected FMOD_MUSIC_ENTITY(long pointer) {
		super(pointer);
	}

	/**
	 * Create an object that holds a null <code>FMOD_MUSIC_ENTITY</code>.<br>
	 * The call <code>isNull()</code> on the object created will returns true.<br>
	 * <pre><code>  FMOD_MUSIC_ENTITY obj = new FMOD_MUSIC_ENTITY();
	 *  (obj == null) <=> false
	 *  obj.isNull() <=> true
	 * </code></pre>
	 * To creates a new <code>FMOD_MUSIC_ENTITY</code>, use the static "constructor" :
	 * <pre><code>  FMOD_MUSIC_ENTITY obj = FMOD_MUSIC_ENTITY.allocate();</code></pre>
	 * @see FMOD_MUSIC_ENTITY#allocate()
	 */
	public FMOD_MUSIC_ENTITY() {
		super();
	}

	public void release() {
		if(pointer != 0) {
			StructureJNI.FMOD_MUSIC_ENTITY_delete(pointer);
		}
		pointer = 0;
	}

	/**
	 * The name of the music entity as a null terminated string.
	 */
	public String getName() {
		if(pointer == 0) throw new NullPointerException();
		String javaResult = StructureJNI.FMOD_MUSIC_ENTITY_get_name(pointer);
		return javaResult;
	}
	/**
	 * The name of the music entity as a null terminated string.
	 */
	public void setName(String name) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_MUSIC_ENTITY_set_name(pointer, name == null ? null : name.getBytes());
	}

	/**
	 * The ID of the music entity.
	 */
	public int getId() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_MUSIC_ENTITY_get_id(pointer);
		return javaResult;
	}
	/**
	 * The ID of the music entity.
	 */
	public void setId(int id) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_MUSIC_ENTITY_set_id(pointer, id);
	}

}
