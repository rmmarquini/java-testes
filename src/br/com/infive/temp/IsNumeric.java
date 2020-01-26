package br.com.infive.temp;

public class IsNumeric {
	
	public static void main(String[] args) {
		String str = "1001123456";
		
		boolean isNum = isNumeric(str);
		
		System.out.println(isNum);
	}
	
	public static boolean isNumeric(String str) {
		return str.matches(("-?\\d+(\\.\\d+)?"));
	}

}
