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
 * Bit fields for memory allocation type being passed into FMOD memory callbacks.<BR>
 * <BR><U><B>Remarks</B></U><BR><BR>
 * Remember this is a bitfield.  You may get more than 1 bit set (ie physical + persistent) so do not simply switch on the types!  You must check each bit individually or clear out the bits that you do not want within the callback.<BR>
 * Bits can be excluded if you want during Memory_Initialize so that you never get them.<BR>
 * <BR><U><B>Platforms Supported</B></U><BR><BR>
 * Win32, Win64, Linux, Linux64, Macintosh, Xbox360, PlayStation 2, PlayStation Portable, PlayStation 3, Wii, Solaris, iPhone<BR>
 * <BR><U><B>See Also</B></U><BR><BR>
 * FMOD_MEMORY_ALLOCCALLBACK<BR>
 * FMOD_MEMORY_REALLOCCALLBACK<BR>
 * FMOD_MEMORY_FREECALLBACK<BR>
 * Memory_Initialize<BR>
 * 
 */
public interface FMOD_MEMORY_TYPE {
	/** Standard memory. */
	public static final int FMOD_MEMORY_NORMAL = 0x00000000;
	/** Stream file buffer, size controllable with System::setStreamBufferSize. */
	public static final int FMOD_MEMORY_STREAM_FILE = 0x00000001;
	/** Stream decode buffer, size controllable with FMOD_CREATESOUNDEXINFO::decodebuffersize. */
	public static final int FMOD_MEMORY_STREAM_DECODE = 0x00000002;
	/** Requires XPhysicalAlloc / XPhysicalFree. */
	public static final int FMOD_MEMORY_XBOX360_PHYSICAL = 0x00100000;
	/** Persistent memory. Memory will be freed when System::release is called. */
	public static final int FMOD_MEMORY_PERSISTENT = 0x00200000;
	/** Secondary memory. Allocation should be in secondary memory. For example RSX on the PS3. */
	public static final int FMOD_MEMORY_SECONDARY = 0x00400000;
	/**  */
	public static final int FMOD_MEMORY_ALL = 0xFFFFFFFF;
}
