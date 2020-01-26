package br.com.infive.temp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class getCurrentTime {
	
	public static void main(String[] args) {
		
		Date date = new Date();
		String hourFormat = "HH:mm:ss";
		DateFormat sdf = new SimpleDateFormat(hourFormat);
		String curHour = sdf.format(date);
		System.out.println("HORA ATUAL: " + curHour);
		System.out.println("HORA EXEC: " + Integer.parseInt("07"));
		
		if (Integer.parseInt(curHour.substring(0, 2)) == Integer.parseInt("07")) {
			System.out.println("HORA ATUAL: " + curHour.substring(0, 2));
		} else {
			System.out.println("HORARIO NAO CORRESPONDE AO ESPERADO.");
		}
		
	}

}
