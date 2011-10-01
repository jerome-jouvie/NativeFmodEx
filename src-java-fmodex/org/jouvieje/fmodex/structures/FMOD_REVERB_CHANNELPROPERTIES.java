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

package org.jouvieje.fmodex.structures;

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

public class FMOD_REVERB_CHANNELPROPERTIES extends Pointer {
	/**
	 * Create a view of the <code>Pointer</code> object as a <code>FMOD_REVERB_CHANNELPROPERTIES</code> object.<br>
	 * This view is valid only if the memory holded by the <code>Pointer</code> holds a FMOD_REVERB_CHANNELPROPERTIES object.
	 */
	public static FMOD_REVERB_CHANNELPROPERTIES asFMOD_REVERB_CHANNELPROPERTIES(Pointer pointer) {
		long address = Pointer.getPointer(pointer);
		if(address == 0) return null;
		return new FMOD_REVERB_CHANNELPROPERTIES(address);
	}
	/**
	 * Allocate a new <code>FMOD_REVERB_CHANNELPROPERTIES</code>.<br>
	 * The call <code>isNull()</code> on the object created will return false.<br>
	 * <pre><code>  FMOD_REVERB_CHANNELPROPERTIES obj = FMOD_REVERB_CHANNELPROPERTIES.allocate();
	 *  (obj == null) <=> obj.isNull() <=> false
	 * </code></pre>
	 */
	public static FMOD_REVERB_CHANNELPROPERTIES allocate() {
		final long pointer = StructureJNI.FMOD_REVERB_CHANNELPROPERTIES_new();
		if(pointer == 0) throw new OutOfMemoryError();
		return new FMOD_REVERB_CHANNELPROPERTIES(pointer);
	}

	protected FMOD_REVERB_CHANNELPROPERTIES(long pointer) {
		super(pointer);
	}

	/**
	 * Create an object that holds a null <code>FMOD_REVERB_CHANNELPROPERTIES</code>.<br>
	 * The call <code>isNull()</code> on the object created will returns true.<br>
	 * <pre><code>  FMOD_REVERB_CHANNELPROPERTIES obj = new FMOD_REVERB_CHANNELPROPERTIES();
	 *  (obj == null) <=> false
	 *  obj.isNull() <=> true
	 * </code></pre>
	 * To creates a new <code>FMOD_REVERB_CHANNELPROPERTIES</code>, use the static "constructor" :
	 * <pre><code>  FMOD_REVERB_CHANNELPROPERTIES obj = FMOD_REVERB_CHANNELPROPERTIES.allocate();</code></pre>
	 * @see FMOD_REVERB_CHANNELPROPERTIES#allocate()
	 */
	public FMOD_REVERB_CHANNELPROPERTIES() {
		super();
	}

	public void release() {
		if(pointer != 0) {
			StructureJNI.FMOD_REVERB_CHANNELPROPERTIES_delete(pointer);
		}
		pointer = 0;
	}

