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
 * Values for the Flags member of the FMOD_REVERB_PROPERTIES structure.<BR>
 * <BR><U><B>Remarks</B></U><BR><BR>
 * <BR><U><B>Platforms Supported</B></U><BR><BR>
 * Win32, Win64, Linux, Linux64, Macintosh, Xbox360, PlayStation 2, PlayStation Portable, PlayStation 3, Wii, Solaris, iPhone<BR>
 * <BR><U><B>See Also</B></U><BR><BR>
 * FMOD_REVERB_PROPERTIES<BR>
 * 
 */
public interface FMOD_REVERB_FLAGS {
	/** 'EnvSize' affects reverberation decay time */
	public static final int FMOD_REVERB_FLAGS_DECAYTIMESCALE = 0x00000001;
	/** 'EnvSize' affects reflection level */
	public static final int FMOD_REVERB_FLAGS_REFLECTIONSSCALE = 0x00000002;
	/** 'EnvSize' affects initial reflection delay time */
	public static final int FMOD_REVERB_FLAGS_REFLECTIONSDELAYSCALE = 0x00000004;
	/** 'EnvSize' affects reflections level */
	public static final int FMOD_REVERB_FLAGS_REVERBSCALE = 0x00000008;
	/** 'EnvSize' affects late reverberation delay time */
	public static final int FMOD_REVERB_FLAGS_REVERBDELAYSCALE = 0x00000010;
	/** AirAbsorptionHF affects DecayHFRatio */
	public static final int FMOD_REVERB_FLAGS_DECAYHFLIMIT = 0x00000020;
	/** 'EnvSize' affects echo time */
	public static final int FMOD_REVERB_FLAGS_ECHOTIMESCALE = 0x00000040;
	/** 'EnvSize' affects modulation time */
	public static final int FMOD_REVERB_FLAGS_MODULATIONTIMESCALE = 0x00000080;
	/** PS2 Only - Reverb is applied to CORE0 (hw voices 0-23) */
	public static final int FMOD_REVERB_FLAGS_CORE0 = 0x00000100;
	/** PS2 Only - Reverb is applied to CORE1 (hw voices 24-47) */
	public static final int FMOD_REVERB_FLAGS_CORE1 = 0x00000200;
	/** GameCube/Wii. Use high quality reverb */
	public static final int FMOD_REVERB_FLAGS_HIGHQUALITYREVERB = 0x00000400;
	/** GameCube/Wii. Use high quality DPL2 reverb */
	public static final int FMOD_REVERB_FLAGS_HIGHQUALITYDPL2REVERB = 0x00000800;
	/**  */
	public static final int FMOD_REVERB_FLAGS_DEFAULT = (0x00000001 | 0x00000002 | 0x00000004 | 0x00000008 | 0x00000010 | 0x00000020 | 0x00000100 | 0x00000200);
}
