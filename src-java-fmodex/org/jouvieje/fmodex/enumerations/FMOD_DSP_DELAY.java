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
 * Parameter types for the FMOD_DSP_TYPE_DELAY filter.<BR>
 * <BR><U><B>Remarks</B></U><BR><BR>
 * Note.  Every time MaxDelay is changed, the plugin re-allocates the delay buffer.  This means the delay will dissapear at that time while it refills its new buffer.<BR>
 * A larger MaxDelay results in larger amounts of memory allocated.<BR>
 * Channel delays above MaxDelay will be clipped to MaxDelay and the delay buffer will not be resized.<BR>
 * <BR><U><B>Platforms Supported</B></U><BR><BR>
 * Win32, Win64, Linux, Linux64, Macintosh, Xbox360, PlayStation 2, PlayStation Portable, PlayStation 3, Wii, Solaris, iPhone<BR>
 * <BR><U><B>See Also</B></U><BR><BR>
 * DSP::setParameter<BR>
 * DSP::getParameter<BR>
 * FMOD_DSP_TYPE<BR>
 * 
 */
public class FMOD_DSP_DELAY implements Enumeration, Comparable {
	/**  */
	public final static FMOD_DSP_DELAY FMOD_DSP_DELAY_CH0 = new FMOD_DSP_DELAY("FMOD_DSP_DELAY_CH0", EnumerationJNI.get_FMOD_DSP_DELAY_CH0());
	/**  */
	public final static FMOD_DSP_DELAY FMOD_DSP_DELAY_CH1 = new FMOD_DSP_DELAY("FMOD_DSP_DELAY_CH1", EnumerationJNI.get_FMOD_DSP_DELAY_CH1());
	/**  */
	public final static FMOD_DSP_DELAY FMOD_DSP_DELAY_CH2 = new FMOD_DSP_DELAY("FMOD_DSP_DELAY_CH2", EnumerationJNI.get_FMOD_DSP_DELAY_CH2());
	/**  */
	public final static FMOD_DSP_DELAY FMOD_DSP_DELAY_CH3 = new FMOD_DSP_DELAY("FMOD_DSP_DELAY_CH3", EnumerationJNI.get_FMOD_DSP_DELAY_CH3());
	/**  */
	public final static FMOD_DSP_DELAY FMOD_DSP_DELAY_CH4 = new FMOD_DSP_DELAY("FMOD_DSP_DELAY_CH4", EnumerationJNI.get_FMOD_DSP_DELAY_CH4());
	/**  */
	public final static FMOD_DSP_DELAY FMOD_DSP_DELAY_CH5 = new FMOD_DSP_DELAY("FMOD_DSP_DELAY_CH5", EnumerationJNI.get_FMOD_DSP_DELAY_CH5());
	/**  */
	public final static FMOD_DSP_DELAY FMOD_DSP_DELAY_CH6 = new FMOD_DSP_DELAY("FMOD_DSP_DELAY_CH6", EnumerationJNI.get_FMOD_DSP_DELAY_CH6());
	/**  */
	public final static FMOD_DSP_DELAY FMOD_DSP_DELAY_CH7 = new FMOD_DSP_DELAY("FMOD_DSP_DELAY_CH7", EnumerationJNI.get_FMOD_DSP_DELAY_CH7());
	/**  */
	public final static FMOD_DSP_DELAY FMOD_DSP_DELAY_CH8 = new FMOD_DSP_DELAY("FMOD_DSP_DELAY_CH8", EnumerationJNI.get_FMOD_DSP_DELAY_CH8());
	/**  */
	public final static FMOD_DSP_DELAY FMOD_DSP_DELAY_CH9 = new FMOD_DSP_DELAY("FMOD_DSP_DELAY_CH9", EnumerationJNI.get_FMOD_DSP_DELAY_CH9());
	/**  */
	public final static FMOD_DSP_DELAY FMOD_DSP_DELAY_CH10 = new FMOD_DSP_DELAY("FMOD_DSP_DELAY_CH10", EnumerationJNI.get_FMOD_DSP_DELAY_CH10());
	/**  */
	public final static FMOD_DSP_DELAY FMOD_DSP_DELAY_CH11 = new FMOD_DSP_DELAY("FMOD_DSP_DELAY_CH11", EnumerationJNI.get_FMOD_DSP_DELAY_CH11());
	/**  */
	public final static FMOD_DSP_DELAY FMOD_DSP_DELAY_CH12 = new FMOD_DSP_DELAY("FMOD_DSP_DELAY_CH12", EnumerationJNI.get_FMOD_DSP_DELAY_CH12());
	/**  */
	public final static FMOD_DSP_DELAY FMOD_DSP_DELAY_CH13 = new FMOD_DSP_DELAY("FMOD_DSP_DELAY_CH13", EnumerationJNI.get_FMOD_DSP_DELAY_CH13());
	/**  */
	public final static FMOD_DSP_DELAY FMOD_DSP_DELAY_CH14 = new FMOD_DSP_DELAY("FMOD_DSP_DELAY_CH14", EnumerationJNI.get_FMOD_DSP_DELAY_CH14());
	/**  */
	public final static FMOD_DSP_DELAY FMOD_DSP_DELAY_CH15 = new FMOD_DSP_DELAY("FMOD_DSP_DELAY_CH15", EnumerationJNI.get_FMOD_DSP_DELAY_CH15());
	/**  */
	public final static FMOD_DSP_DELAY FMOD_DSP_DELAY_MAXDELAY = new FMOD_DSP_DELAY("FMOD_DSP_DELAY_MAXDELAY", EnumerationJNI.get_FMOD_DSP_DELAY_MAXDELAY());

