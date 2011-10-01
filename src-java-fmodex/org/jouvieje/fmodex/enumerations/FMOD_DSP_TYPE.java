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
 * These definitions can be used for creating FMOD defined special effects or DSP units.<BR>
 * <BR><U><B>Remarks</B></U><BR><BR>
 * To get them to be active, first create the unit, then add it somewhere into the DSP network, either at the front of the network near the soundcard unit to affect the global output (by using System::getDSPHead), or on a single channel (using Channel::getDSPHead).<BR>
 * <BR><U><B>Platforms Supported</B></U><BR><BR>
 * Win32, Win64, Linux, Linux64, Macintosh, Xbox360, PlayStation 2, PlayStation Portable, PlayStation 3, Wii, Solaris, iPhone<BR>
 * <BR><U><B>See Also</B></U><BR><BR>
 * System::createDSPByType<BR>
 * 
 */
public class FMOD_DSP_TYPE implements Enumeration, Comparable {
	/**  */
	public final static FMOD_DSP_TYPE FMOD_DSP_TYPE_UNKNOWN = new FMOD_DSP_TYPE("FMOD_DSP_TYPE_UNKNOWN", EnumerationJNI.get_FMOD_DSP_TYPE_UNKNOWN());
	/**  */
	public final static FMOD_DSP_TYPE FMOD_DSP_TYPE_MIXER = new FMOD_DSP_TYPE("FMOD_DSP_TYPE_MIXER", EnumerationJNI.get_FMOD_DSP_TYPE_MIXER());
	/**  */
	public final static FMOD_DSP_TYPE FMOD_DSP_TYPE_OSCILLATOR = new FMOD_DSP_TYPE("FMOD_DSP_TYPE_OSCILLATOR", EnumerationJNI.get_FMOD_DSP_TYPE_OSCILLATOR());
	/**  */
	public final static FMOD_DSP_TYPE FMOD_DSP_TYPE_LOWPASS = new FMOD_DSP_TYPE("FMOD_DSP_TYPE_LOWPASS", EnumerationJNI.get_FMOD_DSP_TYPE_LOWPASS());
	/**  */
	public final static FMOD_DSP_TYPE FMOD_DSP_TYPE_ITLOWPASS = new FMOD_DSP_TYPE("FMOD_DSP_TYPE_ITLOWPASS", EnumerationJNI.get_FMOD_DSP_TYPE_ITLOWPASS());
	/**  */
	public final static FMOD_DSP_TYPE FMOD_DSP_TYPE_HIGHPASS = new FMOD_DSP_TYPE("FMOD_DSP_TYPE_HIGHPASS", EnumerationJNI.get_FMOD_DSP_TYPE_HIGHPASS());
	/**  */
	public final static FMOD_DSP_TYPE FMOD_DSP_TYPE_ECHO = new FMOD_DSP_TYPE("FMOD_DSP_TYPE_ECHO", EnumerationJNI.get_FMOD_DSP_TYPE_ECHO());
	/**  */
	public final static FMOD_DSP_TYPE FMOD_DSP_TYPE_FLANGE = new FMOD_DSP_TYPE("FMOD_DSP_TYPE_FLANGE", EnumerationJNI.get_FMOD_DSP_TYPE_FLANGE());
	/**  */
	public final static FMOD_DSP_TYPE FMOD_DSP_TYPE_DISTORTION = new FMOD_DSP_TYPE("FMOD_DSP_TYPE_DISTORTION", EnumerationJNI.get_FMOD_DSP_TYPE_DISTORTION());
	/**  */
	public final static FMOD_DSP_TYPE FMOD_DSP_TYPE_NORMALIZE = new FMOD_DSP_TYPE("FMOD_DSP_TYPE_NORMALIZE", EnumerationJNI.get_FMOD_DSP_TYPE_NORMALIZE());
	/**  */
	public final static FMOD_DSP_TYPE FMOD_DSP_TYPE_PARAMEQ = new FMOD_DSP_TYPE("FMOD_DSP_TYPE_PARAMEQ", EnumerationJNI.get_FMOD_DSP_TYPE_PARAMEQ());
	/**  */
	public final static FMOD_DSP_TYPE FMOD_DSP_TYPE_PITCHSHIFT = new FMOD_DSP_TYPE("FMOD_DSP_TYPE_PITCHSHIFT", EnumerationJNI.get_FMOD_DSP_TYPE_PITCHSHIFT());
	/**  */
	public final static FMOD_DSP_TYPE FMOD_DSP_TYPE_CHORUS = new FMOD_DSP_TYPE("FMOD_DSP_TYPE_CHORUS", EnumerationJNI.get_FMOD_DSP_TYPE_CHORUS());
	/**  */
	public final static FMOD_DSP_TYPE FMOD_DSP_TYPE_REVERB = new FMOD_DSP_TYPE("FMOD_DSP_TYPE_REVERB", EnumerationJNI.get_FMOD_DSP_TYPE_REVERB());
	/**  */
	public final static FMOD_DSP_TYPE FMOD_DSP_TYPE_VSTPLUGIN = new FMOD_DSP_TYPE("FMOD_DSP_TYPE_VSTPLUGIN", EnumerationJNI.get_FMOD_DSP_TYPE_VSTPLUGIN());
	/**  */
	public final static FMOD_DSP_TYPE FMOD_DSP_TYPE_WINAMPPLUGIN = new FMOD_DSP_TYPE("FMOD_DSP_TYPE_WINAMPPLUGIN", EnumerationJNI.get_FMOD_DSP_TYPE_WINAMPPLUGIN());
	/**  */
	public final static FMOD_DSP_TYPE FMOD_DSP_TYPE_ITECHO = new FMOD_DSP_TYPE("FMOD_DSP_TYPE_ITECHO", EnumerationJNI.get_FMOD_DSP_TYPE_ITECHO());
	/**  */
	public final static FMOD_DSP_TYPE FMOD_DSP_TYPE_COMPRESSOR = new FMOD_DSP_TYPE("FMOD_DSP_TYPE_COMPRESSOR", EnumerationJNI.get_FMOD_DSP_TYPE_COMPRESSOR());
	/**  */
	public final static FMOD_DSP_TYPE FMOD_DSP_TYPE_SFXREVERB = new FMOD_DSP_TYPE("FMOD_DSP_TYPE_SFXREVERB", EnumerationJNI.get_FMOD_DSP_TYPE_SFXREVERB());
	/**  */
	public final static FMOD_DSP_TYPE FMOD_DSP_TYPE_LOWPASS_SIMPLE = new FMOD_DSP_TYPE("FMOD_DSP_TYPE_LOWPASS_SIMPLE", EnumerationJNI.get_FMOD_DSP_TYPE_LOWPASS_SIMPLE());
	/**  */
	public final static FMOD_DSP_TYPE FMOD_DSP_TYPE_DELAY = new FMOD_DSP_TYPE("FMOD_DSP_TYPE_DELAY", EnumerationJNI.get_FMOD_DSP_TYPE_DELAY());
	/**  */
	public final static FMOD_DSP_TYPE FMOD_DSP_TYPE_TREMOLO = new FMOD_DSP_TYPE("FMOD_DSP_TYPE_TREMOLO", EnumerationJNI.get_FMOD_DSP_TYPE_TREMOLO());
	/**  */
	public final static FMOD_DSP_TYPE FMOD_DSP_TYPE_FORCEINT = new FMOD_DSP_TYPE("FMOD_DSP_TYPE_FORCEINT", 65536);

