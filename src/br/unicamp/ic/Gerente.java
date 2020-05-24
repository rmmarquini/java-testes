package br.unicamp.ic;

public class Gerente extends Funcionario {
	
	public Gerente() {
		this.Nome += " Tanenbaum";
	}
	
	public static void main(String[] args) {
		Gerente x = new Gerente();
		System.out.println(x.Nome);
	}
	
}
