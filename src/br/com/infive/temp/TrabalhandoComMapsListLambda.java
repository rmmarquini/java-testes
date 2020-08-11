package br.com.infive.temp;

import java.util.*;
import java.util.stream.Collectors;

public class TrabalhandoComMapsListLambda {
	
	/**
	 * MAIN METHOD
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		
		List<Map<String, Object>> lstOfMaps = new ArrayList<>();
		Map<String, Object> myMap = new HashMap<>();
		
		System.out.println(new String(new char[50]).replace("\0", "-"));
		System.out.println("----- INICIO -----");
		System.out.println(new String(new char[50]).replace("\0", "-"));
		System.out.println("PRIMEIRA INTERACAO");
		myMap.put("COD_FORM", 21);
		myMap.put("COD_PROCESSO", 12456);
		myMap.put("COD_USUARIO_ETAPA", 1494);
		myMap.put("NOM_USUARIO", "Bjorn");
		System.out.println("myMap - preenchimento 1: " + myMap);
		lstOfMaps.add(myMap);
		
		myMap = new HashMap<>();
		System.out.println(new String(new char[50]).replace("\0", "-"));
		System.out.println("SEGUNDA INTERACAO");
		myMap.put("COD_FORM", 21);
		myMap.put("COD_PROCESSO", 13557);
		myMap.put("COD_USUARIO_ETAPA", 1493);
		myMap.put("NOM_USUARIO", "Ragnar");
		System.out.println("myMap - preenchimento 2: " + myMap);
		lstOfMaps.add(myMap);
		
		myMap = new HashMap<>();
		System.out.println(new String(new char[50]).replace("\0", "-"));
		System.out.println("TERCEIRA INTERACAO");
		myMap.put("COD_FORM", 35);
		myMap.put("COD_PROCESSO", 14882);
		myMap.put("COD_USUARIO_ETAPA", 1495);
		myMap.put("NOM_USUARIO", "Lagertha");
		System.out.println("myMap - preenchimento 3: " + myMap);
		lstOfMaps.add(myMap);
		
		System.out.println(new String(new char[50]).replace("\0", "-"));
		System.out.println("lstOfMaps - final: " + lstOfMaps);
		
		System.out.println(new String(new char[50]).replace("\0", "-"));
		System.out.println("FILTRANDO OS COD_FORM...");
		
		List<Integer> codForms = new ArrayList<>();
		lstOfMaps.stream()
			.map(map -> {
				int codForm = (int) map.get("COD_FORM");
				if (!codForms.contains(codForm)) 
					codForms.add(codForm);
				return codForms;
			})
			.collect(Collectors.toList());
		System.out.println(codForms);
		System.out.println(new String(new char[50]).replace("\0", "-"));
		
		for (int codForm : codForms) {
			List<Map<String, Object>> procGestor = new ArrayList<>();
			procGestor = lstOfMaps.stream()
							.filter(map -> map.get("COD_FORM").equals(codForm))
							.collect(Collectors.toList());
			System.out.println(procGestor);
			System.out.println("DISPARA E-MAIL PARA O GESTOR DO COD_FORM " + codForm);
			System.out.println(new String(new char[50]).replace("\0", "-"));
		}
		
		System.out.println("----- FIM -----");
		System.out.println(new String(new char[50]).replace("\0", "-"));
		
	}
	
}
