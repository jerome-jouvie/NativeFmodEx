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

JNIEXPORT jlong JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1REVERB_1CHANNELPROPERTIES_1new(JNIEnv *java_env, jclass jcls) {
	FMOD_REVERB_CHANNELPROPERTIES *result_ = new FMOD_REVERB_CHANNELPROPERTIES();
	CheckAllocation(java_env, result_);
	POINTER_TYPE jresult/* = 0*/;
	N2J_CAST_PTR(jresult, FMOD_REVERB_CHANNELPROPERTIES *) = result_;
	return (jlong)jresult;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1REVERB_1CHANNELPROPERTIES_1delete(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	delete N2J_CAST_PTR(pointer, FMOD_REVERB_CHANNELPROPERTIES *);
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1REVERB_1CHANNELPROPERTIES_1get_1Direct(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int result_ = N2J_CAST_PTR(pointer, FMOD_REVERB_CHANNELPROPERTIES *)->Direct;
	return (jint)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1REVERB_1CHANNELPROPERTIES_1set_1Direct(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jDirect) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int Direct = (int)jDirect;
	N2J_CAST_PTR(pointer, FMOD_REVERB_CHANNELPROPERTIES *)->Direct = Direct;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1REVERB_1CHANNELPROPERTIES_1get_1DirectHF(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int result_ = N2J_CAST_PTR(pointer, FMOD_REVERB_CHANNELPROPERTIES *)->DirectHF;
	return (jint)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1REVERB_1CHANNELPROPERTIES_1set_1DirectHF(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jDirectHF) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int DirectHF = (int)jDirectHF;
	N2J_CAST_PTR(pointer, FMOD_REVERB_CHANNELPROPERTIES *)->DirectHF = DirectHF;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1REVERB_1CHANNELPROPERTIES_1get_1Room(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int result_ = N2J_CAST_PTR(pointer, FMOD_REVERB_CHANNELPROPERTIES *)->Room;
	return (jint)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1REVERB_1CHANNELPROPERTIES_1set_1Room(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jRoom) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int Room = (int)jRoom;
	N2J_CAST_PTR(pointer, FMOD_REVERB_CHANNELPROPERTIES *)->Room = Room;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1REVERB_1CHANNELPROPERTIES_1get_1RoomHF(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int result_ = N2J_CAST_PTR(pointer, FMOD_REVERB_CHANNELPROPERTIES *)->RoomHF;
	return (jint)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1REVERB_1CHANNELPROPERTIES_1set_1RoomHF(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jRoomHF) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int RoomHF = (int)jRoomHF;
	N2J_CAST_PTR(pointer, FMOD_REVERB_CHANNELPROPERTIES *)->RoomHF = RoomHF;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1REVERB_1CHANNELPROPERTIES_1get_1Obstruction(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int result_ = N2J_CAST_PTR(pointer, FMOD_REVERB_CHANNELPROPERTIES *)->Obstruction;
	return (jint)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1REVERB_1CHANNELPROPERTIES_1set_1Obstruction(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jObstruction) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int Obstruction = (int)jObstruction;
	N2J_CAST_PTR(pointer, FMOD_REVERB_CHANNELPROPERTIES *)->Obstruction = Obstruction;
}

JNIEXPORT jfloat JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1REVERB_1CHANNELPROPERTIES_1get_1ObstructionLFRatio(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float result_ = N2J_CAST_PTR(pointer, FMOD_REVERB_CHANNELPROPERTIES *)->ObstructionLFRatio;
	return (jfloat)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1REVERB_1CHANNELPROPERTIES_1set_1ObstructionLFRatio(JNIEnv *java_env, jclass jcls, jlong jpointer, jfloat jObstructionLFRatio) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float ObstructionLFRatio = (float)jObstructionLFRatio;
	N2J_CAST_PTR(pointer, FMOD_REVERB_CHANNELPROPERTIES *)->ObstructionLFRatio = ObstructionLFRatio;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1REVERB_1CHANNELPROPERTIES_1get_1Occlusion(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int result_ = N2J_CAST_PTR(pointer, FMOD_REVERB_CHANNELPROPERTIES *)->Occlusion;
	return (jint)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1REVERB_1CHANNELPROPERTIES_1set_1Occlusion(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jOcclusion) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int Occlusion = (int)jOcclusion;
	N2J_CAST_PTR(pointer, FMOD_REVERB_CHANNELPROPERTIES *)->Occlusion = Occlusion;
}

JNIEXPORT jfloat JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1REVERB_1CHANNELPROPERTIES_1get_1OcclusionLFRatio(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float result_ = N2J_CAST_PTR(pointer, FMOD_REVERB_CHANNELPROPERTIES *)->OcclusionLFRatio;
	return (jfloat)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1REVERB_1CHANNELPROPERTIES_1set_1OcclusionLFRatio(JNIEnv *java_env, jclass jcls, jlong jpointer, jfloat jOcclusionLFRatio) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float OcclusionLFRatio = (float)jOcclusionLFRatio;
	N2J_CAST_PTR(pointer, FMOD_REVERB_CHANNELPROPERTIES *)->OcclusionLFRatio = OcclusionLFRatio;
}

JNIEXPORT jfloat JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1REVERB_1CHANNELPROPERTIES_1get_1OcclusionRoomRatio(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float result_ = N2J_CAST_PTR(pointer, FMOD_REVERB_CHANNELPROPERTIES *)->OcclusionRoomRatio;
	return (jfloat)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1REVERB_1CHANNELPROPERTIES_1set_1OcclusionRoomRatio(JNIEnv *java_env, jclass jcls, jlong jpointer, jfloat jOcclusionRoomRatio) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float OcclusionRoomRatio = (float)jOcclusionRoomRatio;
	N2J_CAST_PTR(pointer, FMOD_REVERB_CHANNELPROPERTIES *)->OcclusionRoomRatio = OcclusionRoomRatio;
}

JNIEXPORT jfloat JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1REVERB_1CHANNELPROPERTIES_1get_1OcclusionDirectRatio(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float result_ = N2J_CAST_PTR(pointer, FMOD_REVERB_CHANNELPROPERTIES *)->OcclusionDirectRatio;
	return (jfloat)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1REVERB_1CHANNELPROPERTIES_1set_1OcclusionDirectRatio(JNIEnv *java_env, jclass jcls, jlong jpointer, jfloat jOcclusionDirectRatio) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float OcclusionDirectRatio = (float)jOcclusionDirectRatio;
	N2J_CAST_PTR(pointer, FMOD_REVERB_CHANNELPROPERTIES *)->OcclusionDirectRatio = OcclusionDirectRatio;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1REVERB_1CHANNELPROPERTIES_1get_1Exclusion(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int result_ = N2J_CAST_PTR(pointer, FMOD_REVERB_CHANNELPROPERTIES *)->Exclusion;
	return (jint)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1REVERB_1CHANNELPROPERTIES_1set_1Exclusion(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jExclusion) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int Exclusion = (int)jExclusion;
	N2J_CAST_PTR(pointer, FMOD_REVERB_CHANNELPROPERTIES *)->Exclusion = Exclusion;
}

JNIEXPORT jfloat JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1REVERB_1CHANNELPROPERTIES_1get_1ExclusionLFRatio(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float result_ = N2J_CAST_PTR(pointer, FMOD_REVERB_CHANNELPROPERTIES *)->ExclusionLFRatio;
	return (jfloat)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1REVERB_1CHANNELPROPERTIES_1set_1ExclusionLFRatio(JNIEnv *java_env, jclass jcls, jlong jpointer, jfloat jExclusionLFRatio) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float ExclusionLFRatio = (float)jExclusionLFRatio;
	N2J_CAST_PTR(pointer, FMOD_REVERB_CHANNELPROPERTIES *)->ExclusionLFRatio = ExclusionLFRatio;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1REVERB_1CHANNELPROPERTIES_1get_1OutsideVolumeHF(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int result_ = N2J_CAST_PTR(pointer, FMOD_REVERB_CHANNELPROPERTIES *)->OutsideVolumeHF;
	return (jint)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1REVERB_1CHANNELPROPERTIES_1set_1OutsideVolumeHF(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jOutsideVolumeHF) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int OutsideVolumeHF = (int)jOutsideVolumeHF;
	N2J_CAST_PTR(pointer, FMOD_REVERB_CHANNELPROPERTIES *)->OutsideVolumeHF = OutsideVolumeHF;
}

JNIEXPORT jfloat JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1REVERB_1CHANNELPROPERTIES_1get_1DopplerFactor(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float result_ = N2J_CAST_PTR(pointer, FMOD_REVERB_CHANNELPROPERTIES *)->DopplerFactor;
	return (jfloat)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1REVERB_1CHANNELPROPERTIES_1set_1DopplerFactor(JNIEnv *java_env, jclass jcls, jlong jpointer, jfloat jDopplerFactor) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float DopplerFactor = (float)jDopplerFactor;
	N2J_CAST_PTR(pointer, FMOD_REVERB_CHANNELPROPERTIES *)->DopplerFactor = DopplerFactor;
}

JNIEXPORT jfloat JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1REVERB_1CHANNELPROPERTIES_1get_1RolloffFactor(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float result_ = N2J_CAST_PTR(pointer, FMOD_REVERB_CHANNELPROPERTIES *)->RolloffFactor;
	return (jfloat)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1REVERB_1CHANNELPROPERTIES_1set_1RolloffFactor(JNIEnv *java_env, jclass jcls, jlong jpointer, jfloat jRolloffFactor) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float RolloffFactor = (float)jRolloffFactor;
	N2J_CAST_PTR(pointer, FMOD_REVERB_CHANNELPROPERTIES *)->RolloffFactor = RolloffFactor;
}

JNIEXPORT jfloat JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1REVERB_1CHANNELPROPERTIES_1get_1RoomRolloffFactor(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float result_ = N2J_CAST_PTR(pointer, FMOD_REVERB_CHANNELPROPERTIES *)->RoomRolloffFactor;
	return (jfloat)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1REVERB_1CHANNELPROPERTIES_1set_1RoomRolloffFactor(JNIEnv *java_env, jclass jcls, jlong jpointer, jfloat jRoomRolloffFactor) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float RoomRolloffFactor = (float)jRoomRolloffFactor;
	N2J_CAST_PTR(pointer, FMOD_REVERB_CHANNELPROPERTIES *)->RoomRolloffFactor = RoomRolloffFactor;
}

JNIEXPORT jfloat JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1REVERB_1CHANNELPROPERTIES_1get_1AirAbsorptionFactor(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float result_ = N2J_CAST_PTR(pointer, FMOD_REVERB_CHANNELPROPERTIES *)->AirAbsorptionFactor;
	return (jfloat)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1REVERB_1CHANNELPROPERTIES_1set_1AirAbsorptionFactor(JNIEnv *java_env, jclass jcls, jlong jpointer, jfloat jAirAbsorptionFactor) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float AirAbsorptionFactor = (float)jAirAbsorptionFactor;
	N2J_CAST_PTR(pointer, FMOD_REVERB_CHANNELPROPERTIES *)->AirAbsorptionFactor = AirAbsorptionFactor;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1REVERB_1CHANNELPROPERTIES_1get_1Flags(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int result_ = N2J_CAST_PTR(pointer, FMOD_REVERB_CHANNELPROPERTIES *)->Flags;
	return (jint)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1REVERB_1CHANNELPROPERTIES_1set_1Flags(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jFlags) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int Flags = (int)jFlags;
	N2J_CAST_PTR(pointer, FMOD_REVERB_CHANNELPROPERTIES *)->Flags = Flags;
}

JNIEXPORT jlong JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1REVERB_1CHANNELPROPERTIES_1get_1ConnectionPoint(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	POINTER_TYPE jresult/* = 0*/;
	N2J_CAST_PTR(jresult, FMOD_DSP *) = N2J_CAST_PTR(pointer, FMOD_REVERB_CHANNELPROPERTIES *)->ConnectionPoint;
	return (jlong)jresult;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1REVERB_1CHANNELPROPERTIES_1set_1ConnectionPoint(JNIEnv *java_env, jclass jcls, jlong jpointer, jlong jConnectionPoint) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	POINTER_TYPE ConnectionPointTmp = (POINTER_TYPE)jConnectionPoint;
	N2J_CAST_PTR(pointer, FMOD_REVERB_CHANNELPROPERTIES *)->ConnectionPoint = N2J_CAST_PTR(ConnectionPointTmp, FMOD_DSP *);
}



