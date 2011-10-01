/**
 * 			NativeFmodEx Project
 *
 * Want to use FMOD Ex API (www.fmod.org) in the Java language ? NativeFmodEx is made for you.
 * Copyright � 2005-2010 J�r�me JOUVIE (Jouvieje)
 *
 * Created on 23 feb. 2005
 * @version file v1.5.0
 * @author J�r�me JOUVIE (Jouvieje)
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

#include "fmod_event.h"
#include "fmod_event_net.h"
#include "fmod_event.hpp"
#include "fmod_event_net.hpp"
#include "Utils.h"
#include "Pointer.h"
#include "NativeFmodDesigner.h"
#include "org_jouvieje_fmoddesigner_FmodDesignerJNI.h"
#include "CallbackManager.h"

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventSystem_1init(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jmaxchannels, jint jflags, jlong jextradriverdata, jint jeventflags) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int maxchannels = (int)jmaxchannels;
	FMOD_INITFLAGS flags = (FMOD_INITFLAGS)jflags;
	POINTER_TYPE extradriverdataTmp = (POINTER_TYPE)jextradriverdata;
	void *extradriverdata = N2J_CAST_PTR(extradriverdataTmp, void *);
	FMOD_EVENT_INITFLAGS eventflags = (FMOD_EVENT_INITFLAGS)jeventflags;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventSystem *)->init(maxchannels, flags, extradriverdata, eventflags);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventSystem_1release(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventSystem *)->release();

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventSystem_1update(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventSystem *)->update();

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventSystem_1setMediaPath(JNIEnv *java_env, jclass jcls, jlong jpointer, jbyteArray jpath) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	const char *path = (const char *)getByteArrayElements(java_env, jpath);

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventSystem *)->setMediaPath(path);

	releaseByteArrayElements(java_env, jpath, (const char *)path);
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventSystem_1setPluginPath(JNIEnv *java_env, jclass jcls, jlong jpointer, jbyteArray jpath) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	const char *path = (const char *)getByteArrayElements(java_env, jpath);

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventSystem *)->setPluginPath(path);

	releaseByteArrayElements(java_env, jpath, (const char *)path);
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventSystem_1getVersion(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jversion, jlong jversion_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	unsigned int *version = 0;
	if(jversion) {
		version = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jversion), char *)+jversion_, unsigned int *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventSystem *)->getVersion(version);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventSystem_1getInfo(JNIEnv *java_env, jclass jcls, jlong jpointer, jlong jinfo) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD_EVENT_SYSTEMINFO *info = 0;
	if(jinfo) {
		POINTER_TYPE infoTmp = (POINTER_TYPE)jinfo;
		info = N2J_CAST_PTR(infoTmp, FMOD_EVENT_SYSTEMINFO *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventSystem *)->getInfo(info);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventSystem_1getSystemObject(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jsystem) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD::System *system/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventSystem *)->getSystemObject(&system);

	if(jsystem) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, FMOD::System *) = system;
		setPointerAddress(java_env, jsystem, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventSystem_1getMusicSystem(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jmusicsystem) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD::MusicSystem *musicsystem/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventSystem *)->getMusicSystem(&musicsystem);

	if(jmusicsystem) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, FMOD::MusicSystem *) = musicsystem;
		setPointerAddress(java_env, jmusicsystem, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventSystem_1load__J_3BJLorg_jouvieje_fmoddesigner_EventProject_2(JNIEnv *java_env, jclass jcls, jlong jpointer, jbyteArray jname_or_data, jlong jloadinfo, jobject jproject) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	const char *name_or_data = (const char *)getByteArrayElements(java_env, jname_or_data);
	FMOD_EVENT_LOADINFO *loadinfo = 0;
	if(jloadinfo) {
		POINTER_TYPE loadinfoTmp = (POINTER_TYPE)jloadinfo;
		loadinfo = N2J_CAST_PTR(loadinfoTmp, FMOD_EVENT_LOADINFO *);
	}
	FMOD::EventProject *project/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventSystem *)->load(name_or_data, loadinfo, &project);

	releaseByteArrayElements(java_env, jname_or_data, (const char *)name_or_data);
	if(jproject) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, FMOD::EventProject *) = project;
		setPointerAddress(java_env, jproject, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventSystem_1load__JLjava_nio_ByteBuffer_2JJLorg_jouvieje_fmoddesigner_EventProject_2(JNIEnv *java_env, jclass jcls, jlong jpointer, 	jobject jname_or_data, jlong jname_or_data_, jlong jloadinfo, jobject jproject) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	const char *name_or_data = 0;
	if(jname_or_data) {
		name_or_data = N2J_CAST_VAR(java_env->GetDirectBufferAddress(jname_or_data), const char *)+jname_or_data_;
	}
	FMOD_EVENT_LOADINFO *loadinfo = 0;
	if(jloadinfo) {
		POINTER_TYPE loadinfoTmp = (POINTER_TYPE)jloadinfo;
		loadinfo = N2J_CAST_PTR(loadinfoTmp, FMOD_EVENT_LOADINFO *);
	}
	FMOD::EventProject *project/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventSystem *)->load(name_or_data, loadinfo, &project);

	if(jproject) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, FMOD::EventProject *) = project;
		setPointerAddress(java_env, jproject, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventSystem_1unload(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventSystem *)->unload();

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventSystem_1getProject(JNIEnv *java_env, jclass jcls, jlong jpointer, jbyteArray jname, jobject jproject) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	const char *name = (const char *)getByteArrayElements(java_env, jname);
	FMOD::EventProject *project/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventSystem *)->getProject(name, &project);

	releaseByteArrayElements(java_env, jname, (const char *)name);
	if(jproject) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, FMOD::EventProject *) = project;
		setPointerAddress(java_env, jproject, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventSystem_1getProjectByIndex(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jindex, jobject jproject) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int index = (int)jindex;
	FMOD::EventProject *project/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventSystem *)->getProjectByIndex(index, &project);

	if(jproject) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, FMOD::EventProject *) = project;
		setPointerAddress(java_env, jproject, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventSystem_1getNumProjects(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jnumprojects, jlong jnumprojects_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int *numprojects = 0;
	if(jnumprojects) {
		numprojects = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jnumprojects), char *)+jnumprojects_, int *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventSystem *)->getNumProjects(numprojects);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventSystem_1getCategory(JNIEnv *java_env, jclass jcls, jlong jpointer, jbyteArray jname, jobject jcategory) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	const char *name = (const char *)getByteArrayElements(java_env, jname);
	FMOD::EventCategory *category/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventSystem *)->getCategory(name, &category);

	releaseByteArrayElements(java_env, jname, (const char *)name);
	if(jcategory) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, FMOD::EventCategory *) = category;
		setPointerAddress(java_env, jcategory, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventSystem_1getCategoryByIndex(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jindex, jobject jcategory) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int index = (int)jindex;
	FMOD::EventCategory *category/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventSystem *)->getCategoryByIndex(index, &category);

	if(jcategory) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, FMOD::EventCategory *) = category;
		setPointerAddress(java_env, jcategory, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventSystem_1getMusicCategory(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jcategory) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD::EventCategory *category/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventSystem *)->getMusicCategory(&category);

	if(jcategory) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, FMOD::EventCategory *) = category;
		setPointerAddress(java_env, jcategory, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventSystem_1getNumCategories(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jnumcategories, jlong jnumcategories_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int *numcategories = 0;
	if(jnumcategories) {
		numcategories = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jnumcategories), char *)+jnumcategories_, int *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventSystem *)->getNumCategories(numcategories);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventSystem_1getGroup(JNIEnv *java_env, jclass jcls, jlong jpointer, jbyteArray jname, jboolean jcacheevents, jobject jgroup) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	const char *name = (const char *)getByteArrayElements(java_env, jname);
	bool cacheevents = N2J_CAST_VAR(jcacheevents != 0, bool);
	FMOD::EventGroup *group/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventSystem *)->getGroup(name, cacheevents, &group);

	releaseByteArrayElements(java_env, jname, (const char *)name);
	if(jgroup) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, FMOD::EventGroup *) = group;
		setPointerAddress(java_env, jgroup, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventSystem_1getEvent(JNIEnv *java_env, jclass jcls, jlong jpointer, jbyteArray jname, jint jmode, jobject jevent) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	const char *name = (const char *)getByteArrayElements(java_env, jname);
	FMOD_EVENT_MODE mode = (FMOD_EVENT_MODE)jmode;
	FMOD::Event *event/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventSystem *)->getEvent(name, mode, &event);

	releaseByteArrayElements(java_env, jname, (const char *)name);
	if(jevent) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, FMOD::Event *) = event;
		setPointerAddress(java_env, jevent, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventSystem_1getEventBySystemID(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jsystemid, jint jmode, jobject jevent) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int systemid = (int)jsystemid;
	FMOD_EVENT_MODE mode = (FMOD_EVENT_MODE)jmode;
	FMOD::Event *event/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventSystem *)->getEventBySystemID(systemid, mode, &event);

	if(jevent) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, FMOD::Event *) = event;
		setPointerAddress(java_env, jevent, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventSystem_1getEventByGUID(JNIEnv *java_env, jclass jcls, jlong jpointer, jlong jguid, jint jmode, jobject jevent) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD_GUID *guid = 0;
	if(jguid) {
		POINTER_TYPE guidTmp = (POINTER_TYPE)jguid;
		guid = N2J_CAST_PTR(guidTmp, FMOD_GUID *);
	}
	FMOD_EVENT_MODE mode = (FMOD_EVENT_MODE)jmode;
	FMOD::Event *event/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventSystem *)->getEventByGUID(guid, mode, &event);

	if(jevent) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, FMOD::Event *) = event;
		setPointerAddress(java_env, jevent, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventSystem_1getEventByGUIDString(JNIEnv *java_env, jclass jcls, jlong jpointer, jbyteArray jguid, jint jmode, jobject jevent) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	const char *guid = (const char *)getByteArrayElements(java_env, jguid);
	FMOD_EVENT_MODE mode = (FMOD_EVENT_MODE)jmode;
	FMOD::Event *event/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventSystem *)->getEventByGUIDString(guid, mode, &event);

	releaseByteArrayElements(java_env, jguid, (const char *)guid);
	if(jevent) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, FMOD::Event *) = event;
		setPointerAddress(java_env, jevent, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventSystem_1getNumEvents(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jnumevents, jlong jnumevents_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int *numevents = 0;
	if(jnumevents) {
		numevents = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jnumevents), char *)+jnumevents_, int *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventSystem *)->getNumEvents(numevents);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventSystem_1setReverbProperties(JNIEnv *java_env, jclass jcls, jlong jpointer, jlong jprops) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD_REVERB_PROPERTIES *props = 0;
	if(jprops) {
		POINTER_TYPE propsTmp = (POINTER_TYPE)jprops;
		props = N2J_CAST_PTR(propsTmp, FMOD_REVERB_PROPERTIES *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventSystem *)->setReverbProperties(props);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventSystem_1getReverbProperties(JNIEnv *java_env, jclass jcls, jlong jpointer, jlong jprops) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD_REVERB_PROPERTIES *props = 0;
	if(jprops) {
		POINTER_TYPE propsTmp = (POINTER_TYPE)jprops;
		props = N2J_CAST_PTR(propsTmp, FMOD_REVERB_PROPERTIES *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventSystem *)->getReverbProperties(props);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventSystem_1getReverbPreset(JNIEnv *java_env, jclass jcls, jlong jpointer, jbyteArray jname, jlong jprops, jobject jindex, jlong jindex_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	const char *name = (const char *)getByteArrayElements(java_env, jname);
	FMOD_REVERB_PROPERTIES *props = 0;
	if(jprops) {
		POINTER_TYPE propsTmp = (POINTER_TYPE)jprops;
		props = N2J_CAST_PTR(propsTmp, FMOD_REVERB_PROPERTIES *);
	}
	int *index = 0;
	if(jindex) {
		index = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jindex), char *)+jindex_, int *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventSystem *)->getReverbPreset(name, props, index);

	releaseByteArrayElements(java_env, jname, (const char *)name);
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventSystem_1getReverbPresetByIndex(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jindex, jlong jprops, jobject jname) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int index = (int)jindex;
	FMOD_REVERB_PROPERTIES *props = 0;
	if(jprops) {
		POINTER_TYPE propsTmp = (POINTER_TYPE)jprops;
		props = N2J_CAST_PTR(propsTmp, FMOD_REVERB_PROPERTIES *);
	}
	char *name/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventSystem *)->getReverbPresetByIndex(index, props, &name);

	if(jname) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, char *) = name;
		setPointerAddress(java_env, jname, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventSystem_1getNumReverbPresets(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jnumpresets, jlong jnumpresets_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int *numpresets = 0;
	if(jnumpresets) {
		numpresets = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jnumpresets), char *)+jnumpresets_, int *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventSystem *)->getNumReverbPresets(numpresets);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventSystem_1createReverb(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jreverb) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD::EventReverb *reverb/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventSystem *)->createReverb(&reverb);

	if(jreverb) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, FMOD::EventReverb *) = reverb;
		setPointerAddress(java_env, jreverb, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventSystem_1setReverbAmbientProperties(JNIEnv *java_env, jclass jcls, jlong jpointer, jlong jprops) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD_REVERB_PROPERTIES *props = 0;
	if(jprops) {
		POINTER_TYPE propsTmp = (POINTER_TYPE)jprops;
		props = N2J_CAST_PTR(propsTmp, FMOD_REVERB_PROPERTIES *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventSystem *)->setReverbAmbientProperties(props);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventSystem_1getReverbAmbientProperties(JNIEnv *java_env, jclass jcls, jlong jpointer, jlong jprops) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD_REVERB_PROPERTIES *props = 0;
	if(jprops) {
		POINTER_TYPE propsTmp = (POINTER_TYPE)jprops;
		props = N2J_CAST_PTR(propsTmp, FMOD_REVERB_PROPERTIES *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventSystem *)->getReverbAmbientProperties(props);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventSystem_1createEventQueue(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jqueue) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD::EventQueue *queue/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventSystem *)->createEventQueue(&queue);

	if(jqueue) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, FMOD::EventQueue *) = queue;
		setPointerAddress(java_env, jqueue, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventSystem_1createEventQueueEntry(JNIEnv *java_env, jclass jcls, jlong jpointer, jlong jevent, jobject jentry) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	FMOD::Event *event = 0;
	if(jevent) {
		POINTER_TYPE eventTmp = (POINTER_TYPE)jevent;
		event = N2J_CAST_PTR(eventTmp, FMOD::Event *);
	}
	FMOD::EventQueueEntry *entry/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventSystem *)->createEventQueueEntry(event, &entry);

	if(jentry) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, FMOD::EventQueueEntry *) = entry;
		setPointerAddress(java_env, jentry, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventSystem_1set3DNumListeners(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jnumlisteners) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int numlisteners = (int)jnumlisteners;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventSystem *)->set3DNumListeners(numlisteners);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventSystem_1get3DNumListeners(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject jnumlisteners, jlong jnumlisteners_) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	int *numlisteners = 0;
	if(jnumlisteners) {
		numlisteners = N2J_CAST_VAR(N2J_CAST_VAR(java_env->GetDirectBufferAddress(jnumlisteners), char *)+jnumlisteners_, int *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventSystem *)->get3DNumListeners(numlisteners);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventSystem_1set3DListenerAttributes(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jlistener, jlong jpos, jlong jvel, jlong jforward, jlong jup) {
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

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventSystem *)->set3DListenerAttributes(listener, pos, vel, forward, up);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventSystem_1get3DListenerAttributes(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jlistener, jlong jpos, jlong jvel, jlong jforward, jlong jup) {
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

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventSystem *)->get3DListenerAttributes(listener, pos, vel, forward, up);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventSystem_1setUserData(JNIEnv *java_env, jclass jcls, jlong jpointer, jlong juserdata) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	POINTER_TYPE userdataTmp = (POINTER_TYPE)juserdata;
	void *userdata = N2J_CAST_PTR(userdataTmp, void *);

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventSystem *)->setUserData(userdata);

	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventSystem_1getUserData(JNIEnv *java_env, jclass jcls, jlong jpointer, jobject juserdata) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	void *userdata/* = 0*/;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventSystem *)->getUserData(&userdata);

	if(juserdata) {
		POINTER_TYPE newAddress/* = 0*/;
		N2J_CAST_PTR(newAddress, void *) = userdata;
		setPointerAddress(java_env, juserdata, newAddress);
	}
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventSystem_1preloadFSB(JNIEnv *java_env, jclass jcls, jlong jpointer, jbyteArray jfilename, jint jstreaminstance, jlong jsound) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	const char *filename = (const char *)getByteArrayElements(java_env, jfilename);
	int streaminstance = (int)jstreaminstance;
	FMOD::Sound *sound = 0;
	if(jsound) {
		POINTER_TYPE soundTmp = (POINTER_TYPE)jsound;
		sound = N2J_CAST_PTR(soundTmp, FMOD::Sound *);
	}

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventSystem *)->preloadFSB(filename, streaminstance, sound);

	releaseByteArrayElements(java_env, jfilename, (const char *)filename);
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventSystem_1unloadFSB(JNIEnv *java_env, jclass jcls, jlong jpointer, jbyteArray jfilename, jint jstreaminstance) {
	POINTER_TYPE pointer = (POINTER_TYPE)jpointer;
	const char *filename = (const char *)getByteArrayElements(java_env, jfilename);
	int streaminstance = (int)jstreaminstance;

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventSystem *)->unloadFSB(filename, streaminstance);

	releaseByteArrayElements(java_env, jfilename, (const char *)filename);
	return (jint)result_;
}

JNIEXPORT jint JNICALL Java_org_jouvieje_fmoddesigner_FmodDesignerJNI_EventSystem_1getMemoryInfo(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jmemorybits, jint jevent_memorybits, jobject jmemoryused, jlong jmemoryused_, jlong jmemoryused_details) {
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

	FMOD_RESULT result_ = N2J_CAST_PTR(pointer, FMOD::EventSystem *)->getMemoryInfo(memorybits, event_memorybits, memoryused, memoryused_details);

	return (jint)result_;
}


