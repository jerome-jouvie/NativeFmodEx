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

JNIEXPORT jlong JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_MusicSystem_1newArray(JNIEnv *java_env, jclass jcls, jint length) {
	FMOD::MusicSystem **array = new FMOD::MusicSystem *[(int)length];
	if((int)length > 0) { CheckAllocation(java_env, array); }
	POINTER_TYPE jresult/* = 0*/;
	N2J_CAST_PTR(jresult, FMOD::MusicSystem **) = array;
	return (jlong)jresult;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_MusicSystem_1SIZEOF(JNIEnv *java_env, jclass jcls) {
	return (jint)sizeof(FMOD::MusicSystem *);
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_MusicSystem_1reset(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::MusicSystem *)->reset();

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_MusicSystem_1setVolume(JNIEnv *java_env, jclass jcls, jlong jpointer, jfloat jvolume) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float volume = (float)jvolume;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::MusicSystem *)->setVolume(volume);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_MusicSystem_1getVolume(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jvolume, jlong jvolume_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float *volume = 0;
	if(jvolume) {
		volume = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jvolume), char *)+jvolume_, float *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::MusicSystem *)->getVolume(volume);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_MusicSystem_1setReverbProperties(JNIEnv *java_env, jclass jcls, jlong jpointer, jlong jprops) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD_REVERB_CHANNELPROPERTIES *props = 0;
	if(jprops) {
		POINTER_TYPE propsTmp = (POINTER_TYPE)jprops;
		props = N2J_CAST_PTR(propsTmp, FMOD_REVERB_CHANNELPROPERTIES *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::MusicSystem *)->setReverbProperties(props);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_MusicSystem_1getReverbProperties(JNIEnv *java_env, jclass jcls, jlong jpointer, jlong jprops) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD_REVERB_CHANNELPROPERTIES *props = 0;
	if(jprops) {
		POINTER_TYPE propsTmp = (POINTER_TYPE)jprops;
		props = N2J_CAST_PTR(propsTmp, FMOD_REVERB_CHANNELPROPERTIES *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::MusicSystem *)->getReverbProperties(props);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_MusicSystem_1setPaused(JNIEnv *java_env, jclass jcls, jlong jpointer, jboolean jpaused) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	bool paused = N2J_CAST_VAR(jpaused != 0, bool);

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::MusicSystem *)->setPaused(paused);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_MusicSystem_1getPaused(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jpaused, jlong jpaused_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	bool *paused = 0;
	if(jpaused) {
		paused = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jpaused), char *)+jpaused_, bool *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::MusicSystem *)->getPaused(paused);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_MusicSystem_1setMute(JNIEnv *java_env, jclass jcls, jlong jpointer, jboolean jmute) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	bool mute = N2J_CAST_VAR(jmute != 0, bool);

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::MusicSystem *)->setMute(mute);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_MusicSystem_1getMute(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jmute, jlong jmute_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	bool *mute = 0;
	if(jmute) {
		mute = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jmute), char *)+jmute_, bool *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::MusicSystem *)->getMute(mute);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_MusicSystem_1getInfo(JNIEnv *java_env, jclass jcls, jlong jpointer, jlong jinfo) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD_MUSIC_INFO *info = 0;
	if(jinfo) {
		POINTER_TYPE infoTmp = (POINTER_TYPE)jinfo;
		info = N2J_CAST_PTR(infoTmp, FMOD_MUSIC_INFO *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::MusicSystem *)->getInfo(info);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_MusicSystem_1promptCue(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jid) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD_MUSIC_CUE_ID id = (FMOD_MUSIC_CUE_ID)jid;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::MusicSystem *)->promptCue(id);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_MusicSystem_1prepareCue(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jid, jobject jprompt) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD_MUSIC_CUE_ID id = (FMOD_MUSIC_CUE_ID)jid;
	FMOD::MusicPrompt *prompt/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::MusicSystem *)->prepareCue(id, &prompt);

	if(jprompt) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, FMOD::MusicPrompt *) = prompt;
		setPointerAddress(java_env, jprompt, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_MusicSystem_1getParameterValue(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jid, jobject jparameter, jlong jparameter_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD_MUSIC_PARAM_ID id = (FMOD_MUSIC_PARAM_ID)jid;
	float *parameter = 0;
	if(jparameter) {
		parameter = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jparameter), char *)+jparameter_, float *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::MusicSystem *)->getParameterValue(id, parameter);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_MusicSystem_1setParameterValue(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jid, jfloat jparameter) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD_MUSIC_PARAM_ID id = (FMOD_MUSIC_PARAM_ID)jid;
	float parameter = (float)jparameter;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::MusicSystem *)->setParameterValue(id, parameter);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_MusicSystem_1getCues(JNIEnv *java_env, jclass jcls, jlong jpointer, jlong jit, jbyteArray jfilter) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD_MUSIC_ITERATOR *it = 0;
	if(jit) {
		POINTER_TYPE itTmp = (POINTER_TYPE)jit;
		it = N2J_CAST_PTR(itTmp, FMOD_MUSIC_ITERATOR *);
	}
	const char *filter = (const char *)getByteArrayElements(java_env, jfilter);

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::MusicSystem *)->getCues(it, filter);

	releaseByteArrayElements(java_env, jfilter, (const char *)filter);
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_MusicSystem_1getNextCue(JNIEnv *java_env, jclass jcls, jlong jpointer, jlong jit) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD_MUSIC_ITERATOR *it = 0;
	if(jit) {
		POINTER_TYPE itTmp = (POINTER_TYPE)jit;
		it = N2J_CAST_PTR(itTmp, FMOD_MUSIC_ITERATOR *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::MusicSystem *)->getNextCue(it);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_MusicSystem_1getParameters(JNIEnv *java_env, jclass jcls, jlong jpointer, jlong jit, jbyteArray jfilter) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD_MUSIC_ITERATOR *it = 0;
	if(jit) {
		POINTER_TYPE itTmp = (POINTER_TYPE)jit;
		it = N2J_CAST_PTR(itTmp, FMOD_MUSIC_ITERATOR *);
	}
	const char *filter = (const char *)getByteArrayElements(java_env, jfilter);

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::MusicSystem *)->getParameters(it, filter);

	releaseByteArrayElements(java_env, jfilter, (const char *)filter);
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_MusicSystem_1getNextParameter(JNIEnv *java_env, jclass jcls, jlong jpointer, jlong jit) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD_MUSIC_ITERATOR *it = 0;
	if(jit) {
		POINTER_TYPE itTmp = (POINTER_TYPE)jit;
		it = N2J_CAST_PTR(itTmp, FMOD_MUSIC_ITERATOR *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::MusicSystem *)->getNextParameter(it);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_MusicSystem_1loadSoundData(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jresource, jint jmode) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD_EVENT_RESOURCE resource = (FMOD_EVENT_RESOURCE)jresource;
	FMOD_EVENT_MODE mode = (FMOD_EVENT_MODE)jmode;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::MusicSystem *)->loadSoundData(resource, mode);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_MusicSystem_1freeSoundData(JNIEnv *java_env, jclass jcls, jlong jpointer, jboolean jwaituntilready) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	bool waituntilready = N2J_CAST_VAR(jwaituntilready != 0, bool);

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::MusicSystem *)->freeSoundData(waituntilready);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_MusicSystem_1setCallback(JNIEnv *java_env, jclass jcls, jlong jpointer, jboolean jcallback, jlong juserdata) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	POINTER_TYPE userdataTmp = (POINTER_TYPE)juserdata;
	void *userdata = N2J_CAST_PTR(userdataTmp, void *);

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::MusicSystem *)->setCallback(jcallback == 0 ? NULL : FMOD_MUSIC_CALLBACK_BRIDGE, userdata);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_MusicSystem_1getMemoryInfo(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jmemorybits, jint jevent_memorybits, jobject jmemoryused, jlong jmemoryused_, jlong jmemoryused_details) {
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

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::MusicSystem *)->getMemoryInfo(memorybits, event_memorybits, memoryused, memoryused_details);

	return (jint)result_;
}


