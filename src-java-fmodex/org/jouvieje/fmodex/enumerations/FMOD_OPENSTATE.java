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

package org.jouvieje.fmodex.enumerations;

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
import java.util.HashMap;

/**
 * <BR>
 * <BR>
 * These values describe what state a sound is in after FMOD_NONBLOCKING has been used to open it.<BR>
 * <BR><U><B>Remarks</B></U><BR><BR>
 * With streams, if you are using FMOD_NONBLOCKING, note that if the user calls Sound::getSubSound, a stream will go into FMOD_OPENSTATE_SEEKING state and sound related commands will return FMOD_ERR_NOTREADY.<BR>
 * With streams, if you are using FMOD_NONBLOCKING, note that if the user calls Channel::getPosition, a stream will go into FMOD_OPENSTATE_SETPOSITION state and sound related commands will return FMOD_ERR_NOTREADY.<BR>
 * <BR><U><B>Platforms Supported</B></U><BR><BR>
 * Win32, Win64, Linux, Linux64, Macintosh, Xbox360, PlayStation 2, PlayStation Portable, PlayStation 3, Wii, Solaris, iPhone<BR>
 * <BR><U><B>See Also</B></U><BR><BR>
 * Sound::getOpenState<BR>
 * FMOD_MODE<BR>
 * 
 */
public class FMOD_OPENSTATE implements Enumeration, Comparable {
	/**  */
	public final static FMOD_OPENSTATE FMOD_OPENSTATE_READY = new FMOD_OPENSTATE("FMOD_OPENSTATE_READY", 0);
	/**  */
	public final static FMOD_OPENSTATE FMOD_OPENSTATE_LOADING = new FMOD_OPENSTATE("FMOD_OPENSTATE_LOADING", EnumerationJNI.get_FMOD_OPENSTATE_LOADING());
	/**  */
	public final static FMOD_OPENSTATE FMOD_OPENSTATE_ERROR = new FMOD_OPENSTATE("FMOD_OPENSTATE_ERROR", EnumerationJNI.get_FMOD_OPENSTATE_ERROR());
	/**  */
	public final static FMOD_OPENSTATE FMOD_OPENSTATE_CONNECTING = new FMOD_OPENSTATE("FMOD_OPENSTATE_CONNECTING", EnumerationJNI.get_FMOD_OPENSTATE_CONNECTING());
	/**  */
	public final static FMOD_OPENSTATE FMOD_OPENSTATE_BUFFERING = new FMOD_OPENSTATE("FMOD_OPENSTATE_BUFFERING", EnumerationJNI.get_FMOD_OPENSTATE_BUFFERING());
	/**  */
	public final static FMOD_OPENSTATE FMOD_OPENSTATE_SEEKING = new FMOD_OPENSTATE("FMOD_OPENSTATE_SEEKING", EnumerationJNI.get_FMOD_OPENSTATE_SEEKING());
	/**  */
	public final static FMOD_OPENSTATE FMOD_OPENSTATE_STREAMING = new FMOD_OPENSTATE("FMOD_OPENSTATE_STREAMING", EnumerationJNI.get_FMOD_OPENSTATE_STREAMING());
	/**  */
	public final static FMOD_OPENSTATE FMOD_OPENSTATE_SETPOSITION = new FMOD_OPENSTATE("FMOD_OPENSTATE_SETPOSITION", EnumerationJNI.get_FMOD_OPENSTATE_SETPOSITION());
	/**  */
	public final static FMOD_OPENSTATE FMOD_OPENSTATE_MAX = new FMOD_OPENSTATE("FMOD_OPENSTATE_MAX", EnumerationJNI.get_FMOD_OPENSTATE_MAX());
	/**  */
	public final static FMOD_OPENSTATE FMOD_OPENSTATE_FORCEINT = new FMOD_OPENSTATE("FMOD_OPENSTATE_FORCEINT", 65536);

	private final static HashMap VALUES = new HashMap(2*10);
	static {
		VALUES.put(new Integer(FMOD_OPENSTATE_READY.asInt()), FMOD_OPENSTATE_READY);
		VALUES.put(new Integer(FMOD_OPENSTATE_LOADING.asInt()), FMOD_OPENSTATE_LOADING);
		VALUES.put(new Integer(FMOD_OPENSTATE_ERROR.asInt()), FMOD_OPENSTATE_ERROR);
		VALUES.put(new Integer(FMOD_OPENSTATE_CONNECTING.asInt()), FMOD_OPENSTATE_CONNECTING);
		VALUES.put(new Integer(FMOD_OPENSTATE_BUFFERING.asInt()), FMOD_OPENSTATE_BUFFERING);
		VALUES.put(new Integer(FMOD_OPENSTATE_SEEKING.asInt()), FMOD_OPENSTATE_SEEKING);
		VALUES.put(new Integer(FMOD_OPENSTATE_STREAMING.asInt()), FMOD_OPENSTATE_STREAMING);
		VALUES.put(new Integer(FMOD_OPENSTATE_SETPOSITION.asInt()), FMOD_OPENSTATE_SETPOSITION);
		VALUES.put(new Integer(FMOD_OPENSTATE_MAX.asInt()), FMOD_OPENSTATE_MAX);
		VALUES.put(new Integer(FMOD_OPENSTATE_FORCEINT.asInt()), FMOD_OPENSTATE_FORCEINT);
	}

	private final String name;
	private final int nativeValue;
	private FMOD_OPENSTATE(String name, int nativeValue) {
		this.name = name;
		this.nativeValue = nativeValue;
	}

	public int asInt() {
		return nativeValue;
	}
	public String toString() {
		return name;
	}
	public boolean equals(Object object) {
		if(object instanceof FMOD_OPENSTATE) {
			return asInt() == ((FMOD_OPENSTATE)object).asInt();
		}
		return false;
	}
	public int compareTo(Object object) {
		return asInt() - ((FMOD_OPENSTATE)object).asInt();
	}


	/**
	 * Retrieve a FMOD_OPENSTATE enum field with his integer value
	 * @param nativeValue the integer value of the field to retrieve
	 * @return the FMOD_OPENSTATE enum field that correspond to the integer value
	 */
	public static FMOD_OPENSTATE get(int nativeValue) {
		return (FMOD_OPENSTATE)VALUES.get(new Integer(nativeValue));
	}

	/**
	 * Retrieve a FMOD_OPENSTATE enum field from a Pointer
	 * @param pointer a pointer holding an FMOD_OPENSTATE enum field
	 * @return the FMOD_OPENSTATE enum field that correspond to the enum field in the pointer
	 */
	public static FMOD_OPENSTATE get(Pointer pointer) {
		return get(pointer.asInt());
	}

	/**
	 * @return an <code>Iterator</code> over the elements in this enumeration.<BR>
	 * Can be cast to <code>Iterator<FMOD_OPENSTATE></code> in Java 1.5.
	 */
	public static java.util.Iterator iterator() {
		return new java.util.Iterator(){
			private java.util.Iterator i = VALUES.values().iterator();	//Wrapper of the HashMap iterator
			public boolean hasNext() { return i.hasNext(); }
			public Object next() { return i.next(); }
			public void remove() { throw new UnsupportedOperationException(); }
		};
	}
}
