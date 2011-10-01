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

package org.jouvieje.fmoddesigner.enumerations;

import org.jouvieje.fmoddesigner.*;
import org.jouvieje.fmodex.exceptions.*;
import org.jouvieje.fmoddesigner.callbacks.*;
import org.jouvieje.fmoddesigner.*;
import org.jouvieje.fmoddesigner.defines.*;
import org.jouvieje.fmoddesigner.enumerations.*;
import org.jouvieje.fmoddesigner.structures.*;
import java.nio.*;
import org.jouvieje.fmodex.*;
import org.jouvieje.fmodex.System;
import org.jouvieje.fmodex.enumerations.*;
import org.jouvieje.fmodex.structures.*;
import org.jouvieje.fmodex.utils.*;
import java.util.HashMap;

/**
 * <BR>
 * <BR>
 * Sound definition entry types for FMOD_EVENT_SOUNDDEFINFO.<BR>
 * <BR><U><B>Remarks</B></U><BR><BR>
 * <BR><U><B>Platforms Supported</B></U><BR><BR>
 * Win32, Win64, Linux, Macintosh, Xbox, Xbox360, PlayStation 2, GameCube, PlayStation Portable, PlayStation 3, Wii, Wii<BR>
 * <BR><U><B>See Also</B></U><BR><BR>
 * FMOD_EVENT_SOUNDDEFINFO<BR>
 * FMOD_EVENT_CALLBACK<BR>
 * FMOD_EVENT_CALLBACKTYPE<BR>
 * 
 */
public class FMOD_EVENT_SOUNDDEF_ENTRYTYPE implements Enumeration, Comparable {
	/**  */
	public final static FMOD_EVENT_SOUNDDEF_ENTRYTYPE FMOD_EVENT_SOUNDDEF_ENTRYTYPE_WAVETABLE = new FMOD_EVENT_SOUNDDEF_ENTRYTYPE("FMOD_EVENT_SOUNDDEF_ENTRYTYPE_WAVETABLE", EnumerationJNI.get_FMOD_EVENT_SOUNDDEF_ENTRYTYPE_WAVETABLE());
	/**  */
	public final static FMOD_EVENT_SOUNDDEF_ENTRYTYPE FMOD_EVENT_SOUNDDEF_ENTRYTYPE_OSCILLATOR = new FMOD_EVENT_SOUNDDEF_ENTRYTYPE("FMOD_EVENT_SOUNDDEF_ENTRYTYPE_OSCILLATOR", EnumerationJNI.get_FMOD_EVENT_SOUNDDEF_ENTRYTYPE_OSCILLATOR());
	/**  */
	public final static FMOD_EVENT_SOUNDDEF_ENTRYTYPE FMOD_EVENT_SOUNDDEF_ENTRYTYPE_NULL = new FMOD_EVENT_SOUNDDEF_ENTRYTYPE("FMOD_EVENT_SOUNDDEF_ENTRYTYPE_NULL", EnumerationJNI.get_FMOD_EVENT_SOUNDDEF_ENTRYTYPE_NULL());
	/**  */
	public final static FMOD_EVENT_SOUNDDEF_ENTRYTYPE FMOD_EVENT_SOUNDDEF_ENTRYTYPE_PROGRAMMER = new FMOD_EVENT_SOUNDDEF_ENTRYTYPE("FMOD_EVENT_SOUNDDEF_ENTRYTYPE_PROGRAMMER", EnumerationJNI.get_FMOD_EVENT_SOUNDDEF_ENTRYTYPE_PROGRAMMER());

	private final static HashMap VALUES = new HashMap(2*4);
	static {
		VALUES.put(new Integer(FMOD_EVENT_SOUNDDEF_ENTRYTYPE_WAVETABLE.asInt()), FMOD_EVENT_SOUNDDEF_ENTRYTYPE_WAVETABLE);
		VALUES.put(new Integer(FMOD_EVENT_SOUNDDEF_ENTRYTYPE_OSCILLATOR.asInt()), FMOD_EVENT_SOUNDDEF_ENTRYTYPE_OSCILLATOR);
		VALUES.put(new Integer(FMOD_EVENT_SOUNDDEF_ENTRYTYPE_NULL.asInt()), FMOD_EVENT_SOUNDDEF_ENTRYTYPE_NULL);
		VALUES.put(new Integer(FMOD_EVENT_SOUNDDEF_ENTRYTYPE_PROGRAMMER.asInt()), FMOD_EVENT_SOUNDDEF_ENTRYTYPE_PROGRAMMER);
	}

	private final String name;
	private final int nativeValue;
	private FMOD_EVENT_SOUNDDEF_ENTRYTYPE(String name, int nativeValue) {
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
		if(object instanceof FMOD_EVENT_SOUNDDEF_ENTRYTYPE) {
			return asInt() == ((FMOD_EVENT_SOUNDDEF_ENTRYTYPE)object).asInt();
		}
		return false;
	}
	public int compareTo(Object object) {
		return asInt() - ((FMOD_EVENT_SOUNDDEF_ENTRYTYPE)object).asInt();
	}


	/**
	 * Retrieve a FMOD_EVENT_SOUNDDEF_ENTRYTYPE enum field with his integer value
	 * @param nativeValue the integer value of the field to retrieve
	 * @return the FMOD_EVENT_SOUNDDEF_ENTRYTYPE enum field that correspond to the integer value
	 */
	public static FMOD_EVENT_SOUNDDEF_ENTRYTYPE get(int nativeValue) {
		return (FMOD_EVENT_SOUNDDEF_ENTRYTYPE)VALUES.get(new Integer(nativeValue));
	}

	/**
	 * Retrieve a FMOD_EVENT_SOUNDDEF_ENTRYTYPE enum field from a Pointer
	 * @param pointer a pointer holding an FMOD_EVENT_SOUNDDEF_ENTRYTYPE enum field
	 * @return the FMOD_EVENT_SOUNDDEF_ENTRYTYPE enum field that correspond to the enum field in the pointer
	 */
	public static FMOD_EVENT_SOUNDDEF_ENTRYTYPE get(Pointer pointer) {
		return get(pointer.asInt());
	}

	/**
	 * @return an <code>Iterator</code> over the elements in this enumeration.<BR>
	 * Can be cast to <code>Iterator<FMOD_EVENT_SOUNDDEF_ENTRYTYPE></code> in Java 1.5.
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
