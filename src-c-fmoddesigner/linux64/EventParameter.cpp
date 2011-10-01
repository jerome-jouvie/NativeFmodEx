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

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventParameter_1getInfo(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jindex, jlong jindex_, jobject jname) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int *index = 0;
	if(jindex) {
		index = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jindex), char *)+jindex_, int *);
	}
	char *name/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventParameter *)->getInfo(index, &name);

	if(jname) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, char *) = name;
		setPointerAddress(java_env, jname, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventParameter_1getRange(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jrangemin, jlong jrangemin_, jobject jrangemax, jlong jrangemax_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float *rangemin = 0;
	if(jrangemin) {
		rangemin = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jrangemin), char *)+jrangemin_, float *);
	}
	float *rangemax = 0;
	if(jrangemax) {
		rangemax = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jrangemax), char *)+jrangemax_, float *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventParameter *)->getRange(rangemin, rangemax);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventParameter_1setValue(JNIEnv *java_env, jclass jcls, jlong jpointer, jfloat jvalue) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float value = (float)jvalue;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventParameter *)->setValue(value);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventParameter_1getValue(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jvalue, jlong jvalue_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float *value = 0;
	if(jvalue) {
		value = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jvalue), char *)+jvalue_, float *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventParameter *)->getValue(value);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventParameter_1setVelocity(JNIEnv *java_env, jclass jcls, jlong jpointer, jfloat jvalue) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float value = (float)jvalue;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventParameter *)->setVelocity(value);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventParameter_1getVelocity(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jvalue, jlong jvalue_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float *value = 0;
	if(jvalue) {
		value = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jvalue), char *)+jvalue_, float *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventParameter *)->getVelocity(value);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventParameter_1setSeekSpeed(JNIEnv *java_env, jclass jcls, jlong jpointer, jfloat jvalue) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float value = (float)jvalue;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventParameter *)->setSeekSpeed(value);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventParameter_1getSeekSpeed(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jvalue, jlong jvalue_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float *value = 0;
	if(jvalue) {
		value = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jvalue), char *)+jvalue_, float *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventParameter *)->getSeekSpeed(value);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventParameter_1setUserData(JNIEnv *java_env, jclass jcls, jlong jpointer, jlong juserdata) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	POINTER_TYPE userdataTmp = (POINTER_TYPE)juserdata;
	void *userdata = N2J_CAST_PTR(userdataTmp, void *);

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventParameter *)->setUserData(userdata);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventParameter_1getUserData(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject juserdata) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	void *userdata/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventParameter *)->getUserData(&userdata);

	if(juserdata) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, void *) = userdata;
		setPointerAddress(java_env, juserdata, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventParameter_1keyOff(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventParameter *)->keyOff();

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventParameter_1getMemoryInfo(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jmemorybits, jint jevent_memorybits, jobject jmemoryused, jlong jmemoryused_, jlong jmemoryused_details) {
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

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventParameter *)->getMemoryInfo(memorybits, event_memorybits, memoryused, memoryused_details);

	return (jint)result_;
}


