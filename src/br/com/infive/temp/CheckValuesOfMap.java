package br.com.infive.temp;
import java.util.HashMap;
import java.util.Map;

public class CheckValuesOfMap {
	
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		boolean exec = false;
		
		map.put("CHAVE", "0265081513220191202");
		map.put("NOME", "Rafael Mardegan Marquini");
		map.put("IDADE", "");
		map.put("TELEFONE", "");
		map.put("EMAIL", "rafa.mardegan@gmail.com");
		
		for (Map.Entry<String, String> entry : map.entrySet()) {
			exec = (entry.getValue().length() > 0) ? true : false;
			if (!exec) break;
		}
		
		System.out.println("VALOR DO EXEC = " + exec);
		
	}

}
