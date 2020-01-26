package br.com.infive.temp;

public class StringCapitalizeFully {

	public static void main(String[] args) {
		
		String name    = "RAFAEL MARDEGAN MARQUNI";
		String newName = "";
		
		String[] spltName = name.split(" ");
		
		for (String part : spltName) {
			String aux = part.toLowerCase();
			aux = Character.toString(aux.charAt(0)).toUpperCase() + aux.substring(1);
			newName += aux + " ";
		}
		
		System.out.println(newName.trim());
		
	}
	
}
