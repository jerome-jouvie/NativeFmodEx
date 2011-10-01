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

JNIEXPORT jlong JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1DSP_1PARAMETERDESC_1newArray(JNIEnv *java_env, jclass jcls, jint length) {
	FMOD_DSP_PARAMETERDESC *array = new FMOD_DSP_PARAMETERDESC[(int)length];
	if((int)length > 0) { CheckAllocation(java_env, array); }
	POINTER_TYPE jresult/* = 0*/;
	N2J_CAST_PTR(jresult, FMOD_DSP_PARAMETERDESC *) = array;
	return (jlong)jresult;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1DSP_1PARAMETERDESC_1SIZEOF(JNIEnv *java_env, jclass jcls) {
	return (jint)sizeof(FMOD_DSP_PARAMETERDESC);
}

JNIEXPORT jlong JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1DSP_1PARAMETERDESC_1new(JNIEnv *java_env, jclass jcls) {
	FMOD_DSP_PARAMETERDESC *result_ = new FMOD_DSP_PARAMETERDESC();
	CheckAllocation(java_env, result_);
	POINTER_TYPE jresult/* = 0*/;
	N2J_CAST_PTR(jresult, FMOD_DSP_PARAMETERDESC *) = result_;
	return (jlong)jresult;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1DSP_1PARAMETERDESC_1delete(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	delete N2J_CAST_PTR(pointer, FMOD_DSP_PARAMETERDESC *);
}

JNIEXPORT jfloat JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1DSP_1PARAMETERDESC_1get_1min(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float result_ = N2J_CAST_PTR(pointer, FMOD_DSP_PARAMETERDESC *)->min;
	return (jfloat)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1DSP_1PARAMETERDESC_1set_1min(JNIEnv *java_env, jclass jcls, jlong jpointer, jfloat jmin) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float min = (float)jmin;
	N2J_CAST_PTR(pointer, FMOD_DSP_PARAMETERDESC *)->min = min;
}

JNIEXPORT jfloat JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1DSP_1PARAMETERDESC_1get_1max(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float result_ = N2J_CAST_PTR(pointer, FMOD_DSP_PARAMETERDESC *)->max;
	return (jfloat)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1DSP_1PARAMETERDESC_1set_1max(JNIEnv *java_env, jclass jcls, jlong jpointer, jfloat jmax) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float max = (float)jmax;
	N2J_CAST_PTR(pointer, FMOD_DSP_PARAMETERDESC *)->max = max;
}

JNIEXPORT jfloat JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1DSP_1PARAMETERDESC_1get_1defaultval(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float result_ = N2J_CAST_PTR(pointer, FMOD_DSP_PARAMETERDESC *)->defaultval;
	return (jfloat)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1DSP_1PARAMETERDESC_1set_1defaultval(JNIEnv *java_env, jclass jcls, jlong jpointer, jfloat jdefaultval) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float defaultval = (float)jdefaultval;
	N2J_CAST_PTR(pointer, FMOD_DSP_PARAMETERDESC *)->defaultval = defaultval;
}

JNIEXPORT jstring JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1DSP_1PARAMETERDESC_1get_1name(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	char *result_ = (char *)N2J_CAST_PTR(pointer, FMOD_DSP_PARAMETERDESC *)->name;
	jstring jresult = 0;
	if(result_) {
		jresult = java_env->NewStringUTF((const char *)result_);
	}
	return jresult;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1DSP_1PARAMETERDESC_1set_1name(JNIEnv *java_env, jclass jcls, jlong jpointer, jbyteArray jname) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	char *name = 0;
	if(jname) {
		name = (char *)getByteArrayElements(java_env, jname);
		if(name) {
			strncpy(N2J_CAST_VAR(N2J_CAST_PTR(pointer, FMOD_DSP_PARAMETERDESC *)->name, char *), (const char *)name, 16);
		}
		releaseByteArrayElements(java_env, jname, (const char *)name);
	}
	else {
		N2J_CAST_PTR(pointer, FMOD_DSP_PARAMETERDESC *)->name[0] = 0;
	}
#if 0
	Error if actif: array constant length expected
#endif
}

JNIEXPORT jstring JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1DSP_1PARAMETERDESC_1get_1label(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	char *result_ = (char *)N2J_CAST_PTR(pointer, FMOD_DSP_PARAMETERDESC *)->label;
	jstring jresult = 0;
	if(result_) {
		jresult = java_env->NewStringUTF((const char *)result_);
	}
	return jresult;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1DSP_1PARAMETERDESC_1set_1label(JNIEnv *java_env, jclass jcls, jlong jpointer, jbyteArray jlabel) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	char *label = 0;
	if(jlabel) {
		label = (char *)getByteArrayElements(java_env, jlabel);
		if(label) {
			strncpy(N2J_CAST_VAR(N2J_CAST_PTR(pointer, FMOD_DSP_PARAMETERDESC *)->label, char *), (const char *)label, 16);
		}
		releaseByteArrayElements(java_env, jlabel, (const char *)label);
	}
	else {
		N2J_CAST_PTR(pointer, FMOD_DSP_PARAMETERDESC *)->label[0] = 0;
	}
#if 0
	Error if actif: array constant length expected
#endif
}

JNIEXPORT jstring JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1DSP_1PARAMETERDESC_1get_1description(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	const char *result_ = N2J_CAST_VAR(N2J_CAST_PTR(pointer, FMOD_DSP_PARAMETERDESC *)->description, const char *);
	jstring jresult = 0;
	if(result_) {
		jresult = java_env->NewStringUTF((const char *)result_);
	}
	return jresult;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1DSP_1PARAMETERDESC_1set_1description(JNIEnv *java_env, jclass jcls, jlong jpointer, jbyteArray jdescription) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	const char *description = 0;
	if(jdescription) {
		description = (const char *)getByteArrayElements(java_env, jdescription);
		N2J_CAST_PTR(pointer, FMOD_DSP_PARAMETERDESC *)->description = description;
	}
	else {
		N2J_CAST_PTR(pointer, FMOD_DSP_PARAMETERDESC *)->description = (const char *)0;
	}
}



