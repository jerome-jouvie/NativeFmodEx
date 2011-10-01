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

JNIEXPORT jlong JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1VECTOR_1allocate(JNIEnv *java_env, jclass jcls, jfloat x, jfloat y, jfloat z) {
	FMOD_VECTOR *result_ = new FMOD_VECTOR();
	CheckAllocation(java_env, result_);
	result_->x = (float)x;
	result_->y = (float)y;
	result_->z = (float)z;
	POINTER_TYPE jresult/* = 0*/;
	N2J_CAST_PTR(jresult, FMOD_VECTOR *) = result_;
	return (jlong)jresult;
}

JNIEXPORT jlong JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1VECTOR_1newArray(JNIEnv *java_env, jclass jcls, jint length) {
	FMOD_VECTOR *array = new FMOD_VECTOR[(int)length];
	if((int)length > 0) { CheckAllocation(java_env, array); }
	POINTER_TYPE jresult/* = 0*/;
	N2J_CAST_PTR(jresult, FMOD_VECTOR *) = array;
	return (jlong)jresult;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1VECTOR_1SIZEOF(JNIEnv *java_env, jclass jcls) {
	return (jint)sizeof(FMOD_VECTOR);
}

JNIEXPORT jlong JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1VECTOR_1new(JNIEnv *java_env, jclass jcls) {
	FMOD_VECTOR *result_ = new FMOD_VECTOR();
	CheckAllocation(java_env, result_);
	POINTER_TYPE jresult/* = 0*/;
	N2J_CAST_PTR(jresult, FMOD_VECTOR *) = result_;
	return (jlong)jresult;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1VECTOR_1delete(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	delete N2J_CAST_PTR(pointer, FMOD_VECTOR *);
}

JNIEXPORT jfloat JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1VECTOR_1get_1x(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float result_ = N2J_CAST_PTR(pointer, FMOD_VECTOR *)->x;
	return (jfloat)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1VECTOR_1set_1x(JNIEnv *java_env, jclass jcls, jlong jpointer, jfloat jx) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float x = (float)jx;
	N2J_CAST_PTR(pointer, FMOD_VECTOR *)->x = x;
}

JNIEXPORT jfloat JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1VECTOR_1get_1y(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float result_ = N2J_CAST_PTR(pointer, FMOD_VECTOR *)->y;
	return (jfloat)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1VECTOR_1set_1y(JNIEnv *java_env, jclass jcls, jlong jpointer, jfloat jy) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float y = (float)jy;
	N2J_CAST_PTR(pointer, FMOD_VECTOR *)->y = y;
}

JNIEXPORT jfloat JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1VECTOR_1get_1z(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float result_ = N2J_CAST_PTR(pointer, FMOD_VECTOR *)->z;
	return (jfloat)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1VECTOR_1set_1z(JNIEnv *java_env, jclass jcls, jlong jpointer, jfloat jz) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float z = (float)jz;
	N2J_CAST_PTR(pointer, FMOD_VECTOR *)->z = z;
}


JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1VECTOR_1set_1xyz__JJ(JNIEnv *java_env, jclass jcls, jlong jpointer, jlong jvector) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	if(jvector) {
		POINTER_TYPE vector = (POINTER_TYPE)jvector;
		FMOD_VECTOR *pointer_ = N2J_CAST_PTR(pointer, FMOD_VECTOR *);
		FMOD_VECTOR *vector_ = N2J_CAST_PTR(vector, FMOD_VECTOR *);
		
		pointer_->x = vector_->x;
		pointer_->y = vector_->y;
		pointer_->z = vector_->z;
	}
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1VECTOR_1set_1xyz__JFFF(JNIEnv *java_env, jclass jcls, jlong jpointer, jfloat x, jfloat y, jfloat z) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD_VECTOR *pointer_ = N2J_CAST_PTR(pointer, FMOD_VECTOR *);
	pointer_->x = (float)x;
	pointer_->y = (float)y;
	pointer_->z = (float)z;
}


