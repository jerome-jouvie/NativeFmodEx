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

JNIEXPORT jlong JNICALL Java_org_jouvieje_fmoddesigner_structures_StructureJNI_FMOD_1MUSIC_1SAMPLE_1INFO_1new(JNIEnv *java_env, jclass jcls) {
	FMOD_MUSIC_SAMPLE_INFO *result_ = new FMOD_MUSIC_SAMPLE_INFO();
	CheckAllocation(java_env, result_);
	POINTER_TYPE jresult/* = 0*/;
	N2J_CAST_PTR(jresult, FMOD_MUSIC_SAMPLE_INFO *) = result_;
	return (jlong)jresult;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmoddesigner_structures_StructureJNI_FMOD_1MUSIC_1SAMPLE_1INFO_1delete(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	delete N2J_CAST_PTR(pointer, FMOD_MUSIC_SAMPLE_INFO *);
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_structures_StructureJNI_FMOD_1MUSIC_1SAMPLE_1INFO_1get_1segment_1id(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int result_ = N2J_CAST_PTR(pointer, FMOD_MUSIC_SAMPLE_INFO *)->segment_id;
	return (jint)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmoddesigner_structures_StructureJNI_FMOD_1MUSIC_1SAMPLE_1INFO_1set_1segment_1id(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jsegment_id) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int segment_id = (int)jsegment_id;
	N2J_CAST_PTR(pointer, FMOD_MUSIC_SAMPLE_INFO *)->segment_id = segment_id;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_structures_StructureJNI_FMOD_1MUSIC_1SAMPLE_1INFO_1get_1index(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int result_ = N2J_CAST_PTR(pointer, FMOD_MUSIC_SAMPLE_INFO *)->index;
	return (jint)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmoddesigner_structures_StructureJNI_FMOD_1MUSIC_1SAMPLE_1INFO_1set_1index(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jindex) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int index = (int)jindex;
	N2J_CAST_PTR(pointer, FMOD_MUSIC_SAMPLE_INFO *)->index = index;
}

JNIEXPORT jstring JNICALL Java_org_jouvieje_fmoddesigner_structures_StructureJNI_FMOD_1MUSIC_1SAMPLE_1INFO_1get_1filename(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	const char *result_ = N2J_CAST_VAR(N2J_CAST_PTR(pointer, FMOD_MUSIC_SAMPLE_INFO *)->filename, const char *);
	jstring jresult = 0;
	if(result_) {
		jresult = java_env->NewStringUTF((const char *)result_);
	}
	return jresult;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmoddesigner_structures_StructureJNI_FMOD_1MUSIC_1SAMPLE_1INFO_1set_1filename(JNIEnv *java_env, jclass jcls, jlong jpointer, jbyteArray jfilename) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	const char *filename = 0;
	if(jfilename) {
		filename = (const char *)getByteArrayElements(java_env, jfilename);
		N2J_CAST_PTR(pointer, FMOD_MUSIC_SAMPLE_INFO *)->filename = filename;
	}
	else {
		N2J_CAST_PTR(pointer, FMOD_MUSIC_SAMPLE_INFO *)->filename = (const char *)0;
	}
}



