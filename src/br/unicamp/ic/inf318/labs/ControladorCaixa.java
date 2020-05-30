package br.unicamp.ic.inf318.labs;

import br.unicamp.ic.inf318.labs.ContaCor;


public class ControladorCaixa {
	// ATRIBUTOS
	private CadastroContas dbContas;  // BANCO DE DADOS DAS CONTAS
	private Caixa caixa;


	// OPERACOES
	public ControladorCaixa(int senhaCaixa) {
		dbContas = new CadastroContas();
		caixa = new Caixa(senhaCaixa);
	}

	
	public float consultarSaldo (int num, int senha){
		ContaCor cta;
		cta = dbContas.buscarConta(num); // OBTEM REFERENCIA PARA O OBJETO QUE REPRESENTA A CONTA 'NUM'
		if (cta==null)   // SE NUMERO DE CONTA INVALIDO ...
			return -1; // ... RETORNA -1 
		else             // CASO CONTRARIO ... 
			return cta.obterSaldo(senha); // EFETUA CONSULTA 
	} 

	/**
	 * SAQUES PERMITIDOS DEVE SER MENOR OU IGUAL QUE O SALDO DISPONIVEL NO CAIXA.
	 * @param num NUMERO DA CONTA CORRENTE
	 * @param senha SENHA DO CLIENTE 
	 * @param val VALOR QUE SERA RETIRADO DA CONTA
	 * @return true SE O NUMERO DA CONTA E A SENHA ESTIVEREM CORRETOS E SE O VALOR A SER RETIRADO ESTA DISPONIVEL
	 * E EH MENOR QUE O SALDO ATUAL. CASO CONTRARIO, RETORNA FALSE.
	 */
	public boolean efetuarSaque (int num, int senha, float val){

		ContaCor cta;

		float saldoCaixa = this.caixa.obterSaldoCaixa();

		if (saldoCaixa < val ){
			System.out.println("O caixa nao possui R$"+val+" e precisa ser recarregado.");
			return false;
		}

		cta=dbContas.buscarConta(num);  // OBTEM A REFERENCIA PARA O OBJETO QUE REPRESENTA A CONTA 'NUM'

		if (cta==null)  // SE NUMERO DE CONTA INVALIDO ...
			return false;  // ... RETORNA FALSE

		if (cta.debitarValor("Saque Automatico", val, senha)==false) // SE SAQUE RECUSADO ...
			return false;  // RETORNA FALSE
		else{
			this.caixa.liberarNotas((int)(val/10)); // LIBERA PAGAMENTO
			return true;
		}


	}
	
	/**
	 * EFETUA TRANSFERENCIA ENTRE CONTAS
	 * VERIFICA SE AS CONTAS SAO VALIDAS
	 * VERIFICA SE O SALDO PARA TRANSFERENCIA EH VALIDO
	 * 
	 * @param senhaCliente
	 * @param numContaOrigem
	 * @param numContaDestino
	 * @param val
	 * @return true SE TRANSFERENCIA EFETUADA COM SUCESSO OU FALSE SE OCORREU ALGO INVALIDO
	 */
	public boolean efetuarTransfEntreContas(int senhaCliente, int numContaOrigem, int numContaDestino, float val) {
		ContaCor ctaOrigem;
		ContaCor ctaDestino;
		
		ctaOrigem = dbContas.buscarConta(numContaOrigem);
		ctaDestino = dbContas.buscarConta(numContaDestino);
		
		if (ctaOrigem == null || ctaDestino == null) {
			System.out.println("Verifique se os numeros de contas estao corretos.");
			return false;
		} else if (val > ctaOrigem.obterSaldo(senhaCliente)) {
			System.out.println("Nao ha saldo em conta para efetuar transferencia.");
			return false;
		} else {
			ctaOrigem.debitarValor(null, val, senhaCliente);
			ctaDestino.creditarValor(null, val);
		}
		return true;
		
	}



	public void recarregar(int senha){
		this.caixa.recarregar(senha);
	}

	public boolean validarSenha(int senha){
		return this.caixa.validarSenha(senha);
	}



	public void alternarModo(int senhaCaixa){
		this.caixa.alternarModo(senhaCaixa);
	}

	public int obterModoOperacaoAtual(){
		return this.caixa.obterModoOperacaoAtual();
	}

}