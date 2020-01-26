package br.com.infive.temp;

public class RegexTest {

	public static void main(String[] args) {
		
		String s = "";
		
		boolean match = false;
		
		if (s.matches("\\w.*")) match = true;
		
		System.out.println(match);
		
	}

}
