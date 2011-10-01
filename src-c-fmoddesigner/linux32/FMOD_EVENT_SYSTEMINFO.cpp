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

JNIEXPORT jlong JNICALL Java_org_jouvieje_fmoddesigner_structures_StructureJNI_FMOD_1EVENT_1SYSTEMINFO_1new(JNIEnv *java_env, jclass jcls) {
	FMOD_EVENT_SYSTEMINFO *result_ = new FMOD_EVENT_SYSTEMINFO();
	CheckAllocation(java_env, result_);
	POINTER_TYPE jresult/* = 0*/;
	N2J_CAST_PTR(jresult, FMOD_EVENT_SYSTEMINFO *) = result_;
	return (jlong)jresult;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmoddesigner_structures_StructureJNI_FMOD_1EVENT_1SYSTEMINFO_1delete(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	delete N2J_CAST_PTR(pointer, FMOD_EVENT_SYSTEMINFO *);
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_structures_StructureJNI_FMOD_1EVENT_1SYSTEMINFO_1get_1numevents(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int result_ = N2J_CAST_PTR(pointer, FMOD_EVENT_SYSTEMINFO *)->numevents;
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_structures_StructureJNI_FMOD_1EVENT_1SYSTEMINFO_1get_1numinstances(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int result_ = N2J_CAST_PTR(pointer, FMOD_EVENT_SYSTEMINFO *)->numinstances;
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_structures_StructureJNI_FMOD_1EVENT_1SYSTEMINFO_1get_1maxwavebanks(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int result_ = N2J_CAST_PTR(pointer, FMOD_EVENT_SYSTEMINFO *)->maxwavebanks;
	return (jint)result_;
}

JNIEXPORT jlong JNICALL Java_org_jouvieje_fmoddesigner_structures_StructureJNI_FMOD_1EVENT_1SYSTEMINFO_1get_1wavebankinfo(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	POINTER_TYPE jresult/* = 0*/;
	N2J_CAST_PTR(jresult, FMOD_EVENT_WAVEBANKINFO *) = N2J_CAST_PTR(pointer, FMOD_EVENT_SYSTEMINFO *)->wavebankinfo;
	return (jlong)jresult;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmoddesigner_structures_StructureJNI_FMOD_1EVENT_1SYSTEMINFO_1set_1wavebankinfo(JNIEnv *java_env, jclass jcls, jlong jpointer, jlong jwavebankinfo, jint wavebankinfoLen_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	POINTER_TYPE wavebankinfoTmp = (POINTER_TYPE)jwavebankinfo;
	N2J_CAST_PTR(pointer, FMOD_EVENT_SYSTEMINFO *)->wavebankinfo = N2J_CAST_PTR(wavebankinfoTmp, FMOD_EVENT_WAVEBANKINFO *);
#if 1
	N2J_CAST_PTR(pointer, FMOD_EVENT_SYSTEMINFO *)->maxwavebanks = wavebankinfoLen_;
#endif
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_structures_StructureJNI_FMOD_1EVENT_1SYSTEMINFO_1get_1numplayingevents(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int result_ = N2J_CAST_PTR(pointer, FMOD_EVENT_SYSTEMINFO *)->numplayingevents;
	return (jint)result_;
}

JNIEXPORT jobjectArray JNICALL Java_org_jouvieje_fmoddesigner_structures_StructureJNI_FMOD_1EVENT_1SYSTEMINFO_1get_1playingevents(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD_EVENT **playingevents = N2J_CAST_VAR(N2J_CAST_PTR(pointer, FMOD_EVENT_SYSTEMINFO *)->playingevents, FMOD_EVENT **);
	jobjectArray jplayingevents = 0;
	if(playingevents) {
		jsize jlength_ = N2J_CAST_VAR(N2J_CAST_VAR(N2J_CAST_PTR(pointer, FMOD_EVENT_SYSTEMINFO *)->numplayingevents, jint), jsize);
		if(jlength_ > 0) {
			jplayingevents = java_env->NewObjectArray(jlength_, getEventClass(java_env), 0);
			for(int i_ = 0; i_ < jlength_; i_++) {
				POINTER_TYPE address;
				N2J_CAST_PTR(address, FMOD_EVENT *) = playingevents[i_];
				java_env->SetObjectArrayElement(jplayingevents, i_, newEventObject(java_env, address));
			}
		}
	}
	return jplayingevents;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmoddesigner_structures_StructureJNI_FMOD_1EVENT_1SYSTEMINFO_1set_1playingevents(JNIEnv *java_env, jclass jcls, jlong jpointer, jobjectArray jplayingevents) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	{ //Memory deletion
		FMOD_EVENT ** playingeventsOld = N2J_CAST_PTR(pointer, FMOD_EVENT_SYSTEMINFO *)->playingevents;
		if(playingeventsOld) {
			delete[] playingeventsOld;
		}
	}
	FMOD_EVENT **playingevents = 0;
	int playingeventsLen_ = 0;
	if(jplayingevents) {
		playingeventsLen_ = java_env->GetArrayLength(jplayingevents);
		playingevents = new FMOD_EVENT *[playingeventsLen_];
		for(int i_ = 0; i_ < playingeventsLen_; i_++) {
			POINTER_TYPE jelementAddress = getPointerAddress(java_env, java_env->GetObjectArrayElement(jplayingevents, i_));
			playingevents[i_] = N2J_CAST_PTR(jelementAddress, FMOD_EVENT *);
		}
	}
	N2J_CAST_PTR(pointer, FMOD_EVENT_SYSTEMINFO *)->playingevents = (FMOD_EVENT **)playingevents;
#if 1
	N2J_CAST_PTR(pointer, FMOD_EVENT_SYSTEMINFO *)->numplayingevents = playingeventsLen_;
#endif
}



