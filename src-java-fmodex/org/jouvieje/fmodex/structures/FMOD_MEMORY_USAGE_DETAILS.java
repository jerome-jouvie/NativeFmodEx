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

public class FMOD_MEMORY_USAGE_DETAILS extends Pointer {
	/**
	 * Create a view of the <code>Pointer</code> object as a <code>FMOD_MEMORY_USAGE_DETAILS</code> object.<br>
	 * This view is valid only if the memory holded by the <code>Pointer</code> holds a FMOD_MEMORY_USAGE_DETAILS object.
	 */
	public static FMOD_MEMORY_USAGE_DETAILS asFMOD_MEMORY_USAGE_DETAILS(Pointer pointer) {
		long address = Pointer.getPointer(pointer);
		if(address == 0) return null;
		return new FMOD_MEMORY_USAGE_DETAILS(address);
	}
	/**
	 * Allocate a new <code>FMOD_MEMORY_USAGE_DETAILS</code>.<br>
	 * The call <code>isNull()</code> on the object created will return false.<br>
	 * <pre><code>  FMOD_MEMORY_USAGE_DETAILS obj = FMOD_MEMORY_USAGE_DETAILS.allocate();
	 *  (obj == null) <=> obj.isNull() <=> false
	 * </code></pre>
	 */
	public static FMOD_MEMORY_USAGE_DETAILS allocate() {
		final long pointer = StructureJNI.FMOD_MEMORY_USAGE_DETAILS_new();
		if(pointer == 0) throw new OutOfMemoryError();
		return new FMOD_MEMORY_USAGE_DETAILS(pointer);
	}

	protected FMOD_MEMORY_USAGE_DETAILS(long pointer) {
		super(pointer);
	}

	/**
	 * Create an object that holds a null <code>FMOD_MEMORY_USAGE_DETAILS</code>.<br>
	 * The call <code>isNull()</code> on the object created will returns true.<br>
	 * <pre><code>  FMOD_MEMORY_USAGE_DETAILS obj = new FMOD_MEMORY_USAGE_DETAILS();
	 *  (obj == null) <=> false
	 *  obj.isNull() <=> true
	 * </code></pre>
	 * To creates a new <code>FMOD_MEMORY_USAGE_DETAILS</code>, use the static "constructor" :
	 * <pre><code>  FMOD_MEMORY_USAGE_DETAILS obj = FMOD_MEMORY_USAGE_DETAILS.allocate();</code></pre>
	 * @see FMOD_MEMORY_USAGE_DETAILS#allocate()
	 */
	public FMOD_MEMORY_USAGE_DETAILS() {
		super();
	}

	public void release() {
		if(pointer != 0) {
			StructureJNI.FMOD_MEMORY_USAGE_DETAILS_delete(pointer);
		}
		pointer = 0;
	}

