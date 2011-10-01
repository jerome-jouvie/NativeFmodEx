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

public class FMOD_CODEC_DESCRIPTION extends Pointer {
	/**
	 * Create a view of the <code>Pointer</code> object as a <code>FMOD_CODEC_DESCRIPTION</code> object.<br>
	 * This view is valid only if the memory holded by the <code>Pointer</code> holds a FMOD_CODEC_DESCRIPTION object.
	 */
	public static FMOD_CODEC_DESCRIPTION asFMOD_CODEC_DESCRIPTION(Pointer pointer) {
		long address = Pointer.getPointer(pointer);
		if(address == 0) return null;
		return new FMOD_CODEC_DESCRIPTION(address);
	}
	/**
	 * Allocate a new <code>FMOD_CODEC_DESCRIPTION</code>.<br>
	 * The call <code>isNull()</code> on the object created will return false.<br>
	 * <pre><code>  FMOD_CODEC_DESCRIPTION obj = FMOD_CODEC_DESCRIPTION.allocate();
	 *  (obj == null) <=> obj.isNull() <=> false
	 * </code></pre>
	 */
	public static FMOD_CODEC_DESCRIPTION allocate() {
		final long pointer = StructureJNI.FMOD_CODEC_DESCRIPTION_new();
		if(pointer == 0) throw new OutOfMemoryError();
		return new FMOD_CODEC_DESCRIPTION(pointer);
	}

	protected FMOD_CODEC_DESCRIPTION(long pointer) {
		super(pointer);
	}

	/**
	 * Create an object that holds a null <code>FMOD_CODEC_DESCRIPTION</code>.<br>
	 * The call <code>isNull()</code> on the object created will returns true.<br>
	 * <pre><code>  FMOD_CODEC_DESCRIPTION obj = new FMOD_CODEC_DESCRIPTION();
	 *  (obj == null) <=> false
	 *  obj.isNull() <=> true
	 * </code></pre>
	 * To creates a new <code>FMOD_CODEC_DESCRIPTION</code>, use the static "constructor" :
	 * <pre><code>  FMOD_CODEC_DESCRIPTION obj = FMOD_CODEC_DESCRIPTION.allocate();</code></pre>
	 * @see FMOD_CODEC_DESCRIPTION#allocate()
	 */
	public FMOD_CODEC_DESCRIPTION() {
		super();
	}

	public void release() {
		if(pointer != 0) {
			CallbackManager.addCallback(7, null, pointer);
			CallbackManager.addCallback(2, null, pointer);
			CallbackManager.addCallback(8, null, pointer);
			CallbackManager.addCallback(3, null, pointer);
			CallbackManager.addCallback(9, null, pointer);
			CallbackManager.addCallback(4, null, pointer);
			CallbackManager.addCallback(10, null, pointer);
			CallbackManager.addCallback(5, null, pointer);
			CallbackManager.addOwner(0, pointer);
			StructureJNI.FMOD_CODEC_DESCRIPTION_delete(pointer);
		}
		pointer = 0;
	}

