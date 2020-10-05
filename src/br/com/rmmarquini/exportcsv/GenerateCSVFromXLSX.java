package br.com.rmmarquini.exportcsv;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GenerateCSVFromXLSX extends IntMain {
	
	private PrintStream out;
	private final String separator = "|";
	private XSSFWorkbook wb = null;
	private FormulaEvaluator fe = null;
	
	protected PrintStream convertCSV() throws IOException, FileNotFoundException, InvalidFormatException {
		
		try {
			
			wb = new XSSFWorkbook(new File(getPath() + getXlsxFilename()));
			fe = wb.getCreationHelper().createFormulaEvaluator();
			
			DataFormatter formatter = new DataFormatter();
			out = new PrintStream(new FileOutputStream(getPath() + getCsvFilename()), true, "UTF-8");
			byte[] bom = {(byte)0xEF, (byte)0xBB, (byte)0xBF};
			out.write(bom);
			{
				Sheet sheet = wb.getSheetAt(0);
				for (int r=0; r<=sheet.getLastRowNum(); r++) {
			        Row row = sheet.getRow(r);
			        if ( row == null ) { out.println(separator); continue; }
			        boolean firstCell = true;
			        for (int c = 0; c<row.getLastCellNum(); c++) {
			            Cell cell = row.getCell(c, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
			            if (!firstCell) out.print(separator);
			            if ( cell != null ) {
			                if ( fe != null ) cell = fe.evaluateInCell(cell);
			                String value = formatter.formatCellValue(cell);
			                if ( cell.getCellTypeEnum() == CellType.FORMULA ) {
			                    value = "=" + value;
			                }
			                out.print(value);
			            }
			            firstCell = false;
			        }
			        out.println();
			    }
			}
			
		} finally {
			if (fe != null) fe.clearAllCachedResultValues();
			if (wb != null) wb.close();
			if (out != null) out.close();
		}
		
		return out;
		
	}

}
