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
 * Parameter types for the FMOD_DSP_TYPE_CHORUS filter.<BR>
 * <BR><U><B>Remarks</B></U><BR><BR>
 * Chrous is an effect where the sound is more 'spacious' due to 1 to 3 versions of the sound being played along side the original signal but with the pitch of each copy modulating on a sine wave.<BR>
 * This is a highly configurable chorus unit.  It supports 3 taps, small and large delay times and also feedback.<BR>
 * This unit also could be used to do a simple echo, or a flange effect.<BR>
 * <BR><U><B>Platforms Supported</B></U><BR><BR>
 * Win32, Win64, Linux, Linux64, Macintosh, Xbox360, PlayStation 2, PlayStation Portable, PlayStation 3, Wii, Solaris, iPhone<BR>
 * <BR><U><B>See Also</B></U><BR><BR>
 * DSP::setParameter<BR>
 * DSP::getParameter<BR>
 * FMOD_DSP_TYPE<BR>
 * 
 */
public class FMOD_DSP_CHORUS implements Enumeration, Comparable {
	/**  */
	public final static FMOD_DSP_CHORUS FMOD_DSP_CHORUS_DRYMIX = new FMOD_DSP_CHORUS("FMOD_DSP_CHORUS_DRYMIX", EnumerationJNI.get_FMOD_DSP_CHORUS_DRYMIX());
	/**  */
	public final static FMOD_DSP_CHORUS FMOD_DSP_CHORUS_WETMIX1 = new FMOD_DSP_CHORUS("FMOD_DSP_CHORUS_WETMIX1", EnumerationJNI.get_FMOD_DSP_CHORUS_WETMIX1());
	/**  */
	public final static FMOD_DSP_CHORUS FMOD_DSP_CHORUS_WETMIX2 = new FMOD_DSP_CHORUS("FMOD_DSP_CHORUS_WETMIX2", EnumerationJNI.get_FMOD_DSP_CHORUS_WETMIX2());
	/**  */
	public final static FMOD_DSP_CHORUS FMOD_DSP_CHORUS_WETMIX3 = new FMOD_DSP_CHORUS("FMOD_DSP_CHORUS_WETMIX3", EnumerationJNI.get_FMOD_DSP_CHORUS_WETMIX3());
	/**  */
	public final static FMOD_DSP_CHORUS FMOD_DSP_CHORUS_DELAY = new FMOD_DSP_CHORUS("FMOD_DSP_CHORUS_DELAY", EnumerationJNI.get_FMOD_DSP_CHORUS_DELAY());
	/**  */
	public final static FMOD_DSP_CHORUS FMOD_DSP_CHORUS_RATE = new FMOD_DSP_CHORUS("FMOD_DSP_CHORUS_RATE", EnumerationJNI.get_FMOD_DSP_CHORUS_RATE());
	/**  */
	public final static FMOD_DSP_CHORUS FMOD_DSP_CHORUS_DEPTH = new FMOD_DSP_CHORUS("FMOD_DSP_CHORUS_DEPTH", EnumerationJNI.get_FMOD_DSP_CHORUS_DEPTH());
	/**  */
	public final static FMOD_DSP_CHORUS FMOD_DSP_CHORUS_FEEDBACK = new FMOD_DSP_CHORUS("FMOD_DSP_CHORUS_FEEDBACK", EnumerationJNI.get_FMOD_DSP_CHORUS_FEEDBACK());

	private final static HashMap VALUES = new HashMap(2*8);
	static {
		VALUES.put(new Integer(FMOD_DSP_CHORUS_DRYMIX.asInt()), FMOD_DSP_CHORUS_DRYMIX);
		VALUES.put(new Integer(FMOD_DSP_CHORUS_WETMIX1.asInt()), FMOD_DSP_CHORUS_WETMIX1);
		VALUES.put(new Integer(FMOD_DSP_CHORUS_WETMIX2.asInt()), FMOD_DSP_CHORUS_WETMIX2);
		VALUES.put(new Integer(FMOD_DSP_CHORUS_WETMIX3.asInt()), FMOD_DSP_CHORUS_WETMIX3);
		VALUES.put(new Integer(FMOD_DSP_CHORUS_DELAY.asInt()), FMOD_DSP_CHORUS_DELAY);
		VALUES.put(new Integer(FMOD_DSP_CHORUS_RATE.asInt()), FMOD_DSP_CHORUS_RATE);
		VALUES.put(new Integer(FMOD_DSP_CHORUS_DEPTH.asInt()), FMOD_DSP_CHORUS_DEPTH);
		VALUES.put(new Integer(FMOD_DSP_CHORUS_FEEDBACK.asInt()), FMOD_DSP_CHORUS_FEEDBACK);
	}

	private final String name;
	private final int nativeValue;
	private FMOD_DSP_CHORUS(String name, int nativeValue) {
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
		if(object instanceof FMOD_DSP_CHORUS) {
			return asInt() == ((FMOD_DSP_CHORUS)object).asInt();
		}
		return false;
	}
	public int compareTo(Object object) {
		return asInt() - ((FMOD_DSP_CHORUS)object).asInt();
	}


	/**
	 * Retrieve a FMOD_DSP_CHORUS enum field with his integer value
	 * @param nativeValue the integer value of the field to retrieve
	 * @return the FMOD_DSP_CHORUS enum field that correspond to the integer value
	 */
	public static FMOD_DSP_CHORUS get(int nativeValue) {
		return (FMOD_DSP_CHORUS)VALUES.get(new Integer(nativeValue));
	}

	/**
	 * Retrieve a FMOD_DSP_CHORUS enum field from a Pointer
	 * @param pointer a pointer holding an FMOD_DSP_CHORUS enum field
	 * @return the FMOD_DSP_CHORUS enum field that correspond to the enum field in the pointer
	 */
	public static FMOD_DSP_CHORUS get(Pointer pointer) {
		return get(pointer.asInt());
	}

	/**
	 * @return an <code>Iterator</code> over the elements in this enumeration.<BR>
	 * Can be cast to <code>Iterator<FMOD_DSP_CHORUS></code> in Java 1.5.
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
