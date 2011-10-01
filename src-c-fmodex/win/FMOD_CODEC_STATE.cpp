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

JNIEXPORT jlong JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CODEC_1STATE_1new(JNIEnv *java_env, jclass jcls) {
	FMOD_CODEC_STATE *result_ = new FMOD_CODEC_STATE();
	CheckAllocation(java_env, result_);
	POINTER_TYPE jresult/* = 0*/;
	N2J_CAST_PTR(jresult, FMOD_CODEC_STATE *) = result_;
	return (jlong)jresult;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CODEC_1STATE_1delete(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	delete N2J_CAST_PTR(pointer, FMOD_CODEC_STATE *);
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CODEC_1STATE_1get_1numsubsounds(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int result_ = N2J_CAST_PTR(pointer, FMOD_CODEC_STATE *)->numsubsounds;
	return (jint)result_;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CODEC_1STATE_1set_1numsubsounds(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jnumsubsounds) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int numsubsounds = (int)jnumsubsounds;
	N2J_CAST_PTR(pointer, FMOD_CODEC_STATE *)->numsubsounds = numsubsounds;
}

JNIEXPORT jlong JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CODEC_1STATE_1get_1waveformat(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	POINTER_TYPE jresult/* = 0*/;
	N2J_CAST_PTR(jresult, FMOD_CODEC_WAVEFORMAT *) = N2J_CAST_PTR(pointer, FMOD_CODEC_STATE *)->waveformat;
	return (jlong)jresult;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CODEC_1STATE_1set_1waveformat(JNIEnv *java_env, jclass jcls, jlong jpointer, jlong jwaveformat) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	POINTER_TYPE waveformatTmp = (POINTER_TYPE)jwaveformat;
	N2J_CAST_PTR(pointer, FMOD_CODEC_STATE *)->waveformat = N2J_CAST_PTR(waveformatTmp, FMOD_CODEC_WAVEFORMAT *);
}

JNIEXPORT jlong JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CODEC_1STATE_1get_1plugindata(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	POINTER_TYPE jresult/* = 0*/;
	N2J_CAST_PTR(jresult, void *) = N2J_CAST_PTR(pointer, FMOD_CODEC_STATE *)->plugindata;
	return (jlong)jresult;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CODEC_1STATE_1set_1plugindata(JNIEnv *java_env, jclass jcls, jlong jpointer, jlong jplugindata) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	POINTER_TYPE plugindataTmp = (POINTER_TYPE)jplugindata;
	N2J_CAST_PTR(pointer, FMOD_CODEC_STATE *)->plugindata = N2J_CAST_PTR(plugindataTmp, void *);
}

JNIEXPORT jlong JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CODEC_1STATE_1get_1filehandle(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	POINTER_TYPE jresult/* = 0*/;
	N2J_CAST_PTR(jresult, void *) = N2J_CAST_PTR(pointer, FMOD_CODEC_STATE *)->filehandle;
	return (jlong)jresult;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CODEC_1STATE_1get_1filesize(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int result_ = N2J_CAST_PTR(pointer, FMOD_CODEC_STATE *)->filesize;
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CODEC_1STATE_1invoke_1fileread(JNIEnv *java_env, jclass jcls, jlong jpointer, jlong jhandle, jobject jbuffer, jlong jbuffer_, jint jsizebytes, jobject jbytesread, jlong jbytesread_, jlong juserdata) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	POINTER_TYPE handleTmp = (POINTER_TYPE)jhandle;
	void *handle = N2J_CAST_PTR(handleTmp, void *);
	void *buffer = 0;
	if(jbuffer) {
		buffer = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jbuffer), char *)+jbuffer_, void *);
	}
	int sizebytes = (int)jsizebytes;
	unsigned int *bytesread = 0;
	if(jbytesread) {
		bytesread = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jbytesread), char *)+jbytesread_, unsigned int *);
	}
	POINTER_TYPE userdataTmp = (POINTER_TYPE)juserdata;
	void *userdata = N2J_CAST_PTR(userdataTmp, void *);

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD_CODEC_STATE *)->fileread(handle, buffer, sizebytes, bytesread, userdata);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CODEC_1STATE_1invoke_1fileseek(JNIEnv *java_env, jclass jcls, jlong jpointer, jlong jhandle, jint jpos, jlong juserdata) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	POINTER_TYPE handleTmp = (POINTER_TYPE)jhandle;
	void *handle = N2J_CAST_PTR(handleTmp, void *);
	int pos = (int)jpos;
	POINTER_TYPE userdataTmp = (POINTER_TYPE)juserdata;
	void *userdata = N2J_CAST_PTR(userdataTmp, void *);

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD_CODEC_STATE *)->fileseek(handle, pos, userdata);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_structures_StructureJNI_FMOD_1CODEC_1STATE_1invoke_1metadata(JNIEnv *java_env, jclass jcls, jlong jpointer, jlong jcodec_state, jint jtagtype, jbyteArray jname, jlong jdata, jint jdatalen, jint jdatatype, jint junique) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD_CODEC_STATE *codec_state = 0;
	if(jcodec_state) {
		POINTER_TYPE codec_stateTmp = (POINTER_TYPE)jcodec_state;
		codec_state = N2J_CAST_PTR(codec_stateTmp, FMOD_CODEC_STATE *);
	}
	FMOD_TAGTYPE tagtype = (FMOD_TAGTYPE)jtagtype;
	char *name = (char *)getByteArrayElements(java_env, jname);
	POINTER_TYPE dataTmp = (POINTER_TYPE)jdata;
	void *data = N2J_CAST_PTR(dataTmp, void *);
	int datalen = (int)jdatalen;
	FMOD_TAGDATATYPE datatype = (FMOD_TAGDATATYPE)jdatatype;
	int unique = (int)junique;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD_CODEC_STATE *)->metadata(codec_state, tagtype, name, data, datalen, datatype, unique);

	releaseByteArrayElements(java_env, jname, (const char *)name);
	return (jint)result_;
}



