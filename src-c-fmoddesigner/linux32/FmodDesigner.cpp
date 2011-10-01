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
#include "org_jouvieje_fmoddesigner_FmodDesignerJNI.h"
#include "CallbackManager.h"

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_FmodDesigner_1EventSystem_1Create(JNIEnv *java_env, jclass jcls, jobject jeventsystem) {
	FMOD::EventSystem *eventsystem/* = 0*/;

	FMOD_RESULT result_ = FMOD::EventSystem_Create(&eventsystem);

	if(jeventsystem) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, FMOD::EventSystem *) = eventsystem;
		setPointerAddress(java_env, jeventsystem, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_FmodDesigner_1NetEventSystem_1Init(JNIEnv *java_env, jclass jcls, jlong jeventsystem, jshort jport) {
	FMOD::EventSystem *eventsystem = 0;
	if(jeventsystem) {
		POINTER_TYPE eventsystemTmp = (POINTER_TYPE)jeventsystem;
		eventsystem = N2J_CAST_PTR(eventsystemTmp, FMOD::EventSystem *);
	}
	short port = (short)jport;

	FMOD_RESULT result_ = FMOD::NetEventSystem_Init(eventsystem, port);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_FmodDesigner_1NetEventSystem_1Update(JNIEnv *java_env, jclass jcls) {

	FMOD_RESULT result_ = FMOD::NetEventSystem_Update();

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_FmodDesigner_1NetEventSystem_1Shutdown(JNIEnv *java_env, jclass jcls) {

	FMOD_RESULT result_ = FMOD::NetEventSystem_Shutdown();

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_FmodDesigner_1NetEventSystem_1GetVersion(JNIEnv *java_env, jclass jcls, jobject jversion, jlong jversion_) {
	unsigned int *version = 0;
	if(jversion) {
		version = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jversion), char *)+jversion_, unsigned int *);
	}

	FMOD_RESULT result_ = FMOD::NetEventSystem_GetVersion(version);

	return (jint)result_;
}


