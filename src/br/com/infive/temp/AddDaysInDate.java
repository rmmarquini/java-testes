package br.com.infive.temp;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AddDaysInDate {
	
	// FORMATO PARA CONVERSAO String PARA Date
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	// FORMATA PARA CONVERSAO Date PARA String
	private static DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	// INSTANCIA A LIB Calendar DO JAVA
	private static Calendar cal = Calendar.getInstance();
	// INSTANCIA O Writer PARA LIDAR COM EXCEPTIONS
	private static Writer writer = new StringWriter();
	
	public static void main(String[] args) throws ParseException {
		
		// DADOS DE ENTRADA
		String strInputDate = "2020-01-15";
		int addDays = 366;
		System.out.println(strInputDate);
		
		// FAZ A ADICAO DA DATA
		try {
			String strOutputDate = addDaysInDate(strInputDate, addDays);
			System.out.println(strOutputDate);
		} catch (ParseException e) {
			e.printStackTrace(new PrintWriter(writer));
			System.out.println(writer.toString());
		}
		
	}
	
	private static String addDaysInDate(String strInputDate, int addDays) throws ParseException {
		
		// CONVERTE A String DE ENTRADA PARA Date
		Date inputDate = sdf.parse(strInputDate);
		System.out.println(inputDate);
		
		// DEFINE A DATA DE ENTRADA NO FORMATO CALENDAR
		// PARA UTILIZAR OS METODOS COM OPERACOES DA LIB
		cal.setTime(inputDate);
		cal.add(Calendar.DATE, addDays);
		
		// CONVERTE O RESULTADO OBTIDO PARA DATE
		Date outputDate = cal.getTime();
		System.out.println(outputDate);
		
		// CONVERTE O Date DE SAIDA PARA String
		String strOutputDate = df.format(outputDate);
		
		return strOutputDate;
		
	}

}
