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
#include "malloc.h"
#include "CallbackManager.h"

jclass byteBufferClass = 0;
jclass getByteBufferClass(JNIEnv *java_env) {
	if(!byteBufferClass) {
		byteBufferClass = (jclass)java_env->NewGlobalRef(java_env->FindClass("java/nio/ByteBuffer"));
	}
	return byteBufferClass;
}

jclass caller = 0;
jboolean connectCaller(JNIEnv *java_env) {
	caller = (jclass)java_env->NewGlobalRef(java_env->FindClass("org/jouvieje/fmodex/callbacks/CallbackBridge"));
	if(java_env->ExceptionCheck()) {
		java_env->ExceptionDescribe();
		java_env->ExceptionClear();
		caller = 0;
	}
	return (jboolean)(caller != 0);
}

jmethodID callbackId[32];
jboolean connectCallbacks(JNIEnv *java_env) {
	static struct {
		const char *name;
		const char *signature;
	}callbacks[32] = {
		{"FMOD_3D_ROLLOFFCALLBACK_BRIDGE", "(JF)F"},
		{"FMOD_CHANNEL_CALLBACK_BRIDGE", "(JIJJ)I"},
		{"FMOD_CODEC_CLOSECALLBACK_BRIDGE", "(J)I"},
		{"FMOD_CODEC_GETLENGTHCALLBACK_BRIDGE", "(JLjava/nio/ByteBuffer;I)I"},
		{"FMOD_CODEC_GETPOSITIONCALLBACK_BRIDGE", "(JLjava/nio/ByteBuffer;I)I"},
		{"FMOD_CODEC_GETWAVEFORMAT_BRIDGE", "(JIJ)I"},
		{"FMOD_CODEC_METADATACALLBACK_BRIDGE", "(JILjava/lang/String;JIII)I"},
		{"FMOD_CODEC_OPENCALLBACK_BRIDGE", "(JIJ)I"},
		{"FMOD_CODEC_READCALLBACK_BRIDGE", "(JLjava/nio/ByteBuffer;ILjava/nio/ByteBuffer;)I"},
		{"FMOD_CODEC_SETPOSITIONCALLBACK_BRIDGE", "(JIII)I"},
		{"FMOD_CODEC_SOUNDCREATECALLBACK_BRIDGE", "(JIJ)I"},
		{"FMOD_DSP_CREATECALLBACK_BRIDGE", "(J)I"},
		{"FMOD_DSP_DIALOGCALLBACK_BRIDGE", "(JJI)I"},
		{"FMOD_DSP_GETPARAMCALLBACK_BRIDGE", "(JILjava/nio/ByteBuffer;Ljava/nio/ByteBuffer;)I"},
		{"FMOD_DSP_READCALLBACK_BRIDGE", "(JLjava/nio/ByteBuffer;Ljava/nio/ByteBuffer;III)I"},
		{"FMOD_DSP_RELEASECALLBACK_BRIDGE", "(J)I"},
		{"FMOD_DSP_RESETCALLBACK_BRIDGE", "(J)I"},
		{"FMOD_DSP_SETPARAMCALLBACK_BRIDGE", "(JIF)I"},
		{"FMOD_DSP_SETPOSITIONCALLBACK_BRIDGE", "(JI)I"},
		{"FMOD_FILE_ASYNCCANCELCALLBACK_BRIDGE", "(JJ)I"},
		{"FMOD_FILE_ASYNCREADCALLBACK_BRIDGE", "(JJ)I"},
		{"FMOD_FILE_CLOSECALLBACK_BRIDGE", "(JJ)I"},
		{"FMOD_FILE_OPENCALLBACK_BRIDGE", "(Ljava/lang/String;ILjava/nio/ByteBuffer;Lorg/jouvieje/fmodex/utils/Pointer;Lorg/jouvieje/fmodex/utils/Pointer;)I"},
		{"FMOD_FILE_READCALLBACK_BRIDGE", "(JLjava/nio/ByteBuffer;ILjava/nio/ByteBuffer;J)I"},
		{"FMOD_FILE_SEEKCALLBACK_BRIDGE", "(JIJ)I"},
		{"FMOD_MEMORY_ALLOCCALLBACK_BRIDGE", "(II)Ljava/nio/ByteBuffer;"},
		{"FMOD_MEMORY_FREECALLBACK_BRIDGE", "(Ljava/nio/ByteBuffer;I)V"},
		{"FMOD_MEMORY_REALLOCCALLBACK_BRIDGE", "(Ljava/nio/ByteBuffer;II)Ljava/nio/ByteBuffer;"},
		{"FMOD_SOUND_NONBLOCKCALLBACK_BRIDGE", "(JI)I"},
		{"FMOD_SOUND_PCMREADCALLBACK_BRIDGE", "(JLjava/nio/ByteBuffer;I)I"},
		{"FMOD_SOUND_PCMSETPOSCALLBACK_BRIDGE", "(JIII)I"},
		{"FMOD_SYSTEM_CALLBACK_BRIDGE", "(JIJJ)I"}
	};

	for(int i = 0; i < 32; i++) {
		callbackId[i] = java_env->GetStaticMethodID(caller, callbacks[i].name, callbacks[i].signature);
		if(java_env->ExceptionCheck()) {
			java_env->ExceptionDescribe();
			java_env->ExceptionClear();
			return (jboolean)false;
		}
	}
	return (jboolean)true;
}

