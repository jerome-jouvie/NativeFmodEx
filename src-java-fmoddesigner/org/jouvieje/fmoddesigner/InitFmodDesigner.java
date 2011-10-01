/**
 * 				NativeFmodEx Project
 *
 * Want to use FMOD Ex API (www.fmod.org) in the Java language ? NativeFmodEx is made for you.
 * Copyright © 2005-2010 Jérôme JOUVIE (Jouvieje)
 *
 * Created on 23 feb. 2005
 * @version file v1.0.0
 * @author Jérôme JOUVIE (Jouvieje)
 * @site   http://jerome.jouvie.free.fr/
 * @mail   jerome.jouvie@gmail.com
 * 
 * 
 * INTRODUCTION
 * FMOD Ex is an API (Application Programming Interface) that allow you to use music
 * and creating sound effects with a lot of sort of musics.
 * FMOD is at :
 * 		http://www.fmod.org/
 * The reason of this project is that FMOD Ex can't be used direcly with Java, so I've created
 * this project to do this.
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

import org.jouvieje.fmodex.exceptions.InitException;
import org.jouvieje.libloader.LibLoader;
import org.jouvieje.libloader.LibraryConfig;
import org.jouvieje.libloader.PlatformLibrary;

/**
 * Initialization of <code>NativeFmodDesigner</code> / <code>FMOD Designer</code>.<BR>
 * You should call <code><a href="#loadLibraries()">InitFmodDesigner.loadLibraries</a></code> before using <code>NativeFmodDesigner</code> & <code>FmodDesigner</code>.
 */
public class InitFmodDesigner {
	private InitFmodDesigner(){}
	
	/** Display errors when loading libraries */
	public static boolean DEBUG = false;
	/** Indicates if libraries has been loaded */
	protected static boolean librariesLoaded = false;
	
	/**
	 * This is the first thing to do before trying to use FMOD Designer.<BR>
	 * <BR>
	 * This method loads all requiered libraries.<BR>
	 * If all libraries are not loaded an exception occures. Then, you can decide what should
	 * be done.<BR>
	 * <BR>
	 * This is equivalent to the call <code>loadLibraries(INIT_MODES.INIT_DEFAULT)</code>.<BR>
	 * @throws InitException exception that occures when all libraries are not properly loaded.
	 * @see #loadLibraries(int)
	 * @see INIT_MODES
	 */
	public static void loadLibraries() throws InitException {
		if(!org.jouvieje.fmodex.Init.isLibrariesLoaded()) {
			throw new InitException("You should call "+org.jouvieje.fmodex.Init.class.getName()+".loadLibraries() first.");
		}
		
		final String fmod_event_net = "fmod_event_net";
		final String fmodevent = "fmodevent";
		final String fmodeventnet = "fmodeventnet";
		
		final String x64 = "64";
		final String lib = "lib";
		final String dll = ".dll";
		final String so = ".so";
		final String jnilib = ".jnilib";
		
		LibLoader.DEBUG = DEBUG;
		
		// Native Library Loading
		{
			final LibraryConfig libConfig = new LibraryConfig();
			libConfig.windowsLibraries = new PlatformLibrary(fmod_event_net, fmod_event_net+dll);
			libConfig.windows64Libraries = new PlatformLibrary(fmod_event_net+x64, fmod_event_net+x64+dll);
			libConfig.linuxLibraries = new PlatformLibrary(fmodevent, lib+fmodevent+so);
			libConfig.linux64Libraries = new PlatformLibrary(fmodevent+x64, lib+fmodevent+x64+so);
			libConfig.macLibraries = new PlatformLibrary(fmodeventnet, lib+fmodeventnet+jnilib);
			
			if(!LibLoader.loadLibrary(libConfig, true)) {
				throw new InitException("no FMOD Desginer in java.library.path or org.lwjgl.librarypath");
			}
			printlnDebug("FMOD Designer successfully loaded");
		}
		final String NativeFmodDesigner = "NativeFmodDesigner";
		if(!LibLoader.loadLibrary(NativeFmodDesigner, false)) {
			throw new InitException("no "+NativeFmodDesigner+" in java.library.path or org.lwjgl.librarypath");
		}
		printlnDebug(NativeFmodDesigner+" successfully loaded");
		
		// Optional library
		{
			final LibraryConfig optLibConfig = new LibraryConfig();
			optLibConfig.linuxLibraries = new PlatformLibrary(fmodeventnet, lib+fmodeventnet+so);
			optLibConfig.linux64Libraries = new PlatformLibrary(fmodeventnet+x64, lib+fmodeventnet+x64+so);
			
			final boolean optLibLoaded = LibLoader.loadLibrary(optLibConfig, false);
			printlnDebug("FMOD Designer optional libraries are "+((optLibLoaded)?"not":"")+" loaded");
		}
		
		//Attach callbacks
		attachJavaVM();
		
		librariesLoaded = true;
	}
	
	protected final static native void attachJavaVM() throws InitException;
	
	/**
	 * You can use this method to know if all libraries needed for the <code>INIT_MODES</code> choosen.
	 * @return true if all libraries requiered are loaded.
	 */
	public static boolean isLibrariesLoaded() {
		return librariesLoaded;
	}
	
	private static void printlnDebug(String s) {
		if(DEBUG) {
			java.lang.System.out.println(s);
		}
	}
}
