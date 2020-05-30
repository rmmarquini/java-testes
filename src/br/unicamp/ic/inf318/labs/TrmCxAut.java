package br.unicamp.ic.inf318.labs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StreamTokenizer;

public class TrmCxAut {

	// ATRIBUTOS
	private ControladorCaixa controladorCaixa; // ASSOCIACAO ENTRE TERMINAL E ControladorCaixa

	// OPERACOES
	public TrmCxAut(int senhaCaixa) {
		controladorCaixa = new ControladorCaixa(senhaCaixa);

	}

	/**
	 * SOLICITA QUE O USUARIO DIGITE DADOS NA ENTRADA PADRAO DE ACORDO COM O SIGNIFICADO DA STRING 
	 * PASSADA COMO PARAMETRO.
	 * @param STR DEFINE O QUE E SOLICITADO PARA O USUARIO, E.G. "SENHA DO CAIXA"
	 * @return UM NUMERO (INT) QUE FOI DIGITADO PELO USARIO
	 */
	private int getInt(String str) {

		System.out.println("Entre com "+str);

		// LE OS VALORES DIGITADOS NA ENTRADA PADRAO
		Reader r = new BufferedReader(new InputStreamReader (System.in));
		StreamTokenizer st = new StreamTokenizer(r);

		try {
			st.nextToken();
		}
		catch (IOException e) {
			System.out.println("Erro na leitura do teclado");
			return(0);
		}

		return((int)st.nval);
	}




	private int getOp() {
		int op;

		int modoAtual = this.controladorCaixa.obterModoOperacaoAtual();

		do {
			if (modoAtual==Caixa.MODO_CLIENTE) {  // MODO CLIENTE 
				op=getInt
						("opcao: 1 = consulta saldo, 2 = saque, 8 = modo supervisor, 9 = sai");
				if (op!=1 && op!=2 && op!=8 && op!=9) op=0;
			}else {				// MODO SUPERVISOR 
				op=getInt
						("opcao: 3 = recarrega, 8 = modo cliente, 9 = sai");
				if (op!=3 && op!=8 && op!=9) op=0;
			}
		} while (op==0);
		return(op);
	}

	public void iniciarOperacao() {
		int op;	// CODIGO DA OPERACAO SOLICITADA 
		op=getOp();
		while (op!=9) {
			switch (op) {
			case 1:
				float saldo = controladorCaixa.consultarSaldo(getInt("numero da conta"), getInt("senha"));

				if (saldo==-1)  // TESTA SE CONSULTA FOI REJEITADA 
					System.out.println("conta/senha invalida ou conta inativa");
				else
					System.out.println("Saldo atual: "+saldo); 
				break;

			case 2:
				boolean saqueEfetuado = controladorCaixa.efetuarSaque(getInt("numero da conta"), getInt("senha"), getInt("valor"));
				if (saqueEfetuado)		// TESTA SE SAQUE FOI ACEITO 
					System.out.println("Pode retirar o dinheiro");
				else 
					System.out.println("Pedido de saque recusado");
				break;

			case 3:
				controladorCaixa.recarregar(getInt("senha")); 
				break;

			case 8:
				controladorCaixa.alternarModo(getInt("senha do caixa")); 
				break;
			}
			op=getOp();
		}
	}

}