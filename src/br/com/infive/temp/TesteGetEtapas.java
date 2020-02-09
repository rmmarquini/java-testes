package br.com.infive.temp;

import java.util.ArrayList;
import java.util.List;

public class TesteGetEtapas {

	public static void main(String[] args) {
		String forms = "10@9;11@23;23@7";
		String[] spltForms = forms.split(";");
		List<String> lstForms = new ArrayList<String>();
		for (String form : spltForms) {
			System.out.println("codForm: " + form.split("@")[0]);
			System.out.println("codEtapa: " + form.split("@")[1]);
			lstForms.add(form);
		}
		System.out.println(lstForms);

	}

}
