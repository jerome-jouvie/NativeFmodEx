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

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Geometry_1release(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Geometry *)->release();

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Geometry_1addPolygon(JNIEnv *java_env, jclass jcls, jlong jpointer, jfloat jdirectocclusion, jfloat jreverbocclusion, jboolean jdoublesided, jint jnumvertices, jlong jvertices, jint verticesLen_, jobject jpolygonindex, jlong jpolygonindex_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	float directocclusion = (float)jdirectocclusion;
	float reverbocclusion = (float)jreverbocclusion;
	bool doublesided = N2J_CAST_VAR(jdoublesided != 0, bool);
	int numvertices = (int)jnumvertices;
	POINTER_TYPE verticesTmp = (POINTER_TYPE)jvertices;
	FMOD_VECTOR *vertices = N2J_CAST_PTR(verticesTmp, FMOD_VECTOR *);
	int *polygonindex = 0;
	if(jpolygonindex) {
		polygonindex = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jpolygonindex), char *)+jpolygonindex_, int *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Geometry *)->addPolygon(directocclusion, reverbocclusion, doublesided, numvertices, vertices, polygonindex);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Geometry_1getNumPolygons(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jnumpolygons, jlong jnumpolygons_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int *numpolygons = 0;
	if(jnumpolygons) {
		numpolygons = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jnumpolygons), char *)+jnumpolygons_, int *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Geometry *)->getNumPolygons(numpolygons);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Geometry_1getMaxPolygons(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jmaxpolygons, jlong jmaxpolygons_, jobject jmaxvertices, jlong jmaxvertices_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int *maxpolygons = 0;
	if(jmaxpolygons) {
		maxpolygons = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jmaxpolygons), char *)+jmaxpolygons_, int *);
	}
	int *maxvertices = 0;
	if(jmaxvertices) {
		maxvertices = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jmaxvertices), char *)+jmaxvertices_, int *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Geometry *)->getMaxPolygons(maxpolygons, maxvertices);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Geometry_1getPolygonNumVertices(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jindex, jobject jnumvertices, jlong jnumvertices_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int index = (int)jindex;
	int *numvertices = 0;
	if(jnumvertices) {
		numvertices = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jnumvertices), char *)+jnumvertices_, int *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Geometry *)->getPolygonNumVertices(index, numvertices);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Geometry_1setPolygonVertex(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jindex, jint jvertexindex, jlong jvertex) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int index = (int)jindex;
	int vertexindex = (int)jvertexindex;
	FMOD_VECTOR *vertex = 0;
	if(jvertex) {
		POINTER_TYPE vertexTmp = (POINTER_TYPE)jvertex;
		vertex = N2J_CAST_PTR(vertexTmp, FMOD_VECTOR *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Geometry *)->setPolygonVertex(index, vertexindex, vertex);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Geometry_1getPolygonVertex(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jindex, jint jvertexindex, jlong jvertex) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int index = (int)jindex;
	int vertexindex = (int)jvertexindex;
	FMOD_VECTOR *vertex = 0;
	if(jvertex) {
		POINTER_TYPE vertexTmp = (POINTER_TYPE)jvertex;
		vertex = N2J_CAST_PTR(vertexTmp, FMOD_VECTOR *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Geometry *)->getPolygonVertex(index, vertexindex, vertex);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Geometry_1setPolygonAttributes(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jindex, jfloat jdirectocclusion, jfloat jreverbocclusion, jboolean jdoublesided) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int index = (int)jindex;
	float directocclusion = (float)jdirectocclusion;
	float reverbocclusion = (float)jreverbocclusion;
	bool doublesided = N2J_CAST_VAR(jdoublesided != 0, bool);

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Geometry *)->setPolygonAttributes(index, directocclusion, reverbocclusion, doublesided);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Geometry_1getPolygonAttributes(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jindex, jobject jdirectocclusion, jlong jdirectocclusion_, jobject jreverbocclusion, jlong jreverbocclusion_, jobject jdoublesided, jlong jdoublesided_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int index = (int)jindex;
	float *directocclusion = 0;
	if(jdirectocclusion) {
		directocclusion = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jdirectocclusion), char *)+jdirectocclusion_, float *);
	}
	float *reverbocclusion = 0;
	if(jreverbocclusion) {
		reverbocclusion = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jreverbocclusion), char *)+jreverbocclusion_, float *);
	}
	bool *doublesided = 0;
	if(jdoublesided) {
		doublesided = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jdoublesided), char *)+jdoublesided_, bool *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Geometry *)->getPolygonAttributes(index, directocclusion, reverbocclusion, doublesided);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Geometry_1setActive(JNIEnv *java_env, jclass jcls, jlong jpointer, jboolean jactive) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	bool active = N2J_CAST_VAR(jactive != 0, bool);

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Geometry *)->setActive(active);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Geometry_1getActive(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jactive, jlong jactive_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	bool *active = 0;
	if(jactive) {
		active = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jactive), char *)+jactive_, bool *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Geometry *)->getActive(active);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Geometry_1setRotation(JNIEnv *java_env, jclass jcls, jlong jpointer, jlong jforward, jlong jup) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
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

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Geometry *)->setRotation(forward, up);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Geometry_1getRotation(JNIEnv *java_env, jclass jcls, jlong jpointer, jlong jforward, jlong jup) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
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

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Geometry *)->getRotation(forward, up);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Geometry_1setPosition(JNIEnv *java_env, jclass jcls, jlong jpointer, jlong jposition) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD_VECTOR *position = 0;
	if(jposition) {
		POINTER_TYPE positionTmp = (POINTER_TYPE)jposition;
		position = N2J_CAST_PTR(positionTmp, FMOD_VECTOR *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Geometry *)->setPosition(position);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Geometry_1getPosition(JNIEnv *java_env, jclass jcls, jlong jpointer, jlong jposition) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD_VECTOR *position = 0;
	if(jposition) {
		POINTER_TYPE positionTmp = (POINTER_TYPE)jposition;
		position = N2J_CAST_PTR(positionTmp, FMOD_VECTOR *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Geometry *)->getPosition(position);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Geometry_1setScale(JNIEnv *java_env, jclass jcls, jlong jpointer, jlong jscale) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD_VECTOR *scale = 0;
	if(jscale) {
		POINTER_TYPE scaleTmp = (POINTER_TYPE)jscale;
		scale = N2J_CAST_PTR(scaleTmp, FMOD_VECTOR *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Geometry *)->setScale(scale);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Geometry_1getScale(JNIEnv *java_env, jclass jcls, jlong jpointer, jlong jscale) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD_VECTOR *scale = 0;
	if(jscale) {
		POINTER_TYPE scaleTmp = (POINTER_TYPE)jscale;
		scale = N2J_CAST_PTR(scaleTmp, FMOD_VECTOR *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Geometry *)->getScale(scale);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Geometry_1save(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jdata, jlong jdata_, jobject jdatasize, jlong jdatasize_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	void *data = 0;
	if(jdata) {
		data = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jdata), char *)+jdata_, void *);
	}
	int *datasize = 0;
	if(jdatasize) {
		datasize = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jdatasize), char *)+jdatasize_, int *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Geometry *)->save(data, datasize);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Geometry_1setUserData(JNIEnv *java_env, jclass jcls, jlong jpointer, jlong juserdata) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	POINTER_TYPE userdataTmp = (POINTER_TYPE)juserdata;
	void *userdata = N2J_CAST_PTR(userdataTmp, void *);

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Geometry *)->setUserData(userdata);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Geometry_1getUserData(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject juserdata) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	void *userdata/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Geometry *)->getUserData(&userdata);

	if(juserdata) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, void *) = userdata;
		setPointerAddress(java_env, juserdata, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_FmodExJNI_Geometry_1getMemoryInfo(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jmemorybits, jint jevent_memorybits, jobject jmemoryused, jlong jmemoryused_, jlong jmemoryused_details) {
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

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::Geometry *)->getMemoryInfo(memorybits, event_memorybits, memoryused, memoryused_details);

	return (jint)result_;
}


