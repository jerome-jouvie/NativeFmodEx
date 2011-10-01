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
 * Types of delay that can be used with Channel::setDelay / Channel::getDelay.<BR>
 * <BR><U><B>Remarks</B></U><BR><BR>
 * If you haven't called Channel::setDelay yet, if you call Channel::getDelay with FMOD_DELAYTYPE_DSPCLOCK_START it will return the<BR>
 * equivalent global DSP clock value to determine when a channel started, so that you can use it for other channels to sync against.<BR>
 * Use System::getDSPClock to also get the current dspclock time, a base for future calls to Channel::setDelay.<BR>
 * Use FMOD_64BIT_ADD or FMOD_64BIT_SUB to add a hi/lo combination together and cope with wraparound.<BR>
 * If FMOD_DELAYTYPE_END_MS is specified, the value is not treated as a 64 bit number, just the delayhi value is used and it is treated as milliseconds.<BR>
 * <BR><U><B>Platforms Supported</B></U><BR><BR>
 * Win32, Win64, Linux, Linux64, Macintosh, Xbox360, PlayStation 2, PlayStation Portable, PlayStation 3, Wii, Solaris, iPhone<BR>
 * <BR><U><B>See Also</B></U><BR><BR>
 * Channel::setDelay<BR>
 * Channel::getDelay<BR>
 * System::getDSPClock<BR>
 * 
 */
public class FMOD_DELAYTYPE implements Enumeration, Comparable {
	/**  */
	public final static FMOD_DELAYTYPE FMOD_DELAYTYPE_END_MS = new FMOD_DELAYTYPE("FMOD_DELAYTYPE_END_MS", EnumerationJNI.get_FMOD_DELAYTYPE_END_MS());
	/**  */
	public final static FMOD_DELAYTYPE FMOD_DELAYTYPE_DSPCLOCK_START = new FMOD_DELAYTYPE("FMOD_DELAYTYPE_DSPCLOCK_START", EnumerationJNI.get_FMOD_DELAYTYPE_DSPCLOCK_START());
	/**  */
	public final static FMOD_DELAYTYPE FMOD_DELAYTYPE_DSPCLOCK_END = new FMOD_DELAYTYPE("FMOD_DELAYTYPE_DSPCLOCK_END", EnumerationJNI.get_FMOD_DELAYTYPE_DSPCLOCK_END());
	/**  */
	public final static FMOD_DELAYTYPE FMOD_DELAYTYPE_DSPCLOCK_PAUSE = new FMOD_DELAYTYPE("FMOD_DELAYTYPE_DSPCLOCK_PAUSE", EnumerationJNI.get_FMOD_DELAYTYPE_DSPCLOCK_PAUSE());
	/**  */
	public final static FMOD_DELAYTYPE FMOD_DELAYTYPE_MAX = new FMOD_DELAYTYPE("FMOD_DELAYTYPE_MAX", EnumerationJNI.get_FMOD_DELAYTYPE_MAX());
	/**  */
	public final static FMOD_DELAYTYPE FMOD_DELAYTYPE_FORCEINT = new FMOD_DELAYTYPE("FMOD_DELAYTYPE_FORCEINT", 65536);

	private final static HashMap VALUES = new HashMap(2*6);
	static {
		VALUES.put(new Integer(FMOD_DELAYTYPE_END_MS.asInt()), FMOD_DELAYTYPE_END_MS);
		VALUES.put(new Integer(FMOD_DELAYTYPE_DSPCLOCK_START.asInt()), FMOD_DELAYTYPE_DSPCLOCK_START);
		VALUES.put(new Integer(FMOD_DELAYTYPE_DSPCLOCK_END.asInt()), FMOD_DELAYTYPE_DSPCLOCK_END);
		VALUES.put(new Integer(FMOD_DELAYTYPE_DSPCLOCK_PAUSE.asInt()), FMOD_DELAYTYPE_DSPCLOCK_PAUSE);
		VALUES.put(new Integer(FMOD_DELAYTYPE_MAX.asInt()), FMOD_DELAYTYPE_MAX);
		VALUES.put(new Integer(FMOD_DELAYTYPE_FORCEINT.asInt()), FMOD_DELAYTYPE_FORCEINT);
	}

	private final String name;
	private final int nativeValue;
	private FMOD_DELAYTYPE(String name, int nativeValue) {
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
		if(object instanceof FMOD_DELAYTYPE) {
			return asInt() == ((FMOD_DELAYTYPE)object).asInt();
		}
		return false;
	}
	public int compareTo(Object object) {
		return asInt() - ((FMOD_DELAYTYPE)object).asInt();
	}


	/**
	 * Retrieve a FMOD_DELAYTYPE enum field with his integer value
	 * @param nativeValue the integer value of the field to retrieve
	 * @return the FMOD_DELAYTYPE enum field that correspond to the integer value
	 */
	public static FMOD_DELAYTYPE get(int nativeValue) {
		return (FMOD_DELAYTYPE)VALUES.get(new Integer(nativeValue));
	}

	/**
	 * Retrieve a FMOD_DELAYTYPE enum field from a Pointer
	 * @param pointer a pointer holding an FMOD_DELAYTYPE enum field
	 * @return the FMOD_DELAYTYPE enum field that correspond to the enum field in the pointer
	 */
	public static FMOD_DELAYTYPE get(Pointer pointer) {
		return get(pointer.asInt());
	}

	/**
	 * @return an <code>Iterator</code> over the elements in this enumeration.<BR>
	 * Can be cast to <code>Iterator<FMOD_DELAYTYPE></code> in Java 1.5.
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