	/**
	 * [in] Name of the codec.
	 */
	public String getName() {
		if(pointer == 0) throw new NullPointerException();
		String javaResult = StructureJNI.FMOD_CODEC_DESCRIPTION_get_name(pointer);
		return javaResult;
	}
	/**
	 * [in] Name of the codec.
	 */
	public void setName(String name) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_CODEC_DESCRIPTION_set_name(pointer, name == null ? null : name.getBytes());
	}

	/**
	 * [in] Plugin writer's version number.
	 */
	public int getVersion() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_CODEC_DESCRIPTION_get_version(pointer);
		return javaResult;
	}
	/**
	 * [in] Plugin writer's version number.
	 */
	public void setVersion(int version) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_CODEC_DESCRIPTION_set_version(pointer, version);
	}

	/**
	 * [in] Tells FMOD to open the file as a stream when calling System::createSound, and not a static sample.  Should normally be 0 (FALSE), because generally the user wants to decode the file into memory when using System::createSound.   Mainly used for formats that decode for a very long time, or could use large amounts of memory when decoded.  Usually sequenced formats such as mod/s3m/xm/it/midi fall into this category.   It is mainly to stop users that don't know what they're doing from getting FMOD_ERR_MEMORY returned from createSound when they should have in fact called System::createStream or used FMOD_CREATESTREAM in System::createSound.
	 */
	public int getDefaultAsStream() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_CODEC_DESCRIPTION_get_defaultasstream(pointer);
		return javaResult;
	}
	/**
	 * [in] Tells FMOD to open the file as a stream when calling System::createSound, and not a static sample.  Should normally be 0 (FALSE), because generally the user wants to decode the file into memory when using System::createSound.   Mainly used for formats that decode for a very long time, or could use large amounts of memory when decoded.  Usually sequenced formats such as mod/s3m/xm/it/midi fall into this category.   It is mainly to stop users that don't know what they're doing from getting FMOD_ERR_MEMORY returned from createSound when they should have in fact called System::createStream or used FMOD_CREATESTREAM in System::createSound.
	 */
	public void setDefaultAsStream(int defaultAsStream) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_CODEC_DESCRIPTION_set_defaultasstream(pointer, defaultAsStream);
	}

	/**
	 * [in] When setposition codec is called, only these time formats will be passed to the codec. Use bitwise OR to accumulate different types.
	 */
	public int getTimeUnits() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_CODEC_DESCRIPTION_get_timeunits(pointer);
		return javaResult;
	}
	/**
	 * [in] When setposition codec is called, only these time formats will be passed to the codec. Use bitwise OR to accumulate different types.
	 */
	public void setTimeUnits(int timeUnits) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_CODEC_DESCRIPTION_set_timeunits(pointer, timeUnits);
	}

	/**
	 * [in] Open callback for the codec for when FMOD tries to open a sound using this codec.
	 */
	public FMOD_CODEC_OPENCALLBACK getOpen() {
		if(pointer == 0) throw new NullPointerException();
		return (FMOD_CODEC_OPENCALLBACK)CallbackManager.getCallback(7, pointer, false);
	}
	/**
	 * [in] Open callback for the codec for when FMOD tries to open a sound using this codec.
	 */
	public void setOpen(FMOD_CODEC_OPENCALLBACK open) {
		if(pointer == 0) throw new NullPointerException();
		CallbackManager.addCallback(7, open, pointer);
		StructureJNI.FMOD_CODEC_DESCRIPTION_set_open(pointer, open != null);
	}

	/**
	 * [in] Close callback for the codec for when FMOD tries to close a sound using this codec.
	 */
	public FMOD_CODEC_CLOSECALLBACK getClose() {
		if(pointer == 0) throw new NullPointerException();
		return (FMOD_CODEC_CLOSECALLBACK)CallbackManager.getCallback(2, pointer, false);
	}
	/**
	 * [in] Close callback for the codec for when FMOD tries to close a sound using this codec.
	 */
	public void setClose(FMOD_CODEC_CLOSECALLBACK close) {
		if(pointer == 0) throw new NullPointerException();
		CallbackManager.addCallback(2, close, pointer);
		StructureJNI.FMOD_CODEC_DESCRIPTION_set_close(pointer, close != null);
	}

	/**
	 * [in] Read callback for the codec for when FMOD tries to read some data from the file to the destination format (specified in the open callback).
	 */
	public FMOD_CODEC_READCALLBACK getRead() {
		if(pointer == 0) throw new NullPointerException();
		return (FMOD_CODEC_READCALLBACK)CallbackManager.getCallback(8, pointer, false);
	}
	/**
	 * [in] Read callback for the codec for when FMOD tries to read some data from the file to the destination format (specified in the open callback).
	 */
	public void setRead(FMOD_CODEC_READCALLBACK read) {
		if(pointer == 0) throw new NullPointerException();
		CallbackManager.addCallback(8, read, pointer);
		StructureJNI.FMOD_CODEC_DESCRIPTION_set_read(pointer, read != null);
	}

	/**
	 * [in] Callback to return the length of the song in whatever format required when Sound::getLength is called.
	 */
	public FMOD_CODEC_GETLENGTHCALLBACK getGetLength() {
		if(pointer == 0) throw new NullPointerException();
		return (FMOD_CODEC_GETLENGTHCALLBACK)CallbackManager.getCallback(3, pointer, false);
	}
	/**
	 * [in] Callback to return the length of the song in whatever format required when Sound::getLength is called.
	 */
	public void setGetLength(FMOD_CODEC_GETLENGTHCALLBACK getLength) {
		if(pointer == 0) throw new NullPointerException();
		CallbackManager.addCallback(3, getLength, pointer);
		StructureJNI.FMOD_CODEC_DESCRIPTION_set_getlength(pointer, getLength != null);
	}

	/**
	 * [in] Seek callback for the codec for when FMOD tries to seek within the file with Channel::setPosition.
	 */
	public FMOD_CODEC_SETPOSITIONCALLBACK getSetPosition() {
		if(pointer == 0) throw new NullPointerException();
		return (FMOD_CODEC_SETPOSITIONCALLBACK)CallbackManager.getCallback(9, pointer, false);
	}
	/**
	 * [in] Seek callback for the codec for when FMOD tries to seek within the file with Channel::setPosition.
	 */
	public void setSetPosition(FMOD_CODEC_SETPOSITIONCALLBACK setPosition) {
		if(pointer == 0) throw new NullPointerException();
		CallbackManager.addCallback(9, setPosition, pointer);
		StructureJNI.FMOD_CODEC_DESCRIPTION_set_setposition(pointer, setPosition != null);
	}

	/**
	 * [in] Tell callback for the codec for when FMOD tries to get the current position within the with Channel::getPosition.
	 */
	public FMOD_CODEC_GETPOSITIONCALLBACK getGetPosition() {
		if(pointer == 0) throw new NullPointerException();
		return (FMOD_CODEC_GETPOSITIONCALLBACK)CallbackManager.getCallback(4, pointer, false);
	}
	/**
	 * [in] Tell callback for the codec for when FMOD tries to get the current position within the with Channel::getPosition.
	 */
	public void setGetPosition(FMOD_CODEC_GETPOSITIONCALLBACK getPosition) {
		if(pointer == 0) throw new NullPointerException();
		CallbackManager.addCallback(4, getPosition, pointer);
		StructureJNI.FMOD_CODEC_DESCRIPTION_set_getposition(pointer, getPosition != null);
	}

	/**
	 * [in] Sound creation callback for the codec when FMOD finishes creating the sound.  (So the codec can set more parameters for the related created sound, ie loop points/mode or 3D attributes etc).
	 */
	public FMOD_CODEC_SOUNDCREATECALLBACK getSoundCreate() {
		if(pointer == 0) throw new NullPointerException();
		return (FMOD_CODEC_SOUNDCREATECALLBACK)CallbackManager.getCallback(10, pointer, false);
	}
	/**
	 * [in] Sound creation callback for the codec when FMOD finishes creating the sound.  (So the codec can set more parameters for the related created sound, ie loop points/mode or 3D attributes etc).
	 */
	public void setSoundCreate(FMOD_CODEC_SOUNDCREATECALLBACK soundCreate) {
		if(pointer == 0) throw new NullPointerException();
		CallbackManager.addCallback(10, soundCreate, pointer);
		StructureJNI.FMOD_CODEC_DESCRIPTION_set_soundcreate(pointer, soundCreate != null);
	}

	/**
	 * [in] Callback to tell FMOD about the waveformat of a particular subsound.  This is to save memory, rather than saving 1000 FMOD_CODEC_WAVEFORMAT structures in the codec, the codec might have a more optimal way of storing this information.
	 */
	public FMOD_CODEC_GETWAVEFORMAT getGetWaveFormat() {
		if(pointer == 0) throw new NullPointerException();
		return (FMOD_CODEC_GETWAVEFORMAT)CallbackManager.getCallback(5, pointer, false);
	}
	/**
	 * [in] Callback to tell FMOD about the waveformat of a particular subsound.  This is to save memory, rather than saving 1000 FMOD_CODEC_WAVEFORMAT structures in the codec, the codec might have a more optimal way of storing this information.
	 */
	public void setGetWaveFormat(FMOD_CODEC_GETWAVEFORMAT getWaveFormat) {
		if(pointer == 0) throw new NullPointerException();
		CallbackManager.addCallback(5, getWaveFormat, pointer);
		StructureJNI.FMOD_CODEC_DESCRIPTION_set_getwaveformat(pointer, getWaveFormat != null);
	}

}