JavaVM *jvm;
jboolean attachJavaVM(JNIEnv *java_env) {
	java_env->GetJavaVM(&jvm);
	if(!connectCaller(java_env)) {
		return (jboolean)false;
	}
	return connectCallbacks(java_env);
}
bool acquire_jenv(JNIEnv **java_env) {
	if(jvm->GetEnv((void **)java_env, JNI_VERSION_1_4) != JNI_OK) {
		jvm->AttachCurrentThread((void **)java_env, 0);
		return true;
	}
	return false;
}
void leave_jenv(bool attached) {
	if(attached) {
		jvm->DetachCurrentThread();
	}
}

float F_CALLBACK FMOD_3D_ROLLOFFCALLBACK_BRIDGE(FMOD_CHANNEL * channel, float distance) {
	JNIEnv *java_env/* = 0*/;
	bool attached = acquire_jenv(&java_env);
	POINTER_TYPE jchannel/* = 0*/;
	N2J_CAST_PTR(jchannel, FMOD_CHANNEL *) = (FMOD_CHANNEL *)channel;
	jfloat result_ = java_env->CallStaticFloatMethod(caller, callbackId[0], (jlong)jchannel, (jfloat)distance);
	leave_jenv(attached);
	return (float)result_;
}

FMOD_RESULT F_CALLBACK FMOD_CHANNEL_CALLBACK_BRIDGE(FMOD_CHANNEL * channel, FMOD_CHANNEL_CALLBACKTYPE type, void * commanddata1, void * commanddata2) {
	JNIEnv *java_env/* = 0*/;
	bool attached = acquire_jenv(&java_env);
	POINTER_TYPE jchannel/* = 0*/;
	N2J_CAST_PTR(jchannel, FMOD_CHANNEL *) = (FMOD_CHANNEL *)channel;
	POINTER_TYPE jcommanddata1/* = 0*/;
	N2J_CAST_PTR(jcommanddata1, void *) = commanddata1;
	POINTER_TYPE jcommanddata2/* = 0*/;
	N2J_CAST_PTR(jcommanddata2, void *) = commanddata2;
	jint result_ = java_env->CallStaticIntMethod(caller, callbackId[1], (jlong)jchannel, (jint)type, (jlong)jcommanddata1, (jlong)jcommanddata2);
	leave_jenv(attached);
	return (FMOD_RESULT)result_;
}

FMOD_RESULT F_CALLBACK FMOD_CODEC_CLOSECALLBACK_BRIDGE(FMOD_CODEC_STATE * codec_state) {
	JNIEnv *java_env/* = 0*/;
	bool attached = acquire_jenv(&java_env);
	POINTER_TYPE jcodec_state/* = 0*/;
	N2J_CAST_PTR(jcodec_state, FMOD_CODEC_STATE *) = (FMOD_CODEC_STATE *)codec_state;
	jint result_ = java_env->CallStaticIntMethod(caller, callbackId[2], (jlong)jcodec_state);
	leave_jenv(attached);
	return (FMOD_RESULT)result_;
}

