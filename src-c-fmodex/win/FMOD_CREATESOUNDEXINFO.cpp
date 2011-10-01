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

JNIEXPORT jlong JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CREATESOUNDEXINFO_1new(JNIEnv *java_env, jclass jcls) {
	FMOD_CREATESOUNDEXINFO *result_ = new FMOD_CREATESOUNDEXINFO();
	CheckAllocation(java_env, result_);
	result_->cbsize = sizeof(FMOD_CREATESOUNDEXINFO);
	POINTER_TYPE jresult/* = 0*/;
	N2J_CAST_PTR(jresult, FMOD_CREATESOUNDEXINFO *) = result_;
	return (jlong)jresult;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CREATESOUNDEXINFO_1delete(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	delete N2J_CAST_PTR(pointer, FMOD_CREATESOUNDEXINFO *);
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CREATESOUNDEXINFO_1get_1cbsize(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int result_ = N2J_CAST_PTR(pointer, FMOD_CREATESOUNDEXINFO *)->cbsize;
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CREATESOUNDEXINFO_1get_1length(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int result_ = N2J_CAST_PTR(pointer, FMOD_CREATESOUNDEXINFO *)->length;
	return (jint)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CREATESOUNDEXINFO_1set_1length(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jlength) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int length = (int)jlength;
	N2J_CAST_PTR(pointer, FMOD_CREATESOUNDEXINFO *)->length = length;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CREATESOUNDEXINFO_1get_1fileoffset(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int result_ = N2J_CAST_PTR(pointer, FMOD_CREATESOUNDEXINFO *)->fileoffset;
	return (jint)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CREATESOUNDEXINFO_1set_1fileoffset(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jfileoffset) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int fileoffset = (int)jfileoffset;
	N2J_CAST_PTR(pointer, FMOD_CREATESOUNDEXINFO *)->fileoffset = fileoffset;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CREATESOUNDEXINFO_1get_1numchannels(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int result_ = N2J_CAST_PTR(pointer, FMOD_CREATESOUNDEXINFO *)->numchannels;
	return (jint)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CREATESOUNDEXINFO_1set_1numchannels(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jnumchannels) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int numchannels = (int)jnumchannels;
	N2J_CAST_PTR(pointer, FMOD_CREATESOUNDEXINFO *)->numchannels = numchannels;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CREATESOUNDEXINFO_1get_1defaultfrequency(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int result_ = N2J_CAST_PTR(pointer, FMOD_CREATESOUNDEXINFO *)->defaultfrequency;
	return (jint)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CREATESOUNDEXINFO_1set_1defaultfrequency(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jdefaultfrequency) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int defaultfrequency = (int)jdefaultfrequency;
	N2J_CAST_PTR(pointer, FMOD_CREATESOUNDEXINFO *)->defaultfrequency = defaultfrequency;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CREATESOUNDEXINFO_1get_1format(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD_SOUND_FORMAT result_ = N2J_CAST_PTR(pointer, FMOD_CREATESOUNDEXINFO *)->format;
	return (jint)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CREATESOUNDEXINFO_1set_1format(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jformat) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int format = (int)jformat;
	N2J_CAST_PTR(pointer, FMOD_CREATESOUNDEXINFO *)->format = (FMOD_SOUND_FORMAT)format;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CREATESOUNDEXINFO_1get_1decodebuffersize(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int result_ = N2J_CAST_PTR(pointer, FMOD_CREATESOUNDEXINFO *)->decodebuffersize;
	return (jint)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CREATESOUNDEXINFO_1set_1decodebuffersize(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jdecodebuffersize) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int decodebuffersize = (int)jdecodebuffersize;
	N2J_CAST_PTR(pointer, FMOD_CREATESOUNDEXINFO *)->decodebuffersize = decodebuffersize;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CREATESOUNDEXINFO_1get_1initialsubsound(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int result_ = N2J_CAST_PTR(pointer, FMOD_CREATESOUNDEXINFO *)->initialsubsound;
	return (jint)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CREATESOUNDEXINFO_1set_1initialsubsound(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jinitialsubsound) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int initialsubsound = (int)jinitialsubsound;
	N2J_CAST_PTR(pointer, FMOD_CREATESOUNDEXINFO *)->initialsubsound = initialsubsound;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CREATESOUNDEXINFO_1get_1numsubsounds(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int result_ = N2J_CAST_PTR(pointer, FMOD_CREATESOUNDEXINFO *)->numsubsounds;
	return (jint)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CREATESOUNDEXINFO_1set_1numsubsounds(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jnumsubsounds) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int numsubsounds = (int)jnumsubsounds;
	N2J_CAST_PTR(pointer, FMOD_CREATESOUNDEXINFO *)->numsubsounds = numsubsounds;
}

JNIEXPORT jobject JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CREATESOUNDEXINFO_1get_1inclusionlist(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int *result_ = N2J_CAST_VAR(N2J_CAST_PTR(pointer, FMOD_CREATESOUNDEXINFO *)->inclusionlist, int *);
	jobject jresult = 0;
	if(result_) {
		jresult = java_env->NewDirectByteBuffer((int *)result_, N2J_CAST_PTR(pointer, FMOD_CREATESOUNDEXINFO *)->inclusionlistnum * sizeof(int));
	}
	return jresult;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CREATESOUNDEXINFO_1set_1inclusionlist(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jinclusionlist, jlong jinclusionlist_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int *inclusionlist = 0;
	if(jinclusionlist) {
		inclusionlist = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(java_env->NewGlobalRef(jinclusionlist)), char *)+jinclusionlist_, int *);
	}
	N2J_CAST_PTR(pointer, FMOD_CREATESOUNDEXINFO *)->inclusionlist = inclusionlist;
#if 1
	N2J_CAST_PTR(pointer, FMOD_CREATESOUNDEXINFO *)->inclusionlistnum = (jinclusionlist) ? N2J_CAST_VAR((java_env->GetDirectBufferCapacity(jinclusionlist) - jinclusionlist_) / sizeof(int), int) : 0;
#endif
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CREATESOUNDEXINFO_1get_1inclusionlistnum(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int result_ = N2J_CAST_PTR(pointer, FMOD_CREATESOUNDEXINFO *)->inclusionlistnum;
	return (jint)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CREATESOUNDEXINFO_1set_1pcmreadcallback(JNIEnv *java_env, jclass jcls, jlong jpointer, jboolean jpcmreadcallback) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	N2J_CAST_PTR(pointer, FMOD_CREATESOUNDEXINFO *)->pcmreadcallback = ((jpcmreadcallback == 0) ? NULL : FMOD_SOUND_PCMREADCALLBACK_BRIDGE);
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CREATESOUNDEXINFO_1set_1pcmsetposcallback(JNIEnv *java_env, jclass jcls, jlong jpointer, jboolean jpcmsetposcallback) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	N2J_CAST_PTR(pointer, FMOD_CREATESOUNDEXINFO *)->pcmsetposcallback = ((jpcmsetposcallback == 0) ? NULL : FMOD_SOUND_PCMSETPOSCALLBACK_BRIDGE);
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CREATESOUNDEXINFO_1set_1nonblockcallback(JNIEnv *java_env, jclass jcls, jlong jpointer, jboolean jnonblockcallback) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	N2J_CAST_PTR(pointer, FMOD_CREATESOUNDEXINFO *)->nonblockcallback = ((jnonblockcallback == 0) ? NULL : FMOD_SOUND_NONBLOCKCALLBACK_BRIDGE);
}

JNIEXPORT jstring JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CREATESOUNDEXINFO_1get_1dlsname(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	const char *result_ = N2J_CAST_VAR(N2J_CAST_PTR(pointer, FMOD_CREATESOUNDEXINFO *)->dlsname, const char *);
	jstring jresult = 0;
	if(result_) {
		jresult = java_env->NewStringUTF((const char *)result_);
	}
	return jresult;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CREATESOUNDEXINFO_1set_1dlsname(JNIEnv *java_env, jclass jcls, jlong jpointer, jbyteArray jdlsname) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	const char *dlsname = 0;
	if(jdlsname) {
		dlsname = (const char *)getByteArrayElements(java_env, jdlsname);
		N2J_CAST_PTR(pointer, FMOD_CREATESOUNDEXINFO *)->dlsname = dlsname;
	}
	else {
		N2J_CAST_PTR(pointer, FMOD_CREATESOUNDEXINFO *)->dlsname = (const char *)0;
	}
}

JNIEXPORT jstring JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CREATESOUNDEXINFO_1get_1encryptionkey(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	const char *result_ = N2J_CAST_VAR(N2J_CAST_PTR(pointer, FMOD_CREATESOUNDEXINFO *)->encryptionkey, const char *);
	jstring jresult = 0;
	if(result_) {
		jresult = java_env->NewStringUTF((const char *)result_);
	}
	return jresult;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CREATESOUNDEXINFO_1set_1encryptionkey(JNIEnv *java_env, jclass jcls, jlong jpointer, jbyteArray jencryptionkey) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	const char *encryptionkey = 0;
	if(jencryptionkey) {
		encryptionkey = (const char *)getByteArrayElements(java_env, jencryptionkey);
		N2J_CAST_PTR(pointer, FMOD_CREATESOUNDEXINFO *)->encryptionkey = encryptionkey;
	}
	else {
		N2J_CAST_PTR(pointer, FMOD_CREATESOUNDEXINFO *)->encryptionkey = (const char *)0;
	}
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CREATESOUNDEXINFO_1get_1maxpolyphony(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int result_ = N2J_CAST_PTR(pointer, FMOD_CREATESOUNDEXINFO *)->maxpolyphony;
	return (jint)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CREATESOUNDEXINFO_1set_1maxpolyphony(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jmaxpolyphony) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int maxpolyphony = (int)jmaxpolyphony;
	N2J_CAST_PTR(pointer, FMOD_CREATESOUNDEXINFO *)->maxpolyphony = maxpolyphony;
}

JNIEXPORT jlong JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CREATESOUNDEXINFO_1get_1userdata(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	POINTER_TYPE jresult/* = 0*/;
	N2J_CAST_PTR(jresult, void *) = N2J_CAST_PTR(pointer, FMOD_CREATESOUNDEXINFO *)->userdata;
	return (jlong)jresult;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CREATESOUNDEXINFO_1set_1userdata(JNIEnv *java_env, jclass jcls, jlong jpointer, jlong juserdata) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	POINTER_TYPE userdataTmp = (POINTER_TYPE)juserdata;
	N2J_CAST_PTR(pointer, FMOD_CREATESOUNDEXINFO *)->userdata = N2J_CAST_PTR(userdataTmp, void *);
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CREATESOUNDEXINFO_1get_1suggestedsoundtype(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD_SOUND_TYPE result_ = N2J_CAST_PTR(pointer, FMOD_CREATESOUNDEXINFO *)->suggestedsoundtype;
	return (jint)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CREATESOUNDEXINFO_1set_1suggestedsoundtype(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jsuggestedsoundtype) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int suggestedsoundtype = (int)jsuggestedsoundtype;
	N2J_CAST_PTR(pointer, FMOD_CREATESOUNDEXINFO *)->suggestedsoundtype = (FMOD_SOUND_TYPE)suggestedsoundtype;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CREATESOUNDEXINFO_1set_1useropen(JNIEnv *java_env, jclass jcls, jlong jpointer, jboolean juseropen) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	N2J_CAST_PTR(pointer, FMOD_CREATESOUNDEXINFO *)->useropen = ((juseropen == 0) ? NULL : FMOD_FILE_OPENCALLBACK_BRIDGE);
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CREATESOUNDEXINFO_1set_1userclose(JNIEnv *java_env, jclass jcls, jlong jpointer, jboolean juserclose) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	N2J_CAST_PTR(pointer, FMOD_CREATESOUNDEXINFO *)->userclose = ((juserclose == 0) ? NULL : FMOD_FILE_CLOSECALLBACK_BRIDGE);
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CREATESOUNDEXINFO_1set_1userread(JNIEnv *java_env, jclass jcls, jlong jpointer, jboolean juserread) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	N2J_CAST_PTR(pointer, FMOD_CREATESOUNDEXINFO *)->userread = ((juserread == 0) ? NULL : FMOD_FILE_READCALLBACK_BRIDGE);
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CREATESOUNDEXINFO_1set_1userseek(JNIEnv *java_env, jclass jcls, jlong jpointer, jboolean juserseek) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	N2J_CAST_PTR(pointer, FMOD_CREATESOUNDEXINFO *)->userseek = ((juserseek == 0) ? NULL : FMOD_FILE_SEEKCALLBACK_BRIDGE);
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CREATESOUNDEXINFO_1set_1userasyncread(JNIEnv *java_env, jclass jcls, jlong jpointer, jboolean juserasyncread) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	N2J_CAST_PTR(pointer, FMOD_CREATESOUNDEXINFO *)->userasyncread = ((juserasyncread == 0) ? NULL : FMOD_FILE_ASYNCREADCALLBACK_BRIDGE);
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CREATESOUNDEXINFO_1set_1userasynccancel(JNIEnv *java_env, jclass jcls, jlong jpointer, jboolean juserasynccancel) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	N2J_CAST_PTR(pointer, FMOD_CREATESOUNDEXINFO *)->userasynccancel = ((juserasynccancel == 0) ? NULL : FMOD_FILE_ASYNCCANCELCALLBACK_BRIDGE);
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CREATESOUNDEXINFO_1get_1speakermap(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD_SPEAKERMAPTYPE result_ = N2J_CAST_PTR(pointer, FMOD_CREATESOUNDEXINFO *)->speakermap;
	return (jint)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CREATESOUNDEXINFO_1set_1speakermap(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jspeakermap) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int speakermap = (int)jspeakermap;
	N2J_CAST_PTR(pointer, FMOD_CREATESOUNDEXINFO *)->speakermap = (FMOD_SPEAKERMAPTYPE)speakermap;
}

JNIEXPORT jlong JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CREATESOUNDEXINFO_1get_1initialsoundgroup(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	POINTER_TYPE jresult/* = 0*/;
	N2J_CAST_PTR(jresult, FMOD_SOUNDGROUP *) = N2J_CAST_PTR(pointer, FMOD_CREATESOUNDEXINFO *)->initialsoundgroup;
	return (jlong)jresult;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CREATESOUNDEXINFO_1set_1initialsoundgroup(JNIEnv *java_env, jclass jcls, jlong jpointer, jlong jinitialsoundgroup) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	POINTER_TYPE initialsoundgroupTmp = (POINTER_TYPE)jinitialsoundgroup;
	N2J_CAST_PTR(pointer, FMOD_CREATESOUNDEXINFO *)->initialsoundgroup = N2J_CAST_PTR(initialsoundgroupTmp, FMOD_SOUNDGROUP *);
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CREATESOUNDEXINFO_1get_1initialseekposition(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int result_ = N2J_CAST_PTR(pointer, FMOD_CREATESOUNDEXINFO *)->initialseekposition;
	return (jint)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CREATESOUNDEXINFO_1set_1initialseekposition(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jinitialseekposition) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int initialseekposition = (int)jinitialseekposition;
	N2J_CAST_PTR(pointer, FMOD_CREATESOUNDEXINFO *)->initialseekposition = initialseekposition;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CREATESOUNDEXINFO_1get_1initialseekpostype(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD_TIMEUNIT result_ = N2J_CAST_PTR(pointer, FMOD_CREATESOUNDEXINFO *)->initialseekpostype;
	return (jint)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CREATESOUNDEXINFO_1set_1initialseekpostype(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jinitialseekpostype) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int initialseekpostype = (int)jinitialseekpostype;
	N2J_CAST_PTR(pointer, FMOD_CREATESOUNDEXINFO *)->initialseekpostype = (FMOD_TIMEUNIT)initialseekpostype;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CREATESOUNDEXINFO_1get_1ignoresetfilesystem(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int result_ = N2J_CAST_PTR(pointer, FMOD_CREATESOUNDEXINFO *)->ignoresetfilesystem;
	return (jint)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CREATESOUNDEXINFO_1set_1ignoresetfilesystem(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jignoresetfilesystem) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int ignoresetfilesystem = (int)jignoresetfilesystem;
	N2J_CAST_PTR(pointer, FMOD_CREATESOUNDEXINFO *)->ignoresetfilesystem = ignoresetfilesystem;
}



