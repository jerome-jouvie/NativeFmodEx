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

package org.jouvieje.fmoddesigner;

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

class FmodDesignerJNI {
	static {
		if(!InitFmodDesigner.isLibrariesLoaded()) {
			throw new RuntimeException("Libraries not loaded ! Use InitFmodDesigner.loadLibraries() before using NativeFmodDesigner.");
		}
	}

	protected final static native int Event_SIZEOF();
	protected final static native long Event_newArray(int length);
	protected final static native int Event_release(long pointer, boolean freeeventdata, boolean waituntilready);
	protected final static native int Event_start(long pointer);
	protected final static native int Event_stop(long pointer, boolean immediate);
	protected final static native int Event_getInfo(long pointer, IntBuffer index, long index_, Pointer name, long info);
	protected final static native int Event_getState(long pointer, IntBuffer state, long state_);
	protected final static native int Event_getParentGroup(long pointer, EventGroup group);
	protected final static native int Event_getChannelGroup(long pointer, ChannelGroup channelgroup);
	protected final static native int Event_setCallback(long pointer, boolean callback, long userdata);
	protected final static native int Event_getParameter(long pointer, byte[] name, EventParameter parameter);
	protected final static native int Event_getParameterByIndex(long pointer, int index, EventParameter parameter);
	protected final static native int Event_getNumParameters(long pointer, IntBuffer numparameters, long numparameters_);
	protected final static native int Event_getProperty(long pointer, byte[] propertyname, long value, boolean this_instance);
	protected final static native int Event_getPropertyByIndex(long pointer, int propertyindex, long value, boolean this_instance);
	protected final static native int Event_setProperty(long pointer, byte[] propertyname, long value, boolean this_instance);
	protected final static native int Event_setPropertyByIndex(long pointer, int propertyindex, long value, boolean this_instance);
	protected final static native int Event_getNumProperties(long pointer, IntBuffer numproperties, long numproperties_);
	protected final static native int Event_getPropertyInfo(long pointer, IntBuffer propertyindex, long propertyindex_, Pointer propertyname, IntBuffer typePointer);
	protected final static native int Event_getCategory(long pointer, EventCategory category);
	protected final static native int Event_setVolume(long pointer, float volume);
	protected final static native int Event_getVolume(long pointer, FloatBuffer volume, long volume_);
	protected final static native int Event_setPitch(long pointer, float pitch, int units);
	protected final static native int Event_getPitch(long pointer, FloatBuffer pitch, long pitch_, int units);
	protected final static native int Event_setPaused(long pointer, boolean paused);
	protected final static native int Event_getPaused(long pointer, ByteBuffer paused, long paused_);
	protected final static native int Event_setMute(long pointer, boolean mute);
	protected final static native int Event_getMute(long pointer, ByteBuffer mute, long mute_);
	protected final static native int Event_set3DAttributes(long pointer, long position, long velocity, long orientation);
	protected final static native int Event_get3DAttributes(long pointer, long position, long velocity, long orientation);
	protected final static native int Event_set3DOcclusion(long pointer, float directocclusion, float reverbocclusion);
	protected final static native int Event_get3DOcclusion(long pointer, FloatBuffer directocclusion, long directocclusion_, FloatBuffer reverbocclusion, long reverbocclusion_);
	protected final static native int Event_setReverbProperties(long pointer, long props);
	protected final static native int Event_getReverbProperties(long pointer, long props);
	protected final static native int Event_setUserData(long pointer, long userdata);
	protected final static native int Event_getUserData(long pointer, Pointer userdata);
	protected final static native int Event_getMemoryInfo(long pointer, int memorybits, int event_memorybits, IntBuffer memoryused, long memoryused_, long memoryused_details);
	protected final static native int EventCategory_getInfo(long pointer, IntBuffer index, long index_, Pointer name);
	protected final static native int EventCategory_getCategory(long pointer, byte[] name, EventCategory category);
	protected final static native int EventCategory_getCategoryByIndex(long pointer, int index, EventCategory category);
	protected final static native int EventCategory_getNumCategories(long pointer, IntBuffer numcategories, long numcategories_);
	protected final static native int EventCategory_getEventByIndex(long pointer, int index, int mode, Event event);
	protected final static native int EventCategory_getNumEvents(long pointer, IntBuffer numevents, long numevents_);
	protected final static native int EventCategory_getParentCategory(long pointer, EventCategory category);
	protected final static native int EventCategory_stopAllEvents(long pointer);
	protected final static native int EventCategory_setVolume(long pointer, float volume);
	protected final static native int EventCategory_getVolume(long pointer, FloatBuffer volume, long volume_);
	protected final static native int EventCategory_setPitch(long pointer, float pitch, int units);
	protected final static native int EventCategory_getPitch(long pointer, FloatBuffer pitch, long pitch_, int units);
	protected final static native int EventCategory_setPaused(long pointer, boolean paused);
	protected final static native int EventCategory_getPaused(long pointer, ByteBuffer paused, long paused_);
	protected final static native int EventCategory_setMute(long pointer, boolean mute);
	protected final static native int EventCategory_getMute(long pointer, ByteBuffer mute, long mute_);
	protected final static native int EventCategory_getChannelGroup(long pointer, ChannelGroup channelgroup);
	protected final static native int EventCategory_setUserData(long pointer, long userdata);
	protected final static native int EventCategory_getUserData(long pointer, Pointer userdata);
	protected final static native int EventCategory_getMemoryInfo(long pointer, int memorybits, int event_memorybits, IntBuffer memoryused, long memoryused_, long memoryused_details);
	protected final static native int EventGroup_getInfo(long pointer, IntBuffer index, long index_, Pointer name);
	protected final static native int EventGroup_loadEventData(long pointer, int resource, int mode);
	protected final static native int EventGroup_freeEventData(long pointer, long event, boolean waituntilready);
	protected final static native int EventGroup_getGroup(long pointer, byte[] name, boolean cacheevents, EventGroup group);
	protected final static native int EventGroup_getGroupByIndex(long pointer, int index, boolean cacheevents, EventGroup group);
	protected final static native int EventGroup_getParentGroup(long pointer, EventGroup group);
	protected final static native int EventGroup_getParentProject(long pointer, EventProject project);
	protected final static native int EventGroup_getNumGroups(long pointer, IntBuffer numgroups, long numgroups_);
	protected final static native int EventGroup_getEvent(long pointer, byte[] name, int mode, Event event);
	protected final static native int EventGroup_getEventByIndex(long pointer, int index, int mode, Event event);
	protected final static native int EventGroup_getNumEvents(long pointer, IntBuffer numevents, long numevents_);
	protected final static native int EventGroup_getProperty(long pointer, byte[] propertyname, long value);
	protected final static native int EventGroup_getPropertyByIndex(long pointer, int propertyindex, long value);
	protected final static native int EventGroup_getNumProperties(long pointer, IntBuffer numproperties, long numproperties_);
	protected final static native int EventGroup_getState(long pointer, IntBuffer state, long state_);
	protected final static native int EventGroup_setUserData(long pointer, long userdata);
	protected final static native int EventGroup_getUserData(long pointer, Pointer userdata);
	protected final static native int EventGroup_getMemoryInfo(long pointer, int memorybits, int event_memorybits, IntBuffer memoryused, long memoryused_, long memoryused_details);
	protected final static native int EventParameter_getInfo(long pointer, IntBuffer index, long index_, Pointer name);
	protected final static native int EventParameter_getRange(long pointer, FloatBuffer rangemin, long rangemin_, FloatBuffer rangemax, long rangemax_);
	protected final static native int EventParameter_setValue(long pointer, float value);
	protected final static native int EventParameter_getValue(long pointer, FloatBuffer value, long value_);
	protected final static native int EventParameter_setVelocity(long pointer, float value);
	protected final static native int EventParameter_getVelocity(long pointer, FloatBuffer value, long value_);
	protected final static native int EventParameter_setSeekSpeed(long pointer, float value);
	protected final static native int EventParameter_getSeekSpeed(long pointer, FloatBuffer value, long value_);
	protected final static native int EventParameter_setUserData(long pointer, long userdata);
	protected final static native int EventParameter_getUserData(long pointer, Pointer userdata);
	protected final static native int EventParameter_keyOff(long pointer);
	protected final static native int EventParameter_getMemoryInfo(long pointer, int memorybits, int event_memorybits, IntBuffer memoryused, long memoryused_, long memoryused_details);
	protected final static native int EventProject_release(long pointer);
	protected final static native int EventProject_getInfo(long pointer, IntBuffer index, long index_, Pointer name);
	protected final static native int EventProject_getGroup(long pointer, byte[] name, boolean cacheevents, EventGroup group);
	protected final static native int EventProject_getGroupByIndex(long pointer, int index, boolean cacheevents, EventGroup group);
	protected final static native int EventProject_getNumGroups(long pointer, IntBuffer numgroups, long numgroups_);
	protected final static native int EventProject_getEvent(long pointer, byte[] name, int mode, Event event);
	protected final static native int EventProject_getEventByProjectID(long pointer, int projectid, int mode, Event event);
	protected final static native int EventProject_getNumEvents(long pointer, IntBuffer numevents, long numevents_);
	protected final static native int EventProject_loadSampleData(long pointer, IntBuffer eventid_array, long eventid_array_, int sizeof_eventid_array, Pointer groupname_array, int sizeof_groupname_array, int eventmode);
	protected final static native int EventProject_setUserData(long pointer, long userdata);
	protected final static native int EventProject_getUserData(long pointer, Pointer userdata);
	protected final static native int EventProject_stopAllEvents(long pointer, boolean immediate);
	protected final static native int EventProject_getMemoryInfo(long pointer, int memorybits, int event_memorybits, IntBuffer memoryused, long memoryused_, long memoryused_details);
	protected final static native int EventQueue_SIZEOF();
	protected final static native long EventQueue_newArray(int length);
	protected final static native int EventQueue_release(long pointer);
	protected final static native int EventQueue_add(long pointer, long entry, boolean allow_duplicates);
	protected final static native int EventQueue_remove(long pointer, long entry);
	protected final static native int EventQueue_removeHead(long pointer);
	protected final static native int EventQueue_clear(long pointer, boolean stopallevents);
	protected final static native int EventQueue_findFirstEntry(long pointer, EventQueueEntry entry);
	protected final static native int EventQueue_findNextEntry(long pointer, EventQueueEntry entry);
	protected final static native int EventQueue_setPaused(long pointer, boolean paused);
	protected final static native int EventQueue_getPaused(long pointer, ByteBuffer paused, long paused_);
	protected final static native int EventQueue_includeDuckingCategory(long pointer, long category, float ducked_volume, float unducked_volume, int duck_time, int unduck_time);
	protected final static native int EventQueue_excludeDuckingCategory(long pointer, long category);
	protected final static native int EventQueue_setCallback(long pointer, boolean callback, long callbackuserdata);
	protected final static native int EventQueue_setUserData(long pointer, long userdata);
	protected final static native int EventQueue_getUserData(long pointer, Pointer userdata);
	protected final static native int EventQueue_dump(long pointer);
	protected final static native int EventQueue_getMemoryInfo(long pointer, int memorybits, int event_memorybits, IntBuffer memoryused, long memoryused_, long memoryused_details);
	protected final static native int EventQueueEntry_release(long pointer);
	protected final static native int EventQueueEntry_getInfoOnlyEvent(long pointer, Event infoonlyevent);
	protected final static native int EventQueueEntry_getRealEvent(long pointer, Event realevent);
	protected final static native int EventQueueEntry_setPriority(long pointer, char priority);
	protected final static native int EventQueueEntry_getPriority(long pointer, ByteBuffer priority, long priority_);
	protected final static native int EventQueueEntry_setExpiryTime(long pointer, int expirytime);
	protected final static native int EventQueueEntry_getExpiryTime(long pointer, IntBuffer expirytime, long expirytime_);
	protected final static native int EventQueueEntry_setDelayTime(long pointer, int delay);
	protected final static native int EventQueueEntry_getDelayTime(long pointer, IntBuffer delay, long delay_);
	protected final static native int EventQueueEntry_setInterrupt(long pointer, boolean interrupt);
	protected final static native int EventQueueEntry_getInterrupt(long pointer, ByteBuffer interrupt, long interrupt_);
	protected final static native int EventQueueEntry_setCrossfadeTime(long pointer, int crossfade);
	protected final static native int EventQueueEntry_getCrossfadeTime(long pointer, IntBuffer crossfade, long crossfade_);
	protected final static native int EventQueueEntry_setUserData(long pointer, long userdata);
	protected final static native int EventQueueEntry_getUserData(long pointer, Pointer userdata);
	protected final static native int EventQueueEntry_getMemoryInfo(long pointer, int memorybits, int event_memorybits, IntBuffer memoryused, long memoryused_, long memoryused_details);
	protected final static native int EventReverb_release(long pointer);
	protected final static native int EventReverb_set3DAttributes(long pointer, long position, float mindistance, float maxdistance);
	protected final static native int EventReverb_get3DAttributes(long pointer, long position, FloatBuffer mindistance, long mindistance_, FloatBuffer maxdistance, long maxdistance_);
	protected final static native int EventReverb_setProperties(long pointer, long props);
	protected final static native int EventReverb_getProperties(long pointer, long props);
	protected final static native int EventReverb_setActive(long pointer, boolean active);
	protected final static native int EventReverb_getActive(long pointer, ByteBuffer active, long active_);
	protected final static native int EventReverb_setUserData(long pointer, long userdata);
	protected final static native int EventReverb_getUserData(long pointer, Pointer userdata);
	protected final static native int EventReverb_getMemoryInfo(long pointer, int memorybits, int event_memorybits, IntBuffer memoryused, long memoryused_, long memoryused_details);
	protected final static native int EventSystem_init(long pointer, int maxchannels, int flags, long extradriverdata, int eventflags);
	protected final static native int EventSystem_release(long pointer);
	protected final static native int EventSystem_update(long pointer);
	protected final static native int EventSystem_setMediaPath(long pointer, byte[] path);
	protected final static native int EventSystem_setPluginPath(long pointer, byte[] path);
	protected final static native int EventSystem_getVersion(long pointer, IntBuffer version, long version_);
	protected final static native int EventSystem_getInfo(long pointer, long info);
	protected final static native int EventSystem_getSystemObject(long pointer, System system);
	protected final static native int EventSystem_getMusicSystem(long pointer, MusicSystem musicsystem);
	protected final static native int EventSystem_load(long pointer, byte[] name_or_data, long loadinfo, EventProject project);
	protected final static native int EventSystem_load(long pointer, ByteBuffer name_or_data, long name_or_data_, long loadinfo, EventProject project);
	protected final static native int EventSystem_unload(long pointer);
	protected final static native int EventSystem_getProject(long pointer, byte[] name, EventProject project);
	protected final static native int EventSystem_getProjectByIndex(long pointer, int index, EventProject project);
	protected final static native int EventSystem_getNumProjects(long pointer, IntBuffer numprojects, long numprojects_);
	protected final static native int EventSystem_getCategory(long pointer, byte[] name, EventCategory category);
	protected final static native int EventSystem_getCategoryByIndex(long pointer, int index, EventCategory category);
	protected final static native int EventSystem_getMusicCategory(long pointer, EventCategory category);
	protected final static native int EventSystem_getNumCategories(long pointer, IntBuffer numcategories, long numcategories_);
	protected final static native int EventSystem_getGroup(long pointer, byte[] name, boolean cacheevents, EventGroup group);
	protected final static native int EventSystem_getEvent(long pointer, byte[] name, int mode, Event event);
	protected final static native int EventSystem_getEventBySystemID(long pointer, int systemid, int mode, Event event);
	protected final static native int EventSystem_getEventByGUID(long pointer, long guid, int mode, Event event);
	protected final static native int EventSystem_getEventByGUIDString(long pointer, byte[] guid, int mode, Event event);
	protected final static native int EventSystem_getNumEvents(long pointer, IntBuffer numevents, long numevents_);
	protected final static native int EventSystem_setReverbProperties(long pointer, long props);
	protected final static native int EventSystem_getReverbProperties(long pointer, long props);
	protected final static native int EventSystem_getReverbPreset(long pointer, byte[] name, long props, IntBuffer index, long index_);
	protected final static native int EventSystem_getReverbPresetByIndex(long pointer, int index, long props, Pointer name);
	protected final static native int EventSystem_getNumReverbPresets(long pointer, IntBuffer numpresets, long numpresets_);
	protected final static native int EventSystem_createReverb(long pointer, EventReverb reverb);
	protected final static native int EventSystem_setReverbAmbientProperties(long pointer, long props);
	protected final static native int EventSystem_getReverbAmbientProperties(long pointer, long props);
	protected final static native int EventSystem_createEventQueue(long pointer, EventQueue queue);
	protected final static native int EventSystem_createEventQueueEntry(long pointer, long event, EventQueueEntry entry);
	protected final static native int EventSystem_set3DNumListeners(long pointer, int numlisteners);
	protected final static native int EventSystem_get3DNumListeners(long pointer, IntBuffer numlisteners, long numlisteners_);
	protected final static native int EventSystem_set3DListenerAttributes(long pointer, int listener, long pos, long vel, long forward, long up);
	protected final static native int EventSystem_get3DListenerAttributes(long pointer, int listener, long pos, long vel, long forward, long up);
	protected final static native int EventSystem_setUserData(long pointer, long userdata);
	protected final static native int EventSystem_getUserData(long pointer, Pointer userdata);
	protected final static native int EventSystem_preloadFSB(long pointer, byte[] filename, int streaminstance, long sound);
	protected final static native int EventSystem_unloadFSB(long pointer, byte[] filename, int streaminstance);
	protected final static native int EventSystem_getMemoryInfo(long pointer, int memorybits, int event_memorybits, IntBuffer memoryused, long memoryused_, long memoryused_details);
	protected final static native int FmodDesigner_EventSystem_Create(EventSystem eventsystem);
	protected final static native int FmodDesigner_NetEventSystem_Init(long eventsystem, short port);
	protected final static native int FmodDesigner_NetEventSystem_Update();
	protected final static native int FmodDesigner_NetEventSystem_Shutdown();
	protected final static native int FmodDesigner_NetEventSystem_GetVersion(IntBuffer version, long version_);
	protected final static native int MusicPrompt_release(long pointer);
	protected final static native int MusicPrompt_begin(long pointer);
	protected final static native int MusicPrompt_end(long pointer);
	protected final static native int MusicPrompt_isActive(long pointer, ByteBuffer active, long active_);
	protected final static native int MusicPrompt_getMemoryInfo(long pointer, int memorybits, int event_memorybits, IntBuffer memoryused, long memoryused_, long memoryused_details);
	protected final static native int MusicSystem_SIZEOF();
	protected final static native long MusicSystem_newArray(int length);
	protected final static native int MusicSystem_reset(long pointer);
	protected final static native int MusicSystem_setVolume(long pointer, float volume);
	protected final static native int MusicSystem_getVolume(long pointer, FloatBuffer volume, long volume_);
	protected final static native int MusicSystem_setReverbProperties(long pointer, long props);
	protected final static native int MusicSystem_getReverbProperties(long pointer, long props);
	protected final static native int MusicSystem_setPaused(long pointer, boolean paused);
	protected final static native int MusicSystem_getPaused(long pointer, ByteBuffer paused, long paused_);
	protected final static native int MusicSystem_setMute(long pointer, boolean mute);
	protected final static native int MusicSystem_getMute(long pointer, ByteBuffer mute, long mute_);
	protected final static native int MusicSystem_getInfo(long pointer, long info);
	protected final static native int MusicSystem_promptCue(long pointer, int id);
	protected final static native int MusicSystem_prepareCue(long pointer, int id, MusicPrompt prompt);
	protected final static native int MusicSystem_getParameterValue(long pointer, int id, FloatBuffer parameter, long parameter_);
	protected final static native int MusicSystem_setParameterValue(long pointer, int id, float parameter);
	protected final static native int MusicSystem_getCues(long pointer, long it, byte[] filter);
	protected final static native int MusicSystem_getNextCue(long pointer, long it);
	protected final static native int MusicSystem_getParameters(long pointer, long it, byte[] filter);
	protected final static native int MusicSystem_getNextParameter(long pointer, long it);
	protected final static native int MusicSystem_loadSoundData(long pointer, int resource, int mode);
	protected final static native int MusicSystem_freeSoundData(long pointer, boolean waituntilready);
	protected final static native int MusicSystem_setCallback(long pointer, boolean callback, long userdata);
	protected final static native int MusicSystem_getMemoryInfo(long pointer, int memorybits, int event_memorybits, IntBuffer memoryused, long memoryused_, long memoryused_details);
}
