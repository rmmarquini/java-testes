package br.com.infive.temp;

public class ConvertStringDate {
	public static void main(String[] args) {
		String inDate = "2019-09-11 01:00:00.000";
		System.out.println(inDate.substring(8, 10) + "/" + inDate.substring(5, 7) + "/" + inDate.substring(0, 4));
	}
}
