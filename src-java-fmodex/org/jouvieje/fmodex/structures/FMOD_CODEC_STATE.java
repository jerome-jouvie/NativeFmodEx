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

public class FMOD_CODEC_STATE extends Pointer {
	/**
	 * Create a view of the <code>Pointer</code> object as a <code>FMOD_CODEC_STATE</code> object.<br>
	 * This view is valid only if the memory holded by the <code>Pointer</code> holds a FMOD_CODEC_STATE object.
	 */
	public static FMOD_CODEC_STATE asFMOD_CODEC_STATE(Pointer pointer) {
		long address = Pointer.getPointer(pointer);
		if(address == 0) return null;
		return new FMOD_CODEC_STATE(address);
	}
	/**
	 * Allocate a new <code>FMOD_CODEC_STATE</code>.<br>
	 * The call <code>isNull()</code> on the object created will return false.<br>
	 * <pre><code>  FMOD_CODEC_STATE obj = FMOD_CODEC_STATE.allocate();
	 *  (obj == null) <=> obj.isNull() <=> false
	 * </code></pre>
	 */
	public static FMOD_CODEC_STATE allocate() {
		final long pointer = StructureJNI.FMOD_CODEC_STATE_new();
		if(pointer == 0) throw new OutOfMemoryError();
		return new FMOD_CODEC_STATE(pointer);
	}

	protected FMOD_CODEC_STATE(long pointer) {
		super(pointer);
	}

	/**
	 * Create an object that holds a null <code>FMOD_CODEC_STATE</code>.<br>
	 * The call <code>isNull()</code> on the object created will returns true.<br>
	 * <pre><code>  FMOD_CODEC_STATE obj = new FMOD_CODEC_STATE();
	 *  (obj == null) <=> false
	 *  obj.isNull() <=> true
	 * </code></pre>
	 * To creates a new <code>FMOD_CODEC_STATE</code>, use the static "constructor" :
	 * <pre><code>  FMOD_CODEC_STATE obj = FMOD_CODEC_STATE.allocate();</code></pre>
	 * @see FMOD_CODEC_STATE#allocate()
	 */
	public FMOD_CODEC_STATE() {
		super();
	}

	public void release() {
		if(pointer != 0) {
			CallbackManager.addCallback(23, null, pointer);
			CallbackManager.addCallback(24, null, pointer);
			CallbackManager.addCallback(6, null, pointer);
			CallbackManager.addOwner(0, pointer);
			StructureJNI.FMOD_CODEC_STATE_delete(pointer);
		}
		pointer = 0;
	}

