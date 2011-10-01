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

#include "fmod_errors.h"
#include "fmod_memoryinfo.h"
#include "fmod.h"
#include "fmod_codec.h"
#include "fmod_dsp.h"
#include "fmod_output.h"
#include "fmod.hpp"
#include "Utils.h"
#include "Pointer.h"
#include "NativeFmodEx.h"
#include "org_jouvieje_fmodex_FmodExJNI.h"
#include "CallbackManager.h"

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_DSPConnection_1getInput(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jinput) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD::DSP *input/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::DSPConnection *)->getInput(&input);

	if(jinput) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, FMOD::DSP *) = input;
		setPointerAddress(java_env, jinput, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_DSPConnection_1getOutput(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject joutput) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD::DSP *output/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::DSPConnection *)->getOutput(&output);

	if(joutput) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, FMOD::DSP *) = output;
		setPointerAddress(java_env, joutput, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_DSPConnection_1setMix(JNIEnv *java_env, jclass jcls, jlong jpointer, jfloat jvolume) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float volume = (float)jvolume;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::DSPConnection *)->setMix(volume);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_DSPConnection_1getMix(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jvolume, jlong jvolume_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float *volume = 0;
	if(jvolume) {
		volume = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jvolume), char *)+jvolume_, float *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::DSPConnection *)->getMix(volume);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_DSPConnection_1setLevels(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jspeaker, jobject jlevels, jlong jlevels_, jint jnumlevels) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD_SPEAKER speaker = (FMOD_SPEAKER)jspeaker;
	float *levels = 0;
	if(jlevels) {
		levels = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jlevels), char *)+jlevels_, float *);
	}
	int numlevels = (int)jnumlevels;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::DSPConnection *)->setLevels(speaker, levels, numlevels);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_DSPConnection_1getLevels(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jspeaker, jobject jlevels, jlong jlevels_, jint jnumlevels) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD_SPEAKER speaker = (FMOD_SPEAKER)jspeaker;
	float *levels = 0;
	if(jlevels) {
		levels = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jlevels), char *)+jlevels_, float *);
	}
	int numlevels = (int)jnumlevels;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::DSPConnection *)->getLevels(speaker, levels, numlevels);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_DSPConnection_1setUserData(JNIEnv *java_env, jclass jcls, jlong jpointer, jlong juserdata) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	POINTER_TYPE userdataTmp = (POINTER_TYPE)juserdata;
	void *userdata = N2J_CAST_PTR(userdataTmp, void *);

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::DSPConnection *)->setUserData(userdata);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_DSPConnection_1getUserData(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject juserdata) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	void *userdata/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::DSPConnection *)->getUserData(&userdata);

	if(juserdata) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, void *) = userdata;
		setPointerAddress(java_env, juserdata, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_DSPConnection_1getMemoryInfo(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jmemorybits, jint jevent_memorybits, jobject jmemoryused, jlong jmemoryused_, jlong jmemoryused_details) {
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

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::DSPConnection *)->getMemoryInfo(memorybits, event_memorybits, memoryused, memoryused_details);

	return (jint)result_;
}


