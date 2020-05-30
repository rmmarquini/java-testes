package br.unicamp.ic.inf300;

import br.unicamp.ic.inf300.sort.BubbleSort;

public class VectorSorter {
	
	private int[] vector;
	private static String[] parameters;

	public static void main(String[] args) {
	
		parameters = args;
		int[] numbers = parseParameters();
	
		VectorSorter sorter = new VectorSorter(numbers);
		System.out.print("Input: ");
		sorter.print();
		sorter.sort();
		System.out.print("Sorted: ");
		sorter.print();
	}
	
	public VectorSorter(int size) {
		vector = generateRandomVector(size);
	}
	
	public VectorSorter(int[] numbers) {
		vector = numbers;
	}
	
	public void sort() {
		BubbleSort s = new BubbleSort();
		s.sort(vector);
	}
	
	public static int[] parseParameters() {
		int[] numbers;
		if(parameters.length > 0) {
			numbers = new int[parameters.length];
			for(int k=0; k<parameters.length; k++) {
				numbers[k] = Integer.parseInt(parameters[k]);
			}
		}else {
			numbers = generateRandomVector(10);
		}
		return numbers;
	}
	
	private static int[] generateRandomVector(int size) {

		int[] vector = new int[size];

		for (int i = 1; i < vector.length ; i++) {
			vector[i] = (int) (Math.random()*100 + 1);
		}
		
		return vector;
	}
	
	public void print() {
		System.out.print("[ ");
		System.out.print(vector[0]);
		
		int i = 1;
		do {
			i++;
			System.out.print(", ");
			System.out.print(vector[i]);
		}while(i < vector.length - 1);

		System.out.println(" ]");
	}
}
