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

public class FMOD_CDTOC extends Pointer {
	/**
	 * Create a view of the <code>Pointer</code> object as a <code>FMOD_CDTOC</code> object.<br>
	 * This view is valid only if the memory holded by the <code>Pointer</code> holds a FMOD_CDTOC object.
	 */
	public static FMOD_CDTOC asFMOD_CDTOC(Pointer pointer) {
		long address = Pointer.getPointer(pointer);
		if(address == 0) return null;
		return new FMOD_CDTOC(address);
	}
	/**
	 * Allocate a new <code>FMOD_CDTOC</code>.<br>
	 * The call <code>isNull()</code> on the object created will return false.<br>
	 * <pre><code>  FMOD_CDTOC obj = FMOD_CDTOC.allocate();
	 *  (obj == null) <=> obj.isNull() <=> false
	 * </code></pre>
	 */
	public static FMOD_CDTOC allocate() {
		final long pointer = StructureJNI.FMOD_CDTOC_new();
		if(pointer == 0) throw new OutOfMemoryError();
		return new FMOD_CDTOC(pointer);
	}

	protected FMOD_CDTOC(long pointer) {
		super(pointer);
	}

	/**
	 * Create an object that holds a null <code>FMOD_CDTOC</code>.<br>
	 * The call <code>isNull()</code> on the object created will returns true.<br>
	 * <pre><code>  FMOD_CDTOC obj = new FMOD_CDTOC();
	 *  (obj == null) <=> false
	 *  obj.isNull() <=> true
	 * </code></pre>
	 * To creates a new <code>FMOD_CDTOC</code>, use the static "constructor" :
	 * <pre><code>  FMOD_CDTOC obj = FMOD_CDTOC.allocate();</code></pre>
	 * @see FMOD_CDTOC#allocate()
	 */
	public FMOD_CDTOC() {
		super();
	}

	public void release() {
		if(pointer != 0) {
			StructureJNI.FMOD_CDTOC_delete(pointer);
		}
		pointer = 0;
	}

	/**
	 * [r] The number of tracks on the CD
	 */
	public int getNumTracks() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_CDTOC_get_numtracks(pointer);
		return javaResult;
	}

	/**
	 * [r] The start offset of each track in minutes
	 */
	public IntBuffer getMin() {
		if(pointer == 0) throw new NullPointerException();
		ByteBuffer javaResult = StructureJNI.FMOD_CDTOC_get_min(pointer);
		if(javaResult == null) { return null; }
		javaResult.order(ByteOrder.nativeOrder());
		return javaResult.asIntBuffer();
	}

	/**
	 * [r] The start offset of each track in seconds
	 */
	public IntBuffer getSec() {
		if(pointer == 0) throw new NullPointerException();
		ByteBuffer javaResult = StructureJNI.FMOD_CDTOC_get_sec(pointer);
		if(javaResult == null) { return null; }
		javaResult.order(ByteOrder.nativeOrder());
		return javaResult.asIntBuffer();
	}

	/**
	 * [r] The start offset of each track in frames
	 */
	public IntBuffer getFrame() {
		if(pointer == 0) throw new NullPointerException();
		ByteBuffer javaResult = StructureJNI.FMOD_CDTOC_get_frame(pointer);
		if(javaResult == null) { return null; }
		javaResult.order(ByteOrder.nativeOrder());
		return javaResult.asIntBuffer();
	}

}
