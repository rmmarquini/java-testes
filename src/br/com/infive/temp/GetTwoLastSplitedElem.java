package br.com.infive.temp;

public class GetTwoLastSplitedElem {
	
	public static void main(String[] args) {
		
		String s = "/opt/lecom/workflow/tomcat6_aceite/webapps/workflow/relatorio/";
		String[] sp = s.split("\\/");
		String webdir = "";
		for (int i=0; i<sp.length; i++) {
			if (i==sp.length-2 || i==sp.length-1) {
				webdir += "/"+sp[i];
			}
		}
		System.out.println(webdir);
	}

}
