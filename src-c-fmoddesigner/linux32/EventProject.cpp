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

#include "fmod_event.h"
#include "fmod_event_net.h"
#include "fmod_event.hpp"
#include "fmod_event_net.hpp"
#include "Utils.h"
#include "Pointer.h"
#include "NativeFmodDesigner.h"
#include "org_jouvieje_fmoddesigner_FmodDesignerJNI.h"
#include "CallbackManager.h"

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventProject_1release(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventProject *)->release();

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventProject_1getInfo(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jindex, jlong jindex_, jobject jname) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int *index = 0;
	if(jindex) {
		index = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jindex), char *)+jindex_, int *);
	}
	char *name/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventProject *)->getInfo(index, &name);

	if(jname) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, char *) = name;
		setPointerAddress(java_env, jname, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventProject_1getGroup(JNIEnv *java_env, jclass jcls, jlong jpointer, jbyteArray jname, jboolean jcacheevents, jobject jgroup) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	const char *name = (const char *)getByteArrayElements(java_env, jname);
	bool cacheevents = N2J_CAST_VAR(jcacheevents != 0, bool);
	FMOD::EventGroup *group/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventProject *)->getGroup(name, cacheevents, &group);

	releaseByteArrayElements(java_env, jname, (const char *)name);
	if(jgroup) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, FMOD::EventGroup *) = group;
		setPointerAddress(java_env, jgroup, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventProject_1getGroupByIndex(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jindex, jboolean jcacheevents, jobject jgroup) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int index = (int)jindex;
	bool cacheevents = N2J_CAST_VAR(jcacheevents != 0, bool);
	FMOD::EventGroup *group/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventProject *)->getGroupByIndex(index, cacheevents, &group);

	if(jgroup) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, FMOD::EventGroup *) = group;
		setPointerAddress(java_env, jgroup, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventProject_1getNumGroups(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jnumgroups, jlong jnumgroups_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int *numgroups = 0;
	if(jnumgroups) {
		numgroups = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jnumgroups), char *)+jnumgroups_, int *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventProject *)->getNumGroups(numgroups);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventProject_1getEvent(JNIEnv *java_env, jclass jcls, jlong jpointer, jbyteArray jname, jint jmode, jobject jevent) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	const char *name = (const char *)getByteArrayElements(java_env, jname);
	FMOD_EVENT_MODE mode = (FMOD_EVENT_MODE)jmode;
	FMOD::Event *event/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventProject *)->getEvent(name, mode, &event);

	releaseByteArrayElements(java_env, jname, (const char *)name);
	if(jevent) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, FMOD::Event *) = event;
		setPointerAddress(java_env, jevent, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventProject_1getEventByProjectID(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jprojectid, jint jmode, jobject jevent) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int projectid = (int)jprojectid;
	FMOD_EVENT_MODE mode = (FMOD_EVENT_MODE)jmode;
	FMOD::Event *event/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventProject *)->getEventByProjectID(projectid, mode, &event);

	if(jevent) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, FMOD::Event *) = event;
		setPointerAddress(java_env, jevent, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventProject_1getNumEvents(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jnumevents, jlong jnumevents_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int *numevents = 0;
	if(jnumevents) {
		numevents = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jnumevents), char *)+jnumevents_, int *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventProject *)->getNumEvents(numevents);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventProject_1loadSampleData(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jeventid_array, jlong jeventid_array_, jint jsizeof_eventid_array, jobject jgroupname_array, jint jsizeof_groupname_array, jint jeventmode) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int *eventid_array = 0;
	if(jeventid_array) {
		eventid_array = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jeventid_array), char *)+jeventid_array_, int *);
	}
	int sizeof_eventid_array = (int)jsizeof_eventid_array;
	char *groupname_array/* = 0*/;
	int sizeof_groupname_array = (int)jsizeof_groupname_array;
	FMOD_EVENT_MODE eventmode = (FMOD_EVENT_MODE)jeventmode;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventProject *)->loadSampleData(eventid_array, sizeof_eventid_array, &groupname_array, sizeof_groupname_array, eventmode);

	if(jgroupname_array) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, char *) = groupname_array;
		setPointerAddress(java_env, jgroupname_array, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventProject_1setUserData(JNIEnv *java_env, jclass jcls, jlong jpointer, jlong juserdata) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	POINTER_TYPE userdataTmp = (POINTER_TYPE)juserdata;
	void *userdata = N2J_CAST_PTR(userdataTmp, void *);

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventProject *)->setUserData(userdata);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventProject_1getUserData(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject juserdata) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	void *userdata/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventProject *)->getUserData(&userdata);

	if(juserdata) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, void *) = userdata;
		setPointerAddress(java_env, juserdata, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventProject_1stopAllEvents(JNIEnv *java_env, jclass jcls, jlong jpointer, jboolean jimmediate) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	bool immediate = N2J_CAST_VAR(jimmediate != 0, bool);

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventProject *)->stopAllEvents(immediate);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventProject_1getMemoryInfo(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jmemorybits, jint jevent_memorybits, jobject jmemoryused, jlong jmemoryused_, jlong jmemoryused_details) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int memorybits = (int)jmemorybits;
	int event_memorybits = (int)jevent_memorybits;
	unsigned int *memoryused = 0;
	if(jmemoryused) {
		memoryused = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jmemoryused), char *)+jmemoryused_, unsigned int *);
	}
	FMOD_MEMORY_USAGE_DETAILS *memoryused_details = 0;
	if(jmemoryused_details) {
		POINTER_TYPE memoryused_detailsTmp = (POINTER_TYPE)jmemoryused_details;
		memoryused_details = N2J_CAST_PTR(memoryused_detailsTmp, FMOD_MEMORY_USAGE_DETAILS *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventProject *)->getMemoryInfo(memorybits, event_memorybits, memoryused, memoryused_details);

	return (jint)result_;
}


