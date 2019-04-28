package io.github.marcelolx.brazilianutils.cpf;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import io.github.marcelolx.brazilianutils.cpf.impl.CPFFormatterImpl;

public class CPFFormatterTest {

	private CPFFormatter cpfFormatter;
	
	@Before
	public void setUp() throws Exception {
		cpfFormatter = new CPFFormatterImpl();
	}

	@Test
	public void testFormatSuccess() {
	  assertEquals("", cpfFormatter.format(null));
	  assertEquals("", cpfFormatter.format(""));
	  assertEquals("9", cpfFormatter.format("9"));
	  assertEquals("94", cpfFormatter.format("94"));
	  assertEquals("943", cpfFormatter.format("943"));
	  assertEquals("943.8", cpfFormatter.format("9438"));
	  assertEquals("943.89", cpfFormatter.format("94389"));
	  assertEquals("943.895", cpfFormatter.format("943895"));
	  assertEquals("943.895.7", cpfFormatter.format("9438957"));
	  assertEquals("943.895.75", cpfFormatter.format("94389575"));
	  assertEquals("943.895.751", cpfFormatter.format("943895751"));
	  assertEquals("943.895.751-0", cpfFormatter.format("9438957510"));
	  assertEquals("943.895.751-04", cpfFormatter.format("94389575104"));
	}
	
	@Test
	public void testShouldNotAddDigitsAfterCPFLength() {
		assertEquals("943.895.751-04", cpfFormatter.format("94389575104000000"));
	}
	
	@Test
	public void shouldRemoveAllNonNumericCharacters() {
		assertEquals("943.895.751-04", cpfFormatter.format("943.?ABC895.751-04abc"));
	}

}
