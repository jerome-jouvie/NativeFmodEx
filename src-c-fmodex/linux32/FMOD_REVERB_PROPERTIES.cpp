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

JNIEXPORT jlong JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1REVERB_1PROPERTIES_1new(JNIEnv *java_env, jclass jcls) {
	FMOD_REVERB_PROPERTIES *result_ = new FMOD_REVERB_PROPERTIES();
	CheckAllocation(java_env, result_);
	POINTER_TYPE jresult/* = 0*/;
	N2J_CAST_PTR(jresult, FMOD_REVERB_PROPERTIES *) = result_;
	return (jlong)jresult;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1REVERB_1PROPERTIES_1delete(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	delete N2J_CAST_PTR(pointer, FMOD_REVERB_PROPERTIES *);
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1REVERB_1PROPERTIES_1get_1Instance(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int result_ = N2J_CAST_PTR(pointer, FMOD_REVERB_PROPERTIES *)->Instance;
	return (jint)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1REVERB_1PROPERTIES_1set_1Instance(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jInstance) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int Instance = (int)jInstance;
	N2J_CAST_PTR(pointer, FMOD_REVERB_PROPERTIES *)->Instance = Instance;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1REVERB_1PROPERTIES_1get_1Environment(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int result_ = N2J_CAST_PTR(pointer, FMOD_REVERB_PROPERTIES *)->Environment;
	return (jint)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1REVERB_1PROPERTIES_1set_1Environment(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jEnvironment) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int Environment = (int)jEnvironment;
	N2J_CAST_PTR(pointer, FMOD_REVERB_PROPERTIES *)->Environment = Environment;
}

JNIEXPORT jfloat JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1REVERB_1PROPERTIES_1get_1EnvSize(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float result_ = N2J_CAST_PTR(pointer, FMOD_REVERB_PROPERTIES *)->EnvSize;
	return (jfloat)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1REVERB_1PROPERTIES_1set_1EnvSize(JNIEnv *java_env, jclass jcls, jlong jpointer, jfloat jEnvSize) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float EnvSize = (float)jEnvSize;
	N2J_CAST_PTR(pointer, FMOD_REVERB_PROPERTIES *)->EnvSize = EnvSize;
}

JNIEXPORT jfloat JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1REVERB_1PROPERTIES_1get_1EnvDiffusion(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float result_ = N2J_CAST_PTR(pointer, FMOD_REVERB_PROPERTIES *)->EnvDiffusion;
	return (jfloat)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1REVERB_1PROPERTIES_1set_1EnvDiffusion(JNIEnv *java_env, jclass jcls, jlong jpointer, jfloat jEnvDiffusion) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float EnvDiffusion = (float)jEnvDiffusion;
	N2J_CAST_PTR(pointer, FMOD_REVERB_PROPERTIES *)->EnvDiffusion = EnvDiffusion;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1REVERB_1PROPERTIES_1get_1Room(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int result_ = N2J_CAST_PTR(pointer, FMOD_REVERB_PROPERTIES *)->Room;
	return (jint)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1REVERB_1PROPERTIES_1set_1Room(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jRoom) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int Room = (int)jRoom;
	N2J_CAST_PTR(pointer, FMOD_REVERB_PROPERTIES *)->Room = Room;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1REVERB_1PROPERTIES_1get_1RoomHF(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int result_ = N2J_CAST_PTR(pointer, FMOD_REVERB_PROPERTIES *)->RoomHF;
	return (jint)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1REVERB_1PROPERTIES_1set_1RoomHF(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jRoomHF) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int RoomHF = (int)jRoomHF;
	N2J_CAST_PTR(pointer, FMOD_REVERB_PROPERTIES *)->RoomHF = RoomHF;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1REVERB_1PROPERTIES_1get_1RoomLF(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int result_ = N2J_CAST_PTR(pointer, FMOD_REVERB_PROPERTIES *)->RoomLF;
	return (jint)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1REVERB_1PROPERTIES_1set_1RoomLF(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jRoomLF) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int RoomLF = (int)jRoomLF;
	N2J_CAST_PTR(pointer, FMOD_REVERB_PROPERTIES *)->RoomLF = RoomLF;
}

JNIEXPORT jfloat JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1REVERB_1PROPERTIES_1get_1DecayTime(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float result_ = N2J_CAST_PTR(pointer, FMOD_REVERB_PROPERTIES *)->DecayTime;
	return (jfloat)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1REVERB_1PROPERTIES_1set_1DecayTime(JNIEnv *java_env, jclass jcls, jlong jpointer, jfloat jDecayTime) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float DecayTime = (float)jDecayTime;
	N2J_CAST_PTR(pointer, FMOD_REVERB_PROPERTIES *)->DecayTime = DecayTime;
}

JNIEXPORT jfloat JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1REVERB_1PROPERTIES_1get_1DecayHFRatio(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float result_ = N2J_CAST_PTR(pointer, FMOD_REVERB_PROPERTIES *)->DecayHFRatio;
	return (jfloat)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1REVERB_1PROPERTIES_1set_1DecayHFRatio(JNIEnv *java_env, jclass jcls, jlong jpointer, jfloat jDecayHFRatio) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float DecayHFRatio = (float)jDecayHFRatio;
	N2J_CAST_PTR(pointer, FMOD_REVERB_PROPERTIES *)->DecayHFRatio = DecayHFRatio;
}

JNIEXPORT jfloat JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1REVERB_1PROPERTIES_1get_1DecayLFRatio(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float result_ = N2J_CAST_PTR(pointer, FMOD_REVERB_PROPERTIES *)->DecayLFRatio;
	return (jfloat)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1REVERB_1PROPERTIES_1set_1DecayLFRatio(JNIEnv *java_env, jclass jcls, jlong jpointer, jfloat jDecayLFRatio) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float DecayLFRatio = (float)jDecayLFRatio;
	N2J_CAST_PTR(pointer, FMOD_REVERB_PROPERTIES *)->DecayLFRatio = DecayLFRatio;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1REVERB_1PROPERTIES_1get_1Reflections(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int result_ = N2J_CAST_PTR(pointer, FMOD_REVERB_PROPERTIES *)->Reflections;
	return (jint)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1REVERB_1PROPERTIES_1set_1Reflections(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jReflections) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int Reflections = (int)jReflections;
	N2J_CAST_PTR(pointer, FMOD_REVERB_PROPERTIES *)->Reflections = Reflections;
}

JNIEXPORT jfloat JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1REVERB_1PROPERTIES_1get_1ReflectionsDelay(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float result_ = N2J_CAST_PTR(pointer, FMOD_REVERB_PROPERTIES *)->ReflectionsDelay;
	return (jfloat)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1REVERB_1PROPERTIES_1set_1ReflectionsDelay(JNIEnv *java_env, jclass jcls, jlong jpointer, jfloat jReflectionsDelay) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float ReflectionsDelay = (float)jReflectionsDelay;
	N2J_CAST_PTR(pointer, FMOD_REVERB_PROPERTIES *)->ReflectionsDelay = ReflectionsDelay;
}

JNIEXPORT jobject JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1REVERB_1PROPERTIES_1get_1ReflectionsPan(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float *result_ = (float *)N2J_CAST_PTR(pointer, FMOD_REVERB_PROPERTIES *)->ReflectionsPan;
	jobject jresult = 0;
	if(result_) {
		jresult = java_env->NewDirectByteBuffer((float *)result_, N2J_CAST_VAR(3*sizeof(float), jlong));
	}
	return jresult;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1REVERB_1PROPERTIES_1set_1ReflectionsPan(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jReflectionsPan, jlong jReflectionsPan_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float *ReflectionsPan = 0;
	if(jReflectionsPan) {
		ReflectionsPan = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jReflectionsPan), char *)+jReflectionsPan_, float *);
	}
	float *temp = (float *)N2J_CAST_PTR(pointer, FMOD_REVERB_PROPERTIES *)->ReflectionsPan;
	for(int i = 0; i < 3; i++) {
		temp[i] = *((float *) ReflectionsPan + i);
	}
#if 0
	Error if actif: array constant length expected
#endif
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1REVERB_1PROPERTIES_1get_1Reverb(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int result_ = N2J_CAST_PTR(pointer, FMOD_REVERB_PROPERTIES *)->Reverb;
	return (jint)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1REVERB_1PROPERTIES_1set_1Reverb(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jReverb) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int Reverb = (int)jReverb;
	N2J_CAST_PTR(pointer, FMOD_REVERB_PROPERTIES *)->Reverb = Reverb;
}

JNIEXPORT jfloat JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1REVERB_1PROPERTIES_1get_1ReverbDelay(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float result_ = N2J_CAST_PTR(pointer, FMOD_REVERB_PROPERTIES *)->ReverbDelay;
	return (jfloat)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1REVERB_1PROPERTIES_1set_1ReverbDelay(JNIEnv *java_env, jclass jcls, jlong jpointer, jfloat jReverbDelay) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float ReverbDelay = (float)jReverbDelay;
	N2J_CAST_PTR(pointer, FMOD_REVERB_PROPERTIES *)->ReverbDelay = ReverbDelay;
}

JNIEXPORT jobject JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1REVERB_1PROPERTIES_1get_1ReverbPan(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float *result_ = (float *)N2J_CAST_PTR(pointer, FMOD_REVERB_PROPERTIES *)->ReverbPan;
	jobject jresult = 0;
	if(result_) {
		jresult = java_env->NewDirectByteBuffer((float *)result_, N2J_CAST_VAR(3*sizeof(float), jlong));
	}
	return jresult;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1REVERB_1PROPERTIES_1set_1ReverbPan(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jReverbPan, jlong jReverbPan_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float *ReverbPan = 0;
	if(jReverbPan) {
		ReverbPan = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jReverbPan), char *)+jReverbPan_, float *);
	}
	float *temp = (float *)N2J_CAST_PTR(pointer, FMOD_REVERB_PROPERTIES *)->ReverbPan;
	for(int i = 0; i < 3; i++) {
		temp[i] = *((float *) ReverbPan + i);
	}
#if 0
	Error if actif: array constant length expected
#endif
}

JNIEXPORT jfloat JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1REVERB_1PROPERTIES_1get_1EchoTime(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float result_ = N2J_CAST_PTR(pointer, FMOD_REVERB_PROPERTIES *)->EchoTime;
	return (jfloat)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1REVERB_1PROPERTIES_1set_1EchoTime(JNIEnv *java_env, jclass jcls, jlong jpointer, jfloat jEchoTime) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float EchoTime = (float)jEchoTime;
	N2J_CAST_PTR(pointer, FMOD_REVERB_PROPERTIES *)->EchoTime = EchoTime;
}

JNIEXPORT jfloat JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1REVERB_1PROPERTIES_1get_1EchoDepth(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float result_ = N2J_CAST_PTR(pointer, FMOD_REVERB_PROPERTIES *)->EchoDepth;
	return (jfloat)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1REVERB_1PROPERTIES_1set_1EchoDepth(JNIEnv *java_env, jclass jcls, jlong jpointer, jfloat jEchoDepth) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float EchoDepth = (float)jEchoDepth;
	N2J_CAST_PTR(pointer, FMOD_REVERB_PROPERTIES *)->EchoDepth = EchoDepth;
}

JNIEXPORT jfloat JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1REVERB_1PROPERTIES_1get_1ModulationTime(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float result_ = N2J_CAST_PTR(pointer, FMOD_REVERB_PROPERTIES *)->ModulationTime;
	return (jfloat)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1REVERB_1PROPERTIES_1set_1ModulationTime(JNIEnv *java_env, jclass jcls, jlong jpointer, jfloat jModulationTime) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float ModulationTime = (float)jModulationTime;
	N2J_CAST_PTR(pointer, FMOD_REVERB_PROPERTIES *)->ModulationTime = ModulationTime;
}

JNIEXPORT jfloat JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1REVERB_1PROPERTIES_1get_1ModulationDepth(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float result_ = N2J_CAST_PTR(pointer, FMOD_REVERB_PROPERTIES *)->ModulationDepth;
	return (jfloat)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1REVERB_1PROPERTIES_1set_1ModulationDepth(JNIEnv *java_env, jclass jcls, jlong jpointer, jfloat jModulationDepth) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float ModulationDepth = (float)jModulationDepth;
	N2J_CAST_PTR(pointer, FMOD_REVERB_PROPERTIES *)->ModulationDepth = ModulationDepth;
}

JNIEXPORT jfloat JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1REVERB_1PROPERTIES_1get_1AirAbsorptionHF(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float result_ = N2J_CAST_PTR(pointer, FMOD_REVERB_PROPERTIES *)->AirAbsorptionHF;
	return (jfloat)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1REVERB_1PROPERTIES_1set_1AirAbsorptionHF(JNIEnv *java_env, jclass jcls, jlong jpointer, jfloat jAirAbsorptionHF) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float AirAbsorptionHF = (float)jAirAbsorptionHF;
	N2J_CAST_PTR(pointer, FMOD_REVERB_PROPERTIES *)->AirAbsorptionHF = AirAbsorptionHF;
}

JNIEXPORT jfloat JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1REVERB_1PROPERTIES_1get_1HFReference(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float result_ = N2J_CAST_PTR(pointer, FMOD_REVERB_PROPERTIES *)->HFReference;
	return (jfloat)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1REVERB_1PROPERTIES_1set_1HFReference(JNIEnv *java_env, jclass jcls, jlong jpointer, jfloat jHFReference) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float HFReference = (float)jHFReference;
	N2J_CAST_PTR(pointer, FMOD_REVERB_PROPERTIES *)->HFReference = HFReference;
}

JNIEXPORT jfloat JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1REVERB_1PROPERTIES_1get_1LFReference(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float result_ = N2J_CAST_PTR(pointer, FMOD_REVERB_PROPERTIES *)->LFReference;
	return (jfloat)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1REVERB_1PROPERTIES_1set_1LFReference(JNIEnv *java_env, jclass jcls, jlong jpointer, jfloat jLFReference) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float LFReference = (float)jLFReference;
	N2J_CAST_PTR(pointer, FMOD_REVERB_PROPERTIES *)->LFReference = LFReference;
}

JNIEXPORT jfloat JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1REVERB_1PROPERTIES_1get_1RoomRolloffFactor(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float result_ = N2J_CAST_PTR(pointer, FMOD_REVERB_PROPERTIES *)->RoomRolloffFactor;
	return (jfloat)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1REVERB_1PROPERTIES_1set_1RoomRolloffFactor(JNIEnv *java_env, jclass jcls, jlong jpointer, jfloat jRoomRolloffFactor) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float RoomRolloffFactor = (float)jRoomRolloffFactor;
	N2J_CAST_PTR(pointer, FMOD_REVERB_PROPERTIES *)->RoomRolloffFactor = RoomRolloffFactor;
}

JNIEXPORT jfloat JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1REVERB_1PROPERTIES_1get_1Diffusion(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float result_ = N2J_CAST_PTR(pointer, FMOD_REVERB_PROPERTIES *)->Diffusion;
	return (jfloat)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1REVERB_1PROPERTIES_1set_1Diffusion(JNIEnv *java_env, jclass jcls, jlong jpointer, jfloat jDiffusion) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float Diffusion = (float)jDiffusion;
	N2J_CAST_PTR(pointer, FMOD_REVERB_PROPERTIES *)->Diffusion = Diffusion;
}

JNIEXPORT jfloat JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1REVERB_1PROPERTIES_1get_1Density(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float result_ = N2J_CAST_PTR(pointer, FMOD_REVERB_PROPERTIES *)->Density;
	return (jfloat)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1REVERB_1PROPERTIES_1set_1Density(JNIEnv *java_env, jclass jcls, jlong jpointer, jfloat jDensity) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float Density = (float)jDensity;
	N2J_CAST_PTR(pointer, FMOD_REVERB_PROPERTIES *)->Density = Density;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1REVERB_1PROPERTIES_1get_1Flags(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int result_ = N2J_CAST_PTR(pointer, FMOD_REVERB_PROPERTIES *)->Flags;
	return (jint)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1REVERB_1PROPERTIES_1set_1Flags(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jFlags) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int Flags = (int)jFlags;
	N2J_CAST_PTR(pointer, FMOD_REVERB_PROPERTIES *)->Flags = Flags;
}



