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

JNIEXPORT jlong JNICALL Java_org_jouvieje_fmoddesigner_structures_StructureJNI_FMOD_1EVENT_1LOADINFO_1new(JNIEnv *java_env, jclass jcls) {
	FMOD_EVENT_LOADINFO *result_ = new FMOD_EVENT_LOADINFO();
	CheckAllocation(java_env, result_);
	result_->size = sizeof(FMOD_EVENT_LOADINFO);
	POINTER_TYPE jresult/* = 0*/;
	N2J_CAST_PTR(jresult, FMOD_EVENT_LOADINFO *) = result_;
	return (jlong)jresult;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmoddesigner_structures_StructureJNI_FMOD_1EVENT_1LOADINFO_1delete(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	delete N2J_CAST_PTR(pointer, FMOD_EVENT_LOADINFO *);
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_structures_StructureJNI_FMOD_1EVENT_1LOADINFO_1get_1size(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int result_ = N2J_CAST_PTR(pointer, FMOD_EVENT_LOADINFO *)->size;
	return (jint)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmoddesigner_structures_StructureJNI_FMOD_1EVENT_1LOADINFO_1set_1size(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jsize) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int size = (int)jsize;
	N2J_CAST_PTR(pointer, FMOD_EVENT_LOADINFO *)->size = size;
}

JNIEXPORT jstring JNICALL Java_org_jouvieje_fmoddesigner_structures_StructureJNI_FMOD_1EVENT_1LOADINFO_1get_1encryptionkey(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	char *result_ = N2J_CAST_VAR(N2J_CAST_PTR(pointer, FMOD_EVENT_LOADINFO *)->encryptionkey, char *);
	jstring jresult = 0;
	if(result_) {
		jresult = java_env->NewStringUTF((const char *)result_);
	}
	return jresult;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmoddesigner_structures_StructureJNI_FMOD_1EVENT_1LOADINFO_1set_1encryptionkey(JNIEnv *java_env, jclass jcls, jlong jpointer, jbyteArray jencryptionkey) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	char *encryptionkey = 0;
	if(jencryptionkey) {
		encryptionkey = (char *)getByteArrayElements(java_env, jencryptionkey);
		N2J_CAST_PTR(pointer, FMOD_EVENT_LOADINFO *)->encryptionkey = encryptionkey;
	}
	else {
		N2J_CAST_PTR(pointer, FMOD_EVENT_LOADINFO *)->encryptionkey = (char *)0;
	}
}

JNIEXPORT jfloat JNICALL Java_org_jouvieje_fmoddesigner_structures_StructureJNI_FMOD_1EVENT_1LOADINFO_1get_1sounddefentrylimit(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float result_ = N2J_CAST_PTR(pointer, FMOD_EVENT_LOADINFO *)->sounddefentrylimit;
	return (jfloat)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmoddesigner_structures_StructureJNI_FMOD_1EVENT_1LOADINFO_1set_1sounddefentrylimit(JNIEnv *java_env, jclass jcls, jlong jpointer, jfloat jsounddefentrylimit) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float sounddefentrylimit = (float)jsounddefentrylimit;
	N2J_CAST_PTR(pointer, FMOD_EVENT_LOADINFO *)->sounddefentrylimit = sounddefentrylimit;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_structures_StructureJNI_FMOD_1EVENT_1LOADINFO_1get_1loadfrommemory_1length(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int result_ = N2J_CAST_PTR(pointer, FMOD_EVENT_LOADINFO *)->loadfrommemory_length;
	return (jint)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmoddesigner_structures_StructureJNI_FMOD_1EVENT_1LOADINFO_1set_1loadfrommemory_1length(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jloadfrommemory_length) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int loadfrommemory_length = (int)jloadfrommemory_length;
	N2J_CAST_PTR(pointer, FMOD_EVENT_LOADINFO *)->loadfrommemory_length = loadfrommemory_length;
}

JNIEXPORT jboolean JNICALL Java_org_jouvieje_fmoddesigner_structures_StructureJNI_FMOD_1EVENT_1LOADINFO_1get_1override_1category_1vals(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD_BOOL result_ = N2J_CAST_PTR(pointer, FMOD_EVENT_LOADINFO *)->override_category_vals;
	return N2J_CAST_VAR(result_ != 0, jboolean);
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmoddesigner_structures_StructureJNI_FMOD_1EVENT_1LOADINFO_1set_1override_1category_1vals(JNIEnv *java_env, jclass jcls, jlong jpointer, jboolean joverride_category_vals) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD_BOOL override_category_vals = N2J_CAST_VAR(joverride_category_vals != 0, FMOD_BOOL);
	N2J_CAST_PTR(pointer, FMOD_EVENT_LOADINFO *)->override_category_vals = override_category_vals;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_structures_StructureJNI_FMOD_1EVENT_1LOADINFO_1get_1sizeof_1instancepool_1simple(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int result_ = N2J_CAST_PTR(pointer, FMOD_EVENT_LOADINFO *)->sizeof_instancepool_simple;
	return (jint)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmoddesigner_structures_StructureJNI_FMOD_1EVENT_1LOADINFO_1set_1sizeof_1instancepool_1simple(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jsizeof_instancepool_simple) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int sizeof_instancepool_simple = (int)jsizeof_instancepool_simple;
	N2J_CAST_PTR(pointer, FMOD_EVENT_LOADINFO *)->sizeof_instancepool_simple = sizeof_instancepool_simple;
}



