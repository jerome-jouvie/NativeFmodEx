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
 * Parameter types for the FMOD_DSP_TYPE_PITCHSHIFT filter.<BR>
 * <BR><U><B>Remarks</B></U><BR><BR>
 * This pitch shifting unit can be used to change the pitch of a sound without speeding it up or slowing it down.<BR>
 * It can also be used for time stretching or scaling, for example if the pitch was doubled, and the frequency of the sound was halved, the pitch of the sound would sound correct but it would be twice as slow.<BR>
 * <b>Warning!</b> This filter is very computationally expensive!  Similar to a vocoder, it requires several overlapping FFT and IFFT's to produce smooth output, and can require around 440mhz for 1 stereo 48khz signal using the default settings.<BR>
 * Reducing the signal to mono will half the cpu usage.<BR>
 * Reducing this will lower audio quality, but what settings to use are largely dependant on the sound being played.  A noisy polyphonic signal will need higher fft size compared to a speaking voice for example.<BR>
 * This pitch shifter is based on the pitch shifter code at http://www.dspdimension.com, written by Stephan M. Bernsee.<BR>
 * The original code is COPYRIGHT 1999-2003 Stephan M. Bernsee <smb@dspdimension.com>.<BR>
 * '<i>maxchannels</i>' dictates the amount of memory allocated.  By default, the maxchannels value is 0.  If FMOD is set to stereo, the pitch shift unit will allocate enough memory for 2 channels.  If it is 5.1, it will allocate enough memory for a 6 channel pitch shift, etc.<BR>
 * If the pitch shift effect is only ever applied to the global mix (ie it was added with System::addDSP), then 0 is the value to set as it will be enough to handle all speaker modes.<BR>
 * When the pitch shift is added to a channel (ie Channel::addDSP) then the channel count that comes in could be anything from 1 to 8 possibly.  It is only in this case where you might want to increase the channel count above the output's channel count.<BR>
 * If a channel pitch shift is set to a lower number than the sound's channel count that is coming in, it will not pitch shift the sound.<BR>
 * <BR><U><B>Platforms Supported</B></U><BR><BR>
 * Win32, Win64, Linux, Linux64, Macintosh, Xbox360, PlayStation 2, PlayStation Portable, PlayStation 3, Wii, Solaris, iPhone<BR>
 * <BR><U><B>See Also</B></U><BR><BR>
 * DSP::setParameter<BR>
 * DSP::getParameter<BR>
 * FMOD_DSP_TYPE<BR>
 * 
 */
public class FMOD_DSP_PITCHSHIFT implements Enumeration, Comparable {
	/**  */
	public final static FMOD_DSP_PITCHSHIFT FMOD_DSP_PITCHSHIFT_PITCH = new FMOD_DSP_PITCHSHIFT("FMOD_DSP_PITCHSHIFT_PITCH", EnumerationJNI.get_FMOD_DSP_PITCHSHIFT_PITCH());
	/**  */
	public final static FMOD_DSP_PITCHSHIFT FMOD_DSP_PITCHSHIFT_FFTSIZE = new FMOD_DSP_PITCHSHIFT("FMOD_DSP_PITCHSHIFT_FFTSIZE", EnumerationJNI.get_FMOD_DSP_PITCHSHIFT_FFTSIZE());
	/**  */
	public final static FMOD_DSP_PITCHSHIFT FMOD_DSP_PITCHSHIFT_OVERLAP = new FMOD_DSP_PITCHSHIFT("FMOD_DSP_PITCHSHIFT_OVERLAP", EnumerationJNI.get_FMOD_DSP_PITCHSHIFT_OVERLAP());
	/**  */
	public final static FMOD_DSP_PITCHSHIFT FMOD_DSP_PITCHSHIFT_MAXCHANNELS = new FMOD_DSP_PITCHSHIFT("FMOD_DSP_PITCHSHIFT_MAXCHANNELS", EnumerationJNI.get_FMOD_DSP_PITCHSHIFT_MAXCHANNELS());

	private final static HashMap VALUES = new HashMap(2*4);
	static {
		VALUES.put(new Integer(FMOD_DSP_PITCHSHIFT_PITCH.asInt()), FMOD_DSP_PITCHSHIFT_PITCH);
		VALUES.put(new Integer(FMOD_DSP_PITCHSHIFT_FFTSIZE.asInt()), FMOD_DSP_PITCHSHIFT_FFTSIZE);
		VALUES.put(new Integer(FMOD_DSP_PITCHSHIFT_OVERLAP.asInt()), FMOD_DSP_PITCHSHIFT_OVERLAP);
		VALUES.put(new Integer(FMOD_DSP_PITCHSHIFT_MAXCHANNELS.asInt()), FMOD_DSP_PITCHSHIFT_MAXCHANNELS);
	}

	private final String name;
	private final int nativeValue;
	private FMOD_DSP_PITCHSHIFT(String name, int nativeValue) {
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
		if(object instanceof FMOD_DSP_PITCHSHIFT) {
			return asInt() == ((FMOD_DSP_PITCHSHIFT)object).asInt();
		}
		return false;
	}
	public int compareTo(Object object) {
		return asInt() - ((FMOD_DSP_PITCHSHIFT)object).asInt();
	}


	/**
	 * Retrieve a FMOD_DSP_PITCHSHIFT enum field with his integer value
	 * @param nativeValue the integer value of the field to retrieve
	 * @return the FMOD_DSP_PITCHSHIFT enum field that correspond to the integer value
	 */
	public static FMOD_DSP_PITCHSHIFT get(int nativeValue) {
		return (FMOD_DSP_PITCHSHIFT)VALUES.get(new Integer(nativeValue));
	}

	/**
	 * Retrieve a FMOD_DSP_PITCHSHIFT enum field from a Pointer
	 * @param pointer a pointer holding an FMOD_DSP_PITCHSHIFT enum field
	 * @return the FMOD_DSP_PITCHSHIFT enum field that correspond to the enum field in the pointer
	 */
	public static FMOD_DSP_PITCHSHIFT get(Pointer pointer) {
		return get(pointer.asInt());
	}

	/**
	 * @return an <code>Iterator</code> over the elements in this enumeration.<BR>
	 * Can be cast to <code>Iterator<FMOD_DSP_PITCHSHIFT></code> in Java 1.5.
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
