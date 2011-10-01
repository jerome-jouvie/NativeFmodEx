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

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_DSP_1release(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::DSP *)->release();

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_DSP_1getSystemObject(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jsystem) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD::System *system/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::DSP *)->getSystemObject(&system);

	if(jsystem) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, FMOD::System *) = system;
		setPointerAddress(java_env, jsystem, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_DSP_1addInput(JNIEnv *java_env, jclass jcls, jlong jpointer, jlong jtarget, jobject jconnection) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD::DSP *target = 0;
	if(jtarget) {
		POINTER_TYPE targetTmp = (POINTER_TYPE)jtarget;
		target = N2J_CAST_PTR(targetTmp, FMOD::DSP *);
	}
	FMOD::DSPConnection *connection/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::DSP *)->addInput(target, &connection);

	if(jconnection) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, FMOD::DSPConnection *) = connection;
		setPointerAddress(java_env, jconnection, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_DSP_1disconnectFrom(JNIEnv *java_env, jclass jcls, jlong jpointer, jlong jtarget) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD::DSP *target = 0;
	if(jtarget) {
		POINTER_TYPE targetTmp = (POINTER_TYPE)jtarget;
		target = N2J_CAST_PTR(targetTmp, FMOD::DSP *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::DSP *)->disconnectFrom(target);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_DSP_1disconnectAll(JNIEnv *java_env, jclass jcls, jlong jpointer, jboolean jinputs, jboolean joutputs) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	bool inputs = N2J_CAST_VAR(jinputs != 0, bool);
	bool outputs = N2J_CAST_VAR(joutputs != 0, bool);

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::DSP *)->disconnectAll(inputs, outputs);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_DSP_1remove(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::DSP *)->remove();

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_DSP_1getNumInputs(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jnuminputs, jlong jnuminputs_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int *numinputs = 0;
	if(jnuminputs) {
		numinputs = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jnuminputs), char *)+jnuminputs_, int *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::DSP *)->getNumInputs(numinputs);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_DSP_1getNumOutputs(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jnumoutputs, jlong jnumoutputs_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int *numoutputs = 0;
	if(jnumoutputs) {
		numoutputs = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jnumoutputs), char *)+jnumoutputs_, int *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::DSP *)->getNumOutputs(numoutputs);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_DSP_1getInput(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jindex, jobject jinput, jobject jinputconnection) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int index = (int)jindex;
	FMOD::DSP *input/* = 0*/;
	FMOD::DSPConnection *inputconnection/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::DSP *)->getInput(index, &input, &inputconnection);

	if(jinput) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, FMOD::DSP *) = input;
		setPointerAddress(java_env, jinput, newAddress);
	}
	if(jinputconnection) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, FMOD::DSPConnection *) = inputconnection;
		setPointerAddress(java_env, jinputconnection, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_DSP_1getOutput(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jindex, jobject joutput, jobject joutputconnection) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int index = (int)jindex;
	FMOD::DSP *output/* = 0*/;
	FMOD::DSPConnection *outputconnection/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::DSP *)->getOutput(index, &output, &outputconnection);

	if(joutput) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, FMOD::DSP *) = output;
		setPointerAddress(java_env, joutput, newAddress);
	}
	if(joutputconnection) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, FMOD::DSPConnection *) = outputconnection;
		setPointerAddress(java_env, joutputconnection, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_DSP_1setActive(JNIEnv *java_env, jclass jcls, jlong jpointer, jboolean jactive) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	bool active = N2J_CAST_VAR(jactive != 0, bool);

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::DSP *)->setActive(active);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_DSP_1getActive(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jactive, jlong jactive_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	bool *active = 0;
	if(jactive) {
		active = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jactive), char *)+jactive_, bool *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::DSP *)->getActive(active);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_DSP_1setBypass(JNIEnv *java_env, jclass jcls, jlong jpointer, jboolean jbypass) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	bool bypass = N2J_CAST_VAR(jbypass != 0, bool);

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::DSP *)->setBypass(bypass);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_DSP_1getBypass(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jbypass, jlong jbypass_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	bool *bypass = 0;
	if(jbypass) {
		bypass = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jbypass), char *)+jbypass_, bool *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::DSP *)->getBypass(bypass);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_DSP_1setSpeakerActive(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jspeaker, jboolean jactive) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD_SPEAKER speaker = (FMOD_SPEAKER)jspeaker;
	bool active = N2J_CAST_VAR(jactive != 0, bool);

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::DSP *)->setSpeakerActive(speaker, active);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_DSP_1getSpeakerActive(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jspeaker, jobject jactive, jlong jactive_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD_SPEAKER speaker = (FMOD_SPEAKER)jspeaker;
	bool *active = 0;
	if(jactive) {
		active = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jactive), char *)+jactive_, bool *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::DSP *)->getSpeakerActive(speaker, active);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_DSP_1reset(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::DSP *)->reset();

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_DSP_1setParameter(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jindex, jfloat jvalue) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int index = (int)jindex;
	float value = (float)jvalue;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::DSP *)->setParameter(index, value);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_DSP_1getParameter(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jindex, jobject jvalue, jlong jvalue_, 	jobject jvaluestr, jlong jvaluestr_, jint jvaluestrlen) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int index = (int)jindex;
	float *value = 0;
	if(jvalue) {
		value = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jvalue), char *)+jvalue_, float *);
	}
	char *valuestr = 0;
	if(jvaluestr) {
		valuestr = N2J_CAST_VAR(java_env->GetDirectBufferAddress(jvaluestr), char *)+jvaluestr_;
	}
	int valuestrlen = (int)jvaluestrlen;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::DSP *)->getParameter(index, value, valuestr, valuestrlen);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_DSP_1getNumParameters(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jnumparams, jlong jnumparams_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int *numparams = 0;
	if(jnumparams) {
		numparams = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jnumparams), char *)+jnumparams_, int *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::DSP *)->getNumParameters(numparams);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_DSP_1getParameterInfo(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jindex, 	jobject jname, jlong jname_, 	jobject jlabel, jlong jlabel_, 	jobject jdescription, jlong jdescription_, jint jdescriptionlen, jobject jmin, jlong jmin_, jobject jmax, jlong jmax_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int index = (int)jindex;
	char *name = 0;
	if(jname) {
		name = N2J_CAST_VAR(java_env->GetDirectBufferAddress(jname), char *)+jname_;
	}
	char *label = 0;
	if(jlabel) {
		label = N2J_CAST_VAR(java_env->GetDirectBufferAddress(jlabel), char *)+jlabel_;
	}
	char *description = 0;
	if(jdescription) {
		description = N2J_CAST_VAR(java_env->GetDirectBufferAddress(jdescription), char *)+jdescription_;
	}
	int descriptionlen = (int)jdescriptionlen;
	float *min = 0;
	if(jmin) {
		min = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jmin), char *)+jmin_, float *);
	}
	float *max = 0;
	if(jmax) {
		max = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jmax), char *)+jmax_, float *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::DSP *)->getParameterInfo(index, name, label, description, descriptionlen, min, max);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_DSP_1showConfigDialog(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jhwnd, jlong hwndHwnd, jboolean jshow) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	jlong handle/* = 0*/;
	if(jhwnd) {
		handle = Java_org_jouvieje_fmodex_FmodExJNI_getHwnd(java_env, jcls, jhwnd);
	}
	bool show = N2J_CAST_VAR(jshow != 0, bool);
	
