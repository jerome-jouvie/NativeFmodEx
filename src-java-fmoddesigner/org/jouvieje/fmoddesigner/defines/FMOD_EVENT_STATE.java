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
 * These values describe what state an event is in.<BR>
 * <BR><U><B>Remarks</B></U><BR><BR>
 * The flags below can be combined to set multiple states at once.  Use bitwise AND operations to test for these.<BR>
 * An example of a combined flag set would be FMOD_EVENT_STATE_READY | FMOD_EVENT_STATE_PLAYING.<BR>
 * <BR><U><B>Platforms Supported</B></U><BR><BR>
 * Win32, Win64, Linux, Macintosh, Xbox, Xbox360, PlayStation 2, GameCube, PlayStation Portable, PlayStation 3, Wii<BR>
 * <BR><U><B>See Also</B></U><BR><BR>
 * Event::getState<BR>
 * FMOD_EVENT_MODE<BR>
 * 
 */
public interface FMOD_EVENT_STATE {
	/** Event is ready to play. */
	public static final int FMOD_EVENT_STATE_READY = 0x00000001;
	/** Loading in progress. */
	public static final int FMOD_EVENT_STATE_LOADING = 0x00000002;
	/** Failed to open - file not found, out of memory etc.  See return value of Event::getState for what happened. */
	public static final int FMOD_EVENT_STATE_ERROR = 0x00000004;
	/** Event has been started.  This will still be true even if there are no sounds active.  Event::stop must be called or the event must stop itself using a 'one shot and stop event' parameter mode. */
	public static final int FMOD_EVENT_STATE_PLAYING = 0x00000008;
	/** Event has active voices.  Use this if you want to detect if sounds are playing in the event or not. */
	public static final int FMOD_EVENT_STATE_CHANNELSACTIVE = 0x00000010;
	/** Event was loaded with the FMOD_EVENT_INFOONLY flag. */
	public static final int FMOD_EVENT_STATE_INFOONLY = 0x00000020;
	/** Event is streaming but not being fed data in time, so may be stuttering. */
	public static final int FMOD_EVENT_STATE_STARVING = 0x00000040;
}
