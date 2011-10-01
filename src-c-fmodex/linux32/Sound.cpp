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

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Sound_1release(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Sound *)->release();

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Sound_1getSystemObject(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jsystem) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD::System *system/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Sound *)->getSystemObject(&system);

	if(jsystem) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, FMOD::System *) = system;
		setPointerAddress(java_env, jsystem, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Sound_1lock(JNIEnv *java_env, jclass jcls, jlong jpointer, jint joffset, jint jlength, jobjectArray jptr1, jobjectArray jptr2, jobject jlen1, jlong jlen1_, jobject jlen2, jlong jlen2_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int offset = (int)joffset;
	int length = (int)jlength;
	void *ptr1/* = 0*/;
	void *ptr2/* = 0*/;
	unsigned int *len1 = 0;
	if(jlen1) {
		len1 = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jlen1), char *)+jlen1_, unsigned int *);
	}
	unsigned int *len2 = 0;
	if(jlen2) {
		len2 = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jlen2), char *)+jlen2_, unsigned int *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Sound *)->lock(offset, length, &ptr1, &ptr2, len1, len2);

	if(ptr1 && jptr1 && java_env->GetArrayLength(jptr1) >= 1) {
		java_env->SetObjectArrayElement(jptr1, 0, java_env->NewDirectByteBuffer((void *)ptr1, *len1));
	}
	if(ptr2 && jptr2 && java_env->GetArrayLength(jptr2) >= 1) {
		java_env->SetObjectArrayElement(jptr2, 0, java_env->NewDirectByteBuffer((void *)ptr2, *len2));
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Sound_1unlock(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jptr1, jlong jptr1_, jobject jptr2, jlong jptr2_, jint jlen1, jint jlen2) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	void *ptr1 = 0;
	if(jptr1) {
		ptr1 = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jptr1), char *)+jptr1_, void *);
	}
	void *ptr2 = 0;
	if(jptr2) {
		ptr2 = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jptr2), char *)+jptr2_, void *);
	}
	int len1 = (int)jlen1;
	int len2 = (int)jlen2;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Sound *)->unlock(ptr1, ptr2, len1, len2);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Sound_1setDefaults(JNIEnv *java_env, jclass jcls, jlong jpointer, jfloat jfrequency, jfloat jvolume, jfloat jpan, jint jpriority) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float frequency = (float)jfrequency;
	float volume = (float)jvolume;
	float pan = (float)jpan;
	int priority = (int)jpriority;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Sound *)->setDefaults(frequency, volume, pan, priority);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Sound_1getDefaults(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jfrequency, jlong jfrequency_, jobject jvolume, jlong jvolume_, jobject jpan, jlong jpan_, jobject jpriority, jlong jpriority_) {
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

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Sound *)->getDefaults(frequency, volume, pan, priority);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Sound_1setVariations(JNIEnv *java_env, jclass jcls, jlong jpointer, jfloat jfrequencyvar, jfloat jvolumevar, jfloat jpanvar) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float frequencyvar = (float)jfrequencyvar;
	float volumevar = (float)jvolumevar;
	float panvar = (float)jpanvar;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Sound *)->setVariations(frequencyvar, volumevar, panvar);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Sound_1getVariations(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jfrequencyvar, jlong jfrequencyvar_, jobject jvolumevar, jlong jvolumevar_, jobject jpanvar, jlong jpanvar_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float *frequencyvar = 0;
	if(jfrequencyvar) {
		frequencyvar = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jfrequencyvar), char *)+jfrequencyvar_, float *);
	}
	float *volumevar = 0;
	if(jvolumevar) {
		volumevar = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jvolumevar), char *)+jvolumevar_, float *);
	}
	float *panvar = 0;
	if(jpanvar) {
		panvar = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jpanvar), char *)+jpanvar_, float *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Sound *)->getVariations(frequencyvar, volumevar, panvar);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Sound_1set3DMinMaxDistance(JNIEnv *java_env, jclass jcls, jlong jpointer, jfloat jmin, jfloat jmax) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float min = (float)jmin;
	float max = (float)jmax;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Sound *)->set3DMinMaxDistance(min, max);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Sound_1get3DMinMaxDistance(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jmin, jlong jmin_, jobject jmax, jlong jmax_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float *min = 0;
	if(jmin) {
		min = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jmin), char *)+jmin_, float *);
	}
	float *max = 0;
	if(jmax) {
		max = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jmax), char *)+jmax_, float *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Sound *)->get3DMinMaxDistance(min, max);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Sound_1set3DConeSettings(JNIEnv *java_env, jclass jcls, jlong jpointer, jfloat jinsideconeangle, jfloat joutsideconeangle, jfloat joutsidevolume) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float insideconeangle = (float)jinsideconeangle;
	float outsideconeangle = (float)joutsideconeangle;
	float outsidevolume = (float)joutsidevolume;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Sound *)->set3DConeSettings(insideconeangle, outsideconeangle, outsidevolume);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Sound_1get3DConeSettings(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jinsideconeangle, jlong jinsideconeangle_, jobject joutsideconeangle, jlong joutsideconeangle_, jobject joutsidevolume, jlong joutsidevolume_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float *insideconeangle = 0;
	if(jinsideconeangle) {
		insideconeangle = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jinsideconeangle), char *)+jinsideconeangle_, float *);
	}
	float *outsideconeangle = 0;
	if(joutsideconeangle) {
		outsideconeangle = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(joutsideconeangle), char *)+joutsideconeangle_, float *);
	}
	float *outsidevolume = 0;
	if(joutsidevolume) {
		outsidevolume = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(joutsidevolume), char *)+joutsidevolume_, float *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Sound *)->get3DConeSettings(insideconeangle, outsideconeangle, outsidevolume);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Sound_1set3DCustomRolloff(JNIEnv *java_env, jclass jcls, jlong jpointer, jlong jpoints, jint jnumpoints) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD_VECTOR *points = 0;
	if(jpoints) {
		POINTER_TYPE pointsTmp = (POINTER_TYPE)jpoints;
		points = N2J_CAST_PTR(pointsTmp, FMOD_VECTOR *);
	}
	int numpoints = (int)jnumpoints;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Sound *)->set3DCustomRolloff(points, numpoints);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Sound_1get3DCustomRolloff(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jpoints, jobject jnumpoints, jlong jnumpoints_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD_VECTOR *points/* = 0*/;
	int *numpoints = 0;
	if(jnumpoints) {
		numpoints = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jnumpoints), char *)+jnumpoints_, int *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Sound *)->get3DCustomRolloff(&points, numpoints);

	if(jpoints) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, FMOD_VECTOR *) = points;
		setPointerAddress(java_env, jpoints, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Sound_1setSubSound(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jindex, jlong jsubsound) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int index = (int)jindex;
	FMOD::Sound *subsound = 0;
	if(jsubsound) {
		POINTER_TYPE subsoundTmp = (POINTER_TYPE)jsubsound;
		subsound = N2J_CAST_PTR(subsoundTmp, FMOD::Sound *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Sound *)->setSubSound(index, subsound);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Sound_1getSubSound(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jindex, jobject jsubsound) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int index = (int)jindex;
	FMOD::Sound *subsound/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Sound *)->getSubSound(index, &subsound);

	if(jsubsound) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, FMOD::Sound *) = subsound;
		setPointerAddress(java_env, jsubsound, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Sound_1setSubSoundSentence(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jsubsoundlist, jlong jsubsoundlist_, jint jnumsubsounds) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int *subsoundlist = 0;
	if(jsubsoundlist) {
		subsoundlist = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jsubsoundlist), char *)+jsubsoundlist_, int *);
	}
	int numsubsounds = (int)jnumsubsounds;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Sound *)->setSubSoundSentence(subsoundlist, numsubsounds);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Sound_1getName(JNIEnv *java_env, jclass jcls, jlong jpointer, 	jobject jname, jlong jname_, jint jnamelen) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	char *name = 0;
	if(jname) {
		name = N2J_CAST_VAR(java_env->GetDirectBufferAddress(jname), char *)+jname_;
	}
	int namelen = (int)jnamelen;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Sound *)->getName(name, namelen);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Sound_1getLength(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jlength, jlong jlength_, jint jlengthtype) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	unsigned int *length = 0;
	if(jlength) {
		length = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jlength), char *)+jlength_, unsigned int *);
	}
	FMOD_TIMEUNIT lengthtype = (FMOD_TIMEUNIT)jlengthtype;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Sound *)->getLength(length, lengthtype);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Sound_1getFormat(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jtypePointer, jobject jformatPointer, jobject jchannels, jlong jchannels_, jobject jbits, jlong jbits_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD_SOUND_TYPE type;
	FMOD_SOUND_FORMAT format;
	int *channels = 0;
	if(jchannels) {
		channels = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jchannels), char *)+jchannels_, int *);
	}
	int *bits = 0;
	if(jbits) {
		bits = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jbits), char *)+jbits_, int *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Sound *)->getFormat(&type, &format, channels, bits);

	if(jtypePointer) {
		int *typePointer = (int *)java_env->GetDirectBufferAddress(jtypePointer);
		typePointer[0] = type;
	}
	if(jformatPointer) {
		int *formatPointer = (int *)java_env->GetDirectBufferAddress(jformatPointer);
		formatPointer[0] = format;
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Sound_1getNumSubSounds(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jnumsubsounds, jlong jnumsubsounds_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int *numsubsounds = 0;
	if(jnumsubsounds) {
		numsubsounds = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jnumsubsounds), char *)+jnumsubsounds_, int *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Sound *)->getNumSubSounds(numsubsounds);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Sound_1getNumTags(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jnumtags, jlong jnumtags_, jobject jnumtagsupdated, jlong jnumtagsupdated_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int *numtags = 0;
	if(jnumtags) {
		numtags = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jnumtags), char *)+jnumtags_, int *);
	}
	int *numtagsupdated = 0;
	if(jnumtagsupdated) {
		numtagsupdated = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jnumtagsupdated), char *)+jnumtagsupdated_, int *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Sound *)->getNumTags(numtags, numtagsupdated);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Sound_1getTag(JNIEnv *java_env, jclass jcls, jlong jpointer, jbyteArray jname, jint jindex, jlong jtag) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	const char *name = (const char *)getByteArrayElements(java_env, jname);
	int index = (int)jindex;
	FMOD_TAG *tag = 0;
	if(jtag) {
		POINTER_TYPE tagTmp = (POINTER_TYPE)jtag;
		tag = N2J_CAST_PTR(tagTmp, FMOD_TAG *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Sound *)->getTag(name, index, tag);

	releaseByteArrayElements(java_env, jname, (const char *)name);
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Sound_1getOpenState(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jopenstatePointer, jobject jpercentbuffered, jlong jpercentbuffered_, jobject jstarving, jlong jstarving_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD_OPENSTATE openstate;
	unsigned int *percentbuffered = 0;
	if(jpercentbuffered) {
		percentbuffered = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jpercentbuffered), char *)+jpercentbuffered_, unsigned int *);
	}
	bool *starving = 0;
	if(jstarving) {
		starving = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jstarving), char *)+jstarving_, bool *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Sound *)->getOpenState(&openstate, percentbuffered, starving);

	if(jopenstatePointer) {
		int *openstatePointer = (int *)java_env->GetDirectBufferAddress(jopenstatePointer);
		openstatePointer[0] = openstate;
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Sound_1readData(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jbuffer, jlong jbuffer_, jint jlenbytes, jobject jread, jlong jread_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	void *buffer = 0;
	if(jbuffer) {
		buffer = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jbuffer), char *)+jbuffer_, void *);
	}
	int lenbytes = (int)jlenbytes;
	unsigned int *read = 0;
	if(jread) {
		read = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jread), char *)+jread_, unsigned int *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Sound *)->readData(buffer, lenbytes, read);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Sound_1seekData(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jpcm) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int pcm = (int)jpcm;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Sound *)->seekData(pcm);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Sound_1setSoundGroup(JNIEnv *java_env, jclass jcls, jlong jpointer, jlong jsoundgroup) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD::SoundGroup *soundgroup = 0;
	if(jsoundgroup) {
		POINTER_TYPE soundgroupTmp = (POINTER_TYPE)jsoundgroup;
		soundgroup = N2J_CAST_PTR(soundgroupTmp, FMOD::SoundGroup *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Sound *)->setSoundGroup(soundgroup);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Sound_1getSoundGroup(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jsoundgroup) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD::SoundGroup *soundgroup/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Sound *)->getSoundGroup(&soundgroup);

	if(jsoundgroup) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, FMOD::SoundGroup *) = soundgroup;
		setPointerAddress(java_env, jsoundgroup, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Sound_1getNumSyncPoints(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jnumsyncpoints, jlong jnumsyncpoints_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int *numsyncpoints = 0;
	if(jnumsyncpoints) {
		numsyncpoints = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jnumsyncpoints), char *)+jnumsyncpoints_, int *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Sound *)->getNumSyncPoints(numsyncpoints);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Sound_1getSyncPoint(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jindex, jobject jpoint) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int index = (int)jindex;
	FMOD_SYNCPOINT *point/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Sound *)->getSyncPoint(index, &point);

	if(jpoint) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, FMOD_SYNCPOINT *) = point;
		setPointerAddress(java_env, jpoint, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Sound_1getSyncPointInfo(JNIEnv *java_env, jclass jcls, jlong jpointer, jlong jpoint, 	jobject jname, jlong jname_, jint jnamelen, jobject joffset, jlong joffset_, jint joffsettype) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD_SYNCPOINT *point = 0;
	if(jpoint) {
		POINTER_TYPE pointTmp = (POINTER_TYPE)jpoint;
		point = N2J_CAST_PTR(pointTmp, FMOD_SYNCPOINT *);
	}
	char *name = 0;
	if(jname) {
		name = N2J_CAST_VAR(java_env->GetDirectBufferAddress(jname), char *)+jname_;
	}
	int namelen = (int)jnamelen;
	unsigned int *offset = 0;
	if(joffset) {
		offset = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(joffset), char *)+joffset_, unsigned int *);
	}
	FMOD_TIMEUNIT offsettype = (FMOD_TIMEUNIT)joffsettype;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Sound *)->getSyncPointInfo(point, name, namelen, offset, offsettype);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Sound_1addSyncPoint(JNIEnv *java_env, jclass jcls, jlong jpointer, jint joffset, jint joffsettype, jbyteArray jname, jobject jpoint) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int offset = (int)joffset;
	FMOD_TIMEUNIT offsettype = (FMOD_TIMEUNIT)joffsettype;
	const char *name = (const char *)getByteArrayElements(java_env, jname);
	FMOD_SYNCPOINT *point/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Sound *)->addSyncPoint(offset, offsettype, name, &point);

	releaseByteArrayElements(java_env, jname, (const char *)name);
	if(jpoint) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, FMOD_SYNCPOINT *) = point;
		setPointerAddress(java_env, jpoint, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Sound_1deleteSyncPoint(JNIEnv *java_env, jclass jcls, jlong jpointer, jlong jpoint) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD_SYNCPOINT *point = 0;
	if(jpoint) {
		POINTER_TYPE pointTmp = (POINTER_TYPE)jpoint;
		point = N2J_CAST_PTR(pointTmp, FMOD_SYNCPOINT *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Sound *)->deleteSyncPoint(point);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Sound_1setMode(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jmode) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD_MODE mode = (FMOD_MODE)jmode;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Sound *)->setMode(mode);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Sound_1getMode(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jmode, jlong jmode_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD_MODE *mode = 0;
	if(jmode) {
		mode = N2J_CAST_VAR(N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jmode), char *)+jmode_, int *), FMOD_MODE *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Sound *)->getMode(mode);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Sound_1setLoopCount(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jloopcount) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int loopcount = (int)jloopcount;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Sound *)->setLoopCount(loopcount);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Sound_1getLoopCount(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jloopcount, jlong jloopcount_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int *loopcount = 0;
	if(jloopcount) {
		loopcount = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jloopcount), char *)+jloopcount_, int *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Sound *)->getLoopCount(loopcount);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Sound_1setLoopPoints(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jloopstart, jint jloopstarttype, jint jloopend, jint jloopendtype) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int loopstart = (int)jloopstart;
	FMOD_TIMEUNIT loopstarttype = (FMOD_TIMEUNIT)jloopstarttype;
	int loopend = (int)jloopend;
	FMOD_TIMEUNIT loopendtype = (FMOD_TIMEUNIT)jloopendtype;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Sound *)->setLoopPoints(loopstart, loopstarttype, loopend, loopendtype);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Sound_1getLoopPoints(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jloopstart, jlong jloopstart_, jint jloopstarttype, jobject jloopend, jlong jloopend_, jint jloopendtype) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	unsigned int *loopstart = 0;
	if(jloopstart) {
		loopstart = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jloopstart), char *)+jloopstart_, unsigned int *);
	}
	FMOD_TIMEUNIT loopstarttype = (FMOD_TIMEUNIT)jloopstarttype;
	unsigned int *loopend = 0;
	if(jloopend) {
		loopend = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jloopend), char *)+jloopend_, unsigned int *);
	}
	FMOD_TIMEUNIT loopendtype = (FMOD_TIMEUNIT)jloopendtype;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Sound *)->getLoopPoints(loopstart, loopstarttype, loopend, loopendtype);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Sound_1getMusicNumChannels(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jnumchannels, jlong jnumchannels_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int *numchannels = 0;
	if(jnumchannels) {
		numchannels = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jnumchannels), char *)+jnumchannels_, int *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Sound *)->getMusicNumChannels(numchannels);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Sound_1setMusicChannelVolume(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jchannel, jfloat jvolume) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int channel = (int)jchannel;
	float volume = (float)jvolume;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Sound *)->setMusicChannelVolume(channel, volume);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Sound_1getMusicChannelVolume(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jchannel, jobject jvolume, jlong jvolume_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int channel = (int)jchannel;
	float *volume = 0;
	if(jvolume) {
		volume = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jvolume), char *)+jvolume_, float *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Sound *)->getMusicChannelVolume(channel, volume);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Sound_1setUserData(JNIEnv *java_env, jclass jcls, jlong jpointer, jlong juserdata) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	POINTER_TYPE userdataTmp = (POINTER_TYPE)juserdata;
	void *userdata = N2J_CAST_PTR(userdataTmp, void *);

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Sound *)->setUserData(userdata);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Sound_1getUserData(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject juserdata) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	void *userdata/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Sound *)->getUserData(&userdata);

	if(juserdata) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, void *) = userdata;
		setPointerAddress(java_env, juserdata, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Sound_1getMemoryInfo(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jmemorybits, jint jevent_memorybits, jobject jmemoryused, jlong jmemoryused_, jlong jmemoryused_details) {
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

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Sound *)->getMemoryInfo(memorybits, event_memorybits, memoryused, memoryused_details);

	return (jint)result_;
}


