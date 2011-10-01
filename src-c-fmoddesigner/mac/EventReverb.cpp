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

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventReverb_1release(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventReverb *)->release();

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventReverb_1set3DAttributes(JNIEnv *java_env, jclass jcls, jlong jpointer, jlong jposition, jfloat jmindistance, jfloat jmaxdistance) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD_VECTOR *position = 0;
	if(jposition) {
		POINTER_TYPE positionTmp = (POINTER_TYPE)jposition;
		position = N2J_CAST_PTR(positionTmp, FMOD_VECTOR *);
	}
	float mindistance = (float)jmindistance;
	float maxdistance = (float)jmaxdistance;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventReverb *)->set3DAttributes(position, mindistance, maxdistance);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventReverb_1get3DAttributes(JNIEnv *java_env, jclass jcls, jlong jpointer, jlong jposition, jobject jmindistance, jlong jmindistance_, jobject jmaxdistance, jlong jmaxdistance_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD_VECTOR *position = 0;
	if(jposition) {
		POINTER_TYPE positionTmp = (POINTER_TYPE)jposition;
		position = N2J_CAST_PTR(positionTmp, FMOD_VECTOR *);
	}
	float *mindistance = 0;
	if(jmindistance) {
		mindistance = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jmindistance), char *)+jmindistance_, float *);
	}
	float *maxdistance = 0;
	if(jmaxdistance) {
		maxdistance = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jmaxdistance), char *)+jmaxdistance_, float *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventReverb *)->get3DAttributes(position, mindistance, maxdistance);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventReverb_1setProperties(JNIEnv *java_env, jclass jcls, jlong jpointer, jlong jprops) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD_REVERB_PROPERTIES *props = 0;
	if(jprops) {
		POINTER_TYPE propsTmp = (POINTER_TYPE)jprops;
		props = N2J_CAST_PTR(propsTmp, FMOD_REVERB_PROPERTIES *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventReverb *)->setProperties(props);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventReverb_1getProperties(JNIEnv *java_env, jclass jcls, jlong jpointer, jlong jprops) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD_REVERB_PROPERTIES *props = 0;
	if(jprops) {
		POINTER_TYPE propsTmp = (POINTER_TYPE)jprops;
		props = N2J_CAST_PTR(propsTmp, FMOD_REVERB_PROPERTIES *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventReverb *)->getProperties(props);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventReverb_1setActive(JNIEnv *java_env, jclass jcls, jlong jpointer, jboolean jactive) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	bool active = N2J_CAST_VAR(jactive != 0, bool);

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventReverb *)->setActive(active);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventReverb_1getActive(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jactive, jlong jactive_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	bool *active = 0;
	if(jactive) {
		active = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jactive), char *)+jactive_, bool *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventReverb *)->getActive(active);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventReverb_1setUserData(JNIEnv *java_env, jclass jcls, jlong jpointer, jlong juserdata) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	POINTER_TYPE userdataTmp = (POINTER_TYPE)juserdata;
	void *userdata = N2J_CAST_PTR(userdataTmp, void *);

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventReverb *)->setUserData(userdata);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventReverb_1getUserData(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject juserdata) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	void *userdata/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventReverb *)->getUserData(&userdata);

	if(juserdata) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, void *) = userdata;
		setPointerAddress(java_env, juserdata, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventReverb_1getMemoryInfo(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jmemorybits, jint jevent_memorybits, jobject jmemoryused, jlong jmemoryused_, jlong jmemoryused_details) {
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

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventReverb *)->getMemoryInfo(memorybits, event_memorybits, memoryused, memoryused_details);

	return (jint)result_;
}


