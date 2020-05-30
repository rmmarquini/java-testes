package br.unicamp.ic.inf318.labs;

public class ContaCor {

	public static int ATIVA = 1;
	public static int ENCERRADA = 2;
	public static int QTDMAXLANC = 10;

	private int estado;  		  // ATIVA OU ENCERRADA
	private String titular; 	  // NOME DO TITULAR
	private int numConta;		  // NUMERO DA CONTA
	private int senha;			  // SENHA
	private float saldoAnterior;  // SALDO ANTERIOR
	private String historico[];   // HISTORICOS E
	private float valorLanc[];	  // VALORES DOS ULTIMOS LANCAMENTOS > 0 P/ CREDITOS; < 0 P/ DEBITOS. NESSA VERSAO DO CODIGO, A OPCAO DE CREDITO NAO FOI IMPLEMENTADA
	private int ultLanc;		  // TOPO DOS VETORES ACIMA
	private float saldoAtual;     // SALDO ATUAL DA CONTA
	
	private TiposConta tipoConta; // TIPO DA CONTA

	public ContaCor(String titular, float saldoAtual, int numConta, int senha, TiposConta tipoConta) {
		this.estado = ContaCor.ATIVA; 		// A CONTA SE TORNA ATIVA, PPODENDO RECEBER LANCAMENTOS.
		this.titular = titular;
		this.saldoAtual = saldoAtual;
		this.numConta = numConta;
		this.senha = senha;
		this.ultLanc = 0; 					// A CONTA SEM NENHUM LANCAMENTO.
		this.historico = new String[ContaCor.QTDMAXLANC]; 		// CRIA VETORES ...
		this.valorLanc = new float[ContaCor.QTDMAXLANC];		// ... COM QTDMAXLANC ELEMENTOS
		this.tipoConta = tipoConta;
	}

	private boolean estaAtiva() {
		return estado == ContaCor.ATIVA;
	}

	public float obterSaldo(int senhaCliente) {
		// A CONTA DEVE ESTAR ATIVA
		if (!this.estaAtiva()){
			System.out.println("Conta inativa");
			return (-1);
		}
		// A SENHA DE ENTRADA DEVE SER IGUAL à SENHA DA CONTA
		if (senha!=senhaCliente){
			System.out.println("Senha incorreta");
			return (-1);
		}
		return (saldoAtual);		// RETORNA O SALDO ATUAL
	}

	/**
	 * ESTE METODO VERIFICA SE A CONTA ESTA ATIVA, SE A SENHA EH CORRETA E SE O VALOR DO DEBITO EH ADEQUADO, ANTES DE EFETUAR O DEBITO NA CONTA CORRENTE DO CLIENTE.
	 * CASO O DEBITO SEJA EFETUADO, ISSO EH REGISTRADO EM UM HISTORICO DA CONTA DO CLIENTE.
	 * @param hist
	 * @param val O VALOR DO SAQUE DEVE SER: (I) MAIOR QUE ZERO; (II) MENOR OU IGUAL A R$200,00; (III) MULTIPLO DE 10; (IV) MENOR OU IGUAL QUE O SALDO DO CLIENTE.
	 * @param senhaCliente
	 * @return true SE O DEBITO FOR BEM SUCEDIDO E FALSE CASO CONTRARIO
	 */
	public boolean debitarValor(String hist, float val, int senhaCliente) {

		// A CONTA DEVE ESTAR ATIVA
		if (!this.estaAtiva()){
			System.out.println("Conta Inativa");
			return false;
		}

		// A SENHA DE ENTRADA DEVE SER IGUAL A SENHA DA CONTA
		if (senha != senhaCliente){
			System.out.println("Senha incorreta");
			return false;
		}

		if (val<0 || (val%10)!=0 || val>200 || val> this.obterSaldo(senha) ){
			System.out.println("Valor de saque incorreto:"+val);
			return false;
		}

		if (ultLanc == (ContaCor.QTDMAXLANC - 1) ) 	// SE ESTA NO LIMITE DE LANCAMENTOS DA LISTA
			for(int i = 0; i < (ContaCor.QTDMAXLANC - 1) ; i++) {
				// REMOVE O PRIMEIRO DA LISTA
				historico[i] = historico[i+1];
				valorLanc[i] = valorLanc[i+1];
			}
		else
			ultLanc++;

		historico[ultLanc] = hist;	// GUARDA HISTORICO ...
		valorLanc[ultLanc] = -val;	// ... E VALOR DO LANCAMENTO (COM SINAL NEGATIVO)
		saldoAnterior = this.saldoAtual;
		this.saldoAtual -= val; 			// DEBITA VALOR DO SALDO ATUAL

		if ( saldoAtual == 0 ){			// SE ZEROU O SALDO ...
			estado = ContaCor.ENCERRADA;		// ... TORNA A CONTA INATIVA
			System.out.println("Conta de "+this.titular+", numero "+this.numConta+" foi encerrada.");
		}
		return true;
	}
	
	/**
	 * CREDITA VALOR NA CONTA
	 * SALVA AS OPERACOES NO HISTORICO
	 * SE A CONTA ESTIVER INATIVA, VOLTA O ESTADO PARA ATIVA APOS O CREDITO DO VALOR
	 * @param hist
	 * @param val
	 * @return
	 */
	public boolean creditarValor(String hist, float val) {
		
		if (ultLanc == (ContaCor.QTDMAXLANC - 1) ) { 	// SE ESTA NO LIMITE DE LANCAMENTOS DA LISTA
			for(int i = 0; i < (ContaCor.QTDMAXLANC - 1) ; i++) {
				// REMOVE O PRIMEIRO DA LISTA
				historico[i] = historico[i+1];
				valorLanc[i] = valorLanc[i+1];
			}
		} else {
			ultLanc++;
		}

		historico[ultLanc] = hist;	// GUARDA HISTORICO ...
		valorLanc[ultLanc] = val;	// ... E VALOR DO LANCAMENTO
		saldoAnterior = this.saldoAtual;
		this.saldoAtual += val; 			// CREDITA VALOR NO SALDO ATUAL
		
		// NAO FIZ A VERIFICACAO DE CONTA ATIVA ANTES, POIS ELA EH INATIVA APENAS SE SALDO = 0
		// COMO IREMOS CREDITAR VALOR NA CONTA, O SALDO DEIXARA DE SER 0, PORTANTO A CONTA VOLTARA ATIVA SE ESTIVER INATIVA
		if(!this.estaAtiva()) {
			estado = ContaCor.ATIVA;
		}
		System.out.println("Transferencia efetuada com sucesso.");
		return true;
	}

}
