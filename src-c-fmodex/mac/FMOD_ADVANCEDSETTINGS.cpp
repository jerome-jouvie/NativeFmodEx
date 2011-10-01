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
#include "org_jouvieje_fmodex_structures_StructureJNI.h"
#include "CallbackManager.h"

JNIEXPORT jlong JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1ADVANCEDSETTINGS_1new(JNIEnv *java_env, jclass jcls) {
	FMOD_ADVANCEDSETTINGS *result_ = new FMOD_ADVANCEDSETTINGS();
	CheckAllocation(java_env, result_);
	result_->cbsize = sizeof(FMOD_ADVANCEDSETTINGS);
	POINTER_TYPE jresult/* = 0*/;
	N2J_CAST_PTR(jresult, FMOD_ADVANCEDSETTINGS *) = result_;
	return (jlong)jresult;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1ADVANCEDSETTINGS_1delete(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	delete N2J_CAST_PTR(pointer, FMOD_ADVANCEDSETTINGS *);
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1ADVANCEDSETTINGS_1get_1cbsize(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int result_ = N2J_CAST_PTR(pointer, FMOD_ADVANCEDSETTINGS *)->cbsize;
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1ADVANCEDSETTINGS_1get_1maxMPEGcodecs(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int result_ = N2J_CAST_PTR(pointer, FMOD_ADVANCEDSETTINGS *)->maxMPEGcodecs;
	return (jint)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1ADVANCEDSETTINGS_1set_1maxMPEGcodecs(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jmaxMPEGcodecs) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int maxMPEGcodecs = (int)jmaxMPEGcodecs;
	N2J_CAST_PTR(pointer, FMOD_ADVANCEDSETTINGS *)->maxMPEGcodecs = maxMPEGcodecs;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1ADVANCEDSETTINGS_1get_1maxADPCMcodecs(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int result_ = N2J_CAST_PTR(pointer, FMOD_ADVANCEDSETTINGS *)->maxADPCMcodecs;
	return (jint)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1ADVANCEDSETTINGS_1set_1maxADPCMcodecs(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jmaxADPCMcodecs) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int maxADPCMcodecs = (int)jmaxADPCMcodecs;
	N2J_CAST_PTR(pointer, FMOD_ADVANCEDSETTINGS *)->maxADPCMcodecs = maxADPCMcodecs;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1ADVANCEDSETTINGS_1get_1maxXMAcodecs(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int result_ = N2J_CAST_PTR(pointer, FMOD_ADVANCEDSETTINGS *)->maxXMAcodecs;
	return (jint)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1ADVANCEDSETTINGS_1set_1maxXMAcodecs(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jmaxXMAcodecs) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int maxXMAcodecs = (int)jmaxXMAcodecs;
	N2J_CAST_PTR(pointer, FMOD_ADVANCEDSETTINGS *)->maxXMAcodecs = maxXMAcodecs;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1ADVANCEDSETTINGS_1get_1maxCELTcodecs(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int result_ = N2J_CAST_PTR(pointer, FMOD_ADVANCEDSETTINGS *)->maxCELTcodecs;
	return (jint)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1ADVANCEDSETTINGS_1set_1maxCELTcodecs(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jmaxCELTcodecs) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int maxCELTcodecs = (int)jmaxCELTcodecs;
	N2J_CAST_PTR(pointer, FMOD_ADVANCEDSETTINGS *)->maxCELTcodecs = maxCELTcodecs;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1ADVANCEDSETTINGS_1get_1maxPCMcodecs(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int result_ = N2J_CAST_PTR(pointer, FMOD_ADVANCEDSETTINGS *)->maxPCMcodecs;
	return (jint)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1ADVANCEDSETTINGS_1set_1maxPCMcodecs(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jmaxPCMcodecs) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int maxPCMcodecs = (int)jmaxPCMcodecs;
	N2J_CAST_PTR(pointer, FMOD_ADVANCEDSETTINGS *)->maxPCMcodecs = maxPCMcodecs;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1ADVANCEDSETTINGS_1get_1ASIONumChannels(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int result_ = N2J_CAST_PTR(pointer, FMOD_ADVANCEDSETTINGS *)->ASIONumChannels;
	return (jint)result_;
}

JNIEXPORT jobjectArray JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1ADVANCEDSETTINGS_1get_1ASIOChannelList(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	char **result = N2J_CAST_PTR(pointer, FMOD_ADVANCEDSETTINGS *)->ASIOChannelList;
	jint size = (jint)N2J_CAST_PTR(pointer, FMOD_ADVANCEDSETTINGS *)->ASIONumChannels;
	jobjectArray jresult = java_env->NewObjectArray(size, getStringClass(java_env), 0);
	for(int i = 0; i < size; i++) {
		jobject resulti = java_env->NewStringUTF((const char *)result[i]);
		java_env->SetObjectArrayElement(jresult, N2J_CAST_VAR(N2J_CAST_VAR(i, jint), jsize), resulti);
	}
	return jresult;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1ADVANCEDSETTINGS_1set_1ASIOChannelList(JNIEnv *java_env, jclass jcls, jlong jpointer, jobjectArray jASIOChannelList) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	{ //Memory deletion
		char ** ASIOChannelListMem_ = N2J_CAST_PTR(pointer, FMOD_ADVANCEDSETTINGS *)->ASIOChannelList;
		if(ASIOChannelListMem_) {
			int ASIOChannelListLen_ = N2J_CAST_PTR(pointer, FMOD_ADVANCEDSETTINGS *)->ASIONumChannels;
			for(int i = 0; i < ASIOChannelListLen_; i++) {
				delete[] (ASIOChannelListMem_[i]);
			}
			delete[] ASIOChannelListMem_;
		}
	}
	
	int size = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetArrayLength(jASIOChannelList), jint), int);
	
	char **cresult = NULL;
	if(size > 0) {
		cresult = new char *[size];
		CheckAllocation(java_env, cresult);
		for(int i = 0; i < size; i++) {
			jstring jstringi = (jstring)java_env->GetObjectArrayElement(jASIOChannelList, N2J_CAST_VAR(N2J_CAST_VAR(i, jint), jsize));
			char* cstringi = getStringElements(java_env, jstringi);
			cresult[i] = cstringi;
		}
	}
	N2J_CAST_PTR(pointer, FMOD_ADVANCEDSETTINGS *)->ASIOChannelList = cresult;
#if 1
	N2J_CAST_PTR(pointer, FMOD_ADVANCEDSETTINGS *)->ASIONumChannels = size;
#endif
}

JNIEXPORT jobject JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1ADVANCEDSETTINGS_1get_1ASIOSpeakerList(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int size = N2J_CAST_PTR(pointer, FMOD_ADVANCEDSETTINGS *)->ASIONumChannels;
	jobject jresult = 0;
	if(size > 0) {
		FMOD_SPEAKER *result_ = (FMOD_SPEAKER *)N2J_CAST_PTR(pointer, FMOD_ADVANCEDSETTINGS *)->ASIOSpeakerList;
		if(result_) {
			jresult = java_env->NewDirectByteBuffer(result_, size * sizeof(FMOD_SPEAKER));
		}
	}
	return jresult;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1ADVANCEDSETTINGS_1set_1ASIOSpeakerList(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jASIOSpeakerList, jlong jASIOSpeakerList_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	{ //Memory deletion
		FMOD_SPEAKER *ASIOSpeakerListMem_ = N2J_CAST_PTR(pointer, FMOD_ADVANCEDSETTINGS *)->ASIOSpeakerList;
		if(ASIOSpeakerListMem_) {
			delete[] ASIOSpeakerListMem_;
		}
	}
	
	FMOD_SPEAKER *ASIOSpeakerList = 0;
	if(jASIOSpeakerList) {
		ASIOSpeakerList = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(java_env->NewGlobalRef(jASIOSpeakerList)), char *)+jASIOSpeakerList_, FMOD_SPEAKER *);
	}
	N2J_CAST_PTR(pointer, FMOD_ADVANCEDSETTINGS *)->ASIOSpeakerList = ASIOSpeakerList;
#if 1
	N2J_CAST_PTR(pointer, FMOD_ADVANCEDSETTINGS *)->ASIONumChannels = (jASIOSpeakerList) ? N2J_CAST_VAR((java_env->GetDirectBufferCapacity(jASIOSpeakerList) - jASIOSpeakerList_) / sizeof(FMOD_SPEAKER), int) : 0;
#endif
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1ADVANCEDSETTINGS_1get_1max3DReverbDSPs(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int result_ = N2J_CAST_PTR(pointer, FMOD_ADVANCEDSETTINGS *)->max3DReverbDSPs;
	return (jint)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1ADVANCEDSETTINGS_1set_1max3DReverbDSPs(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jmax3DReverbDSPs) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int max3DReverbDSPs = (int)jmax3DReverbDSPs;
	N2J_CAST_PTR(pointer, FMOD_ADVANCEDSETTINGS *)->max3DReverbDSPs = max3DReverbDSPs;
}

JNIEXPORT jfloat JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1ADVANCEDSETTINGS_1get_1HRTFMinAngle(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float result_ = N2J_CAST_PTR(pointer, FMOD_ADVANCEDSETTINGS *)->HRTFMinAngle;
	return (jfloat)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1ADVANCEDSETTINGS_1set_1HRTFMinAngle(JNIEnv *java_env, jclass jcls, jlong jpointer, jfloat jHRTFMinAngle) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float HRTFMinAngle = (float)jHRTFMinAngle;
	N2J_CAST_PTR(pointer, FMOD_ADVANCEDSETTINGS *)->HRTFMinAngle = HRTFMinAngle;
}

JNIEXPORT jfloat JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1ADVANCEDSETTINGS_1get_1HRTFMaxAngle(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float result_ = N2J_CAST_PTR(pointer, FMOD_ADVANCEDSETTINGS *)->HRTFMaxAngle;
	return (jfloat)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1ADVANCEDSETTINGS_1set_1HRTFMaxAngle(JNIEnv *java_env, jclass jcls, jlong jpointer, jfloat jHRTFMaxAngle) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float HRTFMaxAngle = (float)jHRTFMaxAngle;
	N2J_CAST_PTR(pointer, FMOD_ADVANCEDSETTINGS *)->HRTFMaxAngle = HRTFMaxAngle;
}

JNIEXPORT jfloat JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1ADVANCEDSETTINGS_1get_1HRTFFreq(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float result_ = N2J_CAST_PTR(pointer, FMOD_ADVANCEDSETTINGS *)->HRTFFreq;
	return (jfloat)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1ADVANCEDSETTINGS_1set_1HRTFFreq(JNIEnv *java_env, jclass jcls, jlong jpointer, jfloat jHRTFFreq) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float HRTFFreq = (float)jHRTFFreq;
	N2J_CAST_PTR(pointer, FMOD_ADVANCEDSETTINGS *)->HRTFFreq = HRTFFreq;
}

JNIEXPORT jfloat JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1ADVANCEDSETTINGS_1get_1vol0virtualvol(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float result_ = N2J_CAST_PTR(pointer, FMOD_ADVANCEDSETTINGS *)->vol0virtualvol;
	return (jfloat)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1ADVANCEDSETTINGS_1set_1vol0virtualvol(JNIEnv *java_env, jclass jcls, jlong jpointer, jfloat jvol0virtualvol) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float vol0virtualvol = (float)jvol0virtualvol;
	N2J_CAST_PTR(pointer, FMOD_ADVANCEDSETTINGS *)->vol0virtualvol = vol0virtualvol;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1ADVANCEDSETTINGS_1get_1eventqueuesize(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int result_ = N2J_CAST_PTR(pointer, FMOD_ADVANCEDSETTINGS *)->eventqueuesize;
	return (jint)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1ADVANCEDSETTINGS_1set_1eventqueuesize(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jeventqueuesize) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int eventqueuesize = (int)jeventqueuesize;
	N2J_CAST_PTR(pointer, FMOD_ADVANCEDSETTINGS *)->eventqueuesize = eventqueuesize;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1ADVANCEDSETTINGS_1get_1defaultDecodeBufferSize(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int result_ = N2J_CAST_PTR(pointer, FMOD_ADVANCEDSETTINGS *)->defaultDecodeBufferSize;
	return (jint)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1ADVANCEDSETTINGS_1set_1defaultDecodeBufferSize(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jdefaultDecodeBufferSize) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int defaultDecodeBufferSize = (int)jdefaultDecodeBufferSize;
	N2J_CAST_PTR(pointer, FMOD_ADVANCEDSETTINGS *)->defaultDecodeBufferSize = defaultDecodeBufferSize;
}

JNIEXPORT jstring JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1ADVANCEDSETTINGS_1get_1debugLogFilename(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	char *result_ = N2J_CAST_VAR(N2J_CAST_PTR(pointer, FMOD_ADVANCEDSETTINGS *)->debugLogFilename, char *);
	jstring jresult = 0;
	if(result_) {
		jresult = java_env->NewStringUTF((const char *)result_);
	}
	return jresult;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1ADVANCEDSETTINGS_1set_1debugLogFilename(JNIEnv *java_env, jclass jcls, jlong jpointer, jbyteArray jdebugLogFilename) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	char *debugLogFilename = 0;
	if(jdebugLogFilename) {
		debugLogFilename = (char *)getByteArrayElements(java_env, jdebugLogFilename);
		N2J_CAST_PTR(pointer, FMOD_ADVANCEDSETTINGS *)->debugLogFilename = debugLogFilename;
	}
	else {
		N2J_CAST_PTR(pointer, FMOD_ADVANCEDSETTINGS *)->debugLogFilename = (char *)0;
	}
}

JNIEXPORT jshort JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1ADVANCEDSETTINGS_1get_1profileport(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	short result_ = N2J_CAST_PTR(pointer, FMOD_ADVANCEDSETTINGS *)->profileport;
	return (jshort)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1ADVANCEDSETTINGS_1set_1profileport(JNIEnv *java_env, jclass jcls, jlong jpointer, jshort jprofileport) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	short profileport = (short)jprofileport;
	N2J_CAST_PTR(pointer, FMOD_ADVANCEDSETTINGS *)->profileport = profileport;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1ADVANCEDSETTINGS_1get_1geometryMaxFadeTime(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int result_ = N2J_CAST_PTR(pointer, FMOD_ADVANCEDSETTINGS *)->geometryMaxFadeTime;
	return (jint)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1ADVANCEDSETTINGS_1set_1geometryMaxFadeTime(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jgeometryMaxFadeTime) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int geometryMaxFadeTime = (int)jgeometryMaxFadeTime;
	N2J_CAST_PTR(pointer, FMOD_ADVANCEDSETTINGS *)->geometryMaxFadeTime = geometryMaxFadeTime;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1ADVANCEDSETTINGS_1get_1maxSpectrumWaveDataBuffers(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int result_ = N2J_CAST_PTR(pointer, FMOD_ADVANCEDSETTINGS *)->maxSpectrumWaveDataBuffers;
	return (jint)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1ADVANCEDSETTINGS_1set_1maxSpectrumWaveDataBuffers(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jmaxSpectrumWaveDataBuffers) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int maxSpectrumWaveDataBuffers = (int)jmaxSpectrumWaveDataBuffers;
	N2J_CAST_PTR(pointer, FMOD_ADVANCEDSETTINGS *)->maxSpectrumWaveDataBuffers = maxSpectrumWaveDataBuffers;
}



