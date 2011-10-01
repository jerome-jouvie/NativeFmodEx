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

JNIEXPORT jlong JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventQueue_1newArray(JNIEnv *java_env, jclass jcls, jint length) {
	FMOD::EventQueue **array = new FMOD::EventQueue *[(int)length];
	if((int)length > 0) { CheckAllocation(java_env, array); }
	POINTER_TYPE jresult/* = 0*/;
	N2J_CAST_PTR(jresult, FMOD::EventQueue **) = array;
	return (jlong)jresult;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventQueue_1SIZEOF(JNIEnv *java_env, jclass jcls) {
	return (jint)sizeof(FMOD::EventQueue *);
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventQueue_1release(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventQueue *)->release();

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventQueue_1add(JNIEnv *java_env, jclass jcls, jlong jpointer, jlong jentry, jboolean jallow_duplicates) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD::EventQueueEntry *entry = 0;
	if(jentry) {
		POINTER_TYPE entryTmp = (POINTER_TYPE)jentry;
		entry = N2J_CAST_PTR(entryTmp, FMOD::EventQueueEntry *);
	}
	bool allow_duplicates = N2J_CAST_VAR(jallow_duplicates != 0, bool);

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventQueue *)->add(entry, allow_duplicates);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventQueue_1remove(JNIEnv *java_env, jclass jcls, jlong jpointer, jlong jentry) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD::EventQueueEntry *entry = 0;
	if(jentry) {
		POINTER_TYPE entryTmp = (POINTER_TYPE)jentry;
		entry = N2J_CAST_PTR(entryTmp, FMOD::EventQueueEntry *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventQueue *)->remove(entry);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventQueue_1removeHead(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventQueue *)->removeHead();

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventQueue_1clear(JNIEnv *java_env, jclass jcls, jlong jpointer, jboolean jstopallevents) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	bool stopallevents = N2J_CAST_VAR(jstopallevents != 0, bool);

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventQueue *)->clear(stopallevents);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventQueue_1findFirstEntry(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jentry) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD::EventQueueEntry *entry/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventQueue *)->findFirstEntry(&entry);

	if(jentry) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, FMOD::EventQueueEntry *) = entry;
		setPointerAddress(java_env, jentry, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventQueue_1findNextEntry(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jentry) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD::EventQueueEntry *entry/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventQueue *)->findNextEntry(&entry);

	if(jentry) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, FMOD::EventQueueEntry *) = entry;
		setPointerAddress(java_env, jentry, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventQueue_1setPaused(JNIEnv *java_env, jclass jcls, jlong jpointer, jboolean jpaused) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	bool paused = N2J_CAST_VAR(jpaused != 0, bool);

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventQueue *)->setPaused(paused);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventQueue_1getPaused(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jpaused, jlong jpaused_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	bool *paused = 0;
	if(jpaused) {
		paused = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jpaused), char *)+jpaused_, bool *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventQueue *)->getPaused(paused);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventQueue_1includeDuckingCategory(JNIEnv *java_env, jclass jcls, jlong jpointer, jlong jcategory, jfloat jducked_volume, jfloat junducked_volume, jint jduck_time, jint junduck_time) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD::EventCategory *category = 0;
	if(jcategory) {
		POINTER_TYPE categoryTmp = (POINTER_TYPE)jcategory;
		category = N2J_CAST_PTR(categoryTmp, FMOD::EventCategory *);
	}
	float ducked_volume = (float)jducked_volume;
	float unducked_volume = (float)junducked_volume;
	int duck_time = (int)jduck_time;
	int unduck_time = (int)junduck_time;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventQueue *)->includeDuckingCategory(category, ducked_volume, unducked_volume, duck_time, unduck_time);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventQueue_1excludeDuckingCategory(JNIEnv *java_env, jclass jcls, jlong jpointer, jlong jcategory) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD::EventCategory *category = 0;
	if(jcategory) {
		POINTER_TYPE categoryTmp = (POINTER_TYPE)jcategory;
		category = N2J_CAST_PTR(categoryTmp, FMOD::EventCategory *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventQueue *)->excludeDuckingCategory(category);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventQueue_1setCallback(JNIEnv *java_env, jclass jcls, jlong jpointer, jboolean jcallback, jlong jcallbackuserdata) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	POINTER_TYPE callbackuserdataTmp = (POINTER_TYPE)jcallbackuserdata;
	void *callbackuserdata = N2J_CAST_PTR(callbackuserdataTmp, void *);

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventQueue *)->setCallback(jcallback == 0 ? NULL : FMOD_EVENTQUEUE_CALLBACK_BRIDGE, callbackuserdata);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventQueue_1setUserData(JNIEnv *java_env, jclass jcls, jlong jpointer, jlong juserdata) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	POINTER_TYPE userdataTmp = (POINTER_TYPE)juserdata;
	void *userdata = N2J_CAST_PTR(userdataTmp, void *);

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventQueue *)->setUserData(userdata);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventQueue_1getUserData(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject juserdata) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	void *userdata/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventQueue *)->getUserData(&userdata);

	if(juserdata) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, void *) = userdata;
		setPointerAddress(java_env, juserdata, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventQueue_1dump(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventQueue *)->dump();

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventQueue_1getMemoryInfo(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jmemorybits, jint jevent_memorybits, jobject jmemoryused, jlong jmemoryused_, jlong jmemoryused_details) {
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

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventQueue *)->getMemoryInfo(memorybits, event_memorybits, memoryused, memoryused_details);

	return (jint)result_;
}


