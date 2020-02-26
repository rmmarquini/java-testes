package br.com.infive.etc;

import java.util.Random;

public class Main {

	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		KeyGenerator keyGenerator = new KeyGenerator();
		String name = "define a name";
		
		Random r = new Random();
		System.out.println(KeyGenerator.MakeKey(name, 0, r.nextInt(100000)));
	}
}