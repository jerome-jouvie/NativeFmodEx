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

package org.jouvieje.fmodex.defines;

public interface VERSIONS {
	/**
	 * FMOD version number.  Check this against <code>FMOD::System::getVersion</code>.<br>
	 * 0xaaaabbcc -> aaaa = major version number.  bb = minor version number.  cc = development version number.
	 */
	public final static int FMOD_VERSION = VersionsJNI.get_FMOD_VERSION();
	
	/**
	 * NativeFmodEx jar version.<br>
	 * 0xaaaabbcc -> aaaa = major version number.  bb = minor version number.  cc = development version number.<br>
	 * <br>
	 * <B><U>Warning :</U></B><br>
	 * NativeFmodEx & FmodEx have differents versions !
	 */
	public final static int NATIVEFMODEX_JAR_VERSION = VersionsJNI.get_NATIVEFMODEX_JAR_VERSION();
	/**
	 * NativeFmodEx library version.<br>
	 * 0xaaaabbcc -> aaaa = major version number.  bb = minor version number.  cc = development version number.<br>
	 * <br>
	 * <B><U>Warning :</U></B><br>
	 * NativeFmodEx & FmodEx have differents versions !
	 */
	public final static int NATIVEFMODEX_LIBRARY_VERSION = VersionsJNI.get_NATIVEFMODEX_VERSION();
}