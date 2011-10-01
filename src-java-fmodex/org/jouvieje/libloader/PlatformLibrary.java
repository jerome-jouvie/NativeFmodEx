/* $LICENSE$ */
package org.jouvieje.libloader;

public class PlatformLibrary {
	public final String libraryName;
	public final String libraryFullName;
	public final boolean optional;
	public PlatformLibrary(String libraryName, String libraryFullName) {
		this(libraryName, libraryFullName, true);
	}
	public PlatformLibrary(String libraryName, String libraryFullName, boolean optional) {
		this.libraryName = libraryName;
		this.libraryFullName = libraryFullName;
		this.optional = optional;
	}
}