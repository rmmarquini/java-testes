package br.unicamp.ic;

import java.util.ArrayList;
import java.util.List;

public class Quiz4a {
	
	public static void main(String[] args) {
		List<List<Integer>> table = new ArrayList<List<Integer>>();
		//List<List<Integer>> table = new ArrayList<>();
		//List<List<Integer>> table = new List<>();
		//List<List<Integer>> table = new ArrayList<ArrayList<Integer>>();
		//List<List<Integer>> table = new ArrayList<List<>>();
		
		for (int i=0; i<10; i++) {
			List<Integer> row = new ArrayList<Integer>();
			
			for (int j=0; j<10; j++) {
				row.add(i+j);
			}
			table.add(row);
		}
	}

}
