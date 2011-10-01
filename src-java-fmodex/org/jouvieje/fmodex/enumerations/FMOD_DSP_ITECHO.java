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
 * Parameter types for the FMOD_DSP_TYPE_ITECHO filter.<BR>
 * This is effectively a software based echo filter that emulates the DirectX DMO echo effect.  Impulse tracker files can support this, and FMOD will produce the effect on ANY platform, not just those that support DirectX effects!<BR>
 * <BR><U><B>Remarks</B></U><BR><BR>
 * Note.  Every time the delay is changed, the plugin re-allocates the echo buffer.  This means the echo will dissapear at that time while it refills its new buffer.<BR>
 * Larger echo delays result in larger amounts of memory allocated.<BR>
 * As this is a stereo filter made mainly for IT playback, it is targeted for stereo signals.<BR>
 * With mono signals only the FMOD_DSP_ITECHO_LEFTDELAY is used.<BR>
 * For multichannel signals (>2) there will be no echo on those channels.<BR>
 * <BR><U><B>Platforms Supported</B></U><BR><BR>
 * Win32, Win64, Linux, Linux64, Macintosh, Xbox360, PlayStation 2, PlayStation Portable, PlayStation 3, Wii, Solaris, iPhone<BR>
 * <BR><U><B>See Also</B></U><BR><BR>
 * DSP::SetParameter<BR>
 * DSP::GetParameter<BR>
 * FMOD_DSP_TYPE<BR>
 * System::addDSP<BR>
 * 
 */
public class FMOD_DSP_ITECHO implements Enumeration, Comparable {
	/**  */
	public final static FMOD_DSP_ITECHO FMOD_DSP_ITECHO_WETDRYMIX = new FMOD_DSP_ITECHO("FMOD_DSP_ITECHO_WETDRYMIX", EnumerationJNI.get_FMOD_DSP_ITECHO_WETDRYMIX());
	/**  */
	public final static FMOD_DSP_ITECHO FMOD_DSP_ITECHO_FEEDBACK = new FMOD_DSP_ITECHO("FMOD_DSP_ITECHO_FEEDBACK", EnumerationJNI.get_FMOD_DSP_ITECHO_FEEDBACK());
	/**  */
	public final static FMOD_DSP_ITECHO FMOD_DSP_ITECHO_LEFTDELAY = new FMOD_DSP_ITECHO("FMOD_DSP_ITECHO_LEFTDELAY", EnumerationJNI.get_FMOD_DSP_ITECHO_LEFTDELAY());
	/**  */
	public final static FMOD_DSP_ITECHO FMOD_DSP_ITECHO_RIGHTDELAY = new FMOD_DSP_ITECHO("FMOD_DSP_ITECHO_RIGHTDELAY", EnumerationJNI.get_FMOD_DSP_ITECHO_RIGHTDELAY());
	/**  */
	public final static FMOD_DSP_ITECHO FMOD_DSP_ITECHO_PANDELAY = new FMOD_DSP_ITECHO("FMOD_DSP_ITECHO_PANDELAY", EnumerationJNI.get_FMOD_DSP_ITECHO_PANDELAY());

	private final static HashMap VALUES = new HashMap(2*5);
	static {
		VALUES.put(new Integer(FMOD_DSP_ITECHO_WETDRYMIX.asInt()), FMOD_DSP_ITECHO_WETDRYMIX);
		VALUES.put(new Integer(FMOD_DSP_ITECHO_FEEDBACK.asInt()), FMOD_DSP_ITECHO_FEEDBACK);
		VALUES.put(new Integer(FMOD_DSP_ITECHO_LEFTDELAY.asInt()), FMOD_DSP_ITECHO_LEFTDELAY);
		VALUES.put(new Integer(FMOD_DSP_ITECHO_RIGHTDELAY.asInt()), FMOD_DSP_ITECHO_RIGHTDELAY);
		VALUES.put(new Integer(FMOD_DSP_ITECHO_PANDELAY.asInt()), FMOD_DSP_ITECHO_PANDELAY);
	}

	private final String name;
	private final int nativeValue;
	private FMOD_DSP_ITECHO(String name, int nativeValue) {
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
		if(object instanceof FMOD_DSP_ITECHO) {
			return asInt() == ((FMOD_DSP_ITECHO)object).asInt();
		}
		return false;
	}
	public int compareTo(Object object) {
		return asInt() - ((FMOD_DSP_ITECHO)object).asInt();
	}


	/**
	 * Retrieve a FMOD_DSP_ITECHO enum field with his integer value
	 * @param nativeValue the integer value of the field to retrieve
	 * @return the FMOD_DSP_ITECHO enum field that correspond to the integer value
	 */
	public static FMOD_DSP_ITECHO get(int nativeValue) {
		return (FMOD_DSP_ITECHO)VALUES.get(new Integer(nativeValue));
	}

	/**
	 * Retrieve a FMOD_DSP_ITECHO enum field from a Pointer
	 * @param pointer a pointer holding an FMOD_DSP_ITECHO enum field
	 * @return the FMOD_DSP_ITECHO enum field that correspond to the enum field in the pointer
	 */
	public static FMOD_DSP_ITECHO get(Pointer pointer) {
		return get(pointer.asInt());
	}

	/**
	 * @return an <code>Iterator</code> over the elements in this enumeration.<BR>
	 * Can be cast to <code>Iterator<FMOD_DSP_ITECHO></code> in Java 1.5.
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
