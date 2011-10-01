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
 * List of windowing methods used in spectrum analysis to reduce leakage / transient signals intefering with the analysis.<BR>
 * This is a problem with analysis of continuous signals that only have a small portion of the signal sample (the fft window size).<BR>
 * Windowing the signal with a curve or triangle tapers the sides of the fft window to help alleviate this problem.<BR>
 * <BR><U><B>Remarks</B></U><BR><BR>
 * Cyclic signals such as a sine wave that repeat their cycle in a multiple of the window size do not need windowing.<BR>
 * I.e. If the sine wave repeats every 1024, 512, 256 etc samples and the FMOD fft window is 1024, then the signal would not need windowing.<BR>
 * Not windowing is the same as FMOD_DSP_FFT_WINDOW_RECT, which is the default.<BR>
 * If the cycle of the signal (ie the sine wave) is not a multiple of the window size, it will cause frequency abnormalities, so a different windowing method is needed.<BR>
 * <BR><U><B>Platforms Supported</B></U><BR><BR>
 * Win32, Win64, Linux, Linux64, Macintosh, Xbox360, PlayStation 2, PlayStation Portable, PlayStation 3, Wii, Solaris, iPhone<BR>
 * <BR><U><B>See Also</B></U><BR><BR>
 * System::getSpectrum<BR>
 * Channel::getSpectrum<BR>
 * 
 */
public class FMOD_DSP_FFT_WINDOW implements Enumeration, Comparable {
	/**  */
	public final static FMOD_DSP_FFT_WINDOW FMOD_DSP_FFT_WINDOW_RECT = new FMOD_DSP_FFT_WINDOW("FMOD_DSP_FFT_WINDOW_RECT", EnumerationJNI.get_FMOD_DSP_FFT_WINDOW_RECT());
	/**  */
	public final static FMOD_DSP_FFT_WINDOW FMOD_DSP_FFT_WINDOW_TRIANGLE = new FMOD_DSP_FFT_WINDOW("FMOD_DSP_FFT_WINDOW_TRIANGLE", EnumerationJNI.get_FMOD_DSP_FFT_WINDOW_TRIANGLE());
	/**  */
	public final static FMOD_DSP_FFT_WINDOW FMOD_DSP_FFT_WINDOW_HAMMING = new FMOD_DSP_FFT_WINDOW("FMOD_DSP_FFT_WINDOW_HAMMING", EnumerationJNI.get_FMOD_DSP_FFT_WINDOW_HAMMING());
	/**  */
	public final static FMOD_DSP_FFT_WINDOW FMOD_DSP_FFT_WINDOW_HANNING = new FMOD_DSP_FFT_WINDOW("FMOD_DSP_FFT_WINDOW_HANNING", EnumerationJNI.get_FMOD_DSP_FFT_WINDOW_HANNING());
	/**  */
	public final static FMOD_DSP_FFT_WINDOW FMOD_DSP_FFT_WINDOW_BLACKMAN = new FMOD_DSP_FFT_WINDOW("FMOD_DSP_FFT_WINDOW_BLACKMAN", EnumerationJNI.get_FMOD_DSP_FFT_WINDOW_BLACKMAN());
	/**  */
	public final static FMOD_DSP_FFT_WINDOW FMOD_DSP_FFT_WINDOW_BLACKMANHARRIS = new FMOD_DSP_FFT_WINDOW("FMOD_DSP_FFT_WINDOW_BLACKMANHARRIS", EnumerationJNI.get_FMOD_DSP_FFT_WINDOW_BLACKMANHARRIS());
	/**  */
	public final static FMOD_DSP_FFT_WINDOW FMOD_DSP_FFT_WINDOW_MAX = new FMOD_DSP_FFT_WINDOW("FMOD_DSP_FFT_WINDOW_MAX", EnumerationJNI.get_FMOD_DSP_FFT_WINDOW_MAX());
	/**  */
	public final static FMOD_DSP_FFT_WINDOW FMOD_DSP_FFT_WINDOW_FORCEINT = new FMOD_DSP_FFT_WINDOW("FMOD_DSP_FFT_WINDOW_FORCEINT", 65536);

	private final static HashMap VALUES = new HashMap(2*8);
	static {
		VALUES.put(new Integer(FMOD_DSP_FFT_WINDOW_RECT.asInt()), FMOD_DSP_FFT_WINDOW_RECT);
		VALUES.put(new Integer(FMOD_DSP_FFT_WINDOW_TRIANGLE.asInt()), FMOD_DSP_FFT_WINDOW_TRIANGLE);
		VALUES.put(new Integer(FMOD_DSP_FFT_WINDOW_HAMMING.asInt()), FMOD_DSP_FFT_WINDOW_HAMMING);
		VALUES.put(new Integer(FMOD_DSP_FFT_WINDOW_HANNING.asInt()), FMOD_DSP_FFT_WINDOW_HANNING);
		VALUES.put(new Integer(FMOD_DSP_FFT_WINDOW_BLACKMAN.asInt()), FMOD_DSP_FFT_WINDOW_BLACKMAN);
		VALUES.put(new Integer(FMOD_DSP_FFT_WINDOW_BLACKMANHARRIS.asInt()), FMOD_DSP_FFT_WINDOW_BLACKMANHARRIS);
		VALUES.put(new Integer(FMOD_DSP_FFT_WINDOW_MAX.asInt()), FMOD_DSP_FFT_WINDOW_MAX);
		VALUES.put(new Integer(FMOD_DSP_FFT_WINDOW_FORCEINT.asInt()), FMOD_DSP_FFT_WINDOW_FORCEINT);
	}

	private final String name;
	private final int nativeValue;
	private FMOD_DSP_FFT_WINDOW(String name, int nativeValue) {
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
		if(object instanceof FMOD_DSP_FFT_WINDOW) {
			return asInt() == ((FMOD_DSP_FFT_WINDOW)object).asInt();
		}
		return false;
	}
	public int compareTo(Object object) {
		return asInt() - ((FMOD_DSP_FFT_WINDOW)object).asInt();
	}


	/**
	 * Retrieve a FMOD_DSP_FFT_WINDOW enum field with his integer value
	 * @param nativeValue the integer value of the field to retrieve
	 * @return the FMOD_DSP_FFT_WINDOW enum field that correspond to the integer value
	 */
	public static FMOD_DSP_FFT_WINDOW get(int nativeValue) {
		return (FMOD_DSP_FFT_WINDOW)VALUES.get(new Integer(nativeValue));
	}

	/**
	 * Retrieve a FMOD_DSP_FFT_WINDOW enum field from a Pointer
	 * @param pointer a pointer holding an FMOD_DSP_FFT_WINDOW enum field
	 * @return the FMOD_DSP_FFT_WINDOW enum field that correspond to the enum field in the pointer
	 */
	public static FMOD_DSP_FFT_WINDOW get(Pointer pointer) {
		return get(pointer.asInt());
	}

	/**
	 * @return an <code>Iterator</code> over the elements in this enumeration.<BR>
	 * Can be cast to <code>Iterator<FMOD_DSP_FFT_WINDOW></code> in Java 1.5.
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
