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

package org.jouvieje.fmoddesigner.enumerations;

import org.jouvieje.fmoddesigner.*;
import org.jouvieje.fmodex.exceptions.*;
import org.jouvieje.fmoddesigner.callbacks.*;
import org.jouvieje.fmoddesigner.*;
import org.jouvieje.fmoddesigner.defines.*;
import org.jouvieje.fmoddesigner.enumerations.*;
import org.jouvieje.fmoddesigner.structures.*;
import java.nio.*;
import org.jouvieje.fmodex.*;
import org.jouvieje.fmodex.System;
import org.jouvieje.fmodex.enumerations.*;
import org.jouvieje.fmodex.structures.*;
import org.jouvieje.fmodex.utils.*;
import java.util.HashMap;

/**
 * <BR>
 * <BR>
 * These callback types are used with FMOD_EVENT_CALLBACK.<BR>
 * <BR><U><B>Remarks</B></U><BR><BR>
 * <b>Note!</b> Currently the user must call EventSystem::update for these callbacks to trigger!<p><BR>
 * When the event callback is called, 'param1' and 'param2' mean different things depending on the type of callback. Here is an explanation of what these parameters<BR>
 * mean in what context :<p>&nbsp;<p><BR>
 * <b>FMOD_EVENT_CALLBACKTYPE_SYNCPOINT</b><BR>
 * <p><BR>
 * param1 = (char *) name of sync point<br><BR>
 * param2 = (unsigned int) PCM offset of sync point.<br><BR>
 * <p><BR>
 * An FMOD_EVENT_CALLBACKTYPE_SYNCPOINT callback is generated from 'markers' embedded in .wav files.<BR>
 * These can be created by placing 'markers' in the original source wavs using a tool such as Sound Forge or Cooledit.<BR>
 * The wavs are then compiled into .FSB files when compiling the audio data using the FMOD designer tool.<BR>
 * Callbacks will be automatically generated at the correct place in the timeline when these markers are encountered<BR>
 * which makes it useful for synchronization, lip syncing etc.<BR>
 * <p>&nbsp;<p><BR>
 * <b>FMOD_EVENT_CALLBACKTYPE_SOUNDDEF_START</b><BR>
 * <p><BR>
 * param1 = (char *) name of sound definition being started<br><BR>
 * param2 = (int) index of wave being started inside sound definition (ie for multi wave sound definitions)<br><BR>
 * <p><BR>
 * An FMOD_EVENT_CALLBACKTYPE_SOUNDDEF_START callback is generated each time a sound definition is played in an event.<BR>
 * This happens every time a sound definition starts due to the event parameter entering the region specified in the<BR>
 * layer created by the sound designer.<BR>
 * This also happens when sounds are randomly respawned using the random respawn feature in the sound definition<BR>
 * properties in FMOD designer.<BR>
 * <p>&nbsp;<p><BR>
 * <b>FMOD_EVENT_CALLBACKTYPE_SOUNDDEF_END</b><BR>
 * <p><BR>
 * param1 = (char *) name of sound definition being stopped<br><BR>
 * param2 = (int) index of wave being stopped inside sound definition (ie for multi wave sound definitions)<br><BR>
 * <p><BR>
 * An FMOD_EVENT_CALLBACKTYPE_SOUNDDEF_END callback is generated when a one-shot sound definition inside an event ends,<BR>
 * or when a looping sound definition stops due to the event parameter leaving the region specified in the layer created<BR>
 * by the sound designer.<BR>
 * <p>&nbsp;<p><BR>
 * <b>FMOD_EVENT_CALLBACKTYPE_STOLEN</b><BR>
 * <p><BR>
 * param1 = 0<br><BR>
 * param2 = 0<br><BR>
 * <p><BR>
 * An FMOD_EVENT_CALLBACKTYPE_STOLEN callback is generated when a getEventXXX call needs to steal an event instance that is in use because<BR>
 * the event's "Max playbacks" has been exceeded. This callback is called before the event is stolen and before the event<BR>
 * is stopped (if it is playing). An FMOD_EVENT_CALLBACKTYPE_EVENTFINISHED callback will be generated when the stolen event is stopped i.e. <b>after</b><BR>
 * the FMOD_EVENT_CALLBACKTYPE_STOLEN. If the callback function returns FMOD_ERR_EVENT_FAILED, the event will <b>not</b><BR>
 * be stolen, and the returned value will be passed back as the return value of the getEventXXX call that triggered the steal attempt.<BR>
 * <p>&nbsp;<p><BR>
 * <b>FMOD_EVENT_CALLBACKTYPE_EVENTFINISHED</b><BR>
 * <p><BR>
 * param1 = 0<br><BR>
 * param2 = 0<br><BR>
 * <p><BR>
 * An FMOD_EVENT_CALLBACKTYPE_EVENTFINISHED callback is generated whenever an event is stopped for any reason including when the user<BR>
 * calls Event::stop().<BR>
 * <p>&nbsp;<p><BR>
 * <b>FMOD_EVENT_CALLBACKTYPE_NET_MODIFIED</b><BR>
 * <p><BR>
 * param1 = (FMOD_EVENT_PROPERTY) which property was modified<br><BR>
 * param2 = (float) the new property value<br><BR>
 * <p><BR>
 * An FMOD_EVENT_CALLBACKTYPE_NET_MODIFIED callback is generated when someone has connected to your running application with<BR>
 * FMOD Designer and changed a property within this event, for example volume or pitch.<BR>
 * <p>&nbsp;<p><BR>
 * <b>FMOD_EVENT_CALLBACKTYPE_SOUNDDEF_CREATE</b><BR>
 * <p><BR>
 * param1 = (char *) name of sound definition<br><BR>
 * param2 [in] = (int *) pointer to index of sound definition entry<br><BR>
 * param2 [out] = (FMOD::Sound **) pointer to a valid lower level API FMOD Sound handle<br><BR>
 * <p><BR>
 * An FMOD_EVENT_CALLBACKTYPE_SOUNDDEF_CREATE callback is generated when a "programmer" sound needs to be loaded.<BR>
 * <p>&nbsp;<p><BR>
 * <b>FMOD_EVENT_CALLBACKTYPE_SOUNDDEF_RELEASE</b><BR>
 * <p><BR>
 * param1 = (char *) name of sound definition<br><BR>
 * param2 = (FMOD::Sound *) the FMOD sound handle that was previously created in FMOD_EVENT_CALLBACKTYPE_SOUNDDEF_CREATE<br><BR>
 * <p><BR>
 * An FMOD_EVENT_CALLBACKTYPE_SOUNDDEF_RELEASE callback is generated when a "programmer" sound needs to be unloaded.<BR>
 * <p>&nbsp;<p><BR>
 * <b>FMOD_EVENT_CALLBACKTYPE_SOUNDDEF_INFO</b><BR>
 * <p><BR>
 * param1 = (char *) name of sound definition<br><BR>
 * param2 = (FMOD::Sound *) the FMOD sound handle that FMOD will use for this sound definition<br><BR>
 * <p><BR>
 * An FMOD_EVENT_CALLBACKTYPE_SOUNDDEF_INFO callback is generated when a sound definition is loaded. It can be used to find<BR>
 * information about the specific sound that will be played.<BR>
 * <p>&nbsp;<p><BR>
 * <b>FMOD_EVENT_CALLBACKTYPE_EVENTSTARTED</b><BR>
 * <p><BR>
 * param1 = 0<br><BR>
 * param2 = 0<br><BR>
 * <p><BR>
 * An FMOD_EVENT_CALLBACKTYPE_EVENTSTARTED callback is generated whenever an event is started. This callback will be called before any sounds in the event have begun to play.<BR>
 * <p>&nbsp;<p><BR>
 * <b>FMOD_EVENT_CALLBACKTYPE_SOUNDDEF_SELECTINDEX</b><BR>
 * <p><BR>
 * param1 = (char *) name of sound definition if FMOD_EVENT_INIT_DETAILED_SOUNDDEF_INFO was not specified<br><BR>
 * param1 = (FMOD_EVENT_SOUNDDEFINFO *) sound definition info struct if FMOD_EVENT_INIT_DETAILED_SOUNDDEF_INFO was specified<br><BR>
 * param2 [in] = (int *) pointer to number of entries in this sound definition<br><BR>
 * *param2 [out] = (int) index of sound definition entry to select<br><BR>
 * <p><BR>
 * An FMOD_EVENT_CALLBACKTYPE_SOUNDDEF_SELECTINDEX callback is generated when a sound definition entry needs to be chosen from a "ProgrammerSelected" sound definition.<BR>
 * <p>&nbsp;<p><BR>
 * <b>FMOD_EVENT_CALLBACKTYPE_OCCLUSION</b><BR>
 * <p><BR>
 * param1 = (float *) pointer to a floating point direct value that can be read and modified after the geometry engine has calculated it for this event's channel.<br><BR>
 * param2 = (float *) pointer to a floating point reverb value that can be read and modified after the geometry engine has calculated it for this event's channel.<br><BR>
 * <p><BR>
 * An FMOD_EVENT_CALLBACKTYPE_OCCLUSION callback is generated whenever an channel has its occlusion updated via the geometry system.<BR>
 * <p>&nbsp;<p><BR>
 * <BR><U><B>Platforms Supported</B></U><BR><BR>
 * Win32, Win64, Linux, Macintosh, Xbox, Xbox360, PlayStation 2, GameCube, PlayStation Portable, PlayStation 3, Wii<BR>
 * <BR><U><B>See Also</B></U><BR><BR>
 * Event::setCallback<BR>
 * FMOD_EVENT_CALLBACK<BR>
 * FMOD_EVENT_SOUNDDEFINFO<BR>
 * FMOD_EVENT_INITFLAGS<BR>
 * EventSystem::update<BR>
 * 
 */
