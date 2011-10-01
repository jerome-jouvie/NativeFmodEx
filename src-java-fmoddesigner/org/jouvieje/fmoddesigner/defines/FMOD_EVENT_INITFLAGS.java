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

package org.jouvieje.fmoddesigner.defines;

/**
 * <BR>
 * Initialization flags.  Use them with EventSystem::init in the eventflags parameter to change various behaviour.<BR>
 * <BR><U><B>Remarks</B></U><BR><BR>
 * <BR><U><B>Platforms Supported</B></U><BR><BR>
 * Win32, Win64, Linux, Linux64, Macintosh, Xbox, Xbox360, PlayStation 2, GameCube, PlayStation Portable, PlayStation 3<BR>
 * <BR><U><B>See Also</B></U><BR><BR>
 * EventSystem::init<BR>
 * EventSystem::getEventByGUID<BR>
 * FMOD_EVENT_SOUNDDEFINFO<BR>
 * FMOD_EVENT_CALLBACKTYPE<BR>
 * 
 */
public interface FMOD_EVENT_INITFLAGS {
	/** All platforms - Initialize normally */
	public static final int FMOD_EVENT_INIT_NORMAL = 0x00000000;
	/** All platforms - All wave data loading/freeing will be referred back to the user through the event callback */
	public static final int FMOD_EVENT_INIT_USER_ASSETMANAGER = 0x00000001;
	/** All platforms - Events will fail if "Max streams" was reached when playing streamed banks, instead of going virtual. */
	public static final int FMOD_EVENT_INIT_FAIL_ON_MAXSTREAMS = 0x00000002;
	/** All platforms - All event/eventgroup/eventparameter/eventcategory/eventreverb names will be discarded on load. Use getXXXByIndex to access them. This may potentially save a lot of memory at runtime. */
	public static final int FMOD_EVENT_INIT_DONTUSENAMES = 0x00000004;
	/** All platforms - All FSB filenames will be translated to upper case before being used. */
	public static final int FMOD_EVENT_INIT_UPPERCASE_FILENAMES = 0x00000008;
	/** All platforms - All FSB filenames will be translated to lower case before being used. */
	public static final int FMOD_EVENT_INIT_LOWERCASE_FILENAMES = 0x00000080;
	/** All platforms - Search the current directory for dsp/codec plugins on EventSystem::init. */
	public static final int FMOD_EVENT_INIT_SEARCH_PLUGINS = 0x00000010;
	/** All platforms - Build an event GUID table when loading FEVs so that EventSystem::getEventByGUID can be used. */
	public static final int FMOD_EVENT_INIT_USE_GUIDS = 0x00000020;
	/** All platforms - Pass an FMOD_EVENT_SOUNDDEFINFO struct to FMOD_EVENT_CALLBACKTYPE_SOUNDDEF_SELECTINDEX callbacks rather than just the sound definition name (uses more memory for sound definition waveform names). */
	public static final int FMOD_EVENT_INIT_DETAILED_SOUNDDEF_INFO = 0x00000040;
	/** All platforms - Reset parameters to minimum value when getting an event instance instead of using the INFO_ONLY event's values. */
	public static final int FMOD_EVENT_INIT_RESETPARAMSTOMINIMUM = 0x00000100;
}
