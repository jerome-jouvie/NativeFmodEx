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

package org.jouvieje.fmodex.utils;

import java.nio.Buffer;
import java.nio.ByteBuffer;

import org.jouvieje.fmodex.Init;

class MiscJNI {
	static {
		if(!Init.isLibrariesLoaded()) {
			throw new RuntimeException("Libraries not loaded ! Use Init.loadLibraries() before using NativeFmodEx.");
		}
	}

	/* Buffer Utils */
	protected final static native long getBufferAddress(Buffer jarg1, int jarg1_);
	protected final static native ByteBuffer newDirectByteBuffer(long address, long capacity);

	/* PointerUtils */
	protected final static native String Pointer_toString(long jarg1);
	protected final static native int asInt(long jarg1);
	protected final static native float asFloat(long jarg1);
	protected final static native double asDouble(long jarg1);

	/* ObjectPointer */
	protected final static native long new_ObjectPointer(Object jarg1);
	protected final static native Object get_ObjectPointer(long jarg1);
	protected final static native void set_ObjectPointer(long jarg1, Object jarg2);
	protected final static native void delete_ObjectPointer(long jarg1);
}