FMOD_RESULT F_CALLBACK FMOD_CODEC_GETLENGTHCALLBACK_BRIDGE(FMOD_CODEC_STATE * codec_state, unsigned int * length, FMOD_TIMEUNIT lengthtype) {
	JNIEnv *java_env/* = 0*/;
	bool attached = acquire_jenv(&java_env);
	POINTER_TYPE jcodec_state/* = 0*/;
	N2J_CAST_PTR(jcodec_state, FMOD_CODEC_STATE *) = (FMOD_CODEC_STATE *)codec_state;
	jobject jlength = 0;
	if(length) {
		jlength = java_env->NewDirectByteBuffer((int *)length, 4);
	}
	jint result_ = java_env->CallStaticIntMethod(caller, callbackId[3], (jlong)jcodec_state, jlength, (jint)lengthtype);
	leave_jenv(attached);
	return (FMOD_RESULT)result_;
}

FMOD_RESULT F_CALLBACK FMOD_CODEC_GETPOSITIONCALLBACK_BRIDGE(FMOD_CODEC_STATE * codec_state, unsigned int * position, FMOD_TIMEUNIT postype) {
	JNIEnv *java_env/* = 0*/;
	bool attached = acquire_jenv(&java_env);
	POINTER_TYPE jcodec_state/* = 0*/;
	N2J_CAST_PTR(jcodec_state, FMOD_CODEC_STATE *) = (FMOD_CODEC_STATE *)codec_state;
	jobject jposition = 0;
	if(position) {
		jposition = java_env->NewDirectByteBuffer((int *)position, 4);
	}
	jint result_ = java_env->CallStaticIntMethod(caller, callbackId[4], (jlong)jcodec_state, jposition, (jint)postype);
	leave_jenv(attached);
	return (FMOD_RESULT)result_;
}

FMOD_RESULT F_CALLBACK FMOD_CODEC_GETWAVEFORMAT_BRIDGE(FMOD_CODEC_STATE * codec_state, int index, FMOD_CODEC_WAVEFORMAT * waveformat) {
	JNIEnv *java_env/* = 0*/;
	bool attached = acquire_jenv(&java_env);
	POINTER_TYPE jcodec_state/* = 0*/;
	N2J_CAST_PTR(jcodec_state, FMOD_CODEC_STATE *) = (FMOD_CODEC_STATE *)codec_state;
	POINTER_TYPE jwaveformat/* = 0*/;
	N2J_CAST_PTR(jwaveformat, FMOD_CODEC_WAVEFORMAT *) = (FMOD_CODEC_WAVEFORMAT *)waveformat;
	jint result_ = java_env->CallStaticIntMethod(caller, callbackId[5], (jlong)jcodec_state, (jint)index, (jlong)jwaveformat);
	leave_jenv(attached);
	return (FMOD_RESULT)result_;
}

FMOD_RESULT F_CALLBACK FMOD_CODEC_METADATACALLBACK_BRIDGE(FMOD_CODEC_STATE * codec_state, FMOD_TAGTYPE tagtype, char * name, void * data, unsigned int datalen, FMOD_TAGDATATYPE datatype, int unique) {
	JNIEnv *java_env/* = 0*/;
	bool attached = acquire_jenv(&java_env);
	POINTER_TYPE jcodec_state/* = 0*/;
	N2J_CAST_PTR(jcodec_state, FMOD_CODEC_STATE *) = (FMOD_CODEC_STATE *)codec_state;
	jstring jname = 0;
	if(name) {
		jname = java_env->NewStringUTF((const char *)name);
	}
	POINTER_TYPE jdata/* = 0*/;
	N2J_CAST_PTR(jdata, void *) = data;
	jint result_ = java_env->CallStaticIntMethod(caller, callbackId[6], (jlong)jcodec_state, (jint)tagtype, jname, (jlong)jdata, (jint)datalen, (jint)datatype, (jint)unique);
	leave_jenv(attached);
	return (FMOD_RESULT)result_;
}

