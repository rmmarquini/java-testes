package br.com.infive.temp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CompareDates {

	public static void main(String[] args) throws ParseException {
		String inDtAdmissao = "2019-04-22";
		
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
		
		System.out.println("DATA DE HOJE: " + strToday);
		System.out.println("NOVA DATA DE ENTREGA: " + strDtAdmissao);
		
		// CALCULA A DIFERENCA EM MILISEGUNDOS PELO METODO getTime()
		long diff = dtToday.getTime() - nDtAdmissao.getTime();
		
		System.out.println(diff + " milisegundos de diferença ");
		
		// CALCULA A DIFERENCA EM DIAS BASEADO NOS MILISEGUNDOS
		long diffDays = diff / (24 * 60 * 60 * 1000);

		System.out.print(diffDays + " dias de diferença ");
	}
	
}
