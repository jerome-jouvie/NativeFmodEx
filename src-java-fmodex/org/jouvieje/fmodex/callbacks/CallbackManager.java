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

package org.jouvieje.fmodex.callbacks;

import java.util.Enumeration;
import java.util.Hashtable;

import org.jouvieje.fmodex.exceptions.CallbackException;

//FIXME Make this class invisible

/** Internal, don't use */
public class CallbackManager {
	private final static boolean DEBUG_MODE = false;

	/*
	 * Key   : owner    (Long)
	 * Value : Callback (Object)
	 */
	protected static Hashtable[] callbacksTable = null;
	//Store the last callback added
	protected static Object[] lastCallbacksAdded = null;
	/*
	 * Key   : object (Long)
	 * Value : owner (Long)
	 */
	protected static Hashtable ownersTable = null;

	static {
		callbacksTable = new Hashtable[CallbackBridge.NB_CALLBACKS];
		lastCallbacksAdded = new Object[CallbackBridge.NB_CALLBACKS];
		ownersTable = new Hashtable();
		for(int i = 0; i < callbacksTable.length; i++) {
			callbacksTable[i] = new Hashtable();
			lastCallbacksAdded[i] = null;
		}
	}

	public static Object getCallback(int type) {
		return getCallback(type, 0, false);
	}

	public static Object getCallback(int type, long object, boolean autoAttach) {
		Long owner = (object == 0) ? new Long(0) : (Long)ownersTable.get(new Long(object));
		if(owner != null) {
			Object callback = callbacksTable[type].get(owner);
			if(callback == null) {
				if(object == 0) {
					if(DEBUG_MODE) {
						printDebug("Owner not found (type=" + type + " object=" + object + ")! Try to use last Callbacks added");
					}
					callback = lastCallbacksAdded[type];
				}
				if(callback == null) {
					throw new CallbackException("A callback may not be implemented. Please contact support.");
				}
			}
			if(DEBUG_MODE) printDebug("Get Callback type=" + type + "(" + getCallbackName(type) + ") owner=" + owner);
			return callback;
		}
		else {
			if(DEBUG_MODE) printDebug("Owner not found (type=" + type + " object=" + object + ")! Use last Callbacks.");
			Object callback = lastCallbacksAdded[type];
			if(callback == null) {
				throw new CallbackException("A callback may not be implemented. Please contact support.");
			}
			if(autoAttach) {
				Enumeration values = callbacksTable[type].elements();
				Enumeration keys = callbacksTable[type].keys();
				while(values.hasMoreElements()) {
					Object currentValue = values.nextElement();
					Long currentKey = (Long)keys.nextElement();
					if(currentValue == callback) {
						owner = currentKey;
						addOwner(owner.longValue(), object);
						break;
					}
				}
			}
			if(DEBUG_MODE) printDebug("Get Callback type=" + type + "(" + getCallbackName(type) + ") owner=" + owner);
			return callback;
		}
	}

	public static void addTmpCallback(int type, Object callback) {
		if(callback != null) {
			lastCallbacksAdded[type] = callback;
			if(DEBUG_MODE) {
				printDebug("Add Temporary Callback type=" + type);
			}
		}
	}

	public static void addCallback(int type, Object callback, long owner) {
		if(callbacksTable[type].remove(new Long(owner)) != null) {
			lastCallbacksAdded[type] = null;
			if(DEBUG_MODE) {
				printDebug("Removing Callback type=" + type + " owner=" + owner);
			}
		}
		if(callback != null) {
			callbacksTable[type].put(new Long(owner), callback);
			lastCallbacksAdded[type] = callback;
			if(DEBUG_MODE) {
				printDebug("Add Callback type=" + type + " owner=" + owner);
			}
		}
	}

	public static void addOwner(long owner, long object) {
		Object o = ownersTable.remove(new Long(object));
		if(o != null) {
			if(DEBUG_MODE) {
				printDebug("Removing Owner owner=" + (o != null ? ((Long)o).longValue() : 0) + " object=" + object);
			}
		}
		if(owner != 0) {
			ownersTable.put(new Long(object), new Long(owner));
			if(DEBUG_MODE) {
				printDebug("Add Owner owner=" + owner + " object=" + object);
			}
		}
	}

	public static String getCallbackName(int type) {
		return CallbackBridge.getCallbackName(type);
	}

	/* For DEBUG mode*/

	private static void printDebug(String message) {
		java.lang.System.out.println("CALLBACK MANAGER : " + message);
	}
}