FMOD_RESULT F_CALLBACK FMOD_CODEC_OPENCALLBACK_BRIDGE(FMOD_CODEC_STATE * codec_state, FMOD_MODE usermode, FMOD_CREATESOUNDEXINFO * userexinfo) {
	JNIEnv *java_env/* = 0*/;
	bool attached = acquire_jenv(&java_env);
	POINTER_TYPE jcodec_state/* = 0*/;
	N2J_CAST_PTR(jcodec_state, FMOD_CODEC_STATE *) = (FMOD_CODEC_STATE *)codec_state;
	POINTER_TYPE juserexinfo/* = 0*/;
	N2J_CAST_PTR(juserexinfo, FMOD_CREATESOUNDEXINFO *) = (FMOD_CREATESOUNDEXINFO *)userexinfo;
	jint result_ = java_env->CallStaticIntMethod(caller, callbackId[7], (jlong)jcodec_state, (jint)usermode, (jlong)juserexinfo);
	leave_jenv(attached);
	return (FMOD_RESULT)result_;
}

FMOD_RESULT F_CALLBACK FMOD_CODEC_READCALLBACK_BRIDGE(FMOD_CODEC_STATE * codec_state, void * buffer, unsigned int sizebytes, unsigned int * bytesread) {
	JNIEnv *java_env/* = 0*/;
	bool attached = acquire_jenv(&java_env);
	POINTER_TYPE jcodec_state/* = 0*/;
	N2J_CAST_PTR(jcodec_state, FMOD_CODEC_STATE *) = (FMOD_CODEC_STATE *)codec_state;
	jobject jbuffer = 0;
	if(buffer) {
		jbuffer = java_env->NewDirectByteBuffer((void *)buffer, sizebytes);
	}
	jobject jbytesread = 0;
	if(bytesread) {
		jbytesread = java_env->NewDirectByteBuffer((int *)bytesread, 4);
	}
	jint result_ = java_env->CallStaticIntMethod(caller, callbackId[8], (jlong)jcodec_state, jbuffer, (jint)sizebytes, jbytesread);
	leave_jenv(attached);
	return (FMOD_RESULT)result_;
}

FMOD_RESULT F_CALLBACK FMOD_CODEC_SETPOSITIONCALLBACK_BRIDGE(FMOD_CODEC_STATE * codec_state, int subsound, unsigned int position, FMOD_TIMEUNIT postype) {
	JNIEnv *java_env/* = 0*/;
	bool attached = acquire_jenv(&java_env);
	POINTER_TYPE jcodec_state/* = 0*/;
	N2J_CAST_PTR(jcodec_state, FMOD_CODEC_STATE *) = (FMOD_CODEC_STATE *)codec_state;
	jint result_ = java_env->CallStaticIntMethod(caller, callbackId[9], (jlong)jcodec_state, (jint)subsound, (jint)position, (jint)postype);
	leave_jenv(attached);
	return (FMOD_RESULT)result_;
}

FMOD_RESULT F_CALLBACK FMOD_CODEC_SOUNDCREATECALLBACK_BRIDGE(FMOD_CODEC_STATE * codec_state, int subsound, FMOD_SOUND * sound) {
	JNIEnv *java_env/* = 0*/;
	bool attached = acquire_jenv(&java_env);
	POINTER_TYPE jcodec_state/* = 0*/;
	N2J_CAST_PTR(jcodec_state, FMOD_CODEC_STATE *) = (FMOD_CODEC_STATE *)codec_state;
	POINTER_TYPE jsound/* = 0*/;
	N2J_CAST_PTR(jsound, FMOD_SOUND *) = (FMOD_SOUND *)sound;
	jint result_ = java_env->CallStaticIntMethod(caller, callbackId[10], (jlong)jcodec_state, (jint)subsound, (jlong)jsound);
	leave_jenv(attached);
	return (FMOD_RESULT)result_;
}

FMOD_RESULT F_CALLBACK FMOD_DSP_CREATECALLBACK_BRIDGE(FMOD_DSP_STATE * dsp_state) {
	JNIEnv *java_env/* = 0*/;
	bool attached = acquire_jenv(&java_env);
	POINTER_TYPE jdsp_state/* = 0*/;
	N2J_CAST_PTR(jdsp_state, FMOD_DSP_STATE *) = (FMOD_DSP_STATE *)dsp_state;
	jint result_ = java_env->CallStaticIntMethod(caller, callbackId[11], (jlong)jdsp_state);
	leave_jenv(attached);
	return (FMOD_RESULT)result_;
}

