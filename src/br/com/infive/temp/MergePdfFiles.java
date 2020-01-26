package br.com.infive.temp;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;

public class MergePdfFiles {

	@SuppressWarnings("unused")
	private static boolean mergePdfFiles(List<InputStream> inputPdfFiles, OutputStream mergedFile) throws Exception {

		try {

			// CRIA DOCUMENTO E OBJETOS PDFREADER
			Document document = new Document();
			List<PdfReader> readers = new ArrayList<PdfReader>();

			// INICIALIZA O CONTADOR DE PAGINAS
			int totalPages = 0;

			// CRIA UM ITERADOR PARA PERCORRER A LISTA DE ARQUIVOS PDF
			Iterator<InputStream> pdfIterator = inputPdfFiles.iterator();

			// LE A LISTA DE PDF
			while (pdfIterator.hasNext()) {
				InputStream pdf = pdfIterator.next();
				PdfReader pdfReader = new PdfReader(pdf);
				readers.add(pdfReader);
				totalPages += pdfReader.getNumberOfPages();
			}

			// CRIA O OBJETO QUE IRA ESCREVER NO ARQUIVO DE SAIDA
			PdfWriter writer = PdfWriter.getInstance(document, mergedFile);

			// AGORA ABRE O DOCUMENTO
			document.open();

			// MANTEM OS BYTES DO CONTEUDO PDF
			PdfContentByte pageContentByte = writer.getDirectContent();

			PdfImportedPage pdfImportedPage;
			int curPdfReaderPage = 1;
			Iterator<PdfReader> iteratorPdfReader = readers.iterator();

			// ITERA E PROCESSO A LISTA readers, ONDE FORAM ADICIONADOS OS ARQUIVOS PDF
			while (iteratorPdfReader.hasNext()) {
				PdfReader pdfReader = iteratorPdfReader.next();
				// CRIA A PAGINA E ADD O CONTEUDO CHECANDO CADA PAGINA DO ARQUIVO ABERTO NO
				// MOMENTO
				while (curPdfReaderPage <= pdfReader.getNumberOfPages()) {
					document.newPage();
					pdfImportedPage = writer.getImportedPage(pdfReader, curPdfReaderPage);
					pageContentByte.addTemplate(pdfImportedPage, 0, 0);
					curPdfReaderPage++;
				}
				// RETORNA O PONTEIRO DE PAGINA PARA O VALOR INICIAL
				curPdfReaderPage = 1;
			}

			// LIBERA O ARQUIVO, FECHA O DOCUMENTO E O OUTPUTSTREAM
			mergedFile.flush();
			document.close();
			mergedFile.close();

			System.out.println("Arquivos PDF combinados com sucesso!");

			return true;

		} catch (Exception e) {
			System.out.println("ERRO: " + e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	public static void main(String args[]) {
		try {
			// PREPARA OS ARQUIVOS PDF QUE DESEJA-SE COMBINAR
			List<InputStream> inputPdfList = new ArrayList<InputStream>();
			inputPdfList.add(new FileInputStream("C:/Users/rafam/Documents/pg01.pdf"));
			inputPdfList.add(new FileInputStream("C:/Users/rafam/Documents/pg02.pdf"));

			// PREPARA O OUTPUT QUE RECEBERA O ARQUIVO COMBINADO
			OutputStream outputStream = new FileOutputStream("C:/Users/rafam/Documents/merged-file.pdf");

			// CHAMA O METODO PARA COMBINAR OS ARQUIVOS
			mergePdfFiles(inputPdfList, outputStream);
			
		} catch (Exception e) {
			System.out.println("ERRO: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
