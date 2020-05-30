package br.unicamp.ic.inf318.labs;

public class Principal {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// INSTANCIA O CAIXA AUTOMATICO COM A SENHA DO CAIXA
		TrmCxAut meuTrmCxAut = new TrmCxAut(123);
		
		// UTILIZACAO DO TERMINAL DO CAIXA
		meuTrmCxAut.iniciarOperacao();

	}

}