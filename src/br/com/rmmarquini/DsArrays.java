package br.com.rmmarquini;

public class DsArrays {
	
	/**
	 * The size of array must be known in advance before using in the program
	 * Increasing size of the array is a time taking process. It's almost impossible to expand the array' size at run time
	 * All the elements in the array need to be contiguosly stored in the memory. Inserting any element in the array needs shifiting of all predecessors.
	 */
	
	public static void main(String[] args) {
		int[][] arr2D = {{1, 2}, {3, 4}, {5, 6}, {7, 8}};
		for (int[] e : arr2D) {
			String arr = "";
			for (int i=0; i<e.length-1; i++) 
				arr = "[" + e[i] + "][";
			arr += e[e.length-1] + "]";
			System.out.println(arr);
		}
	}
}