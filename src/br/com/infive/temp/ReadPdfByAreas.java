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

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.text.PDFTextStripperByArea;


public class ReadPdfByAreas {
	
	private static Writer writer = new StringWriter();
	private static String[] fieldLines = null;
	private static Map<String, String> fieldData = new HashMap<String, String>();
	private static List<Map<String, String>> lstPdfData = new ArrayList<Map<String, String>>();
	
	public static void main(String[] args) throws IOException {
		
		PDDocument documento = PDDocument.load(new File("C:\\Users\\rafam\\Downloads\\arquivo.pdf"));
		try {
			
			if (!documento.isEncrypted()) {
				
				Map<String, List<Integer>> fieldCoordinates = new HashMap<String, List<Integer>>();
				List<Integer> lstCoordinates = new ArrayList<Integer>();
				lstCoordinates.add(100); // x
				lstCoordinates.add(150); // y
				lstCoordinates.add(100); // width
				lstCoordinates.add(50);  // height
				fieldCoordinates.put("Data de emissao", lstCoordinates);
				lstCoordinates = new ArrayList<Integer>();
				lstCoordinates.add(40);  // x
				lstCoordinates.add(150); // y
				lstCoordinates.add(100); // width
				lstCoordinates.add(50);  // height
				fieldCoordinates.put("Numero do pedido", lstCoordinates);
				lstCoordinates = new ArrayList<Integer>();
				lstCoordinates.add(150); // x
				lstCoordinates.add(300); // y
				lstCoordinates.add(100); // width
				lstCoordinates.add(80);  // height
				fieldCoordinates.put("Data entrega", lstCoordinates);
				lstCoordinates = new ArrayList<Integer>();
				lstCoordinates.add(50);  // x
				lstCoordinates.add(180); // y
				lstCoordinates.add(100); // width
				lstCoordinates.add(80);  // height
				fieldCoordinates.put("CNPJ", lstCoordinates);
				lstCoordinates = new ArrayList<Integer>();
				lstCoordinates.add(50);  // x
				lstCoordinates.add(320); // y
				lstCoordinates.add(100); // width
				lstCoordinates.add(50);  // height
				fieldCoordinates.put("Codigo EAN", lstCoordinates);
				lstCoordinates = new ArrayList<Integer>();
				lstCoordinates.add(300); // x
				lstCoordinates.add(320); // y
				lstCoordinates.add(100); // width
				lstCoordinates.add(50);  // height
				fieldCoordinates.put("Condicao de entrega", lstCoordinates);
				lstCoordinates = new ArrayList<Integer>();
				lstCoordinates.add(30);  // x
				lstCoordinates.add(620); // y
				lstCoordinates.add(730); // width
				lstCoordinates.add(225); // height
				fieldCoordinates.put("Observações", lstCoordinates);
				lstCoordinates = new ArrayList<Integer>();
				lstCoordinates.add(293); // x
				lstCoordinates.add(500); // y
				lstCoordinates.add(30);  // width
				lstCoordinates.add(50);  // height
				fieldCoordinates.put("Quantidade", lstCoordinates);
				lstCoordinates = new ArrayList<Integer>();
				lstCoordinates.add(337); // x
				lstCoordinates.add(500); // y
				lstCoordinates.add(30);  // width
				lstCoordinates.add(50);  // height
				fieldCoordinates.put("Valor unitario", lstCoordinates);
				
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
	
	/** 
	 * COLETA CADA OBJETO DO DOCUMENTO LISTADOS PELAS COORDENADAS INFORMADAS 
	 * @param fieldLines
	 * @param documento
	 * @param k
	 * @param V
	 * @throws IOException
	 */
	public static void setFieldLines(String[] fieldLines, PDDocument documento, String k, List<Integer> V) throws IOException {
		
		// CRIA O OBJETO QUE RECEBE O DOCUMENTO PDF E INFORMA QUE SERA VERIFICADO POR POSICIONAMENTO
		PDFTextStripperByArea st = new PDFTextStripperByArea();
		st.setSortByPosition(true);
		
		// MONTA A AREA RETANGULAR INFORMADA PELA COORDENADA
		Rectangle rectArea = new Rectangle(V.get(0), V.get(1), V.get(2), V.get(3));
		st.addRegion( k, rectArea );
		
		// SETA A PAGINA PARA EXTRAIR AS INFORMACOES DA REGIAO
		PDPage firstPg = documento.getPage(0);
		st.extractRegions(firstPg);
		System.out.println(new String(new char[50]).replace("\0", "-"));
		System.out.println("TEXTO NA AREA: " + rectArea);
		
		// DEFINE AS INFORMACOES NO ARRAY
		fieldLines = st.getTextForRegion(k).split("\\r?\\n");
		
		ReadPdfByAreas.fieldLines = fieldLines;
	}

	public static Map<String, String> getfieldData() {
		return fieldData;
	}
	
	/**
	 * MONTA OS DADOS EXTRAIDOS NO MAPA QUE SERA ADICIONADO NA LISTA FINAL
	 * @param fieldData
	 */
	public static void setFieldData(Map<String, String> fieldData) {
		fieldData = new HashMap<String, String>();
		int aux = 0;
		String k = null;
		String V = null;
		for (String line : getFieldLines()) {
			System.out.println(line);
			// AS CHAVES DO MAPA FORAM PADRONIZADAS PARA UPPERCASE COM PALAVRAS SEPARADAS POR _
			if (aux == 0) k = normalizarString(line.trim().toUpperCase()).replace(" ", "_");
			// NORMALIZA OS VALORES DAS STRINGS COLETADAS
			if (aux == 1) {
				V = underlineReplacer(normalizarString(line));
				if (k.equalsIgnoreCase("DATA_FINAL") || k.equalsIgnoreCase("DATA_DE_EMISSAO") || 
					k.equalsIgnoreCase("CNPJ")) {
					V = removeSpaces(V);
				}
			}
			aux++;
		}
		fieldData.put(k, V);
		ReadPdfByAreas.fieldData = fieldData;
	}
	
	public static List<Map<String, String>> getLstPdfData() {
		return lstPdfData;
	}
	
	/**
	 * ADICIONA AS INFO MAPEADAS NA COORDENADA NA LISTA RESULTADO FINAL
	 * @param lstPdfData
	 */
	public static void setLstPdfData(List<Map<String, String>> lstPdfData) {
		lstPdfData.add(getfieldData());
		ReadPdfByAreas.lstPdfData = lstPdfData;
	}
	
	// -------------------------------------------------------------------------
	/**
	 * METODO PARA NORMALIZACAO DE STRING
	 * REMOVE CARACTERES ESPECIAIS, EXCETO / , . _ -
	 * @param str
	 * @return
	 */
	public static String normalizarString(String str) {
		return Normalizer.normalize(str.replaceAll("[\\p{Punct}&&[^&/,._-]]+", ""), Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "").trim();
	}
	
	/**
	 * METODO PARA SUBSTITUIR UNDERLINE POR ESPACO
	 * @param str
	 * @return
	 */
	public static String underlineReplacer(String str) {
		return str.replace("_", " ");
	}
	
	/**
	 * METODO PARA REMOVER ESPACOS
	 * @param str
	 * @return
	 */
	public static String removeSpaces(String str) {
		return str.replace(" ", "");
	}

}
