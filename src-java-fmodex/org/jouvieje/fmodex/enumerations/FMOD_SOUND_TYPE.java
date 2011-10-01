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
 * These definitions describe the type of song being played.<BR>
 * <BR><U><B>Remarks</B></U><BR><BR>
 * <BR><U><B>Platforms Supported</B></U><BR><BR>
 * Win32, Win64, Linux, Linux64, Macintosh, Xbox360, PlayStation 2, PlayStation Portable, PlayStation 3, Wii, Solaris, iPhone<BR>
 * <BR><U><B>See Also</B></U><BR><BR>
 * Sound::getFormat<BR>
 * 
 */
public class FMOD_SOUND_TYPE implements Enumeration, Comparable {
	/**  */
	public final static FMOD_SOUND_TYPE FMOD_SOUND_TYPE_UNKNOWN = new FMOD_SOUND_TYPE("FMOD_SOUND_TYPE_UNKNOWN", EnumerationJNI.get_FMOD_SOUND_TYPE_UNKNOWN());
	/**  */
	public final static FMOD_SOUND_TYPE FMOD_SOUND_TYPE_AAC = new FMOD_SOUND_TYPE("FMOD_SOUND_TYPE_AAC", EnumerationJNI.get_FMOD_SOUND_TYPE_AAC());
	/**  */
	public final static FMOD_SOUND_TYPE FMOD_SOUND_TYPE_AIFF = new FMOD_SOUND_TYPE("FMOD_SOUND_TYPE_AIFF", EnumerationJNI.get_FMOD_SOUND_TYPE_AIFF());
	/**  */
	public final static FMOD_SOUND_TYPE FMOD_SOUND_TYPE_ASF = new FMOD_SOUND_TYPE("FMOD_SOUND_TYPE_ASF", EnumerationJNI.get_FMOD_SOUND_TYPE_ASF());
	/**  */
	public final static FMOD_SOUND_TYPE FMOD_SOUND_TYPE_AT3 = new FMOD_SOUND_TYPE("FMOD_SOUND_TYPE_AT3", EnumerationJNI.get_FMOD_SOUND_TYPE_AT3());
	/**  */
	public final static FMOD_SOUND_TYPE FMOD_SOUND_TYPE_CDDA = new FMOD_SOUND_TYPE("FMOD_SOUND_TYPE_CDDA", EnumerationJNI.get_FMOD_SOUND_TYPE_CDDA());
	/**  */
	public final static FMOD_SOUND_TYPE FMOD_SOUND_TYPE_DLS = new FMOD_SOUND_TYPE("FMOD_SOUND_TYPE_DLS", EnumerationJNI.get_FMOD_SOUND_TYPE_DLS());
	/**  */
	public final static FMOD_SOUND_TYPE FMOD_SOUND_TYPE_FLAC = new FMOD_SOUND_TYPE("FMOD_SOUND_TYPE_FLAC", EnumerationJNI.get_FMOD_SOUND_TYPE_FLAC());
	/**  */
	public final static FMOD_SOUND_TYPE FMOD_SOUND_TYPE_FSB = new FMOD_SOUND_TYPE("FMOD_SOUND_TYPE_FSB", EnumerationJNI.get_FMOD_SOUND_TYPE_FSB());
	/**  */
	public final static FMOD_SOUND_TYPE FMOD_SOUND_TYPE_GCADPCM = new FMOD_SOUND_TYPE("FMOD_SOUND_TYPE_GCADPCM", EnumerationJNI.get_FMOD_SOUND_TYPE_GCADPCM());
	/**  */
	public final static FMOD_SOUND_TYPE FMOD_SOUND_TYPE_IT = new FMOD_SOUND_TYPE("FMOD_SOUND_TYPE_IT", EnumerationJNI.get_FMOD_SOUND_TYPE_IT());
	/**  */
	public final static FMOD_SOUND_TYPE FMOD_SOUND_TYPE_MIDI = new FMOD_SOUND_TYPE("FMOD_SOUND_TYPE_MIDI", EnumerationJNI.get_FMOD_SOUND_TYPE_MIDI());
	/**  */
	public final static FMOD_SOUND_TYPE FMOD_SOUND_TYPE_MOD = new FMOD_SOUND_TYPE("FMOD_SOUND_TYPE_MOD", EnumerationJNI.get_FMOD_SOUND_TYPE_MOD());
	/**  */
	public final static FMOD_SOUND_TYPE FMOD_SOUND_TYPE_MPEG = new FMOD_SOUND_TYPE("FMOD_SOUND_TYPE_MPEG", EnumerationJNI.get_FMOD_SOUND_TYPE_MPEG());
	/**  */
	public final static FMOD_SOUND_TYPE FMOD_SOUND_TYPE_OGGVORBIS = new FMOD_SOUND_TYPE("FMOD_SOUND_TYPE_OGGVORBIS", EnumerationJNI.get_FMOD_SOUND_TYPE_OGGVORBIS());
	/**  */
	public final static FMOD_SOUND_TYPE FMOD_SOUND_TYPE_PLAYLIST = new FMOD_SOUND_TYPE("FMOD_SOUND_TYPE_PLAYLIST", EnumerationJNI.get_FMOD_SOUND_TYPE_PLAYLIST());
	/**  */
	public final static FMOD_SOUND_TYPE FMOD_SOUND_TYPE_RAW = new FMOD_SOUND_TYPE("FMOD_SOUND_TYPE_RAW", EnumerationJNI.get_FMOD_SOUND_TYPE_RAW());
	/**  */
	public final static FMOD_SOUND_TYPE FMOD_SOUND_TYPE_S3M = new FMOD_SOUND_TYPE("FMOD_SOUND_TYPE_S3M", EnumerationJNI.get_FMOD_SOUND_TYPE_S3M());
	/**  */
	public final static FMOD_SOUND_TYPE FMOD_SOUND_TYPE_SF2 = new FMOD_SOUND_TYPE("FMOD_SOUND_TYPE_SF2", EnumerationJNI.get_FMOD_SOUND_TYPE_SF2());
	/**  */
	public final static FMOD_SOUND_TYPE FMOD_SOUND_TYPE_USER = new FMOD_SOUND_TYPE("FMOD_SOUND_TYPE_USER", EnumerationJNI.get_FMOD_SOUND_TYPE_USER());
	/**  */
	public final static FMOD_SOUND_TYPE FMOD_SOUND_TYPE_WAV = new FMOD_SOUND_TYPE("FMOD_SOUND_TYPE_WAV", EnumerationJNI.get_FMOD_SOUND_TYPE_WAV());
	/**  */
	public final static FMOD_SOUND_TYPE FMOD_SOUND_TYPE_XM = new FMOD_SOUND_TYPE("FMOD_SOUND_TYPE_XM", EnumerationJNI.get_FMOD_SOUND_TYPE_XM());
	/**  */
	public final static FMOD_SOUND_TYPE FMOD_SOUND_TYPE_XMA = new FMOD_SOUND_TYPE("FMOD_SOUND_TYPE_XMA", EnumerationJNI.get_FMOD_SOUND_TYPE_XMA());
	/**  */
	public final static FMOD_SOUND_TYPE FMOD_SOUND_TYPE_VAG = new FMOD_SOUND_TYPE("FMOD_SOUND_TYPE_VAG", EnumerationJNI.get_FMOD_SOUND_TYPE_VAG());
	/**  */
	public final static FMOD_SOUND_TYPE FMOD_SOUND_TYPE_AUDIOQUEUE = new FMOD_SOUND_TYPE("FMOD_SOUND_TYPE_AUDIOQUEUE", EnumerationJNI.get_FMOD_SOUND_TYPE_AUDIOQUEUE());
	/**  */
	public final static FMOD_SOUND_TYPE FMOD_SOUND_TYPE_XWMA = new FMOD_SOUND_TYPE("FMOD_SOUND_TYPE_XWMA", EnumerationJNI.get_FMOD_SOUND_TYPE_XWMA());
	/**  */
	public final static FMOD_SOUND_TYPE FMOD_SOUND_TYPE_MAX = new FMOD_SOUND_TYPE("FMOD_SOUND_TYPE_MAX", EnumerationJNI.get_FMOD_SOUND_TYPE_MAX());
	/**  */
	public final static FMOD_SOUND_TYPE FMOD_SOUND_TYPE_FORCEINT = new FMOD_SOUND_TYPE("FMOD_SOUND_TYPE_FORCEINT", 65536);

