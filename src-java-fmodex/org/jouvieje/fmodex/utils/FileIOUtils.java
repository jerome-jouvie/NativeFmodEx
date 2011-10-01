/**
 * 			NativeFmodEx Project
 *
 * Want to use FMOD Ex API (www.fmod.org) in the Java language ? NativeFmodEx is made for you.
 * Copyright � 2005-2010 J�r�me JOUVIE (Jouvieje)
 *
 * Created on 23 feb. 2005
 * @version file v1.5.0
 * @author J�r�me JOUVIE (Jouvieje)
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

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;

import org.jouvieje.fmodex.utils.BufferUtils;

/** This class is an utility to read/write from a <code>RandomAccessFile</code>. */
public class FileIOUtils implements SizeOfPrimitive {
	private ByteBuffer shortBuffer = null;
	private ByteBuffer charBuffer = null;
	private ByteBuffer intBuffer = null;
	private ByteBuffer longBuffer = null;
	private ByteBuffer floatBuffer = null;
	private ByteBuffer doubleBuffer = null;

	/** Call this to free internal memory allocated */
	public void freeMemory() {
		shortBuffer = null;
		charBuffer = null;
		intBuffer = null;
		longBuffer = null;
		floatBuffer = null;
		doubleBuffer = null;
	}

	/**
	 * Read a simple <code>byte</code> into the file.
	 * @return the <code>byte</code> read from the file
	 * @throws IOException if an I/O error occures.
	 */
	public byte readByte(RandomAccessFile file) throws IOException {
		return file.readByte();
	}
	/**
	 * Read a <code>short</code> from 2 bytes of the file.
	 * @return the <code>short</code> read from the file.
	 * @throws IOException if an I/O error occures.
	 */
	public short readShort(RandomAccessFile file) throws IOException {
		final ByteBuffer buffer = getShortBuffer();
		synchronized(buffer) {
			file.getChannel().read(buffer);
			buffer.rewind();
			return buffer.getShort(0);
		}
	}
	/**
	 * Read a <code>char</code> from 2 bytes of the file.
	 * @return the <code>char</code> read from the file.
	 * @throws IOException if an I/O error occures.
	 */
	public char readChar(RandomAccessFile file) throws IOException {
		final ByteBuffer buffer = getCharBuffer();
		synchronized(buffer) {
			file.getChannel().read(buffer);
			buffer.rewind();
			return buffer.getChar(0);
		}
	}
	/**
	 * Read an <code>int</code> from 4 bytes of the file.
	 * @return the <code>int</code> read from the file.
	 * @throws IOException if an I/O error occures.
	 */
	public int readInt(RandomAccessFile file) throws IOException {
		final ByteBuffer buffer = getIntBuffer();
		synchronized(buffer) {
			file.getChannel().read(buffer);
			buffer.rewind();
			return buffer.getInt(0);
		}
	}
	/**
	 * Read a <code>float</code> from 4 bytes of the file.
	 * @return the <code>float</code> read from the file.
	 * @throws IOException if an I/O error occures.
	 */
	public float readFloat(RandomAccessFile file) throws IOException {
		final ByteBuffer buffer = getFloatBuffer();
		synchronized(buffer) {
			file.getChannel().read(buffer);
			buffer.rewind();
			return buffer.getFloat(0);
		}
	}
	/**
	 * Read a <code>long</code> from 8 bytes of the file.
	 * @return the <code>long</code> read from the file.
	 * @throws IOException if an I/O error occures.
	 */
	public long readLong(RandomAccessFile file) throws IOException {
		final ByteBuffer buffer = getLongBuffer();
		synchronized(buffer) {
			file.getChannel().read(buffer);
			buffer.rewind();
			return buffer.getLong(0);
		}
	}
	/**
	 * Read a <code>double</code> from 8 bytes of the file.
	 * @return the <code>double</code> read from the file.
	 * @throws IOException if an I/O error occures.
	 */
	public double readDouble(RandomAccessFile file) throws IOException {
		final ByteBuffer buffer = getDoubleBuffer();
		synchronized(buffer) {
			file.getChannel().read(buffer);
			buffer.rewind();
			return buffer.getDouble(0);
		}
	}

