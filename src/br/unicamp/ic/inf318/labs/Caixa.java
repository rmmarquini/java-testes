package br.unicamp.ic.inf318.labs;


public class Caixa {
	// ATRIBUTOS 
	private float saldoCaixa;	// SALDO NO CAIXA, EM R$
	private int senhaCaixa;
	private int modoAtual;  // MODO DE OPERACAO ATUAL: 0=SUPERVISOR, 1=CLIENTE 

	// CONSTANTES
	public static int MODO_SUPERVISOR = 0;
	public static int MODO_CLIENTE = 1;

	// OPERACOES
	public Caixa(int senhaCaixa) {
		this.senhaCaixa = senhaCaixa;
		this.saldoCaixa = 0;
	}


	public void alternarModo(int senhaCaixa){
		if(this.validarSenha(senhaCaixa)){
			if (this.modoAtual == Caixa.MODO_SUPERVISOR)
				this.modoAtual = Caixa.MODO_CLIENTE;
			else
				this.modoAtual = Caixa.MODO_SUPERVISOR;
		}
		else
			System.out.println("Senha incorreta!");

	}

	public void liberarNotas(int qtd){
		this.saldoCaixa -= qtd*10; // NOTAS DE R$10
		while ( ( qtd-- ) > 0 )
			System.out.println("===/ R$10,00 /===>");
	}	

	public int obterModoOperacaoAtual(){
		return this.modoAtual;
	}

	public float obterSaldoCaixa(){
		return saldoCaixa;

	}


	public void recarregar(int senha){
		if(this.senhaCaixa == senha){
			this.saldoCaixa=1000;	// CAIXA RECARREGADO (R$ 1000,00)
			System.out.println("Caixa recarregado!");
		}
		else
			System.out.println("Senha incorreta!");
	}
	
	public boolean validarSenha(int senhaCx){
		if(this.senhaCaixa == senhaCx)
			return true;
		else
			return false;
	}
	
}