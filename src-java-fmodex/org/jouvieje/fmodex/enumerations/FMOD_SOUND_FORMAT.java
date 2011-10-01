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
 * These definitions describe the native format of the hardware or software buffer that will be used.<BR>
 * <BR><U><B>Remarks</B></U><BR><BR>
 * This is the format the native hardware or software buffer will be or is created in.<BR>
 * <BR><U><B>Platforms Supported</B></U><BR><BR>
 * Win32, Win64, Linux, Linux64, Macintosh, Xbox360, PlayStation 2, PlayStation Portable, PlayStation 3, Wii, Solaris, iPhone<BR>
 * <BR><U><B>See Also</B></U><BR><BR>
 * System::createSound<BR>
 * Sound::getFormat<BR>
 * 
 */
public class FMOD_SOUND_FORMAT implements Enumeration, Comparable {
	/**  */
	public final static FMOD_SOUND_FORMAT FMOD_SOUND_FORMAT_NONE = new FMOD_SOUND_FORMAT("FMOD_SOUND_FORMAT_NONE", EnumerationJNI.get_FMOD_SOUND_FORMAT_NONE());
	/**  */
	public final static FMOD_SOUND_FORMAT FMOD_SOUND_FORMAT_PCM8 = new FMOD_SOUND_FORMAT("FMOD_SOUND_FORMAT_PCM8", EnumerationJNI.get_FMOD_SOUND_FORMAT_PCM8());
	/**  */
	public final static FMOD_SOUND_FORMAT FMOD_SOUND_FORMAT_PCM16 = new FMOD_SOUND_FORMAT("FMOD_SOUND_FORMAT_PCM16", EnumerationJNI.get_FMOD_SOUND_FORMAT_PCM16());
	/**  */
	public final static FMOD_SOUND_FORMAT FMOD_SOUND_FORMAT_PCM24 = new FMOD_SOUND_FORMAT("FMOD_SOUND_FORMAT_PCM24", EnumerationJNI.get_FMOD_SOUND_FORMAT_PCM24());
	/**  */
	public final static FMOD_SOUND_FORMAT FMOD_SOUND_FORMAT_PCM32 = new FMOD_SOUND_FORMAT("FMOD_SOUND_FORMAT_PCM32", EnumerationJNI.get_FMOD_SOUND_FORMAT_PCM32());
	/**  */
	public final static FMOD_SOUND_FORMAT FMOD_SOUND_FORMAT_PCMFLOAT = new FMOD_SOUND_FORMAT("FMOD_SOUND_FORMAT_PCMFLOAT", EnumerationJNI.get_FMOD_SOUND_FORMAT_PCMFLOAT());
	/**  */
	public final static FMOD_SOUND_FORMAT FMOD_SOUND_FORMAT_GCADPCM = new FMOD_SOUND_FORMAT("FMOD_SOUND_FORMAT_GCADPCM", EnumerationJNI.get_FMOD_SOUND_FORMAT_GCADPCM());
	/**  */
	public final static FMOD_SOUND_FORMAT FMOD_SOUND_FORMAT_IMAADPCM = new FMOD_SOUND_FORMAT("FMOD_SOUND_FORMAT_IMAADPCM", EnumerationJNI.get_FMOD_SOUND_FORMAT_IMAADPCM());
	/**  */
	public final static FMOD_SOUND_FORMAT FMOD_SOUND_FORMAT_VAG = new FMOD_SOUND_FORMAT("FMOD_SOUND_FORMAT_VAG", EnumerationJNI.get_FMOD_SOUND_FORMAT_VAG());
	/**  */
	public final static FMOD_SOUND_FORMAT FMOD_SOUND_FORMAT_XMA = new FMOD_SOUND_FORMAT("FMOD_SOUND_FORMAT_XMA", EnumerationJNI.get_FMOD_SOUND_FORMAT_XMA());
	/**  */
	public final static FMOD_SOUND_FORMAT FMOD_SOUND_FORMAT_MPEG = new FMOD_SOUND_FORMAT("FMOD_SOUND_FORMAT_MPEG", EnumerationJNI.get_FMOD_SOUND_FORMAT_MPEG());
	/**  */
	public final static FMOD_SOUND_FORMAT FMOD_SOUND_FORMAT_CELT = new FMOD_SOUND_FORMAT("FMOD_SOUND_FORMAT_CELT", EnumerationJNI.get_FMOD_SOUND_FORMAT_CELT());
	/**  */
	public final static FMOD_SOUND_FORMAT FMOD_SOUND_FORMAT_MAX = new FMOD_SOUND_FORMAT("FMOD_SOUND_FORMAT_MAX", EnumerationJNI.get_FMOD_SOUND_FORMAT_MAX());
	/**  */
	public final static FMOD_SOUND_FORMAT FMOD_SOUND_FORMAT_FORCEINT = new FMOD_SOUND_FORMAT("FMOD_SOUND_FORMAT_FORCEINT", 65536);

