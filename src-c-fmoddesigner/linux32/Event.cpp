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

JNIEXPORT jlong JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_Event_1newArray(JNIEnv *java_env, jclass jcls, jint length) {
	FMOD::Event **array = new FMOD::Event *[(int)length];
	if((int)length > 0) { CheckAllocation(java_env, array); }
	POINTER_TYPE jresult/* = 0*/;
	N2J_CAST_PTR(jresult, FMOD::Event **) = array;
	return (jlong)jresult;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_Event_1SIZEOF(JNIEnv *java_env, jclass jcls) {
	return (jint)sizeof(FMOD::Event *);
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_Event_1release(JNIEnv *java_env, jclass jcls, jlong jpointer, jboolean jfreeeventdata, jboolean jwaituntilready) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	bool freeeventdata = N2J_CAST_VAR(jfreeeventdata != 0, bool);
	bool waituntilready = N2J_CAST_VAR(jwaituntilready != 0, bool);

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Event *)->release(freeeventdata, waituntilready);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_Event_1start(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Event *)->start();

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_Event_1stop(JNIEnv *java_env, jclass jcls, jlong jpointer, jboolean jimmediate) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	bool immediate = N2J_CAST_VAR(jimmediate != 0, bool);

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Event *)->stop(immediate);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_Event_1getInfo(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jindex, jlong jindex_, jobject jname, jlong jinfo) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int *index = 0;
	if(jindex) {
		index = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jindex), char *)+jindex_, int *);
	}
	char *name/* = 0*/;
	FMOD_EVENT_INFO *info = 0;
	if(jinfo) {
		POINTER_TYPE infoTmp = (POINTER_TYPE)jinfo;
		info = N2J_CAST_PTR(infoTmp, FMOD_EVENT_INFO *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Event *)->getInfo(index, &name, info);

	if(jname) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, char *) = name;
		setPointerAddress(java_env, jname, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_Event_1getState(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jstate, jlong jstate_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD_EVENT_STATE *state = 0;
	if(jstate) {
		state = N2J_CAST_VAR(N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jstate), char *)+jstate_, int *), FMOD_EVENT_STATE *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Event *)->getState(state);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_Event_1getParentGroup(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jgroup) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD::EventGroup *group/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Event *)->getParentGroup(&group);

	if(jgroup) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, FMOD::EventGroup *) = group;
		setPointerAddress(java_env, jgroup, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_Event_1getChannelGroup(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jchannelgroup) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD::ChannelGroup *channelgroup/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Event *)->getChannelGroup(&channelgroup);

	if(jchannelgroup) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, FMOD::ChannelGroup *) = channelgroup;
		setPointerAddress(java_env, jchannelgroup, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_Event_1setCallback(JNIEnv *java_env, jclass jcls, jlong jpointer, jboolean jcallback, jlong juserdata) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	POINTER_TYPE userdataTmp = (POINTER_TYPE)juserdata;
	void *userdata = N2J_CAST_PTR(userdataTmp, void *);

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Event *)->setCallback(jcallback == 0 ? NULL : FMOD_EVENT_CALLBACK_BRIDGE, userdata);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_Event_1getParameter(JNIEnv *java_env, jclass jcls, jlong jpointer, jbyteArray jname, jobject jparameter) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	const char *name = (const char *)getByteArrayElements(java_env, jname);
	FMOD::EventParameter *parameter/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Event *)->getParameter(name, &parameter);

	releaseByteArrayElements(java_env, jname, (const char *)name);
	if(jparameter) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, FMOD::EventParameter *) = parameter;
		setPointerAddress(java_env, jparameter, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_Event_1getParameterByIndex(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jindex, jobject jparameter) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int index = (int)jindex;
	FMOD::EventParameter *parameter/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Event *)->getParameterByIndex(index, &parameter);

	if(jparameter) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, FMOD::EventParameter *) = parameter;
		setPointerAddress(java_env, jparameter, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_Event_1getNumParameters(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jnumparameters, jlong jnumparameters_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int *numparameters = 0;
	if(jnumparameters) {
		numparameters = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jnumparameters), char *)+jnumparameters_, int *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Event *)->getNumParameters(numparameters);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_Event_1getProperty(JNIEnv *java_env, jclass jcls, jlong jpointer, jbyteArray jpropertyname, jlong jvalue, jboolean jthis_instance) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	const char *propertyname = (const char *)getByteArrayElements(java_env, jpropertyname);
	POINTER_TYPE valueTmp = (POINTER_TYPE)jvalue;
	void *value = N2J_CAST_PTR(valueTmp, void *);
	bool this_instance = N2J_CAST_VAR(jthis_instance != 0, bool);

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Event *)->getProperty(propertyname, value, this_instance);

	releaseByteArrayElements(java_env, jpropertyname, (const char *)propertyname);
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_Event_1getPropertyByIndex(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jpropertyindex, jlong jvalue, jboolean jthis_instance) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int propertyindex = (int)jpropertyindex;
	POINTER_TYPE valueTmp = (POINTER_TYPE)jvalue;
	void *value = N2J_CAST_PTR(valueTmp, void *);
	bool this_instance = N2J_CAST_VAR(jthis_instance != 0, bool);

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Event *)->getPropertyByIndex(propertyindex, value, this_instance);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_Event_1setProperty(JNIEnv *java_env, jclass jcls, jlong jpointer, jbyteArray jpropertyname, jlong jvalue, jboolean jthis_instance) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	const char *propertyname = (const char *)getByteArrayElements(java_env, jpropertyname);
	POINTER_TYPE valueTmp = (POINTER_TYPE)jvalue;
	void *value = N2J_CAST_PTR(valueTmp, void *);
	bool this_instance = N2J_CAST_VAR(jthis_instance != 0, bool);

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Event *)->setProperty(propertyname, value, this_instance);

	releaseByteArrayElements(java_env, jpropertyname, (const char *)propertyname);
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_Event_1setPropertyByIndex(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jpropertyindex, jlong jvalue, jboolean jthis_instance) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int propertyindex = (int)jpropertyindex;
	POINTER_TYPE valueTmp = (POINTER_TYPE)jvalue;
	void *value = N2J_CAST_PTR(valueTmp, void *);
	bool this_instance = N2J_CAST_VAR(jthis_instance != 0, bool);

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Event *)->setPropertyByIndex(propertyindex, value, this_instance);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_Event_1getNumProperties(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jnumproperties, jlong jnumproperties_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int *numproperties = 0;
	if(jnumproperties) {
		numproperties = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jnumproperties), char *)+jnumproperties_, int *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Event *)->getNumProperties(numproperties);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_Event_1getPropertyInfo(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jpropertyindex, jlong jpropertyindex_, jobject jpropertyname, jobject jtypePointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int *propertyindex = 0;
	if(jpropertyindex) {
		propertyindex = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jpropertyindex), char *)+jpropertyindex_, int *);
	}
	char *propertyname/* = 0*/;
	FMOD_EVENTPROPERTY_TYPE type;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Event *)->getPropertyInfo(propertyindex, &propertyname, &type);

	if(jpropertyname) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, char *) = propertyname;
		setPointerAddress(java_env, jpropertyname, newAddress);
	}
	if(jtypePointer) {
		int *typePointer = (int *)java_env->GetDirectBufferAddress(jtypePointer);
		typePointer[0] = type;
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_Event_1getCategory(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jcategory) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD::EventCategory *category/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Event *)->getCategory(&category);

	if(jcategory) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, FMOD::EventCategory *) = category;
		setPointerAddress(java_env, jcategory, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_Event_1setVolume(JNIEnv *java_env, jclass jcls, jlong jpointer, jfloat jvolume) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float volume = (float)jvolume;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Event *)->setVolume(volume);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_Event_1getVolume(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jvolume, jlong jvolume_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float *volume = 0;
	if(jvolume) {
		volume = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jvolume), char *)+jvolume_, float *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Event *)->getVolume(volume);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_Event_1setPitch(JNIEnv *java_env, jclass jcls, jlong jpointer, jfloat jpitch, jint junits) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float pitch = (float)jpitch;
	FMOD_EVENT_PITCHUNITS units = (FMOD_EVENT_PITCHUNITS)junits;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Event *)->setPitch(pitch, units);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_Event_1getPitch(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jpitch, jlong jpitch_, jint junits) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float *pitch = 0;
	if(jpitch) {
		pitch = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jpitch), char *)+jpitch_, float *);
	}
	FMOD_EVENT_PITCHUNITS units = (FMOD_EVENT_PITCHUNITS)junits;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Event *)->getPitch(pitch, units);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_Event_1setPaused(JNIEnv *java_env, jclass jcls, jlong jpointer, jboolean jpaused) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	bool paused = N2J_CAST_VAR(jpaused != 0, bool);

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Event *)->setPaused(paused);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_Event_1getPaused(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jpaused, jlong jpaused_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	bool *paused = 0;
	if(jpaused) {
		paused = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jpaused), char *)+jpaused_, bool *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Event *)->getPaused(paused);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_Event_1setMute(JNIEnv *java_env, jclass jcls, jlong jpointer, jboolean jmute) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	bool mute = N2J_CAST_VAR(jmute != 0, bool);

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Event *)->setMute(mute);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_Event_1getMute(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jmute, jlong jmute_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	bool *mute = 0;
	if(jmute) {
		mute = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jmute), char *)+jmute_, bool *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Event *)->getMute(mute);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_Event_1set3DAttributes(JNIEnv *java_env, jclass jcls, jlong jpointer, jlong jposition, jlong jvelocity, jlong jorientation) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD_VECTOR *position = 0;
	if(jposition) {
		POINTER_TYPE positionTmp = (POINTER_TYPE)jposition;
		position = N2J_CAST_PTR(positionTmp, FMOD_VECTOR *);
	}
	FMOD_VECTOR *velocity = 0;
	if(jvelocity) {
		POINTER_TYPE velocityTmp = (POINTER_TYPE)jvelocity;
		velocity = N2J_CAST_PTR(velocityTmp, FMOD_VECTOR *);
	}
	FMOD_VECTOR *orientation = 0;
	if(jorientation) {
		POINTER_TYPE orientationTmp = (POINTER_TYPE)jorientation;
		orientation = N2J_CAST_PTR(orientationTmp, FMOD_VECTOR *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Event *)->set3DAttributes(position, velocity, orientation);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_Event_1get3DAttributes(JNIEnv *java_env, jclass jcls, jlong jpointer, jlong jposition, jlong jvelocity, jlong jorientation) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD_VECTOR *position = 0;
	if(jposition) {
		POINTER_TYPE positionTmp = (POINTER_TYPE)jposition;
		position = N2J_CAST_PTR(positionTmp, FMOD_VECTOR *);
	}
	FMOD_VECTOR *velocity = 0;
	if(jvelocity) {
		POINTER_TYPE velocityTmp = (POINTER_TYPE)jvelocity;
		velocity = N2J_CAST_PTR(velocityTmp, FMOD_VECTOR *);
	}
	FMOD_VECTOR *orientation = 0;
	if(jorientation) {
		POINTER_TYPE orientationTmp = (POINTER_TYPE)jorientation;
		orientation = N2J_CAST_PTR(orientationTmp, FMOD_VECTOR *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Event *)->get3DAttributes(position, velocity, orientation);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_Event_1set3DOcclusion(JNIEnv *java_env, jclass jcls, jlong jpointer, jfloat jdirectocclusion, jfloat jreverbocclusion) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float directocclusion = (float)jdirectocclusion;
	float reverbocclusion = (float)jreverbocclusion;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Event *)->set3DOcclusion(directocclusion, reverbocclusion);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_Event_1get3DOcclusion(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jdirectocclusion, jlong jdirectocclusion_, jobject jreverbocclusion, jlong jreverbocclusion_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float *directocclusion = 0;
	if(jdirectocclusion) {
		directocclusion = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jdirectocclusion), char *)+jdirectocclusion_, float *);
	}
	float *reverbocclusion = 0;
	if(jreverbocclusion) {
		reverbocclusion = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jreverbocclusion), char *)+jreverbocclusion_, float *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Event *)->get3DOcclusion(directocclusion, reverbocclusion);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_Event_1setReverbProperties(JNIEnv *java_env, jclass jcls, jlong jpointer, jlong jprops) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD_REVERB_CHANNELPROPERTIES *props = 0;
	if(jprops) {
		POINTER_TYPE propsTmp = (POINTER_TYPE)jprops;
		props = N2J_CAST_PTR(propsTmp, FMOD_REVERB_CHANNELPROPERTIES *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Event *)->setReverbProperties(props);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_Event_1getReverbProperties(JNIEnv *java_env, jclass jcls, jlong jpointer, jlong jprops) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD_REVERB_CHANNELPROPERTIES *props = 0;
	if(jprops) {
		POINTER_TYPE propsTmp = (POINTER_TYPE)jprops;
		props = N2J_CAST_PTR(propsTmp, FMOD_REVERB_CHANNELPROPERTIES *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Event *)->getReverbProperties(props);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_Event_1setUserData(JNIEnv *java_env, jclass jcls, jlong jpointer, jlong juserdata) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	POINTER_TYPE userdataTmp = (POINTER_TYPE)juserdata;
	void *userdata = N2J_CAST_PTR(userdataTmp, void *);

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Event *)->setUserData(userdata);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_Event_1getUserData(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject juserdata) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	void *userdata/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Event *)->getUserData(&userdata);

	if(juserdata) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, void *) = userdata;
		setPointerAddress(java_env, juserdata, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_Event_1getMemoryInfo(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jmemorybits, jint jevent_memorybits, jobject jmemoryused, jlong jmemoryused_, jlong jmemoryused_details) {
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

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Event *)->getMemoryInfo(memorybits, event_memorybits, memoryused, memoryused_details);

	return (jint)result_;
}