	private final static HashMap VALUES = new HashMap(2*23);
	static {
		VALUES.put(new Integer(FMOD_DSP_TYPE_UNKNOWN.asInt()), FMOD_DSP_TYPE_UNKNOWN);
		VALUES.put(new Integer(FMOD_DSP_TYPE_MIXER.asInt()), FMOD_DSP_TYPE_MIXER);
		VALUES.put(new Integer(FMOD_DSP_TYPE_OSCILLATOR.asInt()), FMOD_DSP_TYPE_OSCILLATOR);
		VALUES.put(new Integer(FMOD_DSP_TYPE_LOWPASS.asInt()), FMOD_DSP_TYPE_LOWPASS);
		VALUES.put(new Integer(FMOD_DSP_TYPE_ITLOWPASS.asInt()), FMOD_DSP_TYPE_ITLOWPASS);
		VALUES.put(new Integer(FMOD_DSP_TYPE_HIGHPASS.asInt()), FMOD_DSP_TYPE_HIGHPASS);
		VALUES.put(new Integer(FMOD_DSP_TYPE_ECHO.asInt()), FMOD_DSP_TYPE_ECHO);
		VALUES.put(new Integer(FMOD_DSP_TYPE_FLANGE.asInt()), FMOD_DSP_TYPE_FLANGE);
		VALUES.put(new Integer(FMOD_DSP_TYPE_DISTORTION.asInt()), FMOD_DSP_TYPE_DISTORTION);
		VALUES.put(new Integer(FMOD_DSP_TYPE_NORMALIZE.asInt()), FMOD_DSP_TYPE_NORMALIZE);
		VALUES.put(new Integer(FMOD_DSP_TYPE_PARAMEQ.asInt()), FMOD_DSP_TYPE_PARAMEQ);
		VALUES.put(new Integer(FMOD_DSP_TYPE_PITCHSHIFT.asInt()), FMOD_DSP_TYPE_PITCHSHIFT);
		VALUES.put(new Integer(FMOD_DSP_TYPE_CHORUS.asInt()), FMOD_DSP_TYPE_CHORUS);
		VALUES.put(new Integer(FMOD_DSP_TYPE_REVERB.asInt()), FMOD_DSP_TYPE_REVERB);
		VALUES.put(new Integer(FMOD_DSP_TYPE_VSTPLUGIN.asInt()), FMOD_DSP_TYPE_VSTPLUGIN);
		VALUES.put(new Integer(FMOD_DSP_TYPE_WINAMPPLUGIN.asInt()), FMOD_DSP_TYPE_WINAMPPLUGIN);
		VALUES.put(new Integer(FMOD_DSP_TYPE_ITECHO.asInt()), FMOD_DSP_TYPE_ITECHO);
		VALUES.put(new Integer(FMOD_DSP_TYPE_COMPRESSOR.asInt()), FMOD_DSP_TYPE_COMPRESSOR);
		VALUES.put(new Integer(FMOD_DSP_TYPE_SFXREVERB.asInt()), FMOD_DSP_TYPE_SFXREVERB);
		VALUES.put(new Integer(FMOD_DSP_TYPE_LOWPASS_SIMPLE.asInt()), FMOD_DSP_TYPE_LOWPASS_SIMPLE);
		VALUES.put(new Integer(FMOD_DSP_TYPE_DELAY.asInt()), FMOD_DSP_TYPE_DELAY);
		VALUES.put(new Integer(FMOD_DSP_TYPE_TREMOLO.asInt()), FMOD_DSP_TYPE_TREMOLO);
		VALUES.put(new Integer(FMOD_DSP_TYPE_FORCEINT.asInt()), FMOD_DSP_TYPE_FORCEINT);
	}

