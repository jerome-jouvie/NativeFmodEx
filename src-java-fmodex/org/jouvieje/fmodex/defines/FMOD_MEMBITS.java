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
 * Bitfield used to request specific memory usage information from the getMemoryInfo function of every public FMOD Ex class.<BR>
 * Use with the "memorybits" parameter of getMemoryInfo to get information on FMOD Ex memory usage.<BR>
 * <BR><U><B>Remarks</B></U><BR><BR>
 * Every public FMOD class has a getMemoryInfo function which can be used to get detailed information on what memory resources are associated with the object in question.<BR>
 * The FMOD_MEMBITS defines can be OR'd together to specify precisely what memory usage you'd like to get information on. See System::getMemoryInfo for an example.<BR>
 * <BR><U><B>Platforms Supported</B></U><BR><BR>
 * Win32, Win64, Linux, Linux64, Macintosh, Xbox360, PlayStation 2, PlayStation Portable, PlayStation 3, Wii, Solaris, iPhone<BR>
 * <BR><U><B>See Also</B></U><BR><BR>
 * FMOD_EVENT_MEMBITS<BR>
 * System::getMemoryInfo<BR>
 * 
 */
public interface FMOD_MEMBITS {
	/** Memory not accounted for by other types */
	public static final int FMOD_MEMBITS_OTHER = 0x00000001;
	/** String data */
	public static final int FMOD_MEMBITS_STRING = 0x00000002;
	/** System object and various internals */
	public static final int FMOD_MEMBITS_SYSTEM = 0x00000004;
	/** Plugin objects and internals */
	public static final int FMOD_MEMBITS_PLUGINS = 0x00000008;
	/** Output module object and internals */
	public static final int FMOD_MEMBITS_OUTPUT = 0x00000010;
	/** Channel related memory */
	public static final int FMOD_MEMBITS_CHANNEL = 0x00000020;
	/** ChannelGroup objects and internals */
	public static final int FMOD_MEMBITS_CHANNELGROUP = 0x00000040;
	/** Codecs allocated for streaming */
	public static final int FMOD_MEMBITS_CODEC = 0x00000080;
	/** Codecs allocated for streaming */
	public static final int FMOD_MEMBITS_FILE = 0x00000100;
	/** Sound objects and internals */
	public static final int FMOD_MEMBITS_SOUND = 0x00000200;
	/** Sound data stored in secondary RAM */
	public static final int FMOD_MEMBITS_SOUND_SECONDARYRAM = 0x00000400;
	/** SoundGroup objects and internals */
	public static final int FMOD_MEMBITS_SOUNDGROUP = 0x00000800;
	/** Stream buffer memory */
	public static final int FMOD_MEMBITS_STREAMBUFFER = 0x00001000;
	/** DSPConnection objects and internals */
	public static final int FMOD_MEMBITS_DSPCONNECTION = 0x00002000;
	/** DSP implementation objects */
	public static final int FMOD_MEMBITS_DSP = 0x00004000;
	/** Realtime file format decoding DSP objects */
	public static final int FMOD_MEMBITS_DSPCODEC = 0x00008000;
	/** Profiler memory footprint. */
	public static final int FMOD_MEMBITS_PROFILE = 0x00010000;
	/** Buffer used to store recorded data from microphone */
	public static final int FMOD_MEMBITS_RECORDBUFFER = 0x00020000;
	/** Reverb implementation objects */
	public static final int FMOD_MEMBITS_REVERB = 0x00040000;
	/** Reverb channel properties structs */
	public static final int FMOD_MEMBITS_REVERBCHANNELPROPS = 0x00080000;
	/** Geometry objects and internals */
	public static final int FMOD_MEMBITS_GEOMETRY = 0x00100000;
	/** Sync point memory. */
	public static final int FMOD_MEMBITS_SYNCPOINT = 0x00200000;
	/** All memory used by FMOD Ex */
	public static final int FMOD_MEMBITS_ALL = 0xffffffff;
}
