package br.com.rmmarquini.exportcsv;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetProtection;

public class GenerateCSVFromLinkedHashMapData extends IntMain {
	
	private XSSFWorkbook wb = null;
	private OutputStream os = null;
	
	@SuppressWarnings("unused")
	protected OutputStream convertDataToCSV() throws IOException, FileNotFoundException {
		
		try {
			
			wb = new XSSFWorkbook();
			DataFormat dataFormat = wb.createDataFormat();
			XSSFSheet sheet = wb.createSheet("planilha");
			sheet.protectSheet("1234");
			
			sheet.setAutoFilter(CellRangeAddress.valueOf("A1:A1"));
			CTSheetProtection sheetProtection = sheet.getCTWorksheet().getSheetProtection();
			sheetProtection.setSort(false);
			sheetProtection.setAutoFilter(false);
			
			int colPos = 0;
			int rowPos = 0;
			XSSFCellStyle style = wb.createCellStyle();
			
			XSSFFont font = wb.createFont();
			font.setFontName(HSSFFont.FONT_ARIAL);
			font.setFontHeightInPoints((short) 10);
			style.setFont(font);
			
			for (Map.Entry<Integer, String> map : getCsvDataMap().entrySet()) {
				XSSFRow row = sheet.createRow(rowPos);
				XSSFCell cell = row.createCell(colPos);
				cell.setCellValue((String) map.getValue());
				rowPos++;
			}
			
			System.out.println(new String(new char[50]).replace("\0", "-"));
			System.out.println("GERANDO O ARQUIVO CSV");
			os = new FileOutputStream(new File(getPath() + getCsvFilename()));
			wb.write(os);
			setOs(os);
			
		} finally {
			if (wb != null) wb.close();
			if (os != null) os.close();
		}
		
		return getOs();
		
	}

	private OutputStream getOs() {
		return os;
	}

	private void setOs(OutputStream os) {
		this.os = os;
	}

}