#if (CURRENT_PLATFORM == NATIVE2JAVA_WIN_32) || (CURRENT_PLATFORM == NATIVE2JAVA_WIN_64)
#pragma message("Windows platform detected !")
	ConfigDialogThreadParams params;
	memset(&params, 0, sizeof(ConfigDialogThreadParams));
	params.pointer = pointer;
	params.handle = handle;
	params.hwndHwnd = hwndHwnd;
	params.show = show;
	params.isShown = false;
	
	_beginthread(configDialogThread, 0, (void *)&params);
	
	while(!params.isShown) {
		Sleep(1);
	}
	return N2J_CAST_VAR(params.result, jint);
#else
#pragma message("Linux/Mac platform detected !")
	FMOD_RESULT result_;
	if(handle) {
		result_ = N2J_CAST_PTR(pointer, FMOD::DSP *)->showConfigDialog(N2J_CAST_PTR(handle, void *), show);
	}
	else {
		result_ = N2J_CAST_PTR(pointer, FMOD::DSP *)->showConfigDialog(N2J_CAST_PTR(hwndHwnd, void *), show);
	}
	return (jint)result_;
#endif
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_DSP_1getInfo(JNIEnv *java_env, jclass jcls, jlong jpointer, 	jobject jname, jlong jname_, jobject jversion, jlong jversion_, jobject jchannels, jlong jchannels_, jobject jconfigwidth, jlong jconfigwidth_, jobject jconfigheight, jlong jconfigheight_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	char *name = 0;
	if(jname) {
		name = N2J_CAST_VAR(java_env->GetDirectBufferAddress(jname), char *)+jname_;
	}
	unsigned int *version = 0;
	if(jversion) {
		version = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jversion), char *)+jversion_, unsigned int *);
	}
	int *channels = 0;
	if(jchannels) {
		channels = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jchannels), char *)+jchannels_, int *);
	}
	int *configwidth = 0;
	if(jconfigwidth) {
		configwidth = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jconfigwidth), char *)+jconfigwidth_, int *);
	}
	int *configheight = 0;
	if(jconfigheight) {
		configheight = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jconfigheight), char *)+jconfigheight_, int *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::DSP *)->getInfo(name, version, channels, configwidth, configheight);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_DSP_1getType(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jtypePointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD_DSP_TYPE type;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::DSP *)->getType(&type);

	if(jtypePointer) {
		int *typePointer = (int *)java_env->GetDirectBufferAddress(jtypePointer);
		typePointer[0] = type;
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_DSP_1setDefaults(JNIEnv *java_env, jclass jcls, jlong jpointer, jfloat jfrequency, jfloat jvolume, jfloat jpan, jint jpriority) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float frequency = (float)jfrequency;
	float volume = (float)jvolume;
	float pan = (float)jpan;
	int priority = (int)jpriority;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::DSP *)->setDefaults(frequency, volume, pan, priority);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_DSP_1getDefaults(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jfrequency, jlong jfrequency_, jobject jvolume, jlong jvolume_, jobject jpan, jlong jpan_, jobject jpriority, jlong jpriority_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float *frequency = 0;
	if(jfrequency) {
		frequency = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jfrequency), char *)+jfrequency_, float *);
	}
	float *volume = 0;
	if(jvolume) {
		volume = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jvolume), char *)+jvolume_, float *);
	}
	float *pan = 0;
	if(jpan) {
		pan = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jpan), char *)+jpan_, float *);
	}
	int *priority = 0;
	if(jpriority) {
		priority = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jpriority), char *)+jpriority_, int *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::DSP *)->getDefaults(frequency, volume, pan, priority);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_DSP_1setUserData(JNIEnv *java_env, jclass jcls, jlong jpointer, jlong juserdata) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	POINTER_TYPE userdataTmp = (POINTER_TYPE)juserdata;
	void *userdata = N2J_CAST_PTR(userdataTmp, void *);

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::DSP *)->setUserData(userdata);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_DSP_1getUserData(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject juserdata) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	void *userdata/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::DSP *)->getUserData(&userdata);

	if(juserdata) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, void *) = userdata;
		setPointerAddress(java_env, juserdata, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_DSP_1getMemoryInfo(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jmemorybits, jint jevent_memorybits, jobject jmemoryused, jlong jmemoryused_, jlong jmemoryused_details) {
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

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::DSP *)->getMemoryInfo(memorybits, event_memorybits, memoryused, memoryused_details);

	return (jint)result_;
}


