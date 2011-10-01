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
 * Parameter types for the FMOD_DSP_TYPE_TREMOLO filter.<BR>
 * <BR><U><B>Remarks</B></U><BR><BR>
 * The tremolo effect varies the amplitude of a sound. Depending on the settings, this unit can produce a tremolo, chopper or auto-pan effect.<BR>
 * The shape of the LFO (low freq. oscillator) can morphed between sine, triangle and sawtooth waves using the FMOD_DSP_TREMOLO_SHAPE and FMOD_DSP_TREMOLO_SKEW parameters.<BR>
 * FMOD_DSP_TREMOLO_DUTY and FMOD_DSP_TREMOLO_SQUARE are useful for a chopper-type effect where the first controls the on-time duration and second controls the flatness of the envelope.<BR>
 * FMOD_DSP_TREMOLO_SPREAD varies the LFO phase between channels to get an auto-pan effect. This works best with a sine shape LFO.<BR>
 * The LFO can be synchronized using the FMOD_DSP_TREMOLO_PHASE parameter which sets its instantaneous phase.<BR>
 * <BR><U><B>Platforms Supported</B></U><BR><BR>
 * Win32, Win64, Linux, Linux64, Macintosh, Xbox360, PlayStation 2, PlayStation Portable, PlayStation 3, Wii, Solaris, iPhone<BR>
 * <BR><U><B>See Also</B></U><BR><BR>
 * DSP::setParameter<BR>
 * DSP::getParameter<BR>
 * FMOD_DSP_TYPE<BR>
 * 
 */
public class FMOD_DSP_TREMOLO implements Enumeration, Comparable {
	/**  */
	public final static FMOD_DSP_TREMOLO FMOD_DSP_TREMOLO_FREQUENCY = new FMOD_DSP_TREMOLO("FMOD_DSP_TREMOLO_FREQUENCY", EnumerationJNI.get_FMOD_DSP_TREMOLO_FREQUENCY());
	/**  */
	public final static FMOD_DSP_TREMOLO FMOD_DSP_TREMOLO_DEPTH = new FMOD_DSP_TREMOLO("FMOD_DSP_TREMOLO_DEPTH", EnumerationJNI.get_FMOD_DSP_TREMOLO_DEPTH());
	/**  */
	public final static FMOD_DSP_TREMOLO FMOD_DSP_TREMOLO_SHAPE = new FMOD_DSP_TREMOLO("FMOD_DSP_TREMOLO_SHAPE", EnumerationJNI.get_FMOD_DSP_TREMOLO_SHAPE());
	/**  */
	public final static FMOD_DSP_TREMOLO FMOD_DSP_TREMOLO_SKEW = new FMOD_DSP_TREMOLO("FMOD_DSP_TREMOLO_SKEW", EnumerationJNI.get_FMOD_DSP_TREMOLO_SKEW());
	/**  */
	public final static FMOD_DSP_TREMOLO FMOD_DSP_TREMOLO_DUTY = new FMOD_DSP_TREMOLO("FMOD_DSP_TREMOLO_DUTY", EnumerationJNI.get_FMOD_DSP_TREMOLO_DUTY());
	/**  */
	public final static FMOD_DSP_TREMOLO FMOD_DSP_TREMOLO_SQUARE = new FMOD_DSP_TREMOLO("FMOD_DSP_TREMOLO_SQUARE", EnumerationJNI.get_FMOD_DSP_TREMOLO_SQUARE());
	/**  */
	public final static FMOD_DSP_TREMOLO FMOD_DSP_TREMOLO_PHASE = new FMOD_DSP_TREMOLO("FMOD_DSP_TREMOLO_PHASE", EnumerationJNI.get_FMOD_DSP_TREMOLO_PHASE());
	/**  */
	public final static FMOD_DSP_TREMOLO FMOD_DSP_TREMOLO_SPREAD = new FMOD_DSP_TREMOLO("FMOD_DSP_TREMOLO_SPREAD", EnumerationJNI.get_FMOD_DSP_TREMOLO_SPREAD());

	private final static HashMap VALUES = new HashMap(2*8);
	static {
		VALUES.put(new Integer(FMOD_DSP_TREMOLO_FREQUENCY.asInt()), FMOD_DSP_TREMOLO_FREQUENCY);
		VALUES.put(new Integer(FMOD_DSP_TREMOLO_DEPTH.asInt()), FMOD_DSP_TREMOLO_DEPTH);
		VALUES.put(new Integer(FMOD_DSP_TREMOLO_SHAPE.asInt()), FMOD_DSP_TREMOLO_SHAPE);
		VALUES.put(new Integer(FMOD_DSP_TREMOLO_SKEW.asInt()), FMOD_DSP_TREMOLO_SKEW);
		VALUES.put(new Integer(FMOD_DSP_TREMOLO_DUTY.asInt()), FMOD_DSP_TREMOLO_DUTY);
		VALUES.put(new Integer(FMOD_DSP_TREMOLO_SQUARE.asInt()), FMOD_DSP_TREMOLO_SQUARE);
		VALUES.put(new Integer(FMOD_DSP_TREMOLO_PHASE.asInt()), FMOD_DSP_TREMOLO_PHASE);
		VALUES.put(new Integer(FMOD_DSP_TREMOLO_SPREAD.asInt()), FMOD_DSP_TREMOLO_SPREAD);
	}

	private final String name;
	private final int nativeValue;
	private FMOD_DSP_TREMOLO(String name, int nativeValue) {
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
		if(object instanceof FMOD_DSP_TREMOLO) {
			return asInt() == ((FMOD_DSP_TREMOLO)object).asInt();
		}
		return false;
	}
	public int compareTo(Object object) {
		return asInt() - ((FMOD_DSP_TREMOLO)object).asInt();
	}


	/**
	 * Retrieve a FMOD_DSP_TREMOLO enum field with his integer value
	 * @param nativeValue the integer value of the field to retrieve
	 * @return the FMOD_DSP_TREMOLO enum field that correspond to the integer value
	 */
	public static FMOD_DSP_TREMOLO get(int nativeValue) {
		return (FMOD_DSP_TREMOLO)VALUES.get(new Integer(nativeValue));
	}

	/**
	 * Retrieve a FMOD_DSP_TREMOLO enum field from a Pointer
	 * @param pointer a pointer holding an FMOD_DSP_TREMOLO enum field
	 * @return the FMOD_DSP_TREMOLO enum field that correspond to the enum field in the pointer
	 */
	public static FMOD_DSP_TREMOLO get(Pointer pointer) {
		return get(pointer.asInt());
	}

	/**
	 * @return an <code>Iterator</code> over the elements in this enumeration.<BR>
	 * Can be cast to <code>Iterator<FMOD_DSP_TREMOLO></code> in Java 1.5.
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
