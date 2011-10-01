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

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_ChannelGroup_1release(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::ChannelGroup *)->release();

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_ChannelGroup_1getSystemObject(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jsystem) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD::System *system/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::ChannelGroup *)->getSystemObject(&system);

	if(jsystem) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, FMOD::System *) = system;
		setPointerAddress(java_env, jsystem, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_ChannelGroup_1setVolume(JNIEnv *java_env, jclass jcls, jlong jpointer, jfloat jvolume) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float volume = (float)jvolume;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::ChannelGroup *)->setVolume(volume);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_ChannelGroup_1getVolume(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jvolume, jlong jvolume_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float *volume = 0;
	if(jvolume) {
		volume = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jvolume), char *)+jvolume_, float *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::ChannelGroup *)->getVolume(volume);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_ChannelGroup_1setPitch(JNIEnv *java_env, jclass jcls, jlong jpointer, jfloat jpitch) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float pitch = (float)jpitch;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::ChannelGroup *)->setPitch(pitch);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_ChannelGroup_1getPitch(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jpitch, jlong jpitch_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float *pitch = 0;
	if(jpitch) {
		pitch = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jpitch), char *)+jpitch_, float *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::ChannelGroup *)->getPitch(pitch);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_ChannelGroup_1set3DOcclusion(JNIEnv *java_env, jclass jcls, jlong jpointer, jfloat jdirectocclusion, jfloat jreverbocclusion) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float directocclusion = (float)jdirectocclusion;
	float reverbocclusion = (float)jreverbocclusion;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::ChannelGroup *)->set3DOcclusion(directocclusion, reverbocclusion);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_ChannelGroup_1get3DOcclusion(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jdirectocclusion, jlong jdirectocclusion_, jobject jreverbocclusion, jlong jreverbocclusion_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float *directocclusion = 0;
	if(jdirectocclusion) {
		directocclusion = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jdirectocclusion), char *)+jdirectocclusion_, float *);
	}
	float *reverbocclusion = 0;
	if(jreverbocclusion) {
		reverbocclusion = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jreverbocclusion), char *)+jreverbocclusion_, float *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::ChannelGroup *)->get3DOcclusion(directocclusion, reverbocclusion);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_ChannelGroup_1setPaused(JNIEnv *java_env, jclass jcls, jlong jpointer, jboolean jpaused) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	bool paused = N2J_CAST_VAR(jpaused != 0, bool);

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::ChannelGroup *)->setPaused(paused);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_ChannelGroup_1getPaused(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jpaused, jlong jpaused_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	bool *paused = 0;
	if(jpaused) {
		paused = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jpaused), char *)+jpaused_, bool *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::ChannelGroup *)->getPaused(paused);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_ChannelGroup_1setMute(JNIEnv *java_env, jclass jcls, jlong jpointer, jboolean jmute) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	bool mute = N2J_CAST_VAR(jmute != 0, bool);

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::ChannelGroup *)->setMute(mute);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_ChannelGroup_1getMute(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jmute, jlong jmute_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	bool *mute = 0;
	if(jmute) {
		mute = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jmute), char *)+jmute_, bool *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::ChannelGroup *)->getMute(mute);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_ChannelGroup_1stop(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::ChannelGroup *)->stop();

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_ChannelGroup_1overrideVolume(JNIEnv *java_env, jclass jcls, jlong jpointer, jfloat jvolume) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float volume = (float)jvolume;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::ChannelGroup *)->overrideVolume(volume);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_ChannelGroup_1overrideFrequency(JNIEnv *java_env, jclass jcls, jlong jpointer, jfloat jfrequency) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float frequency = (float)jfrequency;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::ChannelGroup *)->overrideFrequency(frequency);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_ChannelGroup_1overridePan(JNIEnv *java_env, jclass jcls, jlong jpointer, jfloat jpan) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float pan = (float)jpan;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::ChannelGroup *)->overridePan(pan);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_ChannelGroup_1overrideReverbProperties(JNIEnv *java_env, jclass jcls, jlong jpointer, jlong jprop) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD_REVERB_CHANNELPROPERTIES *prop = 0;
	if(jprop) {
		POINTER_TYPE propTmp = (POINTER_TYPE)jprop;
		prop = N2J_CAST_PTR(propTmp, FMOD_REVERB_CHANNELPROPERTIES *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::ChannelGroup *)->overrideReverbProperties(prop);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_ChannelGroup_1override3DAttributes(JNIEnv *java_env, jclass jcls, jlong jpointer, jlong jpos, jlong jvel) {
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

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::ChannelGroup *)->override3DAttributes(pos, vel);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_ChannelGroup_1overrideSpeakerMix(JNIEnv *java_env, jclass jcls, jlong jpointer, jfloat jfrontleft, jfloat jfrontright, jfloat jcenter, jfloat jlfe, jfloat jbackleft, jfloat jbackright, jfloat jsideleft, jfloat jsideright) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float frontleft = (float)jfrontleft;
	float frontright = (float)jfrontright;
	float center = (float)jcenter;
	float lfe = (float)jlfe;
	float backleft = (float)jbackleft;
	float backright = (float)jbackright;
	float sideleft = (float)jsideleft;
	float sideright = (float)jsideright;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::ChannelGroup *)->overrideSpeakerMix(frontleft, frontright, center, lfe, backleft, backright, sideleft, sideright);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_ChannelGroup_1addGroup(JNIEnv *java_env, jclass jcls, jlong jpointer, jlong jgroup) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD::ChannelGroup *group = 0;
	if(jgroup) {
		POINTER_TYPE groupTmp = (POINTER_TYPE)jgroup;
		group = N2J_CAST_PTR(groupTmp, FMOD::ChannelGroup *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::ChannelGroup *)->addGroup(group);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_ChannelGroup_1getNumGroups(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jnumgroups, jlong jnumgroups_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int *numgroups = 0;
	if(jnumgroups) {
		numgroups = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jnumgroups), char *)+jnumgroups_, int *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::ChannelGroup *)->getNumGroups(numgroups);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_ChannelGroup_1getGroup(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jindex, jobject jgroup) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int index = (int)jindex;
	FMOD::ChannelGroup *group/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::ChannelGroup *)->getGroup(index, &group);

	if(jgroup) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, FMOD::ChannelGroup *) = group;
		setPointerAddress(java_env, jgroup, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_ChannelGroup_1getParentGroup(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jgroup) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD::ChannelGroup *group/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::ChannelGroup *)->getParentGroup(&group);

	if(jgroup) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, FMOD::ChannelGroup *) = group;
		setPointerAddress(java_env, jgroup, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_ChannelGroup_1getDSPHead(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jdsp) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD::DSP *dsp/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::ChannelGroup *)->getDSPHead(&dsp);

	if(jdsp) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, FMOD::DSP *) = dsp;
		setPointerAddress(java_env, jdsp, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_ChannelGroup_1addDSP(JNIEnv *java_env, jclass jcls, jlong jpointer, jlong jdsp, jobject jconnection) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD::DSP *dsp = 0;
	if(jdsp) {
		POINTER_TYPE dspTmp = (POINTER_TYPE)jdsp;
		dsp = N2J_CAST_PTR(dspTmp, FMOD::DSP *);
	}
	FMOD::DSPConnection *connection/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::ChannelGroup *)->addDSP(dsp, &connection);

	if(jconnection) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, FMOD::DSPConnection *) = connection;
		setPointerAddress(java_env, jconnection, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_ChannelGroup_1getName(JNIEnv *java_env, jclass jcls, jlong jpointer, 	jobject jname, jlong jname_, jint jnamelen) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	char *name = 0;
	if(jname) {
		name = N2J_CAST_VAR(java_env->GetDirectBufferAddress(jname), char *)+jname_;
	}
	int namelen = (int)jnamelen;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::ChannelGroup *)->getName(name, namelen);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_ChannelGroup_1getNumChannels(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jnumchannels, jlong jnumchannels_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int *numchannels = 0;
	if(jnumchannels) {
		numchannels = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jnumchannels), char *)+jnumchannels_, int *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::ChannelGroup *)->getNumChannels(numchannels);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_ChannelGroup_1getChannel(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jindex, jobject jchannel) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int index = (int)jindex;
	FMOD::Channel *channel/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::ChannelGroup *)->getChannel(index, &channel);

	if(jchannel) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, FMOD::Channel *) = channel;
		setPointerAddress(java_env, jchannel, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_ChannelGroup_1getSpectrum(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jspectrumarray, jlong jspectrumarray_, jint jnumvalues, jint jchanneloffset, jint jwindowtype) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float *spectrumarray = 0;
	if(jspectrumarray) {
		spectrumarray = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jspectrumarray), char *)+jspectrumarray_, float *);
	}
	int numvalues = (int)jnumvalues;
	int channeloffset = (int)jchanneloffset;
	FMOD_DSP_FFT_WINDOW windowtype = (FMOD_DSP_FFT_WINDOW)jwindowtype;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::ChannelGroup *)->getSpectrum(spectrumarray, numvalues, channeloffset, windowtype);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_ChannelGroup_1getWaveData(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jwavearray, jlong jwavearray_, jint jnumvalues, jint jchanneloffset) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float *wavearray = 0;
	if(jwavearray) {
		wavearray = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jwavearray), char *)+jwavearray_, float *);
	}
	int numvalues = (int)jnumvalues;
	int channeloffset = (int)jchanneloffset;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::ChannelGroup *)->getWaveData(wavearray, numvalues, channeloffset);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_ChannelGroup_1setUserData(JNIEnv *java_env, jclass jcls, jlong jpointer, jlong juserdata) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	POINTER_TYPE userdataTmp = (POINTER_TYPE)juserdata;
	void *userdata = N2J_CAST_PTR(userdataTmp, void *);

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::ChannelGroup *)->setUserData(userdata);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_ChannelGroup_1getUserData(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject juserdata) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	void *userdata/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::ChannelGroup *)->getUserData(&userdata);

	if(juserdata) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, void *) = userdata;
		setPointerAddress(java_env, juserdata, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_ChannelGroup_1getMemoryInfo(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jmemorybits, jint jevent_memorybits, jobject jmemoryused, jlong jmemoryused_, jlong jmemoryused_details) {
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

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::ChannelGroup *)->getMemoryInfo(memorybits, event_memorybits, memoryused, memoryused_details);

	return (jint)result_;
}


