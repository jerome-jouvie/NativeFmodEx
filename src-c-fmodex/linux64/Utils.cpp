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

const char * NULL_OBJECT_POINTER = "Null pointer";
const char * NULL_POINTER = NULL_POINTER;
const char * NULL_BUFFER = NULL_BUFFER;
const char * FATAL_ERROR_MESSAGE = "An non-throwable exception has occured.";

void ThrowException(JNIEnv *jenv, ExceptionType type, const char *message) {
	jclass exception;
	switch(type) {
		//case FFmpegException:	   exception = jenv->FindClass("#DEFAULT_EXCEPTION/#/FFmpegException"); break;
		case InitException:		   exception = jenv->FindClass("#DEFAULT_EXCEPTION/#/InitException"); break;
		case NullPointerException: exception = jenv->FindClass("java/lang/NullPointerException"); break;
		case RuntimeException:	   exception = jenv->FindClass("java/lang/RuntimeException"); break;
		case OutOfMemoryError:	   exception = jenv->FindClass("java/lang/OutOfMemoryError"); break;
		default:				   exception = jenv->FindClass("java/lang/UnknownError"); break;
	}

	if(exception) {
		jenv->ThrowNew(exception, message);
		jenv->DeleteLocalRef(exception);
	}
}
bool CheckAllocation(JNIEnv *jenv, void *memAllocated) {
	if(memAllocated == NULL) {
		ThrowException(jenv, OutOfMemoryError, "");
		return false;
	}
	else {
		return true;
	}
}

jclass stringClass = 0;
jclass getStringClass(JNIEnv *jenv) {
	if(!stringClass) {
		stringClass = (jclass)jenv->NewGlobalRef(jenv->FindClass("java/lang/String"));
	}
	return stringClass;
}
jmethodID getBytesId = 0;
jmethodID getGetBytesId(JNIEnv *jenv) {
	if(getBytesId == 0) {
		getBytesId = jenv->GetMethodID(getStringClass(jenv), "getBytes", "()[B");
	}
	return getBytesId;
}

char *getByteArrayElements(JNIEnv *jenv, jbyteArray array) {
	if(array) {
		const jsize length = jenv->GetArrayLength(array);
		const jbyte *chars = jenv->GetByteArrayElements(array, 0);
		char *copy = new char[length+1];		//Allocate memory
		if(!CheckAllocation(jenv, copy)) {
			return 0;
		}

		for(int i = 0; i < length; i++) {
			copy[i] = (char)chars[i];
		}
		copy[length] = 0;		//End of the string
		jenv->ReleaseByteArrayElements(array, (jbyte *)chars, 0);

		return copy;
	}
	return 0;
}

void releaseByteArrayElements(JNIEnv *jenv, jbyteArray array, const char *chars) {
	if(chars) {
		delete [] chars; //Deallocate memory
		chars = NULL;
	}
}

char *getStringElements(JNIEnv *jenv, jstring string) {
	if(string) {
		jbyteArray array = (jbyteArray)jenv->CallObjectMethod(string, getGetBytesId(jenv));
		return getByteArrayElements(jenv, array);
	}
	return 0;
}

void releaseStringElements(JNIEnv *jenv, jstring string, const char *chars) {
	if(chars) {
		delete [] chars; //Deallocate memory
		chars = NULL;
	}
}
