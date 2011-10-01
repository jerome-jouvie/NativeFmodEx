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

#include "NativeFmodEx.h"
#include "fmod.h"
#include "fmod_errors.h"
#include "CallbackManager.h"
#include "org_jouvieje_fmodex_Init.h"
#include "org_jouvieje_fmodex_FmodExJNI.h"
#include "org_jouvieje_fmodex_defines_VersionsJNI.h"

#if (CURRENT_PLATFORM == NATIVE2JAVA_WIN_64)
#pragma comment(lib, "fmodex64_vc.lib")
#pragma comment(lib, "../../JAWT/1.5.0_06_x64/jawt.lib")
#else
#pragma comment(lib, "fmodex_vc.lib")
#pragma comment(lib, "../../JAWT/1.5.0_06/jawt.lib")
#endif

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_defines_VersionsJNI_get_1FMOD_1VERSION(JNIEnv *jenv, jclass jcls) {
	return FMOD_VERSION;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_defines_VersionsJNI_get_1NATIVEFMODEX_1VERSION(JNIEnv *jenv, jclass jcls) {
	return NATIVEFMODEX_VERSION;
}


JNIEXPORT jstring JNICALL Java_org_jouvieje_fmodex_FmodExJNI_FMOD_1ErrorString(JNIEnv *jenv, jclass jcls, jint errCode) {
	const char *result = FMOD_ErrorString((FMOD_RESULT)errCode);
	jstring jresult = 0;
	if(result) {
		jresult = jenv->NewStringUTF((const char *)result);
	}
	return jresult;
}

JNIEXPORT void JNICALL Java_org_jouvieje_fmodex_Init_attachJavaVM(JNIEnv *jenv, jclass jcls) {
	attachJavaVM(jenv);
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmodex_Init_get_1PLATFORM(JNIEnv *jenv, jclass jcls) {
	return CURRENT_PLATFORM;
}
