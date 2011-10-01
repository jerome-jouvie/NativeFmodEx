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
#include "org_jouvieje_fmoddesigner_enumerations_EnumerationJNI.h"
#include "CallbackManager.h"

				/* FMOD_EVENTPROPERTY_TYPE */

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_enumerations_EnumerationJNI_get_1FMOD_1EVENTPROPERTY_1TYPE_1INT(JNIEnv *java_env, jclass jcls) {
	return (jint)FMOD_EVENTPROPERTY_TYPE_INT;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_enumerations_EnumerationJNI_get_1FMOD_1EVENTPROPERTY_1TYPE_1FLOAT(JNIEnv *java_env, jclass jcls) {
	return (jint)FMOD_EVENTPROPERTY_TYPE_FLOAT;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_enumerations_EnumerationJNI_get_1FMOD_1EVENTPROPERTY_1TYPE_1STRING(JNIEnv *java_env, jclass jcls) {
	return (jint)FMOD_EVENTPROPERTY_TYPE_STRING;
}

				/* FMOD_EVENTQUEUE_CALLBACKTYPE */

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_enumerations_EnumerationJNI_get_1FMOD_1EVENTQUEUE_1CALLBACKTYPE_1PREPARE(JNIEnv *java_env, jclass jcls) {
	return (jint)FMOD_EVENTQUEUE_CALLBACKTYPE_PREPARE;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_enumerations_EnumerationJNI_get_1FMOD_1EVENTQUEUE_1CALLBACKTYPE_1ABOUTTOPLAY(JNIEnv *java_env, jclass jcls) {
	return (jint)FMOD_EVENTQUEUE_CALLBACKTYPE_ABOUTTOPLAY;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_enumerations_EnumerationJNI_get_1FMOD_1EVENTQUEUE_1CALLBACKTYPE_1FINISHED(JNIEnv *java_env, jclass jcls) {
	return (jint)FMOD_EVENTQUEUE_CALLBACKTYPE_FINISHED;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_enumerations_EnumerationJNI_get_1FMOD_1EVENTQUEUE_1CALLBACKTYPE_1EXPIRED(JNIEnv *java_env, jclass jcls) {
	return (jint)FMOD_EVENTQUEUE_CALLBACKTYPE_EXPIRED;
}

				/* FMOD_EVENT_CALLBACKTYPE */

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_enumerations_EnumerationJNI_get_1FMOD_1EVENT_1CALLBACKTYPE_1SYNCPOINT(JNIEnv *java_env, jclass jcls) {
	return (jint)FMOD_EVENT_CALLBACKTYPE_SYNCPOINT;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_enumerations_EnumerationJNI_get_1FMOD_1EVENT_1CALLBACKTYPE_1SOUNDDEF_1START(JNIEnv *java_env, jclass jcls) {
	return (jint)FMOD_EVENT_CALLBACKTYPE_SOUNDDEF_START;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_enumerations_EnumerationJNI_get_1FMOD_1EVENT_1CALLBACKTYPE_1SOUNDDEF_1END(JNIEnv *java_env, jclass jcls) {
	return (jint)FMOD_EVENT_CALLBACKTYPE_SOUNDDEF_END;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_enumerations_EnumerationJNI_get_1FMOD_1EVENT_1CALLBACKTYPE_1STOLEN(JNIEnv *java_env, jclass jcls) {
	return (jint)FMOD_EVENT_CALLBACKTYPE_STOLEN;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_enumerations_EnumerationJNI_get_1FMOD_1EVENT_1CALLBACKTYPE_1EVENTFINISHED(JNIEnv *java_env, jclass jcls) {
	return (jint)FMOD_EVENT_CALLBACKTYPE_EVENTFINISHED;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_enumerations_EnumerationJNI_get_1FMOD_1EVENT_1CALLBACKTYPE_1NET_1MODIFIED(JNIEnv *java_env, jclass jcls) {
	return (jint)FMOD_EVENT_CALLBACKTYPE_NET_MODIFIED;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_enumerations_EnumerationJNI_get_1FMOD_1EVENT_1CALLBACKTYPE_1SOUNDDEF_1CREATE(JNIEnv *java_env, jclass jcls) {
	return (jint)FMOD_EVENT_CALLBACKTYPE_SOUNDDEF_CREATE;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_enumerations_EnumerationJNI_get_1FMOD_1EVENT_1CALLBACKTYPE_1SOUNDDEF_1RELEASE(JNIEnv *java_env, jclass jcls) {
	return (jint)FMOD_EVENT_CALLBACKTYPE_SOUNDDEF_RELEASE;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_enumerations_EnumerationJNI_get_1FMOD_1EVENT_1CALLBACKTYPE_1SOUNDDEF_1INFO(JNIEnv *java_env, jclass jcls) {
	return (jint)FMOD_EVENT_CALLBACKTYPE_SOUNDDEF_INFO;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_enumerations_EnumerationJNI_get_1FMOD_1EVENT_1CALLBACKTYPE_1EVENTSTARTED(JNIEnv *java_env, jclass jcls) {
	return (jint)FMOD_EVENT_CALLBACKTYPE_EVENTSTARTED;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_enumerations_EnumerationJNI_get_1FMOD_1EVENT_1CALLBACKTYPE_1SOUNDDEF_1SELECTINDEX(JNIEnv *java_env, jclass jcls) {
	return (jint)FMOD_EVENT_CALLBACKTYPE_SOUNDDEF_SELECTINDEX;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_enumerations_EnumerationJNI_get_1FMOD_1EVENT_1CALLBACKTYPE_1OCCLUSION(JNIEnv *java_env, jclass jcls) {
	return (jint)FMOD_EVENT_CALLBACKTYPE_OCCLUSION;
}

				/* FMOD_EVENT_PITCHUNITS */

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_enumerations_EnumerationJNI_get_1FMOD_1EVENT_1PITCHUNITS_1RAW(JNIEnv *java_env, jclass jcls) {
	return (jint)FMOD_EVENT_PITCHUNITS_RAW;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_enumerations_EnumerationJNI_get_1FMOD_1EVENT_1PITCHUNITS_1OCTAVES(JNIEnv *java_env, jclass jcls) {
	return (jint)FMOD_EVENT_PITCHUNITS_OCTAVES;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_enumerations_EnumerationJNI_get_1FMOD_1EVENT_1PITCHUNITS_1SEMITONES(JNIEnv *java_env, jclass jcls) {
	return (jint)FMOD_EVENT_PITCHUNITS_SEMITONES;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_enumerations_EnumerationJNI_get_1FMOD_1EVENT_1PITCHUNITS_1TONES(JNIEnv *java_env, jclass jcls) {
	return (jint)FMOD_EVENT_PITCHUNITS_TONES;
}

				/* FMOD_EVENT_PROPERTY */

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_enumerations_EnumerationJNI_get_1FMOD_1EVENTPROPERTY_1NAME(JNIEnv *java_env, jclass jcls) {
	return (jint)FMOD_EVENTPROPERTY_NAME;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_enumerations_EnumerationJNI_get_1FMOD_1EVENTPROPERTY_1VOLUME(JNIEnv *java_env, jclass jcls) {
	return (jint)FMOD_EVENTPROPERTY_VOLUME;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_enumerations_EnumerationJNI_get_1FMOD_1EVENTPROPERTY_1VOLUMERANDOMIZATION(JNIEnv *java_env, jclass jcls) {
	return (jint)FMOD_EVENTPROPERTY_VOLUMERANDOMIZATION;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_enumerations_EnumerationJNI_get_1FMOD_1EVENTPROPERTY_1PITCH(JNIEnv *java_env, jclass jcls) {
	return (jint)FMOD_EVENTPROPERTY_PITCH;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_enumerations_EnumerationJNI_get_1FMOD_1EVENTPROPERTY_1PITCH_1OCTAVES(JNIEnv *java_env, jclass jcls) {
	return (jint)FMOD_EVENTPROPERTY_PITCH_OCTAVES;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_enumerations_EnumerationJNI_get_1FMOD_1EVENTPROPERTY_1PITCH_1SEMITONES(JNIEnv *java_env, jclass jcls) {
	return (jint)FMOD_EVENTPROPERTY_PITCH_SEMITONES;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_enumerations_EnumerationJNI_get_1FMOD_1EVENTPROPERTY_1PITCH_1TONES(JNIEnv *java_env, jclass jcls) {
	return (jint)FMOD_EVENTPROPERTY_PITCH_TONES;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_enumerations_EnumerationJNI_get_1FMOD_1EVENTPROPERTY_1PITCHRANDOMIZATION(JNIEnv *java_env, jclass jcls) {
	return (jint)FMOD_EVENTPROPERTY_PITCHRANDOMIZATION;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_enumerations_EnumerationJNI_get_1FMOD_1EVENTPROPERTY_1PITCHRANDOMIZATION_1OCTAVES(JNIEnv *java_env, jclass jcls) {
	return (jint)FMOD_EVENTPROPERTY_PITCHRANDOMIZATION_OCTAVES;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_enumerations_EnumerationJNI_get_1FMOD_1EVENTPROPERTY_1PITCHRANDOMIZATION_1SEMITONES(JNIEnv *java_env, jclass jcls) {
	return (jint)FMOD_EVENTPROPERTY_PITCHRANDOMIZATION_SEMITONES;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_enumerations_EnumerationJNI_get_1FMOD_1EVENTPROPERTY_1PITCHRANDOMIZATION_1TONES(JNIEnv *java_env, jclass jcls) {
	return (jint)FMOD_EVENTPROPERTY_PITCHRANDOMIZATION_TONES;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_enumerations_EnumerationJNI_get_1FMOD_1EVENTPROPERTY_1PRIORITY(JNIEnv *java_env, jclass jcls) {
	return (jint)FMOD_EVENTPROPERTY_PRIORITY;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_enumerations_EnumerationJNI_get_1FMOD_1EVENTPROPERTY_1MAX_1PLAYBACKS(JNIEnv *java_env, jclass jcls) {
	return (jint)FMOD_EVENTPROPERTY_MAX_PLAYBACKS;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_enumerations_EnumerationJNI_get_1FMOD_1EVENTPROPERTY_1MAX_1PLAYBACKS_1BEHAVIOR(JNIEnv *java_env, jclass jcls) {
	return (jint)FMOD_EVENTPROPERTY_MAX_PLAYBACKS_BEHAVIOR;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_enumerations_EnumerationJNI_get_1FMOD_1EVENTPROPERTY_1MODE(JNIEnv *java_env, jclass jcls) {
	return (jint)FMOD_EVENTPROPERTY_MODE;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_enumerations_EnumerationJNI_get_1FMOD_1EVENTPROPERTY_13D_1IGNORE_1GEOMETRY(JNIEnv *java_env, jclass jcls) {
	return (jint)FMOD_EVENTPROPERTY_3D_IGNORE_GEOMETRY;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_enumerations_EnumerationJNI_get_1FMOD_1EVENTPROPERTY_13D_1ROLLOFF(JNIEnv *java_env, jclass jcls) {
	return (jint)FMOD_EVENTPROPERTY_3D_ROLLOFF;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_enumerations_EnumerationJNI_get_1FMOD_1EVENTPROPERTY_13D_1MINDISTANCE(JNIEnv *java_env, jclass jcls) {
	return (jint)FMOD_EVENTPROPERTY_3D_MINDISTANCE;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_enumerations_EnumerationJNI_get_1FMOD_1EVENTPROPERTY_13D_1MAXDISTANCE(JNIEnv *java_env, jclass jcls) {
	return (jint)FMOD_EVENTPROPERTY_3D_MAXDISTANCE;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_enumerations_EnumerationJNI_get_1FMOD_1EVENTPROPERTY_13D_1POSITION(JNIEnv *java_env, jclass jcls) {
	return (jint)FMOD_EVENTPROPERTY_3D_POSITION;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_enumerations_EnumerationJNI_get_1FMOD_1EVENTPROPERTY_13D_1CONEINSIDEANGLE(JNIEnv *java_env, jclass jcls) {
	return (jint)FMOD_EVENTPROPERTY_3D_CONEINSIDEANGLE;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_enumerations_EnumerationJNI_get_1FMOD_1EVENTPROPERTY_13D_1CONEOUTSIDEANGLE(JNIEnv *java_env, jclass jcls) {
	return (jint)FMOD_EVENTPROPERTY_3D_CONEOUTSIDEANGLE;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_enumerations_EnumerationJNI_get_1FMOD_1EVENTPROPERTY_13D_1CONEOUTSIDEVOLUME(JNIEnv *java_env, jclass jcls) {
	return (jint)FMOD_EVENTPROPERTY_3D_CONEOUTSIDEVOLUME;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_enumerations_EnumerationJNI_get_1FMOD_1EVENTPROPERTY_13D_1DOPPLERSCALE(JNIEnv *java_env, jclass jcls) {
	return (jint)FMOD_EVENTPROPERTY_3D_DOPPLERSCALE;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_enumerations_EnumerationJNI_get_1FMOD_1EVENTPROPERTY_13D_1SPEAKERSPREAD(JNIEnv *java_env, jclass jcls) {
	return (jint)FMOD_EVENTPROPERTY_3D_SPEAKERSPREAD;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_enumerations_EnumerationJNI_get_1FMOD_1EVENTPROPERTY_13D_1PANLEVEL(JNIEnv *java_env, jclass jcls) {
	return (jint)FMOD_EVENTPROPERTY_3D_PANLEVEL;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_enumerations_EnumerationJNI_get_1FMOD_1EVENTPROPERTY_1SPEAKER_1L(JNIEnv *java_env, jclass jcls) {
	return (jint)FMOD_EVENTPROPERTY_SPEAKER_L;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_enumerations_EnumerationJNI_get_1FMOD_1EVENTPROPERTY_1SPEAKER_1C(JNIEnv *java_env, jclass jcls) {
	return (jint)FMOD_EVENTPROPERTY_SPEAKER_C;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_enumerations_EnumerationJNI_get_1FMOD_1EVENTPROPERTY_1SPEAKER_1R(JNIEnv *java_env, jclass jcls) {
	return (jint)FMOD_EVENTPROPERTY_SPEAKER_R;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_enumerations_EnumerationJNI_get_1FMOD_1EVENTPROPERTY_1SPEAKER_1LS(JNIEnv *java_env, jclass jcls) {
	return (jint)FMOD_EVENTPROPERTY_SPEAKER_LS;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_enumerations_EnumerationJNI_get_1FMOD_1EVENTPROPERTY_1SPEAKER_1RS(JNIEnv *java_env, jclass jcls) {
	return (jint)FMOD_EVENTPROPERTY_SPEAKER_RS;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_enumerations_EnumerationJNI_get_1FMOD_1EVENTPROPERTY_1SPEAKER_1LR(JNIEnv *java_env, jclass jcls) {
	return (jint)FMOD_EVENTPROPERTY_SPEAKER_LR;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_enumerations_EnumerationJNI_get_1FMOD_1EVENTPROPERTY_1SPEAKER_1RR(JNIEnv *java_env, jclass jcls) {
	return (jint)FMOD_EVENTPROPERTY_SPEAKER_RR;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_enumerations_EnumerationJNI_get_1FMOD_1EVENTPROPERTY_1SPEAKER_1LFE(JNIEnv *java_env, jclass jcls) {
	return (jint)FMOD_EVENTPROPERTY_SPEAKER_LFE;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_enumerations_EnumerationJNI_get_1FMOD_1EVENTPROPERTY_1REVERBWETLEVEL(JNIEnv *java_env, jclass jcls) {
	return (jint)FMOD_EVENTPROPERTY_REVERBWETLEVEL;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_enumerations_EnumerationJNI_get_1FMOD_1EVENTPROPERTY_1ONESHOT(JNIEnv *java_env, jclass jcls) {
	return (jint)FMOD_EVENTPROPERTY_ONESHOT;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_enumerations_EnumerationJNI_get_1FMOD_1EVENTPROPERTY_1FADEIN(JNIEnv *java_env, jclass jcls) {
	return (jint)FMOD_EVENTPROPERTY_FADEIN;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_enumerations_EnumerationJNI_get_1FMOD_1EVENTPROPERTY_1FADEOUT(JNIEnv *java_env, jclass jcls) {
	return (jint)FMOD_EVENTPROPERTY_FADEOUT;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_enumerations_EnumerationJNI_get_1FMOD_1EVENTPROPERTY_1REVERBDRYLEVEL(JNIEnv *java_env, jclass jcls) {
	return (jint)FMOD_EVENTPROPERTY_REVERBDRYLEVEL;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_enumerations_EnumerationJNI_get_1FMOD_1EVENTPROPERTY_1TIMEOFFSET(JNIEnv *java_env, jclass jcls) {
	return (jint)FMOD_EVENTPROPERTY_TIMEOFFSET;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_enumerations_EnumerationJNI_get_1FMOD_1EVENTPROPERTY_1SPAWNINTENSITY(JNIEnv *java_env, jclass jcls) {
	return (jint)FMOD_EVENTPROPERTY_SPAWNINTENSITY;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_enumerations_EnumerationJNI_get_1FMOD_1EVENTPROPERTY_1SPAWNINTENSITY_1RANDOMIZATION(JNIEnv *java_env, jclass jcls) {
	return (jint)FMOD_EVENTPROPERTY_SPAWNINTENSITY_RANDOMIZATION;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_enumerations_EnumerationJNI_get_1FMOD_1EVENTPROPERTY_1WII_1CONTROLLERSPEAKERS(JNIEnv *java_env, jclass jcls) {
	return (jint)FMOD_EVENTPROPERTY_WII_CONTROLLERSPEAKERS;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_enumerations_EnumerationJNI_get_1FMOD_1EVENTPROPERTY_13D_1POSRANDOMIZATION(JNIEnv *java_env, jclass jcls) {
	return (jint)FMOD_EVENTPROPERTY_3D_POSRANDOMIZATION;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_enumerations_EnumerationJNI_get_1FMOD_1EVENTPROPERTY_1EVENTTYPE(JNIEnv *java_env, jclass jcls) {
	return (jint)FMOD_EVENTPROPERTY_EVENTTYPE;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_enumerations_EnumerationJNI_get_1FMOD_1EVENTPROPERTY_1STEAL_1PRIORITY(JNIEnv *java_env, jclass jcls) {
	return (jint)FMOD_EVENTPROPERTY_STEAL_PRIORITY;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_enumerations_EnumerationJNI_get_1FMOD_1EVENTPROPERTY_1EFFECTS_1AFFECT_1REVERB(JNIEnv *java_env, jclass jcls) {
	return (jint)FMOD_EVENTPROPERTY_EFFECTS_AFFECT_REVERB;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_enumerations_EnumerationJNI_get_1FMOD_1EVENTPROPERTY_1WILL_1TERMINATE(JNIEnv *java_env, jclass jcls) {
	return (jint)FMOD_EVENTPROPERTY_WILL_TERMINATE;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_enumerations_EnumerationJNI_get_1FMOD_1EVENTPROPERTY_1USER_1BASE(JNIEnv *java_env, jclass jcls) {
	return (jint)FMOD_EVENTPROPERTY_USER_BASE;
}

				/* FMOD_EVENT_RESOURCE */

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_enumerations_EnumerationJNI_get_1FMOD_1EVENT_1RESOURCE_1STREAMS_1AND_1SAMPLES(JNIEnv *java_env, jclass jcls) {
	return (jint)FMOD_EVENT_RESOURCE_STREAMS_AND_SAMPLES;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_enumerations_EnumerationJNI_get_1FMOD_1EVENT_1RESOURCE_1STREAMS(JNIEnv *java_env, jclass jcls) {
	return (jint)FMOD_EVENT_RESOURCE_STREAMS;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_enumerations_EnumerationJNI_get_1FMOD_1EVENT_1RESOURCE_1SAMPLES(JNIEnv *java_env, jclass jcls) {
	return (jint)FMOD_EVENT_RESOURCE_SAMPLES;
}

				/* FMOD_EVENT_SOUNDDEF_ENTRYTYPE */

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_enumerations_EnumerationJNI_get_1FMOD_1EVENT_1SOUNDDEF_1ENTRYTYPE_1WAVETABLE(JNIEnv *java_env, jclass jcls) {
	return (jint)FMOD_EVENT_SOUNDDEF_ENTRYTYPE_WAVETABLE;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_enumerations_EnumerationJNI_get_1FMOD_1EVENT_1SOUNDDEF_1ENTRYTYPE_1OSCILLATOR(JNIEnv *java_env, jclass jcls) {
	return (jint)FMOD_EVENT_SOUNDDEF_ENTRYTYPE_OSCILLATOR;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_enumerations_EnumerationJNI_get_1FMOD_1EVENT_1SOUNDDEF_1ENTRYTYPE_1NULL(JNIEnv *java_env, jclass jcls) {
	return (jint)FMOD_EVENT_SOUNDDEF_ENTRYTYPE_NULL;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_enumerations_EnumerationJNI_get_1FMOD_1EVENT_1SOUNDDEF_1ENTRYTYPE_1PROGRAMMER(JNIEnv *java_env, jclass jcls) {
	return (jint)FMOD_EVENT_SOUNDDEF_ENTRYTYPE_PROGRAMMER;
}

				/* FMOD_MUSIC_CALLBACKTYPE */

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_enumerations_EnumerationJNI_get_1FMOD_1MUSIC_1CALLBACKTYPE_1SEGMENT_1START(JNIEnv *java_env, jclass jcls) {
	return (jint)FMOD_MUSIC_CALLBACKTYPE_SEGMENT_START;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_enumerations_EnumerationJNI_get_1FMOD_1MUSIC_1CALLBACKTYPE_1SEGMENT_1END(JNIEnv *java_env, jclass jcls) {
	return (jint)FMOD_MUSIC_CALLBACKTYPE_SEGMENT_END;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_enumerations_EnumerationJNI_get_1FMOD_1MUSIC_1CALLBACKTYPE_1SAMPLE_1CREATE(JNIEnv *java_env, jclass jcls) {
	return (jint)FMOD_MUSIC_CALLBACKTYPE_SAMPLE_CREATE;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_enumerations_EnumerationJNI_get_1FMOD_1MUSIC_1CALLBACKTYPE_1SAMPLE_1RELEASE(JNIEnv *java_env, jclass jcls) {
	return (jint)FMOD_MUSIC_CALLBACKTYPE_SAMPLE_RELEASE;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_enumerations_EnumerationJNI_get_1FMOD_1MUSIC_1CALLBACKTYPE_1RESET(JNIEnv *java_env, jclass jcls) {
	return (jint)FMOD_MUSIC_CALLBACKTYPE_RESET;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_enumerations_EnumerationJNI_get_1FMOD_1MUSIC_1CALLBACKTYPE_1BEAT(JNIEnv *java_env, jclass jcls) {
	return (jint)FMOD_MUSIC_CALLBACKTYPE_BEAT;
}


