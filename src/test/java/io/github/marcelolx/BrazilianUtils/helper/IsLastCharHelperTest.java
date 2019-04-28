package io.github.marcelolx.brazilianutils.helper;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class IsLastCharHelperTest {

	@Test
	public void testShouldReturnTrueWhenIndexIsTheSameAsLastIndexOfTheString() {
		assertTrue(IsLastCharHelper.verify(2, "123"));
	}
	
	@Test
	public void testShouldReturnFalseWhenIndexIsNotTheSameAsLastIndexOfTheString() {		
		assertFalse(IsLastCharHelper.verify(1, "123"));
		assertFalse(IsLastCharHelper.verify(3, "123"));
	}

}
