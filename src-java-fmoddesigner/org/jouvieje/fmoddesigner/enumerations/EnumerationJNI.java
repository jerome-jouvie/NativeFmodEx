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

package org.jouvieje.fmoddesigner.enumerations;

import org.jouvieje.fmoddesigner.*;
import org.jouvieje.fmodex.exceptions.*;
import org.jouvieje.fmoddesigner.callbacks.*;
import org.jouvieje.fmoddesigner.*;
import org.jouvieje.fmoddesigner.defines.*;
import org.jouvieje.fmoddesigner.enumerations.*;
import org.jouvieje.fmoddesigner.structures.*;
import java.nio.*;
import org.jouvieje.fmodex.*;
import org.jouvieje.fmodex.System;
import org.jouvieje.fmodex.enumerations.*;
import org.jouvieje.fmodex.structures.*;
import org.jouvieje.fmodex.utils.*;

class EnumerationJNI {
	static {
		if(!InitFmodDesigner.isLibrariesLoaded()) {
			throw new RuntimeException("Libraries not loaded ! Use InitFmodDesigner.loadLibraries() before using NativeFmodDesigner.");
		}
	}

				/* FMOD_EVENTPROPERTY_TYPE */

	protected final static native int get_FMOD_EVENTPROPERTY_TYPE_FLOAT();
	protected final static native int get_FMOD_EVENTPROPERTY_TYPE_STRING();

				/* FMOD_EVENTQUEUE_CALLBACKTYPE */

	protected final static native int get_FMOD_EVENTQUEUE_CALLBACKTYPE_PREPARE();
	protected final static native int get_FMOD_EVENTQUEUE_CALLBACKTYPE_ABOUTTOPLAY();
	protected final static native int get_FMOD_EVENTQUEUE_CALLBACKTYPE_FINISHED();
	protected final static native int get_FMOD_EVENTQUEUE_CALLBACKTYPE_EXPIRED();

				/* FMOD_EVENT_CALLBACKTYPE */

	protected final static native int get_FMOD_EVENT_CALLBACKTYPE_SYNCPOINT();
	protected final static native int get_FMOD_EVENT_CALLBACKTYPE_SOUNDDEF_START();
	protected final static native int get_FMOD_EVENT_CALLBACKTYPE_SOUNDDEF_END();
	protected final static native int get_FMOD_EVENT_CALLBACKTYPE_STOLEN();
	protected final static native int get_FMOD_EVENT_CALLBACKTYPE_EVENTFINISHED();
	protected final static native int get_FMOD_EVENT_CALLBACKTYPE_NET_MODIFIED();
	protected final static native int get_FMOD_EVENT_CALLBACKTYPE_SOUNDDEF_CREATE();
	protected final static native int get_FMOD_EVENT_CALLBACKTYPE_SOUNDDEF_RELEASE();
	protected final static native int get_FMOD_EVENT_CALLBACKTYPE_SOUNDDEF_INFO();
	protected final static native int get_FMOD_EVENT_CALLBACKTYPE_EVENTSTARTED();
	protected final static native int get_FMOD_EVENT_CALLBACKTYPE_SOUNDDEF_SELECTINDEX();
	protected final static native int get_FMOD_EVENT_CALLBACKTYPE_OCCLUSION();

				/* FMOD_EVENT_PITCHUNITS */

	protected final static native int get_FMOD_EVENT_PITCHUNITS_OCTAVES();
	protected final static native int get_FMOD_EVENT_PITCHUNITS_SEMITONES();
	protected final static native int get_FMOD_EVENT_PITCHUNITS_TONES();

				/* FMOD_EVENT_PROPERTY */