	private final static HashMap VALUES = new HashMap(2*28);
	static {
		VALUES.put(new Integer(FMOD_SOUND_TYPE_UNKNOWN.asInt()), FMOD_SOUND_TYPE_UNKNOWN);
		VALUES.put(new Integer(FMOD_SOUND_TYPE_AAC.asInt()), FMOD_SOUND_TYPE_AAC);
		VALUES.put(new Integer(FMOD_SOUND_TYPE_AIFF.asInt()), FMOD_SOUND_TYPE_AIFF);
		VALUES.put(new Integer(FMOD_SOUND_TYPE_ASF.asInt()), FMOD_SOUND_TYPE_ASF);
		VALUES.put(new Integer(FMOD_SOUND_TYPE_AT3.asInt()), FMOD_SOUND_TYPE_AT3);
		VALUES.put(new Integer(FMOD_SOUND_TYPE_CDDA.asInt()), FMOD_SOUND_TYPE_CDDA);
		VALUES.put(new Integer(FMOD_SOUND_TYPE_DLS.asInt()), FMOD_SOUND_TYPE_DLS);
		VALUES.put(new Integer(FMOD_SOUND_TYPE_FLAC.asInt()), FMOD_SOUND_TYPE_FLAC);
		VALUES.put(new Integer(FMOD_SOUND_TYPE_FSB.asInt()), FMOD_SOUND_TYPE_FSB);
		VALUES.put(new Integer(FMOD_SOUND_TYPE_GCADPCM.asInt()), FMOD_SOUND_TYPE_GCADPCM);
		VALUES.put(new Integer(FMOD_SOUND_TYPE_IT.asInt()), FMOD_SOUND_TYPE_IT);
		VALUES.put(new Integer(FMOD_SOUND_TYPE_MIDI.asInt()), FMOD_SOUND_TYPE_MIDI);
		VALUES.put(new Integer(FMOD_SOUND_TYPE_MOD.asInt()), FMOD_SOUND_TYPE_MOD);
		VALUES.put(new Integer(FMOD_SOUND_TYPE_MPEG.asInt()), FMOD_SOUND_TYPE_MPEG);
		VALUES.put(new Integer(FMOD_SOUND_TYPE_OGGVORBIS.asInt()), FMOD_SOUND_TYPE_OGGVORBIS);
		VALUES.put(new Integer(FMOD_SOUND_TYPE_PLAYLIST.asInt()), FMOD_SOUND_TYPE_PLAYLIST);
		VALUES.put(new Integer(FMOD_SOUND_TYPE_RAW.asInt()), FMOD_SOUND_TYPE_RAW);
		VALUES.put(new Integer(FMOD_SOUND_TYPE_S3M.asInt()), FMOD_SOUND_TYPE_S3M);
		VALUES.put(new Integer(FMOD_SOUND_TYPE_SF2.asInt()), FMOD_SOUND_TYPE_SF2);
		VALUES.put(new Integer(FMOD_SOUND_TYPE_USER.asInt()), FMOD_SOUND_TYPE_USER);
		VALUES.put(new Integer(FMOD_SOUND_TYPE_WAV.asInt()), FMOD_SOUND_TYPE_WAV);
		VALUES.put(new Integer(FMOD_SOUND_TYPE_XM.asInt()), FMOD_SOUND_TYPE_XM);
		VALUES.put(new Integer(FMOD_SOUND_TYPE_XMA.asInt()), FMOD_SOUND_TYPE_XMA);
		VALUES.put(new Integer(FMOD_SOUND_TYPE_VAG.asInt()), FMOD_SOUND_TYPE_VAG);
		VALUES.put(new Integer(FMOD_SOUND_TYPE_AUDIOQUEUE.asInt()), FMOD_SOUND_TYPE_AUDIOQUEUE);
		VALUES.put(new Integer(FMOD_SOUND_TYPE_XWMA.asInt()), FMOD_SOUND_TYPE_XWMA);
		VALUES.put(new Integer(FMOD_SOUND_TYPE_MAX.asInt()), FMOD_SOUND_TYPE_MAX);
		VALUES.put(new Integer(FMOD_SOUND_TYPE_FORCEINT.asInt()), FMOD_SOUND_TYPE_FORCEINT);
	}

