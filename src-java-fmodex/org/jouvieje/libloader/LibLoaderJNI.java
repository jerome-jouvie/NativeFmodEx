/**
 * 							LibLoader
 *
 * Projet created for loading NativeFmod & NativeFmodEx libraries.
 * Copyright � 2007-2010 J�r�me JOUVIE (Jouvieje)
 *
 * Created on 25 mar. 2007
 * @version file v1.2
 * @author J�r�me JOUVIE (Jouvieje)
 * @site   http://jerome.jouvie.free.fr/
 * @mail   jerome.jouvie@gmail.com
 *
 *
 * INTRODUCTION
 * Project created to fix library loading, System.loadLibrary load library
 * with RTLD_LOCAL, RTLD_GLOCAL is needed for loading well NativeFmodEx under linux.
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

package org.jouvieje.libloader;

class LibLoaderJNI {
	static {
		if(!LibLoader.isLibLoaderLibsLoaded()) {
			throw new UnsatisfiedLinkError("LibLoader libraries not loaded !");
		}
	}
	
	/* void *dlopen(const char *filename, int flag); */
	protected final static native long dlopen(byte[] filename, int flag);
	/* char *dlerror(void); */
	protected final static native String dlerror();
	/* void *dlsym(void *handle, const char *symbol); */
	protected final static native long dlsym(long handle, byte[] symbol);
	/* int dlopen(void *handle); */
	protected final static native int dlclose(long handle);
}
