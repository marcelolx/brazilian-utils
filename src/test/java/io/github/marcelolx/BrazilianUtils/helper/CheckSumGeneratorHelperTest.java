package io.github.marcelolx.brazilianutils.helper;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CheckSumGeneratorHelperTest {

	private static final Integer baseNumber = 12;
	
	@Test
	public void testGenerateTheRightChecksum() {		
		int weight = 10;
		
		assertEquals(28, CheckSumGeneratorHelper.generate(baseNumber, weight));
	}
	
	@Test
	public void testGenerateRightChecksum() {
		Integer[] weight = {10, 9};
		
		assertEquals(28, CheckSumGeneratorHelper.generate(baseNumber, weight));
	}
}