	private final static HashMap VALUES = new HashMap(2*17);
	static {
		VALUES.put(new Integer(FMOD_DSP_DELAY_CH0.asInt()), FMOD_DSP_DELAY_CH0);
		VALUES.put(new Integer(FMOD_DSP_DELAY_CH1.asInt()), FMOD_DSP_DELAY_CH1);
		VALUES.put(new Integer(FMOD_DSP_DELAY_CH2.asInt()), FMOD_DSP_DELAY_CH2);
		VALUES.put(new Integer(FMOD_DSP_DELAY_CH3.asInt()), FMOD_DSP_DELAY_CH3);
		VALUES.put(new Integer(FMOD_DSP_DELAY_CH4.asInt()), FMOD_DSP_DELAY_CH4);
		VALUES.put(new Integer(FMOD_DSP_DELAY_CH5.asInt()), FMOD_DSP_DELAY_CH5);
		VALUES.put(new Integer(FMOD_DSP_DELAY_CH6.asInt()), FMOD_DSP_DELAY_CH6);
		VALUES.put(new Integer(FMOD_DSP_DELAY_CH7.asInt()), FMOD_DSP_DELAY_CH7);
		VALUES.put(new Integer(FMOD_DSP_DELAY_CH8.asInt()), FMOD_DSP_DELAY_CH8);
		VALUES.put(new Integer(FMOD_DSP_DELAY_CH9.asInt()), FMOD_DSP_DELAY_CH9);
		VALUES.put(new Integer(FMOD_DSP_DELAY_CH10.asInt()), FMOD_DSP_DELAY_CH10);
		VALUES.put(new Integer(FMOD_DSP_DELAY_CH11.asInt()), FMOD_DSP_DELAY_CH11);
		VALUES.put(new Integer(FMOD_DSP_DELAY_CH12.asInt()), FMOD_DSP_DELAY_CH12);
		VALUES.put(new Integer(FMOD_DSP_DELAY_CH13.asInt()), FMOD_DSP_DELAY_CH13);
		VALUES.put(new Integer(FMOD_DSP_DELAY_CH14.asInt()), FMOD_DSP_DELAY_CH14);
		VALUES.put(new Integer(FMOD_DSP_DELAY_CH15.asInt()), FMOD_DSP_DELAY_CH15);
		VALUES.put(new Integer(FMOD_DSP_DELAY_MAXDELAY.asInt()), FMOD_DSP_DELAY_MAXDELAY);
	}

	private final String name;
	private final int nativeValue;
	private FMOD_DSP_DELAY(String name, int nativeValue) {
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
		if(object instanceof FMOD_DSP_DELAY) {
			return asInt() == ((FMOD_DSP_DELAY)object).asInt();
		}
		return false;
	}
	public int compareTo(Object object) {
		return asInt() - ((FMOD_DSP_DELAY)object).asInt();
	}


	/**
	 * Retrieve a FMOD_DSP_DELAY enum field with his integer value
	 * @param nativeValue the integer value of the field to retrieve
	 * @return the FMOD_DSP_DELAY enum field that correspond to the integer value
	 */
	public static FMOD_DSP_DELAY get(int nativeValue) {
		return (FMOD_DSP_DELAY)VALUES.get(new Integer(nativeValue));
	}

	/**
	 * Retrieve a FMOD_DSP_DELAY enum field from a Pointer
	 * @param pointer a pointer holding an FMOD_DSP_DELAY enum field
	 * @return the FMOD_DSP_DELAY enum field that correspond to the enum field in the pointer
	 */
	public static FMOD_DSP_DELAY get(Pointer pointer) {
		return get(pointer.asInt());
	}

	/**
	 * @return an <code>Iterator</code> over the elements in this enumeration.<BR>
	 * Can be cast to <code>Iterator<FMOD_DSP_DELAY></code> in Java 1.5.
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