FMOD_RESULT F_CALLBACK FMOD_DSP_DIALOGCALLBACK_BRIDGE(FMOD_DSP_STATE * dsp_state, void * hwnd, int show) {
	JNIEnv *java_env/* = 0*/;
	bool attached = acquire_jenv(&java_env);
	POINTER_TYPE jdsp_state/* = 0*/;
	N2J_CAST_PTR(jdsp_state, FMOD_DSP_STATE *) = (FMOD_DSP_STATE *)dsp_state;
	POINTER_TYPE jhwnd/* = 0*/;
	N2J_CAST_PTR(jhwnd, void *) = hwnd;
	jint result_ = java_env->CallStaticIntMethod(caller, callbackId[12], (jlong)jdsp_state, (jlong)jhwnd, (jint)show);
	leave_jenv(attached);
	return (FMOD_RESULT)result_;
}

FMOD_RESULT F_CALLBACK FMOD_DSP_GETPARAMCALLBACK_BRIDGE(FMOD_DSP_STATE * dsp_state, int index, float * value, char * valuestr) {
	JNIEnv *java_env/* = 0*/;
	bool attached = acquire_jenv(&java_env);
	POINTER_TYPE jdsp_state/* = 0*/;
	N2J_CAST_PTR(jdsp_state, FMOD_DSP_STATE *) = (FMOD_DSP_STATE *)dsp_state;
	jobject jvalue = 0;
	if(value) {
		jvalue = java_env->NewDirectByteBuffer((float *)value, 4);
	}
	jobject jvaluestr = 0;
	if(valuestr) {
		jvaluestr = java_env->NewDirectByteBuffer((char *)valuestr, 16);
	}
	jint result_ = java_env->CallStaticIntMethod(caller, callbackId[13], (jlong)jdsp_state, (jint)index, jvalue, jvaluestr);
	leave_jenv(attached);
	return (FMOD_RESULT)result_;
}

FMOD_RESULT F_CALLBACK FMOD_DSP_READCALLBACK_BRIDGE(FMOD_DSP_STATE * dsp_state, float * inbuffer, float * outbuffer, unsigned int length, int inchannels, int outchannels) {
	JNIEnv *java_env/* = 0*/;
	bool attached = acquire_jenv(&java_env);
	POINTER_TYPE jdsp_state/* = 0*/;
	N2J_CAST_PTR(jdsp_state, FMOD_DSP_STATE *) = (FMOD_DSP_STATE *)dsp_state;
	jobject jinbuffer = 0;
	if(inbuffer) {
		jinbuffer = java_env->NewDirectByteBuffer((float *)inbuffer, length*inchannels*4);
	}
	jobject joutbuffer = 0;
	if(outbuffer) {
		joutbuffer = java_env->NewDirectByteBuffer((float *)outbuffer, length*outchannels*4);
	}
	jint result_ = java_env->CallStaticIntMethod(caller, callbackId[14], (jlong)jdsp_state, jinbuffer, joutbuffer, (jint)length, (jint)inchannels, (jint)outchannels);
	leave_jenv(attached);
	return (FMOD_RESULT)result_;
}

FMOD_RESULT F_CALLBACK FMOD_DSP_RELEASECALLBACK_BRIDGE(FMOD_DSP_STATE * dsp_state) {
	JNIEnv *java_env/* = 0*/;
	bool attached = acquire_jenv(&java_env);
	POINTER_TYPE jdsp_state/* = 0*/;
	N2J_CAST_PTR(jdsp_state, FMOD_DSP_STATE *) = (FMOD_DSP_STATE *)dsp_state;
	jint result_ = java_env->CallStaticIntMethod(caller, callbackId[15], (jlong)jdsp_state);
	leave_jenv(attached);
	return (FMOD_RESULT)result_;
}

FMOD_RESULT F_CALLBACK FMOD_DSP_RESETCALLBACK_BRIDGE(FMOD_DSP_STATE * dsp_state) {
	JNIEnv *java_env/* = 0*/;
	bool attached = acquire_jenv(&java_env);
	POINTER_TYPE jdsp_state/* = 0*/;
	N2J_CAST_PTR(jdsp_state, FMOD_DSP_STATE *) = (FMOD_DSP_STATE *)dsp_state;
	jint result_ = java_env->CallStaticIntMethod(caller, callbackId[16], (jlong)jdsp_state);
	leave_jenv(attached);
	return (FMOD_RESULT)result_;
}

