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

#include "Pointer.h"
#include "WindowHandle.h"
#include "org_jouvieje_fmodex_FmodExJNI.h"
#include "fmod.h"
#include "fmod.hpp"

#if (CURRENT_PLATFORM == NATIVE2JAVA_WIN_32) || (CURRENT_PLATFORM == NATIVE2JAVA_WIN_64)
	JNIEXPORT jlong JNICALL Java_org_jouvieje_fmodex_FmodExJNI_getHwnd(JNIEnv *jenv, jclass jcls, jobject canvas) {
		if(!canvas) {
			return 0;
		}

 		JAWT awt;
 		awt.version = JAWT_VERSION_1_4;
 		if(JAWT_GetAWT(jenv, &awt) == JNI_FALSE) {
 			return 0;
 		}

 		///Get the drawing surface
		 JAWT_DrawingSurface* ds = awt.GetDrawingSurface(jenv, canvas);
		 if(ds == NULL) {
			 return 0;
 		}

 		//Lock the drawing surface
		 jint lock = ds->Lock(ds);
 		if((lock & JAWT_LOCK_ERROR) != 0) {
 			awt.FreeDrawingSurface(ds);
 			return 0;
		 }

 		//Get the drawing surface info
 		JAWT_DrawingSurfaceInfo* dsi = ds->GetDrawingSurfaceInfo(ds);
 		if(dsi == NULL) {
 			ds->Unlock(ds);
 			awt.FreeDrawingSurface(ds);
 			return 0;
 		}

 		//Get the platform-specific drawing info
 		JAWT_Win32DrawingSurfaceInfo* dsi_Win32 = (JAWT_Win32DrawingSurfaceInfo*)dsi->platformInfo;
 		if(dsi_Win32 == NULL)
 		{
 			ds->Unlock(ds);
 			awt.FreeDrawingSurface(ds);
 			return 0;
 		}

 		POINTER_TYPE jresult = 0;
		if(dsi_Win32->hwnd) {
 			*(void **)&jresult = dsi_Win32->hwnd;
		}

 		ds->FreeDrawingSurfaceInfo(dsi);
 		dsi = 0;
 		ds->Unlock(ds);
 		awt.FreeDrawingSurface(ds);
 		ds = 0;

		return (jlong)jresult;
	}

	void configDialogThread(void *args) {
		ConfigDialogThreadParams *params = (ConfigDialogThreadParams *)args;
		params->isShown = false;

		FMOD_RESULT result_;
		if(params->handle) {
			result_ = (*(FMOD::DSP **)&(params->pointer))->showConfigDialog(N2J_CAST_VAR(params->handle, HWND), params->show);
		}
		else {
			result_ = (*(FMOD::DSP **)&(params->pointer))->showConfigDialog(N2J_CAST_VAR(params->hwndHwnd, HWND), params->show);
		}
		params->result = (jint)result_;
		params->isShown = true;

		if(params->show) {
			MSG msg;
			while(GetMessage(&msg, 0, 0, 0) > 0) {
				TranslateMessage(&msg);
				DispatchMessage(&msg);
			}
		}

		_endthread();
	}
#elif (CURRENT_PLATFORM == NATIVE2JAVA_LINUX_32) || (CURRENT_PLATFORM == NATIVE2JAVA_LINUX_64)
#if 0
#include "../../JNI_Headers/sun/jawt_md.h"
#endif
JNIEXPORT jlong JNICALL Java_org_jouvieje_fmodex_FmodExJNI_getHwnd(JNIEnv *jenv, jclass jcls, jobject canvas) {
#if 0
	if(!canvas) {
		return 0;
	}

 	JAWT awt;
 	awt.version = JAWT_VERSION_1_4;
 	if(JAWT_GetAWT(jenv, &awt) == JNI_FALSE) {
 		return 0;
 	}

 	///Get the drawing surface
     JAWT_DrawingSurface* ds = awt.GetDrawingSurface(jenv, canvas);
     if(ds == NULL) {
         return 0;
 	}

 	//Lock the drawing surface
     jint lock = ds->Lock(ds);
 	if((lock & JAWT_LOCK_ERROR) != 0) {
 		awt.FreeDrawingSurface(ds);
 		return 0;
     }

 	//Get the drawing surface info
 	JAWT_DrawingSurfaceInfo* dsi = ds->GetDrawingSurfaceInfo(ds);
 	if(dsi == NULL) {
 		ds->Unlock(ds);
 		awt.FreeDrawingSurface(ds);
 		return 0;
 	}

 	//Get the platform-specific drawing info
 	JAWT_X11DrawingSurfaceInfo* dsi_X11 = (JAWT_X11DrawingSurfaceInfo*)dsi->platformInfo;
 	if(dsi_X11 == NULL)
 	{
 		ds->Unlock(ds);
 		awt.FreeDrawingSurface(ds);
 		return 0;
 	}

 	jlong jresult = 0;
	if(dsi_X11->drawable) {
 		*(Drawable *)&jresult = dsi_X11->drawable;
	}

 	ds->FreeDrawingSurfaceInfo(dsi);
 	dsi = 0;
 	ds->Unlock(ds);
 	awt.FreeDrawingSurface(ds);
 	ds = 0;

	return jresult;
#else
	return 0;
#endif
}
#else
#if 0
#include "jawt_md.h"
#endif
	JNIEXPORT jlong JNICALL Java_org_jouvieje_fmodex_FmodExJNI_getHwnd(JNIEnv *jenv, jclass jcls, jobject canvas) {
#if 0
	if(!canvas) {
		return 0;
	}

 	JAWT awt;
 	awt.version = JAWT_VERSION_1_4;
 	if(JAWT_GetAWT(jenv, &awt) == JNI_FALSE) {
 		return 0;
 	}

 	///Get the drawing surface
     JAWT_DrawingSurface* ds = awt.GetDrawingSurface(jenv, canvas);
     if(ds == NULL) {
         return 0;
 	}

 	//Lock the drawing surface
     jint lock = ds->Lock(ds);
 	if((lock & JAWT_LOCK_ERROR) != 0) {
 		awt.FreeDrawingSurface(ds);
 		return 0;
     }

 	//Get the drawing surface info
 	JAWT_DrawingSurfaceInfo* dsi = ds->GetDrawingSurfaceInfo(ds);
 	if(dsi == NULL) {
 		ds->Unlock(ds);
 		awt.FreeDrawingSurface(ds);
 		return 0;
 	}

 	//Get the platform-specific drawing info
 	JAWT_MacOSDrawingSurfaceInfo* dsi_MacOS = (JAWT_MacOSDrawingSurfaceInfo*)dsi->platformInfo;
 	if(dsi_MacOS == NULL)
 	{
 		ds->Unlock(ds);
 		awt.FreeDrawingSurface(ds);
 		return 0;
 	}

 	jlong jresult = 0;
	if(dsi_MacOS->cocoaViewRef) {
 		*(NSView **)&jresult = dsi_MacOS->cocoaViewRef;
	}

 	ds->FreeDrawingSurfaceInfo(dsi);
 	dsi = 0;
 	ds->Unlock(ds);
 	awt.FreeDrawingSurface(ds);
 	ds = 0;

	return jresult;
#else
	return 0;
#endif
	}
#endif
