package br.com.infive.temp;

public class GenerateNChar {
	
	public static void main(String[] args) {
		System.out.println(new String(new char[50]).replace("\0", "-"));
	}

}
