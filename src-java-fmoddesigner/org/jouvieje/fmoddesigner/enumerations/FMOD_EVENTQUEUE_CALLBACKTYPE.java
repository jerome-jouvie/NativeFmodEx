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
 * These callback types are used with FMOD_EVENTQUEUE_CALLBACK.<BR>
 * <BR><U><B>Remarks</B></U><BR><BR>
 * <b>Note!</b> Currently the user must call EventSystem::update for these callbacks to trigger!<p><BR>
 * <BR><U><B>Platforms Supported</B></U><BR><BR>
 * Win32, Win64, Linux, Macintosh, Xbox, Xbox360, PlayStation 2, GameCube, PlayStation Portable, PlayStation 3, Wii<BR>
 * <BR><U><B>See Also</B></U><BR><BR>
 * EventQueue::setCallback<BR>
 * FMOD_EVENTQUEUE_CALLBACK<BR>
 * EventSystem::update<BR>
 * 
 */
public class FMOD_EVENTQUEUE_CALLBACKTYPE implements Enumeration, Comparable {
	/**  */
	public final static FMOD_EVENTQUEUE_CALLBACKTYPE FMOD_EVENTQUEUE_CALLBACKTYPE_PREPARE = new FMOD_EVENTQUEUE_CALLBACKTYPE("FMOD_EVENTQUEUE_CALLBACKTYPE_PREPARE", EnumerationJNI.get_FMOD_EVENTQUEUE_CALLBACKTYPE_PREPARE());
	/**  */
	public final static FMOD_EVENTQUEUE_CALLBACKTYPE FMOD_EVENTQUEUE_CALLBACKTYPE_ABOUTTOPLAY = new FMOD_EVENTQUEUE_CALLBACKTYPE("FMOD_EVENTQUEUE_CALLBACKTYPE_ABOUTTOPLAY", EnumerationJNI.get_FMOD_EVENTQUEUE_CALLBACKTYPE_ABOUTTOPLAY());
	/**  */
	public final static FMOD_EVENTQUEUE_CALLBACKTYPE FMOD_EVENTQUEUE_CALLBACKTYPE_FINISHED = new FMOD_EVENTQUEUE_CALLBACKTYPE("FMOD_EVENTQUEUE_CALLBACKTYPE_FINISHED", EnumerationJNI.get_FMOD_EVENTQUEUE_CALLBACKTYPE_FINISHED());
	/**  */
	public final static FMOD_EVENTQUEUE_CALLBACKTYPE FMOD_EVENTQUEUE_CALLBACKTYPE_EXPIRED = new FMOD_EVENTQUEUE_CALLBACKTYPE("FMOD_EVENTQUEUE_CALLBACKTYPE_EXPIRED", EnumerationJNI.get_FMOD_EVENTQUEUE_CALLBACKTYPE_EXPIRED());

	private final static HashMap VALUES = new HashMap(2*4);
	static {
		VALUES.put(new Integer(FMOD_EVENTQUEUE_CALLBACKTYPE_PREPARE.asInt()), FMOD_EVENTQUEUE_CALLBACKTYPE_PREPARE);
		VALUES.put(new Integer(FMOD_EVENTQUEUE_CALLBACKTYPE_ABOUTTOPLAY.asInt()), FMOD_EVENTQUEUE_CALLBACKTYPE_ABOUTTOPLAY);
		VALUES.put(new Integer(FMOD_EVENTQUEUE_CALLBACKTYPE_FINISHED.asInt()), FMOD_EVENTQUEUE_CALLBACKTYPE_FINISHED);
		VALUES.put(new Integer(FMOD_EVENTQUEUE_CALLBACKTYPE_EXPIRED.asInt()), FMOD_EVENTQUEUE_CALLBACKTYPE_EXPIRED);
	}

	private final String name;
	private final int nativeValue;
	private FMOD_EVENTQUEUE_CALLBACKTYPE(String name, int nativeValue) {
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
		if(object instanceof FMOD_EVENTQUEUE_CALLBACKTYPE) {
			return asInt() == ((FMOD_EVENTQUEUE_CALLBACKTYPE)object).asInt();
		}
		return false;
	}
	public int compareTo(Object object) {
		return asInt() - ((FMOD_EVENTQUEUE_CALLBACKTYPE)object).asInt();
	}


	/**
	 * Retrieve a FMOD_EVENTQUEUE_CALLBACKTYPE enum field with his integer value
	 * @param nativeValue the integer value of the field to retrieve
	 * @return the FMOD_EVENTQUEUE_CALLBACKTYPE enum field that correspond to the integer value
	 */
	public static FMOD_EVENTQUEUE_CALLBACKTYPE get(int nativeValue) {
		return (FMOD_EVENTQUEUE_CALLBACKTYPE)VALUES.get(new Integer(nativeValue));
	}

	/**
	 * Retrieve a FMOD_EVENTQUEUE_CALLBACKTYPE enum field from a Pointer
	 * @param pointer a pointer holding an FMOD_EVENTQUEUE_CALLBACKTYPE enum field
	 * @return the FMOD_EVENTQUEUE_CALLBACKTYPE enum field that correspond to the enum field in the pointer
	 */
	public static FMOD_EVENTQUEUE_CALLBACKTYPE get(Pointer pointer) {
		return get(pointer.asInt());
	}

	/**
	 * @return an <code>Iterator</code> over the elements in this enumeration.<BR>
	 * Can be cast to <code>Iterator<FMOD_EVENTQUEUE_CALLBACKTYPE></code> in Java 1.5.
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
