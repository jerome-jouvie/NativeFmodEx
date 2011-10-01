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

public class FMOD_ADVANCEDSETTINGS extends Pointer {
	/**
	 * Create a view of the <code>Pointer</code> object as a <code>FMOD_ADVANCEDSETTINGS</code> object.<br>
	 * This view is valid only if the memory holded by the <code>Pointer</code> holds a FMOD_ADVANCEDSETTINGS object.
	 */
	public static FMOD_ADVANCEDSETTINGS asFMOD_ADVANCEDSETTINGS(Pointer pointer) {
		long address = Pointer.getPointer(pointer);
		if(address == 0) return null;
		return new FMOD_ADVANCEDSETTINGS(address);
	}
	/**
	 * Allocate a new <code>FMOD_ADVANCEDSETTINGS</code>.<br>
	 * The call <code>isNull()</code> on the object created will return false.<br>
	 * <pre><code>  FMOD_ADVANCEDSETTINGS obj = FMOD_ADVANCEDSETTINGS.allocate();
	 *  (obj == null) <=> obj.isNull() <=> false
	 * </code></pre>
	 */
	public static FMOD_ADVANCEDSETTINGS allocate() {
		final long pointer = StructureJNI.FMOD_ADVANCEDSETTINGS_new();
		if(pointer == 0) throw new OutOfMemoryError();
		return new FMOD_ADVANCEDSETTINGS(pointer);
	}

	protected FMOD_ADVANCEDSETTINGS(long pointer) {
		super(pointer);
	}

	/**
	 * Create an object that holds a null <code>FMOD_ADVANCEDSETTINGS</code>.<br>
	 * The call <code>isNull()</code> on the object created will returns true.<br>
	 * <pre><code>  FMOD_ADVANCEDSETTINGS obj = new FMOD_ADVANCEDSETTINGS();
	 *  (obj == null) <=> false
	 *  obj.isNull() <=> true
	 * </code></pre>
	 * To creates a new <code>FMOD_ADVANCEDSETTINGS</code>, use the static "constructor" :
	 * <pre><code>  FMOD_ADVANCEDSETTINGS obj = FMOD_ADVANCEDSETTINGS.allocate();</code></pre>
	 * @see FMOD_ADVANCEDSETTINGS#allocate()
	 */
	public FMOD_ADVANCEDSETTINGS() {
		super();
	}

	public void release() {
		if(pointer != 0) {
			StructureJNI.FMOD_ADVANCEDSETTINGS_delete(pointer);
		}
		pointer = 0;
	}

