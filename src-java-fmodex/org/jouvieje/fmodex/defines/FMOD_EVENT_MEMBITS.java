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
 * Bitfield used to request specific memory usage information from the getMemoryInfo function of every public FMOD Event System class.<BR>
 * Use with the "event_memorybits" parameter of getMemoryInfo to get information on FMOD Event System memory usage.<BR>
 * <BR><U><B>Remarks</B></U><BR><BR>
 * Every public FMOD Event System class has a getMemoryInfo function which can be used to get detailed information on what memory resources are associated with the object in question.<BR>
 * The FMOD_EVENT_MEMBITS defines can be OR'd together to specify precisely what memory usage you'd like to get information on. See EventSystem::getMemoryInfo for an example.<BR>
 * <BR><U><B>Platforms Supported</B></U><BR><BR>
 * Win32, Win64, Linux, Linux64, Macintosh, Xbox360, PlayStation 2, PlayStation Portable, PlayStation 3, Wii, Solaris, iPhone<BR>
 * <BR><U><B>See Also</B></U><BR><BR>
 * FMOD_MEMBITS<BR>
 * System::getMemoryInfo<BR>
 * 
 */
public interface FMOD_EVENT_MEMBITS {
	/** EventSystem and various internals */
	public static final int FMOD_EVENT_MEMBITS_EVENTSYSTEM = 0x00000001;
	/** MusicSystem and various internals */
	public static final int FMOD_EVENT_MEMBITS_MUSICSYSTEM = 0x00000002;
	/** Definition of objects contained in all loaded projects e.g. events, groups, categories */
	public static final int FMOD_EVENT_MEMBITS_FEV = 0x00000004;
	/** Data loaded with registerMemoryFSB */
	public static final int FMOD_EVENT_MEMBITS_MEMORYFSB = 0x00000008;
	/** EventProject objects and internals */
	public static final int FMOD_EVENT_MEMBITS_EVENTPROJECT = 0x00000010;
	/** EventGroup objects and internals */
	public static final int FMOD_EVENT_MEMBITS_EVENTGROUPI = 0x00000020;
	/** Objects used to manage wave banks */
	public static final int FMOD_EVENT_MEMBITS_SOUNDBANKCLASS = 0x00000040;
	/** Data used to manage lists of wave bank usage */
	public static final int FMOD_EVENT_MEMBITS_SOUNDBANKLIST = 0x00000080;
	/** Stream objects and internals */
	public static final int FMOD_EVENT_MEMBITS_STREAMINSTANCE = 0x00000100;
	/** Sound definition objects */
	public static final int FMOD_EVENT_MEMBITS_SOUNDDEFCLASS = 0x00000200;
	/** Sound definition static data objects */
	public static final int FMOD_EVENT_MEMBITS_SOUNDDEFDEFCLASS = 0x00000400;
	/** Sound definition pool data */
	public static final int FMOD_EVENT_MEMBITS_SOUNDDEFPOOL = 0x00000800;
	/** Reverb definition objects */
	public static final int FMOD_EVENT_MEMBITS_REVERBDEF = 0x00001000;
	/** Reverb objects */
	public static final int FMOD_EVENT_MEMBITS_EVENTREVERB = 0x00002000;
	/** User property objects */
	public static final int FMOD_EVENT_MEMBITS_USERPROPERTY = 0x00004000;
	/** Event instance base objects */
	public static final int FMOD_EVENT_MEMBITS_EVENTINSTANCE = 0x00008000;
	/** Complex event instance objects */
	public static final int FMOD_EVENT_MEMBITS_EVENTINSTANCE_COMPLEX = 0x00010000;
	/** Simple event instance objects */
	public static final int FMOD_EVENT_MEMBITS_EVENTINSTANCE_SIMPLE = 0x00020000;
	/** Event layer instance objects */
	public static final int FMOD_EVENT_MEMBITS_EVENTINSTANCE_LAYER = 0x00040000;
	/** Event sound instance objects */
	public static final int FMOD_EVENT_MEMBITS_EVENTINSTANCE_SOUND = 0x00080000;
	/** Event envelope objects */
	public static final int FMOD_EVENT_MEMBITS_EVENTENVELOPE = 0x00100000;
	/** Event envelope definition objects */
	public static final int FMOD_EVENT_MEMBITS_EVENTENVELOPEDEF = 0x00200000;
	/** Event parameter objects */
	public static final int FMOD_EVENT_MEMBITS_EVENTPARAMETER = 0x00400000;
	/** Event category objects */
	public static final int FMOD_EVENT_MEMBITS_EVENTCATEGORY = 0x00800000;
	/** Event envelope point object+s */
	public static final int FMOD_EVENT_MEMBITS_EVENTENVELOPEPOINT = 0x01000000;
	/** Event instance pool data */
	public static final int FMOD_EVENT_MEMBITS_EVENTINSTANCEPOOL = 0x02000000;
	/** All memory used by FMOD Event System */
	public static final int FMOD_EVENT_MEMBITS_ALL = 0xffffffff;
	/**  */
	public static final int FMOD_EVENT_MEMBITS_EVENTINSTANCE_GROUP = (0x00008000 | 0x00010000 | 0x00020000 | 0x00040000 | 0x00080000);
	/**  */
	public static final int FMOD_EVENT_MEMBITS_SOUNDDEF_GROUP = (0x00000200 | 0x00000400 | 0x00000800);
}
