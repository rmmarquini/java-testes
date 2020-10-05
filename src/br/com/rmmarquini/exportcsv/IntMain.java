package br.com.rmmarquini.exportcsv;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.LinkedHashMap;
import java.util.Map;

public class IntMain {
	
	private static Writer writer = new StringWriter();
	protected static String path;
	protected static String xlsxFilename;
	protected static String csvFilename;
	protected static Map<String, Object> entryDataMap;
	protected static Map<Integer, String> csvDataMap;
	protected static String columnsRange;
	protected static OutputStream xlsxOs;
	protected static OutputStream csvOs;
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		try {
			
			System.out.println(new String(new char[50]).replace("\0", "-"));
			System.out.println("----- INICIO DA EXECUCAO -----");
			
			System.out.println(new String(new char[50]).replace("\0", "-"));
			entryDataMap = new LinkedHashMap<String, Object>();
			setEntryDataMap(entryDataMap);
			System.out.println("DEFINE O MAP DE DADOS: " + getEntryDataMap());
			
			System.out.println(new String(new char[50]).replace("\0", "-"));
			setColumnsRange(columnsRange);
			System.out.println("RECUPERA O RANGE DAS COLUNAS: " + getColumnsRange());
			
			System.out.println(new String(new char[50]).replace("\0", "-"));
			System.out.println("CONVERTENDO OS DADOS PARA XLSX");
			setPath(path);
			setXlsxFilename(xlsxFilename);
			setXlsxOs(xlsxOs);
			System.out.println("XLSX GERADO... " + getXlsxOs());
			
			System.out.println(new String(new char[50]).replace("\0", "-"));
			System.out.println("CONVERTENDO O XLSX PARA CSV");
			setCsvDataMap(csvDataMap);
			System.out.println("CSV FORMATADO... " + getCsvDataMap());
			setCsvFilename(csvFilename);
			setCsvOs(csvOs);
			System.out.println("CSV GERADO... " + getCsvOs());
			
		} catch (FileNotFoundException e) {
			e.printStackTrace(new PrintWriter(writer));
			System.out.println(writer.toString());
		} catch (IOException e) {
			e.printStackTrace(new PrintWriter(writer));
			System.out.println(writer.toString());
		} finally {
			if (xlsxOs != null) xlsxOs.close();
		}
		
	}

	public String getPath() {
		return path;
	}

	private static void setPath(String path) {
		path = "C:\\Temp\\";
		IntMain.path = path;
	}

	public static String getXlsxFilename() {
		return xlsxFilename;
	}

	private static void setXlsxFilename(String filename) {
		filename = "minha_planilha.xlsx";
		IntMain.xlsxFilename = filename;
	}

	public static String getCsvFilename() {
		return csvFilename;
	}

	private static void setCsvFilename(String csvFilename) {
		csvFilename = "minha_planilha.csv";
		IntMain.csvFilename = csvFilename;
	}

	public static Map<String, Object> getEntryDataMap() {
		return entryDataMap;
	}

	private static void setEntryDataMap(Map<String, Object> entryDataMap) {
		entryDataMap.put("COLUNA_A", "VALOR 0");
		entryDataMap.put("COLUNA_B", "VALOR 1");
		entryDataMap.put("COLUNA_C", "VALOR 2");
		entryDataMap.put("COLUNA_D", "VALOR 3");
		entryDataMap.put("COLUNA_E", "VALOR 4");
		entryDataMap.put("COLUNA_F", "VALOR 5");
		entryDataMap.put("COLUNA_G", "VALOR 6");
		entryDataMap.put("COLUNA_H", "VALOR 7");
		entryDataMap.put("COLUNA_I", "VALOR 8");
		entryDataMap.put("COLUNA_J", "VALOR 9");
		entryDataMap.put("COLUNA_K", "VALOR 10");
		entryDataMap.put("COLUNA_L", "VALOR 11");
		entryDataMap.put("COLUNA_M", "VALOR 12");
		entryDataMap.put("COLUNA_N", "VALOR 13");
		entryDataMap.put("COLUNA_O", "VALOR 14");
		entryDataMap.put("COLUNA_P", "VALOR 15");
		entryDataMap.put("COLUNA_Q", "VALOR 16");
		entryDataMap.put("COLUNA_R", "VALOR 17");
		entryDataMap.put("COLUNA_S", "VALOR 18");
		entryDataMap.put("COLUNA_T", "VALOR 19");
		entryDataMap.put("COLUNA_U", "VALOR 20");
		entryDataMap.put("COLUNA_V", "VALOR 21");
		entryDataMap.put("COLUNA_W", "VALOR 22");
		entryDataMap.put("COLUNA_X", "VALOR 23");
		entryDataMap.put("COLUNA_Y", "VALOR 24");
		entryDataMap.put("COLUNA_Z", "VALOR 25");
		entryDataMap.put("COLUNA_AA", "VALOR 26");
		entryDataMap.put("COLUNA_AB", "VALOR 27");
		entryDataMap.put("COLUNA_AC", "VALOR 28");
		entryDataMap.put("COLUNA_AD", "VALOR 29");
		entryDataMap.put("COLUNA_AE", "VALOR 30");
		entryDataMap.put("COLUNA_AF", "VALOR 31");
		entryDataMap.put("COLUNA_AG", "VALOR 32");
		entryDataMap.put("COLUNA_AH", "VALOR 33");
		entryDataMap.put("COLUNA_AI", "VALOR 34");
		entryDataMap.put("COLUNA_AJ", "VALOR 35");
		entryDataMap.put("COLUNA_AK", "VALOR 36");
		entryDataMap.put("COLUNA_AL", "VALOR 37");
		entryDataMap.put("COLUNA_AM", "VALOR 38");
		entryDataMap.put("COLUNA_AN", "VALOR 39");
		entryDataMap.put("COLUNA_AO", "VALOR 40");
		entryDataMap.put("COLUNA_AP", "VALOR 41");
		entryDataMap.put("COLUNA_AQ", "VALOR 42");
		entryDataMap.put("COLUNA_AR", "VALOR 43");
		entryDataMap.put("COLUNA_AS", "VALOR 44");
		entryDataMap.put("COLUNA_AT", "VALOR 45");
		entryDataMap.put("COLUNA_AU", "VALOR 46");
		entryDataMap.put("COLUNA_AV", "VALOR 47");
		entryDataMap.put("COLUNA_AW", "VALOR 48");
		entryDataMap.put("COLUNA_AX", "VALOR 49");
		entryDataMap.put("COLUNA_AY", "VALOR 50");
		entryDataMap.put("COLUNA_AZ", "VALOR 51");
		entryDataMap.put("COLUNA_BA", "VALOR 52");
		entryDataMap.put("COLUNA_BB", "VALOR 53");
		entryDataMap.put("COLUNA_BC", "VALOR 54");
		entryDataMap.put("COLUNA_BD", "VALOR 55");
		entryDataMap.put("COLUNA_BE", "VALOR 56");
		entryDataMap.put("COLUNA_BF", "VALOR 57");
		entryDataMap.put("COLUNA_BG", "VALOR 58");
		entryDataMap.put("COLUNA_BH", "VALOR 59");
		entryDataMap.put("COLUNA_BI", "VALOR 60");
		IntMain.entryDataMap = entryDataMap;
	}

	public static String getColumnsRange() {
		return columnsRange;
	}

	private static void setColumnsRange(String columnsRange) {
		DefineSheetColumns dsc = new DefineSheetColumns();
		columnsRange = dsc.defineColumnsToCSVFile(getEntryDataMap());
		IntMain.columnsRange = columnsRange;
	}

	public static OutputStream getXlsxOs() {
		return xlsxOs;
	}

	private static void setXlsxOs(OutputStream xlsxOs) throws FileNotFoundException, IOException {
		GenerateXLSXFromLinkedHashMapData convertXLSX = new GenerateXLSXFromLinkedHashMapData();
		xlsxOs = convertXLSX.convertDataToXLSX();
		IntMain.xlsxOs = xlsxOs;
	}

	public static Map<Integer, String> getCsvDataMap() {
		return csvDataMap;
	}

	private static void setCsvDataMap(Map<Integer, String> csvDataMap) throws FileNotFoundException, IOException {
		ConvertXLSXToCSVFormat csvFormat = new ConvertXLSXToCSVFormat();
		csvDataMap = csvFormat.convertXLSXToCSV();
		IntMain.csvDataMap = csvDataMap;
	}

	public static OutputStream getCsvOs() {
		return csvOs;
	}

	public static void setCsvOs(OutputStream csvOs) throws FileNotFoundException, IOException {
		GenerateCSVFromLinkedHashMapData convertCSV = new GenerateCSVFromLinkedHashMapData();
		csvOs = convertCSV.convertDataToCSV();
		IntMain.csvOs = csvOs;
	}

}