	private final String name;
	private final int nativeValue;
	private FMOD_SOUND_TYPE(String name, int nativeValue) {
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
		if(object instanceof FMOD_SOUND_TYPE) {
			return asInt() == ((FMOD_SOUND_TYPE)object).asInt();
		}
		return false;
	}
	public int compareTo(Object object) {
		return asInt() - ((FMOD_SOUND_TYPE)object).asInt();
	}


	/**
	 * Retrieve a FMOD_SOUND_TYPE enum field with his integer value
	 * @param nativeValue the integer value of the field to retrieve
	 * @return the FMOD_SOUND_TYPE enum field that correspond to the integer value
	 */
	public static FMOD_SOUND_TYPE get(int nativeValue) {
		return (FMOD_SOUND_TYPE)VALUES.get(new Integer(nativeValue));
	}

	/**
	 * Retrieve a FMOD_SOUND_TYPE enum field from a Pointer
	 * @param pointer a pointer holding an FMOD_SOUND_TYPE enum field
	 * @return the FMOD_SOUND_TYPE enum field that correspond to the enum field in the pointer
	 */
	public static FMOD_SOUND_TYPE get(Pointer pointer) {
		return get(pointer.asInt());
	}

	/**
	 * @return an <code>Iterator</code> over the elements in this enumeration.<BR>
	 * Can be cast to <code>Iterator<FMOD_SOUND_TYPE></code> in Java 1.5.
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