public class FMOD_EVENT_CALLBACKTYPE implements Enumeration, Comparable {
	/**  */
	public final static FMOD_EVENT_CALLBACKTYPE FMOD_EVENT_CALLBACKTYPE_SYNCPOINT = new FMOD_EVENT_CALLBACKTYPE("FMOD_EVENT_CALLBACKTYPE_SYNCPOINT", EnumerationJNI.get_FMOD_EVENT_CALLBACKTYPE_SYNCPOINT());
	/**  */
	public final static FMOD_EVENT_CALLBACKTYPE FMOD_EVENT_CALLBACKTYPE_SOUNDDEF_START = new FMOD_EVENT_CALLBACKTYPE("FMOD_EVENT_CALLBACKTYPE_SOUNDDEF_START", EnumerationJNI.get_FMOD_EVENT_CALLBACKTYPE_SOUNDDEF_START());
	/**  */
	public final static FMOD_EVENT_CALLBACKTYPE FMOD_EVENT_CALLBACKTYPE_SOUNDDEF_END = new FMOD_EVENT_CALLBACKTYPE("FMOD_EVENT_CALLBACKTYPE_SOUNDDEF_END", EnumerationJNI.get_FMOD_EVENT_CALLBACKTYPE_SOUNDDEF_END());
	/**  */
	public final static FMOD_EVENT_CALLBACKTYPE FMOD_EVENT_CALLBACKTYPE_STOLEN = new FMOD_EVENT_CALLBACKTYPE("FMOD_EVENT_CALLBACKTYPE_STOLEN", EnumerationJNI.get_FMOD_EVENT_CALLBACKTYPE_STOLEN());
	/**  */
	public final static FMOD_EVENT_CALLBACKTYPE FMOD_EVENT_CALLBACKTYPE_EVENTFINISHED = new FMOD_EVENT_CALLBACKTYPE("FMOD_EVENT_CALLBACKTYPE_EVENTFINISHED", EnumerationJNI.get_FMOD_EVENT_CALLBACKTYPE_EVENTFINISHED());
	/**  */
	public final static FMOD_EVENT_CALLBACKTYPE FMOD_EVENT_CALLBACKTYPE_NET_MODIFIED = new FMOD_EVENT_CALLBACKTYPE("FMOD_EVENT_CALLBACKTYPE_NET_MODIFIED", EnumerationJNI.get_FMOD_EVENT_CALLBACKTYPE_NET_MODIFIED());
	/**  */
	public final static FMOD_EVENT_CALLBACKTYPE FMOD_EVENT_CALLBACKTYPE_SOUNDDEF_CREATE = new FMOD_EVENT_CALLBACKTYPE("FMOD_EVENT_CALLBACKTYPE_SOUNDDEF_CREATE", EnumerationJNI.get_FMOD_EVENT_CALLBACKTYPE_SOUNDDEF_CREATE());
	/**  */
	public final static FMOD_EVENT_CALLBACKTYPE FMOD_EVENT_CALLBACKTYPE_SOUNDDEF_RELEASE = new FMOD_EVENT_CALLBACKTYPE("FMOD_EVENT_CALLBACKTYPE_SOUNDDEF_RELEASE", EnumerationJNI.get_FMOD_EVENT_CALLBACKTYPE_SOUNDDEF_RELEASE());
	/**  */
	public final static FMOD_EVENT_CALLBACKTYPE FMOD_EVENT_CALLBACKTYPE_SOUNDDEF_INFO = new FMOD_EVENT_CALLBACKTYPE("FMOD_EVENT_CALLBACKTYPE_SOUNDDEF_INFO", EnumerationJNI.get_FMOD_EVENT_CALLBACKTYPE_SOUNDDEF_INFO());
	/**  */
	public final static FMOD_EVENT_CALLBACKTYPE FMOD_EVENT_CALLBACKTYPE_EVENTSTARTED = new FMOD_EVENT_CALLBACKTYPE("FMOD_EVENT_CALLBACKTYPE_EVENTSTARTED", EnumerationJNI.get_FMOD_EVENT_CALLBACKTYPE_EVENTSTARTED());
	/**  */
	public final static FMOD_EVENT_CALLBACKTYPE FMOD_EVENT_CALLBACKTYPE_SOUNDDEF_SELECTINDEX = new FMOD_EVENT_CALLBACKTYPE("FMOD_EVENT_CALLBACKTYPE_SOUNDDEF_SELECTINDEX", EnumerationJNI.get_FMOD_EVENT_CALLBACKTYPE_SOUNDDEF_SELECTINDEX());
	/**  */
	public final static FMOD_EVENT_CALLBACKTYPE FMOD_EVENT_CALLBACKTYPE_OCCLUSION = new FMOD_EVENT_CALLBACKTYPE("FMOD_EVENT_CALLBACKTYPE_OCCLUSION", EnumerationJNI.get_FMOD_EVENT_CALLBACKTYPE_OCCLUSION());

