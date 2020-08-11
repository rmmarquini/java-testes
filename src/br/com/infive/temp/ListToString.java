package br.com.infive.temp;
import java.util.ArrayList;
import java.util.List;

public class ListToString {
	
	public static void main(String[] args) {
		List<String> lst = new ArrayList<String>();
		String str = null;
		
		lst.add("contato@exemplo.com");
		lst.add("fulano@email.com");
		lst.add("outro@email.com");
		
		str = String.join(", ", lst);
		
		System.out.println(str);
		
	}

}
