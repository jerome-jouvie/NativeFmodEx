package org.jouvieje.fmodex.examples.utils;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

import org.jouvieje.fmodex.utils.BufferUtils;

/**
 * @author Jérôme JOUVIE (Jouvieje)
 * @site   http://jerome.jouvie.free.fr/
 * @mail   jerome.jouvie@gmail.com
 */
public final class Medias {
	private static String lastError = "";

	private Medias() {}

	public static ByteBuffer loadMediaIntoMemory(String media) {
		try {
			InputStream is = new Medias().getClass().getResourceAsStream(media);
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

			lastError = "";

			return buffer;
		}
		catch(IOException e) {
			e.printStackTrace();
			lastError = e.getMessage();
			return null;
		}
	}

	public static String getLastError() {
		return lastError;
	}
}
