package io.github.marcelolx.brazilianutils.cpf.consts;

import java.util.Arrays;
import java.util.List;

public class CPFConstants {

	public static final int CPF_LENGTH = 11;
	
	public static final Integer HYPHEN_INDEX = 8;
	
	public static final List<String> blacklist() {
		return Arrays.asList("00000000000", "11111111111", "22222222222", "33333333333",
				"44444444444", "55555555555", "66666666666", "77777777777", "88888888888", "99999999999");
	}
	
	public static final List<Integer> checkDigits() {
		return Arrays.asList(9, 10);
	}
	
	public static final List<Integer> dotIndexes() {
		return Arrays.asList(2, 5);
	}	

	private CPFConstants() {
	}

}
