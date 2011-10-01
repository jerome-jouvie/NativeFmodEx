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

#ifndef NATIVE2JAVA_PLATFORM_H_
#define NATIVE2JAVA_PLATFORM_H_
#define NATIVE2JAVA_TARGET_LINUX
#define NATIVE2JAVA_TARGET_64

/* PLATFORM Enumeration */
#define NATIVE2JAVA_WIN_32   0
#define NATIVE2JAVA_WIN_64   1
#define NATIVE2JAVA_LINUX_32 3
#define NATIVE2JAVA_LINUX_64 4
#define NATIVE2JAVA_MAC      5

/* Platform define : tells which platform this library is compiling to */
#if defined NATIVE2JAVA_TARGET_WIN
	#pragma message("Windows platform detected !")
	#ifdef NATIVE2JAVA_TARGET_64
		#pragma message("64 bit platform detected !")
		#define CURRENT_PLATFORM NATIVE2JAVA_WIN_64
	#else
		#define CURRENT_PLATFORM NATIVE2JAVA_WIN_32
	#endif
#elif defined NATIVE2JAVA_TARGET_LINUX
	#pragma message("Linux platform detected !")
	#ifdef NATIVE2JAVA_TARGET_64
		#pragma message("64 bit platform detected !")
		#define CURRENT_PLATFORM NATIVE2JAVA_LINUX_64
	#else
		#define CURRENT_PLATFORM NATIVE2JAVA_LINUX_32
	#endif
#elif defined NATIVE2JAVA_TARGET_MAC
	#pragma message("Mac platform detected !")
	#define CURRENT_PLATFORM NATIVE2JAVA_MAC
#else
	#error Platform unrecognized
#endif

#endif
