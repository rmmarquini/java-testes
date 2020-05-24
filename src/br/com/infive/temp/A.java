package br.com.infive.temp;

public class A {
	
	public static void main(String[] args) {
		A a = new A();
		B b = new B();
		C c = new C();
		D d = new D();
		
		if (d instanceof B) {System.out.println("d instanceof B");}
		if (c instanceof D) {System.out.println("c instanceof D");}
		if (a instanceof C) {System.out.println("a instanceof C");}
		if (d instanceof A) {System.out.println("c instanceof A");}
		if (a instanceof B) {System.out.println("a instanceof B");}
	}
	
}