	protected final static native int get_FMOD_EVENTPROPERTY_VOLUME();
	protected final static native int get_FMOD_EVENTPROPERTY_VOLUMERANDOMIZATION();
	protected final static native int get_FMOD_EVENTPROPERTY_PITCH();
	protected final static native int get_FMOD_EVENTPROPERTY_PITCH_OCTAVES();
	protected final static native int get_FMOD_EVENTPROPERTY_PITCH_SEMITONES();
	protected final static native int get_FMOD_EVENTPROPERTY_PITCH_TONES();
	protected final static native int get_FMOD_EVENTPROPERTY_PITCHRANDOMIZATION();
	protected final static native int get_FMOD_EVENTPROPERTY_PITCHRANDOMIZATION_OCTAVES();
	protected final static native int get_FMOD_EVENTPROPERTY_PITCHRANDOMIZATION_SEMITONES();
	protected final static native int get_FMOD_EVENTPROPERTY_PITCHRANDOMIZATION_TONES();
	protected final static native int get_FMOD_EVENTPROPERTY_PRIORITY();
	protected final static native int get_FMOD_EVENTPROPERTY_MAX_PLAYBACKS();
	protected final static native int get_FMOD_EVENTPROPERTY_MAX_PLAYBACKS_BEHAVIOR();
	protected final static native int get_FMOD_EVENTPROPERTY_MODE();
	protected final static native int get_FMOD_EVENTPROPERTY_3D_IGNORE_GEOMETRY();
	protected final static native int get_FMOD_EVENTPROPERTY_3D_ROLLOFF();
	protected final static native int get_FMOD_EVENTPROPERTY_3D_MINDISTANCE();
	protected final static native int get_FMOD_EVENTPROPERTY_3D_MAXDISTANCE();
	protected final static native int get_FMOD_EVENTPROPERTY_3D_POSITION();
	protected final static native int get_FMOD_EVENTPROPERTY_3D_CONEINSIDEANGLE();
	protected final static native int get_FMOD_EVENTPROPERTY_3D_CONEOUTSIDEANGLE();
	protected final static native int get_FMOD_EVENTPROPERTY_3D_CONEOUTSIDEVOLUME();
	protected final static native int get_FMOD_EVENTPROPERTY_3D_DOPPLERSCALE();
	protected final static native int get_FMOD_EVENTPROPERTY_3D_SPEAKERSPREAD();
	protected final static native int get_FMOD_EVENTPROPERTY_3D_PANLEVEL();
	protected final static native int get_FMOD_EVENTPROPERTY_SPEAKER_L();
	protected final static native int get_FMOD_EVENTPROPERTY_SPEAKER_C();
	protected final static native int get_FMOD_EVENTPROPERTY_SPEAKER_R();
	protected final static native int get_FMOD_EVENTPROPERTY_SPEAKER_LS();
	protected final static native int get_FMOD_EVENTPROPERTY_SPEAKER_RS();
	protected final static native int get_FMOD_EVENTPROPERTY_SPEAKER_LR();
	protected final static native int get_FMOD_EVENTPROPERTY_SPEAKER_RR();
	protected final static native int get_FMOD_EVENTPROPERTY_SPEAKER_LFE();
	protected final static native int get_FMOD_EVENTPROPERTY_REVERBWETLEVEL();
	protected final static native int get_FMOD_EVENTPROPERTY_ONESHOT();
	protected final static native int get_FMOD_EVENTPROPERTY_FADEIN();
	protected final static native int get_FMOD_EVENTPROPERTY_FADEOUT();
	protected final static native int get_FMOD_EVENTPROPERTY_REVERBDRYLEVEL();
	protected final static native int get_FMOD_EVENTPROPERTY_TIMEOFFSET();
	protected final static native int get_FMOD_EVENTPROPERTY_SPAWNINTENSITY();
	protected final static native int get_FMOD_EVENTPROPERTY_SPAWNINTENSITY_RANDOMIZATION();
	protected final static native int get_FMOD_EVENTPROPERTY_WII_CONTROLLERSPEAKERS();
	protected final static native int get_FMOD_EVENTPROPERTY_3D_POSRANDOMIZATION();
	protected final static native int get_FMOD_EVENTPROPERTY_EVENTTYPE();
	protected final static native int get_FMOD_EVENTPROPERTY_STEAL_PRIORITY();
	protected final static native int get_FMOD_EVENTPROPERTY_EFFECTS_AFFECT_REVERB();
	protected final static native int get_FMOD_EVENTPROPERTY_WILL_TERMINATE();
	protected final static native int get_FMOD_EVENTPROPERTY_USER_BASE();

				/* FMOD_EVENT_RESOURCE */

	protected final static native int get_FMOD_EVENT_RESOURCE_STREAMS_AND_SAMPLES();
	protected final static native int get_FMOD_EVENT_RESOURCE_STREAMS();
	protected final static native int get_FMOD_EVENT_RESOURCE_SAMPLES();

				/* FMOD_EVENT_SOUNDDEF_ENTRYTYPE */

	protected final static native int get_FMOD_EVENT_SOUNDDEF_ENTRYTYPE_WAVETABLE();
	protected final static native int get_FMOD_EVENT_SOUNDDEF_ENTRYTYPE_OSCILLATOR();
	protected final static native int get_FMOD_EVENT_SOUNDDEF_ENTRYTYPE_NULL();
	protected final static native int get_FMOD_EVENT_SOUNDDEF_ENTRYTYPE_PROGRAMMER();

				/* FMOD_MUSIC_CALLBACKTYPE */

	protected final static native int get_FMOD_MUSIC_CALLBACKTYPE_SEGMENT_START();
	protected final static native int get_FMOD_MUSIC_CALLBACKTYPE_SEGMENT_END();
	protected final static native int get_FMOD_MUSIC_CALLBACKTYPE_SAMPLE_CREATE();
	protected final static native int get_FMOD_MUSIC_CALLBACKTYPE_SAMPLE_RELEASE();
	protected final static native int get_FMOD_MUSIC_CALLBACKTYPE_RESET();
	protected final static native int get_FMOD_MUSIC_CALLBACKTYPE_BEAT();

}
