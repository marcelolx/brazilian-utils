package io.github.marcelolx.brazilianutils.helper;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class CheckSumGeneratorHelperTest {

	private static final String baseNumber = "12";
	
	@Test
	public void testGenerateTheRightChecksum() {		
		int weight = 10;
		
		assertEquals(28, CheckSumGeneratorHelper.generate(baseNumber, weight));
	}
	
	@Test
	public void testGenerateRightChecksum() {
		List<Integer> weights = new ArrayList<Integer>(Arrays.asList(10, 9));
		
		assertEquals(28, CheckSumGeneratorHelper.generate(baseNumber, weights));
	}
}
