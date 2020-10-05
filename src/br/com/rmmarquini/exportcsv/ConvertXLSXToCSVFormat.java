package br.com.rmmarquini.exportcsv;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ConvertXLSXToCSVFormat extends IntMain {

	private InputStream is = null;
	private final String separator = "|";
	private XSSFWorkbook wb = null;
	private Map<Integer, String> csvDataMap;
	
	protected Map<Integer, String> convertXLSXToCSV() throws IOException, FileNotFoundException {
		
		try {
			csvDataMap = new LinkedHashMap<Integer, String>();
			is = new FileInputStream(new File(getPath() + getXlsxFilename()));
			
			// Open the XLSX file and get the requested sheet from the workbook
			wb = new XSSFWorkbook(is);
			XSSFSheet selSheet = wb.getSheetAt(0);
			
			// Iterate through all the rows in the selected sheet 
			Iterator<Row> rowIterator = selSheet.iterator();
			while (rowIterator.hasNext()) {
				
				Row row = rowIterator.next();
				
				// Iterate through all the columns in the row
				Iterator<Cell> cellIterator = row.cellIterator();
				StringBuffer sb = new StringBuffer();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					if (sb.length() != 0) {
						sb.append(separator);
					}
					
					switch (cell.getCellTypeEnum()) {
						case STRING:
							sb.append(cell.getStringCellValue());
							break;
						case NUMERIC:
							sb.append(cell.getNumericCellValue());
							break;
						case BOOLEAN:
							sb.append(cell.getBooleanCellValue());
							break;
						default:
					}
				}
				csvDataMap.put(row.getRowNum(), sb.toString());
				
			}
			
			
		} finally {
			if (wb != null) wb.close();
			if (is != null) is.close();
		}
		
		return csvDataMap;
		
	}
	
}
