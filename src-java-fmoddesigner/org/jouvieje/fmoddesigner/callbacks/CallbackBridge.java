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

package org.jouvieje.fmoddesigner.callbacks;

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

class CallbackBridge extends Pointer {
	protected final static int NB_CALLBACKS = 3;

	public static int FMOD_EVENTQUEUE_CALLBACK_BRIDGE(int type, long queue, long entry, long callbackuserdata) {
		FMOD_EVENTQUEUE_CALLBACK callback = (FMOD_EVENTQUEUE_CALLBACK)CallbackManager.getCallback(0, type, false);
		try {
			FMOD_RESULT javaResult = callback.FMOD_EVENTQUEUE_CALLBACK(FMOD_EVENTQUEUE_CALLBACKTYPE.get(type), queue == 0 ? null : EventQueue.asEventQueue(Pointer.newPointer(queue)), entry == 0 ? null : EventQueueEntry.asEventQueueEntry(Pointer.newPointer(entry)), callbackuserdata == 0 ? null : Pointer.newPointer(callbackuserdata));
			return javaResult == null ? FMOD_RESULT.FMOD_RESULT_FORCEINT.asInt() : javaResult.asInt();
		} catch(Throwable throwable) {
			throwable.printStackTrace();
			return 0;
		}
	}
	public static int FMOD_EVENT_CALLBACK_BRIDGE(long event, int type, long param1, Pointer param2, long userdata) {
		FMOD_EVENT_CALLBACK callback = (FMOD_EVENT_CALLBACK)CallbackManager.getCallback(1, event, false);
		try {
			FMOD_RESULT javaResult = callback.FMOD_EVENT_CALLBACK(event == 0 ? null : Event.asEvent(Pointer.newPointer(event)), FMOD_EVENT_CALLBACKTYPE.get(type), param1 == 0 ? null : Pointer.newPointer(param1), param2, userdata == 0 ? null : Pointer.newPointer(userdata));
			return javaResult == null ? FMOD_RESULT.FMOD_RESULT_FORCEINT.asInt() : javaResult.asInt();
		} catch(Throwable throwable) {
			throwable.printStackTrace();
			return 0;
		}
	}
	public static int FMOD_MUSIC_CALLBACK_BRIDGE(int type, long param1, long param2, long userdata) {
		FMOD_MUSIC_CALLBACK callback = (FMOD_MUSIC_CALLBACK)CallbackManager.getCallback(2, type, false);
		try {
			FMOD_RESULT javaResult = callback.FMOD_MUSIC_CALLBACK(FMOD_MUSIC_CALLBACKTYPE.get(type), param1 == 0 ? null : Pointer.newPointer(param1), param2 == 0 ? null : Pointer.newPointer(param2), userdata == 0 ? null : Pointer.newPointer(userdata));
			return javaResult == null ? FMOD_RESULT.FMOD_RESULT_FORCEINT.asInt() : javaResult.asInt();
		} catch(Throwable throwable) {
			throwable.printStackTrace();
			return 0;
		}
	}

	protected static String getCallbackName(int type) {
		switch(type) {
			case 0: return "FMOD_EVENTQUEUE_CALLBACK";
			case 1: return "FMOD_EVENT_CALLBACK";
			case 2: return "FMOD_MUSIC_CALLBACK";
			default: return "UNKNOW_"+type;
		}
	}
}
