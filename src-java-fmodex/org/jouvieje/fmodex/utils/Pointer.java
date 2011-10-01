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

package org.jouvieje.fmodex.utils;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * A <code>Pointer</code> object is used to holds a part of the memory.<BR>
 * It can be used to hold any kind of object: both general java object and native objects.
 * <BR>
 * <B><U>ACCESSING VALUE</U></B><BR>
 * To access the value store in the memory, you need to know which kind of object it holds.
 * Afterwards, create the appropriate view of the memory block.<BR>
 * For a String :<BR>
 * <code><pre>
 * Pointer pointer;
 * String string = pointer.asString();
 * </pre></code>
 * For a native object (with java wrapper named NativeObject) :
 * <code><pre>
 * Pointer pointer;
 * NativeObject nativeObject = NativeObject.asNativeObject(pointer);
 * </pre></code>
 * <B><U>Warning :</B></U><BR>
 * If you create an inpropriate 'cast', the JVM (Java Virtual Machine) may crash !<BR>
 */
public class Pointer {
	protected long pointer;

	/**
	 * Default constructor.<BR>
	 * No memory is owned, the object holded is null.
	 * The call <code>isNull()</code> will return <code>true</code>.
	 */
	public Pointer() {
		this.pointer = 0;
	}

	/** @param pointer address pointer in the memory. */
	protected Pointer(long pointer) {
		this.pointer = pointer;
	}

	/**
	 * Retrieve the <code>String</code> value stored in a <code>Pointer</code> (null terminated string).<BR>
	 * @return the String stored in the Pointer.<BR>
	 * null if no String is stored in the buffer.
	 * @see #asString(int, int)
	 */
	public String asString() {
		final long address = pointer;
		return (address == 0) ? null : MiscJNI.Pointer_toString(address);
	}

	/**
	 * Retrieve the <code>String</code> value stored in the <code>Pointer</code>.
	 * @param offset offset (in characters) from the current position in the <code>Pointer</code>.
	 * @param length length of the String to retrieve.
	 * @return the string stored in the <code>Pointer</code>.
	 * @see #asString(Pointer
	 * @see BufferUtils#toString(ByteBuffer, int, int)
	 */
	public String asString(int offset, int length) {
		final long tempAddress = pointer;
		if(tempAddress == 0) {
			return null;
		}
		final long address = tempAddress + offset;

		final String s = MiscJNI.Pointer_toString(address);
		if((s != null) && (s.length() > length)) {
			return s.substring(0, length);
		}
		else {
			return s;
		}
	}

	/**
	 * Create a view of the <code>Pointer</code> object as a <code>ByteBuffer</code> object.<br>
	 * @param offsetInBytes offset in BYTES
	 * @param capacityInBytes capacity in BYTES
	 * @return the ByteBuffer view.
	 */
	public ByteBuffer asByteBuffer(int offsetInBytes, int capacityInBytes) {
		final ByteBuffer result = MiscJNI.newDirectByteBuffer(pointer + offsetInBytes, capacityInBytes);
		if(result != null) {
			result.order(ByteOrder.nativeOrder());
		}
		return result;
	}

	public int asInt() {
		if(pointer != 0) {
			return MiscJNI.asInt(pointer);
		}
		return 0;
	}

	public long asLong() {
		return pointer;
	}

	public float asFloat() {
		if(pointer != 0) {
			return MiscJNI.asFloat(pointer);
		}
		return 0;
	}

	public double asDouble() {
		if(pointer != 0) {
			return MiscJNI.asDouble(pointer);
		}
		return 0;
	}

	public Pointer asPointer(long offset) {
		return new Pointer(pointer + offset);
	}

	/**
	 * Use to know if two object are equals.<BR>
	 * Do NOT use this :<BR>
	 * <code><pre>
	 * Sound sound1, sound2;
	 * ...
	 * if(sound1 == sound2)
	 * {
	 *     ...
	 * </pre></code>
	 * Use this :<BR>
	 * <code><pre>
	 * Sound sound1, sound2;
	 * ...
	 * if(sound1.equals(sound2))
	 * {
	 *     ...
	 * </pre></code>
	 */
	public boolean equals(Object object) {
		if(object instanceof Pointer) {
			return pointer == Pointer.getPointer((Pointer)object);
		}
		return false;
	}

	/** @return true if no memory is holded (ie object holded in the memory is null). */
	public boolean isNull() {
		return pointer == 0;
	}

	/**
	 * Share the same memory region that the <code>Pointer</code> object passed as parameter.<BR>
	 * @param source a <code>Pointer</code>.
	 */
	public void shareMemory(Pointer source) {
		this.pointer = getPointer(source);
	}

	protected static long getPointer(Pointer pointer) {
		if(pointer != null) {
			return pointer.pointer;
		}
		return 0;
	}

	/* JNI access*/
	protected static Pointer newPointer(long address) {
		return new Pointer(address);
	}
}
