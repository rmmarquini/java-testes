package br.unicamp.ic;

public class Tarefa2 {
	
	public static void main(String[] args) {
		
		int a = 1;
		
		Tarefa2 tarefa = new Tarefa2();
		
		System.out.println("Valor de 'a' antes de chamar o método: " + a);
		tarefa.modifica(a);
		System.out.println("Valor de 'a' depois de chamar o método: " + a);
		
	}
	
	public void modifica(int a) {
		a++;
		System.out.println("Valor de 'a': " + a);
	}

}
