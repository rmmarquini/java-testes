package br.unicamp.ic.inf318.labs;

import br.unicamp.ic.inf318.labs.TiposConta;

public class CadastroContas {
	// ATRIBUTOS
	  private ContaCor c[];  // VETOR DE CONTAS
	  private TiposConta tipoConta;
	  
	// OPERACOES
	  public CadastroContas () {  // METODO CONSTRUTOR 
	    c=new ContaCor[5];// O INDICE ZERO NAO EH UTILIZADO
	    
	    c[1]=new ContaCor("Juliana",500,1,1,tipoConta.PacotePremium());
	    System.out.println("Conta de Juliana criada com id 1 senha 1 e 500,00");
	    
	    c[2]=new ContaCor("Maria",500,2,2,tipoConta.PacoteBasico());
	    System.out.println("Conta de Maria criada com id 2 senha 2 e 500,00");
	    
	    c[3]=new ContaCor("Nestor",500,3,3,tipoConta.CobrancaPorOperacao());
	    System.out.println("Conta de Nestor criada com id 3 senha 3 e 500,00");
	    
	  }
	  
	  public ContaCor buscarConta (int num) {
	    if (num < 1 || num > 3)  // APENAS OS NUMEROS 1, 2 E 3 SAO ACEITOS
	      return(null);
	    else
	      return(c[num]);
	  }

}