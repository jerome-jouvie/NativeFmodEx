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

JNIEXPORT jlong JNICALL Java_org_jouvieje_fmoddesigner_structures_StructureJNI_FMOD_1EVENT_1SOUNDDEFINFO_1new(JNIEnv *java_env, jclass jcls) {
	FMOD_EVENT_SOUNDDEFINFO *result_ = new FMOD_EVENT_SOUNDDEFINFO();
	CheckAllocation(java_env, result_);
	POINTER_TYPE jresult/* = 0*/;
	N2J_CAST_PTR(jresult, FMOD_EVENT_SOUNDDEFINFO *) = result_;
	return (jlong)jresult;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmoddesigner_structures_StructureJNI_FMOD_1EVENT_1SOUNDDEFINFO_1delete(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	delete N2J_CAST_PTR(pointer, FMOD_EVENT_SOUNDDEFINFO *);
}

JNIEXPORT jstring JNICALL Java_org_jouvieje_fmoddesigner_structures_StructureJNI_FMOD_1EVENT_1SOUNDDEFINFO_1get_1name(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	char *result_ = N2J_CAST_VAR(N2J_CAST_PTR(pointer, FMOD_EVENT_SOUNDDEFINFO *)->name, char *);
	jstring jresult = 0;
	if(result_) {
		jresult = java_env->NewStringUTF((const char *)result_);
	}
	return jresult;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_structures_StructureJNI_FMOD_1EVENT_1SOUNDDEFINFO_1get_1numentries(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int result_ = N2J_CAST_PTR(pointer, FMOD_EVENT_SOUNDDEFINFO *)->numentries;
	return (jint)result_;
}

JNIEXPORT jobjectArray JNICALL Java_org_jouvieje_fmoddesigner_structures_StructureJNI_FMOD_1EVENT_1SOUNDDEFINFO_1get_1entrynames(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	const char **result = N2J_CAST_PTR(pointer, FMOD_EVENT_SOUNDDEFINFO *)->entrynames;
	jint size = (jint)N2J_CAST_PTR(pointer, FMOD_EVENT_SOUNDDEFINFO *)->numentries;
	jobjectArray jresult = java_env->NewObjectArray(size, getStringClass(java_env), 0);
	for(int i = 0; i < size; i++) {
		jobject resulti = java_env->NewStringUTF((const char *)result[i]);
		java_env->SetObjectArrayElement(jresult, N2J_CAST_VAR(N2J_CAST_VAR(i, jint), jsize), resulti);
	}
	return jresult;
}

JNIEXPORT jobject JNICALL Java_org_jouvieje_fmoddesigner_structures_StructureJNI_FMOD_1EVENT_1SOUNDDEFINFO_1get_1entrytypes(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int size = N2J_CAST_PTR(pointer, FMOD_EVENT_SOUNDDEFINFO *)->numentries;
	jobject jresult = 0;
	if(size > 0) {
		FMOD_EVENT_SOUNDDEF_ENTRYTYPE *result_ = (FMOD_EVENT_SOUNDDEF_ENTRYTYPE *)N2J_CAST_PTR(pointer, FMOD_EVENT_SOUNDDEFINFO *)->entrytypes;
		if(result_) {
			jresult = java_env->NewDirectByteBuffer(result_, size * sizeof(FMOD_EVENT_SOUNDDEF_ENTRYTYPE));
		}
	}
	return jresult;
}



