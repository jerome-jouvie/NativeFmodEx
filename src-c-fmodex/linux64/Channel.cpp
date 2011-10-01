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

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Channel_1getSystemObject(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jsystem) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD::System *system/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Channel *)->getSystemObject(&system);

	if(jsystem) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, FMOD::System *) = system;
		setPointerAddress(java_env, jsystem, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Channel_1stop(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Channel *)->stop();

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Channel_1setPaused(JNIEnv *java_env, jclass jcls, jlong jpointer, jboolean jpaused) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	bool paused = N2J_CAST_VAR(jpaused != 0, bool);

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Channel *)->setPaused(paused);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Channel_1getPaused(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jpaused, jlong jpaused_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	bool *paused = 0;
	if(jpaused) {
		paused = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jpaused), char *)+jpaused_, bool *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Channel *)->getPaused(paused);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Channel_1setVolume(JNIEnv *java_env, jclass jcls, jlong jpointer, jfloat jvolume) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float volume = (float)jvolume;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Channel *)->setVolume(volume);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Channel_1getVolume(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jvolume, jlong jvolume_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float *volume = 0;
	if(jvolume) {
		volume = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jvolume), char *)+jvolume_, float *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Channel *)->getVolume(volume);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Channel_1setFrequency(JNIEnv *java_env, jclass jcls, jlong jpointer, jfloat jfrequency) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float frequency = (float)jfrequency;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Channel *)->setFrequency(frequency);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Channel_1getFrequency(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jfrequency, jlong jfrequency_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float *frequency = 0;
	if(jfrequency) {
		frequency = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jfrequency), char *)+jfrequency_, float *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Channel *)->getFrequency(frequency);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Channel_1setPan(JNIEnv *java_env, jclass jcls, jlong jpointer, jfloat jpan) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float pan = (float)jpan;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Channel *)->setPan(pan);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Channel_1getPan(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jpan, jlong jpan_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float *pan = 0;
	if(jpan) {
		pan = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jpan), char *)+jpan_, float *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Channel *)->getPan(pan);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Channel_1setDelay(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jdelaytype, jint jdelayhi, jint jdelaylo) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD_DELAYTYPE delaytype = (FMOD_DELAYTYPE)jdelaytype;
	int delayhi = (int)jdelayhi;
	int delaylo = (int)jdelaylo;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Channel *)->setDelay(delaytype, delayhi, delaylo);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Channel_1getDelay(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jdelaytype, jobject jdelayhi, jlong jdelayhi_, jobject jdelaylo, jlong jdelaylo_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD_DELAYTYPE delaytype = (FMOD_DELAYTYPE)jdelaytype;
	unsigned int *delayhi = 0;
	if(jdelayhi) {
		delayhi = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jdelayhi), char *)+jdelayhi_, unsigned int *);
	}
	unsigned int *delaylo = 0;
	if(jdelaylo) {
		delaylo = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jdelaylo), char *)+jdelaylo_, unsigned int *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Channel *)->getDelay(delaytype, delayhi, delaylo);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Channel_1setSpeakerMix(JNIEnv *java_env, jclass jcls, jlong jpointer, jfloat jfrontleft, jfloat jfrontright, jfloat jcenter, jfloat jlfe, jfloat jbackleft, jfloat jbackright, jfloat jsideleft, jfloat jsideright) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float frontleft = (float)jfrontleft;
	float frontright = (float)jfrontright;
	float center = (float)jcenter;
	float lfe = (float)jlfe;
	float backleft = (float)jbackleft;
	float backright = (float)jbackright;
	float sideleft = (float)jsideleft;
	float sideright = (float)jsideright;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Channel *)->setSpeakerMix(frontleft, frontright, center, lfe, backleft, backright, sideleft, sideright);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Channel_1getSpeakerMix(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jfrontleft, jlong jfrontleft_, jobject jfrontright, jlong jfrontright_, jobject jcenter, jlong jcenter_, jobject jlfe, jlong jlfe_, jobject jbackleft, jlong jbackleft_, jobject jbackright, jlong jbackright_, jobject jsideleft, jlong jsideleft_, jobject jsideright, jlong jsideright_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float *frontleft = 0;
	if(jfrontleft) {
		frontleft = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jfrontleft), char *)+jfrontleft_, float *);
	}
	float *frontright = 0;
	if(jfrontright) {
		frontright = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jfrontright), char *)+jfrontright_, float *);
	}
	float *center = 0;
	if(jcenter) {
		center = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jcenter), char *)+jcenter_, float *);
	}
	float *lfe = 0;
	if(jlfe) {
		lfe = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jlfe), char *)+jlfe_, float *);
	}
	float *backleft = 0;
	if(jbackleft) {
		backleft = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jbackleft), char *)+jbackleft_, float *);
	}
	float *backright = 0;
	if(jbackright) {
		backright = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jbackright), char *)+jbackright_, float *);
	}
	float *sideleft = 0;
	if(jsideleft) {
		sideleft = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jsideleft), char *)+jsideleft_, float *);
	}
	float *sideright = 0;
	if(jsideright) {
		sideright = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jsideright), char *)+jsideright_, float *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Channel *)->getSpeakerMix(frontleft, frontright, center, lfe, backleft, backright, sideleft, sideright);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Channel_1setSpeakerLevels(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jspeaker, jobject jlevels, jlong jlevels_, jint jnumlevels) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD_SPEAKER speaker = (FMOD_SPEAKER)jspeaker;
	float *levels = 0;
	if(jlevels) {
		levels = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jlevels), char *)+jlevels_, float *);
	}
	int numlevels = (int)jnumlevels;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Channel *)->setSpeakerLevels(speaker, levels, numlevels);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Channel_1getSpeakerLevels(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jspeaker, jobject jlevels, jlong jlevels_, jint jnumlevels) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD_SPEAKER speaker = (FMOD_SPEAKER)jspeaker;
	float *levels = 0;
	if(jlevels) {
		levels = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jlevels), char *)+jlevels_, float *);
	}
	int numlevels = (int)jnumlevels;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Channel *)->getSpeakerLevels(speaker, levels, numlevels);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Channel_1setInputChannelMix(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jlevels, jlong jlevels_, jint jnumlevels) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float *levels = 0;
	if(jlevels) {
		levels = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jlevels), char *)+jlevels_, float *);
	}
	int numlevels = (int)jnumlevels;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Channel *)->setInputChannelMix(levels, numlevels);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Channel_1getInputChannelMix(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jlevels, jlong jlevels_, jint jnumlevels) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float *levels = 0;
	if(jlevels) {
		levels = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jlevels), char *)+jlevels_, float *);
	}
	int numlevels = (int)jnumlevels;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Channel *)->getInputChannelMix(levels, numlevels);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Channel_1setMute(JNIEnv *java_env, jclass jcls, jlong jpointer, jboolean jmute) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	bool mute = N2J_CAST_VAR(jmute != 0, bool);

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Channel *)->setMute(mute);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Channel_1getMute(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jmute, jlong jmute_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	bool *mute = 0;
	if(jmute) {
		mute = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jmute), char *)+jmute_, bool *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Channel *)->getMute(mute);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Channel_1setPriority(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jpriority) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int priority = (int)jpriority;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Channel *)->setPriority(priority);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Channel_1getPriority(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jpriority, jlong jpriority_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int *priority = 0;
	if(jpriority) {
		priority = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jpriority), char *)+jpriority_, int *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Channel *)->getPriority(priority);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Channel_1setPosition(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jposition, jint jpostype) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int position = (int)jposition;
	FMOD_TIMEUNIT postype = (FMOD_TIMEUNIT)jpostype;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Channel *)->setPosition(position, postype);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Channel_1getPosition(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jposition, jlong jposition_, jint jpostype) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	unsigned int *position = 0;
	if(jposition) {
		position = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jposition), char *)+jposition_, unsigned int *);
	}
	FMOD_TIMEUNIT postype = (FMOD_TIMEUNIT)jpostype;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Channel *)->getPosition(position, postype);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Channel_1setReverbProperties(JNIEnv *java_env, jclass jcls, jlong jpointer, jlong jprop) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD_REVERB_CHANNELPROPERTIES *prop = 0;
	if(jprop) {
		POINTER_TYPE propTmp = (POINTER_TYPE)jprop;
		prop = N2J_CAST_PTR(propTmp, FMOD_REVERB_CHANNELPROPERTIES *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Channel *)->setReverbProperties(prop);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Channel_1getReverbProperties(JNIEnv *java_env, jclass jcls, jlong jpointer, jlong jprop) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD_REVERB_CHANNELPROPERTIES *prop = 0;
	if(jprop) {
		POINTER_TYPE propTmp = (POINTER_TYPE)jprop;
		prop = N2J_CAST_PTR(propTmp, FMOD_REVERB_CHANNELPROPERTIES *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Channel *)->getReverbProperties(prop);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Channel_1setLowPassGain(JNIEnv *java_env, jclass jcls, jlong jpointer, jfloat jgain) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float gain = (float)jgain;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Channel *)->setLowPassGain(gain);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Channel_1getLowPassGain(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jgain, jlong jgain_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float *gain = 0;
	if(jgain) {
		gain = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jgain), char *)+jgain_, float *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Channel *)->getLowPassGain(gain);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Channel_1setChannelGroup(JNIEnv *java_env, jclass jcls, jlong jpointer, jlong jchannelgroup) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD::ChannelGroup *channelgroup = 0;
	if(jchannelgroup) {
		POINTER_TYPE channelgroupTmp = (POINTER_TYPE)jchannelgroup;
		channelgroup = N2J_CAST_PTR(channelgroupTmp, FMOD::ChannelGroup *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Channel *)->setChannelGroup(channelgroup);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Channel_1getChannelGroup(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jchannelgroup) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD::ChannelGroup *channelgroup/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Channel *)->getChannelGroup(&channelgroup);

	if(jchannelgroup) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, FMOD::ChannelGroup *) = channelgroup;
		setPointerAddress(java_env, jchannelgroup, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Channel_1setCallback(JNIEnv *java_env, jclass jcls, jlong jpointer, jboolean jcallback) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Channel *)->setCallback(jcallback == 0 ? NULL : FMOD_CHANNEL_CALLBACK_BRIDGE);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Channel_1set3DAttributes(JNIEnv *java_env, jclass jcls, jlong jpointer, jlong jpos, jlong jvel) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD_VECTOR *pos = 0;
	if(jpos) {
		POINTER_TYPE posTmp = (POINTER_TYPE)jpos;
		pos = N2J_CAST_PTR(posTmp, FMOD_VECTOR *);
	}
	FMOD_VECTOR *vel = 0;
	if(jvel) {
		POINTER_TYPE velTmp = (POINTER_TYPE)jvel;
		vel = N2J_CAST_PTR(velTmp, FMOD_VECTOR *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Channel *)->set3DAttributes(pos, vel);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Channel_1get3DAttributes(JNIEnv *java_env, jclass jcls, jlong jpointer, jlong jpos, jlong jvel) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD_VECTOR *pos = 0;
	if(jpos) {
		POINTER_TYPE posTmp = (POINTER_TYPE)jpos;
		pos = N2J_CAST_PTR(posTmp, FMOD_VECTOR *);
	}
	FMOD_VECTOR *vel = 0;
	if(jvel) {
		POINTER_TYPE velTmp = (POINTER_TYPE)jvel;
		vel = N2J_CAST_PTR(velTmp, FMOD_VECTOR *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Channel *)->get3DAttributes(pos, vel);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Channel_1set3DMinMaxDistance(JNIEnv *java_env, jclass jcls, jlong jpointer, jfloat jmindistance, jfloat jmaxdistance) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float mindistance = (float)jmindistance;
	float maxdistance = (float)jmaxdistance;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Channel *)->set3DMinMaxDistance(mindistance, maxdistance);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Channel_1get3DMinMaxDistance(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jmindistance, jlong jmindistance_, jobject jmaxdistance, jlong jmaxdistance_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float *mindistance = 0;
	if(jmindistance) {
		mindistance = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jmindistance), char *)+jmindistance_, float *);
	}
	float *maxdistance = 0;
	if(jmaxdistance) {
		maxdistance = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jmaxdistance), char *)+jmaxdistance_, float *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Channel *)->get3DMinMaxDistance(mindistance, maxdistance);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Channel_1set3DConeSettings(JNIEnv *java_env, jclass jcls, jlong jpointer, jfloat jinsideconeangle, jfloat joutsideconeangle, jfloat joutsidevolume) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float insideconeangle = (float)jinsideconeangle;
	float outsideconeangle = (float)joutsideconeangle;
	float outsidevolume = (float)joutsidevolume;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Channel *)->set3DConeSettings(insideconeangle, outsideconeangle, outsidevolume);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Channel_1get3DConeSettings(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jinsideconeangle, jlong jinsideconeangle_, jobject joutsideconeangle, jlong joutsideconeangle_, jobject joutsidevolume, jlong joutsidevolume_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float *insideconeangle = 0;
	if(jinsideconeangle) {
		insideconeangle = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jinsideconeangle), char *)+jinsideconeangle_, float *);
	}
	float *outsideconeangle = 0;
	if(joutsideconeangle) {
		outsideconeangle = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(joutsideconeangle), char *)+joutsideconeangle_, float *);
	}
	float *outsidevolume = 0;
	if(joutsidevolume) {
		outsidevolume = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(joutsidevolume), char *)+joutsidevolume_, float *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Channel *)->get3DConeSettings(insideconeangle, outsideconeangle, outsidevolume);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Channel_1set3DConeOrientation(JNIEnv *java_env, jclass jcls, jlong jpointer, jlong jorientation) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD_VECTOR *orientation = 0;
	if(jorientation) {
		POINTER_TYPE orientationTmp = (POINTER_TYPE)jorientation;
		orientation = N2J_CAST_PTR(orientationTmp, FMOD_VECTOR *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Channel *)->set3DConeOrientation(orientation);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Channel_1get3DConeOrientation(JNIEnv *java_env, jclass jcls, jlong jpointer, jlong jorientation) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD_VECTOR *orientation = 0;
	if(jorientation) {
		POINTER_TYPE orientationTmp = (POINTER_TYPE)jorientation;
		orientation = N2J_CAST_PTR(orientationTmp, FMOD_VECTOR *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Channel *)->get3DConeOrientation(orientation);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Channel_1set3DCustomRolloff(JNIEnv *java_env, jclass jcls, jlong jpointer, jlong jpoints, jint jnumpoints) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD_VECTOR *points = 0;
	if(jpoints) {
		POINTER_TYPE pointsTmp = (POINTER_TYPE)jpoints;
		points = N2J_CAST_PTR(pointsTmp, FMOD_VECTOR *);
	}
	int numpoints = (int)jnumpoints;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Channel *)->set3DCustomRolloff(points, numpoints);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Channel_1get3DCustomRolloff(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jpoints, jobject jnumpoints, jlong jnumpoints_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD_VECTOR *points/* = 0*/;
	int *numpoints = 0;
	if(jnumpoints) {
		numpoints = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jnumpoints), char *)+jnumpoints_, int *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Channel *)->get3DCustomRolloff(&points, numpoints);

	if(jpoints) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, FMOD_VECTOR *) = points;
		setPointerAddress(java_env, jpoints, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Channel_1set3DOcclusion(JNIEnv *java_env, jclass jcls, jlong jpointer, jfloat jdirectocclusion, jfloat jreverbocclusion) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float directocclusion = (float)jdirectocclusion;
	float reverbocclusion = (float)jreverbocclusion;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Channel *)->set3DOcclusion(directocclusion, reverbocclusion);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Channel_1get3DOcclusion(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jdirectocclusion, jlong jdirectocclusion_, jobject jreverbocclusion, jlong jreverbocclusion_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float *directocclusion = 0;
	if(jdirectocclusion) {
		directocclusion = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jdirectocclusion), char *)+jdirectocclusion_, float *);
	}
	float *reverbocclusion = 0;
	if(jreverbocclusion) {
		reverbocclusion = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jreverbocclusion), char *)+jreverbocclusion_, float *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Channel *)->get3DOcclusion(directocclusion, reverbocclusion);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Channel_1set3DSpread(JNIEnv *java_env, jclass jcls, jlong jpointer, jfloat jangle) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float angle = (float)jangle;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Channel *)->set3DSpread(angle);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Channel_1get3DSpread(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jangle, jlong jangle_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float *angle = 0;
	if(jangle) {
		angle = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jangle), char *)+jangle_, float *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Channel *)->get3DSpread(angle);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Channel_1set3DPanLevel(JNIEnv *java_env, jclass jcls, jlong jpointer, jfloat jlevel) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float level = (float)jlevel;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Channel *)->set3DPanLevel(level);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Channel_1get3DPanLevel(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jlevel, jlong jlevel_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float *level = 0;
	if(jlevel) {
		level = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jlevel), char *)+jlevel_, float *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Channel *)->get3DPanLevel(level);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Channel_1set3DDopplerLevel(JNIEnv *java_env, jclass jcls, jlong jpointer, jfloat jlevel) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float level = (float)jlevel;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Channel *)->set3DDopplerLevel(level);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Channel_1get3DDopplerLevel(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jlevel, jlong jlevel_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float *level = 0;
	if(jlevel) {
		level = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jlevel), char *)+jlevel_, float *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Channel *)->get3DDopplerLevel(level);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Channel_1getDSPHead(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jdsp) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD::DSP *dsp/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Channel *)->getDSPHead(&dsp);

	if(jdsp) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, FMOD::DSP *) = dsp;
		setPointerAddress(java_env, jdsp, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Channel_1addDSP(JNIEnv *java_env, jclass jcls, jlong jpointer, jlong jdsp, jobject jconnection) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD::DSP *dsp = 0;
	if(jdsp) {
		POINTER_TYPE dspTmp = (POINTER_TYPE)jdsp;
		dsp = N2J_CAST_PTR(dspTmp, FMOD::DSP *);
	}
	FMOD::DSPConnection *connection/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Channel *)->addDSP(dsp, &connection);

	if(jconnection) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, FMOD::DSPConnection *) = connection;
		setPointerAddress(java_env, jconnection, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Channel_1isPlaying(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jisplaying, jlong jisplaying_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	bool *isplaying = 0;
	if(jisplaying) {
		isplaying = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jisplaying), char *)+jisplaying_, bool *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Channel *)->isPlaying(isplaying);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Channel_1isVirtual(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jis, jlong jis_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	bool *is = 0;
	if(jis) {
		is = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jis), char *)+jis_, bool *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Channel *)->isVirtual(is);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Channel_1getAudibility(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jaudibility, jlong jaudibility_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float *audibility = 0;
	if(jaudibility) {
		audibility = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jaudibility), char *)+jaudibility_, float *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Channel *)->getAudibility(audibility);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Channel_1getCurrentSound(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jsound) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD::Sound *sound/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Channel *)->getCurrentSound(&sound);

	if(jsound) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, FMOD::Sound *) = sound;
		setPointerAddress(java_env, jsound, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Channel_1getSpectrum(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jspectrumarray, jlong jspectrumarray_, jint jnumvalues, jint jchanneloffset, jint jwindowtype) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float *spectrumarray = 0;
	if(jspectrumarray) {
		spectrumarray = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jspectrumarray), char *)+jspectrumarray_, float *);
	}
	int numvalues = (int)jnumvalues;
	int channeloffset = (int)jchanneloffset;
	FMOD_DSP_FFT_WINDOW windowtype = (FMOD_DSP_FFT_WINDOW)jwindowtype;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Channel *)->getSpectrum(spectrumarray, numvalues, channeloffset, windowtype);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Channel_1getWaveData(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jwavearray, jlong jwavearray_, jint jnumvalues, jint jchanneloffset) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float *wavearray = 0;
	if(jwavearray) {
		wavearray = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jwavearray), char *)+jwavearray_, float *);
	}
	int numvalues = (int)jnumvalues;
	int channeloffset = (int)jchanneloffset;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Channel *)->getWaveData(wavearray, numvalues, channeloffset);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Channel_1getIndex(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jindex, jlong jindex_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int *index = 0;
	if(jindex) {
		index = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jindex), char *)+jindex_, int *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Channel *)->getIndex(index);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Channel_1setMode(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jmode) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD_MODE mode = (FMOD_MODE)jmode;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Channel *)->setMode(mode);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Channel_1getMode(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jmode, jlong jmode_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD_MODE *mode = 0;
	if(jmode) {
		mode = N2J_CAST_VAR(N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jmode), char *)+jmode_, int *), FMOD_MODE *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Channel *)->getMode(mode);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Channel_1setLoopCount(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jloopcount) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int loopcount = (int)jloopcount;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Channel *)->setLoopCount(loopcount);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Channel_1getLoopCount(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jloopcount, jlong jloopcount_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int *loopcount = 0;
	if(jloopcount) {
		loopcount = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jloopcount), char *)+jloopcount_, int *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Channel *)->getLoopCount(loopcount);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Channel_1setLoopPoints(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jloopstart, jint jloopstarttype, jint jloopend, jint jloopendtype) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int loopstart = (int)jloopstart;
	FMOD_TIMEUNIT loopstarttype = (FMOD_TIMEUNIT)jloopstarttype;
	int loopend = (int)jloopend;
	FMOD_TIMEUNIT loopendtype = (FMOD_TIMEUNIT)jloopendtype;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Channel *)->setLoopPoints(loopstart, loopstarttype, loopend, loopendtype);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Channel_1getLoopPoints(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jloopstart, jlong jloopstart_, jint jloopstarttype, jobject jloopend, jlong jloopend_, jint jloopendtype) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	unsigned int *loopstart = 0;
	if(jloopstart) {
		loopstart = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jloopstart), char *)+jloopstart_, unsigned int *);
	}
	FMOD_TIMEUNIT loopstarttype = (FMOD_TIMEUNIT)jloopstarttype;
	unsigned int *loopend = 0;
	if(jloopend) {
		loopend = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jloopend), char *)+jloopend_, unsigned int *);
	}
	FMOD_TIMEUNIT loopendtype = (FMOD_TIMEUNIT)jloopendtype;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Channel *)->getLoopPoints(loopstart, loopstarttype, loopend, loopendtype);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Channel_1setUserData(JNIEnv *java_env, jclass jcls, jlong jpointer, jlong juserdata) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	POINTER_TYPE userdataTmp = (POINTER_TYPE)juserdata;
	void *userdata = N2J_CAST_PTR(userdataTmp, void *);

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Channel *)->setUserData(userdata);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Channel_1getUserData(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject juserdata) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	void *userdata/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Channel *)->getUserData(&userdata);

	if(juserdata) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, void *) = userdata;
		setPointerAddress(java_env, juserdata, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Channel_1getMemoryInfo(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jmemorybits, jint jevent_memorybits, jobject jmemoryused, jlong jmemoryused_, jlong jmemoryused_details) {
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

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Channel *)->getMemoryInfo(memorybits, event_memorybits, memoryused, memoryused_details);

	return (jint)result_;
}


