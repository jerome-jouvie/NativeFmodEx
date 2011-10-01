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

JNIEXPORT jlong JNICALL Java_org_jouvieje_fmoddesigner_structures_StructureJNI_FMOD_1EVENT_1WAVEBANKINFO_1newArray(JNIEnv *java_env, jclass jcls, jint length) {
	FMOD_EVENT_WAVEBANKINFO *array = new FMOD_EVENT_WAVEBANKINFO[(int)length];
	if((int)length > 0) { CheckAllocation(java_env, array); }
	POINTER_TYPE jresult/* = 0*/;
	N2J_CAST_PTR(jresult, FMOD_EVENT_WAVEBANKINFO *) = array;
	return (jlong)jresult;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_structures_StructureJNI_FMOD_1EVENT_1WAVEBANKINFO_1SIZEOF(JNIEnv *java_env, jclass jcls) {
	return (jint)sizeof(FMOD_EVENT_WAVEBANKINFO);
}

JNIEXPORT jlong JNICALL Java_org_jouvieje_fmoddesigner_structures_StructureJNI_FMOD_1EVENT_1WAVEBANKINFO_1new(JNIEnv *java_env, jclass jcls) {
	FMOD_EVENT_WAVEBANKINFO *result_ = new FMOD_EVENT_WAVEBANKINFO();
	CheckAllocation(java_env, result_);
	POINTER_TYPE jresult/* = 0*/;
	N2J_CAST_PTR(jresult, FMOD_EVENT_WAVEBANKINFO *) = result_;
	return (jlong)jresult;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmoddesigner_structures_StructureJNI_FMOD_1EVENT_1WAVEBANKINFO_1delete(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	delete N2J_CAST_PTR(pointer, FMOD_EVENT_WAVEBANKINFO *);
}

JNIEXPORT jobject JNICALL Java_org_jouvieje_fmoddesigner_structures_StructureJNI_FMOD_1EVENT_1WAVEBANKINFO_1get_1name(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	char *result_ = (char *)N2J_CAST_PTR(pointer, FMOD_EVENT_WAVEBANKINFO *)->name;
	jobject jresult = 0;
	if(result_) {
		jresult = java_env->NewDirectByteBuffer((char *)result_, 256);
	}
	return jresult;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_structures_StructureJNI_FMOD_1EVENT_1WAVEBANKINFO_1get_1streamrefcnt(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int result_ = N2J_CAST_PTR(pointer, FMOD_EVENT_WAVEBANKINFO *)->streamrefcnt;
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_structures_StructureJNI_FMOD_1EVENT_1WAVEBANKINFO_1get_1samplerefcnt(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int result_ = N2J_CAST_PTR(pointer, FMOD_EVENT_WAVEBANKINFO *)->samplerefcnt;
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_structures_StructureJNI_FMOD_1EVENT_1WAVEBANKINFO_1get_1numstreams(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int result_ = N2J_CAST_PTR(pointer, FMOD_EVENT_WAVEBANKINFO *)->numstreams;
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_structures_StructureJNI_FMOD_1EVENT_1WAVEBANKINFO_1get_1maxstreams(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int result_ = N2J_CAST_PTR(pointer, FMOD_EVENT_WAVEBANKINFO *)->maxstreams;
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_structures_StructureJNI_FMOD_1EVENT_1WAVEBANKINFO_1get_1streamsinuse(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int result_ = N2J_CAST_PTR(pointer, FMOD_EVENT_WAVEBANKINFO *)->streamsinuse;
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_structures_StructureJNI_FMOD_1EVENT_1WAVEBANKINFO_1get_1streammemory(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int result_ = N2J_CAST_PTR(pointer, FMOD_EVENT_WAVEBANKINFO *)->streammemory;
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_structures_StructureJNI_FMOD_1EVENT_1WAVEBANKINFO_1get_1samplememory(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int result_ = N2J_CAST_PTR(pointer, FMOD_EVENT_WAVEBANKINFO *)->samplememory;
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_structures_StructureJNI_FMOD_1EVENT_1WAVEBANKINFO_1get_1type(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int result_ = N2J_CAST_PTR(pointer, FMOD_EVENT_WAVEBANKINFO *)->type;
	return (jint)result_;
}



