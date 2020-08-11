package br.com.infive.temp;

public class GettingLastElemOfString {
	
	private final static String className = GettingLastElemOfString.class.getCanonicalName();
	
	public static void main(String[] args) {
		System.out.println(className);
		System.out.println(className.substring(className.lastIndexOf(".") + 1).trim());
	}
	
}
