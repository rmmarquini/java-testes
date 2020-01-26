package br.com.infive.temp;

public class PA {
	
	private static Integer cnst;
	
	public static void main(String[] args) {
		// SETA A CONSTANTE
		setCnst(7);
		// ISSO EH OQ EU RECEBO DO PARALELISMO E SEMPRE SERA MULTIPLO DE 7
		// POIS POSSUO 7 ETAPAS EM PARALELO NO MEU WORKFLOW
		int codCiclo = 21; 
		// QUERO DETERMINAR QTOS CICLOS, PORTANTO, RODARAM NAS ETAPAS PARALELAS
		// JA Q A CONCENTRADORA ME RETORNA O VALOR MULTIPLO DE 7
		int codCicloAnt = 1; 
		// AUXILIAR QUE VAI RODAR DURANTE A P.A.
		int aux = 7; 
		
		do {
			aux += getCnst();
			codCicloAnt++;
		} while (aux != codCiclo);
		
		System.out.println("codCicloAnt: " + codCicloAnt);
	}

	public static Integer getCnst() {
		return cnst;
	}

	public static void setCnst(Integer cnst) {
		PA.cnst = cnst;
	}

}