	/**
	 * [in] Number of 'subsounds' in this sound.  Anything other than 0 makes it a 'container' format (ie CDDA/DLS/FSB etc which contain 1 or more su bsounds).  For most normal, single sound codec such as WAV/AIFF/MP3, this should be 0 as they are not a container for subsounds, they are the sound by itself.
	 */
	public int getNumSubsounds() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_CODEC_STATE_get_numsubsounds(pointer);
		return javaResult;
	}
	/**
	 * [in] Number of 'subsounds' in this sound.  Anything other than 0 makes it a 'container' format (ie CDDA/DLS/FSB etc which contain 1 or more su bsounds).  For most normal, single sound codec such as WAV/AIFF/MP3, this should be 0 as they are not a container for subsounds, they are the sound by itself.
	 */
	public void setNumSubsounds(int numSubsounds) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_CODEC_STATE_set_numsubsounds(pointer, numSubsounds);
	}

	/**
	 * [in] Pointer to an array of format structures containing information about each sample.  Can be 0 or NULL if FMOD_CODEC_GETWAVEFORMAT callback is preferred.  The number of entries here must equal the number of subsounds defined in the subsound parameter. If numsubsounds = 0 then there should be 1 instance of this structure.
	 */
	public FMOD_CODEC_WAVEFORMAT getWaveFormat() {
		if(pointer == 0) throw new NullPointerException();
		long javaResult = StructureJNI.FMOD_CODEC_STATE_get_waveformat(pointer);
		return javaResult == 0 ? null : FMOD_CODEC_WAVEFORMAT.asFMOD_CODEC_WAVEFORMAT(Pointer.newPointer(javaResult));
	}
	/**
	 * [in] Pointer to an array of format structures containing information about each sample.  Can be 0 or NULL if FMOD_CODEC_GETWAVEFORMAT callback is preferred.  The number of entries here must equal the number of subsounds defined in the subsound parameter. If numsubsounds = 0 then there should be 1 instance of this structure.
	 */
	public void setWaveFormat(FMOD_CODEC_WAVEFORMAT waveFormat) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_CODEC_STATE_set_waveformat(pointer, Pointer.getPointer(waveFormat));
	}

	/**
	 * [in] Plugin writer created data the codec author wants to attach to this object.
	 */
	public Pointer getPluginData() {
		if(pointer == 0) throw new NullPointerException();
		long javaResult = StructureJNI.FMOD_CODEC_STATE_get_plugindata(pointer);
		return javaResult == 0 ? null : Pointer.newPointer(javaResult);
	}
	/**
	 * [in] Plugin writer created data the codec author wants to attach to this object.
	 */
	public void setPluginData(Pointer pluginData) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_CODEC_STATE_set_plugindata(pointer, Pointer.getPointer(pluginData));
	}

	/**
	 * [out] This will return an internal FMOD file handle to use with the callbacks provided.
	 */
	public Pointer getFileHandle() {
		if(pointer == 0) throw new NullPointerException();
		long javaResult = StructureJNI.FMOD_CODEC_STATE_get_filehandle(pointer);
		return javaResult == 0 ? null : Pointer.newPointer(javaResult);
	}

	/**
	 * [out] This will contain the size of the file in bytes.
	 */
	public int getFileSize() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_CODEC_STATE_get_filesize(pointer);
		return javaResult;
	}

	/**
	 * Invoke an internal FMOD callback.<BR>
	 * Don't use this for user callbacks (callback created from Java).<BR>
	 * <BR>
	 * For an example of its use, look at CodecRaw esxample.
	 */
	public FMOD_RESULT invokeFileRead(Pointer handle, ByteBuffer buffer, int sizebytes, IntBuffer bytesread, Pointer userdata) {
		if(pointer == 0) throw new NullPointerException();

		if(buffer != null && !buffer.isDirect()) {
			throw new NonDirectBufferException();
		}
		if(bytesread != null && !bytesread.isDirect()) {
			throw new NonDirectBufferException();
		}
		int javaResult = StructureJNI.FMOD_CODEC_STATE_invoke_fileread(pointer, Pointer.getPointer(handle), buffer, BufferUtils.getPositionInBytes(buffer), sizebytes, bytesread, BufferUtils.getPositionInBytes(bytesread), Pointer.getPointer(userdata));
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * Invoke an internal FMOD callback.<BR>
	 * Don't use this for user callbacks (callback created from Java).<BR>
	 * <BR>
	 * For an example of its use, look at CodecRaw esxample.
	 */
	public FMOD_RESULT invokeFileSeek(Pointer handle, int pos, Pointer userdata) {
		if(pointer == 0) throw new NullPointerException();

		int javaResult = StructureJNI.FMOD_CODEC_STATE_invoke_fileseek(pointer, Pointer.getPointer(handle), pos, Pointer.getPointer(userdata));
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * Invoke an internal FMOD callback.<BR>
	 * Don't use this for user callbacks (callback created from Java).<BR>
	 * <BR>
	 * For an example of its use, look at CodecRaw esxample.
	 */
	public FMOD_RESULT invokeMetadata(FMOD_CODEC_STATE codec_state, FMOD_TAGTYPE tagtype, String name, Pointer data, int datalen, FMOD_TAGDATATYPE datatype, int unique) {
		if(pointer == 0) throw new NullPointerException();

		int javaResult = StructureJNI.FMOD_CODEC_STATE_invoke_metadata(pointer, Pointer.getPointer(codec_state), tagtype.asInt(), name == null ? null : name.getBytes(), Pointer.getPointer(data), datalen, datatype.asInt(), unique);
		return FMOD_RESULT.get(javaResult);
	}

}