	private final static HashMap VALUES = new HashMap(2*14);
	static {
		VALUES.put(new Integer(FMOD_SOUND_FORMAT_NONE.asInt()), FMOD_SOUND_FORMAT_NONE);
		VALUES.put(new Integer(FMOD_SOUND_FORMAT_PCM8.asInt()), FMOD_SOUND_FORMAT_PCM8);
		VALUES.put(new Integer(FMOD_SOUND_FORMAT_PCM16.asInt()), FMOD_SOUND_FORMAT_PCM16);
		VALUES.put(new Integer(FMOD_SOUND_FORMAT_PCM24.asInt()), FMOD_SOUND_FORMAT_PCM24);
		VALUES.put(new Integer(FMOD_SOUND_FORMAT_PCM32.asInt()), FMOD_SOUND_FORMAT_PCM32);
		VALUES.put(new Integer(FMOD_SOUND_FORMAT_PCMFLOAT.asInt()), FMOD_SOUND_FORMAT_PCMFLOAT);
		VALUES.put(new Integer(FMOD_SOUND_FORMAT_GCADPCM.asInt()), FMOD_SOUND_FORMAT_GCADPCM);
		VALUES.put(new Integer(FMOD_SOUND_FORMAT_IMAADPCM.asInt()), FMOD_SOUND_FORMAT_IMAADPCM);
		VALUES.put(new Integer(FMOD_SOUND_FORMAT_VAG.asInt()), FMOD_SOUND_FORMAT_VAG);
		VALUES.put(new Integer(FMOD_SOUND_FORMAT_XMA.asInt()), FMOD_SOUND_FORMAT_XMA);
		VALUES.put(new Integer(FMOD_SOUND_FORMAT_MPEG.asInt()), FMOD_SOUND_FORMAT_MPEG);
		VALUES.put(new Integer(FMOD_SOUND_FORMAT_CELT.asInt()), FMOD_SOUND_FORMAT_CELT);
		VALUES.put(new Integer(FMOD_SOUND_FORMAT_MAX.asInt()), FMOD_SOUND_FORMAT_MAX);
		VALUES.put(new Integer(FMOD_SOUND_FORMAT_FORCEINT.asInt()), FMOD_SOUND_FORMAT_FORCEINT);
	}

	private final String name;
	private final int nativeValue;
	private FMOD_SOUND_FORMAT(String name, int nativeValue) {
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
		if(object instanceof FMOD_SOUND_FORMAT) {
			return asInt() == ((FMOD_SOUND_FORMAT)object).asInt();
		}
		return false;
	}
	public int compareTo(Object object) {
		return asInt() - ((FMOD_SOUND_FORMAT)object).asInt();
	}


	/**
	 * Retrieve a FMOD_SOUND_FORMAT enum field with his integer value
	 * @param nativeValue the integer value of the field to retrieve
	 * @return the FMOD_SOUND_FORMAT enum field that correspond to the integer value
	 */
	public static FMOD_SOUND_FORMAT get(int nativeValue) {
		return (FMOD_SOUND_FORMAT)VALUES.get(new Integer(nativeValue));
	}

	/**
	 * Retrieve a FMOD_SOUND_FORMAT enum field from a Pointer
	 * @param pointer a pointer holding an FMOD_SOUND_FORMAT enum field
	 * @return the FMOD_SOUND_FORMAT enum field that correspond to the enum field in the pointer
	 */
	public static FMOD_SOUND_FORMAT get(Pointer pointer) {
		return get(pointer.asInt());
	}

	/**
	 * @return an <code>Iterator</code> over the elements in this enumeration.<BR>
	 * Can be cast to <code>Iterator<FMOD_SOUND_FORMAT></code> in Java 1.5.
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