	private final static HashMap VALUES = new HashMap(2*12);
	static {
		VALUES.put(new Integer(FMOD_EVENT_CALLBACKTYPE_SYNCPOINT.asInt()), FMOD_EVENT_CALLBACKTYPE_SYNCPOINT);
		VALUES.put(new Integer(FMOD_EVENT_CALLBACKTYPE_SOUNDDEF_START.asInt()), FMOD_EVENT_CALLBACKTYPE_SOUNDDEF_START);
		VALUES.put(new Integer(FMOD_EVENT_CALLBACKTYPE_SOUNDDEF_END.asInt()), FMOD_EVENT_CALLBACKTYPE_SOUNDDEF_END);
		VALUES.put(new Integer(FMOD_EVENT_CALLBACKTYPE_STOLEN.asInt()), FMOD_EVENT_CALLBACKTYPE_STOLEN);
		VALUES.put(new Integer(FMOD_EVENT_CALLBACKTYPE_EVENTFINISHED.asInt()), FMOD_EVENT_CALLBACKTYPE_EVENTFINISHED);
		VALUES.put(new Integer(FMOD_EVENT_CALLBACKTYPE_NET_MODIFIED.asInt()), FMOD_EVENT_CALLBACKTYPE_NET_MODIFIED);
		VALUES.put(new Integer(FMOD_EVENT_CALLBACKTYPE_SOUNDDEF_CREATE.asInt()), FMOD_EVENT_CALLBACKTYPE_SOUNDDEF_CREATE);
		VALUES.put(new Integer(FMOD_EVENT_CALLBACKTYPE_SOUNDDEF_RELEASE.asInt()), FMOD_EVENT_CALLBACKTYPE_SOUNDDEF_RELEASE);
		VALUES.put(new Integer(FMOD_EVENT_CALLBACKTYPE_SOUNDDEF_INFO.asInt()), FMOD_EVENT_CALLBACKTYPE_SOUNDDEF_INFO);
		VALUES.put(new Integer(FMOD_EVENT_CALLBACKTYPE_EVENTSTARTED.asInt()), FMOD_EVENT_CALLBACKTYPE_EVENTSTARTED);
		VALUES.put(new Integer(FMOD_EVENT_CALLBACKTYPE_SOUNDDEF_SELECTINDEX.asInt()), FMOD_EVENT_CALLBACKTYPE_SOUNDDEF_SELECTINDEX);
		VALUES.put(new Integer(FMOD_EVENT_CALLBACKTYPE_OCCLUSION.asInt()), FMOD_EVENT_CALLBACKTYPE_OCCLUSION);
	}

