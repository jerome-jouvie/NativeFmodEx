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
 * Bit fields to use with System::getDriverCaps to determine the capabilities of a card / output device.<BR>
 * <BR><U><B>Remarks</B></U><BR><BR>
 * It is important to check FMOD_CAPS_HARDWARE_EMULATED on windows machines, to then adjust System::setDSPBufferSize to (1024, 10) to compensate for the higher latency.<BR>
 * <BR><U><B>Platforms Supported</B></U><BR><BR>
 * Win32, Win64, Linux, Linux64, Macintosh, Xbox360, PlayStation 2, PlayStation Portable, PlayStation 3, Wii, Solaris, iPhone<BR>
 * <BR><U><B>See Also</B></U><BR><BR>
 * System::getDriverCaps<BR>
 * System::setDSPBufferSize<BR>
 * 
 */
public interface FMOD_CAPS {
	/** Device has no special capabilities. */
	public static final int FMOD_CAPS_NONE = 0x00000000;
	/** Device supports hardware mixing. */
	public static final int FMOD_CAPS_HARDWARE = 0x00000001;
	/** User has device set to 'Hardware acceleration = off' in control panel, and now extra 200ms latency is incurred. */
	public static final int FMOD_CAPS_HARDWARE_EMULATED = 0x00000002;
	/** Device can do multichannel output, ie greater than 2 channels. */
	public static final int FMOD_CAPS_OUTPUT_MULTICHANNEL = 0x00000004;
	/** Device can output to 8bit integer PCM. */
	public static final int FMOD_CAPS_OUTPUT_FORMAT_PCM8 = 0x00000008;
	/** Device can output to 16bit integer PCM. */
	public static final int FMOD_CAPS_OUTPUT_FORMAT_PCM16 = 0x00000010;
	/** Device can output to 24bit integer PCM. */
	public static final int FMOD_CAPS_OUTPUT_FORMAT_PCM24 = 0x00000020;
	/** Device can output to 32bit integer PCM. */
	public static final int FMOD_CAPS_OUTPUT_FORMAT_PCM32 = 0x00000040;
	/** Device can output to 32bit floating point PCM. */
	public static final int FMOD_CAPS_OUTPUT_FORMAT_PCMFLOAT = 0x00000080;
	/** Device supports EAX2 reverb. */
	public static final int FMOD_CAPS_REVERB_EAX2 = 0x00000100;
	/** Device supports EAX3 reverb. */
	public static final int FMOD_CAPS_REVERB_EAX3 = 0x00000200;
	/** Device supports EAX4 reverb */
	public static final int FMOD_CAPS_REVERB_EAX4 = 0x00000400;
	/** Device supports EAX5 reverb */
	public static final int FMOD_CAPS_REVERB_EAX5 = 0x00000800;
	/** Device supports I3DL2 reverb. */
	public static final int FMOD_CAPS_REVERB_I3DL2 = 0x00001000;
	/** Device supports some form of limited hardware reverb, maybe parameterless and only selectable by environment. */
	public static final int FMOD_CAPS_REVERB_LIMITED = 0x00002000;
}
