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

public class FMOD_CODEC_WAVEFORMAT extends Pointer {
	/**
	 * Create a view of the <code>Pointer</code> object as a <code>FMOD_CODEC_WAVEFORMAT</code> object.<br>
	 * This view is valid only if the memory holded by the <code>Pointer</code> holds a FMOD_CODEC_WAVEFORMAT object.
	 */
	public static FMOD_CODEC_WAVEFORMAT asFMOD_CODEC_WAVEFORMAT(Pointer pointer) {
		long address = Pointer.getPointer(pointer);
		if(address == 0) return null;
		return new FMOD_CODEC_WAVEFORMAT(address);
	}
	/**
	 * Allocate a new <code>FMOD_CODEC_WAVEFORMAT</code>.<br>
	 * The call <code>isNull()</code> on the object created will return false.<br>
	 * <pre><code>  FMOD_CODEC_WAVEFORMAT obj = FMOD_CODEC_WAVEFORMAT.allocate();
	 *  (obj == null) <=> obj.isNull() <=> false
	 * </code></pre>
	 */
	public static FMOD_CODEC_WAVEFORMAT allocate() {
		final long pointer = StructureJNI.FMOD_CODEC_WAVEFORMAT_new();
		if(pointer == 0) throw new OutOfMemoryError();
		return new FMOD_CODEC_WAVEFORMAT(pointer);
	}

	protected FMOD_CODEC_WAVEFORMAT(long pointer) {
		super(pointer);
	}

	/**
	 * Create an object that holds a null <code>FMOD_CODEC_WAVEFORMAT</code>.<br>
	 * The call <code>isNull()</code> on the object created will returns true.<br>
	 * <pre><code>  FMOD_CODEC_WAVEFORMAT obj = new FMOD_CODEC_WAVEFORMAT();
	 *  (obj == null) <=> false
	 *  obj.isNull() <=> true
	 * </code></pre>
	 * To creates a new <code>FMOD_CODEC_WAVEFORMAT</code>, use the static "constructor" :
	 * <pre><code>  FMOD_CODEC_WAVEFORMAT obj = FMOD_CODEC_WAVEFORMAT.allocate();</code></pre>
	 * @see FMOD_CODEC_WAVEFORMAT#allocate()
	 */
	public FMOD_CODEC_WAVEFORMAT() {
		super();
	}

	public void release() {
		if(pointer != 0) {
			StructureJNI.FMOD_CODEC_WAVEFORMAT_delete(pointer);
		}
		pointer = 0;
	}

	/**
	 * [in] Name of sound.
	 */
	public CharBuffer getName() {
		if(pointer == 0) throw new NullPointerException();
		ByteBuffer javaResult = StructureJNI.FMOD_CODEC_WAVEFORMAT_get_name(pointer);
		if(javaResult == null) { return null; }
		javaResult.order(ByteOrder.nativeOrder());
		return javaResult.asCharBuffer();
	}
	/**
	 * [in] Name of sound.
	 */
	public void setName(String name) {
		if(pointer == 0) throw new NullPointerException();
		if((name != null) && (name.length() > 256)) {
			throw new IndexOutOfBoundsException();
		}
		StructureJNI.FMOD_CODEC_WAVEFORMAT_set_name(pointer, name == null ? null : name.getBytes());
	}

