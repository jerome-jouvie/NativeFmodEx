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
 * Parameter types for the FMOD_DSP_TYPE_NORMALIZE filter.<BR>
 * <BR><U><B>Remarks</B></U><BR><BR>
 * Normalize amplifies the sound based on the maximum peaks within the signal.<BR>
 * For example if the maximum peaks in the signal were 50% of the bandwidth, it would scale the whole sound by 2.<BR>
 * The lower threshold value makes the normalizer ignores peaks below a certain point, to avoid over-amplification if a loud signal suddenly came in, and also to avoid amplifying to maximum things like background hiss.<BR>
 * Because FMOD is a realtime audio processor, it doesn't have the luxury of knowing the peak for the whole sound (ie it can't see into the future), so it has to process data as it comes in.<BR>
 * To avoid very sudden changes in volume level based on small samples of new data, fmod fades towards the desired amplification which makes for smooth gain control.  The fadetime parameter can control this.<BR>
 * <BR><U><B>Platforms Supported</B></U><BR><BR>
 * Win32, Win64, Linux, Linux64, Macintosh, Xbox360, PlayStation 2, PlayStation Portable, PlayStation 3, Wii, Solaris, iPhone<BR>
 * <BR><U><B>See Also</B></U><BR><BR>
 * DSP::setParameter<BR>
 * DSP::getParameter<BR>
 * FMOD_DSP_TYPE<BR>
 * 
 */
public class FMOD_DSP_NORMALIZE implements Enumeration, Comparable {
	/**  */
	public final static FMOD_DSP_NORMALIZE FMOD_DSP_NORMALIZE_FADETIME = new FMOD_DSP_NORMALIZE("FMOD_DSP_NORMALIZE_FADETIME", EnumerationJNI.get_FMOD_DSP_NORMALIZE_FADETIME());
	/**  */
	public final static FMOD_DSP_NORMALIZE FMOD_DSP_NORMALIZE_THRESHHOLD = new FMOD_DSP_NORMALIZE("FMOD_DSP_NORMALIZE_THRESHHOLD", EnumerationJNI.get_FMOD_DSP_NORMALIZE_THRESHHOLD());
	/**  */
	public final static FMOD_DSP_NORMALIZE FMOD_DSP_NORMALIZE_MAXAMP = new FMOD_DSP_NORMALIZE("FMOD_DSP_NORMALIZE_MAXAMP", EnumerationJNI.get_FMOD_DSP_NORMALIZE_MAXAMP());

	private final static HashMap VALUES = new HashMap(2*3);
	static {
		VALUES.put(new Integer(FMOD_DSP_NORMALIZE_FADETIME.asInt()), FMOD_DSP_NORMALIZE_FADETIME);
		VALUES.put(new Integer(FMOD_DSP_NORMALIZE_THRESHHOLD.asInt()), FMOD_DSP_NORMALIZE_THRESHHOLD);
		VALUES.put(new Integer(FMOD_DSP_NORMALIZE_MAXAMP.asInt()), FMOD_DSP_NORMALIZE_MAXAMP);
	}

	private final String name;
	private final int nativeValue;
	private FMOD_DSP_NORMALIZE(String name, int nativeValue) {
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
		if(object instanceof FMOD_DSP_NORMALIZE) {
			return asInt() == ((FMOD_DSP_NORMALIZE)object).asInt();
		}
		return false;
	}
	public int compareTo(Object object) {
		return asInt() - ((FMOD_DSP_NORMALIZE)object).asInt();
	}


	/**
	 * Retrieve a FMOD_DSP_NORMALIZE enum field with his integer value
	 * @param nativeValue the integer value of the field to retrieve
	 * @return the FMOD_DSP_NORMALIZE enum field that correspond to the integer value
	 */
	public static FMOD_DSP_NORMALIZE get(int nativeValue) {
		return (FMOD_DSP_NORMALIZE)VALUES.get(new Integer(nativeValue));
	}

	/**
	 * Retrieve a FMOD_DSP_NORMALIZE enum field from a Pointer
	 * @param pointer a pointer holding an FMOD_DSP_NORMALIZE enum field
	 * @return the FMOD_DSP_NORMALIZE enum field that correspond to the enum field in the pointer
	 */
	public static FMOD_DSP_NORMALIZE get(Pointer pointer) {
		return get(pointer.asInt());
	}

	/**
	 * @return an <code>Iterator</code> over the elements in this enumeration.<BR>
	 * Can be cast to <code>Iterator<FMOD_DSP_NORMALIZE></code> in Java 1.5.
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
