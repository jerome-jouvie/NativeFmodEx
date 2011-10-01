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

public class FMOD_CREATESOUNDEXINFO extends Pointer {
	/**
	 * Create a view of the <code>Pointer</code> object as a <code>FMOD_CREATESOUNDEXINFO</code> object.<br>
	 * This view is valid only if the memory holded by the <code>Pointer</code> holds a FMOD_CREATESOUNDEXINFO object.
	 */
	public static FMOD_CREATESOUNDEXINFO asFMOD_CREATESOUNDEXINFO(Pointer pointer) {
		long address = Pointer.getPointer(pointer);
		if(address == 0) return null;
		return new FMOD_CREATESOUNDEXINFO(address);
	}
	/**
	 * Allocate a new <code>FMOD_CREATESOUNDEXINFO</code>.<br>
	 * The call <code>isNull()</code> on the object created will return false.<br>
	 * <pre><code>  FMOD_CREATESOUNDEXINFO obj = FMOD_CREATESOUNDEXINFO.allocate();
	 *  (obj == null) <=> obj.isNull() <=> false
	 * </code></pre>
	 */
	public static FMOD_CREATESOUNDEXINFO allocate() {
		final long pointer = StructureJNI.FMOD_CREATESOUNDEXINFO_new();
		if(pointer == 0) throw new OutOfMemoryError();
		return new FMOD_CREATESOUNDEXINFO(pointer);
	}

	protected FMOD_CREATESOUNDEXINFO(long pointer) {
		super(pointer);
	}

	/**
	 * Create an object that holds a null <code>FMOD_CREATESOUNDEXINFO</code>.<br>
	 * The call <code>isNull()</code> on the object created will returns true.<br>
	 * <pre><code>  FMOD_CREATESOUNDEXINFO obj = new FMOD_CREATESOUNDEXINFO();
	 *  (obj == null) <=> false
	 *  obj.isNull() <=> true
	 * </code></pre>
	 * To creates a new <code>FMOD_CREATESOUNDEXINFO</code>, use the static "constructor" :
	 * <pre><code>  FMOD_CREATESOUNDEXINFO obj = FMOD_CREATESOUNDEXINFO.allocate();</code></pre>
	 * @see FMOD_CREATESOUNDEXINFO#allocate()
	 */
	public FMOD_CREATESOUNDEXINFO() {
		super();
	}

	public void release() {
		if(pointer != 0) {
			CallbackManager.addCallback(29, null, pointer);
			CallbackManager.addCallback(30, null, pointer);
			CallbackManager.addCallback(28, null, pointer);
			CallbackManager.addCallback(22, null, pointer);
			CallbackManager.addCallback(21, null, pointer);
			CallbackManager.addCallback(23, null, pointer);
			CallbackManager.addCallback(24, null, pointer);
			CallbackManager.addCallback(20, null, pointer);
			CallbackManager.addCallback(19, null, pointer);
			CallbackManager.addOwner(0, pointer);
			StructureJNI.FMOD_CREATESOUNDEXINFO_delete(pointer);
		}
		pointer = 0;
	}

