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

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventGroup_1getInfo(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jindex, jlong jindex_, jobject jname) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int *index = 0;
	if(jindex) {
		index = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jindex), char *)+jindex_, int *);
	}
	char *name/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventGroup *)->getInfo(index, &name);

	if(jname) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, char *) = name;
		setPointerAddress(java_env, jname, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventGroup_1loadEventData(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jresource, jint jmode) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD_EVENT_RESOURCE resource = (FMOD_EVENT_RESOURCE)jresource;
	FMOD_EVENT_MODE mode = (FMOD_EVENT_MODE)jmode;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventGroup *)->loadEventData(resource, mode);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventGroup_1freeEventData(JNIEnv *java_env, jclass jcls, jlong jpointer, jlong jevent, jboolean jwaituntilready) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD::Event *event = 0;
	if(jevent) {
		POINTER_TYPE eventTmp = (POINTER_TYPE)jevent;
		event = N2J_CAST_PTR(eventTmp, FMOD::Event *);
	}
	bool waituntilready = N2J_CAST_VAR(jwaituntilready != 0, bool);

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventGroup *)->freeEventData(event, waituntilready);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventGroup_1getGroup(JNIEnv *java_env, jclass jcls, jlong jpointer, jbyteArray jname, jboolean jcacheevents, jobject jgroup) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	const char *name = (const char *)getByteArrayElements(java_env, jname);
	bool cacheevents = N2J_CAST_VAR(jcacheevents != 0, bool);
	FMOD::EventGroup *group/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventGroup *)->getGroup(name, cacheevents, &group);

	releaseByteArrayElements(java_env, jname, (const char *)name);
	if(jgroup) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, FMOD::EventGroup *) = group;
		setPointerAddress(java_env, jgroup, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventGroup_1getGroupByIndex(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jindex, jboolean jcacheevents, jobject jgroup) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int index = (int)jindex;
	bool cacheevents = N2J_CAST_VAR(jcacheevents != 0, bool);
	FMOD::EventGroup *group/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventGroup *)->getGroupByIndex(index, cacheevents, &group);

	if(jgroup) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, FMOD::EventGroup *) = group;
		setPointerAddress(java_env, jgroup, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventGroup_1getParentGroup(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jgroup) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD::EventGroup *group/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventGroup *)->getParentGroup(&group);

	if(jgroup) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, FMOD::EventGroup *) = group;
		setPointerAddress(java_env, jgroup, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventGroup_1getParentProject(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jproject) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD::EventProject *project/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventGroup *)->getParentProject(&project);

	if(jproject) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, FMOD::EventProject *) = project;
		setPointerAddress(java_env, jproject, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventGroup_1getNumGroups(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jnumgroups, jlong jnumgroups_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int *numgroups = 0;
	if(jnumgroups) {
		numgroups = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jnumgroups), char *)+jnumgroups_, int *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventGroup *)->getNumGroups(numgroups);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventGroup_1getEvent(JNIEnv *java_env, jclass jcls, jlong jpointer, jbyteArray jname, jint jmode, jobject jevent) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	const char *name = (const char *)getByteArrayElements(java_env, jname);
	FMOD_EVENT_MODE mode = (FMOD_EVENT_MODE)jmode;
	FMOD::Event *event/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventGroup *)->getEvent(name, mode, &event);

	releaseByteArrayElements(java_env, jname, (const char *)name);
	if(jevent) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, FMOD::Event *) = event;
		setPointerAddress(java_env, jevent, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventGroup_1getEventByIndex(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jindex, jint jmode, jobject jevent) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int index = (int)jindex;
	FMOD_EVENT_MODE mode = (FMOD_EVENT_MODE)jmode;
	FMOD::Event *event/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventGroup *)->getEventByIndex(index, mode, &event);

	if(jevent) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, FMOD::Event *) = event;
		setPointerAddress(java_env, jevent, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventGroup_1getNumEvents(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jnumevents, jlong jnumevents_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int *numevents = 0;
	if(jnumevents) {
		numevents = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jnumevents), char *)+jnumevents_, int *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventGroup *)->getNumEvents(numevents);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventGroup_1getProperty(JNIEnv *java_env, jclass jcls, jlong jpointer, jbyteArray jpropertyname, jlong jvalue) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	const char *propertyname = (const char *)getByteArrayElements(java_env, jpropertyname);
	POINTER_TYPE valueTmp = (POINTER_TYPE)jvalue;
	void *value = N2J_CAST_PTR(valueTmp, void *);

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventGroup *)->getProperty(propertyname, value);

	releaseByteArrayElements(java_env, jpropertyname, (const char *)propertyname);
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventGroup_1getPropertyByIndex(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jpropertyindex, jlong jvalue) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int propertyindex = (int)jpropertyindex;
	POINTER_TYPE valueTmp = (POINTER_TYPE)jvalue;
	void *value = N2J_CAST_PTR(valueTmp, void *);

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventGroup *)->getPropertyByIndex(propertyindex, value);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventGroup_1getNumProperties(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jnumproperties, jlong jnumproperties_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int *numproperties = 0;
	if(jnumproperties) {
		numproperties = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jnumproperties), char *)+jnumproperties_, int *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventGroup *)->getNumProperties(numproperties);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventGroup_1getState(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jstate, jlong jstate_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD_EVENT_STATE *state = 0;
	if(jstate) {
		state = N2J_CAST_VAR(N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jstate), char *)+jstate_, int *), FMOD_EVENT_STATE *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventGroup *)->getState(state);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventGroup_1setUserData(JNIEnv *java_env, jclass jcls, jlong jpointer, jlong juserdata) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	POINTER_TYPE userdataTmp = (POINTER_TYPE)juserdata;
	void *userdata = N2J_CAST_PTR(userdataTmp, void *);

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventGroup *)->setUserData(userdata);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventGroup_1getUserData(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject juserdata) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	void *userdata/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventGroup *)->getUserData(&userdata);

	if(juserdata) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, void *) = userdata;
		setPointerAddress(java_env, juserdata, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventGroup_1getMemoryInfo(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jmemorybits, jint jevent_memorybits, jobject jmemoryused, jlong jmemoryused_, jlong jmemoryused_details) {
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

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventGroup *)->getMemoryInfo(memorybits, event_memorybits, memoryused, memoryused_details);

	return (jint)result_;
}


