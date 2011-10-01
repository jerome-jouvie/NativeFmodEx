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

JNIEXPORT jlong JNICALL Java_org_jouvieje_fmoddesigner_structures_StructureJNI_FMOD_1MUSIC_1ITERATOR_1new(JNIEnv *java_env, jclass jcls) {
	FMOD_MUSIC_ITERATOR *result_ = new FMOD_MUSIC_ITERATOR();
	CheckAllocation(java_env, result_);
	POINTER_TYPE jresult/* = 0*/;
	N2J_CAST_PTR(jresult, FMOD_MUSIC_ITERATOR *) = result_;
	return (jlong)jresult;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmoddesigner_structures_StructureJNI_FMOD_1MUSIC_1ITERATOR_1delete(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	delete N2J_CAST_PTR(pointer, FMOD_MUSIC_ITERATOR *);
}

JNIEXPORT jlong JNICALL Java_org_jouvieje_fmoddesigner_structures_StructureJNI_FMOD_1MUSIC_1ITERATOR_1get_1value(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	POINTER_TYPE jresult/* = 0*/;
	N2J_CAST_PTR(jresult, const FMOD_MUSIC_ENTITY *) = N2J_CAST_PTR(pointer, FMOD_MUSIC_ITERATOR *)->value;
	return (jlong)jresult;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmoddesigner_structures_StructureJNI_FMOD_1MUSIC_1ITERATOR_1set_1value(JNIEnv *java_env, jclass jcls, jlong jpointer, jlong jvalue) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	POINTER_TYPE valueTmp = (POINTER_TYPE)jvalue;
	N2J_CAST_PTR(pointer, FMOD_MUSIC_ITERATOR *)->value = N2J_CAST_PTR(valueTmp, FMOD_MUSIC_ENTITY *);
}

JNIEXPORT jstring JNICALL Java_org_jouvieje_fmoddesigner_structures_StructureJNI_FMOD_1MUSIC_1ITERATOR_1get_1filter(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	const char *result_ = N2J_CAST_VAR(N2J_CAST_PTR(pointer, FMOD_MUSIC_ITERATOR *)->filter, const char *);
	jstring jresult = 0;
	if(result_) {
		jresult = java_env->NewStringUTF((const char *)result_);
	}
	return jresult;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmoddesigner_structures_StructureJNI_FMOD_1MUSIC_1ITERATOR_1set_1filter(JNIEnv *java_env, jclass jcls, jlong jpointer, jbyteArray jfilter) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	const char *filter = 0;
	if(jfilter) {
		filter = (const char *)getByteArrayElements(java_env, jfilter);
		N2J_CAST_PTR(pointer, FMOD_MUSIC_ITERATOR *)->filter = filter;
	}
	else {
		N2J_CAST_PTR(pointer, FMOD_MUSIC_ITERATOR *)->filter = (const char *)0;
	}
}



