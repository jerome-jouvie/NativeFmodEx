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

#include "Utils.h"
#include "JavaObject.h"
#include "org_jouvieje_fmodex_utils_MiscJNI.h"


									/*Buffer*/

JNIEXPORT jlong JNICALL Java_org_jouvieje_fmodex_utils_MiscJNI_getBufferAddress(JNIEnv *jenv, jclass jcls, jobject jarg1, jint jarg1_) {
	void *arg1 = 0;
	if(jarg1)
		arg1 = (char *)jenv->GetDirectBufferAddress(jarg1)+jarg1_;

	POINTER_TYPE jresult/* = 0*/;
	*(void **)&jresult = arg1;
	return (jlong)jresult;
}

JNIEXPORT jobject JNICALL Java_org_jouvieje_fmodex_utils_MiscJNI_newDirectByteBuffer(JNIEnv *jenv, jclass jcls, jlong jarg1, jlong jarg2) {
	if(!jarg1) {
		ThrowException(jenv, NullPointerException, NULL_BUFFER);
		return 0;
	}
	void * arg1 = *(void **)&jarg1;
	return jenv->NewDirectByteBuffer(arg1, jarg2);
}

									/*PointerUtils*/

JNIEXPORT jstring JNICALL Java_org_jouvieje_fmodex_utils_MiscJNI_Pointer_1toString(JNIEnv *jenv, jclass jcls, jlong jarg1) {
	if(!jarg1) {
		ThrowException(jenv, NullPointerException, NULL_POINTER);
		return 0;
	}
	char *arg1 = *(char **)&jarg1;
	jstring jresult = jenv->NewStringUTF(arg1);
	return jresult;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_utils_MiscJNI_asInt(JNIEnv *jenv, jclass jcls, jlong jarg1) {
	if(!jarg1) {
		ThrowException(jenv, NullPointerException, NULL_POINTER);
		return 0;
	}
	int jreturn = *(int *)&jarg1;
	return (jint)jreturn;
}

JNIEXPORT jfloat JNICALL Java_org_jouvieje_fmodex_utils_MiscJNI_asFloat(JNIEnv *jenv, jclass jcls, jlong jarg1) {
	if(!jarg1) {
		ThrowException(jenv, NullPointerException, NULL_POINTER);
		return 0;
	}
	float jreturn = *(float *)&jarg1;
	return (jfloat)jreturn;
}

JNIEXPORT jdouble JNICALL Java_org_jouvieje_fmodex_utils_MiscJNI_asDouble(JNIEnv *jenv, jclass jcls, jlong jarg1) {
	if(!jarg1) {
		ThrowException(jenv, NullPointerException, NULL_POINTER);
		return 0;
	}
	double jreturn = *(double *)&jarg1;
	return (jdouble)jreturn;
}

									/*ObjectPointer*/

class ObjectPointer : public JavaObject {
public:
	ObjectPointer(JNIEnv *jenv, jobject obj) : JavaObject(jenv){
		object = 0;
		setObject(jenv, obj);
	}
	~ObjectPointer(){
		JNIEnv *jenv = acquire_jenv();
		deleteObject(jenv);
	}

	void setObject(JNIEnv *jenv, jobject obj) {
		deleteObject(jenv);
		object = jenv->NewGlobalRef(obj);
	}
	jobject getObject() {
		return object;
	}

private:
	jobject object;
	void deleteObject(JNIEnv *jenv) {
		if(object) {
			jenv->DeleteGlobalRef(object);
			object = 0;
		}
	}
};

JNIEXPORT jlong JNICALL Java_org_jouvieje_fmodex_utils_MiscJNI_new_1ObjectPointer(JNIEnv *jenv, jclass jcls, jobject jarg1) {
	ObjectPointer *result = new ObjectPointer(jenv, jarg1);

	CheckAllocation(jenv, result);

    POINTER_TYPE jresult = 0 ;
    *(ObjectPointer **)&jresult = result;
    return (jlong)jresult;
}

JNIEXPORT jobject JNICALL Java_org_jouvieje_fmodex_utils_MiscJNI_get_1ObjectPointer(JNIEnv *jenv, jclass jcls, jlong jarg1) {
    ObjectPointer *arg1 = *(ObjectPointer **)&jarg1;
    if (!arg1) {
        ThrowException(jenv, NullPointerException, NULL_OBJECT_POINTER);
        return 0;
    }
	return arg1->getObject();
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_utils_MiscJNI_set_1ObjectPointer(JNIEnv *jenv, jclass jcls, jlong jarg1, jobject jarg2) {
    ObjectPointer *arg1 = *(ObjectPointer **)&jarg1;
    if (!arg1) {
        ThrowException(jenv, NullPointerException, NULL_OBJECT_POINTER);
        return ;
    }
	arg1->setObject(jenv, jarg2);
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_utils_MiscJNI_delete_1ObjectPointer(JNIEnv *jenv, jclass jcls, jlong jarg1) {
	delete *(ObjectPointer **)&jarg1;
}
