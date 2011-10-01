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

JNIEXPORT jlong JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CODEC_1WAVEFORMAT_1new(JNIEnv *java_env, jclass jcls) {
	FMOD_CODEC_WAVEFORMAT *result_ = new FMOD_CODEC_WAVEFORMAT();
	CheckAllocation(java_env, result_);
	POINTER_TYPE jresult/* = 0*/;
	N2J_CAST_PTR(jresult, FMOD_CODEC_WAVEFORMAT *) = result_;
	return (jlong)jresult;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CODEC_1WAVEFORMAT_1delete(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	delete N2J_CAST_PTR(pointer, FMOD_CODEC_WAVEFORMAT *);
}

JNIEXPORT jobject JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CODEC_1WAVEFORMAT_1get_1name(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	char *result_ = (char *)N2J_CAST_PTR(pointer, FMOD_CODEC_WAVEFORMAT *)->name;
	jobject jresult = 0;
	if(result_) {
		jresult = java_env->NewDirectByteBuffer((char *)result_, 256);
	}
	return jresult;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CODEC_1WAVEFORMAT_1set_1name(JNIEnv *java_env, jclass jcls, jlong jpointer, jbyteArray jname) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	char *name = 0;
	if(jname) {
		name = (char *)getByteArrayElements(java_env, jname);
		if(name) {
			strncpy(N2J_CAST_VAR(N2J_CAST_PTR(pointer, FMOD_CODEC_WAVEFORMAT *)->name, char *), (const char *)name, 256);
		}
		releaseByteArrayElements(java_env, jname, (const char *)name);
	}
	else {
		N2J_CAST_PTR(pointer, FMOD_CODEC_WAVEFORMAT *)->name[0] = 0;
	}
#if 0
	Error if actif: array constant length expected
#endif
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CODEC_1WAVEFORMAT_1get_1format(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD_SOUND_FORMAT result_ = N2J_CAST_PTR(pointer, FMOD_CODEC_WAVEFORMAT *)->format;
	return (jint)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CODEC_1WAVEFORMAT_1set_1format(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jformat) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int format = (int)jformat;
	N2J_CAST_PTR(pointer, FMOD_CODEC_WAVEFORMAT *)->format = (FMOD_SOUND_FORMAT)format;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CODEC_1WAVEFORMAT_1get_1channels(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int result_ = N2J_CAST_PTR(pointer, FMOD_CODEC_WAVEFORMAT *)->channels;
	return (jint)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CODEC_1WAVEFORMAT_1set_1channels(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jchannels) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int channels = (int)jchannels;
	N2J_CAST_PTR(pointer, FMOD_CODEC_WAVEFORMAT *)->channels = channels;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CODEC_1WAVEFORMAT_1get_1frequency(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int result_ = N2J_CAST_PTR(pointer, FMOD_CODEC_WAVEFORMAT *)->frequency;
	return (jint)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CODEC_1WAVEFORMAT_1set_1frequency(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jfrequency) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int frequency = (int)jfrequency;
	N2J_CAST_PTR(pointer, FMOD_CODEC_WAVEFORMAT *)->frequency = frequency;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CODEC_1WAVEFORMAT_1get_1lengthbytes(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int result_ = N2J_CAST_PTR(pointer, FMOD_CODEC_WAVEFORMAT *)->lengthbytes;
	return (jint)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CODEC_1WAVEFORMAT_1set_1lengthbytes(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jlengthbytes) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int lengthbytes = (int)jlengthbytes;
	N2J_CAST_PTR(pointer, FMOD_CODEC_WAVEFORMAT *)->lengthbytes = lengthbytes;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CODEC_1WAVEFORMAT_1get_1lengthpcm(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int result_ = N2J_CAST_PTR(pointer, FMOD_CODEC_WAVEFORMAT *)->lengthpcm;
	return (jint)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CODEC_1WAVEFORMAT_1set_1lengthpcm(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jlengthpcm) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int lengthpcm = (int)jlengthpcm;
	N2J_CAST_PTR(pointer, FMOD_CODEC_WAVEFORMAT *)->lengthpcm = lengthpcm;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CODEC_1WAVEFORMAT_1get_1blockalign(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int result_ = N2J_CAST_PTR(pointer, FMOD_CODEC_WAVEFORMAT *)->blockalign;
	return (jint)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CODEC_1WAVEFORMAT_1set_1blockalign(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jblockalign) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int blockalign = (int)jblockalign;
	N2J_CAST_PTR(pointer, FMOD_CODEC_WAVEFORMAT *)->blockalign = blockalign;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CODEC_1WAVEFORMAT_1get_1loopstart(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int result_ = N2J_CAST_PTR(pointer, FMOD_CODEC_WAVEFORMAT *)->loopstart;
	return (jint)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CODEC_1WAVEFORMAT_1set_1loopstart(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jloopstart) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int loopstart = (int)jloopstart;
	N2J_CAST_PTR(pointer, FMOD_CODEC_WAVEFORMAT *)->loopstart = loopstart;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CODEC_1WAVEFORMAT_1get_1loopend(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int result_ = N2J_CAST_PTR(pointer, FMOD_CODEC_WAVEFORMAT *)->loopend;
	return (jint)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CODEC_1WAVEFORMAT_1set_1loopend(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jloopend) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int loopend = (int)jloopend;
	N2J_CAST_PTR(pointer, FMOD_CODEC_WAVEFORMAT *)->loopend = loopend;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CODEC_1WAVEFORMAT_1get_1mode(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD_MODE result_ = N2J_CAST_PTR(pointer, FMOD_CODEC_WAVEFORMAT *)->mode;
	return (jint)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CODEC_1WAVEFORMAT_1set_1mode(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jmode) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int mode = (int)jmode;
	N2J_CAST_PTR(pointer, FMOD_CODEC_WAVEFORMAT *)->mode = (FMOD_MODE)mode;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CODEC_1WAVEFORMAT_1get_1channelmask(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int result_ = N2J_CAST_PTR(pointer, FMOD_CODEC_WAVEFORMAT *)->channelmask;
	return (jint)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CODEC_1WAVEFORMAT_1set_1channelmask(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jchannelmask) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int channelmask = (int)jchannelmask;
	N2J_CAST_PTR(pointer, FMOD_CODEC_WAVEFORMAT *)->channelmask = channelmask;
}



