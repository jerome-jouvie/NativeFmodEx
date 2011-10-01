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

package org.jouvieje.fmodex.defines;

/**
 * <BR>
 * List of time types that can be returned by Sound::getLength and used with Channel::setPosition or Channel::getPosition.<BR>
 * <BR><U><B>Remarks</B></U><BR><BR>
 * FMOD_TIMEUNIT_SENTENCE_MS, FMOD_TIMEUNIT_SENTENCE_PCM, FMOD_TIMEUNIT_SENTENCE_PCMBYTES, FMOD_TIMEUNIT_SENTENCE and FMOD_TIMEUNIT_SENTENCE_SUBSOUND are only supported by Channel functions.<BR>
 * Do not combine flags except FMOD_TIMEUNIT_BUFFERED.<BR>
 * <BR><U><B>Platforms Supported</B></U><BR><BR>
 * Win32, Win64, Linux, Linux64, Macintosh, Xbox360, PlayStation 2, PlayStation Portable, PlayStation 3, Wii, Solaris, iPhone<BR>
 * <BR><U><B>See Also</B></U><BR><BR>
 * Sound::getLength<BR>
 * Channel::setPosition<BR>
 * Channel::getPosition<BR>
 * 
 */
public interface FMOD_TIMEUNIT {
	/** Milliseconds. */
	public static final int FMOD_TIMEUNIT_MS = 0x00000001;
	/** PCM samples, related to milliseconds * samplerate / 1000. */
	public static final int FMOD_TIMEUNIT_PCM = 0x00000002;
	/** Bytes, related to PCM samples * channels * datawidth (ie 16bit = 2 bytes). */
	public static final int FMOD_TIMEUNIT_PCMBYTES = 0x00000004;
	/** Raw file bytes of (compressed) sound data (does not include headers).  Only used by Sound::getLength and Channel::getPosition. */
	public static final int FMOD_TIMEUNIT_RAWBYTES = 0x00000008;
	/** Fractions of 1 PCM sample.  Unsigned int range 0 to 0xFFFFFFFF.  Used for sub-sample granularity for DSP purposes. */
	public static final int FMOD_TIMEUNIT_PCMFRACTION = 0x00000010;
	/** MOD/S3M/XM/IT.  Order in a sequenced module format.  Use Sound::getFormat to determine the PCM format being decoded to. */
	public static final int FMOD_TIMEUNIT_MODORDER = 0x00000100;
	/** MOD/S3M/XM/IT.  Current row in a sequenced module format.  Sound::getLength will return the number of rows in the currently playing or seeked to pattern. */
	public static final int FMOD_TIMEUNIT_MODROW = 0x00000200;
	/** MOD/S3M/XM/IT.  Current pattern in a sequenced module format.  Sound::getLength will return the number of patterns in the song and Channel::getPosition will return the currently playing pattern. */
	public static final int FMOD_TIMEUNIT_MODPATTERN = 0x00000400;
	/** Currently playing subsound in a sentence time in milliseconds. */
	public static final int FMOD_TIMEUNIT_SENTENCE_MS = 0x00010000;
	/** Currently playing subsound in a sentence time in PCM Samples, related to milliseconds * samplerate / 1000. */
	public static final int FMOD_TIMEUNIT_SENTENCE_PCM = 0x00020000;
	/** Currently playing subsound in a sentence time in bytes, related to PCM samples * channels * datawidth (ie 16bit = 2 bytes). */
	public static final int FMOD_TIMEUNIT_SENTENCE_PCMBYTES = 0x00040000;
	/** Currently playing sentence index according to the channel. */
	public static final int FMOD_TIMEUNIT_SENTENCE = 0x00080000;
	/** Currently playing subsound index in a sentence. */
	public static final int FMOD_TIMEUNIT_SENTENCE_SUBSOUND = 0x00100000;
	/** Time value as seen by buffered stream.  This is always ahead of audible time, and is only used for processing. */
	public static final int FMOD_TIMEUNIT_BUFFERED = 0x10000000;
}
