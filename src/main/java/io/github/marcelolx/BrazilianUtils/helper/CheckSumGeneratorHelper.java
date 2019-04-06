package io.github.marcelolx.brazilianutils.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CheckSumGeneratorHelper {

	private static int index;

	public static int generate(String baseNumber, Integer weights) {

		String numericBase = OnlyNumbersHelper.get(baseNumber);
		
		List<Integer> weightsArray = numberToWeightArray(weights, numericBase.length());

		return createChecksum(numericBase, weightsArray);
	}

	public static int generate(String baseNumber, List<Integer> weights) {

		return createChecksum(baseNumber, weights);
	}

	private static int createChecksum(String cpfStart, List<Integer> weights) {

		Stream<Character> charStream = cpfStart.chars().mapToObj(c -> (char) c);

		index = 0;

		return charStream.mapToInt(value -> Integer.parseInt(value.toString())).reduce(index, (a, b) -> {

			int result = a + b * weights.get(index);

			++index;

			return result;
		});
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
