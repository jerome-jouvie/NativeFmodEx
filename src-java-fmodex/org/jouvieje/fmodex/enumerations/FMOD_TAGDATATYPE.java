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
 * List of data types that can be returned by Sound::getTag<BR>
 * <BR><U><B>Remarks</B></U><BR><BR>
 * <BR><U><B>Platforms Supported</B></U><BR><BR>
 * Win32, Win64, Linux, Linux64, Macintosh, Xbox360, PlayStation 2, PlayStation Portable, PlayStation 3, Wii, Solaris, iPhone<BR>
 * <BR><U><B>See Also</B></U><BR><BR>
 * Sound::getTag<BR>
 * 
 */
public class FMOD_TAGDATATYPE implements Enumeration, Comparable {
	/**  */
	public final static FMOD_TAGDATATYPE FMOD_TAGDATATYPE_BINARY = new FMOD_TAGDATATYPE("FMOD_TAGDATATYPE_BINARY", 0);
	/**  */
	public final static FMOD_TAGDATATYPE FMOD_TAGDATATYPE_INT = new FMOD_TAGDATATYPE("FMOD_TAGDATATYPE_INT", EnumerationJNI.get_FMOD_TAGDATATYPE_INT());
	/**  */
	public final static FMOD_TAGDATATYPE FMOD_TAGDATATYPE_FLOAT = new FMOD_TAGDATATYPE("FMOD_TAGDATATYPE_FLOAT", EnumerationJNI.get_FMOD_TAGDATATYPE_FLOAT());
	/**  */
	public final static FMOD_TAGDATATYPE FMOD_TAGDATATYPE_STRING = new FMOD_TAGDATATYPE("FMOD_TAGDATATYPE_STRING", EnumerationJNI.get_FMOD_TAGDATATYPE_STRING());
	/**  */
	public final static FMOD_TAGDATATYPE FMOD_TAGDATATYPE_STRING_UTF16 = new FMOD_TAGDATATYPE("FMOD_TAGDATATYPE_STRING_UTF16", EnumerationJNI.get_FMOD_TAGDATATYPE_STRING_UTF16());
	/**  */
	public final static FMOD_TAGDATATYPE FMOD_TAGDATATYPE_STRING_UTF16BE = new FMOD_TAGDATATYPE("FMOD_TAGDATATYPE_STRING_UTF16BE", EnumerationJNI.get_FMOD_TAGDATATYPE_STRING_UTF16BE());
	/**  */
	public final static FMOD_TAGDATATYPE FMOD_TAGDATATYPE_STRING_UTF8 = new FMOD_TAGDATATYPE("FMOD_TAGDATATYPE_STRING_UTF8", EnumerationJNI.get_FMOD_TAGDATATYPE_STRING_UTF8());
	/**  */
	public final static FMOD_TAGDATATYPE FMOD_TAGDATATYPE_CDTOC = new FMOD_TAGDATATYPE("FMOD_TAGDATATYPE_CDTOC", EnumerationJNI.get_FMOD_TAGDATATYPE_CDTOC());
	/**  */
	public final static FMOD_TAGDATATYPE FMOD_TAGDATATYPE_MAX = new FMOD_TAGDATATYPE("FMOD_TAGDATATYPE_MAX", EnumerationJNI.get_FMOD_TAGDATATYPE_MAX());
	/**  */
	public final static FMOD_TAGDATATYPE FMOD_TAGDATATYPE_FORCEINT = new FMOD_TAGDATATYPE("FMOD_TAGDATATYPE_FORCEINT", 65536);

	private final static HashMap VALUES = new HashMap(2*10);
	static {
		VALUES.put(new Integer(FMOD_TAGDATATYPE_BINARY.asInt()), FMOD_TAGDATATYPE_BINARY);
		VALUES.put(new Integer(FMOD_TAGDATATYPE_INT.asInt()), FMOD_TAGDATATYPE_INT);
		VALUES.put(new Integer(FMOD_TAGDATATYPE_FLOAT.asInt()), FMOD_TAGDATATYPE_FLOAT);
		VALUES.put(new Integer(FMOD_TAGDATATYPE_STRING.asInt()), FMOD_TAGDATATYPE_STRING);
		VALUES.put(new Integer(FMOD_TAGDATATYPE_STRING_UTF16.asInt()), FMOD_TAGDATATYPE_STRING_UTF16);
		VALUES.put(new Integer(FMOD_TAGDATATYPE_STRING_UTF16BE.asInt()), FMOD_TAGDATATYPE_STRING_UTF16BE);
		VALUES.put(new Integer(FMOD_TAGDATATYPE_STRING_UTF8.asInt()), FMOD_TAGDATATYPE_STRING_UTF8);
		VALUES.put(new Integer(FMOD_TAGDATATYPE_CDTOC.asInt()), FMOD_TAGDATATYPE_CDTOC);
		VALUES.put(new Integer(FMOD_TAGDATATYPE_MAX.asInt()), FMOD_TAGDATATYPE_MAX);
		VALUES.put(new Integer(FMOD_TAGDATATYPE_FORCEINT.asInt()), FMOD_TAGDATATYPE_FORCEINT);
	}

	private final String name;
	private final int nativeValue;
	private FMOD_TAGDATATYPE(String name, int nativeValue) {
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
		if(object instanceof FMOD_TAGDATATYPE) {
			return asInt() == ((FMOD_TAGDATATYPE)object).asInt();
		}
		return false;
	}
	public int compareTo(Object object) {
		return asInt() - ((FMOD_TAGDATATYPE)object).asInt();
	}


	/**
	 * Retrieve a FMOD_TAGDATATYPE enum field with his integer value
	 * @param nativeValue the integer value of the field to retrieve
	 * @return the FMOD_TAGDATATYPE enum field that correspond to the integer value
	 */
	public static FMOD_TAGDATATYPE get(int nativeValue) {
		return (FMOD_TAGDATATYPE)VALUES.get(new Integer(nativeValue));
	}

	/**
	 * Retrieve a FMOD_TAGDATATYPE enum field from a Pointer
	 * @param pointer a pointer holding an FMOD_TAGDATATYPE enum field
	 * @return the FMOD_TAGDATATYPE enum field that correspond to the enum field in the pointer
	 */
	public static FMOD_TAGDATATYPE get(Pointer pointer) {
		return get(pointer.asInt());
	}

	/**
	 * @return an <code>Iterator</code> over the elements in this enumeration.<BR>
	 * Can be cast to <code>Iterator<FMOD_TAGDATATYPE></code> in Java 1.5.
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
