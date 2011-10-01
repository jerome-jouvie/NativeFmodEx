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
//#include "malloc.h"
#include "CallbackManager.h"

jclass byteBufferClass = 0;
jclass getByteBufferClass(JNIEnv *java_env) {
	if(!byteBufferClass) {
		byteBufferClass = (jclass)java_env->NewGlobalRef(java_env->FindClass("java/nio/ByteBuffer"));
	}
	return byteBufferClass;
}

jclass caller = 0;
jboolean connectCaller(JNIEnv *java_env) {
	caller = (jclass)java_env->NewGlobalRef(java_env->FindClass("org/jouvieje/fmoddesigner/callbacks/CallbackBridge"));
	if(java_env->ExceptionCheck()) {
		java_env->ExceptionDescribe();
		java_env->ExceptionClear();
		caller = 0;
	}
	return (jboolean)(caller != 0);
}

jmethodID callbackId[3];
jboolean connectCallbacks(JNIEnv *java_env) {
	static struct {
		const char *name;
		const char *signature;
	}callbacks[3] = {
		{"FMOD_EVENTQUEUE_CALLBACK_BRIDGE", "(IJJJ)I"},
		{"FMOD_EVENT_CALLBACK_BRIDGE", "(JIJLorg/jouvieje/fmodex/utils/Pointer;J)I"},
		{"FMOD_MUSIC_CALLBACK_BRIDGE", "(IJJJ)I"}
	};

	for(int i = 0; i < 3; i++) {
		callbackId[i] = java_env->GetStaticMethodID(caller, callbacks[i].name, callbacks[i].signature);
		if(java_env->ExceptionCheck()) {
			java_env->ExceptionDescribe();
			java_env->ExceptionClear();
			return (jboolean)false;
		}
	}
	return (jboolean)true;
}

JavaVM *jvm;
jboolean attachJavaVM(JNIEnv *java_env) {
	java_env->GetJavaVM(&jvm);
	if(!connectCaller(java_env)) {
		return (jboolean)false;
	}
	return connectCallbacks(java_env);
}
bool acquire_jenv(JNIEnv **java_env) {
	if(jvm->GetEnv((void **)java_env, JNI_VERSION_1_4) != JNI_OK) {
		jvm->AttachCurrentThread((void **)java_env, 0);
		return true;
	}
	return false;
}
void leave_jenv(bool attached) {
	if(attached) {
		jvm->DetachCurrentThread();
	}
}

FMOD_RESULT F_CALLBACK FMOD_EVENTQUEUE_CALLBACK_BRIDGE(FMOD_EVENTQUEUE_CALLBACKTYPE type, FMOD_EVENTQUEUE * queue, FMOD_EVENTQUEUEENTRY * entry, void * callbackuserdata) {
	JNIEnv *java_env/* = 0*/;
	bool attached = acquire_jenv(&java_env);
	POINTER_TYPE jqueue/* = 0*/;
	N2J_CAST_PTR(jqueue, FMOD_EVENTQUEUE *) = (FMOD_EVENTQUEUE *)queue;
	POINTER_TYPE jentry/* = 0*/;
	N2J_CAST_PTR(jentry, FMOD_EVENTQUEUEENTRY *) = (FMOD_EVENTQUEUEENTRY *)entry;
	POINTER_TYPE jcallbackuserdata/* = 0*/;
	N2J_CAST_PTR(jcallbackuserdata, void *) = callbackuserdata;
	jint result_ = java_env->CallStaticIntMethod(caller, callbackId[0], (jint)type, (jlong)jqueue, (jlong)jentry, (jlong)jcallbackuserdata);
	leave_jenv(attached);
	return (FMOD_RESULT)result_;
}

FMOD_RESULT F_CALLBACK FMOD_EVENT_CALLBACK_BRIDGE(FMOD_EVENT * event, FMOD_EVENT_CALLBACKTYPE type, void * param1, void * param2, void * userdata) {
	JNIEnv *java_env/* = 0*/;
	bool attached = acquire_jenv(&java_env);
	POINTER_TYPE jevent/* = 0*/;
	N2J_CAST_PTR(jevent, FMOD_EVENT *) = (FMOD_EVENT *)event;
	POINTER_TYPE jparam1/* = 0*/;
	N2J_CAST_PTR(jparam1, void *) = param1;
	POINTER_TYPE param2NewPointerAddress/* = 0*/;
	N2J_CAST_PTR(param2NewPointerAddress, void *) = param2;
	jobject jparam2 = newPointer(java_env, param2NewPointerAddress);
	POINTER_TYPE juserdata/* = 0*/;
	N2J_CAST_PTR(juserdata, void *) = userdata;
	jint result_ = java_env->CallStaticIntMethod(caller, callbackId[1], (jlong)jevent, (jint)type, (jlong)jparam1, (jobject)jparam2, (jlong)juserdata);
	if(jparam2) {
		if(type == FMOD_EVENT_CALLBACKTYPE_SOUNDDEF_CREATE) {
			POINTER_TYPE jparam2Address = getPointerAddress(java_env, jparam2);
			if(jparam2Address) {
				N2J_CAST_PTR(param2, FMOD::Sound *) = N2J_CAST_PTR(jparam2Address, FMOD::Sound *);
			}
		}
		else if(type == FMOD_EVENT_CALLBACKTYPE_SOUNDDEF_SELECTINDEX) {
			POINTER_TYPE jparam2Address = getPointerAddress(java_env, jparam2);
			if(jparam2Address) {
				*(int *)param2 = *N2J_CAST_PTR(jparam2Address, int *);
			}
		}
	}
	leave_jenv(attached);
	return (FMOD_RESULT)result_;
}

FMOD_RESULT F_CALLBACK FMOD_MUSIC_CALLBACK_BRIDGE(FMOD_MUSIC_CALLBACKTYPE type, void * param1, void * param2, void * userdata) {
	JNIEnv *java_env/* = 0*/;
	bool attached = acquire_jenv(&java_env);
	POINTER_TYPE jparam1/* = 0*/;
	N2J_CAST_PTR(jparam1, void *) = param1;
	POINTER_TYPE jparam2/* = 0*/;
	N2J_CAST_PTR(jparam2, void *) = param2;
	POINTER_TYPE juserdata/* = 0*/;
	N2J_CAST_PTR(juserdata, void *) = userdata;
	jint result_ = java_env->CallStaticIntMethod(caller, callbackId[2], (jint)type, (jlong)jparam1, (jlong)jparam2, (jlong)juserdata);
	leave_jenv(attached);
	return (FMOD_RESULT)result_;
}


