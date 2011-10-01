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
#include "org_jouvieje_fmoddesigner_structures_StructureJNI.h"
#include "CallbackManager.h"

JNIEXPORT jlong JNICALL Java_org_jouvieje_fmoddesigner_structures_StructureJNI_FMOD_1EVENT_1INFO_1new(JNIEnv *java_env, jclass jcls) {
	FMOD_EVENT_INFO *result_ = new FMOD_EVENT_INFO();
	CheckAllocation(java_env, result_);
	POINTER_TYPE jresult/* = 0*/;
	N2J_CAST_PTR(jresult, FMOD_EVENT_INFO *) = result_;
	return (jlong)jresult;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmoddesigner_structures_StructureJNI_FMOD_1EVENT_1INFO_1delete(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	delete N2J_CAST_PTR(pointer, FMOD_EVENT_INFO *);
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_structures_StructureJNI_FMOD_1EVENT_1INFO_1get_1memoryused(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int result_ = N2J_CAST_PTR(pointer, FMOD_EVENT_INFO *)->memoryused;
	return (jint)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmoddesigner_structures_StructureJNI_FMOD_1EVENT_1INFO_1set_1memoryused(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jmemoryused) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int memoryused = (int)jmemoryused;
	N2J_CAST_PTR(pointer, FMOD_EVENT_INFO *)->memoryused = memoryused;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_structures_StructureJNI_FMOD_1EVENT_1INFO_1get_1positionms(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int result_ = N2J_CAST_PTR(pointer, FMOD_EVENT_INFO *)->positionms;
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_structures_StructureJNI_FMOD_1EVENT_1INFO_1get_1lengthms(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int result_ = N2J_CAST_PTR(pointer, FMOD_EVENT_INFO *)->lengthms;
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_structures_StructureJNI_FMOD_1EVENT_1INFO_1get_1channelsplaying(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int result_ = N2J_CAST_PTR(pointer, FMOD_EVENT_INFO *)->channelsplaying;
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_structures_StructureJNI_FMOD_1EVENT_1INFO_1get_1instancesactive(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int result_ = N2J_CAST_PTR(pointer, FMOD_EVENT_INFO *)->instancesactive;
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_structures_StructureJNI_FMOD_1EVENT_1INFO_1get_1maxwavebanks(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int result_ = N2J_CAST_PTR(pointer, FMOD_EVENT_INFO *)->maxwavebanks;
	return (jint)result_;
}

JNIEXPORT jlong JNICALL Java_org_jouvieje_fmoddesigner_structures_StructureJNI_FMOD_1EVENT_1INFO_1get_1wavebankinfo(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	POINTER_TYPE jresult/* = 0*/;
	N2J_CAST_PTR(jresult, FMOD_EVENT_WAVEBANKINFO *) = N2J_CAST_PTR(pointer, FMOD_EVENT_INFO *)->wavebankinfo;
	return (jlong)jresult;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmoddesigner_structures_StructureJNI_FMOD_1EVENT_1INFO_1set_1wavebankinfo(JNIEnv *java_env, jclass jcls, jlong jpointer, jlong jwavebankinfo, jint wavebankinfoLen_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	POINTER_TYPE wavebankinfoTmp = (POINTER_TYPE)jwavebankinfo;
	N2J_CAST_PTR(pointer, FMOD_EVENT_INFO *)->wavebankinfo = N2J_CAST_PTR(wavebankinfoTmp, FMOD_EVENT_WAVEBANKINFO *);
#if 1
	N2J_CAST_PTR(pointer, FMOD_EVENT_INFO *)->maxwavebanks = wavebankinfoLen_;
#endif
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_structures_StructureJNI_FMOD_1EVENT_1INFO_1get_1projectid(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int result_ = N2J_CAST_PTR(pointer, FMOD_EVENT_INFO *)->projectid;
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_structures_StructureJNI_FMOD_1EVENT_1INFO_1get_1systemid(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int result_ = N2J_CAST_PTR(pointer, FMOD_EVENT_INFO *)->systemid;
	return (jint)result_;
}

JNIEXPORT jfloat JNICALL Java_org_jouvieje_fmoddesigner_structures_StructureJNI_FMOD_1EVENT_1INFO_1get_1audibility(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float result_ = N2J_CAST_PTR(pointer, FMOD_EVENT_INFO *)->audibility;
	return (jfloat)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_structures_StructureJNI_FMOD_1EVENT_1INFO_1get_1numinstances(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int result_ = N2J_CAST_PTR(pointer, FMOD_EVENT_INFO *)->numinstances;
	return (jint)result_;
}

JNIEXPORT jobjectArray JNICALL Java_org_jouvieje_fmoddesigner_structures_StructureJNI_FMOD_1EVENT_1INFO_1get_1instances(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD_EVENT **instances = N2J_CAST_VAR(N2J_CAST_PTR(pointer, FMOD_EVENT_INFO *)->instances, FMOD_EVENT **);
	jobjectArray jinstances = 0;
	if(instances) {
		jsize jlength_ = N2J_CAST_VAR(N2J_CAST_VAR(N2J_CAST_PTR(pointer, FMOD_EVENT_INFO *)->numinstances, jint), jsize);
		if(jlength_ > 0) {
			jinstances = java_env->NewObjectArray(jlength_, getEventClass(java_env), 0);
			for(int i_ = 0; i_ < jlength_; i_++) {
				POINTER_TYPE address;
				N2J_CAST_PTR(address, FMOD_EVENT *) = instances[i_];
				java_env->SetObjectArrayElement(jinstances, i_, newEventObject(java_env, address));
			}
		}
	}
	return jinstances;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmoddesigner_structures_StructureJNI_FMOD_1EVENT_1INFO_1set_1instances(JNIEnv *java_env, jclass jcls, jlong jpointer, jobjectArray jinstances) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	{ //Memory deletion
		FMOD_EVENT ** instancesOld = N2J_CAST_PTR(pointer, FMOD_EVENT_INFO *)->instances;
		if(instancesOld) {
			delete[] instancesOld;
		}
	}
	FMOD_EVENT **instances = 0;
	int instancesLen_ = 0;
	if(jinstances) {
		instancesLen_ = java_env->GetArrayLength(jinstances);
		instances = new FMOD_EVENT *[instancesLen_];
		for(int i_ = 0; i_ < instancesLen_; i_++) {
			POINTER_TYPE jelementAddress = getPointerAddress(java_env, java_env->GetObjectArrayElement(jinstances, i_));
			instances[i_] = N2J_CAST_PTR(jelementAddress, FMOD_EVENT *);
		}
	}
	N2J_CAST_PTR(pointer, FMOD_EVENT_INFO *)->instances = (FMOD_EVENT **)instances;
#if 1
	N2J_CAST_PTR(pointer, FMOD_EVENT_INFO *)->numinstances = instancesLen_;
#endif
}

JNIEXPORT jlong JNICALL Java_org_jouvieje_fmoddesigner_structures_StructureJNI_FMOD_1EVENT_1INFO_1get_1guid(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	POINTER_TYPE jresult/* = 0*/;
	N2J_CAST_PTR(jresult, FMOD_GUID *) = N2J_CAST_PTR(pointer, FMOD_EVENT_INFO *)->guid;
	return (jlong)jresult;
}