	/**
	 * [w] Size of this structure.  This is used so the structure can be expanded in the future and still work on older versions of FMOD Ex.
	 */
	public int getCbSize() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_CREATESOUNDEXINFO_get_cbsize(pointer);
		return javaResult;
	}

	/**
	 * [w] Optional. Specify 0 to ignore. Size in bytes of file to load, or sound to create (in this case only if FMOD_OPENUSER is used).  Required if loading from memory.  If 0 is specified, then it will use the size of the file (unless loading from memory then an error will be returned).
	 */
	public int getLength() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_CREATESOUNDEXINFO_get_length(pointer);
		return javaResult;
	}
	/**
	 * [w] Optional. Specify 0 to ignore. Size in bytes of file to load, or sound to create (in this case only if FMOD_OPENUSER is used).  Required if loading from memory.  If 0 is specified, then it will use the size of the file (unless loading from memory then an error will be returned).
	 */
	public void setLength(int length) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_CREATESOUNDEXINFO_set_length(pointer, length);
	}

	/**
	 * [w] Optional. Specify 0 to ignore. Offset from start of the file to start loading from.  This is useful for loading files from inside big data files.
	 */
	public int getFileOffset() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_CREATESOUNDEXINFO_get_fileoffset(pointer);
		return javaResult;
	}
	/**
	 * [w] Optional. Specify 0 to ignore. Offset from start of the file to start loading from.  This is useful for loading files from inside big data files.
	 */
	public void setFileOffset(int fileOffset) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_CREATESOUNDEXINFO_set_fileoffset(pointer, fileOffset);
	}

	/**
	 * [w] Optional. Specify 0 to ignore. Number of channels in a sound mandatory if FMOD_OPENUSER or FMOD_OPENRAW is used.
	 */
	public int getNumChannels() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_CREATESOUNDEXINFO_get_numchannels(pointer);
		return javaResult;
	}
	/**
	 * [w] Optional. Specify 0 to ignore. Number of channels in a sound mandatory if FMOD_OPENUSER or FMOD_OPENRAW is used.
	 */
	public void setNumChannels(int numChannels) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_CREATESOUNDEXINFO_set_numchannels(pointer, numChannels);
	}

	/**
	 * [w] Optional. Specify 0 to ignore. Default frequency of sound in a sound mandatory if FMOD_OPENUSER or FMOD_OPENRAW is used.  Other formats use the frequency determined by the file format.
	 */
	public int getDefaultFrequency() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_CREATESOUNDEXINFO_get_defaultfrequency(pointer);
		return javaResult;
	}
	/**
	 * [w] Optional. Specify 0 to ignore. Default frequency of sound in a sound mandatory if FMOD_OPENUSER or FMOD_OPENRAW is used.  Other formats use the frequency determined by the file format.
	 */
	public void setDefaultFrequency(int defaultFrequency) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_CREATESOUNDEXINFO_set_defaultfrequency(pointer, defaultFrequency);
	}

	/**
	 * [w] Optional. Specify 0 or FMOD_SOUND_FORMAT_NONE to ignore. Format of the sound mandatory if FMOD_OPENUSER or FMOD_OPENRAW is used.  Other formats use the format determined by the file format.
	 */
	public FMOD_SOUND_FORMAT getFormat() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_CREATESOUNDEXINFO_get_format(pointer);
		return FMOD_SOUND_FORMAT.get(javaResult);
	}
	/**
	 * [w] Optional. Specify 0 or FMOD_SOUND_FORMAT_NONE to ignore. Format of the sound mandatory if FMOD_OPENUSER or FMOD_OPENRAW is used.  Other formats use the format determined by the file format.
	 */
	public void setFormat(FMOD_SOUND_FORMAT format) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_CREATESOUNDEXINFO_set_format(pointer, format.asInt());
	}

	/**
	 * [w] Optional. Specify 0 to ignore. For streams.  This determines the size of the double buffer (in PCM samples) that a stream uses.  Use this for user created streams if you want to determine the size of the callback buffer passed to you.  Specify 0 to use FMOD's default size which is currently equivalent to 400ms of the sound format created/loaded.
	 */
	public int getDecodeBufferSize() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_CREATESOUNDEXINFO_get_decodebuffersize(pointer);
		return javaResult;
	}
	/**
	 * [w] Optional. Specify 0 to ignore. For streams.  This determines the size of the double buffer (in PCM samples) that a stream uses.  Use this for user created streams if you want to determine the size of the callback buffer passed to you.  Specify 0 to use FMOD's default size which is currently equivalent to 400ms of the sound format created/loaded.
	 */
	public void setDecodeBufferSize(int decodeBufferSize) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_CREATESOUNDEXINFO_set_decodebuffersize(pointer, decodeBufferSize);
	}

	/**
	 * [w] Optional. Specify 0 to ignore. In a multi-sample file format such as .FSB/.DLS/.SF2, specify the initial subsound to seek to, only if FMOD_CREATESTREAM is used.
	 */
	public int getInitialSubsound() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_CREATESOUNDEXINFO_get_initialsubsound(pointer);
		return javaResult;
	}
	/**
	 * [w] Optional. Specify 0 to ignore. In a multi-sample file format such as .FSB/.DLS/.SF2, specify the initial subsound to seek to, only if FMOD_CREATESTREAM is used.
	 */
	public void setInitialSubsound(int initialSubsound) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_CREATESOUNDEXINFO_set_initialsubsound(pointer, initialSubsound);
	}

	/**
	 * [w] Optional. Specify 0 to ignore or have no subsounds.  In a sound created with FMOD_OPENUSER, specify the number of subsounds that are accessable with Sound::getSubSound.  If not created with FMOD_OPENUSER, this will limit the number of subsounds loaded within a multi-subsound file.  If using FSB, then if FMOD_CREATESOUNDEXINFO::inclusionlist is used, this will shuffle subsounds down so that there are not any gaps.  It will mean that the indices of the sounds will be different.
	 */
	public int getNumSubsounds() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_CREATESOUNDEXINFO_get_numsubsounds(pointer);
		return javaResult;
	}
	/**
	 * [w] Optional. Specify 0 to ignore or have no subsounds.  In a sound created with FMOD_OPENUSER, specify the number of subsounds that are accessable with Sound::getSubSound.  If not created with FMOD_OPENUSER, this will limit the number of subsounds loaded within a multi-subsound file.  If using FSB, then if FMOD_CREATESOUNDEXINFO::inclusionlist is used, this will shuffle subsounds down so that there are not any gaps.  It will mean that the indices of the sounds will be different.
	 */
	public void setNumSubsounds(int numSubsounds) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_CREATESOUNDEXINFO_set_numsubsounds(pointer, numSubsounds);
	}

	/**
	 * [w] Optional. Specify 0 to ignore. In a multi-sample format such as .FSB/.DLS/.SF2 it may be desirable to specify only a subset of sounds to be loaded out of the whole file.  This is an array of subsound indices to load into memory when created.
	 */
	public IntBuffer getInclusionList() {
		if(pointer == 0) throw new NullPointerException();
		ByteBuffer javaResult = StructureJNI.FMOD_CREATESOUNDEXINFO_get_inclusionlist(pointer);
		if(javaResult == null) { return null; }
		javaResult.order(ByteOrder.nativeOrder());
		return javaResult.asIntBuffer();
	}
	/**
	 * [w] Optional. Specify 0 to ignore. In a multi-sample format such as .FSB/.DLS/.SF2 it may be desirable to specify only a subset of sounds to be loaded out of the whole file.  This is an array of subsound indices to load into memory when created.
	 */
	public void setInclusionList(IntBuffer inclusionList) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_CREATESOUNDEXINFO_set_inclusionlist(pointer, inclusionList, BufferUtils.getPositionInBytes(inclusionList));
	}

	/**
	 * [w] Optional. Specify 0 to ignore. This is the number of integers contained within the inclusionlist array.
	 */
	public int getInclusionListNum() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_CREATESOUNDEXINFO_get_inclusionlistnum(pointer);
		return javaResult;
	}

	/**
	 * [w] Optional. Specify 0 to ignore. Callback to 'piggyback' on FMOD's read functions and accept or even write PCM data while FMOD is opening the sound.  Used for user sounds created with FMOD_OPENUSER or for capturing decoded data as FMOD reads it.
	 */
	public FMOD_SOUND_PCMREADCALLBACK getPcmReadCallback() {
		if(pointer == 0) throw new NullPointerException();
		return (FMOD_SOUND_PCMREADCALLBACK)CallbackManager.getCallback(29, pointer, false);
	}
	/**
	 * [w] Optional. Specify 0 to ignore. Callback to 'piggyback' on FMOD's read functions and accept or even write PCM data while FMOD is opening the sound.  Used for user sounds created with FMOD_OPENUSER or for capturing decoded data as FMOD reads it.
	 */
	public void setPcmReadCallback(FMOD_SOUND_PCMREADCALLBACK pcmReadCallback) {
		if(pointer == 0) throw new NullPointerException();
		CallbackManager.addCallback(29, pcmReadCallback, pointer);
		StructureJNI.FMOD_CREATESOUNDEXINFO_set_pcmreadcallback(pointer, pcmReadCallback != null);
	}

	/**
	 * [w] Optional. Specify 0 to ignore. Callback for when the user calls a seeking function such as Channel::setTime or Channel::setPosition within a multi-sample sound, and for when it is opened.
	 */
	public FMOD_SOUND_PCMSETPOSCALLBACK getPcmSetPosCallback() {
		if(pointer == 0) throw new NullPointerException();
		return (FMOD_SOUND_PCMSETPOSCALLBACK)CallbackManager.getCallback(30, pointer, false);
	}
	/**
	 * [w] Optional. Specify 0 to ignore. Callback for when the user calls a seeking function such as Channel::setTime or Channel::setPosition within a multi-sample sound, and for when it is opened.
	 */
	public void setPcmSetPosCallback(FMOD_SOUND_PCMSETPOSCALLBACK pcmSetPosCallback) {
		if(pointer == 0) throw new NullPointerException();
		CallbackManager.addCallback(30, pcmSetPosCallback, pointer);
		StructureJNI.FMOD_CREATESOUNDEXINFO_set_pcmsetposcallback(pointer, pcmSetPosCallback != null);
	}

	/**
	 * [w] Optional. Specify 0 to ignore. Callback for successful completion, or error while loading a sound that used the FMOD_NONBLOCKING flag.
	 */
	public FMOD_SOUND_NONBLOCKCALLBACK getNonBlockCallback() {
		if(pointer == 0) throw new NullPointerException();
		return (FMOD_SOUND_NONBLOCKCALLBACK)CallbackManager.getCallback(28, pointer, false);
	}
	/**
	 * [w] Optional. Specify 0 to ignore. Callback for successful completion, or error while loading a sound that used the FMOD_NONBLOCKING flag.
	 */
	public void setNonBlockCallback(FMOD_SOUND_NONBLOCKCALLBACK nonBlockCallback) {
		if(pointer == 0) throw new NullPointerException();
		CallbackManager.addCallback(28, nonBlockCallback, pointer);
		StructureJNI.FMOD_CREATESOUNDEXINFO_set_nonblockcallback(pointer, nonBlockCallback != null);
	}

	/**
	 * [w] Optional. Specify 0 to ignore. Filename for a DLS or SF2 sample set when loading a MIDI file. If not specified, on Windows it will attempt to open /windows/system32/drivers/gm.dls or /windows/system32/drivers/etc/gm.dls, on Mac it will attempt to load /System/Library/Components/CoreAudio.component/Contents/Resources/gs_instruments.dls, otherwise the MIDI will fail to open. Current DLS support is for level 1 of the specification.
	 */
	public String getDlsName() {
		if(pointer == 0) throw new NullPointerException();
		String javaResult = StructureJNI.FMOD_CREATESOUNDEXINFO_get_dlsname(pointer);
		return javaResult;
	}
	/**
	 * [w] Optional. Specify 0 to ignore. Filename for a DLS or SF2 sample set when loading a MIDI file. If not specified, on Windows it will attempt to open /windows/system32/drivers/gm.dls or /windows/system32/drivers/etc/gm.dls, on Mac it will attempt to load /System/Library/Components/CoreAudio.component/Contents/Resources/gs_instruments.dls, otherwise the MIDI will fail to open. Current DLS support is for level 1 of the specification.
	 */
	public void setDlsName(String dlsName) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_CREATESOUNDEXINFO_set_dlsname(pointer, dlsName == null ? null : dlsName.getBytes());
	}

	/**
	 * [w] Optional. Specify 0 to ignore. Key for encrypted FSB file.  Without this key an encrypted FSB file will not load.
	 */
	public String getEncryptionKey() {
		if(pointer == 0) throw new NullPointerException();
		String javaResult = StructureJNI.FMOD_CREATESOUNDEXINFO_get_encryptionkey(pointer);
		return javaResult;
	}
	/**
	 * [w] Optional. Specify 0 to ignore. Key for encrypted FSB file.  Without this key an encrypted FSB file will not load.
	 */
	public void setEncryptionKey(String encryptionKey) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_CREATESOUNDEXINFO_set_encryptionkey(pointer, encryptionKey == null ? null : encryptionKey.getBytes());
	}

	/**
	 * [w] Optional. Specify 0 to ignore. For sequenced formats with dynamic channel allocation such as .MID and .IT, this specifies the maximum voice count allowed while playing.  .IT defaults to 64.  .MID defaults to 32.
	 */
	public int getMaxPolyphony() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_CREATESOUNDEXINFO_get_maxpolyphony(pointer);
		return javaResult;
	}
	/**
	 * [w] Optional. Specify 0 to ignore. For sequenced formats with dynamic channel allocation such as .MID and .IT, this specifies the maximum voice count allowed while playing.  .IT defaults to 64.  .MID defaults to 32.
	 */
	public void setMaxPolyphony(int maxPolyphony) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_CREATESOUNDEXINFO_set_maxpolyphony(pointer, maxPolyphony);
	}

	/**
	 * [w] Optional. Specify 0 to ignore. This is user data to be attached to the sound during creation.  Access via Sound::getUserData.  Note: This is not passed to FMOD_FILE_OPENCALLBACK, that is a different userdata that is file specific.
	 */
	public Pointer getUserData() {
		if(pointer == 0) throw new NullPointerException();
		long javaResult = StructureJNI.FMOD_CREATESOUNDEXINFO_get_userdata(pointer);
		return javaResult == 0 ? null : Pointer.newPointer(javaResult);
	}
	/**
	 * [w] Optional. Specify 0 to ignore. This is user data to be attached to the sound during creation.  Access via Sound::getUserData.  Note: This is not passed to FMOD_FILE_OPENCALLBACK, that is a different userdata that is file specific.
	 */
	public void setUserData(Pointer userData) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_CREATESOUNDEXINFO_set_userdata(pointer, Pointer.getPointer(userData));
	}

	/**
	 * [w] Optional. Specify 0 or FMOD_SOUND_TYPE_UNKNOWN to ignore.  Instead of scanning all codec types, use this to speed up loading by making it jump straight to this codec.
	 */
	public FMOD_SOUND_TYPE getSuggestedSoundType() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_CREATESOUNDEXINFO_get_suggestedsoundtype(pointer);
		return FMOD_SOUND_TYPE.get(javaResult);
	}
	/**
	 * [w] Optional. Specify 0 or FMOD_SOUND_TYPE_UNKNOWN to ignore.  Instead of scanning all codec types, use this to speed up loading by making it jump straight to this codec.
	 */
	public void setSuggestedSoundType(FMOD_SOUND_TYPE suggestedSoundType) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_CREATESOUNDEXINFO_set_suggestedsoundtype(pointer, suggestedSoundType.asInt());
	}

	/**
	 * [w] Optional. Specify 0 to ignore. Callback for opening this file.
	 */
	public FMOD_FILE_OPENCALLBACK getUserOpen() {
		if(pointer == 0) throw new NullPointerException();
		return (FMOD_FILE_OPENCALLBACK)CallbackManager.getCallback(22, pointer, false);
	}
	/**
	 * [w] Optional. Specify 0 to ignore. Callback for opening this file.
	 */
	public void setUserOpen(FMOD_FILE_OPENCALLBACK userOpen) {
		if(pointer == 0) throw new NullPointerException();
		CallbackManager.addCallback(22, userOpen, pointer);
		StructureJNI.FMOD_CREATESOUNDEXINFO_set_useropen(pointer, userOpen != null);
	}

	/**
	 * [w] Optional. Specify 0 to ignore. Callback for closing this file.
	 */
	public FMOD_FILE_CLOSECALLBACK getUserClose() {
		if(pointer == 0) throw new NullPointerException();
		return (FMOD_FILE_CLOSECALLBACK)CallbackManager.getCallback(21, pointer, false);
	}
	/**
	 * [w] Optional. Specify 0 to ignore. Callback for closing this file.
	 */
	public void setUserClose(FMOD_FILE_CLOSECALLBACK userClose) {
		if(pointer == 0) throw new NullPointerException();
		CallbackManager.addCallback(21, userClose, pointer);
		StructureJNI.FMOD_CREATESOUNDEXINFO_set_userclose(pointer, userClose != null);
	}

	/**
	 * [w] Optional. Specify 0 to ignore. Callback for reading from this file.
	 */
	public FMOD_FILE_READCALLBACK getUserRead() {
		if(pointer == 0) throw new NullPointerException();
		return (FMOD_FILE_READCALLBACK)CallbackManager.getCallback(23, pointer, false);
	}
	/**
	 * [w] Optional. Specify 0 to ignore. Callback for reading from this file.
	 */
	public void setUserRead(FMOD_FILE_READCALLBACK userRead) {
		if(pointer == 0) throw new NullPointerException();
		CallbackManager.addCallback(23, userRead, pointer);
		StructureJNI.FMOD_CREATESOUNDEXINFO_set_userread(pointer, userRead != null);
	}

	/**
	 * [w] Optional. Specify 0 to ignore. Callback for seeking within this file.
	 */
	public FMOD_FILE_SEEKCALLBACK getUserSeek() {
		if(pointer == 0) throw new NullPointerException();
		return (FMOD_FILE_SEEKCALLBACK)CallbackManager.getCallback(24, pointer, false);
	}
	/**
	 * [w] Optional. Specify 0 to ignore. Callback for seeking within this file.
	 */
	public void setUserSeek(FMOD_FILE_SEEKCALLBACK userSeek) {
		if(pointer == 0) throw new NullPointerException();
		CallbackManager.addCallback(24, userSeek, pointer);
		StructureJNI.FMOD_CREATESOUNDEXINFO_set_userseek(pointer, userSeek != null);
	}

	/**
	 * [w] Optional. Specify 0 to ignore. Callback for seeking within this file.
	 */
	public FMOD_FILE_ASYNCREADCALLBACK getUserAsyncRead() {
		if(pointer == 0) throw new NullPointerException();
		return (FMOD_FILE_ASYNCREADCALLBACK)CallbackManager.getCallback(20, pointer, false);
	}
	/**
	 * [w] Optional. Specify 0 to ignore. Callback for seeking within this file.
	 */
	public void setUserAsyncRead(FMOD_FILE_ASYNCREADCALLBACK userAsyncRead) {
		if(pointer == 0) throw new NullPointerException();
		CallbackManager.addCallback(20, userAsyncRead, pointer);
		StructureJNI.FMOD_CREATESOUNDEXINFO_set_userasyncread(pointer, userAsyncRead != null);
	}

	/**
	 * [w] Optional. Specify 0 to ignore. Callback for seeking within this file.
	 */
	public FMOD_FILE_ASYNCCANCELCALLBACK getUserAsyncCancel() {
		if(pointer == 0) throw new NullPointerException();
		return (FMOD_FILE_ASYNCCANCELCALLBACK)CallbackManager.getCallback(19, pointer, false);
	}
	/**
	 * [w] Optional. Specify 0 to ignore. Callback for seeking within this file.
	 */
	public void setUserAsyncCancel(FMOD_FILE_ASYNCCANCELCALLBACK userAsyncCancel) {
		if(pointer == 0) throw new NullPointerException();
		CallbackManager.addCallback(19, userAsyncCancel, pointer);
		StructureJNI.FMOD_CREATESOUNDEXINFO_set_userasynccancel(pointer, userAsyncCancel != null);
	}

	/**
	 * [w] Optional. Specify 0 to ignore. Use this to differ the way fmod maps multichannel sounds to speakers.  See FMOD_SPEAKERMAPTYPE for more.
	 */
	public FMOD_SPEAKERMAPTYPE getSpeakerMap() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_CREATESOUNDEXINFO_get_speakermap(pointer);
		return FMOD_SPEAKERMAPTYPE.get(javaResult);
	}
	/**
	 * [w] Optional. Specify 0 to ignore. Use this to differ the way fmod maps multichannel sounds to speakers.  See FMOD_SPEAKERMAPTYPE for more.
	 */
	public void setSpeakerMap(FMOD_SPEAKERMAPTYPE speakerMap) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_CREATESOUNDEXINFO_set_speakermap(pointer, speakerMap.asInt());
	}

	/**
	 * [w] Optional. Specify 0 to ignore. Specify a sound group if required, to put sound in as it is created.
	 */
	public SoundGroup getInitialSoundGroup() {
		if(pointer == 0) throw new NullPointerException();
		long javaResult = StructureJNI.FMOD_CREATESOUNDEXINFO_get_initialsoundgroup(pointer);
		return javaResult == 0 ? null : SoundGroup.asSoundGroup(Pointer.newPointer(javaResult));
	}
	/**
	 * [w] Optional. Specify 0 to ignore. Specify a sound group if required, to put sound in as it is created.
	 */
	public void setInitialSoundGroup(SoundGroup initialSoundGroup) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_CREATESOUNDEXINFO_set_initialsoundgroup(pointer, Pointer.getPointer(initialSoundGroup));
	}

	/**
	 * [w] Optional. Specify 0 to ignore. For streams. Specify an initial position to seek the stream to.
	 */
	public int getInitialSeekPosition() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_CREATESOUNDEXINFO_get_initialseekposition(pointer);
		return javaResult;
	}
	/**
	 * [w] Optional. Specify 0 to ignore. For streams. Specify an initial position to seek the stream to.
	 */
	public void setInitialSeekPosition(int initialSeekPosition) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_CREATESOUNDEXINFO_set_initialseekposition(pointer, initialSeekPosition);
	}

	/**
	 * [w] Optional. Specify 0 to ignore. For streams. Specify the time unit for the position set in initialseekposition.
	 */
	public int getInitialSeekPosType() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_CREATESOUNDEXINFO_get_initialseekpostype(pointer);
		return javaResult;
	}
	/**
	 * [w] Optional. Specify 0 to ignore. For streams. Specify the time unit for the position set in initialseekposition.
	 */
	public void setInitialSeekPosType(int initialSeekPosType) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_CREATESOUNDEXINFO_set_initialseekpostype(pointer, initialSeekPosType);
	}

	/**
	 * [w] Optional. Specify 0 to ignore. Set to 1 to use fmod's built in file system. Ignores setFileSystem callbacks and also FMOD_CREATESOUNEXINFO file callbacks.  Useful for specific cases where you don't want to use your own file system but want to use fmod's file system (ie net streaming).
	 */
	public int getIgnoresetfilesystem() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_CREATESOUNDEXINFO_get_ignoresetfilesystem(pointer);
		return javaResult;
	}
	/**
	 * [w] Optional. Specify 0 to ignore. Set to 1 to use fmod's built in file system. Ignores setFileSystem callbacks and also FMOD_CREATESOUNEXINFO file callbacks.  Useful for specific cases where you don't want to use your own file system but want to use fmod's file system (ie net streaming).
	 */
	public void setIgnoresetfilesystem(int ignoresetfilesystem) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_CREATESOUNDEXINFO_set_ignoresetfilesystem(pointer, ignoresetfilesystem);
	}

}
