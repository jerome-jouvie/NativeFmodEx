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

package org.jouvieje.fmodex.enumerations;

import org.jouvieje.fmodex.*;
import org.jouvieje.fmodex.exceptions.*;
import org.jouvieje.fmodex.callbacks.*;
import org.jouvieje.fmodex.*;
import org.jouvieje.fmodex.defines.*;
import org.jouvieje.fmodex.enumerations.*;
import org.jouvieje.fmodex.structures.*;
import java.nio.*;
import org.jouvieje.fmodex.utils.*;
import org.jouvieje.fmodex.System;
import java.util.HashMap;

/**
 * <BR>
 * <BR>
 * error codes.  Returned from every function.<BR>
 * <BR><U><B>Remarks</B></U><BR><BR>
 * <BR><U><B>Platforms Supported</B></U><BR><BR>
 * Win32, Win64, Linux, Linux64, Macintosh, Xbox360, PlayStation 2, PlayStation Portable, PlayStation 3, Wii, Solaris, iPhone<BR>
 * <BR><U><B>See Also</B></U><BR><BR>
 * 
 */
public class FMOD_RESULT implements Enumeration, Comparable {
	/**  */
	public final static FMOD_RESULT FMOD_OK = new FMOD_RESULT("FMOD_OK", EnumerationJNI.get_FMOD_OK());
	/**  */
	public final static FMOD_RESULT FMOD_ERR_ALREADYLOCKED = new FMOD_RESULT("FMOD_ERR_ALREADYLOCKED", EnumerationJNI.get_FMOD_ERR_ALREADYLOCKED());
	/**  */
	public final static FMOD_RESULT FMOD_ERR_BADCOMMAND = new FMOD_RESULT("FMOD_ERR_BADCOMMAND", EnumerationJNI.get_FMOD_ERR_BADCOMMAND());
	/**  */
	public final static FMOD_RESULT FMOD_ERR_CDDA_DRIVERS = new FMOD_RESULT("FMOD_ERR_CDDA_DRIVERS", EnumerationJNI.get_FMOD_ERR_CDDA_DRIVERS());
	/**  */
	public final static FMOD_RESULT FMOD_ERR_CDDA_INIT = new FMOD_RESULT("FMOD_ERR_CDDA_INIT", EnumerationJNI.get_FMOD_ERR_CDDA_INIT());
	/**  */
	public final static FMOD_RESULT FMOD_ERR_CDDA_INVALID_DEVICE = new FMOD_RESULT("FMOD_ERR_CDDA_INVALID_DEVICE", EnumerationJNI.get_FMOD_ERR_CDDA_INVALID_DEVICE());
	/**  */
	public final static FMOD_RESULT FMOD_ERR_CDDA_NOAUDIO = new FMOD_RESULT("FMOD_ERR_CDDA_NOAUDIO", EnumerationJNI.get_FMOD_ERR_CDDA_NOAUDIO());
	/**  */
	public final static FMOD_RESULT FMOD_ERR_CDDA_NODEVICES = new FMOD_RESULT("FMOD_ERR_CDDA_NODEVICES", EnumerationJNI.get_FMOD_ERR_CDDA_NODEVICES());
	/**  */
	public final static FMOD_RESULT FMOD_ERR_CDDA_NODISC = new FMOD_RESULT("FMOD_ERR_CDDA_NODISC", EnumerationJNI.get_FMOD_ERR_CDDA_NODISC());
	/**  */
	public final static FMOD_RESULT FMOD_ERR_CDDA_READ = new FMOD_RESULT("FMOD_ERR_CDDA_READ", EnumerationJNI.get_FMOD_ERR_CDDA_READ());
	/**  */
	public final static FMOD_RESULT FMOD_ERR_CHANNEL_ALLOC = new FMOD_RESULT("FMOD_ERR_CHANNEL_ALLOC", EnumerationJNI.get_FMOD_ERR_CHANNEL_ALLOC());
	/**  */
	public final static FMOD_RESULT FMOD_ERR_CHANNEL_STOLEN = new FMOD_RESULT("FMOD_ERR_CHANNEL_STOLEN", EnumerationJNI.get_FMOD_ERR_CHANNEL_STOLEN());
	/**  */
	public final static FMOD_RESULT FMOD_ERR_COM = new FMOD_RESULT("FMOD_ERR_COM", EnumerationJNI.get_FMOD_ERR_COM());
	/**  */
	public final static FMOD_RESULT FMOD_ERR_DMA = new FMOD_RESULT("FMOD_ERR_DMA", EnumerationJNI.get_FMOD_ERR_DMA());
	/**  */
	public final static FMOD_RESULT FMOD_ERR_DSP_CONNECTION = new FMOD_RESULT("FMOD_ERR_DSP_CONNECTION", EnumerationJNI.get_FMOD_ERR_DSP_CONNECTION());
	/**  */
	public final static FMOD_RESULT FMOD_ERR_DSP_FORMAT = new FMOD_RESULT("FMOD_ERR_DSP_FORMAT", EnumerationJNI.get_FMOD_ERR_DSP_FORMAT());
	/**  */
	public final static FMOD_RESULT FMOD_ERR_DSP_NOTFOUND = new FMOD_RESULT("FMOD_ERR_DSP_NOTFOUND", EnumerationJNI.get_FMOD_ERR_DSP_NOTFOUND());
	/**  */
	public final static FMOD_RESULT FMOD_ERR_DSP_RUNNING = new FMOD_RESULT("FMOD_ERR_DSP_RUNNING", EnumerationJNI.get_FMOD_ERR_DSP_RUNNING());
	/**  */
	public final static FMOD_RESULT FMOD_ERR_DSP_TOOMANYCONNECTIONS = new FMOD_RESULT("FMOD_ERR_DSP_TOOMANYCONNECTIONS", EnumerationJNI.get_FMOD_ERR_DSP_TOOMANYCONNECTIONS());
	/**  */
	public final static FMOD_RESULT FMOD_ERR_FILE_BAD = new FMOD_RESULT("FMOD_ERR_FILE_BAD", EnumerationJNI.get_FMOD_ERR_FILE_BAD());
	/**  */
	public final static FMOD_RESULT FMOD_ERR_FILE_COULDNOTSEEK = new FMOD_RESULT("FMOD_ERR_FILE_COULDNOTSEEK", EnumerationJNI.get_FMOD_ERR_FILE_COULDNOTSEEK());
	/**  */
	public final static FMOD_RESULT FMOD_ERR_FILE_DISKEJECTED = new FMOD_RESULT("FMOD_ERR_FILE_DISKEJECTED", EnumerationJNI.get_FMOD_ERR_FILE_DISKEJECTED());
	/**  */
	public final static FMOD_RESULT FMOD_ERR_FILE_EOF = new FMOD_RESULT("FMOD_ERR_FILE_EOF", EnumerationJNI.get_FMOD_ERR_FILE_EOF());
	/**  */
	public final static FMOD_RESULT FMOD_ERR_FILE_NOTFOUND = new FMOD_RESULT("FMOD_ERR_FILE_NOTFOUND", EnumerationJNI.get_FMOD_ERR_FILE_NOTFOUND());
	/**  */
	public final static FMOD_RESULT FMOD_ERR_FILE_UNWANTED = new FMOD_RESULT("FMOD_ERR_FILE_UNWANTED", EnumerationJNI.get_FMOD_ERR_FILE_UNWANTED());
	/**  */
	public final static FMOD_RESULT FMOD_ERR_FORMAT = new FMOD_RESULT("FMOD_ERR_FORMAT", EnumerationJNI.get_FMOD_ERR_FORMAT());
	/**  */
	public final static FMOD_RESULT FMOD_ERR_HTTP = new FMOD_RESULT("FMOD_ERR_HTTP", EnumerationJNI.get_FMOD_ERR_HTTP());
	/**  */
	public final static FMOD_RESULT FMOD_ERR_HTTP_ACCESS = new FMOD_RESULT("FMOD_ERR_HTTP_ACCESS", EnumerationJNI.get_FMOD_ERR_HTTP_ACCESS());
	/**  */
	public final static FMOD_RESULT FMOD_ERR_HTTP_PROXY_AUTH = new FMOD_RESULT("FMOD_ERR_HTTP_PROXY_AUTH", EnumerationJNI.get_FMOD_ERR_HTTP_PROXY_AUTH());
	/**  */
	public final static FMOD_RESULT FMOD_ERR_HTTP_SERVER_ERROR = new FMOD_RESULT("FMOD_ERR_HTTP_SERVER_ERROR", EnumerationJNI.get_FMOD_ERR_HTTP_SERVER_ERROR());
	/**  */
	public final static FMOD_RESULT FMOD_ERR_HTTP_TIMEOUT = new FMOD_RESULT("FMOD_ERR_HTTP_TIMEOUT", EnumerationJNI.get_FMOD_ERR_HTTP_TIMEOUT());
	/**  */
	public final static FMOD_RESULT FMOD_ERR_INITIALIZATION = new FMOD_RESULT("FMOD_ERR_INITIALIZATION", EnumerationJNI.get_FMOD_ERR_INITIALIZATION());
	/**  */
	public final static FMOD_RESULT FMOD_ERR_INITIALIZED = new FMOD_RESULT("FMOD_ERR_INITIALIZED", EnumerationJNI.get_FMOD_ERR_INITIALIZED());
	/**  */
	public final static FMOD_RESULT FMOD_ERR_INTERNAL = new FMOD_RESULT("FMOD_ERR_INTERNAL", EnumerationJNI.get_FMOD_ERR_INTERNAL());
	/**  */
	public final static FMOD_RESULT FMOD_ERR_INVALID_ADDRESS = new FMOD_RESULT("FMOD_ERR_INVALID_ADDRESS", EnumerationJNI.get_FMOD_ERR_INVALID_ADDRESS());
	/**  */
	public final static FMOD_RESULT FMOD_ERR_INVALID_FLOAT = new FMOD_RESULT("FMOD_ERR_INVALID_FLOAT", EnumerationJNI.get_FMOD_ERR_INVALID_FLOAT());
	/**  */
	public final static FMOD_RESULT FMOD_ERR_INVALID_HANDLE = new FMOD_RESULT("FMOD_ERR_INVALID_HANDLE", EnumerationJNI.get_FMOD_ERR_INVALID_HANDLE());
	/**  */
	public final static FMOD_RESULT FMOD_ERR_INVALID_PARAM = new FMOD_RESULT("FMOD_ERR_INVALID_PARAM", EnumerationJNI.get_FMOD_ERR_INVALID_PARAM());
	/**  */
	public final static FMOD_RESULT FMOD_ERR_INVALID_POSITION = new FMOD_RESULT("FMOD_ERR_INVALID_POSITION", EnumerationJNI.get_FMOD_ERR_INVALID_POSITION());
	/**  */
	public final static FMOD_RESULT FMOD_ERR_INVALID_SPEAKER = new FMOD_RESULT("FMOD_ERR_INVALID_SPEAKER", EnumerationJNI.get_FMOD_ERR_INVALID_SPEAKER());
	/**  */
	public final static FMOD_RESULT FMOD_ERR_INVALID_SYNCPOINT = new FMOD_RESULT("FMOD_ERR_INVALID_SYNCPOINT", EnumerationJNI.get_FMOD_ERR_INVALID_SYNCPOINT());
	/**  */
	public final static FMOD_RESULT FMOD_ERR_INVALID_VECTOR = new FMOD_RESULT("FMOD_ERR_INVALID_VECTOR", EnumerationJNI.get_FMOD_ERR_INVALID_VECTOR());
	/**  */
	public final static FMOD_RESULT FMOD_ERR_IRX = new FMOD_RESULT("FMOD_ERR_IRX", EnumerationJNI.get_FMOD_ERR_IRX());
	/**  */
	public final static FMOD_RESULT FMOD_ERR_MAXAUDIBLE = new FMOD_RESULT("FMOD_ERR_MAXAUDIBLE", EnumerationJNI.get_FMOD_ERR_MAXAUDIBLE());
	/**  */
	public final static FMOD_RESULT FMOD_ERR_MEMORY = new FMOD_RESULT("FMOD_ERR_MEMORY", EnumerationJNI.get_FMOD_ERR_MEMORY());
	/**  */
	public final static FMOD_RESULT FMOD_ERR_MEMORY_CANTPOINT = new FMOD_RESULT("FMOD_ERR_MEMORY_CANTPOINT", EnumerationJNI.get_FMOD_ERR_MEMORY_CANTPOINT());
	/**  */
	public final static FMOD_RESULT FMOD_ERR_MEMORY_IOP = new FMOD_RESULT("FMOD_ERR_MEMORY_IOP", EnumerationJNI.get_FMOD_ERR_MEMORY_IOP());
	/**  */
	public final static FMOD_RESULT FMOD_ERR_MEMORY_SRAM = new FMOD_RESULT("FMOD_ERR_MEMORY_SRAM", EnumerationJNI.get_FMOD_ERR_MEMORY_SRAM());
	/**  */
	public final static FMOD_RESULT FMOD_ERR_NEEDS2D = new FMOD_RESULT("FMOD_ERR_NEEDS2D", EnumerationJNI.get_FMOD_ERR_NEEDS2D());
	/**  */
	public final static FMOD_RESULT FMOD_ERR_NEEDS3D = new FMOD_RESULT("FMOD_ERR_NEEDS3D", EnumerationJNI.get_FMOD_ERR_NEEDS3D());
	/**  */
	public final static FMOD_RESULT FMOD_ERR_NEEDSHARDWARE = new FMOD_RESULT("FMOD_ERR_NEEDSHARDWARE", EnumerationJNI.get_FMOD_ERR_NEEDSHARDWARE());
	/**  */
	public final static FMOD_RESULT FMOD_ERR_NEEDSSOFTWARE = new FMOD_RESULT("FMOD_ERR_NEEDSSOFTWARE", EnumerationJNI.get_FMOD_ERR_NEEDSSOFTWARE());
	/**  */
	public final static FMOD_RESULT FMOD_ERR_NET_CONNECT = new FMOD_RESULT("FMOD_ERR_NET_CONNECT", EnumerationJNI.get_FMOD_ERR_NET_CONNECT());
	/**  */
	public final static FMOD_RESULT FMOD_ERR_NET_SOCKET_ERROR = new FMOD_RESULT("FMOD_ERR_NET_SOCKET_ERROR", EnumerationJNI.get_FMOD_ERR_NET_SOCKET_ERROR());
	/**  */
	public final static FMOD_RESULT FMOD_ERR_NET_URL = new FMOD_RESULT("FMOD_ERR_NET_URL", EnumerationJNI.get_FMOD_ERR_NET_URL());
	/**  */
	public final static FMOD_RESULT FMOD_ERR_NET_WOULD_BLOCK = new FMOD_RESULT("FMOD_ERR_NET_WOULD_BLOCK", EnumerationJNI.get_FMOD_ERR_NET_WOULD_BLOCK());
	/**  */
	public final static FMOD_RESULT FMOD_ERR_NOTREADY = new FMOD_RESULT("FMOD_ERR_NOTREADY", EnumerationJNI.get_FMOD_ERR_NOTREADY());
	/**  */
	public final static FMOD_RESULT FMOD_ERR_OUTPUT_ALLOCATED = new FMOD_RESULT("FMOD_ERR_OUTPUT_ALLOCATED", EnumerationJNI.get_FMOD_ERR_OUTPUT_ALLOCATED());
	/**  */
	public final static FMOD_RESULT FMOD_ERR_OUTPUT_CREATEBUFFER = new FMOD_RESULT("FMOD_ERR_OUTPUT_CREATEBUFFER", EnumerationJNI.get_FMOD_ERR_OUTPUT_CREATEBUFFER());
	/**  */
	public final static FMOD_RESULT FMOD_ERR_OUTPUT_DRIVERCALL = new FMOD_RESULT("FMOD_ERR_OUTPUT_DRIVERCALL", EnumerationJNI.get_FMOD_ERR_OUTPUT_DRIVERCALL());
	/**  */
	public final static FMOD_RESULT FMOD_ERR_OUTPUT_ENUMERATION = new FMOD_RESULT("FMOD_ERR_OUTPUT_ENUMERATION", EnumerationJNI.get_FMOD_ERR_OUTPUT_ENUMERATION());
	/**  */
	public final static FMOD_RESULT FMOD_ERR_OUTPUT_FORMAT = new FMOD_RESULT("FMOD_ERR_OUTPUT_FORMAT", EnumerationJNI.get_FMOD_ERR_OUTPUT_FORMAT());
	/**  */
	public final static FMOD_RESULT FMOD_ERR_OUTPUT_INIT = new FMOD_RESULT("FMOD_ERR_OUTPUT_INIT", EnumerationJNI.get_FMOD_ERR_OUTPUT_INIT());
	/**  */
	public final static FMOD_RESULT FMOD_ERR_OUTPUT_NOHARDWARE = new FMOD_RESULT("FMOD_ERR_OUTPUT_NOHARDWARE", EnumerationJNI.get_FMOD_ERR_OUTPUT_NOHARDWARE());
	/**  */
	public final static FMOD_RESULT FMOD_ERR_OUTPUT_NOSOFTWARE = new FMOD_RESULT("FMOD_ERR_OUTPUT_NOSOFTWARE", EnumerationJNI.get_FMOD_ERR_OUTPUT_NOSOFTWARE());
	/**  */
	public final static FMOD_RESULT FMOD_ERR_PAN = new FMOD_RESULT("FMOD_ERR_PAN", EnumerationJNI.get_FMOD_ERR_PAN());
	/**  */
	public final static FMOD_RESULT FMOD_ERR_PLUGIN = new FMOD_RESULT("FMOD_ERR_PLUGIN", EnumerationJNI.get_FMOD_ERR_PLUGIN());
	/**  */
	public final static FMOD_RESULT FMOD_ERR_PLUGIN_INSTANCES = new FMOD_RESULT("FMOD_ERR_PLUGIN_INSTANCES", EnumerationJNI.get_FMOD_ERR_PLUGIN_INSTANCES());
	/**  */
	public final static FMOD_RESULT FMOD_ERR_PLUGIN_MISSING = new FMOD_RESULT("FMOD_ERR_PLUGIN_MISSING", EnumerationJNI.get_FMOD_ERR_PLUGIN_MISSING());
	/**  */
	public final static FMOD_RESULT FMOD_ERR_PLUGIN_RESOURCE = new FMOD_RESULT("FMOD_ERR_PLUGIN_RESOURCE", EnumerationJNI.get_FMOD_ERR_PLUGIN_RESOURCE());
	/**  */
	public final static FMOD_RESULT FMOD_ERR_PRELOADED = new FMOD_RESULT("FMOD_ERR_PRELOADED", EnumerationJNI.get_FMOD_ERR_PRELOADED());
	/**  */
	public final static FMOD_RESULT FMOD_ERR_PROGRAMMERSOUND = new FMOD_RESULT("FMOD_ERR_PROGRAMMERSOUND", EnumerationJNI.get_FMOD_ERR_PROGRAMMERSOUND());
	/**  */
	public final static FMOD_RESULT FMOD_ERR_RECORD = new FMOD_RESULT("FMOD_ERR_RECORD", EnumerationJNI.get_FMOD_ERR_RECORD());
	/**  */
	public final static FMOD_RESULT FMOD_ERR_REVERB_INSTANCE = new FMOD_RESULT("FMOD_ERR_REVERB_INSTANCE", EnumerationJNI.get_FMOD_ERR_REVERB_INSTANCE());
	/**  */
	public final static FMOD_RESULT FMOD_ERR_SUBSOUND_ALLOCATED = new FMOD_RESULT("FMOD_ERR_SUBSOUND_ALLOCATED", EnumerationJNI.get_FMOD_ERR_SUBSOUND_ALLOCATED());
	/**  */
	public final static FMOD_RESULT FMOD_ERR_SUBSOUND_CANTMOVE = new FMOD_RESULT("FMOD_ERR_SUBSOUND_CANTMOVE", EnumerationJNI.get_FMOD_ERR_SUBSOUND_CANTMOVE());
	/**  */
	public final static FMOD_RESULT FMOD_ERR_SUBSOUND_MODE = new FMOD_RESULT("FMOD_ERR_SUBSOUND_MODE", EnumerationJNI.get_FMOD_ERR_SUBSOUND_MODE());
	/**  */
	public final static FMOD_RESULT FMOD_ERR_SUBSOUNDS = new FMOD_RESULT("FMOD_ERR_SUBSOUNDS", EnumerationJNI.get_FMOD_ERR_SUBSOUNDS());
	/**  */
	public final static FMOD_RESULT FMOD_ERR_TAGNOTFOUND = new FMOD_RESULT("FMOD_ERR_TAGNOTFOUND", EnumerationJNI.get_FMOD_ERR_TAGNOTFOUND());
	/**  */
	public final static FMOD_RESULT FMOD_ERR_TOOMANYCHANNELS = new FMOD_RESULT("FMOD_ERR_TOOMANYCHANNELS", EnumerationJNI.get_FMOD_ERR_TOOMANYCHANNELS());
	/**  */
	public final static FMOD_RESULT FMOD_ERR_UNIMPLEMENTED = new FMOD_RESULT("FMOD_ERR_UNIMPLEMENTED", EnumerationJNI.get_FMOD_ERR_UNIMPLEMENTED());
	/**  */
	public final static FMOD_RESULT FMOD_ERR_UNINITIALIZED = new FMOD_RESULT("FMOD_ERR_UNINITIALIZED", EnumerationJNI.get_FMOD_ERR_UNINITIALIZED());
	/**  */
	public final static FMOD_RESULT FMOD_ERR_UNSUPPORTED = new FMOD_RESULT("FMOD_ERR_UNSUPPORTED", EnumerationJNI.get_FMOD_ERR_UNSUPPORTED());
	/**  */
	public final static FMOD_RESULT FMOD_ERR_UPDATE = new FMOD_RESULT("FMOD_ERR_UPDATE", EnumerationJNI.get_FMOD_ERR_UPDATE());
	/**  */
	public final static FMOD_RESULT FMOD_ERR_VERSION = new FMOD_RESULT("FMOD_ERR_VERSION", EnumerationJNI.get_FMOD_ERR_VERSION());
	/**  */
	public final static FMOD_RESULT FMOD_ERR_EVENT_FAILED = new FMOD_RESULT("FMOD_ERR_EVENT_FAILED", EnumerationJNI.get_FMOD_ERR_EVENT_FAILED());
	/**  */
	public final static FMOD_RESULT FMOD_ERR_EVENT_INFOONLY = new FMOD_RESULT("FMOD_ERR_EVENT_INFOONLY", EnumerationJNI.get_FMOD_ERR_EVENT_INFOONLY());
	/**  */
	public final static FMOD_RESULT FMOD_ERR_EVENT_INTERNAL = new FMOD_RESULT("FMOD_ERR_EVENT_INTERNAL", EnumerationJNI.get_FMOD_ERR_EVENT_INTERNAL());
	/**  */
	public final static FMOD_RESULT FMOD_ERR_EVENT_MAXSTREAMS = new FMOD_RESULT("FMOD_ERR_EVENT_MAXSTREAMS", EnumerationJNI.get_FMOD_ERR_EVENT_MAXSTREAMS());
	/**  */
	public final static FMOD_RESULT FMOD_ERR_EVENT_MISMATCH = new FMOD_RESULT("FMOD_ERR_EVENT_MISMATCH", EnumerationJNI.get_FMOD_ERR_EVENT_MISMATCH());
	/**  */
	public final static FMOD_RESULT FMOD_ERR_EVENT_NAMECONFLICT = new FMOD_RESULT("FMOD_ERR_EVENT_NAMECONFLICT", EnumerationJNI.get_FMOD_ERR_EVENT_NAMECONFLICT());
	/**  */
	public final static FMOD_RESULT FMOD_ERR_EVENT_NOTFOUND = new FMOD_RESULT("FMOD_ERR_EVENT_NOTFOUND", EnumerationJNI.get_FMOD_ERR_EVENT_NOTFOUND());
	/**  */
	public final static FMOD_RESULT FMOD_ERR_EVENT_NEEDSSIMPLE = new FMOD_RESULT("FMOD_ERR_EVENT_NEEDSSIMPLE", EnumerationJNI.get_FMOD_ERR_EVENT_NEEDSSIMPLE());
	/**  */
	public final static FMOD_RESULT FMOD_ERR_EVENT_GUIDCONFLICT = new FMOD_RESULT("FMOD_ERR_EVENT_GUIDCONFLICT", EnumerationJNI.get_FMOD_ERR_EVENT_GUIDCONFLICT());
	/**  */
	public final static FMOD_RESULT FMOD_ERR_EVENT_ALREADY_LOADED = new FMOD_RESULT("FMOD_ERR_EVENT_ALREADY_LOADED", EnumerationJNI.get_FMOD_ERR_EVENT_ALREADY_LOADED());
	/**  */
	public final static FMOD_RESULT FMOD_ERR_MUSIC_UNINITIALIZED = new FMOD_RESULT("FMOD_ERR_MUSIC_UNINITIALIZED", EnumerationJNI.get_FMOD_ERR_MUSIC_UNINITIALIZED());
	/**  */
	public final static FMOD_RESULT FMOD_ERR_MUSIC_NOTFOUND = new FMOD_RESULT("FMOD_ERR_MUSIC_NOTFOUND", EnumerationJNI.get_FMOD_ERR_MUSIC_NOTFOUND());
	/**  */
	public final static FMOD_RESULT FMOD_ERR_MUSIC_NOCALLBACK = new FMOD_RESULT("FMOD_ERR_MUSIC_NOCALLBACK", EnumerationJNI.get_FMOD_ERR_MUSIC_NOCALLBACK());
	/**  */
	public final static FMOD_RESULT FMOD_RESULT_FORCEINT = new FMOD_RESULT("FMOD_RESULT_FORCEINT", 65536);

