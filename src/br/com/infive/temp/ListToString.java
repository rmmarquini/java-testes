package br.com.infive.temp;
import java.util.ArrayList;
import java.util.List;

public class ListToString {
	
	public static void main(String[] args) {
		List<String> lst = new ArrayList<String>();
		String str = null;
		
		lst.add("rafa.mardegan@gmail.com");
		lst.add("moniquebiotto@gmail.com");
		lst.add("andrusfk2@gmail.com");
		
		str = String.join(", ", lst);
		
		System.out.println(str);
		
	}

}
