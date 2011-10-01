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

package org.jouvieje.fmodex;

import org.jouvieje.fmodex.*;
import org.jouvieje.fmodex.exceptions.*;
import org.jouvieje.fmodex.callbacks.*;
import org.jouvieje.fmodex.*;
import org.jouvieje.fmodex.defines.*;
import org.jouvieje.fmodex.enumerations.*;
import org.jouvieje.fmodex.structures.*;
import java.nio.*;
import org.jouvieje.fmodex.utils.*;
import org.jouvieje.fmodex.System;

public class FmodEx extends Pointer {
	private FmodEx() {}

	/**
	 * 
	 */
	public static FMOD_RESULT Memory_Initialize(ByteBuffer poolmem, int poollen, FMOD_MEMORY_ALLOCCALLBACK useralloc, FMOD_MEMORY_REALLOCCALLBACK userrealloc, FMOD_MEMORY_FREECALLBACK userfree, int memtypeflags) {
		if(poolmem != null && !poolmem.isDirect()) {
			throw new NonDirectBufferException();
		}
		if(useralloc != null && userrealloc != null && userfree != null) {
			CallbackManager.addCallback(25, useralloc, 0);
			CallbackManager.addCallback(27, userrealloc, 0);
			CallbackManager.addCallback(26, userfree, 0);
		} else { useralloc = null; userrealloc = null; userfree = null; }
		int javaResult = FmodExJNI.FmodEx_Memory_Initialize(poolmem, BufferUtils.getPositionInBytes(poolmem), poollen, useralloc == null ? false : true, userrealloc == null ? false : true, userfree == null ? false : true, memtypeflags);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public static FMOD_RESULT Memory_GetStats(IntBuffer currentalloced, IntBuffer maxalloced, boolean blocking) {
		if(currentalloced != null && !currentalloced.isDirect()) {
			throw new NonDirectBufferException();
		}
		if(maxalloced != null && !maxalloced.isDirect()) {
			throw new NonDirectBufferException();
		}
		int javaResult = FmodExJNI.FmodEx_Memory_GetStats(currentalloced, BufferUtils.getPositionInBytes(currentalloced), maxalloced, BufferUtils.getPositionInBytes(maxalloced), blocking);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public static FMOD_RESULT Debug_SetLevel(int level) {
		int javaResult = FmodExJNI.FmodEx_Debug_SetLevel(level);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public static FMOD_RESULT Debug_GetLevel(IntBuffer level) {
		if(level != null && !level.isDirect()) {
			throw new NonDirectBufferException();
		}
		int javaResult = FmodExJNI.FmodEx_Debug_GetLevel(level, BufferUtils.getPositionInBytes(level));
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public static FMOD_RESULT File_SetDiskBusy(int busy) {
		int javaResult = FmodExJNI.FmodEx_File_SetDiskBusy(busy);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public static FMOD_RESULT File_GetDiskBusy(IntBuffer busy) {
		if(busy != null && !busy.isDirect()) {
			throw new NonDirectBufferException();
		}
		int javaResult = FmodExJNI.FmodEx_File_GetDiskBusy(busy, BufferUtils.getPositionInBytes(busy));
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public static FMOD_RESULT System_Create(System system) {
		int javaResult = FmodExJNI.FmodEx_System_Create(system);
		return FMOD_RESULT.get(javaResult);
	}


						/*fmod_errors.h*/

	public static String FMOD_ErrorString(FMOD_RESULT errCode) {
		return FmodExJNI.FMOD_ErrorString(errCode.asInt());
	}

}
