package br.com.infive.temp;

public class GettingLastElemOfString {
	
	public static void main(String[] args) {
		String str = "br.com.afip.robo.VerificaFinalizar";
		System.out.println(str.substring(str.lastIndexOf(".") + 1).trim());
	}

}
