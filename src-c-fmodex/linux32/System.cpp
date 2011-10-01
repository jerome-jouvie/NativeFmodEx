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

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_System_1release(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::System *)->release();

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_System_1setOutput(JNIEnv *java_env, jclass jcls, jlong jpointer, jint joutput) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD_OUTPUTTYPE output = (FMOD_OUTPUTTYPE)joutput;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::System *)->setOutput(output);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_System_1getOutput(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject joutputPointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD_OUTPUTTYPE output;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::System *)->getOutput(&output);

	if(joutputPointer) {
		int *outputPointer = (int *)java_env->GetDirectBufferAddress(joutputPointer);
		outputPointer[0] = output;
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_System_1getNumDrivers(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jnumdrivers, jlong jnumdrivers_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int *numdrivers = 0;
	if(jnumdrivers) {
		numdrivers = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jnumdrivers), char *)+jnumdrivers_, int *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::System *)->getNumDrivers(numdrivers);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_System_1getDriverInfo(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jid, 	jobject jname, jlong jname_, jint jnamelen, jlong jguid) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int id = (int)jid;
	char *name = 0;
	if(jname) {
		name = N2J_CAST_VAR(java_env->GetDirectBufferAddress(jname), char *)+jname_;
	}
	int namelen = (int)jnamelen;
	FMOD_GUID *guid = 0;
	if(jguid) {
		POINTER_TYPE guidTmp = (POINTER_TYPE)jguid;
		guid = N2J_CAST_PTR(guidTmp, FMOD_GUID *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::System *)->getDriverInfo(id, name, namelen, guid);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_System_1getDriverCaps(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jid, jobject jcaps, jlong jcaps_, jobject jminfrequency, jlong jminfrequency_, jobject jmaxfrequency, jlong jmaxfrequency_, jobject jcontrolpanelspeakermodePointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int id = (int)jid;
	FMOD_CAPS *caps = 0;
	if(jcaps) {
		caps = N2J_CAST_VAR(N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jcaps), char *)+jcaps_, int *), FMOD_CAPS *);
	}
	int *minfrequency = 0;
	if(jminfrequency) {
		minfrequency = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jminfrequency), char *)+jminfrequency_, int *);
	}
	int *maxfrequency = 0;
	if(jmaxfrequency) {
		maxfrequency = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jmaxfrequency), char *)+jmaxfrequency_, int *);
	}
	FMOD_SPEAKERMODE controlpanelspeakermode;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::System *)->getDriverCaps(id, caps, minfrequency, maxfrequency, &controlpanelspeakermode);

	if(jcontrolpanelspeakermodePointer) {
		int *controlpanelspeakermodePointer = (int *)java_env->GetDirectBufferAddress(jcontrolpanelspeakermodePointer);
		controlpanelspeakermodePointer[0] = controlpanelspeakermode;
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_System_1setDriver(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jdriver) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int driver = (int)jdriver;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::System *)->setDriver(driver);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_System_1getDriver(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jdriver, jlong jdriver_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int *driver = 0;
	if(jdriver) {
		driver = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jdriver), char *)+jdriver_, int *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::System *)->getDriver(driver);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_System_1setHardwareChannels(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jmin2d, jint jmax2d, jint jmin3d, jint jmax3d) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int min2d = (int)jmin2d;
	int max2d = (int)jmax2d;
	int min3d = (int)jmin3d;
	int max3d = (int)jmax3d;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::System *)->setHardwareChannels(min2d, max2d, min3d, max3d);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_System_1setSoftwareChannels(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jnumsoftwarechannels) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int numsoftwarechannels = (int)jnumsoftwarechannels;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::System *)->setSoftwareChannels(numsoftwarechannels);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_System_1getSoftwareChannels(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jnumsoftwarechannels, jlong jnumsoftwarechannels_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int *numsoftwarechannels = 0;
	if(jnumsoftwarechannels) {
		numsoftwarechannels = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jnumsoftwarechannels), char *)+jnumsoftwarechannels_, int *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::System *)->getSoftwareChannels(numsoftwarechannels);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_System_1setSoftwareFormat(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jsamplerate, jint jformat, jint jnumoutputchannels, jint jmaxinputchannels, jint jresamplemethod) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int samplerate = (int)jsamplerate;
	FMOD_SOUND_FORMAT format = (FMOD_SOUND_FORMAT)jformat;
	int numoutputchannels = (int)jnumoutputchannels;
	int maxinputchannels = (int)jmaxinputchannels;
	FMOD_DSP_RESAMPLER resamplemethod = (FMOD_DSP_RESAMPLER)jresamplemethod;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::System *)->setSoftwareFormat(samplerate, format, numoutputchannels, maxinputchannels, resamplemethod);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_System_1getSoftwareFormat(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jsamplerate, jlong jsamplerate_, jobject jformatPointer, jobject jnumoutputchannels, jlong jnumoutputchannels_, jobject jmaxinputchannels, jlong jmaxinputchannels_, jobject jresamplemethodPointer, jobject jbits, jlong jbits_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int *samplerate = 0;
	if(jsamplerate) {
		samplerate = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jsamplerate), char *)+jsamplerate_, int *);
	}
	FMOD_SOUND_FORMAT format;
	int *numoutputchannels = 0;
	if(jnumoutputchannels) {
		numoutputchannels = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jnumoutputchannels), char *)+jnumoutputchannels_, int *);
	}
	int *maxinputchannels = 0;
	if(jmaxinputchannels) {
		maxinputchannels = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jmaxinputchannels), char *)+jmaxinputchannels_, int *);
	}
	FMOD_DSP_RESAMPLER resamplemethod;
	int *bits = 0;
	if(jbits) {
		bits = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jbits), char *)+jbits_, int *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::System *)->getSoftwareFormat(samplerate, &format, numoutputchannels, maxinputchannels, &resamplemethod, bits);

	if(jformatPointer) {
		int *formatPointer = (int *)java_env->GetDirectBufferAddress(jformatPointer);
		formatPointer[0] = format;
	}
	if(jresamplemethodPointer) {
		int *resamplemethodPointer = (int *)java_env->GetDirectBufferAddress(jresamplemethodPointer);
		resamplemethodPointer[0] = resamplemethod;
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_System_1setDSPBufferSize(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jbufferlength, jint jnumbuffers) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int bufferlength = (int)jbufferlength;
	int numbuffers = (int)jnumbuffers;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::System *)->setDSPBufferSize(bufferlength, numbuffers);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_System_1getDSPBufferSize(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jbufferlength, jlong jbufferlength_, jobject jnumbuffers, jlong jnumbuffers_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	unsigned int *bufferlength = 0;
	if(jbufferlength) {
		bufferlength = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jbufferlength), char *)+jbufferlength_, unsigned int *);
	}
	int *numbuffers = 0;
	if(jnumbuffers) {
		numbuffers = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jnumbuffers), char *)+jnumbuffers_, int *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::System *)->getDSPBufferSize(bufferlength, numbuffers);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_System_1setFileSystem(JNIEnv *java_env, jclass jcls, jlong jpointer, jboolean juseropen, jboolean juserclose, jboolean juserread, jboolean juserseek, jboolean juserasyncread, jboolean juserasynccancel, jint jblockalign) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int blockalign = (int)jblockalign;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::System *)->setFileSystem(juseropen == 0 ? NULL : FMOD_FILE_OPENCALLBACK_BRIDGE, juserclose == 0 ? NULL : FMOD_FILE_CLOSECALLBACK_BRIDGE, juserread == 0 ? NULL : FMOD_FILE_READCALLBACK_BRIDGE, juserseek == 0 ? NULL : FMOD_FILE_SEEKCALLBACK_BRIDGE, juserasyncread == 0 ? NULL : FMOD_FILE_ASYNCREADCALLBACK_BRIDGE, juserasynccancel == 0 ? NULL : FMOD_FILE_ASYNCCANCELCALLBACK_BRIDGE, blockalign);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_System_1attachFileSystem(JNIEnv *java_env, jclass jcls, jlong jpointer, jboolean juseropen, jboolean juserclose, jboolean juserread, jboolean juserseek) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::System *)->attachFileSystem(juseropen == 0 ? NULL : FMOD_FILE_OPENCALLBACK_BRIDGE, juserclose == 0 ? NULL : FMOD_FILE_CLOSECALLBACK_BRIDGE, juserread == 0 ? NULL : FMOD_FILE_READCALLBACK_BRIDGE, juserseek == 0 ? NULL : FMOD_FILE_SEEKCALLBACK_BRIDGE);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_System_1setAdvancedSettings(JNIEnv *java_env, jclass jcls, jlong jpointer, jlong jsettings) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD_ADVANCEDSETTINGS *settings = 0;
	if(jsettings) {
		POINTER_TYPE settingsTmp = (POINTER_TYPE)jsettings;
		settings = N2J_CAST_PTR(settingsTmp, FMOD_ADVANCEDSETTINGS *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::System *)->setAdvancedSettings(settings);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_System_1getAdvancedSettings(JNIEnv *java_env, jclass jcls, jlong jpointer, jlong jsettings) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD_ADVANCEDSETTINGS *settings = 0;
	if(jsettings) {
		POINTER_TYPE settingsTmp = (POINTER_TYPE)jsettings;
		settings = N2J_CAST_PTR(settingsTmp, FMOD_ADVANCEDSETTINGS *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::System *)->getAdvancedSettings(settings);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_System_1setSpeakerMode(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jspeakermode) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD_SPEAKERMODE speakermode = (FMOD_SPEAKERMODE)jspeakermode;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::System *)->setSpeakerMode(speakermode);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_System_1getSpeakerMode(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jspeakermodePointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD_SPEAKERMODE speakermode;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::System *)->getSpeakerMode(&speakermode);

	if(jspeakermodePointer) {
		int *speakermodePointer = (int *)java_env->GetDirectBufferAddress(jspeakermodePointer);
		speakermodePointer[0] = speakermode;
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_System_1setCallback(JNIEnv *java_env, jclass jcls, jlong jpointer, jboolean jcallback) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::System *)->setCallback(jcallback == 0 ? NULL : FMOD_SYSTEM_CALLBACK_BRIDGE);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_System_1setPluginPath(JNIEnv *java_env, jclass jcls, jlong jpointer, jbyteArray jpath) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	const char *path = (const char *)getByteArrayElements(java_env, jpath);

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::System *)->setPluginPath(path);

	releaseByteArrayElements(java_env, jpath, (const char *)path);
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_System_1loadPlugin(JNIEnv *java_env, jclass jcls, jlong jpointer, jbyteArray jfilename, jobject jhandle, jlong jhandle_, jint jpriority) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	const char *filename = (const char *)getByteArrayElements(java_env, jfilename);
	unsigned int *handle = 0;
	if(jhandle) {
		handle = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jhandle), char *)+jhandle_, unsigned int *);
	}
	int priority = (int)jpriority;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::System *)->loadPlugin(filename, handle, priority);

	releaseByteArrayElements(java_env, jfilename, (const char *)filename);
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_System_1unloadPlugin(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jhandle) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int handle = (int)jhandle;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::System *)->unloadPlugin(handle);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_System_1getNumPlugins(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jplugintype, jobject jnumplugins, jlong jnumplugins_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD_PLUGINTYPE plugintype = (FMOD_PLUGINTYPE)jplugintype;
	int *numplugins = 0;
	if(jnumplugins) {
		numplugins = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jnumplugins), char *)+jnumplugins_, int *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::System *)->getNumPlugins(plugintype, numplugins);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_System_1getPluginHandle(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jplugintype, jint jindex, jobject jhandle, jlong jhandle_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD_PLUGINTYPE plugintype = (FMOD_PLUGINTYPE)jplugintype;
	int index = (int)jindex;
	unsigned int *handle = 0;
	if(jhandle) {
		handle = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jhandle), char *)+jhandle_, unsigned int *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::System *)->getPluginHandle(plugintype, index, handle);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_System_1getPluginInfo(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jhandle, jobject jplugintypePointer, 	jobject jname, jlong jname_, jint jnamelen, jobject jversion, jlong jversion_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int handle = (int)jhandle;
	FMOD_PLUGINTYPE plugintype;
	char *name = 0;
	if(jname) {
		name = N2J_CAST_VAR(java_env->GetDirectBufferAddress(jname), char *)+jname_;
	}
	int namelen = (int)jnamelen;
	unsigned int *version = 0;
	if(jversion) {
		version = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jversion), char *)+jversion_, unsigned int *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::System *)->getPluginInfo(handle, &plugintype, name, namelen, version);

	if(jplugintypePointer) {
		int *plugintypePointer = (int *)java_env->GetDirectBufferAddress(jplugintypePointer);
		plugintypePointer[0] = plugintype;
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_System_1setOutputByPlugin(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jhandle) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int handle = (int)jhandle;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::System *)->setOutputByPlugin(handle);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_System_1getOutputByPlugin(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jhandle, jlong jhandle_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	unsigned int *handle = 0;
	if(jhandle) {
		handle = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jhandle), char *)+jhandle_, unsigned int *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::System *)->getOutputByPlugin(handle);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_System_1createDSPByPlugin(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jhandle, jobject jdsp) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int handle = (int)jhandle;
	FMOD::DSP *dsp/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::System *)->createDSPByPlugin(handle, &dsp);

	if(jdsp) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, FMOD::DSP *) = dsp;
		setPointerAddress(java_env, jdsp, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_System_1createCodec(JNIEnv *java_env, jclass jcls, jlong jpointer, jlong jdescription, jint jpriority) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD_CODEC_DESCRIPTION *description = 0;
	if(jdescription) {
		POINTER_TYPE descriptionTmp = (POINTER_TYPE)jdescription;
		description = N2J_CAST_PTR(descriptionTmp, FMOD_CODEC_DESCRIPTION *);
	}
	int priority = (int)jpriority;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::System *)->createCodec(description, priority);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_System_1init(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jmaxchannels, jint jflags, jlong jextradriverdata) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int maxchannels = (int)jmaxchannels;
	FMOD_INITFLAGS flags = (FMOD_INITFLAGS)jflags;
	POINTER_TYPE extradriverdataTmp = (POINTER_TYPE)jextradriverdata;
	void *extradriverdata = N2J_CAST_PTR(extradriverdataTmp, void *);

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::System *)->init(maxchannels, flags, extradriverdata);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_System_1close(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::System *)->close();

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_System_1update(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::System *)->update();

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_System_1set3DSettings(JNIEnv *java_env, jclass jcls, jlong jpointer, jfloat jdopplerscale, jfloat jdistancefactor, jfloat jrolloffscale) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float dopplerscale = (float)jdopplerscale;
	float distancefactor = (float)jdistancefactor;
	float rolloffscale = (float)jrolloffscale;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::System *)->set3DSettings(dopplerscale, distancefactor, rolloffscale);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_System_1get3DSettings(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jdopplerscale, jlong jdopplerscale_, jobject jdistancefactor, jlong jdistancefactor_, jobject jrolloffscale, jlong jrolloffscale_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float *dopplerscale = 0;
	if(jdopplerscale) {
		dopplerscale = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jdopplerscale), char *)+jdopplerscale_, float *);
	}
	float *distancefactor = 0;
	if(jdistancefactor) {
		distancefactor = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jdistancefactor), char *)+jdistancefactor_, float *);
	}
	float *rolloffscale = 0;
	if(jrolloffscale) {
		rolloffscale = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jrolloffscale), char *)+jrolloffscale_, float *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::System *)->get3DSettings(dopplerscale, distancefactor, rolloffscale);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_System_1set3DNumListeners(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jnumlisteners) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int numlisteners = (int)jnumlisteners;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::System *)->set3DNumListeners(numlisteners);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_System_1get3DNumListeners(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jnumlisteners, jlong jnumlisteners_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int *numlisteners = 0;
	if(jnumlisteners) {
		numlisteners = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jnumlisteners), char *)+jnumlisteners_, int *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::System *)->get3DNumListeners(numlisteners);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_System_1set3DListenerAttributes(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jlistener, jlong jpos, jlong jvel, jlong jforward, jlong jup) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int listener = (int)jlistener;
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
	FMOD_VECTOR *forward = 0;
	if(jforward) {
		POINTER_TYPE forwardTmp = (POINTER_TYPE)jforward;
		forward = N2J_CAST_PTR(forwardTmp, FMOD_VECTOR *);
	}
	FMOD_VECTOR *up = 0;
	if(jup) {
		POINTER_TYPE upTmp = (POINTER_TYPE)jup;
		up = N2J_CAST_PTR(upTmp, FMOD_VECTOR *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::System *)->set3DListenerAttributes(listener, pos, vel, forward, up);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_System_1get3DListenerAttributes(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jlistener, jlong jpos, jlong jvel, jlong jforward, jlong jup) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int listener = (int)jlistener;
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
	FMOD_VECTOR *forward = 0;
	if(jforward) {
		POINTER_TYPE forwardTmp = (POINTER_TYPE)jforward;
		forward = N2J_CAST_PTR(forwardTmp, FMOD_VECTOR *);
	}
	FMOD_VECTOR *up = 0;
	if(jup) {
		POINTER_TYPE upTmp = (POINTER_TYPE)jup;
		up = N2J_CAST_PTR(upTmp, FMOD_VECTOR *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::System *)->get3DListenerAttributes(listener, pos, vel, forward, up);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_System_1set3DRolloffCallback(JNIEnv *java_env, jclass jcls, jlong jpointer, jboolean jcallback) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::System *)->set3DRolloffCallback(jcallback == 0 ? NULL : FMOD_3D_ROLLOFFCALLBACK_BRIDGE);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_System_1set3DSpeakerPosition(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jspeaker, jfloat jx, jfloat jy, jboolean jactive) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD_SPEAKER speaker = (FMOD_SPEAKER)jspeaker;
	float x = (float)jx;
	float y = (float)jy;
	bool active = N2J_CAST_VAR(jactive != 0, bool);

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::System *)->set3DSpeakerPosition(speaker, x, y, active);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_System_1get3DSpeakerPosition(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jspeaker, jobject jx, jlong jx_, jobject jy, jlong jy_, jobject jactive, jlong jactive_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD_SPEAKER speaker = (FMOD_SPEAKER)jspeaker;
	float *x = 0;
	if(jx) {
		x = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jx), char *)+jx_, float *);
	}
	float *y = 0;
	if(jy) {
		y = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jy), char *)+jy_, float *);
	}
	bool *active = 0;
	if(jactive) {
		active = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jactive), char *)+jactive_, bool *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::System *)->get3DSpeakerPosition(speaker, x, y, active);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_System_1setStreamBufferSize(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jfilebuffersize, jint jfilebuffersizetype) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int filebuffersize = (int)jfilebuffersize;
	FMOD_TIMEUNIT filebuffersizetype = (FMOD_TIMEUNIT)jfilebuffersizetype;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::System *)->setStreamBufferSize(filebuffersize, filebuffersizetype);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_System_1getStreamBufferSize(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jfilebuffersize, jlong jfilebuffersize_, jobject jfilebuffersizetype, jlong jfilebuffersizetype_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	unsigned int *filebuffersize = 0;
	if(jfilebuffersize) {
		filebuffersize = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jfilebuffersize), char *)+jfilebuffersize_, unsigned int *);
	}
	FMOD_TIMEUNIT *filebuffersizetype = 0;
	if(jfilebuffersizetype) {
		filebuffersizetype = N2J_CAST_VAR(N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jfilebuffersizetype), char *)+jfilebuffersizetype_, int *), FMOD_TIMEUNIT *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::System *)->getStreamBufferSize(filebuffersize, filebuffersizetype);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_System_1getVersion(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jversion, jlong jversion_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	unsigned int *version = 0;
	if(jversion) {
		version = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jversion), char *)+jversion_, unsigned int *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::System *)->getVersion(version);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_System_1getOutputHandle(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jhandle) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	void *handle/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::System *)->getOutputHandle(&handle);

	if(jhandle) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, void *) = handle;
		setPointerAddress(java_env, jhandle, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_System_1getChannelsPlaying(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jchannels, jlong jchannels_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int *channels = 0;
	if(jchannels) {
		channels = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jchannels), char *)+jchannels_, int *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::System *)->getChannelsPlaying(channels);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_System_1getHardwareChannels(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jnum2d, jlong jnum2d_, jobject jnum3d, jlong jnum3d_, jobject jtotal, jlong jtotal_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int *num2d = 0;
	if(jnum2d) {
		num2d = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jnum2d), char *)+jnum2d_, int *);
	}
	int *num3d = 0;
	if(jnum3d) {
		num3d = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jnum3d), char *)+jnum3d_, int *);
	}
	int *total = 0;
	if(jtotal) {
		total = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jtotal), char *)+jtotal_, int *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::System *)->getHardwareChannels(num2d, num3d, total);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_System_1getCPUUsage(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jdsp, jlong jdsp_, jobject jstream, jlong jstream_, jobject jgeometry, jlong jgeometry_, jobject jupdate, jlong jupdate_, jobject jtotal, jlong jtotal_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float *dsp = 0;
	if(jdsp) {
		dsp = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jdsp), char *)+jdsp_, float *);
	}
	float *stream = 0;
	if(jstream) {
		stream = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jstream), char *)+jstream_, float *);
	}
	float *geometry = 0;
	if(jgeometry) {
		geometry = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jgeometry), char *)+jgeometry_, float *);
	}
	float *update = 0;
	if(jupdate) {
		update = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jupdate), char *)+jupdate_, float *);
	}
	float *total = 0;
	if(jtotal) {
		total = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jtotal), char *)+jtotal_, float *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::System *)->getCPUUsage(dsp, stream, geometry, update, total);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_System_1getSoundRAM(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jcurrentalloced, jlong jcurrentalloced_, jobject jmaxalloced, jlong jmaxalloced_, jobject jtotal, jlong jtotal_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int *currentalloced = 0;
	if(jcurrentalloced) {
		currentalloced = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jcurrentalloced), char *)+jcurrentalloced_, int *);
	}
	int *maxalloced = 0;
	if(jmaxalloced) {
		maxalloced = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jmaxalloced), char *)+jmaxalloced_, int *);
	}
	int *total = 0;
	if(jtotal) {
		total = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jtotal), char *)+jtotal_, int *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::System *)->getSoundRAM(currentalloced, maxalloced, total);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_System_1getNumCDROMDrives(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jnumdrives, jlong jnumdrives_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int *numdrives = 0;
	if(jnumdrives) {
		numdrives = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jnumdrives), char *)+jnumdrives_, int *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::System *)->getNumCDROMDrives(numdrives);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_System_1getCDROMDriveName(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jdrive, 	jobject jdrivename, jlong jdrivename_, jint jdrivenamelen, 	jobject jscsiname, jlong jscsiname_, jint jscsinamelen, 	jobject jdevicename, jlong jdevicename_, jint jdevicenamelen) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int drive = (int)jdrive;
	char *drivename = 0;
	if(jdrivename) {
		drivename = N2J_CAST_VAR(java_env->GetDirectBufferAddress(jdrivename), char *)+jdrivename_;
	}
	int drivenamelen = (int)jdrivenamelen;
	char *scsiname = 0;
	if(jscsiname) {
		scsiname = N2J_CAST_VAR(java_env->GetDirectBufferAddress(jscsiname), char *)+jscsiname_;
	}
	int scsinamelen = (int)jscsinamelen;
	char *devicename = 0;
	if(jdevicename) {
		devicename = N2J_CAST_VAR(java_env->GetDirectBufferAddress(jdevicename), char *)+jdevicename_;
	}
	int devicenamelen = (int)jdevicenamelen;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::System *)->getCDROMDriveName(drive, drivename, drivenamelen, scsiname, scsinamelen, devicename, devicenamelen);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_System_1getSpectrum(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jspectrumarray, jlong jspectrumarray_, jint jnumvalues, jint jchanneloffset, jint jwindowtype) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float *spectrumarray = 0;
	if(jspectrumarray) {
		spectrumarray = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jspectrumarray), char *)+jspectrumarray_, float *);
	}
	int numvalues = (int)jnumvalues;
	int channeloffset = (int)jchanneloffset;
	FMOD_DSP_FFT_WINDOW windowtype = (FMOD_DSP_FFT_WINDOW)jwindowtype;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::System *)->getSpectrum(spectrumarray, numvalues, channeloffset, windowtype);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_System_1getWaveData(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jwavearray, jlong jwavearray_, jint jnumvalues, jint jchanneloffset) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float *wavearray = 0;
	if(jwavearray) {
		wavearray = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jwavearray), char *)+jwavearray_, float *);
	}
	int numvalues = (int)jnumvalues;
	int channeloffset = (int)jchanneloffset;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::System *)->getWaveData(wavearray, numvalues, channeloffset);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_System_1createSound__J_3BIJLorg_jouvieje_fmodex_Sound_2(JNIEnv *java_env, jclass jcls, jlong jpointer, jbyteArray jname_or_data, jint jmode, jlong jexinfo, jobject jsound) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	const char *name_or_data = (const char *)getByteArrayElements(java_env, jname_or_data);
	FMOD_MODE mode = (FMOD_MODE)jmode;
	FMOD_CREATESOUNDEXINFO *exinfo = 0;
	if(jexinfo) {
		POINTER_TYPE exinfoTmp = (POINTER_TYPE)jexinfo;
		exinfo = N2J_CAST_PTR(exinfoTmp, FMOD_CREATESOUNDEXINFO *);
	}
	FMOD::Sound *sound/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::System *)->createSound(name_or_data, mode, exinfo, &sound);

	releaseByteArrayElements(java_env, jname_or_data, (const char *)name_or_data);
	if(jsound) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, FMOD::Sound *) = sound;
		setPointerAddress(java_env, jsound, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_System_1createSound__JLjava_nio_ByteBuffer_2JIJLorg_jouvieje_fmodex_Sound_2(JNIEnv *java_env, jclass jcls, jlong jpointer, 	jobject jname_or_data, jlong jname_or_data_, jint jmode, jlong jexinfo, jobject jsound) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	const char *name_or_data = 0;
	if(jname_or_data) {
		name_or_data = N2J_CAST_VAR(java_env->GetDirectBufferAddress(jname_or_data), const char *)+jname_or_data_;
	}
	FMOD_MODE mode = (FMOD_MODE)jmode;
	FMOD_CREATESOUNDEXINFO *exinfo = 0;
	if(jexinfo) {
		POINTER_TYPE exinfoTmp = (POINTER_TYPE)jexinfo;
		exinfo = N2J_CAST_PTR(exinfoTmp, FMOD_CREATESOUNDEXINFO *);
	}
	FMOD::Sound *sound/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::System *)->createSound(name_or_data, mode, exinfo, &sound);

	if(jsound) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, FMOD::Sound *) = sound;
		setPointerAddress(java_env, jsound, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_System_1createStream__J_3BIJLorg_jouvieje_fmodex_Sound_2(JNIEnv *java_env, jclass jcls, jlong jpointer, jbyteArray jname_or_data, jint jmode, jlong jexinfo, jobject jsound) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	const char *name_or_data = (const char *)getByteArrayElements(java_env, jname_or_data);
	FMOD_MODE mode = (FMOD_MODE)jmode;
	FMOD_CREATESOUNDEXINFO *exinfo = 0;
	if(jexinfo) {
		POINTER_TYPE exinfoTmp = (POINTER_TYPE)jexinfo;
		exinfo = N2J_CAST_PTR(exinfoTmp, FMOD_CREATESOUNDEXINFO *);
	}
	FMOD::Sound *sound/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::System *)->createStream(name_or_data, mode, exinfo, &sound);

	releaseByteArrayElements(java_env, jname_or_data, (const char *)name_or_data);
	if(jsound) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, FMOD::Sound *) = sound;
		setPointerAddress(java_env, jsound, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_System_1createStream__JLjava_nio_ByteBuffer_2JIJLorg_jouvieje_fmodex_Sound_2(JNIEnv *java_env, jclass jcls, jlong jpointer, 	jobject jname_or_data, jlong jname_or_data_, jint jmode, jlong jexinfo, jobject jsound) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	const char *name_or_data = 0;
	if(jname_or_data) {
		name_or_data = N2J_CAST_VAR(java_env->GetDirectBufferAddress(jname_or_data), const char *)+jname_or_data_;
	}
	FMOD_MODE mode = (FMOD_MODE)jmode;
	FMOD_CREATESOUNDEXINFO *exinfo = 0;
	if(jexinfo) {
		POINTER_TYPE exinfoTmp = (POINTER_TYPE)jexinfo;
		exinfo = N2J_CAST_PTR(exinfoTmp, FMOD_CREATESOUNDEXINFO *);
	}
	FMOD::Sound *sound/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::System *)->createStream(name_or_data, mode, exinfo, &sound);

	if(jsound) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, FMOD::Sound *) = sound;
		setPointerAddress(java_env, jsound, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_System_1createDSP(JNIEnv *java_env, jclass jcls, jlong jpointer, jlong jdescription, jobject jdsp) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD_DSP_DESCRIPTION *description = 0;
	if(jdescription) {
		POINTER_TYPE descriptionTmp = (POINTER_TYPE)jdescription;
		description = N2J_CAST_PTR(descriptionTmp, FMOD_DSP_DESCRIPTION *);
	}
	FMOD::DSP *dsp/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::System *)->createDSP(description, &dsp);

	if(jdsp) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, FMOD::DSP *) = dsp;
		setPointerAddress(java_env, jdsp, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_System_1createDSPByType(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jtype, jobject jdsp) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD_DSP_TYPE type = (FMOD_DSP_TYPE)jtype;
	FMOD::DSP *dsp/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::System *)->createDSPByType(type, &dsp);

	if(jdsp) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, FMOD::DSP *) = dsp;
		setPointerAddress(java_env, jdsp, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_System_1createChannelGroup(JNIEnv *java_env, jclass jcls, jlong jpointer, jbyteArray jname, jobject jchannelgroup) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	const char *name = (const char *)getByteArrayElements(java_env, jname);
	FMOD::ChannelGroup *channelgroup/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::System *)->createChannelGroup(name, &channelgroup);

	releaseByteArrayElements(java_env, jname, (const char *)name);
	if(jchannelgroup) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, FMOD::ChannelGroup *) = channelgroup;
		setPointerAddress(java_env, jchannelgroup, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_System_1createSoundGroup(JNIEnv *java_env, jclass jcls, jlong jpointer, jbyteArray jname, jobject jsoundgroup) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	const char *name = (const char *)getByteArrayElements(java_env, jname);
	FMOD::SoundGroup *soundgroup/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::System *)->createSoundGroup(name, &soundgroup);

	releaseByteArrayElements(java_env, jname, (const char *)name);
	if(jsoundgroup) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, FMOD::SoundGroup *) = soundgroup;
		setPointerAddress(java_env, jsoundgroup, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_System_1createReverb(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jreverb) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD::Reverb *reverb/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::System *)->createReverb(&reverb);

	if(jreverb) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, FMOD::Reverb *) = reverb;
		setPointerAddress(java_env, jreverb, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_System_1playSound(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jchannelid, jlong jsound, jboolean jpaused, jobject jchannel) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD_CHANNELINDEX channelid = (FMOD_CHANNELINDEX)jchannelid;
	FMOD::Sound *sound = 0;
	if(jsound) {
		POINTER_TYPE soundTmp = (POINTER_TYPE)jsound;
		sound = N2J_CAST_PTR(soundTmp, FMOD::Sound *);
	}
	bool paused = N2J_CAST_VAR(jpaused != 0, bool);
	FMOD::Channel *channel/* = 0*/;
	if(jchannel) {
		POINTER_TYPE jchannelAddress = getPointerAddress(java_env, jchannel);
		if(jchannelAddress) {
			channel = N2J_CAST_PTR(jchannelAddress, FMOD::Channel *);
		}
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::System *)->playSound(channelid, sound, paused, &channel);

	if(jchannel) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, FMOD::Channel *) = channel;
		setPointerAddress(java_env, jchannel, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_System_1playDSP(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jchannelid, jlong jdsp, jboolean jpaused, jobject jchannel) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD_CHANNELINDEX channelid = (FMOD_CHANNELINDEX)jchannelid;
	FMOD::DSP *dsp = 0;
	if(jdsp) {
		POINTER_TYPE dspTmp = (POINTER_TYPE)jdsp;
		dsp = N2J_CAST_PTR(dspTmp, FMOD::DSP *);
	}
	bool paused = N2J_CAST_VAR(jpaused != 0, bool);
	FMOD::Channel *channel/* = 0*/;
	if(jchannel) {
		POINTER_TYPE jchannelAddress = getPointerAddress(java_env, jchannel);
		if(jchannelAddress) {
			channel = N2J_CAST_PTR(jchannelAddress, FMOD::Channel *);
		}
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::System *)->playDSP(channelid, dsp, paused, &channel);

	if(jchannel) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, FMOD::Channel *) = channel;
		setPointerAddress(java_env, jchannel, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_System_1getChannel(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jchannelid, jobject jchannel) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int channelid = (int)jchannelid;
	FMOD::Channel *channel/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::System *)->getChannel(channelid, &channel);

	if(jchannel) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, FMOD::Channel *) = channel;
		setPointerAddress(java_env, jchannel, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_System_1getMasterChannelGroup(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jchannelgroup) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD::ChannelGroup *channelgroup/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::System *)->getMasterChannelGroup(&channelgroup);

	if(jchannelgroup) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, FMOD::ChannelGroup *) = channelgroup;
		setPointerAddress(java_env, jchannelgroup, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_System_1getMasterSoundGroup(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jsoundgroup) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD::SoundGroup *soundgroup/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::System *)->getMasterSoundGroup(&soundgroup);

	if(jsoundgroup) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, FMOD::SoundGroup *) = soundgroup;
		setPointerAddress(java_env, jsoundgroup, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_System_1setReverbProperties(JNIEnv *java_env, jclass jcls, jlong jpointer, jlong jprop) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD_REVERB_PROPERTIES *prop = 0;
	if(jprop) {
		POINTER_TYPE propTmp = (POINTER_TYPE)jprop;
		prop = N2J_CAST_PTR(propTmp, FMOD_REVERB_PROPERTIES *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::System *)->setReverbProperties(prop);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_System_1getReverbProperties(JNIEnv *java_env, jclass jcls, jlong jpointer, jlong jprop) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD_REVERB_PROPERTIES *prop = 0;
	if(jprop) {
		POINTER_TYPE propTmp = (POINTER_TYPE)jprop;
		prop = N2J_CAST_PTR(propTmp, FMOD_REVERB_PROPERTIES *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::System *)->getReverbProperties(prop);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_System_1setReverbAmbientProperties(JNIEnv *java_env, jclass jcls, jlong jpointer, jlong jprop) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD_REVERB_PROPERTIES *prop = 0;
	if(jprop) {
		POINTER_TYPE propTmp = (POINTER_TYPE)jprop;
		prop = N2J_CAST_PTR(propTmp, FMOD_REVERB_PROPERTIES *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::System *)->setReverbAmbientProperties(prop);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_System_1getReverbAmbientProperties(JNIEnv *java_env, jclass jcls, jlong jpointer, jlong jprop) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD_REVERB_PROPERTIES *prop = 0;
	if(jprop) {
		POINTER_TYPE propTmp = (POINTER_TYPE)jprop;
		prop = N2J_CAST_PTR(propTmp, FMOD_REVERB_PROPERTIES *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::System *)->getReverbAmbientProperties(prop);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_System_1getDSPHead(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jdsp) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD::DSP *dsp/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::System *)->getDSPHead(&dsp);

	if(jdsp) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, FMOD::DSP *) = dsp;
		setPointerAddress(java_env, jdsp, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_System_1addDSP(JNIEnv *java_env, jclass jcls, jlong jpointer, jlong jdsp, jobject jconnection) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD::DSP *dsp = 0;
	if(jdsp) {
		POINTER_TYPE dspTmp = (POINTER_TYPE)jdsp;
		dsp = N2J_CAST_PTR(dspTmp, FMOD::DSP *);
	}
	FMOD::DSPConnection *connection/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::System *)->addDSP(dsp, &connection);

	if(jconnection) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, FMOD::DSPConnection *) = connection;
		setPointerAddress(java_env, jconnection, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_System_1lockDSP(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::System *)->lockDSP();

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_System_1unlockDSP(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::System *)->unlockDSP();

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_System_1getDSPClock(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jhi, jlong jhi_, jobject jlo, jlong jlo_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	unsigned int *hi = 0;
	if(jhi) {
		hi = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jhi), char *)+jhi_, unsigned int *);
	}
	unsigned int *lo = 0;
	if(jlo) {
		lo = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jlo), char *)+jlo_, unsigned int *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::System *)->getDSPClock(hi, lo);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_System_1getRecordNumDrivers(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jnumdrivers, jlong jnumdrivers_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int *numdrivers = 0;
	if(jnumdrivers) {
		numdrivers = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jnumdrivers), char *)+jnumdrivers_, int *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::System *)->getRecordNumDrivers(numdrivers);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_System_1getRecordDriverInfo(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jid, 	jobject jname, jlong jname_, jint jnamelen, jlong jguid) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int id = (int)jid;
	char *name = 0;
	if(jname) {
		name = N2J_CAST_VAR(java_env->GetDirectBufferAddress(jname), char *)+jname_;
	}
	int namelen = (int)jnamelen;
	FMOD_GUID *guid = 0;
	if(jguid) {
		POINTER_TYPE guidTmp = (POINTER_TYPE)jguid;
		guid = N2J_CAST_PTR(guidTmp, FMOD_GUID *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::System *)->getRecordDriverInfo(id, name, namelen, guid);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_System_1getRecordDriverCaps(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jid, jobject jcaps, jlong jcaps_, jobject jminfrequency, jlong jminfrequency_, jobject jmaxfrequency, jlong jmaxfrequency_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int id = (int)jid;
	FMOD_CAPS *caps = 0;
	if(jcaps) {
		caps = N2J_CAST_VAR(N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jcaps), char *)+jcaps_, int *), FMOD_CAPS *);
	}
	int *minfrequency = 0;
	if(jminfrequency) {
		minfrequency = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jminfrequency), char *)+jminfrequency_, int *);
	}
	int *maxfrequency = 0;
	if(jmaxfrequency) {
		maxfrequency = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jmaxfrequency), char *)+jmaxfrequency_, int *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::System *)->getRecordDriverCaps(id, caps, minfrequency, maxfrequency);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_System_1getRecordPosition(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jid, jobject jposition, jlong jposition_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int id = (int)jid;
	unsigned int *position = 0;
	if(jposition) {
		position = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jposition), char *)+jposition_, unsigned int *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::System *)->getRecordPosition(id, position);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_System_1recordStart(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jid, jlong jsound, jboolean jloop) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int id = (int)jid;
	FMOD::Sound *sound = 0;
	if(jsound) {
		POINTER_TYPE soundTmp = (POINTER_TYPE)jsound;
		sound = N2J_CAST_PTR(soundTmp, FMOD::Sound *);
	}
	bool loop = N2J_CAST_VAR(jloop != 0, bool);

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::System *)->recordStart(id, sound, loop);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_System_1recordStop(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jid) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int id = (int)jid;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::System *)->recordStop(id);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_System_1isRecording(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jid, jobject jrecording, jlong jrecording_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int id = (int)jid;
	bool *recording = 0;
	if(jrecording) {
		recording = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jrecording), char *)+jrecording_, bool *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::System *)->isRecording(id, recording);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_System_1createGeometry(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jmaxpolygons, jint jmaxvertices, jobject jgeometry) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int maxpolygons = (int)jmaxpolygons;
	int maxvertices = (int)jmaxvertices;
	FMOD::Geometry *geometry/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::System *)->createGeometry(maxpolygons, maxvertices, &geometry);

	if(jgeometry) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, FMOD::Geometry *) = geometry;
		setPointerAddress(java_env, jgeometry, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_System_1setGeometrySettings(JNIEnv *java_env, jclass jcls, jlong jpointer, jfloat jmaxworldsize) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float maxworldsize = (float)jmaxworldsize;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::System *)->setGeometrySettings(maxworldsize);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_System_1getGeometrySettings(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jmaxworldsize, jlong jmaxworldsize_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float *maxworldsize = 0;
	if(jmaxworldsize) {
		maxworldsize = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jmaxworldsize), char *)+jmaxworldsize_, float *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::System *)->getGeometrySettings(maxworldsize);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_System_1loadGeometry(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jdata, jlong jdata_, jint jdatasize, jobject jgeometry) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	void *data = 0;
	if(jdata) {
		data = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jdata), char *)+jdata_, void *);
	}
	int datasize = (int)jdatasize;
	FMOD::Geometry *geometry/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::System *)->loadGeometry(data, datasize, &geometry);

	if(jgeometry) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, FMOD::Geometry *) = geometry;
		setPointerAddress(java_env, jgeometry, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_System_1getGeometryOcclusion(JNIEnv *java_env, jclass jcls, jlong jpointer, jlong jlistener, jlong jsource, jobject jdirect, jlong jdirect_, jobject jreverb, jlong jreverb_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD_VECTOR *listener = 0;
	if(jlistener) {
		POINTER_TYPE listenerTmp = (POINTER_TYPE)jlistener;
		listener = N2J_CAST_PTR(listenerTmp, FMOD_VECTOR *);
	}
	FMOD_VECTOR *source = 0;
	if(jsource) {
		POINTER_TYPE sourceTmp = (POINTER_TYPE)jsource;
		source = N2J_CAST_PTR(sourceTmp, FMOD_VECTOR *);
	}
	float *direct = 0;
	if(jdirect) {
		direct = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jdirect), char *)+jdirect_, float *);
	}
	float *reverb = 0;
	if(jreverb) {
		reverb = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jreverb), char *)+jreverb_, float *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::System *)->getGeometryOcclusion(listener, source, direct, reverb);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_System_1setNetworkProxy(JNIEnv *java_env, jclass jcls, jlong jpointer, jbyteArray jproxy) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	const char *proxy = (const char *)getByteArrayElements(java_env, jproxy);

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::System *)->setNetworkProxy(proxy);

	releaseByteArrayElements(java_env, jproxy, (const char *)proxy);
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_System_1getNetworkProxy(JNIEnv *java_env, jclass jcls, jlong jpointer, 	jobject jproxy, jlong jproxy_, jint jproxylen) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	char *proxy = 0;
	if(jproxy) {
		proxy = N2J_CAST_VAR(java_env->GetDirectBufferAddress(jproxy), char *)+jproxy_;
	}
	int proxylen = (int)jproxylen;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::System *)->getNetworkProxy(proxy, proxylen);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_System_1setNetworkTimeout(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jtimeout) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int timeout = (int)jtimeout;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::System *)->setNetworkTimeout(timeout);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_System_1getNetworkTimeout(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jtimeout, jlong jtimeout_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int *timeout = 0;
	if(jtimeout) {
		timeout = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jtimeout), char *)+jtimeout_, int *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::System *)->getNetworkTimeout(timeout);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_System_1setUserData(JNIEnv *java_env, jclass jcls, jlong jpointer, jlong juserdata) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	POINTER_TYPE userdataTmp = (POINTER_TYPE)juserdata;
	void *userdata = N2J_CAST_PTR(userdataTmp, void *);

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::System *)->setUserData(userdata);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_System_1getUserData(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject juserdata) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	void *userdata/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::System *)->getUserData(&userdata);

	if(juserdata) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, void *) = userdata;
		setPointerAddress(java_env, juserdata, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_System_1getMemoryInfo(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jmemorybits, jint jevent_memorybits, jobject jmemoryused, jlong jmemoryused_, jlong jmemoryused_details) {
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

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::System *)->getMemoryInfo(memorybits, event_memorybits, memoryused, memoryused_details);

	return (jint)result_;
}


