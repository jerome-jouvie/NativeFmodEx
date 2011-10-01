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

package org.jouvieje.fmodex;

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

/**
 * 'Geometry' API
 */
public class Geometry extends Pointer {
	/**
	 * Create a view of the <code>Pointer</code> object as a <code>Geometry</code> object.<br>
	 * This view is valid only if the memory holded by the <code>Pointer</code> holds a Geometry object.
	 */
	public static Geometry asGeometry(Pointer pointer) {
		long address = Pointer.getPointer(pointer);
		if(address == 0) return null;
		return new Geometry(address);
	}
	private Geometry(long pointer) {
		super(pointer);
	}

	public Geometry() {
		super(0);
	}

	/**
	 * 
	 */
	public FMOD_RESULT release() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodExJNI.Geometry_release(pointer);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT addPolygon(float directocclusion, float reverbocclusion, boolean doublesided, int numvertices, FMOD_VECTOR[] vertices, IntBuffer polygonindex) {
		if(pointer == 0) throw new NullPointerException();
		if(polygonindex != null && !polygonindex.isDirect()) {
			throw new NonDirectBufferException();
		}
		int javaResult = FmodExJNI.Geometry_addPolygon(pointer, directocclusion, reverbocclusion, doublesided, numvertices, (vertices == null) ? 0 : Pointer.getPointer(vertices[0]), (vertices == null) ? 0 : vertices.length, polygonindex, BufferUtils.getPositionInBytes(polygonindex));
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT getNumPolygons(IntBuffer numpolygons) {
		if(pointer == 0) throw new NullPointerException();
		if(numpolygons != null && !numpolygons.isDirect()) {
			throw new NonDirectBufferException();
		}
		int javaResult = FmodExJNI.Geometry_getNumPolygons(pointer, numpolygons, BufferUtils.getPositionInBytes(numpolygons));
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT getMaxPolygons(IntBuffer maxpolygons, IntBuffer maxvertices) {
		if(pointer == 0) throw new NullPointerException();
		if(maxpolygons != null && !maxpolygons.isDirect()) {
			throw new NonDirectBufferException();
		}
		if(maxvertices != null && !maxvertices.isDirect()) {
			throw new NonDirectBufferException();
		}
		int javaResult = FmodExJNI.Geometry_getMaxPolygons(pointer, maxpolygons, BufferUtils.getPositionInBytes(maxpolygons), maxvertices, BufferUtils.getPositionInBytes(maxvertices));
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT getPolygonNumVertices(int index, IntBuffer numvertices) {
		if(pointer == 0) throw new NullPointerException();
		if(numvertices != null && !numvertices.isDirect()) {
			throw new NonDirectBufferException();
		}
		int javaResult = FmodExJNI.Geometry_getPolygonNumVertices(pointer, index, numvertices, BufferUtils.getPositionInBytes(numvertices));
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT setPolygonVertex(int index, int vertexindex, FMOD_VECTOR vertex) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodExJNI.Geometry_setPolygonVertex(pointer, index, vertexindex, Pointer.getPointer(vertex));
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT getPolygonVertex(int index, int vertexindex, FMOD_VECTOR vertex) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodExJNI.Geometry_getPolygonVertex(pointer, index, vertexindex, Pointer.getPointer(vertex));
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT setPolygonAttributes(int index, float directocclusion, float reverbocclusion, boolean doublesided) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodExJNI.Geometry_setPolygonAttributes(pointer, index, directocclusion, reverbocclusion, doublesided);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT getPolygonAttributes(int index, FloatBuffer directocclusion, FloatBuffer reverbocclusion, ByteBuffer doublesided) {
		if(pointer == 0) throw new NullPointerException();
		if(directocclusion != null && !directocclusion.isDirect()) {
			throw new NonDirectBufferException();
		}
		if(reverbocclusion != null && !reverbocclusion.isDirect()) {
			throw new NonDirectBufferException();
		}
		if(doublesided != null && !doublesided.isDirect()) {
			throw new NonDirectBufferException();
		}
		int javaResult = FmodExJNI.Geometry_getPolygonAttributes(pointer, index, directocclusion, BufferUtils.getPositionInBytes(directocclusion), reverbocclusion, BufferUtils.getPositionInBytes(reverbocclusion), doublesided, BufferUtils.getPositionInBytes(doublesided));
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT setActive(boolean active) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodExJNI.Geometry_setActive(pointer, active);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT getActive(ByteBuffer active) {
		if(pointer == 0) throw new NullPointerException();
		if(active != null && !active.isDirect()) {
			throw new NonDirectBufferException();
		}
		int javaResult = FmodExJNI.Geometry_getActive(pointer, active, BufferUtils.getPositionInBytes(active));
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT setRotation(FMOD_VECTOR forward, FMOD_VECTOR up) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodExJNI.Geometry_setRotation(pointer, Pointer.getPointer(forward), Pointer.getPointer(up));
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT getRotation(FMOD_VECTOR forward, FMOD_VECTOR up) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodExJNI.Geometry_getRotation(pointer, Pointer.getPointer(forward), Pointer.getPointer(up));
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT setPosition(FMOD_VECTOR position) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodExJNI.Geometry_setPosition(pointer, Pointer.getPointer(position));
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT getPosition(FMOD_VECTOR position) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodExJNI.Geometry_getPosition(pointer, Pointer.getPointer(position));
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT setScale(FMOD_VECTOR scale) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodExJNI.Geometry_setScale(pointer, Pointer.getPointer(scale));
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT getScale(FMOD_VECTOR scale) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodExJNI.Geometry_getScale(pointer, Pointer.getPointer(scale));
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT save(ByteBuffer data, IntBuffer datasize) {
		if(pointer == 0) throw new NullPointerException();
		if(data != null && !data.isDirect()) {
			throw new NonDirectBufferException();
		}
		if(datasize != null && !datasize.isDirect()) {
			throw new NonDirectBufferException();
		}
		int javaResult = FmodExJNI.Geometry_save(pointer, data, BufferUtils.getPositionInBytes(data), datasize, BufferUtils.getPositionInBytes(datasize));
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT setUserData(Pointer userdata) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodExJNI.Geometry_setUserData(pointer, Pointer.getPointer(userdata));
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT getUserData(Pointer userdata) {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = FmodExJNI.Geometry_getUserData(pointer, userdata);
		return FMOD_RESULT.get(javaResult);
	}

	/**
	 * 
	 */
	public FMOD_RESULT getMemoryInfo(int memorybits, int event_memorybits, IntBuffer memoryused, FMOD_MEMORY_USAGE_DETAILS memoryused_details) {
		if(pointer == 0) throw new NullPointerException();
		if(memoryused != null && !memoryused.isDirect()) {
			throw new NonDirectBufferException();
		}
		int javaResult = FmodExJNI.Geometry_getMemoryInfo(pointer, memorybits, event_memorybits, memoryused, BufferUtils.getPositionInBytes(memoryused), Pointer.getPointer(memoryused_details));
		return FMOD_RESULT.get(javaResult);
	}

}
