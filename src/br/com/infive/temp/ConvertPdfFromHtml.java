package br.com.infive.temp;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

public class ConvertPdfFromHtml {
	
	public static void main(String[] args) throws DocumentException, IOException {
		try {
			String filename = "C:/Users/rafam/Documents/REL_TRYOUT_4237.html";
			boolean r = convertPDFfromHTML(filename);
			System.out.println(r);
			System.out.println("NOME DA CLASSE: " + ConvertPdfFromHtml.class.getCanonicalName().substring(ConvertPdfFromHtml.class.getCanonicalName().lastIndexOf(".") + 1).trim());
		} catch(DocumentException e) {
			System.out.println("ERRO: " + e.getMessage());
		} catch(IOException e) {
			System.out.println("ERRO: " + e.getMessage());
		}
	}

	private static boolean convertPDFfromHTML(String filename) throws DocumentException, IOException {
		Document document = new Document();
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("C:/Users/rafam/Documents/REL_TRYOUT_4237.pdf"));
		document.open();
		XMLWorkerHelper.getInstance().parseXHtml(writer, document, new FileInputStream(filename));
		document.close();
		return true;
	}
}