	private final static HashMap VALUES = new HashMap(2*99);
	static {
		VALUES.put(new Integer(FMOD_OK.asInt()), FMOD_OK);
		VALUES.put(new Integer(FMOD_ERR_ALREADYLOCKED.asInt()), FMOD_ERR_ALREADYLOCKED);
		VALUES.put(new Integer(FMOD_ERR_BADCOMMAND.asInt()), FMOD_ERR_BADCOMMAND);
		VALUES.put(new Integer(FMOD_ERR_CDDA_DRIVERS.asInt()), FMOD_ERR_CDDA_DRIVERS);
		VALUES.put(new Integer(FMOD_ERR_CDDA_INIT.asInt()), FMOD_ERR_CDDA_INIT);
		VALUES.put(new Integer(FMOD_ERR_CDDA_INVALID_DEVICE.asInt()), FMOD_ERR_CDDA_INVALID_DEVICE);
		VALUES.put(new Integer(FMOD_ERR_CDDA_NOAUDIO.asInt()), FMOD_ERR_CDDA_NOAUDIO);
		VALUES.put(new Integer(FMOD_ERR_CDDA_NODEVICES.asInt()), FMOD_ERR_CDDA_NODEVICES);
		VALUES.put(new Integer(FMOD_ERR_CDDA_NODISC.asInt()), FMOD_ERR_CDDA_NODISC);
		VALUES.put(new Integer(FMOD_ERR_CDDA_READ.asInt()), FMOD_ERR_CDDA_READ);
		VALUES.put(new Integer(FMOD_ERR_CHANNEL_ALLOC.asInt()), FMOD_ERR_CHANNEL_ALLOC);
		VALUES.put(new Integer(FMOD_ERR_CHANNEL_STOLEN.asInt()), FMOD_ERR_CHANNEL_STOLEN);
		VALUES.put(new Integer(FMOD_ERR_COM.asInt()), FMOD_ERR_COM);
		VALUES.put(new Integer(FMOD_ERR_DMA.asInt()), FMOD_ERR_DMA);
		VALUES.put(new Integer(FMOD_ERR_DSP_CONNECTION.asInt()), FMOD_ERR_DSP_CONNECTION);
		VALUES.put(new Integer(FMOD_ERR_DSP_FORMAT.asInt()), FMOD_ERR_DSP_FORMAT);
		VALUES.put(new Integer(FMOD_ERR_DSP_NOTFOUND.asInt()), FMOD_ERR_DSP_NOTFOUND);
		VALUES.put(new Integer(FMOD_ERR_DSP_RUNNING.asInt()), FMOD_ERR_DSP_RUNNING);
		VALUES.put(new Integer(FMOD_ERR_DSP_TOOMANYCONNECTIONS.asInt()), FMOD_ERR_DSP_TOOMANYCONNECTIONS);
		VALUES.put(new Integer(FMOD_ERR_FILE_BAD.asInt()), FMOD_ERR_FILE_BAD);
		VALUES.put(new Integer(FMOD_ERR_FILE_COULDNOTSEEK.asInt()), FMOD_ERR_FILE_COULDNOTSEEK);
		VALUES.put(new Integer(FMOD_ERR_FILE_DISKEJECTED.asInt()), FMOD_ERR_FILE_DISKEJECTED);
		VALUES.put(new Integer(FMOD_ERR_FILE_EOF.asInt()), FMOD_ERR_FILE_EOF);
		VALUES.put(new Integer(FMOD_ERR_FILE_NOTFOUND.asInt()), FMOD_ERR_FILE_NOTFOUND);
		VALUES.put(new Integer(FMOD_ERR_FILE_UNWANTED.asInt()), FMOD_ERR_FILE_UNWANTED);
		VALUES.put(new Integer(FMOD_ERR_FORMAT.asInt()), FMOD_ERR_FORMAT);
		VALUES.put(new Integer(FMOD_ERR_HTTP.asInt()), FMOD_ERR_HTTP);
		VALUES.put(new Integer(FMOD_ERR_HTTP_ACCESS.asInt()), FMOD_ERR_HTTP_ACCESS);
		VALUES.put(new Integer(FMOD_ERR_HTTP_PROXY_AUTH.asInt()), FMOD_ERR_HTTP_PROXY_AUTH);
		VALUES.put(new Integer(FMOD_ERR_HTTP_SERVER_ERROR.asInt()), FMOD_ERR_HTTP_SERVER_ERROR);
		VALUES.put(new Integer(FMOD_ERR_HTTP_TIMEOUT.asInt()), FMOD_ERR_HTTP_TIMEOUT);
		VALUES.put(new Integer(FMOD_ERR_INITIALIZATION.asInt()), FMOD_ERR_INITIALIZATION);
		VALUES.put(new Integer(FMOD_ERR_INITIALIZED.asInt()), FMOD_ERR_INITIALIZED);
		VALUES.put(new Integer(FMOD_ERR_INTERNAL.asInt()), FMOD_ERR_INTERNAL);
		VALUES.put(new Integer(FMOD_ERR_INVALID_ADDRESS.asInt()), FMOD_ERR_INVALID_ADDRESS);
		VALUES.put(new Integer(FMOD_ERR_INVALID_FLOAT.asInt()), FMOD_ERR_INVALID_FLOAT);
		VALUES.put(new Integer(FMOD_ERR_INVALID_HANDLE.asInt()), FMOD_ERR_INVALID_HANDLE);
		VALUES.put(new Integer(FMOD_ERR_INVALID_PARAM.asInt()), FMOD_ERR_INVALID_PARAM);
		VALUES.put(new Integer(FMOD_ERR_INVALID_POSITION.asInt()), FMOD_ERR_INVALID_POSITION);
		VALUES.put(new Integer(FMOD_ERR_INVALID_SPEAKER.asInt()), FMOD_ERR_INVALID_SPEAKER);
		VALUES.put(new Integer(FMOD_ERR_INVALID_SYNCPOINT.asInt()), FMOD_ERR_INVALID_SYNCPOINT);
		VALUES.put(new Integer(FMOD_ERR_INVALID_VECTOR.asInt()), FMOD_ERR_INVALID_VECTOR);
		VALUES.put(new Integer(FMOD_ERR_IRX.asInt()), FMOD_ERR_IRX);
		VALUES.put(new Integer(FMOD_ERR_MAXAUDIBLE.asInt()), FMOD_ERR_MAXAUDIBLE);
		VALUES.put(new Integer(FMOD_ERR_MEMORY.asInt()), FMOD_ERR_MEMORY);
		VALUES.put(new Integer(FMOD_ERR_MEMORY_CANTPOINT.asInt()), FMOD_ERR_MEMORY_CANTPOINT);
		VALUES.put(new Integer(FMOD_ERR_MEMORY_IOP.asInt()), FMOD_ERR_MEMORY_IOP);
		VALUES.put(new Integer(FMOD_ERR_MEMORY_SRAM.asInt()), FMOD_ERR_MEMORY_SRAM);
		VALUES.put(new Integer(FMOD_ERR_NEEDS2D.asInt()), FMOD_ERR_NEEDS2D);
		VALUES.put(new Integer(FMOD_ERR_NEEDS3D.asInt()), FMOD_ERR_NEEDS3D);
		VALUES.put(new Integer(FMOD_ERR_NEEDSHARDWARE.asInt()), FMOD_ERR_NEEDSHARDWARE);
		VALUES.put(new Integer(FMOD_ERR_NEEDSSOFTWARE.asInt()), FMOD_ERR_NEEDSSOFTWARE);
		VALUES.put(new Integer(FMOD_ERR_NET_CONNECT.asInt()), FMOD_ERR_NET_CONNECT);
		VALUES.put(new Integer(FMOD_ERR_NET_SOCKET_ERROR.asInt()), FMOD_ERR_NET_SOCKET_ERROR);
		VALUES.put(new Integer(FMOD_ERR_NET_URL.asInt()), FMOD_ERR_NET_URL);
		VALUES.put(new Integer(FMOD_ERR_NET_WOULD_BLOCK.asInt()), FMOD_ERR_NET_WOULD_BLOCK);
		VALUES.put(new Integer(FMOD_ERR_NOTREADY.asInt()), FMOD_ERR_NOTREADY);
		VALUES.put(new Integer(FMOD_ERR_OUTPUT_ALLOCATED.asInt()), FMOD_ERR_OUTPUT_ALLOCATED);
		VALUES.put(new Integer(FMOD_ERR_OUTPUT_CREATEBUFFER.asInt()), FMOD_ERR_OUTPUT_CREATEBUFFER);
		VALUES.put(new Integer(FMOD_ERR_OUTPUT_DRIVERCALL.asInt()), FMOD_ERR_OUTPUT_DRIVERCALL);
		VALUES.put(new Integer(FMOD_ERR_OUTPUT_ENUMERATION.asInt()), FMOD_ERR_OUTPUT_ENUMERATION);
		VALUES.put(new Integer(FMOD_ERR_OUTPUT_FORMAT.asInt()), FMOD_ERR_OUTPUT_FORMAT);
		VALUES.put(new Integer(FMOD_ERR_OUTPUT_INIT.asInt()), FMOD_ERR_OUTPUT_INIT);
		VALUES.put(new Integer(FMOD_ERR_OUTPUT_NOHARDWARE.asInt()), FMOD_ERR_OUTPUT_NOHARDWARE);
		VALUES.put(new Integer(FMOD_ERR_OUTPUT_NOSOFTWARE.asInt()), FMOD_ERR_OUTPUT_NOSOFTWARE);
		VALUES.put(new Integer(FMOD_ERR_PAN.asInt()), FMOD_ERR_PAN);
		VALUES.put(new Integer(FMOD_ERR_PLUGIN.asInt()), FMOD_ERR_PLUGIN);
		VALUES.put(new Integer(FMOD_ERR_PLUGIN_INSTANCES.asInt()), FMOD_ERR_PLUGIN_INSTANCES);
		VALUES.put(new Integer(FMOD_ERR_PLUGIN_MISSING.asInt()), FMOD_ERR_PLUGIN_MISSING);
		VALUES.put(new Integer(FMOD_ERR_PLUGIN_RESOURCE.asInt()), FMOD_ERR_PLUGIN_RESOURCE);
		VALUES.put(new Integer(FMOD_ERR_PRELOADED.asInt()), FMOD_ERR_PRELOADED);
		VALUES.put(new Integer(FMOD_ERR_PROGRAMMERSOUND.asInt()), FMOD_ERR_PROGRAMMERSOUND);
		VALUES.put(new Integer(FMOD_ERR_RECORD.asInt()), FMOD_ERR_RECORD);
		VALUES.put(new Integer(FMOD_ERR_REVERB_INSTANCE.asInt()), FMOD_ERR_REVERB_INSTANCE);
		VALUES.put(new Integer(FMOD_ERR_SUBSOUND_ALLOCATED.asInt()), FMOD_ERR_SUBSOUND_ALLOCATED);
		VALUES.put(new Integer(FMOD_ERR_SUBSOUND_CANTMOVE.asInt()), FMOD_ERR_SUBSOUND_CANTMOVE);
		VALUES.put(new Integer(FMOD_ERR_SUBSOUND_MODE.asInt()), FMOD_ERR_SUBSOUND_MODE);
		VALUES.put(new Integer(FMOD_ERR_SUBSOUNDS.asInt()), FMOD_ERR_SUBSOUNDS);
		VALUES.put(new Integer(FMOD_ERR_TAGNOTFOUND.asInt()), FMOD_ERR_TAGNOTFOUND);
		VALUES.put(new Integer(FMOD_ERR_TOOMANYCHANNELS.asInt()), FMOD_ERR_TOOMANYCHANNELS);
		VALUES.put(new Integer(FMOD_ERR_UNIMPLEMENTED.asInt()), FMOD_ERR_UNIMPLEMENTED);
		VALUES.put(new Integer(FMOD_ERR_UNINITIALIZED.asInt()), FMOD_ERR_UNINITIALIZED);
		VALUES.put(new Integer(FMOD_ERR_UNSUPPORTED.asInt()), FMOD_ERR_UNSUPPORTED);
		VALUES.put(new Integer(FMOD_ERR_UPDATE.asInt()), FMOD_ERR_UPDATE);
		VALUES.put(new Integer(FMOD_ERR_VERSION.asInt()), FMOD_ERR_VERSION);
		VALUES.put(new Integer(FMOD_ERR_EVENT_FAILED.asInt()), FMOD_ERR_EVENT_FAILED);
		VALUES.put(new Integer(FMOD_ERR_EVENT_INFOONLY.asInt()), FMOD_ERR_EVENT_INFOONLY);
		VALUES.put(new Integer(FMOD_ERR_EVENT_INTERNAL.asInt()), FMOD_ERR_EVENT_INTERNAL);
		VALUES.put(new Integer(FMOD_ERR_EVENT_MAXSTREAMS.asInt()), FMOD_ERR_EVENT_MAXSTREAMS);
		VALUES.put(new Integer(FMOD_ERR_EVENT_MISMATCH.asInt()), FMOD_ERR_EVENT_MISMATCH);
		VALUES.put(new Integer(FMOD_ERR_EVENT_NAMECONFLICT.asInt()), FMOD_ERR_EVENT_NAMECONFLICT);
		VALUES.put(new Integer(FMOD_ERR_EVENT_NOTFOUND.asInt()), FMOD_ERR_EVENT_NOTFOUND);
		VALUES.put(new Integer(FMOD_ERR_EVENT_NEEDSSIMPLE.asInt()), FMOD_ERR_EVENT_NEEDSSIMPLE);
		VALUES.put(new Integer(FMOD_ERR_EVENT_GUIDCONFLICT.asInt()), FMOD_ERR_EVENT_GUIDCONFLICT);
		VALUES.put(new Integer(FMOD_ERR_EVENT_ALREADY_LOADED.asInt()), FMOD_ERR_EVENT_ALREADY_LOADED);
		VALUES.put(new Integer(FMOD_ERR_MUSIC_UNINITIALIZED.asInt()), FMOD_ERR_MUSIC_UNINITIALIZED);
		VALUES.put(new Integer(FMOD_ERR_MUSIC_NOTFOUND.asInt()), FMOD_ERR_MUSIC_NOTFOUND);
		VALUES.put(new Integer(FMOD_ERR_MUSIC_NOCALLBACK.asInt()), FMOD_ERR_MUSIC_NOCALLBACK);
		VALUES.put(new Integer(FMOD_RESULT_FORCEINT.asInt()), FMOD_RESULT_FORCEINT);
	}

	private final String name;
	private final int nativeValue;
	private FMOD_RESULT(String name, int nativeValue) {
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
		if(object instanceof FMOD_RESULT) {
			return asInt() == ((FMOD_RESULT)object).asInt();
		}
		return false;
	}
	public int compareTo(Object object) {
		return asInt() - ((FMOD_RESULT)object).asInt();
	}


	/**
	 * Retrieve a FMOD_RESULT enum field with his integer value
	 * @param nativeValue the integer value of the field to retrieve
	 * @return the FMOD_RESULT enum field that correspond to the integer value
	 */
	public static FMOD_RESULT get(int nativeValue) {
		return (FMOD_RESULT)VALUES.get(new Integer(nativeValue));
	}

	/**
	 * Retrieve a FMOD_RESULT enum field from a Pointer
	 * @param pointer a pointer holding an FMOD_RESULT enum field
	 * @return the FMOD_RESULT enum field that correspond to the enum field in the pointer
	 */
	public static FMOD_RESULT get(Pointer pointer) {
		return get(pointer.asInt());
	}

	/**
	 * @return an <code>Iterator</code> over the elements in this enumeration.<BR>
	 * Can be cast to <code>Iterator<FMOD_RESULT></code> in Java 1.5.
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
