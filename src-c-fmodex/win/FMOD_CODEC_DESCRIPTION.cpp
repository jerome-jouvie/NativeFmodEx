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

JNIEXPORT jlong JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CODEC_1DESCRIPTION_1new(JNIEnv *java_env, jclass jcls) {
	FMOD_CODEC_DESCRIPTION *result_ = new FMOD_CODEC_DESCRIPTION();
	CheckAllocation(java_env, result_);
	POINTER_TYPE jresult/* = 0*/;
	N2J_CAST_PTR(jresult, FMOD_CODEC_DESCRIPTION *) = result_;
	return (jlong)jresult;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CODEC_1DESCRIPTION_1delete(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	delete N2J_CAST_PTR(pointer, FMOD_CODEC_DESCRIPTION *);
}

JNIEXPORT jstring JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CODEC_1DESCRIPTION_1get_1name(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	const char *result_ = N2J_CAST_VAR(N2J_CAST_PTR(pointer, FMOD_CODEC_DESCRIPTION *)->name, const char *);
	jstring jresult = 0;
	if(result_) {
		jresult = java_env->NewStringUTF((const char *)result_);
	}
	return jresult;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CODEC_1DESCRIPTION_1set_1name(JNIEnv *java_env, jclass jcls, jlong jpointer, jbyteArray jname) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	const char *name = 0;
	if(jname) {
		name = (const char *)getByteArrayElements(java_env, jname);
		N2J_CAST_PTR(pointer, FMOD_CODEC_DESCRIPTION *)->name = name;
	}
	else {
		N2J_CAST_PTR(pointer, FMOD_CODEC_DESCRIPTION *)->name = (const char *)0;
	}
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CODEC_1DESCRIPTION_1get_1version(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int result_ = N2J_CAST_PTR(pointer, FMOD_CODEC_DESCRIPTION *)->version;
	return (jint)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CODEC_1DESCRIPTION_1set_1version(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jversion) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int version = (int)jversion;
	N2J_CAST_PTR(pointer, FMOD_CODEC_DESCRIPTION *)->version = version;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CODEC_1DESCRIPTION_1get_1defaultasstream(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int result_ = N2J_CAST_PTR(pointer, FMOD_CODEC_DESCRIPTION *)->defaultasstream;
	return (jint)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CODEC_1DESCRIPTION_1set_1defaultasstream(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jdefaultasstream) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int defaultasstream = (int)jdefaultasstream;
	N2J_CAST_PTR(pointer, FMOD_CODEC_DESCRIPTION *)->defaultasstream = defaultasstream;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CODEC_1DESCRIPTION_1get_1timeunits(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD_TIMEUNIT result_ = N2J_CAST_PTR(pointer, FMOD_CODEC_DESCRIPTION *)->timeunits;
	return (jint)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CODEC_1DESCRIPTION_1set_1timeunits(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jtimeunits) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int timeunits = (int)jtimeunits;
	N2J_CAST_PTR(pointer, FMOD_CODEC_DESCRIPTION *)->timeunits = (FMOD_TIMEUNIT)timeunits;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CODEC_1DESCRIPTION_1set_1open(JNIEnv *java_env, jclass jcls, jlong jpointer, jboolean jopen) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	N2J_CAST_PTR(pointer, FMOD_CODEC_DESCRIPTION *)->open = ((jopen == 0) ? NULL : FMOD_CODEC_OPENCALLBACK_BRIDGE);
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CODEC_1DESCRIPTION_1set_1close(JNIEnv *java_env, jclass jcls, jlong jpointer, jboolean jclose) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	N2J_CAST_PTR(pointer, FMOD_CODEC_DESCRIPTION *)->close = ((jclose == 0) ? NULL : FMOD_CODEC_CLOSECALLBACK_BRIDGE);
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CODEC_1DESCRIPTION_1set_1read(JNIEnv *java_env, jclass jcls, jlong jpointer, jboolean jread) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	N2J_CAST_PTR(pointer, FMOD_CODEC_DESCRIPTION *)->read = ((jread == 0) ? NULL : FMOD_CODEC_READCALLBACK_BRIDGE);
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CODEC_1DESCRIPTION_1set_1getlength(JNIEnv *java_env, jclass jcls, jlong jpointer, jboolean jgetlength) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	N2J_CAST_PTR(pointer, FMOD_CODEC_DESCRIPTION *)->getlength = ((jgetlength == 0) ? NULL : FMOD_CODEC_GETLENGTHCALLBACK_BRIDGE);
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CODEC_1DESCRIPTION_1set_1setposition(JNIEnv *java_env, jclass jcls, jlong jpointer, jboolean jsetposition) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	N2J_CAST_PTR(pointer, FMOD_CODEC_DESCRIPTION *)->setposition = ((jsetposition == 0) ? NULL : FMOD_CODEC_SETPOSITIONCALLBACK_BRIDGE);
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CODEC_1DESCRIPTION_1set_1getposition(JNIEnv *java_env, jclass jcls, jlong jpointer, jboolean jgetposition) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	N2J_CAST_PTR(pointer, FMOD_CODEC_DESCRIPTION *)->getposition = ((jgetposition == 0) ? NULL : FMOD_CODEC_GETPOSITIONCALLBACK_BRIDGE);
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CODEC_1DESCRIPTION_1set_1soundcreate(JNIEnv *java_env, jclass jcls, jlong jpointer, jboolean jsoundcreate) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	N2J_CAST_PTR(pointer, FMOD_CODEC_DESCRIPTION *)->soundcreate = ((jsoundcreate == 0) ? NULL : FMOD_CODEC_SOUNDCREATECALLBACK_BRIDGE);
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CODEC_1DESCRIPTION_1set_1getwaveformat(JNIEnv *java_env, jclass jcls, jlong jpointer, jboolean jgetwaveformat) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	N2J_CAST_PTR(pointer, FMOD_CODEC_DESCRIPTION *)->getwaveformat = ((jgetwaveformat == 0) ? NULL : FMOD_CODEC_GETWAVEFORMAT_BRIDGE);
}



