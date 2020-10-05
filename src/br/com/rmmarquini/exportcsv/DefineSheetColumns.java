package br.com.rmmarquini.exportcsv;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DefineSheetColumns {
	
	private static List<String> alphabet;
	private static List<String> columns;
	private static String columnRange;
	
	protected String defineColumnsToCSVFile(Map<String, Object> dataMap) {
		alphabet = new ArrayList<String>();
		columns  = new ArrayList<String>();
		
		setAlphabet(alphabet);
		setColumns(columns, dataMap);
		
		columnRange = getColumns().get(0) + "1:" + getColumns().get(getColumns().size() - 1) + "1";
		
		return columnRange;
	}
	
	private static List<String> getAlphabet() {
		return alphabet;
	}

	private static void setAlphabet(List<String> alphabet) {
		alphabet.add("A");
		alphabet.add("B");
		alphabet.add("C");
		alphabet.add("D");
		alphabet.add("E");
		alphabet.add("F");
		alphabet.add("G");
		alphabet.add("H");
		alphabet.add("I");
		alphabet.add("J");
		alphabet.add("K");
		alphabet.add("L");
		alphabet.add("M");
		alphabet.add("N");
		alphabet.add("O");
		alphabet.add("P");
		alphabet.add("Q");
		alphabet.add("R");
		alphabet.add("S");
		alphabet.add("T");
		alphabet.add("U");
		alphabet.add("V");
		alphabet.add("W");
		alphabet.add("X");
		alphabet.add("Y");
		alphabet.add("Z");
	}

	private static List<String> getColumns() {
		return columns;
	}

	private static void setColumns(List<String> columns, Map<String, Object> dataMap) {
		for (int i=0; i<dataMap.size(); i++) {
			int colCursor = i / getAlphabet().size();
			if (colCursor > 0) {
				columns.add( getAlphabet().get(colCursor-1) + getAlphabet().get( i - ( getAlphabet().size() * colCursor ) ) );
			} else {
				columns.add( getAlphabet().get(i) );
			}
		}
	}
	
}