	private final String name;
	private final int nativeValue;
	private FMOD_EVENT_CALLBACKTYPE(String name, int nativeValue) {
		this.name = name;
		this.nativeValue = nativeValue;
	}

	public int asInt() {
		return nativeValue;
	}
	public String toString() {
		return name;
	}
	public boolean equals(Object object) {
		if(object instanceof FMOD_EVENT_CALLBACKTYPE) {
			return asInt() == ((FMOD_EVENT_CALLBACKTYPE)object).asInt();
		}
		return false;
	}
	public int compareTo(Object object) {
		return asInt() - ((FMOD_EVENT_CALLBACKTYPE)object).asInt();
	}


	/**
	 * Retrieve a FMOD_EVENT_CALLBACKTYPE enum field with his integer value
	 * @param nativeValue the integer value of the field to retrieve
	 * @return the FMOD_EVENT_CALLBACKTYPE enum field that correspond to the integer value
	 */
	public static FMOD_EVENT_CALLBACKTYPE get(int nativeValue) {
		return (FMOD_EVENT_CALLBACKTYPE)VALUES.get(new Integer(nativeValue));
	}

	/**
	 * Retrieve a FMOD_EVENT_CALLBACKTYPE enum field from a Pointer
	 * @param pointer a pointer holding an FMOD_EVENT_CALLBACKTYPE enum field
	 * @return the FMOD_EVENT_CALLBACKTYPE enum field that correspond to the enum field in the pointer
	 */
	public static FMOD_EVENT_CALLBACKTYPE get(Pointer pointer) {
		return get(pointer.asInt());
	}

	/**
	 * @return an <code>Iterator</code> over the elements in this enumeration.<BR>
	 * Can be cast to <code>Iterator<FMOD_EVENT_CALLBACKTYPE></code> in Java 1.5.
	 */
	public static java.util.Iterator iterator() {
		return new java.util.Iterator(){
			private java.util.Iterator i = VALUES.values().iterator();	//Wrapper of the HashMap iterator
			public boolean hasNext() { return i.hasNext(); }
			public Object next() { return i.next(); }
			public void remove() { throw new UnsupportedOperationException(); }
		};
	}
}
