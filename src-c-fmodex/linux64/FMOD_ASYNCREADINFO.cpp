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
#include "org_jouvieje_fmodex_structures_StructureJNI.h"
#include "CallbackManager.h"

JNIEXPORT jlong JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1ASYNCREADINFO_1new(JNIEnv *java_env, jclass jcls) {
	FMOD_ASYNCREADINFO *result_ = new FMOD_ASYNCREADINFO();
	CheckAllocation(java_env, result_);
	POINTER_TYPE jresult/* = 0*/;
	N2J_CAST_PTR(jresult, FMOD_ASYNCREADINFO *) = result_;
	return (jlong)jresult;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1ASYNCREADINFO_1delete(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	delete N2J_CAST_PTR(pointer, FMOD_ASYNCREADINFO *);
}

JNIEXPORT jlong JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1ASYNCREADINFO_1get_1handle(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	POINTER_TYPE jresult/* = 0*/;
	N2J_CAST_PTR(jresult, void *) = N2J_CAST_PTR(pointer, FMOD_ASYNCREADINFO *)->handle;
	return (jlong)jresult;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1ASYNCREADINFO_1get_1offset(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int result_ = N2J_CAST_PTR(pointer, FMOD_ASYNCREADINFO *)->offset;
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1ASYNCREADINFO_1get_1sizebytes(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int result_ = N2J_CAST_PTR(pointer, FMOD_ASYNCREADINFO *)->sizebytes;
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1ASYNCREADINFO_1get_1priority(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int result_ = N2J_CAST_PTR(pointer, FMOD_ASYNCREADINFO *)->priority;
	return (jint)result_;
}

JNIEXPORT jlong JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1ASYNCREADINFO_1get_1buffer(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	POINTER_TYPE jresult/* = 0*/;
	N2J_CAST_PTR(jresult, void *) = N2J_CAST_PTR(pointer, FMOD_ASYNCREADINFO *)->buffer;
	return (jlong)jresult;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1ASYNCREADINFO_1set_1buffer(JNIEnv *java_env, jclass jcls, jlong jpointer, jlong jbuffer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	POINTER_TYPE bufferTmp = (POINTER_TYPE)jbuffer;
	N2J_CAST_PTR(pointer, FMOD_ASYNCREADINFO *)->buffer = N2J_CAST_PTR(bufferTmp, void *);
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1ASYNCREADINFO_1get_1bytesread(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int result_ = N2J_CAST_PTR(pointer, FMOD_ASYNCREADINFO *)->bytesread;
	return (jint)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1ASYNCREADINFO_1set_1bytesread(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jbytesread) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int bytesread = (int)jbytesread;
	N2J_CAST_PTR(pointer, FMOD_ASYNCREADINFO *)->bytesread = bytesread;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1ASYNCREADINFO_1get_1result(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD_ASYNCREADINFO *)->result;
	return (jint)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1ASYNCREADINFO_1set_1result(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jresult) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int result = (int)jresult;
	N2J_CAST_PTR(pointer, FMOD_ASYNCREADINFO *)->result = (FMOD_RESULT)result;
}

JNIEXPORT jlong JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1ASYNCREADINFO_1get_1userdata(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	POINTER_TYPE jresult/* = 0*/;
	N2J_CAST_PTR(jresult, void *) = N2J_CAST_PTR(pointer, FMOD_ASYNCREADINFO *)->userdata;
	return (jlong)jresult;
}



