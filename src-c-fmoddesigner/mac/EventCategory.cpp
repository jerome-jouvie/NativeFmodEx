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

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventCategory_1getInfo(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jindex, jlong jindex_, jobject jname) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int *index = 0;
	if(jindex) {
		index = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jindex), char *)+jindex_, int *);
	}
	char *name/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventCategory *)->getInfo(index, &name);

	if(jname) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, char *) = name;
		setPointerAddress(java_env, jname, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventCategory_1getCategory(JNIEnv *java_env, jclass jcls, jlong jpointer, jbyteArray jname, jobject jcategory) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	const char *name = (const char *)getByteArrayElements(java_env, jname);
	FMOD::EventCategory *category/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventCategory *)->getCategory(name, &category);

	releaseByteArrayElements(java_env, jname, (const char *)name);
	if(jcategory) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, FMOD::EventCategory *) = category;
		setPointerAddress(java_env, jcategory, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventCategory_1getCategoryByIndex(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jindex, jobject jcategory) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int index = (int)jindex;
	FMOD::EventCategory *category/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventCategory *)->getCategoryByIndex(index, &category);

	if(jcategory) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, FMOD::EventCategory *) = category;
		setPointerAddress(java_env, jcategory, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventCategory_1getNumCategories(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jnumcategories, jlong jnumcategories_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int *numcategories = 0;
	if(jnumcategories) {
		numcategories = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jnumcategories), char *)+jnumcategories_, int *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventCategory *)->getNumCategories(numcategories);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventCategory_1getEventByIndex(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jindex, jint jmode, jobject jevent) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int index = (int)jindex;
	FMOD_EVENT_MODE mode = (FMOD_EVENT_MODE)jmode;
	FMOD::Event *event/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventCategory *)->getEventByIndex(index, mode, &event);

	if(jevent) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, FMOD::Event *) = event;
		setPointerAddress(java_env, jevent, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventCategory_1getNumEvents(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jnumevents, jlong jnumevents_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int *numevents = 0;
	if(jnumevents) {
		numevents = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jnumevents), char *)+jnumevents_, int *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventCategory *)->getNumEvents(numevents);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventCategory_1getParentCategory(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jcategory) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD::EventCategory *category/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventCategory *)->getParentCategory(&category);

	if(jcategory) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, FMOD::EventCategory *) = category;
		setPointerAddress(java_env, jcategory, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventCategory_1stopAllEvents(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventCategory *)->stopAllEvents();

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventCategory_1setVolume(JNIEnv *java_env, jclass jcls, jlong jpointer, jfloat jvolume) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float volume = (float)jvolume;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventCategory *)->setVolume(volume);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventCategory_1getVolume(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jvolume, jlong jvolume_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float *volume = 0;
	if(jvolume) {
		volume = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jvolume), char *)+jvolume_, float *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventCategory *)->getVolume(volume);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventCategory_1setPitch(JNIEnv *java_env, jclass jcls, jlong jpointer, jfloat jpitch, jint junits) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float pitch = (float)jpitch;
	FMOD_EVENT_PITCHUNITS units = (FMOD_EVENT_PITCHUNITS)junits;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventCategory *)->setPitch(pitch, units);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventCategory_1getPitch(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jpitch, jlong jpitch_, jint junits) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float *pitch = 0;
	if(jpitch) {
		pitch = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jpitch), char *)+jpitch_, float *);
	}
	FMOD_EVENT_PITCHUNITS units = (FMOD_EVENT_PITCHUNITS)junits;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventCategory *)->getPitch(pitch, units);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventCategory_1setPaused(JNIEnv *java_env, jclass jcls, jlong jpointer, jboolean jpaused) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	bool paused = N2J_CAST_VAR(jpaused != 0, bool);

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventCategory *)->setPaused(paused);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventCategory_1getPaused(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jpaused, jlong jpaused_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	bool *paused = 0;
	if(jpaused) {
		paused = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jpaused), char *)+jpaused_, bool *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventCategory *)->getPaused(paused);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventCategory_1setMute(JNIEnv *java_env, jclass jcls, jlong jpointer, jboolean jmute) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	bool mute = N2J_CAST_VAR(jmute != 0, bool);

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventCategory *)->setMute(mute);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventCategory_1getMute(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jmute, jlong jmute_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	bool *mute = 0;
	if(jmute) {
		mute = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jmute), char *)+jmute_, bool *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventCategory *)->getMute(mute);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventCategory_1getChannelGroup(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jchannelgroup) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD::ChannelGroup *channelgroup/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventCategory *)->getChannelGroup(&channelgroup);

	if(jchannelgroup) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, FMOD::ChannelGroup *) = channelgroup;
		setPointerAddress(java_env, jchannelgroup, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventCategory_1setUserData(JNIEnv *java_env, jclass jcls, jlong jpointer, jlong juserdata) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	POINTER_TYPE userdataTmp = (POINTER_TYPE)juserdata;
	void *userdata = N2J_CAST_PTR(userdataTmp, void *);

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventCategory *)->setUserData(userdata);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventCategory_1getUserData(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject juserdata) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	void *userdata/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventCategory *)->getUserData(&userdata);

	if(juserdata) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, void *) = userdata;
		setPointerAddress(java_env, juserdata, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventCategory_1getMemoryInfo(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jmemorybits, jint jevent_memorybits, jobject jmemoryused, jlong jmemoryused_, jlong jmemoryused_details) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int memorybits = (int)jmemorybits;
	int event_memorybits = (int)jevent_memorybits;
	unsigned int *memoryused = 0;
	if(jmemoryused) {
		memoryused = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jmemoryused), char *)+jmemoryused_, unsigned int *);
	}
	FMOD_MEMORY_USAGE_DETAILS *memoryused_details = 0;
	if(jmemoryused_details) {
		POINTER_TYPE memoryused_detailsTmp = (POINTER_TYPE)jmemoryused_details;
		memoryused_details = N2J_CAST_PTR(memoryused_detailsTmp, FMOD_MEMORY_USAGE_DETAILS *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventCategory *)->getMemoryInfo(memorybits, event_memorybits, memoryused, memoryused_details);

	return (jint)result_;
}


