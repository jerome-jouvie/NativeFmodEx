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

JNIEXPORT jlong JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1DSP_1DESCRIPTION_1new(JNIEnv *java_env, jclass jcls) {
	FMOD_DSP_DESCRIPTION *result_ = new FMOD_DSP_DESCRIPTION();
	CheckAllocation(java_env, result_);
	POINTER_TYPE jresult/* = 0*/;
	N2J_CAST_PTR(jresult, FMOD_DSP_DESCRIPTION *) = result_;
	return (jlong)jresult;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1DSP_1DESCRIPTION_1delete(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	delete N2J_CAST_PTR(pointer, FMOD_DSP_DESCRIPTION *);
}

JNIEXPORT jstring JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1DSP_1DESCRIPTION_1get_1name(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	char *result_ = (char *)N2J_CAST_PTR(pointer, FMOD_DSP_DESCRIPTION *)->name;
	jstring jresult = 0;
	if(result_) {
		jresult = java_env->NewStringUTF((const char *)result_);
	}
	return jresult;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1DSP_1DESCRIPTION_1set_1name(JNIEnv *java_env, jclass jcls, jlong jpointer, jbyteArray jname) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	char *name = 0;
	if(jname) {
		name = (char *)getByteArrayElements(java_env, jname);
		if(name) {
			strncpy(N2J_CAST_VAR(N2J_CAST_PTR(pointer, FMOD_DSP_DESCRIPTION *)->name, char *), (const char *)name, 32);
		}
		releaseByteArrayElements(java_env, jname, (const char *)name);
	}
	else {
		N2J_CAST_PTR(pointer, FMOD_DSP_DESCRIPTION *)->name[0] = 0;
	}
#if 0
	Error if actif: array constant length expected
#endif
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1DSP_1DESCRIPTION_1get_1version(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int result_ = N2J_CAST_PTR(pointer, FMOD_DSP_DESCRIPTION *)->version;
	return (jint)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1DSP_1DESCRIPTION_1set_1version(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jversion) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int version = (int)jversion;
	N2J_CAST_PTR(pointer, FMOD_DSP_DESCRIPTION *)->version = version;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1DSP_1DESCRIPTION_1get_1channels(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int result_ = N2J_CAST_PTR(pointer, FMOD_DSP_DESCRIPTION *)->channels;
	return (jint)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1DSP_1DESCRIPTION_1set_1channels(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jchannels) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int channels = (int)jchannels;
	N2J_CAST_PTR(pointer, FMOD_DSP_DESCRIPTION *)->channels = channels;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1DSP_1DESCRIPTION_1set_1create(JNIEnv *java_env, jclass jcls, jlong jpointer, jboolean jcreate) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	N2J_CAST_PTR(pointer, FMOD_DSP_DESCRIPTION *)->create = ((jcreate == 0) ? NULL : FMOD_DSP_CREATECALLBACK_BRIDGE);
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1DSP_1DESCRIPTION_1set_1release(JNIEnv *java_env, jclass jcls, jlong jpointer, jboolean jrelease) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	N2J_CAST_PTR(pointer, FMOD_DSP_DESCRIPTION *)->release = ((jrelease == 0) ? NULL : FMOD_DSP_RELEASECALLBACK_BRIDGE);
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1DSP_1DESCRIPTION_1set_1reset(JNIEnv *java_env, jclass jcls, jlong jpointer, jboolean jreset) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	N2J_CAST_PTR(pointer, FMOD_DSP_DESCRIPTION *)->reset = ((jreset == 0) ? NULL : FMOD_DSP_RESETCALLBACK_BRIDGE);
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1DSP_1DESCRIPTION_1set_1read(JNIEnv *java_env, jclass jcls, jlong jpointer, jboolean jread) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	N2J_CAST_PTR(pointer, FMOD_DSP_DESCRIPTION *)->read = ((jread == 0) ? NULL : FMOD_DSP_READCALLBACK_BRIDGE);
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1DSP_1DESCRIPTION_1set_1setposition(JNIEnv *java_env, jclass jcls, jlong jpointer, jboolean jsetposition) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	N2J_CAST_PTR(pointer, FMOD_DSP_DESCRIPTION *)->setposition = ((jsetposition == 0) ? NULL : FMOD_DSP_SETPOSITIONCALLBACK_BRIDGE);
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1DSP_1DESCRIPTION_1get_1numparameters(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int result_ = N2J_CAST_PTR(pointer, FMOD_DSP_DESCRIPTION *)->numparameters;
	return (jint)result_;
}

JNIEXPORT jlong JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1DSP_1DESCRIPTION_1get_1paramdesc(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	POINTER_TYPE jresult/* = 0*/;
	N2J_CAST_PTR(jresult, FMOD_DSP_PARAMETERDESC *) = N2J_CAST_PTR(pointer, FMOD_DSP_DESCRIPTION *)->paramdesc;
	return (jlong)jresult;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1DSP_1DESCRIPTION_1set_1paramdesc(JNIEnv *java_env, jclass jcls, jlong jpointer, jlong jparamdesc, jint paramdescLen_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	POINTER_TYPE paramdescTmp = (POINTER_TYPE)jparamdesc;
	N2J_CAST_PTR(pointer, FMOD_DSP_DESCRIPTION *)->paramdesc = N2J_CAST_PTR(paramdescTmp, FMOD_DSP_PARAMETERDESC *);
#if 1
	N2J_CAST_PTR(pointer, FMOD_DSP_DESCRIPTION *)->numparameters = paramdescLen_;
#endif
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1DSP_1DESCRIPTION_1set_1setparameter(JNIEnv *java_env, jclass jcls, jlong jpointer, jboolean jsetparameter) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	N2J_CAST_PTR(pointer, FMOD_DSP_DESCRIPTION *)->setparameter = ((jsetparameter == 0) ? NULL : FMOD_DSP_SETPARAMCALLBACK_BRIDGE);
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1DSP_1DESCRIPTION_1set_1getparameter(JNIEnv *java_env, jclass jcls, jlong jpointer, jboolean jgetparameter) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	N2J_CAST_PTR(pointer, FMOD_DSP_DESCRIPTION *)->getparameter = ((jgetparameter == 0) ? NULL : FMOD_DSP_GETPARAMCALLBACK_BRIDGE);
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1DSP_1DESCRIPTION_1set_1config(JNIEnv *java_env, jclass jcls, jlong jpointer, jboolean jconfig) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	N2J_CAST_PTR(pointer, FMOD_DSP_DESCRIPTION *)->config = ((jconfig == 0) ? NULL : FMOD_DSP_DIALOGCALLBACK_BRIDGE);
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1DSP_1DESCRIPTION_1get_1configwidth(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int result_ = N2J_CAST_PTR(pointer, FMOD_DSP_DESCRIPTION *)->configwidth;
	return (jint)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1DSP_1DESCRIPTION_1set_1configwidth(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jconfigwidth) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int configwidth = (int)jconfigwidth;
	N2J_CAST_PTR(pointer, FMOD_DSP_DESCRIPTION *)->configwidth = configwidth;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1DSP_1DESCRIPTION_1get_1configheight(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int result_ = N2J_CAST_PTR(pointer, FMOD_DSP_DESCRIPTION *)->configheight;
	return (jint)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1DSP_1DESCRIPTION_1set_1configheight(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jconfigheight) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int configheight = (int)jconfigheight;
	N2J_CAST_PTR(pointer, FMOD_DSP_DESCRIPTION *)->configheight = configheight;
}

JNIEXPORT jlong JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1DSP_1DESCRIPTION_1get_1userdata(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	POINTER_TYPE jresult/* = 0*/;
	N2J_CAST_PTR(jresult, void *) = N2J_CAST_PTR(pointer, FMOD_DSP_DESCRIPTION *)->userdata;
	return (jlong)jresult;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1DSP_1DESCRIPTION_1set_1userdata(JNIEnv *java_env, jclass jcls, jlong jpointer, jlong juserdata) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	POINTER_TYPE userdataTmp = (POINTER_TYPE)juserdata;
	N2J_CAST_PTR(pointer, FMOD_DSP_DESCRIPTION *)->userdata = N2J_CAST_PTR(userdataTmp, void *);
}



