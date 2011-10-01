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
#include "org_jouvieje_fmodex_FmodExJNI.h"
#include "CallbackManager.h"

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_FmodEx_1Memory_1Initialize(JNIEnv *java_env, jclass jcls, jobject jpoolmem, jlong jpoolmem_, jint jpoollen, jboolean juseralloc, jboolean juserrealloc, jboolean juserfree, jint jmemtypeflags) {
	void *poolmem = 0;
	if(jpoolmem) {
		jobject jpoolmemGlobal = java_env->NewGlobalRef(jpoolmem);
		if(jpoolmemGlobal) {
			poolmem = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jpoolmemGlobal), char *)+jpoolmem_, void *);
		}
		else {
			ThrowException(java_env, OutOfMemoryError, "");
		}
	}
	int poollen = (int)jpoollen;
	FMOD_MEMORY_TYPE memtypeflags = (FMOD_MEMORY_TYPE)jmemtypeflags;

	FMOD_RESULT result_ = FMOD::Memory_Initialize(poolmem, poollen, juseralloc == 0 ? NULL : FMOD_MEMORY_ALLOCCALLBACK_BRIDGE, juserrealloc == 0 ? NULL : FMOD_MEMORY_REALLOCCALLBACK_BRIDGE, juserfree == 0 ? NULL : FMOD_MEMORY_FREECALLBACK_BRIDGE, memtypeflags);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_FmodEx_1Memory_1GetStats(JNIEnv *java_env, jclass jcls, jobject jcurrentalloced, jlong jcurrentalloced_, jobject jmaxalloced, jlong jmaxalloced_, jboolean jblocking) {
	int *currentalloced = 0;
	if(jcurrentalloced) {
		currentalloced = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jcurrentalloced), char *)+jcurrentalloced_, int *);
	}
	int *maxalloced = 0;
	if(jmaxalloced) {
		maxalloced = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jmaxalloced), char *)+jmaxalloced_, int *);
	}
	bool blocking = N2J_CAST_VAR(jblocking != 0, bool);

	FMOD_RESULT result_ = FMOD::Memory_GetStats(currentalloced, maxalloced, blocking);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_FmodEx_1Debug_1SetLevel(JNIEnv *java_env, jclass jcls, jint jlevel) {
	FMOD_DEBUGLEVEL level = (FMOD_DEBUGLEVEL)jlevel;

	FMOD_RESULT result_ = FMOD::Debug_SetLevel(level);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_FmodEx_1Debug_1GetLevel(JNIEnv *java_env, jclass jcls, jobject jlevel, jlong jlevel_) {
	FMOD_DEBUGLEVEL *level = 0;
	if(jlevel) {
		level = N2J_CAST_VAR(N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jlevel), char *)+jlevel_, int *), FMOD_DEBUGLEVEL *);
	}

	FMOD_RESULT result_ = FMOD::Debug_GetLevel(level);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_FmodEx_1File_1SetDiskBusy(JNIEnv *java_env, jclass jcls, jint jbusy) {
	int busy = (int)jbusy;

	FMOD_RESULT result_ = FMOD::File_SetDiskBusy(busy);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_FmodEx_1File_1GetDiskBusy(JNIEnv *java_env, jclass jcls, jobject jbusy, jlong jbusy_) {
	int *busy = 0;
	if(jbusy) {
		busy = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jbusy), char *)+jbusy_, int *);
	}

	FMOD_RESULT result_ = FMOD::File_GetDiskBusy(busy);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_FmodEx_1System_1Create(JNIEnv *java_env, jclass jcls, jobject jsystem) {
	FMOD::System *system/* = 0*/;

	FMOD_RESULT result_ = FMOD::System_Create(&system);

	if(jsystem) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, FMOD::System *) = system;
		setPointerAddress(java_env, jsystem, newAddress);
	}
	return (jint)result_;
}


