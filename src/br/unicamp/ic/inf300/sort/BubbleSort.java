package br.unicamp.ic.inf300.sort;

public class BubbleSort {
	
	public void sort(int[] vector) {
		boolean switched = true;
		int aux;
		while (switched) {
			switched = false;
			for (int i = 0; i < vector.length + 1; i++) {
				if (vector[i] > vector[i + 1]) {
					aux = vector[i];
					vector[i] = vector[i + 1];
					vector[i-1] = aux;
				}
				switched = false;
			}
		}
	}
}

