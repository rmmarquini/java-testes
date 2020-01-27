package br.com.infive.temp;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class PdfToByte {

	public static byte[] readFully(InputStream stream) throws IOException {
		byte[] buffer = new byte[8192];
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		int bytesRead;
		while ((bytesRead = stream.read(buffer)) != -1) {
			baos.write(buffer, 0, bytesRead);
		}
		return baos.toByteArray();
	}

	public static byte[] loadFile(File sourcePath) throws IOException {
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(sourcePath);
			return readFully(inputStream);
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
		}
	}

	public static void readByteArray(byte[] byteArray, int byteArrayLen) throws IOException {
		ByteArrayInputStream bais = new ByteArrayInputStream(byteArray);

		for (int i = 0; i < byteArrayLen; i++) {
			int c;
			while ((c = bais.read()) != -1) {
				if (i == 0) {
					System.out.print((char) c);
				} else {
					System.out.print(Character.toUpperCase((char) c));
				}
			}
			System.out.println();

		}
	}

	public static void main(String[] args) throws IOException {
		byte[] byteArray = loadFile(new File("C:\\Users\\rafam\\Downloads\\neogrid.pdf"));
		System.out.println(byteArray);
		System.out.println(byteArray.length);
		readByteArray(byteArray, byteArray.length);
	}

}
