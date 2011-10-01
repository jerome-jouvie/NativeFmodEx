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
import org.jouvieje.fmodex.defines.FMOD_REVERB_PRESETS;

public class FMOD_REVERB_PROPERTIES extends Pointer {
	/**
	 * Create an <code>FMOD_REVERB_PROPERTIES</code> using a preset <code>FMOD_REVERB_PRESETS</code>.<br>
	 * @param preset a preset of the interface <code>FMOD_REVERB_PRESETS</code>.
	 * @see org.jouvieje.fmodex.defines.FMOD_REVERB_PRESETS
	 */
	public static FMOD_REVERB_PROPERTIES create(int preset) {
		switch(preset) {
			case FMOD_REVERB_PRESETS.FMOD_PRESET_OFF: 				return new FMOD_REVERB_PROPERTIES(StructureJNI.get_FMOD_PRESET_OFF());
			case FMOD_REVERB_PRESETS.FMOD_PRESET_GENERIC: 			return new FMOD_REVERB_PROPERTIES(StructureJNI.get_FMOD_PRESET_GENERIC());
			case FMOD_REVERB_PRESETS.FMOD_PRESET_PADDEDCELL: 		return new FMOD_REVERB_PROPERTIES(StructureJNI.get_FMOD_PRESET_PADDEDCELL());
			case FMOD_REVERB_PRESETS.FMOD_PRESET_ROOM: 				return new FMOD_REVERB_PROPERTIES(StructureJNI.get_FMOD_PRESET_ROOM());
			case FMOD_REVERB_PRESETS.FMOD_PRESET_BATHROOM: 			return new FMOD_REVERB_PROPERTIES(StructureJNI.get_FMOD_PRESET_BATHROOM());
			case FMOD_REVERB_PRESETS.FMOD_PRESET_LIVINGROOM: 		return new FMOD_REVERB_PROPERTIES(StructureJNI.get_FMOD_PRESET_LIVINGROOM());
			case FMOD_REVERB_PRESETS.FMOD_PRESET_STONEROOM: 		return new FMOD_REVERB_PROPERTIES(StructureJNI.get_FMOD_PRESET_STONEROOM());
			case FMOD_REVERB_PRESETS.FMOD_PRESET_AUDITORIUM: 		return new FMOD_REVERB_PROPERTIES(StructureJNI.get_FMOD_PRESET_AUDITORIUM());
			case FMOD_REVERB_PRESETS.FMOD_PRESET_CONCERTHALL: 		return new FMOD_REVERB_PROPERTIES(StructureJNI.get_FMOD_PRESET_CONCERTHALL());
			case FMOD_REVERB_PRESETS.FMOD_PRESET_CAVE: 				return new FMOD_REVERB_PROPERTIES(StructureJNI.get_FMOD_PRESET_CAVE());
			case FMOD_REVERB_PRESETS.FMOD_PRESET_ARENA: 			return new FMOD_REVERB_PROPERTIES(StructureJNI.get_FMOD_PRESET_ARENA());
			case FMOD_REVERB_PRESETS.FMOD_PRESET_HANGAR: 			return new FMOD_REVERB_PROPERTIES(StructureJNI.get_FMOD_PRESET_HANGAR());
			case FMOD_REVERB_PRESETS.FMOD_PRESET_CARPETTEDHALLWAY: 	return new FMOD_REVERB_PROPERTIES(StructureJNI.get_FMOD_PRESET_CARPETTEDHALLWAY());
			case FMOD_REVERB_PRESETS.FMOD_PRESET_HALLWAY: 			return new FMOD_REVERB_PROPERTIES(StructureJNI.get_FMOD_PRESET_HALLWAY());
			case FMOD_REVERB_PRESETS.FMOD_PRESET_STONECORRIDOR: 	return new FMOD_REVERB_PROPERTIES(StructureJNI.get_FMOD_PRESET_STONECORRIDOR());
			case FMOD_REVERB_PRESETS.FMOD_PRESET_ALLEY: 			return new FMOD_REVERB_PROPERTIES(StructureJNI.get_FMOD_PRESET_ALLEY());
			case FMOD_REVERB_PRESETS.FMOD_PRESET_FOREST: 			return new FMOD_REVERB_PROPERTIES(StructureJNI.get_FMOD_PRESET_FOREST());
			case FMOD_REVERB_PRESETS.FMOD_PRESET_CITY: 				return new FMOD_REVERB_PROPERTIES(StructureJNI.get_FMOD_PRESET_CITY());
			case FMOD_REVERB_PRESETS.FMOD_PRESET_MOUNTAINS: 		return new FMOD_REVERB_PROPERTIES(StructureJNI.get_FMOD_PRESET_MOUNTAINS());
			case FMOD_REVERB_PRESETS.FMOD_PRESET_QUARRY: 			return new FMOD_REVERB_PROPERTIES(StructureJNI.get_FMOD_PRESET_QUARRY());
			case FMOD_REVERB_PRESETS.FMOD_PRESET_PLAIN: 			return new FMOD_REVERB_PROPERTIES(StructureJNI.get_FMOD_PRESET_PLAIN());
			case FMOD_REVERB_PRESETS.FMOD_PRESET_PARKINGLOT: 		return new FMOD_REVERB_PROPERTIES(StructureJNI.get_FMOD_PRESET_PARKINGLOT());
			case FMOD_REVERB_PRESETS.FMOD_PRESET_SEWERPIPE: 		return new FMOD_REVERB_PROPERTIES(StructureJNI.get_FMOD_PRESET_SEWERPIPE());
			case FMOD_REVERB_PRESETS.FMOD_PRESET_UNDERWATER: 		return new FMOD_REVERB_PROPERTIES(StructureJNI.get_FMOD_PRESET_UNDERWATER());
			case FMOD_REVERB_PRESETS.FMOD_PRESET_DRUGGED: 			return new FMOD_REVERB_PROPERTIES(StructureJNI.get_FMOD_PRESET_DRUGGED());
			case FMOD_REVERB_PRESETS.FMOD_PRESET_DIZZY: 			return new FMOD_REVERB_PROPERTIES(StructureJNI.get_FMOD_PRESET_DIZZY());
			case FMOD_REVERB_PRESETS.FMOD_PRESET_PSYCHOTIC: 		return new FMOD_REVERB_PROPERTIES(StructureJNI.get_FMOD_PRESET_PSYCHOTIC());
			case FMOD_REVERB_PRESETS.FMOD_PRESET_PS2_ROOM: 			return new FMOD_REVERB_PROPERTIES(StructureJNI.get_FMOD_PRESET_PS2_ROOM());
			case FMOD_REVERB_PRESETS.FMOD_PRESET_PS2_STUDIO_A: 		return new FMOD_REVERB_PROPERTIES(StructureJNI.get_FMOD_PRESET_PS2_STUDIO_A());
			case FMOD_REVERB_PRESETS.FMOD_PRESET_PS2_STUDIO_B: 		return new FMOD_REVERB_PROPERTIES(StructureJNI.get_FMOD_PRESET_PS2_STUDIO_B());
			case FMOD_REVERB_PRESETS.FMOD_PRESET_PS2_STUDIO_C: 		return new FMOD_REVERB_PROPERTIES(StructureJNI.get_FMOD_PRESET_PS2_STUDIO_C());
			case FMOD_REVERB_PRESETS.FMOD_PRESET_PS2_HALL: 			return new FMOD_REVERB_PROPERTIES(StructureJNI.get_FMOD_PRESET_PS2_HALL());
			case FMOD_REVERB_PRESETS.FMOD_PRESET_PS2_SPACE: 		return new FMOD_REVERB_PROPERTIES(StructureJNI.get_FMOD_PRESET_PS2_SPACE());
			case FMOD_REVERB_PRESETS.FMOD_PRESET_PS2_ECHO: 			return new FMOD_REVERB_PROPERTIES(StructureJNI.get_FMOD_PRESET_PS2_ECHO());
			case FMOD_REVERB_PRESETS.FMOD_PRESET_PS2_DELAY: 		return new FMOD_REVERB_PROPERTIES(StructureJNI.get_FMOD_PRESET_PS2_DELAY());
			case FMOD_REVERB_PRESETS.FMOD_PRESET_PS2_PIPE: 			return new FMOD_REVERB_PROPERTIES(StructureJNI.get_FMOD_PRESET_PS2_PIPE());
			default : return allocate();
		}
	}
	/**
	 * Create a view of the <code>Pointer</code> object as a <code>FMOD_REVERB_PROPERTIES</code> object.<br>
	 * This view is valid only if the memory holded by the <code>Pointer</code> holds a FMOD_REVERB_PROPERTIES object.
	 */
	public static FMOD_REVERB_PROPERTIES asFMOD_REVERB_PROPERTIES(Pointer pointer) {
		long address = Pointer.getPointer(pointer);
		if(address == 0) return null;
		return new FMOD_REVERB_PROPERTIES(address);
	}
	/**
	 * Allocate a new <code>FMOD_REVERB_PROPERTIES</code>.<br>
	 * The call <code>isNull()</code> on the object created will return false.<br>
	 * <pre><code>  FMOD_REVERB_PROPERTIES obj = FMOD_REVERB_PROPERTIES.allocate();
	 *  (obj == null) <=> obj.isNull() <=> false
	 * </code></pre>
	 */
	public static FMOD_REVERB_PROPERTIES allocate() {
		final long pointer = StructureJNI.FMOD_REVERB_PROPERTIES_new();
		if(pointer == 0) throw new OutOfMemoryError();
		return new FMOD_REVERB_PROPERTIES(pointer);
	}