	/**
	 * [w]   Size of this structure.  Use sizeof(FMOD_ADVANCEDSETTINGS)  NOTE: This must be set before calling System::getAdvancedSettings!
	 */
	public int getCbSize() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_ADVANCEDSETTINGS_get_cbsize(pointer);
		return javaResult;
	}

	/**
	 * [r/w] Optional. Specify 0 to ignore. For use with FMOD_CREATECOMPRESSEDSAMPLE only.  Mpeg  codecs consume 21,684 bytes per instance and this number will determine how many mpeg channels can be played simultaneously.  Default = 16.
	 */
	public int getMaxMpegCodecs() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_ADVANCEDSETTINGS_get_maxMPEGcodecs(pointer);
		return javaResult;
	}
	/**
	 * [r/w] Optional. Specify 0 to ignore. For use with FMOD_CREATECOMPRESSEDSAMPLE only.  Mpeg  codecs consume 21,684 bytes per instance and this number will determine how many mpeg channels can be played simultaneously.  Default = 16.
	 */
	public void setMaxMpegCodecs(int maxMpegCodecs) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_ADVANCEDSETTINGS_set_maxMPEGcodecs(pointer, maxMpegCodecs);
	}

	/**
	 * [r/w] Optional. Specify 0 to ignore. For use with FMOD_CREATECOMPRESSEDSAMPLE only.  ADPCM codecs consume 2,136 bytes per instance (based on FSB encoded ADPCM block size - see remarks) and this number will determine how many ADPCM channels can be played simultaneously.  Default = 32.
	 */
	public int getMaxAdpcmCodecs() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_ADVANCEDSETTINGS_get_maxADPCMcodecs(pointer);
		return javaResult;
	}
	/**
	 * [r/w] Optional. Specify 0 to ignore. For use with FMOD_CREATECOMPRESSEDSAMPLE only.  ADPCM codecs consume 2,136 bytes per instance (based on FSB encoded ADPCM block size - see remarks) and this number will determine how many ADPCM channels can be played simultaneously.  Default = 32.
	 */
	public void setMaxAdpcmCodecs(int maxAdpcmCodecs) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_ADVANCEDSETTINGS_set_maxADPCMcodecs(pointer, maxAdpcmCodecs);
	}

	/**
	 * [r/w] Optional. Specify 0 to ignore. For use with FMOD_CREATECOMPRESSEDSAMPLE only.  XMA   codecs consume 14,836 bytes per instance and this number will determine how many XMA channels can be played simultaneously.  Default = 32.
	 */
	public int getMaxXmaCodecs() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_ADVANCEDSETTINGS_get_maxXMAcodecs(pointer);
		return javaResult;
	}
	/**
	 * [r/w] Optional. Specify 0 to ignore. For use with FMOD_CREATECOMPRESSEDSAMPLE only.  XMA   codecs consume 14,836 bytes per instance and this number will determine how many XMA channels can be played simultaneously.  Default = 32.
	 */
	public void setMaxXmaCodecs(int maxXmaCodecs) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_ADVANCEDSETTINGS_set_maxXMAcodecs(pointer, maxXmaCodecs);
	}

	/**
	 * [r/w] Optional. Specify 0 to ignore. For use with FMOD_CREATECOMPRESSEDSAMPLE only.  CELT  codecs consume 11,500 bytes per instance and this number will determine how many CELT channels can be played simultaneously. Default = 16
	 */
	public int getMaxCELTcodecs() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_ADVANCEDSETTINGS_get_maxCELTcodecs(pointer);
		return javaResult;
	}
	/**
	 * [r/w] Optional. Specify 0 to ignore. For use with FMOD_CREATECOMPRESSEDSAMPLE only.  CELT  codecs consume 11,500 bytes per instance and this number will determine how many CELT channels can be played simultaneously. Default = 16
	 */
	public void setMaxCELTcodecs(int maxCELTcodecs) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_ADVANCEDSETTINGS_set_maxCELTcodecs(pointer, maxCELTcodecs);
	}

	/**
	 * [r/w] Optional. Specify 0 to ignore. For use with PS3 only.                          PCM   codecs consume 12,672 bytes per instance and this number will determine how many streams and PCM voices can be played simultaneously. Default = 16
	 */
	public int getMaxPCMCodecs() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_ADVANCEDSETTINGS_get_maxPCMcodecs(pointer);
		return javaResult;
	}
	/**
	 * [r/w] Optional. Specify 0 to ignore. For use with PS3 only.                          PCM   codecs consume 12,672 bytes per instance and this number will determine how many streams and PCM voices can be played simultaneously. Default = 16
	 */
	public void setMaxPCMCodecs(int maxPCMCodecs) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_ADVANCEDSETTINGS_set_maxPCMcodecs(pointer, maxPCMCodecs);
	}

	/**
	 * [r/w] Optional. Specify 0 to ignore. Number of channels available on the ASIO device.
	 */
	public int getASIONumChannels() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_ADVANCEDSETTINGS_get_ASIONumChannels(pointer);
		return javaResult;
	}

	/**
	 * [r/w] Optional. Specify 0 to ignore. Pointer to an array of strings (number of entries defined by ASIONumChannels) with ASIO channel names.
	 */
	public String[] getASIOChannelList() {
		if(pointer == 0) throw new NullPointerException();
		String[] javaResult = StructureJNI.FMOD_ADVANCEDSETTINGS_get_ASIOChannelList(pointer);
		return javaResult;
	}
	/**
	 * [r/w] Optional. Specify 0 to ignore. Pointer to an array of strings (number of entries defined by ASIONumChannels) with ASIO channel names.
	 */
	public void setASIOChannelList(String[] ASIOChannelList) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_ADVANCEDSETTINGS_set_ASIOChannelList(pointer, ASIOChannelList);
	}

	/**
	 * [r/w] Optional. Specify 0 to ignore. Pointer to a list of speakers that the ASIO channels map to.  This can be called after System::init to remap ASIO output.
	 */
	public FMOD_SPEAKER[] getASIOSpeakerList() {
		if(pointer == 0) throw new NullPointerException();
		ByteBuffer javaResult = StructureJNI.FMOD_ADVANCEDSETTINGS_get_ASIOSpeakerList(pointer);
		if(javaResult == null) { return null; }
		javaResult.order(ByteOrder.nativeOrder());
		if(javaResult == null) return null;
		IntBuffer ASIOSpeakerListIntBuffer = javaResult.asIntBuffer();
		if(ASIOSpeakerListIntBuffer.capacity() <= 0) return null;
		FMOD_SPEAKER[] ASIOSpeakerList = new FMOD_SPEAKER[ASIOSpeakerListIntBuffer.capacity()];
		for(int i = 0; i < ASIOSpeakerList.length; i++) {
			ASIOSpeakerList[i] = FMOD_SPEAKER.get(ASIOSpeakerListIntBuffer.get());
		}
		return ASIOSpeakerList;
	}
	/**
	 * [r/w] Optional. Specify 0 to ignore. Pointer to a list of speakers that the ASIO channels map to.  This can be called after System::init to remap ASIO output.
	 */
	public void setASIOSpeakerList(FMOD_SPEAKER[] ASIOSpeakerList) {
		if(pointer == 0) throw new NullPointerException();
		ByteBuffer ASIOSpeakerListBuffer = BufferUtils.newByteBuffer(ASIOSpeakerList.length * BufferUtils.SIZEOF_INT);
		for(int i = 0; i < ASIOSpeakerList.length; i++) {
			ASIOSpeakerListBuffer.putInt(i, ASIOSpeakerList[i].asInt());
		}
		StructureJNI.FMOD_ADVANCEDSETTINGS_set_ASIOSpeakerList(pointer, ASIOSpeakerListBuffer, BufferUtils.getPositionInBytes(ASIOSpeakerListBuffer));
	}

	/**
	 * [r/w] Optional. Specify 0 to ignore. The max number of 3d reverb DSP's in the system. (NOTE: CURRENTLY DISABLED / UNUSED)
	 */
	public int getMax3DReverbDSPs() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_ADVANCEDSETTINGS_get_max3DReverbDSPs(pointer);
		return javaResult;
	}
	/**
	 * [r/w] Optional. Specify 0 to ignore. The max number of 3d reverb DSP's in the system. (NOTE: CURRENTLY DISABLED / UNUSED)
	 */
	public void setMax3DReverbDSPs(int max3DReverbDSPs) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_ADVANCEDSETTINGS_set_max3DReverbDSPs(pointer, max3DReverbDSPs);
	}

	/**
	 * [r/w] Optional. Specify 0 to ignore. For use with FMOD_INIT_SOFTWARE_HRTF.  The angle range (0-360) of a 3D sound in relation to the listener, at which the HRTF function begins to have an effect. 0 = in front of the listener. 180 = from 90 degrees to the left of the listener to 90 degrees to the right. 360 = behind the listener. Default = 180.0.
	 */
	public float getHRTFMinAngle() {
		if(pointer == 0) throw new NullPointerException();
		float javaResult = StructureJNI.FMOD_ADVANCEDSETTINGS_get_HRTFMinAngle(pointer);
		return javaResult;
	}
	/**
	 * [r/w] Optional. Specify 0 to ignore. For use with FMOD_INIT_SOFTWARE_HRTF.  The angle range (0-360) of a 3D sound in relation to the listener, at which the HRTF function begins to have an effect. 0 = in front of the listener. 180 = from 90 degrees to the left of the listener to 90 degrees to the right. 360 = behind the listener. Default = 180.0.
	 */
	public void setHRTFMinAngle(float HRTFMinAngle) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_ADVANCEDSETTINGS_set_HRTFMinAngle(pointer, HRTFMinAngle);
	}

	/**
	 * [r/w] Optional. Specify 0 to ignore. For use with FMOD_INIT_SOFTWARE_HRTF.  The angle range (0-360) of a 3D sound in relation to the listener, at which the HRTF function has maximum effect. 0 = front of the listener. 180 = from 90 degrees to the left of the listener to 90 degrees to the right. 360 = behind the listener. Default = 360.0.
	 */
	public float getHRTFMaxAngle() {
		if(pointer == 0) throw new NullPointerException();
		float javaResult = StructureJNI.FMOD_ADVANCEDSETTINGS_get_HRTFMaxAngle(pointer);
		return javaResult;
	}
	/**
	 * [r/w] Optional. Specify 0 to ignore. For use with FMOD_INIT_SOFTWARE_HRTF.  The angle range (0-360) of a 3D sound in relation to the listener, at which the HRTF function has maximum effect. 0 = front of the listener. 180 = from 90 degrees to the left of the listener to 90 degrees to the right. 360 = behind the listener. Default = 360.0.
	 */
	public void setHRTFMaxAngle(float HRTFMaxAngle) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_ADVANCEDSETTINGS_set_HRTFMaxAngle(pointer, HRTFMaxAngle);
	}

	/**
	 * [r/w] Optional. Specify 0 to ignore. For use with FMOD_INIT_SOFTWARE_HRTF.  The cutoff frequency of the HRTF's lowpass filter function when at maximum effect. (i.e. at HRTFMaxAngle).  Default = 4000.0.
	 */
	public float getHRTFFreq() {
		if(pointer == 0) throw new NullPointerException();
		float javaResult = StructureJNI.FMOD_ADVANCEDSETTINGS_get_HRTFFreq(pointer);
		return javaResult;
	}
	/**
	 * [r/w] Optional. Specify 0 to ignore. For use with FMOD_INIT_SOFTWARE_HRTF.  The cutoff frequency of the HRTF's lowpass filter function when at maximum effect. (i.e. at HRTFMaxAngle).  Default = 4000.0.
	 */
	public void setHRTFFreq(float HRTFFreq) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_ADVANCEDSETTINGS_set_HRTFFreq(pointer, HRTFFreq);
	}

	/**
	 * [r/w] Optional. Specify 0 to ignore. For use with FMOD_INIT_VOL0_BECOMES_VIRTUAL.  If this flag is used, and the volume is 0.0, then the sound will become virtual.  Use this value to raise the threshold to a different point where a sound goes virtual.
	 */
	public float getVol0VirtualVol() {
		if(pointer == 0) throw new NullPointerException();
		float javaResult = StructureJNI.FMOD_ADVANCEDSETTINGS_get_vol0virtualvol(pointer);
		return javaResult;
	}
	/**
	 * [r/w] Optional. Specify 0 to ignore. For use with FMOD_INIT_VOL0_BECOMES_VIRTUAL.  If this flag is used, and the volume is 0.0, then the sound will become virtual.  Use this value to raise the threshold to a different point where a sound goes virtual.
	 */
	public void setVol0VirtualVol(float vol0VirtualVol) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_ADVANCEDSETTINGS_set_vol0virtualvol(pointer, vol0VirtualVol);
	}

	/**
	 * [r/w] Optional. Specify 0 to ignore. For use with FMOD Event system only.  Specifies the number of slots available for simultaneous non blocking loads.  Default = 32.
	 */
	public int getEventQueueSize() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_ADVANCEDSETTINGS_get_eventqueuesize(pointer);
		return javaResult;
	}
	/**
	 * [r/w] Optional. Specify 0 to ignore. For use with FMOD Event system only.  Specifies the number of slots available for simultaneous non blocking loads.  Default = 32.
	 */
	public void setEventQueueSize(int eventQueueSize) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_ADVANCEDSETTINGS_set_eventqueuesize(pointer, eventQueueSize);
	}

	/**
	 * [r/w] Optional. Specify 0 to ignore. For streams. This determines the default size of the double buffer (in milliseconds) that a stream uses.  Default = 400ms
	 */
	public int getDefaultDecodeBufferSize() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_ADVANCEDSETTINGS_get_defaultDecodeBufferSize(pointer);
		return javaResult;
	}
	/**
	 * [r/w] Optional. Specify 0 to ignore. For streams. This determines the default size of the double buffer (in milliseconds) that a stream uses.  Default = 400ms
	 */
	public void setDefaultDecodeBufferSize(int defaultDecodeBufferSize) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_ADVANCEDSETTINGS_set_defaultDecodeBufferSize(pointer, defaultDecodeBufferSize);
	}

	/**
	 * [r/w] Optional. Specify 0 to ignore. Gives fmod's logging system a path/filename.  Normally the log is placed in the same directory as the executable and called fmod.log. When using System::getAdvancedSettings, provide at least 256 bytes of memory to copy into.
	 */
	public String getDebugLogFilename() {
		if(pointer == 0) throw new NullPointerException();
		String javaResult = StructureJNI.FMOD_ADVANCEDSETTINGS_get_debugLogFilename(pointer);
		return javaResult;
	}
	/**
	 * [r/w] Optional. Specify 0 to ignore. Gives fmod's logging system a path/filename.  Normally the log is placed in the same directory as the executable and called fmod.log. When using System::getAdvancedSettings, provide at least 256 bytes of memory to copy into.
	 */
	public void setDebugLogFilename(String debugLogFilename) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_ADVANCEDSETTINGS_set_debugLogFilename(pointer, debugLogFilename == null ? null : debugLogFilename.getBytes());
	}

	/**
	 * [r/w] Optional. Specify 0 to ignore. For use with FMOD_INIT_ENABLE_PROFILE.  Specify the port to listen on for connections by the profiler application.
	 */
	public short getProfilePort() {
		if(pointer == 0) throw new NullPointerException();
		short javaResult = StructureJNI.FMOD_ADVANCEDSETTINGS_get_profileport(pointer);
		return javaResult;
	}
	/**
	 * [r/w] Optional. Specify 0 to ignore. For use with FMOD_INIT_ENABLE_PROFILE.  Specify the port to listen on for connections by the profiler application.
	 */
	public void setProfilePort(short profilePort) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_ADVANCEDSETTINGS_set_profileport(pointer, profilePort);
	}

	/**
	 * [r/w] Optional. Specify 0 to ignore. The maximum time in miliseconds it takes for a channel to fade to the new level when its occlusion changes.
	 */
	public int getGeometryMaxFadeTime() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_ADVANCEDSETTINGS_get_geometryMaxFadeTime(pointer);
		return javaResult;
	}
	/**
	 * [r/w] Optional. Specify 0 to ignore. The maximum time in miliseconds it takes for a channel to fade to the new level when its occlusion changes.
	 */
	public void setGeometryMaxFadeTime(int geometryMaxFadeTime) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_ADVANCEDSETTINGS_set_geometryMaxFadeTime(pointer, geometryMaxFadeTime);
	}

	/**
	 * [r/w] Optional. Specify 0 to ignore. Tells System::init to allocate a pool of wavedata/spectrum buffers to prevent memory fragmentation, any additional buffers will be allocated normally.
	 */
	public int getMaxSpectrumWaveDataBuffers() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_ADVANCEDSETTINGS_get_maxSpectrumWaveDataBuffers(pointer);
		return javaResult;
	}
	/**
	 * [r/w] Optional. Specify 0 to ignore. Tells System::init to allocate a pool of wavedata/spectrum buffers to prevent memory fragmentation, any additional buffers will be allocated normally.
	 */
	public void setMaxSpectrumWaveDataBuffers(int maxSpectrumWaveDataBuffers) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_ADVANCEDSETTINGS_set_maxSpectrumWaveDataBuffers(pointer, maxSpectrumWaveDataBuffers);
	}

}
