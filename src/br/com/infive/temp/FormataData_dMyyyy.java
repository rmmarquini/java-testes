package br.com.infive.temp;
import java.util.Calendar;

public class FormataData_dMyyyy {
	
	public static void main(String[] args) {
		
		Calendar calendar = Calendar.getInstance();
		int ano = calendar.get(Calendar.YEAR);
		int mes = calendar.get(Calendar.MONTH);
		int dia = calendar.get(Calendar.DAY_OF_MONTH);
		
		System.out.println( (String.valueOf(dia).startsWith("0")) ? String.valueOf(dia).replace("0", "") : dia + "/" + String.valueOf((mes+1)) + "/" + String.valueOf(ano) );
		
	}

}
