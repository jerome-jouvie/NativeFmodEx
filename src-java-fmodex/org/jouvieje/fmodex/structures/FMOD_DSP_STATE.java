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

public class FMOD_DSP_STATE extends Pointer {
	/**
	 * Create a view of the <code>Pointer</code> object as a <code>FMOD_DSP_STATE</code> object.<br>
	 * This view is valid only if the memory holded by the <code>Pointer</code> holds a FMOD_DSP_STATE object.
	 */
	public static FMOD_DSP_STATE asFMOD_DSP_STATE(Pointer pointer) {
		long address = Pointer.getPointer(pointer);
		if(address == 0) return null;
		return new FMOD_DSP_STATE(address);
	}
	/**
	 * Allocate a new <code>FMOD_DSP_STATE</code>.<br>
	 * The call <code>isNull()</code> on the object created will return false.<br>
	 * <pre><code>  FMOD_DSP_STATE obj = FMOD_DSP_STATE.allocate();
	 *  (obj == null) <=> obj.isNull() <=> false
	 * </code></pre>
	 */
	public static FMOD_DSP_STATE allocate() {
		final long pointer = StructureJNI.FMOD_DSP_STATE_new();
		if(pointer == 0) throw new OutOfMemoryError();
		return new FMOD_DSP_STATE(pointer);
	}

	protected FMOD_DSP_STATE(long pointer) {
		super(pointer);
	}

	/**
	 * Create an object that holds a null <code>FMOD_DSP_STATE</code>.<br>
	 * The call <code>isNull()</code> on the object created will returns true.<br>
	 * <pre><code>  FMOD_DSP_STATE obj = new FMOD_DSP_STATE();
	 *  (obj == null) <=> false
	 *  obj.isNull() <=> true
	 * </code></pre>
	 * To creates a new <code>FMOD_DSP_STATE</code>, use the static "constructor" :
	 * <pre><code>  FMOD_DSP_STATE obj = FMOD_DSP_STATE.allocate();</code></pre>
	 * @see FMOD_DSP_STATE#allocate()
	 */
	public FMOD_DSP_STATE() {
		super();
	}

	public void release() {
		if(pointer != 0) {
			StructureJNI.FMOD_DSP_STATE_delete(pointer);
		}
		pointer = 0;
	}

	/**
	 * [r] Handle to the DSP hand the user created.  Not to be modified.  C++ users cast to FMOD::DSP to use.
	 */
	public DSP getInstance() {
		if(pointer == 0) throw new NullPointerException();
		long javaResult = StructureJNI.FMOD_DSP_STATE_get_instance(pointer);
		return javaResult == 0 ? null : DSP.asDSP(Pointer.newPointer(javaResult));
	}

	/**
	 * [w] Plugin writer created data the output author wants to attach to this object.
	 */
	public Pointer getPluginData() {
		if(pointer == 0) throw new NullPointerException();
		long javaResult = StructureJNI.FMOD_DSP_STATE_get_plugindata(pointer);
		return javaResult == 0 ? null : Pointer.newPointer(javaResult);
	}
	/**
	 * [w] Plugin writer created data the output author wants to attach to this object.
	 */
	public void setPluginData(Pointer pluginData) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_DSP_STATE_set_plugindata(pointer, Pointer.getPointer(pluginData));
	}

	/**
	 * [w] Specifies which speakers the DSP effect is active on
	 */
	public short getSpeakerMask() {
		if(pointer == 0) throw new NullPointerException();
		short javaResult = StructureJNI.FMOD_DSP_STATE_get_speakermask(pointer);
		return javaResult;
	}
	/**
	 * [w] Specifies which speakers the DSP effect is active on
	 */
	public void setSpeakerMask(short speakerMask) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_DSP_STATE_set_speakermask(pointer, speakerMask);
	}

}