FMOD_RESULT F_CALLBACK FMOD_DSP_SETPARAMCALLBACK_BRIDGE(FMOD_DSP_STATE * dsp_state, int index, float value) {
	JNIEnv *java_env/* = 0*/;
	bool attached = acquire_jenv(&java_env);
	POINTER_TYPE jdsp_state/* = 0*/;
	N2J_CAST_PTR(jdsp_state, FMOD_DSP_STATE *) = (FMOD_DSP_STATE *)dsp_state;
	jint result_ = java_env->CallStaticIntMethod(caller, callbackId[17], (jlong)jdsp_state, (jint)index, (jfloat)value);
	leave_jenv(attached);
	return (FMOD_RESULT)result_;
}

FMOD_RESULT F_CALLBACK FMOD_DSP_SETPOSITIONCALLBACK_BRIDGE(FMOD_DSP_STATE * dsp_state, unsigned int pos) {
	JNIEnv *java_env/* = 0*/;
	bool attached = acquire_jenv(&java_env);
	POINTER_TYPE jdsp_state/* = 0*/;
	N2J_CAST_PTR(jdsp_state, FMOD_DSP_STATE *) = (FMOD_DSP_STATE *)dsp_state;
	jint result_ = java_env->CallStaticIntMethod(caller, callbackId[18], (jlong)jdsp_state, (jint)pos);
	leave_jenv(attached);
	return (FMOD_RESULT)result_;
}

FMOD_RESULT F_CALLBACK FMOD_FILE_ASYNCCANCELCALLBACK_BRIDGE(void * handle, void * userdata) {
	JNIEnv *java_env/* = 0*/;
	bool attached = acquire_jenv(&java_env);
	POINTER_TYPE jhandle/* = 0*/;
	N2J_CAST_PTR(jhandle, void *) = handle;
	POINTER_TYPE juserdata/* = 0*/;
	N2J_CAST_PTR(juserdata, void *) = userdata;
	jint result_ = java_env->CallStaticIntMethod(caller, callbackId[19], (jlong)jhandle, (jlong)juserdata);
	leave_jenv(attached);
	return (FMOD_RESULT)result_;
}

FMOD_RESULT F_CALLBACK FMOD_FILE_ASYNCREADCALLBACK_BRIDGE(FMOD_ASYNCREADINFO * info, void * userdata) {
	JNIEnv *java_env/* = 0*/;
	bool attached = acquire_jenv(&java_env);
	POINTER_TYPE jinfo/* = 0*/;
	N2J_CAST_PTR(jinfo, FMOD_ASYNCREADINFO *) = (FMOD_ASYNCREADINFO *)info;
	POINTER_TYPE juserdata/* = 0*/;
	N2J_CAST_PTR(juserdata, void *) = userdata;
	jint result_ = java_env->CallStaticIntMethod(caller, callbackId[20], (jlong)jinfo, (jlong)juserdata);
	leave_jenv(attached);
	return (FMOD_RESULT)result_;
}

FMOD_RESULT F_CALLBACK FMOD_FILE_CLOSECALLBACK_BRIDGE(void * handle, void * userdata) {
	JNIEnv *java_env/* = 0*/;
	bool attached = acquire_jenv(&java_env);
	POINTER_TYPE jhandle/* = 0*/;
	N2J_CAST_PTR(jhandle, void *) = handle;
	POINTER_TYPE juserdata/* = 0*/;
	N2J_CAST_PTR(juserdata, void *) = userdata;
	jint result_ = java_env->CallStaticIntMethod(caller, callbackId[21], (jlong)jhandle, (jlong)juserdata);
	leave_jenv(attached);
	return (FMOD_RESULT)result_;
}

