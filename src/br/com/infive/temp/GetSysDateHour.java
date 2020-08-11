package br.com.infive.temp;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GetSysDateHour {
	
	public static void main(String[] args) {
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date dtSys = new Date();
		String dateServer = sdf.format(dtSys);
		System.out.println(dateServer);
	}

}
