/*===============================================================================================
 CODEC_RAW.DLL
 Copyright (c), Firelight Technologies Pty, Ltd 2005.
===============================================================================================*/

package org.jouvieje.fmodex.examples;

import static org.jouvieje.fmodex.defines.FMOD_TIMEUNIT.FMOD_TIMEUNIT_PCMBYTES;
import static org.jouvieje.fmodex.enumerations.FMOD_RESULT.FMOD_OK;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import org.jouvieje.fmodex.callbacks.FMOD_CODEC_CLOSECALLBACK;
import org.jouvieje.fmodex.callbacks.FMOD_CODEC_OPENCALLBACK;
import org.jouvieje.fmodex.callbacks.FMOD_CODEC_READCALLBACK;
import org.jouvieje.fmodex.callbacks.FMOD_CODEC_SETPOSITIONCALLBACK;
import org.jouvieje.fmodex.enumerations.FMOD_RESULT;
import org.jouvieje.fmodex.enumerations.FMOD_SOUND_FORMAT;
import org.jouvieje.fmodex.structures.FMOD_CODEC_DESCRIPTION;
import org.jouvieje.fmodex.structures.FMOD_CODEC_STATE;
import org.jouvieje.fmodex.structures.FMOD_CODEC_WAVEFORMAT;
import org.jouvieje.fmodex.structures.FMOD_CREATESOUNDEXINFO;

/**
 * Based on FMOD Ex C++ example. Ported to Java with NativeFmodEx by Jérôme JOUVIE (Jouvieje.
 * 
 * @author Jérôme JOUVIE (Jouvieje)
 * @site   http://jerome.jouvie.free.fr/
 * @mail   jerome.jouvie@gmail.com
 */
public class CodecRaw {
	private static FMOD_CODEC_DESCRIPTION rawcodec = null;

	public static FMOD_CODEC_DESCRIPTION FMODGetCodecDescription() {
		if(rawcodec == null) {
			rawcodec = FMOD_CODEC_DESCRIPTION.allocate();
			rawcodec.setName("FMOD Raw player plugin example"); //Name
			rawcodec.setVersion(0x00010000); //Version 0xAAAABBBB A = major, B = minor.
			rawcodec.setDefaultAsStream(0); //Don't force everything using this codec to be a stream
			rawcodec.setTimeUnits(FMOD_TIMEUNIT_PCMBYTES); //The time format we would like to accept into setposition/getposition.
			rawcodec.setOpen(rawopen); //Open callback.
			rawcodec.setClose(rawclose); //Close callback.	
			rawcodec.setRead(rawread); //Read callback.
			rawcodec.setGetLength(null); //Getlength callback. (If not specified FMOD return the length in FMOD_TIMEUNIT_PCM, FMOD_TIMEUNIT_MS or FMOD_TIMEUNIT_PCMBYTE units based on the lengthpcm member of the FMOD_CODEC structure).
			rawcodec.setSetPosition(rawsetposition); //Setposition callback.	
			rawcodec.setGetPosition(null); //Getposition callback. (only used for timeunit types that are not FMOD_TIMEUNIT_PCM, FMOD_TIMEUNIT_MS and FMOD_TIMEUNIT_PCMBYTES).
			rawcodec.setSoundCreate(null); //Sound create callback (don't need it)
		}
		return rawcodec;
	}

	static FMOD_CODEC_WAVEFORMAT rawwaveformat;

	/*
	 * The actual codec code. Note that the callbacks uses FMOD's supplied file system callbacks.
	 * This is important as even though you might want to open the file yourself, you would lose the
	 * following benefits. 1. Automatic support of memory files, CDDA based files, and HTTP/TCPIP
	 * based files. 2. "fileoffset" / "length" support when user calls System::createSound with
	 * FMOD_CREATESOUNDEXINFO structure. 3. Buffered file access. FMOD files are high level
	 * abstracts that support all sorts of 'file', they are not just disk file handles. If you want
	 * FMOD to use your own filesystem (and potentially lose the above benefits) use
	 * System::setFileSystem.
	 */
	private static FMOD_CODEC_OPENCALLBACK rawopen = new FMOD_CODEC_OPENCALLBACK(){
		public FMOD_RESULT FMOD_CODEC_OPENCALLBACK(FMOD_CODEC_STATE codec, int usermode,
				FMOD_CREATESOUNDEXINFO userexinfo) {
			rawwaveformat = FMOD_CODEC_WAVEFORMAT.allocate();
			rawwaveformat.setChannels(2);
			rawwaveformat.setFormat(FMOD_SOUND_FORMAT.FMOD_SOUND_FORMAT_PCM16);
			rawwaveformat.setFrequency(44100);
			rawwaveformat.setBlockAlign(rawwaveformat.getChannels() * 2); /* 2 = 16bit pcm */
			rawwaveformat.setLengthPCM(codec.getFileSize() / rawwaveformat.getBlockAlign()); /* bytes converted to PCM samples */

			codec.setNumSubsounds(0); /* number of 'subsounds' in this sound. For most codecs this is 0, only multi sound codecs such as FSB or CDDA have subsounds. */
			codec.setWaveFormat(rawwaveformat);
			codec.setPluginData(null); /* user data value */

			return FMOD_OK;
		}

	};

	private static FMOD_CODEC_CLOSECALLBACK rawclose = new FMOD_CODEC_CLOSECALLBACK(){
		public FMOD_RESULT FMOD_CODEC_CLOSECALLBACK(FMOD_CODEC_STATE codec_state) {
			return FMOD_OK;
		}
	};

	private static FMOD_CODEC_READCALLBACK rawread = new FMOD_CODEC_READCALLBACK(){
		public FMOD_RESULT FMOD_CODEC_READCALLBACK(FMOD_CODEC_STATE codec, ByteBuffer buffer, int sizebytes,
				IntBuffer bytesread) {
			return codec.invokeFileRead(codec.getFileHandle(), buffer, sizebytes, bytesread, null);
		}
	};

	private static FMOD_CODEC_SETPOSITIONCALLBACK rawsetposition = new FMOD_CODEC_SETPOSITIONCALLBACK(){
		public FMOD_RESULT FMOD_CODEC_SETPOSITIONCALLBACK(FMOD_CODEC_STATE codec, int subsound, int position,
				int postype) {
			return codec.invokeFileSeek(codec.getFileHandle(), position, null);
		}
	};
}