	/**
	 * [r/w] -10000, 1000,  0,       direct path level (at low and mid frequencies)              (SUPPORTED:EAX/I3DL2/SFX)
	 */
	public int getDirect() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_REVERB_CHANNELPROPERTIES_get_Direct(pointer);
		return javaResult;
	}
	/**
	 * [r/w] -10000, 1000,  0,       direct path level (at low and mid frequencies)              (SUPPORTED:EAX/I3DL2/SFX)
	 */
	public void setDirect(int direct) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_REVERB_CHANNELPROPERTIES_set_Direct(pointer, direct);
	}

	/**
	 * [r/w] -10000, 0,     0,       relative direct path level at high frequencies              (SUPPORTED:EAX/I3DL2)
	 */
	public int getDirectHF() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_REVERB_CHANNELPROPERTIES_get_DirectHF(pointer);
		return javaResult;
	}
	/**
	 * [r/w] -10000, 0,     0,       relative direct path level at high frequencies              (SUPPORTED:EAX/I3DL2)
	 */
	public void setDirectHF(int directHF) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_REVERB_CHANNELPROPERTIES_set_DirectHF(pointer, directHF);
	}

	/**
	 * [r/w] -10000, 1000,  0,       room effect level (at low and mid frequencies)              (SUPPORTED:EAX/I3DL2/SFX)
	 */
	public int getRoom() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_REVERB_CHANNELPROPERTIES_get_Room(pointer);
		return javaResult;
	}
	/**
	 * [r/w] -10000, 1000,  0,       room effect level (at low and mid frequencies)              (SUPPORTED:EAX/I3DL2/SFX)
	 */
	public void setRoom(int room) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_REVERB_CHANNELPROPERTIES_set_Room(pointer, room);
	}

	/**
	 * [r/w] -10000, 0,     0,       relative room effect level at high frequencies              (SUPPORTED:EAX/I3DL2)
	 */
	public int getRoomHF() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_REVERB_CHANNELPROPERTIES_get_RoomHF(pointer);
		return javaResult;
	}
	/**
	 * [r/w] -10000, 0,     0,       relative room effect level at high frequencies              (SUPPORTED:EAX/I3DL2)
	 */
	public void setRoomHF(int roomHF) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_REVERB_CHANNELPROPERTIES_set_RoomHF(pointer, roomHF);
	}

	/**
	 * [r/w] -10000, 0,     0,       main obstruction control (attenuation at high frequencies)  (SUPPORTED:EAX/I3DL2)
	 */
	public int getObstruction() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_REVERB_CHANNELPROPERTIES_get_Obstruction(pointer);
		return javaResult;
	}
	/**
	 * [r/w] -10000, 0,     0,       main obstruction control (attenuation at high frequencies)  (SUPPORTED:EAX/I3DL2)
	 */
	public void setObstruction(int obstruction) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_REVERB_CHANNELPROPERTIES_set_Obstruction(pointer, obstruction);
	}

	/**
	 * [r/w] 0.0,    1.0,   0.0,     obstruction low-frequency level re. main control            (SUPPORTED:EAX/I3DL2)
	 */
	public float getObstructionLFRatio() {
		if(pointer == 0) throw new NullPointerException();
		float javaResult = StructureJNI.FMOD_REVERB_CHANNELPROPERTIES_get_ObstructionLFRatio(pointer);
		return javaResult;
	}
	/**
	 * [r/w] 0.0,    1.0,   0.0,     obstruction low-frequency level re. main control            (SUPPORTED:EAX/I3DL2)
	 */
	public void setObstructionLFRatio(float obstructionLFRatio) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_REVERB_CHANNELPROPERTIES_set_ObstructionLFRatio(pointer, obstructionLFRatio);
	}

	/**
	 * [r/w] -10000, 0,     0,       main occlusion control (attenuation at high frequencies)    (SUPPORTED:EAX/I3DL2)
	 */
	public int getOcclusion() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_REVERB_CHANNELPROPERTIES_get_Occlusion(pointer);
		return javaResult;
	}
	/**
	 * [r/w] -10000, 0,     0,       main occlusion control (attenuation at high frequencies)    (SUPPORTED:EAX/I3DL2)
	 */
	public void setOcclusion(int occlusion) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_REVERB_CHANNELPROPERTIES_set_Occlusion(pointer, occlusion);
	}

	/**
	 * [r/w] 0.0,    1.0,   0.25,    occlusion low-frequency level re. main control              (SUPPORTED:EAX/I3DL2)
	 */
	public float getOcclusionLFRatio() {
		if(pointer == 0) throw new NullPointerException();
		float javaResult = StructureJNI.FMOD_REVERB_CHANNELPROPERTIES_get_OcclusionLFRatio(pointer);
		return javaResult;
	}
	/**
	 * [r/w] 0.0,    1.0,   0.25,    occlusion low-frequency level re. main control              (SUPPORTED:EAX/I3DL2)
	 */
	public void setOcclusionLFRatio(float occlusionLFRatio) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_REVERB_CHANNELPROPERTIES_set_OcclusionLFRatio(pointer, occlusionLFRatio);
	}

	/**
	 * [r/w] 0.0,    10.0,  1.5,     relative occlusion control for room effect                  (SUPPORTED:EAX only)
	 */
	public float getOcclusionRoomRatio() {
		if(pointer == 0) throw new NullPointerException();
		float javaResult = StructureJNI.FMOD_REVERB_CHANNELPROPERTIES_get_OcclusionRoomRatio(pointer);
		return javaResult;
	}
	/**
	 * [r/w] 0.0,    10.0,  1.5,     relative occlusion control for room effect                  (SUPPORTED:EAX only)
	 */
	public void setOcclusionRoomRatio(float occlusionRoomRatio) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_REVERB_CHANNELPROPERTIES_set_OcclusionRoomRatio(pointer, occlusionRoomRatio);
	}

	/**
	 * [r/w] 0.0,    10.0,  1.0,     relative occlusion control for direct path                  (SUPPORTED:EAX only)
	 */
	public float getOcclusionDirectRatio() {
		if(pointer == 0) throw new NullPointerException();
		float javaResult = StructureJNI.FMOD_REVERB_CHANNELPROPERTIES_get_OcclusionDirectRatio(pointer);
		return javaResult;
	}
	/**
	 * [r/w] 0.0,    10.0,  1.0,     relative occlusion control for direct path                  (SUPPORTED:EAX only)
	 */
	public void setOcclusionDirectRatio(float occlusionDirectRatio) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_REVERB_CHANNELPROPERTIES_set_OcclusionDirectRatio(pointer, occlusionDirectRatio);
	}

	/**
	 * [r/w] -10000, 0,     0,       main exlusion control (attenuation at high frequencies)     (SUPPORTED:EAX only)
	 */
	public int getExclusion() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_REVERB_CHANNELPROPERTIES_get_Exclusion(pointer);
		return javaResult;
	}
	/**
	 * [r/w] -10000, 0,     0,       main exlusion control (attenuation at high frequencies)     (SUPPORTED:EAX only)
	 */
	public void setExclusion(int exclusion) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_REVERB_CHANNELPROPERTIES_set_Exclusion(pointer, exclusion);
	}

	/**
	 * [r/w] 0.0,    1.0,   1.0,     exclusion low-frequency level re. main control              (SUPPORTED:EAX only)
	 */
	public float getExclusionLFRatio() {
		if(pointer == 0) throw new NullPointerException();
		float javaResult = StructureJNI.FMOD_REVERB_CHANNELPROPERTIES_get_ExclusionLFRatio(pointer);
		return javaResult;
	}
	/**
	 * [r/w] 0.0,    1.0,   1.0,     exclusion low-frequency level re. main control              (SUPPORTED:EAX only)
	 */
	public void setExclusionLFRatio(float exclusionLFRatio) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_REVERB_CHANNELPROPERTIES_set_ExclusionLFRatio(pointer, exclusionLFRatio);
	}

	/**
	 * [r/w] -10000, 0,     0,       outside sound cone level at high frequencies                (SUPPORTED:EAX only)
	 */
	public int getOutsideVolumeHF() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_REVERB_CHANNELPROPERTIES_get_OutsideVolumeHF(pointer);
		return javaResult;
	}
	/**
	 * [r/w] -10000, 0,     0,       outside sound cone level at high frequencies                (SUPPORTED:EAX only)
	 */
	public void setOutsideVolumeHF(int outsideVolumeHF) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_REVERB_CHANNELPROPERTIES_set_OutsideVolumeHF(pointer, outsideVolumeHF);
	}

	/**
	 * [r/w] 0.0,    10.0,  0.0,     like DS3D flDopplerFactor but per source                    (SUPPORTED:EAX only)
	 */
	public float getDopplerFactor() {
		if(pointer == 0) throw new NullPointerException();
		float javaResult = StructureJNI.FMOD_REVERB_CHANNELPROPERTIES_get_DopplerFactor(pointer);
		return javaResult;
	}
	/**
	 * [r/w] 0.0,    10.0,  0.0,     like DS3D flDopplerFactor but per source                    (SUPPORTED:EAX only)
	 */
	public void setDopplerFactor(float dopplerFactor) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_REVERB_CHANNELPROPERTIES_set_DopplerFactor(pointer, dopplerFactor);
	}

	/**
	 * [r/w] 0.0,    10.0,  0.0,     like DS3D flRolloffFactor but per source                    (SUPPORTED:EAX only)
	 */
	public float getRolloffFactor() {
		if(pointer == 0) throw new NullPointerException();
		float javaResult = StructureJNI.FMOD_REVERB_CHANNELPROPERTIES_get_RolloffFactor(pointer);
		return javaResult;
	}
	/**
	 * [r/w] 0.0,    10.0,  0.0,     like DS3D flRolloffFactor but per source                    (SUPPORTED:EAX only)
	 */
	public void setRolloffFactor(float rolloffFactor) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_REVERB_CHANNELPROPERTIES_set_RolloffFactor(pointer, rolloffFactor);
	}

	/**
	 * [r/w] 0.0,    10.0,  0.0,     like DS3D flRolloffFactor but for room effect               (SUPPORTED:EAX/I3DL2)
	 */
	public float getRoomRolloffFactor() {
		if(pointer == 0) throw new NullPointerException();
		float javaResult = StructureJNI.FMOD_REVERB_CHANNELPROPERTIES_get_RoomRolloffFactor(pointer);
		return javaResult;
	}
	/**
	 * [r/w] 0.0,    10.0,  0.0,     like DS3D flRolloffFactor but for room effect               (SUPPORTED:EAX/I3DL2)
	 */
	public void setRoomRolloffFactor(float roomRolloffFactor) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_REVERB_CHANNELPROPERTIES_set_RoomRolloffFactor(pointer, roomRolloffFactor);
	}

	/**
	 * [r/w] 0.0,    10.0,  1.0,     multiplies AirAbsorptionHF member of FMOD_REVERB_PROPERTIES (SUPPORTED:EAX only)
	 */
	public float getAirAbsorptionFactor() {
		if(pointer == 0) throw new NullPointerException();
		float javaResult = StructureJNI.FMOD_REVERB_CHANNELPROPERTIES_get_AirAbsorptionFactor(pointer);
		return javaResult;
	}
	/**
	 * [r/w] 0.0,    10.0,  1.0,     multiplies AirAbsorptionHF member of FMOD_REVERB_PROPERTIES (SUPPORTED:EAX only)
	 */
	public void setAirAbsorptionFactor(float airAbsorptionFactor) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_REVERB_CHANNELPROPERTIES_set_AirAbsorptionFactor(pointer, airAbsorptionFactor);
	}

	/**
	 * [r/w] FMOD_REVERB_CHANNELFLAGS - modifies the behavior of properties                      (SUPPORTED:EAX/SFX)
	 */
	public int getFlags() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_REVERB_CHANNELPROPERTIES_get_Flags(pointer);
		return javaResult;
	}
	/**
	 * [r/w] FMOD_REVERB_CHANNELFLAGS - modifies the behavior of properties                      (SUPPORTED:EAX/SFX)
	 */
	public void setFlags(int flags) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_REVERB_CHANNELPROPERTIES_set_Flags(pointer, flags);
	}

	/**
	 * [r/w] See remarks.            DSP network location to connect reverb for this channel.    (SUPPORTED:SFX only).
	 */
	public DSP getConnectionPoint() {
		if(pointer == 0) throw new NullPointerException();
		long javaResult = StructureJNI.FMOD_REVERB_CHANNELPROPERTIES_get_ConnectionPoint(pointer);
		return javaResult == 0 ? null : DSP.asDSP(Pointer.newPointer(javaResult));
	}
	/**
	 * [r/w] See remarks.            DSP network location to connect reverb for this channel.    (SUPPORTED:SFX only).
	 */
	public void setConnectionPoint(DSP connectionPoint) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_REVERB_CHANNELPROPERTIES_set_ConnectionPoint(pointer, Pointer.getPointer(connectionPoint));
	}

}
