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

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_SoundGroup_1release(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::SoundGroup *)->release();

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_SoundGroup_1getSystemObject(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jsystem) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD::System *system/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::SoundGroup *)->getSystemObject(&system);

	if(jsystem) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, FMOD::System *) = system;
		setPointerAddress(java_env, jsystem, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_SoundGroup_1setMaxAudible(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jmaxaudible) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int maxaudible = (int)jmaxaudible;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::SoundGroup *)->setMaxAudible(maxaudible);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_SoundGroup_1getMaxAudible(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jmaxaudible, jlong jmaxaudible_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int *maxaudible = 0;
	if(jmaxaudible) {
		maxaudible = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jmaxaudible), char *)+jmaxaudible_, int *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::SoundGroup *)->getMaxAudible(maxaudible);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_SoundGroup_1setMaxAudibleBehavior(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jbehavior) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD_SOUNDGROUP_BEHAVIOR behavior = (FMOD_SOUNDGROUP_BEHAVIOR)jbehavior;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::SoundGroup *)->setMaxAudibleBehavior(behavior);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_SoundGroup_1getMaxAudibleBehavior(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jbehaviorPointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD_SOUNDGROUP_BEHAVIOR behavior;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::SoundGroup *)->getMaxAudibleBehavior(&behavior);

	if(jbehaviorPointer) {
		int *behaviorPointer = (int *)java_env->GetDirectBufferAddress(jbehaviorPointer);
		behaviorPointer[0] = behavior;
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_SoundGroup_1setMuteFadeSpeed(JNIEnv *java_env, jclass jcls, jlong jpointer, jfloat jspeed) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float speed = (float)jspeed;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::SoundGroup *)->setMuteFadeSpeed(speed);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_SoundGroup_1getMuteFadeSpeed(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jspeed, jlong jspeed_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float *speed = 0;
	if(jspeed) {
		speed = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jspeed), char *)+jspeed_, float *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::SoundGroup *)->getMuteFadeSpeed(speed);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_SoundGroup_1setVolume(JNIEnv *java_env, jclass jcls, jlong jpointer, jfloat jvolume) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float volume = (float)jvolume;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::SoundGroup *)->setVolume(volume);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_SoundGroup_1getVolume(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jvolume, jlong jvolume_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float *volume = 0;
	if(jvolume) {
		volume = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jvolume), char *)+jvolume_, float *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::SoundGroup *)->getVolume(volume);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_SoundGroup_1stop(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::SoundGroup *)->stop();

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_SoundGroup_1getName(JNIEnv *java_env, jclass jcls, jlong jpointer, 	jobject jname, jlong jname_, jint jnamelen) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	char *name = 0;
	if(jname) {
		name = N2J_CAST_VAR(java_env->GetDirectBufferAddress(jname), char *)+jname_;
	}
	int namelen = (int)jnamelen;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::SoundGroup *)->getName(name, namelen);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_SoundGroup_1getNumSounds(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jnumsounds, jlong jnumsounds_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int *numsounds = 0;
	if(jnumsounds) {
		numsounds = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jnumsounds), char *)+jnumsounds_, int *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::SoundGroup *)->getNumSounds(numsounds);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_SoundGroup_1getSound(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jindex, jobject jsound) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int index = (int)jindex;
	FMOD::Sound *sound/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::SoundGroup *)->getSound(index, &sound);

	if(jsound) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, FMOD::Sound *) = sound;
		setPointerAddress(java_env, jsound, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_SoundGroup_1getNumPlaying(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jnumplaying, jlong jnumplaying_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int *numplaying = 0;
	if(jnumplaying) {
		numplaying = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jnumplaying), char *)+jnumplaying_, int *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::SoundGroup *)->getNumPlaying(numplaying);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_SoundGroup_1setUserData(JNIEnv *java_env, jclass jcls, jlong jpointer, jlong juserdata) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	POINTER_TYPE userdataTmp = (POINTER_TYPE)juserdata;
	void *userdata = N2J_CAST_PTR(userdataTmp, void *);

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::SoundGroup *)->setUserData(userdata);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_SoundGroup_1getUserData(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject juserdata) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	void *userdata/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::SoundGroup *)->getUserData(&userdata);

	if(juserdata) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, void *) = userdata;
		setPointerAddress(java_env, juserdata, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_SoundGroup_1getMemoryInfo(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jmemorybits, jint jevent_memorybits, jobject jmemoryused, jlong jmemoryused_, jlong jmemoryused_details) {
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

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::SoundGroup *)->getMemoryInfo(memorybits, event_memorybits, memoryused, memoryused_details);

	return (jint)result_;
}