	/**
	 * [in] Format for (decompressed) codec output, ie FMOD_SOUND_FORMAT_PCM8, FMOD_SOUND_FORMAT_PCM16.
	 */
	public FMOD_SOUND_FORMAT getFormat() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_CODEC_WAVEFORMAT_get_format(pointer);
		return FMOD_SOUND_FORMAT.get(javaResult);
	}
	/**
	 * [in] Format for (decompressed) codec output, ie FMOD_SOUND_FORMAT_PCM8, FMOD_SOUND_FORMAT_PCM16.
	 */
	public void setFormat(FMOD_SOUND_FORMAT format) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_CODEC_WAVEFORMAT_set_format(pointer, format.asInt());
	}

	/**
	 * [in] Number of channels used by codec, ie mono = 1, stereo = 2.
	 */
	public int getChannels() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_CODEC_WAVEFORMAT_get_channels(pointer);
		return javaResult;
	}
	/**
	 * [in] Number of channels used by codec, ie mono = 1, stereo = 2.
	 */
	public void setChannels(int channels) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_CODEC_WAVEFORMAT_set_channels(pointer, channels);
	}

	/**
	 * [in] Default frequency in hz of the codec, ie 44100.
	 */
	public int getFrequency() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_CODEC_WAVEFORMAT_get_frequency(pointer);
		return javaResult;
	}
	/**
	 * [in] Default frequency in hz of the codec, ie 44100.
	 */
	public void setFrequency(int frequency) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_CODEC_WAVEFORMAT_set_frequency(pointer, frequency);
	}

	/**
	 * [in] Length in bytes of the source data.
	 */
	public int getLengthBytes() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_CODEC_WAVEFORMAT_get_lengthbytes(pointer);
		return javaResult;
	}
	/**
	 * [in] Length in bytes of the source data.
	 */
	public void setLengthBytes(int lengthBytes) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_CODEC_WAVEFORMAT_set_lengthbytes(pointer, lengthBytes);
	}

	/**
	 * [in] Length in decompressed, PCM samples of the file, ie length in seconds * frequency.  Used for Sound::getLength and for memory allocation of static decompressed sample data.
	 */
	public int getLengthPCM() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_CODEC_WAVEFORMAT_get_lengthpcm(pointer);
		return javaResult;
	}
	/**
	 * [in] Length in decompressed, PCM samples of the file, ie length in seconds * frequency.  Used for Sound::getLength and for memory allocation of static decompressed sample data.
	 */
	public void setLengthPCM(int lengthPCM) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_CODEC_WAVEFORMAT_set_lengthpcm(pointer, lengthPCM);
	}

	/**
	 * [in] Blockalign in decompressed, PCM samples of the optimal decode chunk size for this format.  The codec read callback will be called in multiples of this value.
	 */
	public int getBlockAlign() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_CODEC_WAVEFORMAT_get_blockalign(pointer);
		return javaResult;
	}
	/**
	 * [in] Blockalign in decompressed, PCM samples of the optimal decode chunk size for this format.  The codec read callback will be called in multiples of this value.
	 */
	public void setBlockAlign(int blockAlign) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_CODEC_WAVEFORMAT_set_blockalign(pointer, blockAlign);
	}

	/**
	 * [in] Loopstart in decompressed, PCM samples of file.
	 */
	public int getLoopStart() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_CODEC_WAVEFORMAT_get_loopstart(pointer);
		return javaResult;
	}
	/**
	 * [in] Loopstart in decompressed, PCM samples of file.
	 */
	public void setLoopStart(int loopStart) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_CODEC_WAVEFORMAT_set_loopstart(pointer, loopStart);
	}

	/**
	 * [in] Loopend in decompressed, PCM samples of file.
	 */
	public int getLoopEnd() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_CODEC_WAVEFORMAT_get_loopend(pointer);
		return javaResult;
	}
	/**
	 * [in] Loopend in decompressed, PCM samples of file.
	 */
	public void setLoopEnd(int loopEnd) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_CODEC_WAVEFORMAT_set_loopend(pointer, loopEnd);
	}

	/**
	 * [in] Mode to determine whether the sound should by default load as looping, non looping, 2d or 3d.
	 */
	public int getMode() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_CODEC_WAVEFORMAT_get_mode(pointer);
		return javaResult;
	}
	/**
	 * [in] Mode to determine whether the sound should by default load as looping, non looping, 2d or 3d.
	 */
	public void setMode(int mode) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_CODEC_WAVEFORMAT_set_mode(pointer, mode);
	}

	/**
	 * [in] Microsoft speaker channel mask, as defined for WAVEFORMATEXTENSIBLE and is found in ksmedia.h.  Leave at 0 to play in natural speaker order.
	 */
	public int getChannelMask() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_CODEC_WAVEFORMAT_get_channelmask(pointer);
		return javaResult;
	}
	/**
	 * [in] Microsoft speaker channel mask, as defined for WAVEFORMATEXTENSIBLE and is found in ksmedia.h.  Leave at 0 to play in natural speaker order.
	 */
	public void setChannelMask(int channelMask) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_CODEC_WAVEFORMAT_set_channelmask(pointer, channelMask);
	}

}
