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

package org.jouvieje.fmoddesigner;

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

public class FmodDesigner extends Pointer {
	/**
	 * Default port that the target (game) will listen on.
	 */
	public final static short FMOD_EVENT_NET_PORT = 17997;
	
	/**
	 * 
	 */
	public static FMOD_RESULT NetEventSystem_Init(EventSystem eventsystem) {
		return NetEventSystem_Init(eventsystem, FMOD_EVENT_NET_PORT);
	}
	
	private FmodDesigner() {}

	/**
	 * 
	 */
	public static FMOD_RESULT EventSystem_Create(EventSystem eventsystem) {
		int javaResult = FmodDesignerJNI.FmodDesigner_EventSystem_Create(eventsystem);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public static FMOD_RESULT NetEventSystem_Init(EventSystem eventsystem, short port) {
		int javaResult = FmodDesignerJNI.FmodDesigner_NetEventSystem_Init(Pointer.getPointer(eventsystem), port);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public static FMOD_RESULT NetEventSystem_Update() {
		int javaResult = FmodDesignerJNI.FmodDesigner_NetEventSystem_Update();
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public static FMOD_RESULT NetEventSystem_Shutdown() {
		int javaResult = FmodDesignerJNI.FmodDesigner_NetEventSystem_Shutdown();
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public static FMOD_RESULT NetEventSystem_GetVersion(IntBuffer version) {
		if(version != null && !version.isDirect()) {
			throw new NonDirectBufferException();
		}
		int javaResult = FmodDesignerJNI.FmodDesigner_NetEventSystem_GetVersion(version, BufferUtils.getPositionInBytes(version));
		return FMOD_RESULT.get(javaResult);
	}

}
