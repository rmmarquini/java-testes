package br.com.infive.temp;

public class WorkWithSubstring {
	
	public static void main(String[] args) {
		String phone = "(19) 3807-4213";
		System.out.println(phone.length());
		System.out.println("DDD: " + phone.substring(1, 3) + " TELEFONE: " + phone.substring(5).replace("-", ""));
	}

}