	/**
	 * Read a <code>byte[]</code> from a file.
	 * @param nbBytes number of bytes to read.
	 * @return the <code>byte[]</code> read from the file.
	 * @throws IOException if an I/O error occures.
	 */
	public byte[] readByteArray(RandomAccessFile file, int nbBytes) throws IOException {
		byte[] datas = new byte[nbBytes];
		file.read(datas, 0, datas.length);
		return datas;
	}
	/**
	 * Read a <code>byte[]</code> from a file.
	 * @param datas <code>byte[]</code> into which the data is read.
	 * @param offset offset
	 * @param nbBytes number of bytes to be read.
	 * @throws IOException if an I/O error occures.
	 */
	public void readByteArray(RandomAccessFile file, byte[] datas, int offset, int nbBytes) throws IOException {
		file.read(datas, offset, nbBytes);
	}

	/**
	 * Read a <code>ByteBuffer</code> from a file.
	 * @param nbBytes number of bytes to be read.
	 * @return the <code>ByteBuffer</code> read from the file
	 * @throws IOException if an I/O error occures.
	 */
	public ByteBuffer readByteBuffer(RandomAccessFile file, int nbBytes) throws IOException {
		final ByteBuffer datas = BufferUtils.newByteBuffer(nbBytes);
		file.getChannel().read(datas);
		return datas;
	}
	/**
	 * Read a <code>ByteBuffer</code> from a file.<BR>
	 * @param buffer <code>ByteBuffer</code> into which the data is read.
	 * @param nbBytes number of bytes to be read.
	 * @throws IOException if an I/O error occures.
	 */
	public void readByteBuffer(RandomAccessFile file, ByteBuffer buffer, int nbBytes) throws IOException {
		final ByteBuffer view = buffer.duplicate();
		view.limit(view.position()+nbBytes);
		file.getChannel().read(view);
		buffer.position(view.position());
	}


	/**
	 * Write a simple <code>byte</code> into the file.
	 * @param file a file to read in.
	 * @param value a <code>byte</code> to be written into the file.
	 * @throws IOException if an I/O exception occures.
	 */
	public void writeByte(RandomAccessFile file, byte value) throws IOException {
		file.writeByte(value);
	}
	/**
	 * Convert the <code>short<code> in 2 bytes and write them into the file.
	 * @param file a file to read in.
	 * @param value a <code>short<code> to be written into the file.
	 * @throws IOException if an I/O exception occures.
	 */
	public void writeShort(RandomAccessFile file, short value) throws IOException {
		final ByteBuffer buffer = getShortBuffer();
		synchronized(buffer) {
			buffer.putShort(0, value);
			file.getChannel().write(buffer);
			buffer.rewind();
		}
	}
	/**
	 * Convert the <code>char</code> in 2 bytes and write them into the file.
	 * @param file a file to read in.
	 * @param value a <code>char</code> to be writte into the file.
	 * @throws IOException if an I/O exception occures.
	 */
	public void writeChar(RandomAccessFile file, char value) throws IOException {
		final ByteBuffer buffer = getCharBuffer();
		synchronized(buffer) {
			buffer.putChar(0, value);
			file.getChannel().write(buffer);
			buffer.rewind();
		}
	}
	/**
	 * Convert the <code>int</code> in 4 bytes and write them into the file.
	 * @param file a file to read in.
	 * @param value an <code>int</code> to be written into the file.
	 * @throws IOException if an I/O exception occures.
	 */
	public void writeInt(RandomAccessFile file, int value) throws IOException {
		final ByteBuffer buffer = getIntBuffer();
		synchronized(buffer) {
			buffer.putInt(0, value);
			file.getChannel().write(buffer);
			buffer.rewind();
		}
	}
	/**
	 * Convert the <code>float</code> in 4 bytes and write them into the file.
	 * @param file a file to read in.
	 * @param value a <code>float</code> to be written into the file.
	 * @throws IOException if an I/O exception occures.
	 */
	public void writeFloat(RandomAccessFile file, float value) throws IOException {
		final ByteBuffer buffer = getFloatBuffer();
		synchronized(buffer) {
			buffer.putFloat(0, value);
			file.getChannel().write(buffer);
			buffer.rewind();
		}
	}
	/**
	 * Convert the <code>long</code> in 8 bytes and write them into the file.
	 * @param file a file to read in.
	 * @param value a <code>long</code> to be written into the file.
	 * @throws IOException if an I/O exception occures.
	 */
	public void writeLong(RandomAccessFile file, long value) throws IOException {
		final ByteBuffer buffer = getLongBuffer();
		synchronized(buffer) {
			buffer.putLong(0, value);
			file.getChannel().write(buffer);
			buffer.rewind();
		}
	}
	/**
	 * Convert the <code>double</code> in 8 bytes and write them into the file.
	 * @param file a file to read in.
	 * @param value a <code>double</code> to be written into the file.
	 * @throws IOException if an I/O exception occures.
	 */
	public void writeDouble(RandomAccessFile file, double value) throws IOException {
		final ByteBuffer buffer = getDoubleBuffer();
		synchronized(buffer) {
			buffer.putDouble(0, value);
			file.getChannel().write(buffer);
			buffer.rewind();
		}
	}

