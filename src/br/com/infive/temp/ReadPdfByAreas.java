package br.com.infive.temp;

import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.text.WordUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.text.PDFTextStripperByArea;


public class ReadPdfByAreas {
	
	private static Writer writer = new StringWriter();
	private static String[] fieldLines = null;
	private static Map<String, String> fieldData = new HashMap<String, String>();
	private static List<Map<String, String>> lstPdfData = new ArrayList<Map<String, String>>();
	
	public static void main(String[] args) throws IOException {
		
		PDDocument documento = PDDocument.load(new File("C:/Users/Rafa/Desktop/mondial/neogrid.pdf"));
		try {
			
			if (!documento.isEncrypted()) {
				
				Map<String, List<Integer>> fieldCoordinates = new HashMap<String, List<Integer>>();
				List<Integer> lstCoordinates = new ArrayList<Integer>();
				lstCoordinates.add(70);  // x
				lstCoordinates.add(242); // y
				lstCoordinates.add(100); // width
				lstCoordinates.add(40);  // height
				fieldCoordinates.put("Comprador", lstCoordinates);
				lstCoordinates = new ArrayList<Integer>();
				lstCoordinates.add(67);  // x
				lstCoordinates.add(209); // y
				lstCoordinates.add(97);  // width
				lstCoordinates.add(52);  // height
				fieldCoordinates.put("Numero do pedido", lstCoordinates);
				
				for (Map.Entry<String, List<Integer>> entry : fieldCoordinates.entrySet()) {
					setFieldLines(fieldLines, documento, entry.getKey(), entry.getValue());
					setFieldData(fieldData);
					setLstPdfData(lstPdfData);
				}
				
				System.out.println(new String(new char[50]).replace("\0", "-"));
				System.out.println("CAMPOS DO PDF: " + getLstPdfData());
				
			}
			
		} catch (IOException e) {
			e.printStackTrace(new PrintWriter(writer));
			System.err.println(writer.toString());
		} finally {
			documento.close();
		}
		
	}
	
	// -------------------------------------------------------------------------
	/**
	 * GETTERS AND SETTERS
	 */
	public static String[] getFieldLines() {
		return fieldLines;
	}

	public static void setFieldLines(String[] fieldLines, PDDocument documento, String k, List<Integer> V) throws IOException {
		
		PDFTextStripperByArea st = new PDFTextStripperByArea();
		st.setSortByPosition(true);
		
		Rectangle rectArea = new Rectangle(V.get(0), V.get(1), V.get(2), V.get(3));
		st.addRegion( k, rectArea );
		
		PDPage firstPg = documento.getPage(0);
		st.extractRegions(firstPg);
		System.out.println(new String(new char[50]).replace("\0", "-"));
		System.out.println("TEXTO NA AREA: " + rectArea);
		
		fieldLines = st.getTextForRegion(k).split("\\r?\\n");
		
		ReadPdfByAreas.fieldLines = fieldLines;
	}

	public static Map<String, String> getfieldData() {
		return fieldData;
	}

	public static void setFieldData(Map<String, String> fieldData) {
		fieldData = new HashMap<String, String>();
		int aux = 0;
		String k = null;
		String V = null;
		for (String line : getFieldLines()) {
			System.out.println(line);
			if (aux == 0) k = normalizarString(WordUtils.capitalizeFully(line));
			if (aux == 1) V = underlineReplacer(normalizarString(WordUtils.capitalizeFully(line)));
			aux++;
		}
		fieldData.put(k, V);
		ReadPdfByAreas.fieldData = fieldData;
	}
	
	public static List<Map<String, String>> getLstPdfData() {
		return lstPdfData;
	}

	public static void setLstPdfData(List<Map<String, String>> lstPdfData) {
		lstPdfData.add(getfieldData());
		ReadPdfByAreas.lstPdfData = lstPdfData;
	}
	
	// -------------------------------------------------------------------------
	/**
	 * METODO PARA NORMALIZACAO DE STRING
	 * REMOVE CARACTERES ESPECIAIS, EXCETO / E _
	 * @param str
	 * @return
	 */
	public static String normalizarString(String str) {
		return Normalizer.normalize(str.replaceAll("[\\p{Punct}&&[^&/._-]]+", ""), Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "").trim();
	}
	
	/**
	 * METODO PARA SUBSTITUIR UNDERLINE POR ESPACO
	 * @param str
	 * @return
	 */
	public static String underlineReplacer(String str) {
		return str.replace("_", " ");
	}

}