	/**
	 * [out] Memory not accounted for by other types
	 */
	public int getOther() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_MEMORY_USAGE_DETAILS_get_other(pointer);
		return javaResult;
	}

	/**
	 * [out] String data
	 */
	public int getString() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_MEMORY_USAGE_DETAILS_get_string(pointer);
		return javaResult;
	}

	/**
	 * [out] System object and various internals
	 */
	public int getSystem() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_MEMORY_USAGE_DETAILS_get_system(pointer);
		return javaResult;
	}

	/**
	 * [out] Plugin objects and internals
	 */
	public int getPlugins() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_MEMORY_USAGE_DETAILS_get_plugins(pointer);
		return javaResult;
	}

	/**
	 * [out] Output module object and internals
	 */
	public int getOutput() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_MEMORY_USAGE_DETAILS_get_output(pointer);
		return javaResult;
	}

	/**
	 * [out] Channel related memory
	 */
	public int getChannel() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_MEMORY_USAGE_DETAILS_get_channel(pointer);
		return javaResult;
	}

	/**
	 * [out] ChannelGroup objects and internals
	 */
	public int getChannelGroup() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_MEMORY_USAGE_DETAILS_get_channelgroup(pointer);
		return javaResult;
	}

	/**
	 * [out] Codecs allocated for streaming
	 */
	public int getCodec() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_MEMORY_USAGE_DETAILS_get_codec(pointer);
		return javaResult;
	}

	/**
	 * [out] File buffers and structures
	 */
	public int getFile() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_MEMORY_USAGE_DETAILS_get_file(pointer);
		return javaResult;
	}

	/**
	 * [out] Sound objects and internals
	 */
	public int getSound() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_MEMORY_USAGE_DETAILS_get_sound(pointer);
		return javaResult;
	}

	/**
	 * [out] Sound data stored in secondary RAM
	 */
	public int getSecondaryRam() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_MEMORY_USAGE_DETAILS_get_secondaryram(pointer);
		return javaResult;
	}

	/**
	 * [out] SoundGroup objects and internals
	 */
	public int getSoundGroup() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_MEMORY_USAGE_DETAILS_get_soundgroup(pointer);
		return javaResult;
	}

	/**
	 * [out] Stream buffer memory
	 */
	public int getStreamBuffer() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_MEMORY_USAGE_DETAILS_get_streambuffer(pointer);
		return javaResult;
	}

	/**
	 * [out] DSPConnection objects and internals
	 */
	public int getDspConnection() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_MEMORY_USAGE_DETAILS_get_dspconnection(pointer);
		return javaResult;
	}

	/**
	 * [out] DSP implementation objects
	 */
	public int getDsp() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_MEMORY_USAGE_DETAILS_get_dsp(pointer);
		return javaResult;
	}

	/**
	 * [out] Realtime file format decoding DSP objects
	 */
	public int getDspCodec() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_MEMORY_USAGE_DETAILS_get_dspcodec(pointer);
		return javaResult;
	}

	/**
	 * [out] Profiler memory footprint.
	 */
	public int getProfile() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_MEMORY_USAGE_DETAILS_get_profile(pointer);
		return javaResult;
	}

	/**
	 * [out] Buffer used to store recorded data from microphone
	 */
	public int getRecordBuffer() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_MEMORY_USAGE_DETAILS_get_recordbuffer(pointer);
		return javaResult;
	}

	/**
	 * [out] Reverb implementation objects
	 */
	public int getReverb() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_MEMORY_USAGE_DETAILS_get_reverb(pointer);
		return javaResult;
	}

	/**
	 * [out] Reverb channel properties structs
	 */
	public int getReverbChannelProps() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_MEMORY_USAGE_DETAILS_get_reverbchannelprops(pointer);
		return javaResult;
	}

	/**
	 * [out] Geometry objects and internals
	 */
	public int getGeometry() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_MEMORY_USAGE_DETAILS_get_geometry(pointer);
		return javaResult;
	}

	/**
	 * [out] Sync point memory.
	 */
	public int getSyncPoint() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_MEMORY_USAGE_DETAILS_get_syncpoint(pointer);
		return javaResult;
	}

	/**
	 * [out] EventSystem and various internals
	 */
	public int getEventSystem() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_MEMORY_USAGE_DETAILS_get_eventsystem(pointer);
		return javaResult;
	}

	/**
	 * [out] MusicSystem and various internals
	 */
	public int getMusicSystem() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_MEMORY_USAGE_DETAILS_get_musicsystem(pointer);
		return javaResult;
	}

	/**
	 * [out] Definition of objects contained in all loaded projects e.g. events, groups, categories
	 */
	public int getFev() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_MEMORY_USAGE_DETAILS_get_fev(pointer);
		return javaResult;
	}

	/**
	 * [out] Data loaded with registerMemoryFSB
	 */
	public int getMemoryFsb() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_MEMORY_USAGE_DETAILS_get_memoryfsb(pointer);
		return javaResult;
	}

	/**
	 * [out] EventProject objects and internals
	 */
	public int getEventProject() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_MEMORY_USAGE_DETAILS_get_eventproject(pointer);
		return javaResult;
	}

	/**
	 * [out] EventGroup objects and internals
	 */
	public int getEventGroupI() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_MEMORY_USAGE_DETAILS_get_eventgroupi(pointer);
		return javaResult;
	}

	/**
	 * [out] Objects used to manage wave banks
	 */
	public int getSoundBankClass() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_MEMORY_USAGE_DETAILS_get_soundbankclass(pointer);
		return javaResult;
	}

	/**
	 * [out] Data used to manage lists of wave bank usage
	 */
	public int getSoundBankList() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_MEMORY_USAGE_DETAILS_get_soundbanklist(pointer);
		return javaResult;
	}

	/**
	 * [out] Stream objects and internals
	 */
	public int getStreamInstance() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_MEMORY_USAGE_DETAILS_get_streaminstance(pointer);
		return javaResult;
	}

	/**
	 * [out] Sound definition objects
	 */
	public int getSoundDefClass() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_MEMORY_USAGE_DETAILS_get_sounddefclass(pointer);
		return javaResult;
	}

	/**
	 * [out] Sound definition static data objects
	 */
	public int getSoundDefDefClass() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_MEMORY_USAGE_DETAILS_get_sounddefdefclass(pointer);
		return javaResult;
	}

	/**
	 * [out] Sound definition pool data
	 */
	public int getSoundDefPool() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_MEMORY_USAGE_DETAILS_get_sounddefpool(pointer);
		return javaResult;
	}

	/**
	 * [out] Reverb definition objects
	 */
	public int getReverbDef() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_MEMORY_USAGE_DETAILS_get_reverbdef(pointer);
		return javaResult;
	}

	/**
	 * [out] Reverb objects
	 */
	public int getEventReverb() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_MEMORY_USAGE_DETAILS_get_eventreverb(pointer);
		return javaResult;
	}

	/**
	 * [out] User property objects
	 */
	public int getUserProperty() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_MEMORY_USAGE_DETAILS_get_userproperty(pointer);
		return javaResult;
	}

	/**
	 * [out] Event instance base objects
	 */
	public int getEventInstance() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_MEMORY_USAGE_DETAILS_get_eventinstance(pointer);
		return javaResult;
	}

	/**
	 * [out] Complex event instance objects
	 */
	public int getEventInstanceComplex() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_MEMORY_USAGE_DETAILS_get_eventinstance_complex(pointer);
		return javaResult;
	}

	/**
	 * [out] Simple event instance objects
	 */
	public int getEventInstanceSimple() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_MEMORY_USAGE_DETAILS_get_eventinstance_simple(pointer);
		return javaResult;
	}

	/**
	 * [out] Event layer instance objects
	 */
	public int getEventInstanceLayer() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_MEMORY_USAGE_DETAILS_get_eventinstance_layer(pointer);
		return javaResult;
	}

	/**
	 * [out] Event sound instance objects
	 */
	public int getEventInstanceSound() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_MEMORY_USAGE_DETAILS_get_eventinstance_sound(pointer);
		return javaResult;
	}

	/**
	 * [out] Event envelope objects
	 */
	public int getEventEnvelope() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_MEMORY_USAGE_DETAILS_get_eventenvelope(pointer);
		return javaResult;
	}

	/**
	 * [out] Event envelope definition objects
	 */
	public int getEventEnvelopeDef() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_MEMORY_USAGE_DETAILS_get_eventenvelopedef(pointer);
		return javaResult;
	}

	/**
	 * [out] Event parameter objects
	 */
	public int getEventParameter() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_MEMORY_USAGE_DETAILS_get_eventparameter(pointer);
		return javaResult;
	}

	/**
	 * [out] Event category objects
	 */
	public int getEventCategory() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_MEMORY_USAGE_DETAILS_get_eventcategory(pointer);
		return javaResult;
	}

	/**
	 * [out] Event envelope point objects
	 */
	public int getEventEnvelopePoint() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_MEMORY_USAGE_DETAILS_get_eventenvelopepoint(pointer);
		return javaResult;
	}

	/**
	 * [out] Event instance pool memory
	 */
	public int getEventInstancePool() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_MEMORY_USAGE_DETAILS_get_eventinstancepool(pointer);
		return javaResult;
	}

}