	protected FMOD_REVERB_PROPERTIES(long pointer) {
		super(pointer);
	}

	/**
	 * Create an object that holds a null <code>FMOD_REVERB_PROPERTIES</code>.<br>
	 * The call <code>isNull()</code> on the object created will returns true.<br>
	 * <pre><code>  FMOD_REVERB_PROPERTIES obj = new FMOD_REVERB_PROPERTIES();
	 *  (obj == null) <=> false
	 *  obj.isNull() <=> true
	 * </code></pre>
	 * To creates a new <code>FMOD_REVERB_PROPERTIES</code>, use the static "constructor" :
	 * <pre><code>  FMOD_REVERB_PROPERTIES obj = FMOD_REVERB_PROPERTIES.allocate();</code></pre>
	 * @see FMOD_REVERB_PROPERTIES#allocate()
	 */
	public FMOD_REVERB_PROPERTIES() {
		super();
	}

	public void release() {
		if(pointer != 0) {
			StructureJNI.FMOD_REVERB_PROPERTIES_delete(pointer);
		}
		pointer = 0;
	}

	/**
	 * [w]   0     , 3     , 0      , Environment Instance. Simultaneous HW reverbs are possible on some platforms. (SUPPORTED:EAX4/SFX(3 instances) and Wii (2 instances))
	 */
	public int getInstance() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_REVERB_PROPERTIES_get_Instance(pointer);
		return javaResult;
	}
	/**
	 * [w]   0     , 3     , 0      , Environment Instance. Simultaneous HW reverbs are possible on some platforms. (SUPPORTED:EAX4/SFX(3 instances) and Wii (2 instances))
	 */
	public void setInstance(int instance) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_REVERB_PROPERTIES_set_Instance(pointer, instance);
	}

	/**
	 * [r/w] -1    , 25    , -1     , sets all listener properties.  -1 = OFF.                                      (SUPPORTED:EAX/PS2)
	 */
	public int getEnvironment() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_REVERB_PROPERTIES_get_Environment(pointer);
		return javaResult;
	}
	/**
	 * [r/w] -1    , 25    , -1     , sets all listener properties.  -1 = OFF.                                      (SUPPORTED:EAX/PS2)
	 */
	public void setEnvironment(int environment) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_REVERB_PROPERTIES_set_Environment(pointer, environment);
	}

	/**
	 * [r/w] 1.0   , 100.0 , 7.5    , environment size in meters                                                    (SUPPORTED:EAX)
	 */
	public float getEnvSize() {
		if(pointer == 0) throw new NullPointerException();
		float javaResult = StructureJNI.FMOD_REVERB_PROPERTIES_get_EnvSize(pointer);
		return javaResult;
	}
	/**
	 * [r/w] 1.0   , 100.0 , 7.5    , environment size in meters                                                    (SUPPORTED:EAX)
	 */
	public void setEnvSize(float envSize) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_REVERB_PROPERTIES_set_EnvSize(pointer, envSize);
	}

	/**
	 * [r/w] 0.0   , 1.0   , 1.0    , environment diffusion                                                         (SUPPORTED:EAX)
	 */
	public float getEnvDiffusion() {
		if(pointer == 0) throw new NullPointerException();
		float javaResult = StructureJNI.FMOD_REVERB_PROPERTIES_get_EnvDiffusion(pointer);
		return javaResult;
	}
	/**
	 * [r/w] 0.0   , 1.0   , 1.0    , environment diffusion                                                         (SUPPORTED:EAX)
	 */
	public void setEnvDiffusion(float envDiffusion) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_REVERB_PROPERTIES_set_EnvDiffusion(pointer, envDiffusion);
	}

	/**
	 * [r/w] -10000, 0     , -1000  , room effect level (at mid frequencies)                                        (SUPPORTED:EAX/I3DL2/SFX)
	 */
	public int getRoom() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_REVERB_PROPERTIES_get_Room(pointer);
		return javaResult;
	}
	/**
	 * [r/w] -10000, 0     , -1000  , room effect level (at mid frequencies)                                        (SUPPORTED:EAX/I3DL2/SFX)
	 */
	public void setRoom(int room) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_REVERB_PROPERTIES_set_Room(pointer, room);
	}

	/**
	 * [r/w] -10000, 0     , -100   , relative room effect level at high frequencies                                (SUPPORTED:EAX/I3DL2/SFX)
	 */
	public int getRoomHF() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_REVERB_PROPERTIES_get_RoomHF(pointer);
		return javaResult;
	}
	/**
	 * [r/w] -10000, 0     , -100   , relative room effect level at high frequencies                                (SUPPORTED:EAX/I3DL2/SFX)
	 */
	public void setRoomHF(int roomHF) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_REVERB_PROPERTIES_set_RoomHF(pointer, roomHF);
	}

	/**
	 * [r/w] -10000, 0     , 0      , relative room effect level at low frequencies                                 (SUPPORTED:EAX/SFX)
	 */
	public int getRoomLF() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_REVERB_PROPERTIES_get_RoomLF(pointer);
		return javaResult;
	}
	/**
	 * [r/w] -10000, 0     , 0      , relative room effect level at low frequencies                                 (SUPPORTED:EAX/SFX)
	 */
	public void setRoomLF(int roomLF) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_REVERB_PROPERTIES_set_RoomLF(pointer, roomLF);
	}

	/**
	 * [r/w] 0.1   , 20.0  , 1.49   , reverberation decay time at mid frequencies                                   (SUPPORTED:EAX/I3DL2/SFX)
	 */
	public float getDecayTime() {
		if(pointer == 0) throw new NullPointerException();
		float javaResult = StructureJNI.FMOD_REVERB_PROPERTIES_get_DecayTime(pointer);
		return javaResult;
	}
	/**
	 * [r/w] 0.1   , 20.0  , 1.49   , reverberation decay time at mid frequencies                                   (SUPPORTED:EAX/I3DL2/SFX)
	 */
	public void setDecayTime(float decayTime) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_REVERB_PROPERTIES_set_DecayTime(pointer, decayTime);
	}

	/**
	 * [r/w] 0.1   , 2.0   , 0.83   , high-frequency to mid-frequency decay time ratio                              (SUPPORTED:EAX/I3DL2/SFX)
	 */
	public float getDecayHFRatio() {
		if(pointer == 0) throw new NullPointerException();
		float javaResult = StructureJNI.FMOD_REVERB_PROPERTIES_get_DecayHFRatio(pointer);
		return javaResult;
	}
	/**
	 * [r/w] 0.1   , 2.0   , 0.83   , high-frequency to mid-frequency decay time ratio                              (SUPPORTED:EAX/I3DL2/SFX)
	 */
	public void setDecayHFRatio(float decayHFRatio) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_REVERB_PROPERTIES_set_DecayHFRatio(pointer, decayHFRatio);
	}

	/**
	 * [r/w] 0.1   , 2.0   , 1.0    , low-frequency to mid-frequency decay time ratio                               (SUPPORTED:EAX)
	 */
	public float getDecayLFRatio() {
		if(pointer == 0) throw new NullPointerException();
		float javaResult = StructureJNI.FMOD_REVERB_PROPERTIES_get_DecayLFRatio(pointer);
		return javaResult;
	}
	/**
	 * [r/w] 0.1   , 2.0   , 1.0    , low-frequency to mid-frequency decay time ratio                               (SUPPORTED:EAX)
	 */
	public void setDecayLFRatio(float decayLFRatio) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_REVERB_PROPERTIES_set_DecayLFRatio(pointer, decayLFRatio);
	}

	/**
	 * [r/w] -10000, 1000  , -2602  , early reflections level relative to room effect                               (SUPPORTED:EAX/I3DL2/SFX)
	 */
	public int getReflections() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_REVERB_PROPERTIES_get_Reflections(pointer);
		return javaResult;
	}
	/**
	 * [r/w] -10000, 1000  , -2602  , early reflections level relative to room effect                               (SUPPORTED:EAX/I3DL2/SFX)
	 */
	public void setReflections(int reflections) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_REVERB_PROPERTIES_set_Reflections(pointer, reflections);
	}

	/**
	 * [r/w] 0.0   , 0.3   , 0.007  , initial reflection delay time                                                 (SUPPORTED:EAX/I3DL2/SFX)
	 */
	public float getReflectionsDelay() {
		if(pointer == 0) throw new NullPointerException();
		float javaResult = StructureJNI.FMOD_REVERB_PROPERTIES_get_ReflectionsDelay(pointer);
		return javaResult;
	}
	/**
	 * [r/w] 0.0   , 0.3   , 0.007  , initial reflection delay time                                                 (SUPPORTED:EAX/I3DL2/SFX)
	 */
	public void setReflectionsDelay(float reflectionsDelay) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_REVERB_PROPERTIES_set_ReflectionsDelay(pointer, reflectionsDelay);
	}

	/**
	 * [r/w]       ,       , [0,0,0], early reflections panning vector                                              (SUPPORTED:EAX)
	 */
	public FloatBuffer getReflectionsPan() {
		if(pointer == 0) throw new NullPointerException();
		ByteBuffer javaResult = StructureJNI.FMOD_REVERB_PROPERTIES_get_ReflectionsPan(pointer);
		if(javaResult == null) { return null; }
		javaResult.order(ByteOrder.nativeOrder());
		return javaResult.asFloatBuffer();
	}
	/**
	 * [r/w]       ,       , [0,0,0], early reflections panning vector                                              (SUPPORTED:EAX)
	 */
	public void setReflectionsPan(FloatBuffer reflectionsPan) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_REVERB_PROPERTIES_set_ReflectionsPan(pointer, reflectionsPan, BufferUtils.getPositionInBytes(reflectionsPan));
	}

	/**
	 * [r/w] -10000, 2000  , 200    , late reverberation level relative to room effect                              (SUPPORTED:EAX/I3DL2/SFX)
	 */
	public int getReverb() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_REVERB_PROPERTIES_get_Reverb(pointer);
		return javaResult;
	}
	/**
	 * [r/w] -10000, 2000  , 200    , late reverberation level relative to room effect                              (SUPPORTED:EAX/I3DL2/SFX)
	 */
	public void setReverb(int reverb) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_REVERB_PROPERTIES_set_Reverb(pointer, reverb);
	}

	/**
	 * [r/w] 0.0   , 0.1   , 0.011  , late reverberation delay time relative to initial reflection                  (SUPPORTED:EAX/I3DL2/SFX)
	 */
	public float getReverbDelay() {
		if(pointer == 0) throw new NullPointerException();
		float javaResult = StructureJNI.FMOD_REVERB_PROPERTIES_get_ReverbDelay(pointer);
		return javaResult;
	}
	/**
	 * [r/w] 0.0   , 0.1   , 0.011  , late reverberation delay time relative to initial reflection                  (SUPPORTED:EAX/I3DL2/SFX)
	 */
	public void setReverbDelay(float reverbDelay) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_REVERB_PROPERTIES_set_ReverbDelay(pointer, reverbDelay);
	}

	/**
	 * [r/w]       ,       , [0,0,0], late reverberation panning vector                                             (SUPPORTED:EAX)
	 */
	public FloatBuffer getReverbPan() {
		if(pointer == 0) throw new NullPointerException();
		ByteBuffer javaResult = StructureJNI.FMOD_REVERB_PROPERTIES_get_ReverbPan(pointer);
		if(javaResult == null) { return null; }
		javaResult.order(ByteOrder.nativeOrder());
		return javaResult.asFloatBuffer();
	}
	/**
	 * [r/w]       ,       , [0,0,0], late reverberation panning vector                                             (SUPPORTED:EAX)
	 */
	public void setReverbPan(FloatBuffer reverbPan) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_REVERB_PROPERTIES_set_ReverbPan(pointer, reverbPan, BufferUtils.getPositionInBytes(reverbPan));
	}

	/**
	 * [r/w] .075  , 0.25  , 0.25   , echo time                                                                     (SUPPORTED:EAX/PS2(FMOD_PRESET_PS2_ECHO/FMOD_PRESET_PS2_DELAY only)
	 */
	public float getEchoTime() {
		if(pointer == 0) throw new NullPointerException();
		float javaResult = StructureJNI.FMOD_REVERB_PROPERTIES_get_EchoTime(pointer);
		return javaResult;
	}
	/**
	 * [r/w] .075  , 0.25  , 0.25   , echo time                                                                     (SUPPORTED:EAX/PS2(FMOD_PRESET_PS2_ECHO/FMOD_PRESET_PS2_DELAY only)
	 */
	public void setEchoTime(float echoTime) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_REVERB_PROPERTIES_set_EchoTime(pointer, echoTime);
	}

	/**
	 * [r/w] 0.0   , 1.0   , 0.0    , echo depth                                                                    (SUPPORTED:EAX/PS2(FMOD_PRESET_PS2_ECHO only)
	 */
	public float getEchoDepth() {
		if(pointer == 0) throw new NullPointerException();
		float javaResult = StructureJNI.FMOD_REVERB_PROPERTIES_get_EchoDepth(pointer);
		return javaResult;
	}
	/**
	 * [r/w] 0.0   , 1.0   , 0.0    , echo depth                                                                    (SUPPORTED:EAX/PS2(FMOD_PRESET_PS2_ECHO only)
	 */
	public void setEchoDepth(float echoDepth) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_REVERB_PROPERTIES_set_EchoDepth(pointer, echoDepth);
	}

	/**
	 * [r/w] 0.04  , 4.0   , 0.25   , modulation time                                                               (SUPPORTED:EAX)
	 */
	public float getModulationTime() {
		if(pointer == 0) throw new NullPointerException();
		float javaResult = StructureJNI.FMOD_REVERB_PROPERTIES_get_ModulationTime(pointer);
		return javaResult;
	}
	/**
	 * [r/w] 0.04  , 4.0   , 0.25   , modulation time                                                               (SUPPORTED:EAX)
	 */
	public void setModulationTime(float modulationTime) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_REVERB_PROPERTIES_set_ModulationTime(pointer, modulationTime);
	}

	/**
	 * [r/w] 0.0   , 1.0   , 0.0    , modulation depth                                                              (SUPPORTED:EAX)
	 */
	public float getModulationDepth() {
		if(pointer == 0) throw new NullPointerException();
		float javaResult = StructureJNI.FMOD_REVERB_PROPERTIES_get_ModulationDepth(pointer);
		return javaResult;
	}
	/**
	 * [r/w] 0.0   , 1.0   , 0.0    , modulation depth                                                              (SUPPORTED:EAX)
	 */
	public void setModulationDepth(float modulationDepth) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_REVERB_PROPERTIES_set_ModulationDepth(pointer, modulationDepth);
	}

	/**
	 * [r/w] -100  , 0.0   , -5.0   , change in level per meter at high frequencies                                 (SUPPORTED:EAX)
	 */
	public float getAirAbsorptionHF() {
		if(pointer == 0) throw new NullPointerException();
		float javaResult = StructureJNI.FMOD_REVERB_PROPERTIES_get_AirAbsorptionHF(pointer);
		return javaResult;
	}
	/**
	 * [r/w] -100  , 0.0   , -5.0   , change in level per meter at high frequencies                                 (SUPPORTED:EAX)
	 */
	public void setAirAbsorptionHF(float airAbsorptionHF) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_REVERB_PROPERTIES_set_AirAbsorptionHF(pointer, airAbsorptionHF);
	}

	/**
	 * [r/w] 1000.0, 20000 , 5000.0 , reference high frequency (hz)                                                 (SUPPORTED:EAX/I3DL2/SFX)
	 */
	public float getHFReference() {
		if(pointer == 0) throw new NullPointerException();
		float javaResult = StructureJNI.FMOD_REVERB_PROPERTIES_get_HFReference(pointer);
		return javaResult;
	}
	/**
	 * [r/w] 1000.0, 20000 , 5000.0 , reference high frequency (hz)                                                 (SUPPORTED:EAX/I3DL2/SFX)
	 */
	public void setHFReference(float HFReference) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_REVERB_PROPERTIES_set_HFReference(pointer, HFReference);
	}

	/**
	 * [r/w] 20.0  , 1000.0, 250.0  , reference low frequency (hz)                                                  (SUPPORTED:EAX/SFX)
	 */
	public float getLFReference() {
		if(pointer == 0) throw new NullPointerException();
		float javaResult = StructureJNI.FMOD_REVERB_PROPERTIES_get_LFReference(pointer);
		return javaResult;
	}
	/**
	 * [r/w] 20.0  , 1000.0, 250.0  , reference low frequency (hz)                                                  (SUPPORTED:EAX/SFX)
	 */
	public void setLFReference(float LFReference) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_REVERB_PROPERTIES_set_LFReference(pointer, LFReference);
	}

	/**
	 * [r/w] 0.0   , 10.0  , 0.0    , like rolloffscale in System::set3DSettings but for reverb room size effect    (SUPPORTED:EAX/I3DL2)
	 */
	public float getRoomRolloffFactor() {
		if(pointer == 0) throw new NullPointerException();
		float javaResult = StructureJNI.FMOD_REVERB_PROPERTIES_get_RoomRolloffFactor(pointer);
		return javaResult;
	}
	/**
	 * [r/w] 0.0   , 10.0  , 0.0    , like rolloffscale in System::set3DSettings but for reverb room size effect    (SUPPORTED:EAX/I3DL2)
	 */
	public void setRoomRolloffFactor(float roomRolloffFactor) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_REVERB_PROPERTIES_set_RoomRolloffFactor(pointer, roomRolloffFactor);
	}

	/**
	 * [r/w] 0.0   , 100.0 , 100.0  , Value that controls the echo density in the late reverberation decay.         (SUPPORTED:I3DL2/SFX)
	 */
	public float getDiffusion() {
		if(pointer == 0) throw new NullPointerException();
		float javaResult = StructureJNI.FMOD_REVERB_PROPERTIES_get_Diffusion(pointer);
		return javaResult;
	}
	/**
	 * [r/w] 0.0   , 100.0 , 100.0  , Value that controls the echo density in the late reverberation decay.         (SUPPORTED:I3DL2/SFX)
	 */
	public void setDiffusion(float diffusion) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_REVERB_PROPERTIES_set_Diffusion(pointer, diffusion);
	}

	/**
	 * [r/w] 0.0   , 100.0 , 100.0  , Value that controls the modal density in the late reverberation decay         (SUPPORTED:I3DL2/SFX)
	 */
	public float getDensity() {
		if(pointer == 0) throw new NullPointerException();
		float javaResult = StructureJNI.FMOD_REVERB_PROPERTIES_get_Density(pointer);
		return javaResult;
	}
	/**
	 * [r/w] 0.0   , 100.0 , 100.0  , Value that controls the modal density in the late reverberation decay         (SUPPORTED:I3DL2/SFX)
	 */
	public void setDensity(float density) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_REVERB_PROPERTIES_set_Density(pointer, density);
	}

	/**
	 * [r/w] FMOD_REVERB_FLAGS - modifies the behavior of above properties                                          (SUPPORTED:EAX/PS2/WII)
	 */
	public int getFlags() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.FMOD_REVERB_PROPERTIES_get_Flags(pointer);
		return javaResult;
	}
	/**
	 * [r/w] FMOD_REVERB_FLAGS - modifies the behavior of above properties                                          (SUPPORTED:EAX/PS2/WII)
	 */
	public void setFlags(int flags) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.FMOD_REVERB_PROPERTIES_set_Flags(pointer, flags);
	}

}
