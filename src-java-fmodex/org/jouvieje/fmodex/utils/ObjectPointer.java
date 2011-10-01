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

/**
 * Container of a java object to be used by the underlaying native API.<BR>
 * <BR>
 * <B><U>ACCESSING VALUE</U></B><BR>
 * If you want to access the Object store in <code>ObjectPointer</code>, use:<BR>
 * <code><pre>
 *  Object o;
 *  ObjectPointer objectPointer = new ObjectPointer(o);
 *  // And later
 *  Object o = (Object)objectPointer.getObject();
 * </pre></code>
 * <BR>
 * <B><U>CLEANING</U></B><BR>
 * The Object stored is not deleted automatically by the <code>Garbage Collector</code>.<BR>
 * To delete it, you have to call <code>release</code> on <code>ObjectPointer</code>.
 */
public class ObjectPointer extends Pointer {
	/**
	 * Create a view of the <code>Pointer</code> as a <code>ObjectPointer</code> object.<br>
	 * This view is valid only if the memory holded by the <code>Pointer</code> holds an <code>Object</code>.
	 */
	public static ObjectPointer asObjectPointer(Pointer pointer) {
		return new ObjectPointer(Pointer.getPointer(pointer));
	}
	/**
	 * Create a new <code>ObjectPointer</code>.<br>
	 * The call <code>isNull()</code> on the object created will return false.<br>
	 * <pre><code>  ObjectPointer obj = ObjectPointer.allocate();
	 *  (obj == null) <=> obj.isNull() <=> false
	 * </code></pre>
	 */
	public static ObjectPointer allocate(Object obj) {
		return new ObjectPointer(MiscJNI.new_ObjectPointer(obj));
	}

	protected ObjectPointer(long pointer) {
		super(pointer);
	}

	/**
	 * Create an object that holds a null <code>ObjectPointer</code>.<br>
	 * The call <code>isNull()</code> on the object created will returns true.<br>
	 * <pre><code>  ObjectPointer obj = new ObjectPointer();
	 *  (obj == null) <=> false
	 *  obj.isNull() <=> true
	 * </code></pre>
	 * To creates a new <code>ObjectPointer</code>, use the static "constructor" :
	 * <pre><code>  ObjectPointer obj = ObjectPointer.allocate();</code></pre>
	 * @see ObjectPointer#allocate(Object)
	 */
	public ObjectPointer() {
		super();
	}

	public void release() {
		if(pointer != 0) {
			MiscJNI.delete_ObjectPointer(pointer);
		}
		pointer = 0;
	}

	/** @return the object stored in the memory */
	public Object getValue() {
		return getObject();
	}

	/** @return the object stored in the memory */
	public Object getObject() {
		return MiscJNI.get_ObjectPointer(pointer);
	}

	/** @param obj object to store in the memory. */
	public void setObject(Object obj) {
		MiscJNI.set_ObjectPointer(pointer, obj);
	}
}
