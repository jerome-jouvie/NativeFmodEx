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

class StructureJNI {
	static {
		if(!InitFmodDesigner.isLibrariesLoaded()) {
			throw new RuntimeException("Libraries not loaded ! Use InitFmodDesigner.loadLibraries() before using NativeFmodDesigner.");
		}
	}

						/* FMOD_EVENT_INFO */

	protected final static native long FMOD_EVENT_INFO_new();
	protected final static native void FMOD_EVENT_INFO_delete(long pointer);
	protected final static native int FMOD_EVENT_INFO_get_memoryused(long pointer);
	protected final static native void FMOD_EVENT_INFO_set_memoryused(long pointer, int memoryused);
	protected final static native int FMOD_EVENT_INFO_get_positionms(long pointer);
	protected final static native int FMOD_EVENT_INFO_get_lengthms(long pointer);
	protected final static native int FMOD_EVENT_INFO_get_channelsplaying(long pointer);
	protected final static native int FMOD_EVENT_INFO_get_instancesactive(long pointer);
	protected final static native int FMOD_EVENT_INFO_get_maxwavebanks(long pointer);
	protected final static native long FMOD_EVENT_INFO_get_wavebankinfo(long pointer);
	protected final static native void FMOD_EVENT_INFO_set_wavebankinfo(long pointer, long wavebankinfo, int wavebankinfoLen_);
	protected final static native int FMOD_EVENT_INFO_get_projectid(long pointer);
	protected final static native int FMOD_EVENT_INFO_get_systemid(long pointer);
	protected final static native float FMOD_EVENT_INFO_get_audibility(long pointer);
	protected final static native int FMOD_EVENT_INFO_get_numinstances(long pointer);
	protected final static native Event[] FMOD_EVENT_INFO_get_instances(long pointer);
	protected final static native void FMOD_EVENT_INFO_set_instances(long pointer, Event[] instances);
	protected final static native long FMOD_EVENT_INFO_get_guid(long pointer);

						/* FMOD_EVENT_LOADINFO */

	protected final static native long FMOD_EVENT_LOADINFO_new();
	protected final static native void FMOD_EVENT_LOADINFO_delete(long pointer);
	protected final static native int FMOD_EVENT_LOADINFO_get_size(long pointer);
	protected final static native void FMOD_EVENT_LOADINFO_set_size(long pointer, int size);
	protected final static native String FMOD_EVENT_LOADINFO_get_encryptionkey(long pointer);
	protected final static native void FMOD_EVENT_LOADINFO_set_encryptionkey(long pointer, byte[] encryptionkey);
	protected final static native float FMOD_EVENT_LOADINFO_get_sounddefentrylimit(long pointer);
	protected final static native void FMOD_EVENT_LOADINFO_set_sounddefentrylimit(long pointer, float sounddefentrylimit);
	protected final static native int FMOD_EVENT_LOADINFO_get_loadfrommemory_length(long pointer);
	protected final static native void FMOD_EVENT_LOADINFO_set_loadfrommemory_length(long pointer, int loadfrommemory_length);
	protected final static native boolean FMOD_EVENT_LOADINFO_get_override_category_vals(long pointer);
	protected final static native void FMOD_EVENT_LOADINFO_set_override_category_vals(long pointer, boolean override_category_vals);
	protected final static native int FMOD_EVENT_LOADINFO_get_sizeof_instancepool_simple(long pointer);
	protected final static native void FMOD_EVENT_LOADINFO_set_sizeof_instancepool_simple(long pointer, int sizeof_instancepool_simple);

						/* FMOD_EVENT_SOUNDDEFINFO */

	protected final static native long FMOD_EVENT_SOUNDDEFINFO_new();
	protected final static native void FMOD_EVENT_SOUNDDEFINFO_delete(long pointer);
	protected final static native String FMOD_EVENT_SOUNDDEFINFO_get_name(long pointer);
	protected final static native int FMOD_EVENT_SOUNDDEFINFO_get_numentries(long pointer);
	protected final static native String[] FMOD_EVENT_SOUNDDEFINFO_get_entrynames(long pointer);
	protected final static native ByteBuffer FMOD_EVENT_SOUNDDEFINFO_get_entrytypes(long pointer);

						/* FMOD_EVENT_SYSTEMINFO */

