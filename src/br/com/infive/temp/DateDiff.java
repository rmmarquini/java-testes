package br.com.infive.temp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDiff {
	
	public static void main(String[] args) throws ParseException {
		
		long diff = 0;
		String inDtAdmissao = "2019-09-08";
		
		try {
			// CRIA OS FORMATOS DE DATA
			DateFormat sdf1 = new SimpleDateFormat("yyyyMMdd 00:00:00");
			DateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
			
			// COLETA O DIA DE HJ E O CONVERTE EM STRING NO FORMATO sdf1
			Date   today 	= new Date();
			String strToday = sdf1.format(today);
			
			// COLETA A DATA QUE DESEJA COMPARAR, A CONVERTE COMO DATA VALIDA NO FORMATO sdf2
			// E ENTAO, CONVERTE PARA O FORMATO sdf1
			Date   dtAdmissao     = sdf2.parse(inDtAdmissao);
			String strDtAdmissao  = sdf1.format(dtAdmissao);
			
			// CONVERTE AMBAS DE STRING PARA DATE
			Date dtToday     = sdf1.parse(strToday);
			Date nDtAdmissao = sdf1.parse(strDtAdmissao);
			
			
			// CALCULA A DIFERENCA EM MILISEGUNDOS PELO METODO getTime()
			diff = dtToday.getTime() - nDtAdmissao.getTime();
			
			// CALCULA A DIFERENCA EM DIAS BASEADO NOS MILISEGUNDOS
			long diffDays = diff / (24 * 60 * 60 * 1000);
			
			System.out.println("DIFERENCA DE DIAS: " + diffDays);

			
		} catch (ParseException e) {
			System.out.println("ERRO AO COMPARAR DIFERENCA ENTRE DATAS");
			throw e;
		}
		
	}

}
