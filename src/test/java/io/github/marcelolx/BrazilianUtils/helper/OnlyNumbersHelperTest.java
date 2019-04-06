package io.github.marcelolx.brazilianutils.helper;

import static org.junit.Assert.*;

import org.junit.Test;

public class OnlyNumbersHelperTest {

	@Test
	public void testRemoveAllNonNumericCharacters() {
		assertEquals("1234567890", OnlyNumbersHelper.get("123abc456?.#789xyz 0"));
	}

}