	protected final static native long FMOD_EVENT_SYSTEMINFO_new();
	protected final static native void FMOD_EVENT_SYSTEMINFO_delete(long pointer);
	protected final static native int FMOD_EVENT_SYSTEMINFO_get_numevents(long pointer);
	protected final static native int FMOD_EVENT_SYSTEMINFO_get_numinstances(long pointer);
	protected final static native int FMOD_EVENT_SYSTEMINFO_get_maxwavebanks(long pointer);
	protected final static native long FMOD_EVENT_SYSTEMINFO_get_wavebankinfo(long pointer);
	protected final static native void FMOD_EVENT_SYSTEMINFO_set_wavebankinfo(long pointer, long wavebankinfo, int wavebankinfoLen_);
	protected final static native int FMOD_EVENT_SYSTEMINFO_get_numplayingevents(long pointer);
	protected final static native Event[] FMOD_EVENT_SYSTEMINFO_get_playingevents(long pointer);
	protected final static native void FMOD_EVENT_SYSTEMINFO_set_playingevents(long pointer, Event[] playingevents);

						/* FMOD_EVENT_WAVEBANKINFO */

	protected final static native int FMOD_EVENT_WAVEBANKINFO_SIZEOF();
	protected final static native long FMOD_EVENT_WAVEBANKINFO_newArray(int length);
	protected final static native long FMOD_EVENT_WAVEBANKINFO_new();
	protected final static native void FMOD_EVENT_WAVEBANKINFO_delete(long pointer);
	protected final static native ByteBuffer FMOD_EVENT_WAVEBANKINFO_get_name(long pointer);
	protected final static native int FMOD_EVENT_WAVEBANKINFO_get_streamrefcnt(long pointer);
	protected final static native int FMOD_EVENT_WAVEBANKINFO_get_samplerefcnt(long pointer);
	protected final static native int FMOD_EVENT_WAVEBANKINFO_get_numstreams(long pointer);
	protected final static native int FMOD_EVENT_WAVEBANKINFO_get_maxstreams(long pointer);
	protected final static native int FMOD_EVENT_WAVEBANKINFO_get_streamsinuse(long pointer);
	protected final static native int FMOD_EVENT_WAVEBANKINFO_get_streammemory(long pointer);
	protected final static native int FMOD_EVENT_WAVEBANKINFO_get_samplememory(long pointer);
	protected final static native int FMOD_EVENT_WAVEBANKINFO_get_type(long pointer);

						/* FMOD_MUSIC_ENTITY */

	protected final static native long FMOD_MUSIC_ENTITY_new();
	protected final static native void FMOD_MUSIC_ENTITY_delete(long pointer);
	protected final static native String FMOD_MUSIC_ENTITY_get_name(long pointer);
	protected final static native void FMOD_MUSIC_ENTITY_set_name(long pointer, byte[] name);
	protected final static native int FMOD_MUSIC_ENTITY_get_id(long pointer);
	protected final static native void FMOD_MUSIC_ENTITY_set_id(long pointer, int id);

						/* FMOD_MUSIC_INFO */

	protected final static native long FMOD_MUSIC_INFO_new();
	protected final static native void FMOD_MUSIC_INFO_delete(long pointer);
	protected final static native boolean FMOD_MUSIC_INFO_get_starving(long pointer);

						/* FMOD_MUSIC_ITERATOR */

	protected final static native long FMOD_MUSIC_ITERATOR_new();
	protected final static native void FMOD_MUSIC_ITERATOR_delete(long pointer);
	protected final static native long FMOD_MUSIC_ITERATOR_get_value(long pointer);
	protected final static native void FMOD_MUSIC_ITERATOR_set_value(long pointer, long value);
	protected final static native String FMOD_MUSIC_ITERATOR_get_filter(long pointer);
	protected final static native void FMOD_MUSIC_ITERATOR_set_filter(long pointer, byte[] filter);

						/* FMOD_MUSIC_SAMPLE_INFO */

	protected final static native long FMOD_MUSIC_SAMPLE_INFO_new();
	protected final static native void FMOD_MUSIC_SAMPLE_INFO_delete(long pointer);
	protected final static native int FMOD_MUSIC_SAMPLE_INFO_get_segment_id(long pointer);
	protected final static native void FMOD_MUSIC_SAMPLE_INFO_set_segment_id(long pointer, int segment_id);
	protected final static native int FMOD_MUSIC_SAMPLE_INFO_get_index(long pointer);
	protected final static native void FMOD_MUSIC_SAMPLE_INFO_set_index(long pointer, int index);
	protected final static native String FMOD_MUSIC_SAMPLE_INFO_get_filename(long pointer);
	protected final static native void FMOD_MUSIC_SAMPLE_INFO_set_filename(long pointer, byte[] filename);

}
