package io.github.marcelolx.brazilianutils.helper;

import java.util.ArrayList;
import java.util.List;

public class CheckSumGeneratorHelper {

	public static int generate(String baseNumber, Integer weights) {

		String numericBase = OnlyNumbersHelper.get(baseNumber);
		
		List<Integer> weightsArray = numberToWeightArray(weights, numericBase.length());

		return createChecksum(numericBase, weightsArray);
	}

	public static int generate(String baseNumber, List<Integer> weights) {

		return createChecksum(baseNumber, weights);
	}

	private static int createChecksum(String cpfStart, List<Integer> weights) {

		String[] cpfStartSplitted = cpfStart.split("");
		int result = 0;
		
		for (int index = 0; index < cpfStartSplitted.length; index++) {
			result = calcCheckSum(index, weights, result, Integer.parseInt(cpfStartSplitted[index]));
		}
		
		return result;
	}
	
	private static int calcCheckSum(Integer index, List<Integer> weights, Integer acumulator, Integer currentValue) {

		return acumulator + currentValue * weights.get(index);
	}

	private static List<Integer> numberToWeightArray(int weight, int length) {
		List<Integer> result = new ArrayList<>();

		for (int i = 0; i < length; i++) {
			result.add(weight - i);
		}

		return result;
	}

	private CheckSumGeneratorHelper() {
	}
}