	/**
	 * Write an entire <code>byte[]</code> into the file.<BR>
	 * This is equivalent to the call <code>writeByteArray(file, datase, 0, datas.length)</code>
	 * @param file a file to read in.
	 * @param datas a <code>byte[]</code> to be written into the file.
	 * @throws IOException if an I/O exception occures.
	 */
	public void writeByteArray(RandomAccessFile file, byte[] datas) throws IOException {
		writeByteArray(file, datas, 0, datas.length);
	}
	/**
	 * Write a part of a <code>byte[]</code> into the file.
	 * @param file a file to read in.
	 * @param datas a <code>byte[]</code> to write into the file.
	 * @param offset offset from the start of the <code>byte[]</code>.
	 * @param length number of bytes to be written starting from the offset of the <code>byte[]</code>.
	 * @throws IOException if an I/O exception occures.
	 */
	public void writeByteArray(RandomAccessFile file, byte[] datas, int offset, int length) throws IOException {
		file.write(datas, offset, length);
	}

	/**
	 * Write an entire <code>ByteBuffer</code> into a file.<BR>
	 * @param file a file to read in.
	 * @param buffer a <code>ByteBuffer</code> to be written into the file.
	 * @throws IOException if an I/O exception occures.
	 */
	public int writeByteBuffer(RandomAccessFile file, ByteBuffer buffer) throws IOException {
		return file.getChannel().write(buffer);
	}
	/**
	 * Write a part of a <code>ByteBuffer</code> into a file.
	 * @param file a file to read in.
	 * @param buffer a <code>ByteBuffer</code> to be written into the file.
	 * @param length number of bytes to be written into the file.
	 * @throws IOException if an I/O exception occures.
	 */
	public int writeByteBuffer(RandomAccessFile file, ByteBuffer buffer, int length) throws IOException {
		final ByteBuffer view = buffer.duplicate();
		view.limit(view.position()+length);
		int written = file.getChannel().write(view);
		buffer.position(view.position());
		return written;
	}

					/*PRIVATE*/

	private ByteBuffer getShortBuffer() {
		if(shortBuffer == null) {
			shortBuffer = BufferUtils.newByteBuffer(SIZEOF_SHORT);
		}
		return shortBuffer;
	}
	private ByteBuffer getCharBuffer() {
		if(charBuffer == null) {
			charBuffer = BufferUtils.newByteBuffer(SIZEOF_CHAR);
		}
		return charBuffer;
	}
	private ByteBuffer getIntBuffer() {
		if(intBuffer == null) {
			intBuffer = BufferUtils.newByteBuffer(SIZEOF_INT);
		}
		return intBuffer;
	}
	private ByteBuffer getLongBuffer() {
		if(longBuffer == null) {
			longBuffer = BufferUtils.newByteBuffer(SIZEOF_LONG);
		}
		return longBuffer;
	}
	private ByteBuffer getFloatBuffer() {
		if(floatBuffer == null) {
			floatBuffer = BufferUtils.newByteBuffer(SIZEOF_FLOAT);
		}
		return floatBuffer;
	}
	private ByteBuffer getDoubleBuffer() {
		if(doubleBuffer == null) {
			doubleBuffer = BufferUtils.newByteBuffer(SIZEOF_DOUBLE);
		}
		return doubleBuffer;
	}
}
