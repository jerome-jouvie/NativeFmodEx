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

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import org.jouvieje.fmodex.callbacks.FMOD_FILE_ASYNCCANCELCALLBACK;
import org.jouvieje.fmodex.callbacks.FMOD_FILE_ASYNCREADCALLBACK;
import org.jouvieje.fmodex.callbacks.FMOD_FILE_CLOSECALLBACK;
import org.jouvieje.fmodex.callbacks.FMOD_FILE_OPENCALLBACK;
import org.jouvieje.fmodex.callbacks.FMOD_FILE_READCALLBACK;
import org.jouvieje.fmodex.callbacks.FMOD_FILE_SEEKCALLBACK;
import org.jouvieje.fmodex.enumerations.FMOD_RESULT;
import org.jouvieje.fmodex.utils.ObjectPointer;
import org.jouvieje.fmodex.utils.Pointer;

/**
 * Copyright © 2008-2010 Jérôme JOUVIE (Jouvieje)
 * @author    Jérôme JOUVIE (Jouvieje)
 * @email     jerome.jouvie@gmail.com
 * @website   http://jerome.jouvie.free.fr/
 */
public class JARFileSystem {
	private final String rootDirectory;

	public JARFileSystem(String fileSystemRootDirectory) {
		rootDirectory = fileSystemRootDirectory == null ? "" : fileSystemRootDirectory;
	}
	
	public final String getRootDirectory() {
		return rootDirectory;
	}
	
	public final FMOD_FILE_OPENCALLBACK jarOpen = new FMOD_FILE_OPENCALLBACK() {
		public FMOD_RESULT FMOD_FILE_OPENCALLBACK(String name, int unicode, IntBuffer filesize, Pointer handle, Pointer userdata) {
			if(name == null) {
				return FMOD_RESULT.FMOD_ERR_FILE_NOTFOUND;
			}
			
//			System.out.println("["+JARFileSystem.class.getSimpleName()+"] Open: "+name);
			ByteBuffer fillBuffer = loadMediaIntoMemory(rootDirectory + name);
			if(fillBuffer == null)  {
				return FMOD_RESULT.FMOD_ERR_FILE_NOTFOUND;
			}
			
			filesize.put(0, fillBuffer.capacity());
			handle.shareMemory(ObjectPointer.allocate(fillBuffer));
			
			return FMOD_RESULT.FMOD_OK;
		}

		private ByteBuffer loadMediaIntoMemory(String media) {
			try {
				InputStream is = JARFileSystem.this.getClass().getResourceAsStream(media);
				if(is == null) {
					if(new File(media).exists()) {
						is = new FileInputStream(new File(media));
					}
					else if(new File("."+media).exists()) {
						is = new FileInputStream(new File("."+media));
					}
					else {
						throw new FileNotFoundException(media);
					}
				}
				BufferedInputStream bis = new BufferedInputStream(is);
				ByteArrayOutputStream baos = new ByteArrayOutputStream();

				byte[] bytes = new byte[4 * 1024];
				int read;
				while((read = bis.read(bytes, 0, bytes.length)) != -1) {
					if(read > 0) {
						baos.write(bytes, 0, read);
					}
				}
				bis.close();
				baos.close();

				ByteBuffer buffer = BufferUtils.newByteBuffer(baos.size());
				buffer.put(baos.toByteArray());
				buffer.rewind();

				return buffer;
			} catch(IOException e) {
				e.printStackTrace();
				return null;
			}
		}
	};

	public final FMOD_FILE_CLOSECALLBACK jarClose = new FMOD_FILE_CLOSECALLBACK() {
		public FMOD_RESULT FMOD_FILE_CLOSECALLBACK(Pointer handle, Pointer userdata) {
			if(handle == null || handle.isNull()) {
				return FMOD_RESULT.FMOD_ERR_INVALID_PARAM;
			}
			
			ObjectPointer objectPointer = ObjectPointer.asObjectPointer(handle);
			objectPointer.release();
			
			return FMOD_RESULT.FMOD_OK;
		}
	};
	
	public final FMOD_FILE_READCALLBACK jarRead = new FMOD_FILE_READCALLBACK() {
		public FMOD_RESULT FMOD_FILE_READCALLBACK(Pointer handle, ByteBuffer buffer, int sizebytes, IntBuffer bytesread, Pointer userdata) {
			if(handle == null || handle.isNull()) {
				return FMOD_RESULT.FMOD_ERR_INVALID_PARAM;
			}
			
			ByteBuffer file = (ByteBuffer)ObjectPointer.asObjectPointer(handle).getObject();
			ByteBuffer fileChunk = file.duplicate();
			
			//Check the number of bytes to read
			int maxBytes = file.capacity() - fileChunk.position();
			int bytesToRead = (sizebytes > maxBytes) ? maxBytes : sizebytes;
			
			//Read bytesToRead bytes
			fileChunk.limit(fileChunk.position()+bytesToRead);
			if(fileChunk.remaining() != sizebytes) {
				return FMOD_RESULT.FMOD_ERR_FILE_EOF;
			}
			buffer.put(fileChunk);
			
			//Move the file pointer of the number of bytes actually read
			file.position(file.position()+bytesToRead);
			bytesread.put(0, bytesToRead);
			
			return FMOD_RESULT.FMOD_OK;
		}
	};
	
	public final FMOD_FILE_SEEKCALLBACK jarSeek = new FMOD_FILE_SEEKCALLBACK() {
		public FMOD_RESULT FMOD_FILE_SEEKCALLBACK(Pointer handle, int pos, Pointer userdata) {
			if(handle == null || handle.isNull()) {
				return FMOD_RESULT.FMOD_ERR_INVALID_PARAM;
			}
			
			ByteBuffer file = (ByteBuffer)ObjectPointer.asObjectPointer(handle).getObject();
			if(pos < 0 || pos > file.capacity()) {
				return FMOD_RESULT.FMOD_ERR_FILE_EOF;
			}
			file.position(pos);
			
			return FMOD_RESULT.FMOD_OK;
		}
	};
	
	public final FMOD_FILE_ASYNCREADCALLBACK jarAsyncRead = null;
	public final FMOD_FILE_ASYNCCANCELCALLBACK jarAsyncCancel = null;
}
