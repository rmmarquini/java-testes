package br.com.infive.temp;
import java.io.*;

public class GetCanonicalPath {

	public static void main(String[] args) {

		try {

			File f = new File("E:\\Downloads\\..\\Movies\\");

			String canonical = f.getCanonicalPath();

			System.out.println("Original file path: " + f.getPath());
			System.out.println("Canonical file path: " + canonical);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
