package io.github.marcelolx.brazilianutils.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CheckSumGeneratorHelper {
	
	public static int generate(Integer baseNumber, Integer weights) {
		
		List<Integer> weightsArray = numberToWeightArray(weights, baseNumber.toString().length());
		
		return createChecksum(baseNumber.toString(), weightsArray);
	}
		
	public static int generate(Integer baseNumber, Integer[] weight) {
		
				
		return -1;		
	}
	
	private static int createChecksum(String cpfStart, List<Integer> weights) {
		Stream<Character> charStream = cpfStart.chars().mapToObj(c -> (char) c);
		
		//charStream.reduce((value, index) -> {});
		
		return -1;
	}
	
	private static List<Integer> numberToWeightArray(int weight, int number) {
		List<Integer> result = new ArrayList<>();
		
		for (int i = 0; i < number; i++) {
			result.add(weight - i);
		}
		
		return result;
	}
	
	private CheckSumGeneratorHelper() {		
	}
}
