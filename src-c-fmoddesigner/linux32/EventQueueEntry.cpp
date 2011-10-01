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

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventQueueEntry_1release(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventQueueEntry *)->release();

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventQueueEntry_1getInfoOnlyEvent(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jinfoonlyevent) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD::Event *infoonlyevent/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventQueueEntry *)->getInfoOnlyEvent(&infoonlyevent);

	if(jinfoonlyevent) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, FMOD::Event *) = infoonlyevent;
		setPointerAddress(java_env, jinfoonlyevent, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventQueueEntry_1getRealEvent(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jrealevent) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD::Event *realevent/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventQueueEntry *)->getRealEvent(&realevent);

	if(jrealevent) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, FMOD::Event *) = realevent;
		setPointerAddress(java_env, jrealevent, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventQueueEntry_1setPriority(JNIEnv *java_env, jclass jcls, jlong jpointer, jchar jpriority) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	char priority = (char)jpriority;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventQueueEntry *)->setPriority(priority);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventQueueEntry_1getPriority(JNIEnv *java_env, jclass jcls, jlong jpointer, 	jobject jpriority, jlong jpriority_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	unsigned char *priority = 0;
	if(jpriority) {
		priority = N2J_CAST_VAR(java_env->GetDirectBufferAddress(jpriority), unsigned char *)+jpriority_;
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventQueueEntry *)->getPriority(priority);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventQueueEntry_1setExpiryTime(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jexpirytime) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int expirytime = (int)jexpirytime;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventQueueEntry *)->setExpiryTime(expirytime);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventQueueEntry_1getExpiryTime(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jexpirytime, jlong jexpirytime_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	unsigned int *expirytime = 0;
	if(jexpirytime) {
		expirytime = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jexpirytime), char *)+jexpirytime_, unsigned int *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventQueueEntry *)->getExpiryTime(expirytime);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventQueueEntry_1setDelayTime(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jdelay) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int delay = (int)jdelay;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventQueueEntry *)->setDelayTime(delay);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventQueueEntry_1getDelayTime(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jdelay, jlong jdelay_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	unsigned int *delay = 0;
	if(jdelay) {
		delay = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jdelay), char *)+jdelay_, unsigned int *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventQueueEntry *)->getDelayTime(delay);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventQueueEntry_1setInterrupt(JNIEnv *java_env, jclass jcls, jlong jpointer, jboolean jinterrupt) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	bool interrupt = N2J_CAST_VAR(jinterrupt != 0, bool);

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventQueueEntry *)->setInterrupt(interrupt);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventQueueEntry_1getInterrupt(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jinterrupt, jlong jinterrupt_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	bool *interrupt = 0;
	if(jinterrupt) {
		interrupt = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jinterrupt), char *)+jinterrupt_, bool *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventQueueEntry *)->getInterrupt(interrupt);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventQueueEntry_1setCrossfadeTime(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jcrossfade) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int crossfade = (int)jcrossfade;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventQueueEntry *)->setCrossfadeTime(crossfade);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventQueueEntry_1getCrossfadeTime(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jcrossfade, jlong jcrossfade_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int *crossfade = 0;
	if(jcrossfade) {
		crossfade = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jcrossfade), char *)+jcrossfade_, int *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventQueueEntry *)->getCrossfadeTime(crossfade);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventQueueEntry_1setUserData(JNIEnv *java_env, jclass jcls, jlong jpointer, jlong juserdata) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	POINTER_TYPE userdataTmp = (POINTER_TYPE)juserdata;
	void *userdata = N2J_CAST_PTR(userdataTmp, void *);

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventQueueEntry *)->setUserData(userdata);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventQueueEntry_1getUserData(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject juserdata) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	void *userdata/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventQueueEntry *)->getUserData(&userdata);

	if(juserdata) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, void *) = userdata;
		setPointerAddress(java_env, juserdata, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventQueueEntry_1getMemoryInfo(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jmemorybits, jint jevent_memorybits, jobject jmemoryused, jlong jmemoryused_, jlong jmemoryused_details) {
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

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventQueueEntry *)->getMemoryInfo(memorybits, event_memorybits, memoryused, memoryused_details);

	return (jint)result_;
}


