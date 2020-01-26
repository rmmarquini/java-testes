package br.com.infive.temp;

public class RetornaNomeClasse {
	
	public static void main(String[] args) {
		System.out.println(RetornaNomeClasse.class.getCanonicalName().substring(RetornaNomeClasse.class.getCanonicalName().lastIndexOf(".") + 1).trim());
	}

}
