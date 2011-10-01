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
 * Event data loading bitfields. Bitwise OR them together for controlling how event data is loaded.<BR>
 * <BR><U><B>Remarks</B></U><BR><BR>
 * <BR><U><B>Platforms Supported</B></U><BR><BR>
 * Win32, Win64, Linux, Macintosh, Xbox, Xbox360, PlayStation 2, GameCube, PlayStation Portable, PlayStation 3, Wii<BR>
 * <BR><U><B>See Also</B></U><BR><BR>
 * EventGroup::loadEventData<BR>
 * EventGroup::getEvent<BR>
 * EventGroup::getEventByIndex<BR>
 * 
 */
public interface FMOD_EVENT_MODE {
	/** FMOD_EVENT_DEFAULT specifies default loading behaviour i.e. event data for the whole group is NOT cached and the function that initiated the loading process will block until loading is complete. */
	public static final int FMOD_EVENT_DEFAULT = 0x00000000;
	/** For loading event data asynchronously. FMOD will use a thread to load the data.  Use Event::getState to find out when loading is complete. */
	public static final int FMOD_EVENT_NONBLOCKING = 0x00000001;
	/** For EventGroup::getEvent / EventGroup::getEventByIndex.  If EventGroup::loadEventData has accidently been forgotten this flag will return an FMOD_ERR_FILE_UNWANTED if the getEvent function tries to load data. */
	public static final int FMOD_EVENT_ERROR_ON_DISKACCESS = 0x00000002;
	/** For EventGroup::getEvent / EventGroup::getEventByIndex.  Don't allocate instances or load data, just get a handle to allow user to get information from the event. */
	public static final int FMOD_EVENT_INFOONLY = 0x00000004;
	/** For EventGroup::getEvent / EventGroup::getEventByIndex.  Tells FMOD that you plan to add your own DSP effects to this event's ChannelGroup at runtime. Omitting this flag will yield a small memory gain. */
	public static final int FMOD_EVENT_USERDSP = 0x00000008;
}
