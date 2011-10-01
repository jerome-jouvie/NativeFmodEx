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

#ifndef WINDOWHANDLE_H_
#define WINDOWHANDLE_H_

#include "Includes.h"
#include "NativeFmodEx.h"

#if (CURRENT_PLATFORM == NATIVE2JAVA_WIN_32) || (CURRENT_PLATFORM == NATIVE2JAVA_WIN_64)
	#include "Includes.h"
	#include <process.h>
	#include "jawt_md.h"

	struct ConfigDialogThreadParams {
		jlong pointer;
		jlong handle;
		jlong hwndHwnd;
		bool show;
		jint result;
		bool isShown;
	};
#else
	#pragma message("Not supported on Linux/Mac platforms !")
#endif

extern void configDialogThread(void *args);

#endif
