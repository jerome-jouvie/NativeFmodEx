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

public class FMOD_EVENT_SOUNDDEFINFO extends Pointer {
	/**
	 * Create a view of the <code>Pointer</code> object as a <code>FMOD_EVENT_SOUNDDEFINFO</code> object.<br>
	 * This view is valid only if the memory holded by the <code>Pointer</code> holds a FMOD_EVENT_SOUNDDEFINFO object.
	 */
	public static FMOD_EVENT_SOUNDDEFINFO asFMOD_EVENT_SOUNDDEFINFO(Pointer pointer) {
		long address = Pointer.getPointer(pointer);
		if(address == 0) return null;
		return new FMOD_EVENT_SOUNDDEFINFO(address);
	}
	/**
	 * Allocate a new <code>FMOD_EVENT_SOUNDDEFINFO</code>.<br>
	 * The call <code>isNull()</code> on the object created will return false.<br>
	 * <pre><code>  FMOD_EVENT_SOUNDDEFINFO obj = FMOD_EVENT_SOUNDDEFINFO.allocate();
	 *  (obj == null) <=> obj.isNull() <=> false
	 * </code></pre>
	 */
	public static FMOD_EVENT_SOUNDDEFINFO allocate() {
		final long pointer = StructureJNI.FMOD_EVENT_SOUNDDEFINFO_new();
		if(pointer == 0) throw new OutOfMemoryError();
		return new FMOD_EVENT_SOUNDDEFINFO(pointer);
	}

	protected FMOD_EVENT_SOUNDDEFINFO(long pointer) {
		super(pointer);
	}

	/**
	 * Create an object that holds a null <code>FMOD_EVENT_SOUNDDEFINFO</code>.<br>
	 * The call <code>isNull()</code> on the object created will returns true.<br>
	 * <pre><code>  FMOD_EVENT_SOUNDDEFINFO obj = new FMOD_EVENT_SOUNDDEFINFO();
	 *  (obj == null) <=> false
	 *  obj.isNull() <=> true
	 * </code></pre>
	 * To creates a new <code>FMOD_EVENT_SOUNDDEFINFO</code>, use the static "constructor" :
	 * <pre><code>  FMOD_EVENT_SOUNDDEFINFO obj = FMOD_EVENT_SOUNDDEFINFO.allocate();</code></pre>
	 * @see FMOD_EVENT_SOUNDDEFINFO#allocate()
	 */
	public FMOD_EVENT_SOUNDDEFINFO() {
		super();
	}

	public void release() {
		if(pointer != 0) {
			StructureJNI.FMOD_EVENT_SOUNDDEFINFO_delete(pointer);
		}
		pointer = 0;
	}

	/**
	 * The name of the sound definition.
	 */
	public String getName() {
		if(pointer == 0) throw new NullPointerException();
		String javaResult = StructureJNI.FMOD_EVENT_SOUNDDEFINFO_get_name(pointer);
		return javaResult;
	}

	/**
	 * The number of entries in the sound definition.
	 */
	public int getNumEntries() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_EVENT_SOUNDDEFINFO_get_numentries(pointer);
		return javaResult;
	}

	/**
	 * The names of the entries in the sound definition (an array of size numentries). Note that entrynames[i] will be null if entrytypes[i] is not FMOD_EVENT_SOUNDDEF_ENTRYTYPE_WAVETABLE.
	 */
	public String[] getEntryNames() {
		if(pointer == 0) throw new NullPointerException();
		String[] javaResult = StructureJNI.FMOD_EVENT_SOUNDDEFINFO_get_entrynames(pointer);
		return javaResult;
	}

	/**
	 * The types of the entries in the sound definition (an array of size numentries).
	 */
	public FMOD_EVENT_SOUNDDEF_ENTRYTYPE[] getEntryTypes() {
		if(pointer == 0) throw new NullPointerException();
		ByteBuffer javaResult = StructureJNI.FMOD_EVENT_SOUNDDEFINFO_get_entrytypes(pointer);
		if(javaResult == null) { return null; }
		javaResult.order(ByteOrder.nativeOrder());
		if(javaResult == null) return null;
		IntBuffer entrytypesIntBuffer = javaResult.asIntBuffer();
		if(entrytypesIntBuffer.capacity() <= 0) return null;
		FMOD_EVENT_SOUNDDEF_ENTRYTYPE[] entrytypes = new FMOD_EVENT_SOUNDDEF_ENTRYTYPE[entrytypesIntBuffer.capacity()];
		for(int i = 0; i < entrytypes.length; i++) {
			entrytypes[i] = FMOD_EVENT_SOUNDDEF_ENTRYTYPE.get(entrytypesIntBuffer.get());
		}
		return entrytypes;
	}

}