	private final String name;
	private final int nativeValue;
	private FMOD_DSP_TYPE(String name, int nativeValue) {
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
		if(object instanceof FMOD_DSP_TYPE) {
			return asInt() == ((FMOD_DSP_TYPE)object).asInt();
		}
		return false;
	}
	public int compareTo(Object object) {
		return asInt() - ((FMOD_DSP_TYPE)object).asInt();
	}


	/**
	 * Retrieve a FMOD_DSP_TYPE enum field with his integer value
	 * @param nativeValue the integer value of the field to retrieve
	 * @return the FMOD_DSP_TYPE enum field that correspond to the integer value
	 */
	public static FMOD_DSP_TYPE get(int nativeValue) {
		return (FMOD_DSP_TYPE)VALUES.get(new Integer(nativeValue));
	}

	/**
	 * Retrieve a FMOD_DSP_TYPE enum field from a Pointer
	 * @param pointer a pointer holding an FMOD_DSP_TYPE enum field
	 * @return the FMOD_DSP_TYPE enum field that correspond to the enum field in the pointer
	 */
	public static FMOD_DSP_TYPE get(Pointer pointer) {
		return get(pointer.asInt());
	}

	/**
	 * @return an <code>Iterator</code> over the elements in this enumeration.<BR>
	 * Can be cast to <code>Iterator<FMOD_DSP_TYPE></code> in Java 1.5.
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