FMOD_RESULT F_CALLBACK FMOD_FILE_OPENCALLBACK_BRIDGE(const char * name, int unicode, unsigned int * filesize, void ** handle, void ** userdata) {
	JNIEnv *java_env/* = 0*/;
	bool attached = acquire_jenv(&java_env);
	jstring jname = 0;
	if(name) {
		jname = java_env->NewStringUTF((const char *)name);
	}
	jobject jfilesize = 0;
	if(filesize) {
		jfilesize = java_env->NewDirectByteBuffer((int *)filesize, 4);
	}
	jobject jhandle = newPointer(java_env);
	jobject juserdata = newPointer(java_env);
	jint result_ = java_env->CallStaticIntMethod(caller, callbackId[22], jname, (jint)unicode, jfilesize, jhandle, juserdata);
	if(jhandle) {
		POINTER_TYPE jhandleAddress = getPointerAddress(java_env, jhandle);
		if(jhandleAddress) {
			*handle = N2J_CAST_PTR(jhandleAddress, void *);
		}
	}
	if(juserdata) {
		POINTER_TYPE juserdataAddress = getPointerAddress(java_env, juserdata);
		if(juserdataAddress) {
			*userdata = N2J_CAST_PTR(juserdataAddress, void *);
		}
	}
	leave_jenv(attached);
	return (FMOD_RESULT)result_;
}

FMOD_RESULT F_CALLBACK FMOD_FILE_READCALLBACK_BRIDGE(void * handle, void * buffer, unsigned int sizebytes, unsigned int * bytesread, void * userdata) {
	JNIEnv *java_env/* = 0*/;
	bool attached = acquire_jenv(&java_env);
	POINTER_TYPE jhandle/* = 0*/;
	N2J_CAST_PTR(jhandle, void *) = handle;
	jobject jbuffer = 0;
	if(buffer) {
		jbuffer = java_env->NewDirectByteBuffer((void *)buffer, sizebytes);
	}
	jobject jbytesread = 0;
	if(bytesread) {
		jbytesread = java_env->NewDirectByteBuffer((int *)bytesread, 4);
	}
	POINTER_TYPE juserdata/* = 0*/;
	N2J_CAST_PTR(juserdata, void *) = userdata;
	jint result_ = java_env->CallStaticIntMethod(caller, callbackId[23], (jlong)jhandle, jbuffer, (jint)sizebytes, jbytesread, (jlong)juserdata);
	leave_jenv(attached);
	return (FMOD_RESULT)result_;
}

FMOD_RESULT F_CALLBACK FMOD_FILE_SEEKCALLBACK_BRIDGE(void * handle, unsigned int pos, void * userdata) {
	JNIEnv *java_env/* = 0*/;
	bool attached = acquire_jenv(&java_env);
	POINTER_TYPE jhandle/* = 0*/;
	N2J_CAST_PTR(jhandle, void *) = handle;
	POINTER_TYPE juserdata/* = 0*/;
	N2J_CAST_PTR(juserdata, void *) = userdata;
	jint result_ = java_env->CallStaticIntMethod(caller, callbackId[24], (jlong)jhandle, (jint)pos, (jlong)juserdata);
	leave_jenv(attached);
	return (FMOD_RESULT)result_;
}

void * F_CALLBACK FMOD_MEMORY_ALLOCCALLBACK_BRIDGE(unsigned int size, FMOD_MEMORY_TYPE type) {
	JNIEnv *java_env/* = 0*/;
	bool attached = acquire_jenv(&java_env);
	jobject result_ = java_env->CallStaticObjectMethod(caller, callbackId[25], (jint)size, (jint)type);
	if(result_) {
		jobject globalRef = java_env->NewGlobalRef(result_);
		if(globalRef) {
			return java_env->GetDirectBufferAddress(globalRef);
		}
		else {
			ThrowException(java_env, OutOfMemoryError, "");
		}
	}
	leave_jenv(attached);
	return 0;
}

void F_CALLBACK FMOD_MEMORY_FREECALLBACK_BRIDGE(void * ptr, FMOD_MEMORY_TYPE type) {
	JNIEnv *java_env/* = 0*/;
	bool attached = acquire_jenv(&java_env);
	jobject jptr = 0;
	if(ptr) {
		jptr = java_env->NewDirectByteBuffer((void *)ptr, malloc_usable_size(ptr));
	}
	java_env->CallStaticVoidMethod(caller, callbackId[26], jptr, (jint)type);
	leave_jenv(attached);
}

