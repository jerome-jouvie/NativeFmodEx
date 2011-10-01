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
 * Values for the Flags member of the FMOD_REVERB_CHANNELPROPERTIES structure.<BR>
 * <BR><U><B>Remarks</B></U><BR><BR>
 * For EAX4,EAX5 and SFX, there is support for multiple reverb environments.<BR>
 * Use FMOD_REVERB_CHANNELFLAGS_ENVIRONMENT0 to FMOD_REVERB_CHANNELFLAGS_ENVIRONMENT3 in the flags member<BR>
 * of FMOD_REVERB_CHANNELPROPERTIES to specify which environment instance(s) to target.<BR>
 * - If you do not specify any instance the first reverb instance will be used.<BR>
 * - If you specify more than one instance with getReverbProperties, the first instance will be used.<BR>
 * - If you specify more than one instance with setReverbProperties, it will set more than 1 instance at once.<BR>
 * <BR><U><B>Platforms Supported</B></U><BR><BR>
 * Win32, Win64, Linux, Linux64, Macintosh, Xbox360, PlayStation 2, PlayStation Portable, PlayStation 3, Wii, Solaris, iPhone<BR>
 * <BR><U><B>See Also</B></U><BR><BR>
 * FMOD_REVERB_CHANNELPROPERTIES<BR>
 * 
 */
public interface FMOD_REVERB_CHANNELFLAGS {
	/** Automatic setting of 'Direct'  due to distance from listener */
	public static final int FMOD_REVERB_CHANNELFLAGS_DIRECTHFAUTO = 0x00000001;
	/** Automatic setting of 'Room'  due to distance from listener */
	public static final int FMOD_REVERB_CHANNELFLAGS_ROOMAUTO = 0x00000002;
	/** Automatic setting of 'RoomHF' due to distance from listener */
	public static final int FMOD_REVERB_CHANNELFLAGS_ROOMHFAUTO = 0x00000004;
	/** EAX4/SFX/GameCube/Wii. Specify channel to target reverb instance 0.  Default target. */
	public static final int FMOD_REVERB_CHANNELFLAGS_INSTANCE0 = 0x00000010;
	/** EAX4/SFX/GameCube/Wii. Specify channel to target reverb instance 1. */
	public static final int FMOD_REVERB_CHANNELFLAGS_INSTANCE1 = 0x00000020;
	/** EAX4/SFX/GameCube/Wii. Specify channel to target reverb instance 2. */
	public static final int FMOD_REVERB_CHANNELFLAGS_INSTANCE2 = 0x00000040;
	/** EAX5/SFX. Specify channel to target reverb instance 3. */
	public static final int FMOD_REVERB_CHANNELFLAGS_INSTANCE3 = 0x00000080;
	/**  */
	public static final int FMOD_REVERB_CHANNELFLAGS_DEFAULT = (0x00000001 | FMOD_REVERB_CHANNELFLAGS_ROOMAUTO| FMOD_REVERB_CHANNELFLAGS_ROOMHFAUTO| 0x00000010);
}
