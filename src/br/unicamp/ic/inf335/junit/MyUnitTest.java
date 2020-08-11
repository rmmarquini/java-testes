package br.unicamp.ic.inf335.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class MyUnitTest {
	
	private static MyUnit mu;
	
	@BeforeAll
	public static void initAll() {
		mu = new MyUnit();
	}
	
	@Test
	public void testTwoStrings() {
		String result = mu.concatenate("abc", "def");
		assertEquals("abcdef", result);
	}
	
	@Test
	public void testSecondEmpty() {
		String result = mu.concatenate("abc", "");
		assertEquals("abc", result);
	}
	
	@Test
	public void testBothEmpty() {
		String result = mu.concatenate("", "");
		assertEquals("", result);
	}
	
}