void * F_CALLBACK FMOD_MEMORY_REALLOCCALLBACK_BRIDGE(void * ptr, unsigned int size, FMOD_MEMORY_TYPE type) {
	JNIEnv *java_env/* = 0*/;
	bool attached = acquire_jenv(&java_env);
	jobject jptr = 0;
	if(ptr) {
		jptr = java_env->NewDirectByteBuffer((void *)ptr, malloc_usable_size(ptr));
	}
	jobject result_ = java_env->CallStaticObjectMethod(caller, callbackId[27], jptr, (jint)size, (jint)type);
	if(result_) {
		jobject globalRef = java_env->NewGlobalRef(result_);
		if(globalRef) {
			return java_env->GetDirectBufferAddress(globalRef);
		}
		else {
			ThrowException(java_env, OutOfMemoryError, "");
		}
	}
	leave_jenv(attached);
	return 0;
}

FMOD_RESULT F_CALLBACK FMOD_SOUND_NONBLOCKCALLBACK_BRIDGE(FMOD_SOUND * sound, FMOD_RESULT result) {
	JNIEnv *java_env/* = 0*/;
	bool attached = acquire_jenv(&java_env);
	POINTER_TYPE jsound/* = 0*/;
	N2J_CAST_PTR(jsound, FMOD_SOUND *) = (FMOD_SOUND *)sound;
	jint result_ = java_env->CallStaticIntMethod(caller, callbackId[28], (jlong)jsound, (jint)result);
	leave_jenv(attached);
	return (FMOD_RESULT)result_;
}

FMOD_RESULT F_CALLBACK FMOD_SOUND_PCMREADCALLBACK_BRIDGE(FMOD_SOUND * sound, void * data, unsigned int datalen) {
	JNIEnv *java_env/* = 0*/;
	bool attached = acquire_jenv(&java_env);
	POINTER_TYPE jsound/* = 0*/;
	N2J_CAST_PTR(jsound, FMOD_SOUND *) = (FMOD_SOUND *)sound;
	jobject jdata = 0;
	if(data) {
		jdata = java_env->NewDirectByteBuffer((void *)data, datalen);
	}
	jint result_ = java_env->CallStaticIntMethod(caller, callbackId[29], (jlong)jsound, jdata, (jint)datalen);
	leave_jenv(attached);
	return (FMOD_RESULT)result_;
}

FMOD_RESULT F_CALLBACK FMOD_SOUND_PCMSETPOSCALLBACK_BRIDGE(FMOD_SOUND * sound, int subsound, unsigned int position, FMOD_TIMEUNIT postype) {
	JNIEnv *java_env/* = 0*/;
	bool attached = acquire_jenv(&java_env);
	POINTER_TYPE jsound/* = 0*/;
	N2J_CAST_PTR(jsound, FMOD_SOUND *) = (FMOD_SOUND *)sound;
	jint result_ = java_env->CallStaticIntMethod(caller, callbackId[30], (jlong)jsound, (jint)subsound, (jint)position, (jint)postype);
	leave_jenv(attached);
	return (FMOD_RESULT)result_;
}

FMOD_RESULT F_CALLBACK FMOD_SYSTEM_CALLBACK_BRIDGE(FMOD_SYSTEM * system, FMOD_SYSTEM_CALLBACKTYPE type, void * commanddata1, void * commanddata2) {
	JNIEnv *java_env/* = 0*/;
	bool attached = acquire_jenv(&java_env);
	POINTER_TYPE jsystem/* = 0*/;
	N2J_CAST_PTR(jsystem, FMOD_SYSTEM *) = (FMOD_SYSTEM *)system;
	POINTER_TYPE jcommanddata1/* = 0*/;
	N2J_CAST_PTR(jcommanddata1, void *) = commanddata1;
	POINTER_TYPE jcommanddata2/* = 0*/;
	N2J_CAST_PTR(jcommanddata2, void *) = commanddata2;
	jint result_ = java_env->CallStaticIntMethod(caller, callbackId[31], (jlong)jsystem, (jint)type, (jlong)jcommanddata1, (jlong)jcommanddata2);
	leave_jenv(attached);
	return (FMOD_RESULT)result_;
}


