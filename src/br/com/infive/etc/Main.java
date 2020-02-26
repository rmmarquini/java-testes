package br.com.infive.etc;

import java.util.Random;

public class Main {

	//Intellij IDEA 14 License Key
	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		KeyGenerator keyGenerator = new KeyGenerator();
		String name = "Gurkan CAKIR";
		
		Random r = new Random();
		System.out.println(KeyGenerator.MakeKey(name, 0, r.nextInt(100000)));
	}
}