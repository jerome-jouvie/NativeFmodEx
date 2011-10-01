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

JNIEXPORT jlong JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1GUID_1new(JNIEnv *java_env, jclass jcls) {
	FMOD_GUID *result_ = new FMOD_GUID();
	CheckAllocation(java_env, result_);
	POINTER_TYPE jresult/* = 0*/;
	N2J_CAST_PTR(jresult, FMOD_GUID *) = result_;
	return (jlong)jresult;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1GUID_1delete(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	delete N2J_CAST_PTR(pointer, FMOD_GUID *);
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1GUID_1get_1Data1(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int result_ = N2J_CAST_PTR(pointer, FMOD_GUID *)->Data1;
	return (jint)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1GUID_1set_1Data1(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jData1) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int Data1 = (int)jData1;
	N2J_CAST_PTR(pointer, FMOD_GUID *)->Data1 = Data1;
}

JNIEXPORT jshort JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1GUID_1get_1Data2(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	short result_ = N2J_CAST_PTR(pointer, FMOD_GUID *)->Data2;
	return (jshort)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1GUID_1set_1Data2(JNIEnv *java_env, jclass jcls, jlong jpointer, jshort jData2) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	short Data2 = (short)jData2;
	N2J_CAST_PTR(pointer, FMOD_GUID *)->Data2 = Data2;
}

JNIEXPORT jshort JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1GUID_1get_1Data3(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	short result_ = N2J_CAST_PTR(pointer, FMOD_GUID *)->Data3;
	return (jshort)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1GUID_1set_1Data3(JNIEnv *java_env, jclass jcls, jlong jpointer, jshort jData3) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	short Data3 = (short)jData3;
	N2J_CAST_PTR(pointer, FMOD_GUID *)->Data3 = Data3;
}

JNIEXPORT jobject JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1GUID_1get_1Data4(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	unsigned char *result_ = (unsigned char *)N2J_CAST_PTR(pointer, FMOD_GUID *)->Data4;
	jobject jresult = 0;
	if(result_) {
		jresult = java_env->NewDirectByteBuffer((char *)result_, 8);
	}
	return jresult;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1GUID_1set_1Data4(JNIEnv *java_env, jclass jcls, jlong jpointer, jbyteArray jData4) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	unsigned char *Data4 = 0;
	if(jData4) {
		Data4 = (unsigned char *)getByteArrayElements(java_env, jData4);
		if(Data4) {
			strncpy(N2J_CAST_VAR(N2J_CAST_PTR(pointer, FMOD_GUID *)->Data4, char *), (const char *)Data4, 8);
		}
		releaseByteArrayElements(java_env, jData4, (const char *)Data4);
	}
	else {
		N2J_CAST_PTR(pointer, FMOD_GUID *)->Data4[0] = 0;
	}
#if 0
	Error if actif: array constant length expected
#endif
}



