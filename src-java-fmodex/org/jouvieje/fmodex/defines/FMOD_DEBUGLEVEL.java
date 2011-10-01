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

package org.jouvieje.fmodex.defines;

/**
 * <BR>
 * Bit fields to use with FMOD::Debug_SetLevel / FMOD::Debug_GetLevel to control the level of tty debug output with logging versions of FMOD (fmodL).<BR>
 * <BR><U><B>Remarks</B></U><BR><BR>
 * <BR><U><B>Platforms Supported</B></U><BR><BR>
 * Win32, Win64, Linux, Linux64, Macintosh, Xbox360, PlayStation 2, PlayStation Portable, PlayStation 3, Wii, Solaris, iPhone<BR>
 * <BR><U><B>See Also</B></U><BR><BR>
 * Debug_SetLevel<BR>
 * Debug_GetLevel<BR>
 * 
 */
public interface FMOD_DEBUGLEVEL {
	/**  */
	public static final int FMOD_DEBUG_LEVEL_NONE = 0x00000000;
	/**  */
	public static final int FMOD_DEBUG_LEVEL_LOG = 0x00000001;
	/**  */
	public static final int FMOD_DEBUG_LEVEL_ERROR = 0x00000002;
	/**  */
	public static final int FMOD_DEBUG_LEVEL_WARNING = 0x00000004;
	/**  */
	public static final int FMOD_DEBUG_LEVEL_HINT = 0x00000008;
	/**  */
	public static final int FMOD_DEBUG_LEVEL_ALL = 0x000000FF;
	/**  */
	public static final int FMOD_DEBUG_TYPE_MEMORY = 0x00000100;
	/**  */
	public static final int FMOD_DEBUG_TYPE_THREAD = 0x00000200;
	/**  */
	public static final int FMOD_DEBUG_TYPE_FILE = 0x00000400;
	/**  */
	public static final int FMOD_DEBUG_TYPE_NET = 0x00000800;
	/**  */
	public static final int FMOD_DEBUG_TYPE_EVENT = 0x00001000;
	/**  */
	public static final int FMOD_DEBUG_TYPE_ALL = 0x0000FFFF;
	/**  */
	public static final int FMOD_DEBUG_DISPLAY_TIMESTAMPS = 0x01000000;
	/**  */
	public static final int FMOD_DEBUG_DISPLAY_LINENUMBERS = 0x02000000;
	/**  */
	public static final int FMOD_DEBUG_DISPLAY_COMPRESS = 0x04000000;
	/**  */
	public static final int FMOD_DEBUG_DISPLAY_THREAD = 0x08000000;
	/**  */
	public static final int FMOD_DEBUG_DISPLAY_ALL = 0x0F000000;
	/**  */
	public static final int FMOD_DEBUG_ALL = 0xFFFFFFFF;
}
