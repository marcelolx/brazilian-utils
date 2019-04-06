package io.github.marcelolx.brazilianutils.cpf.consts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CPFConstants {

	public static final List<String> BLACKLIST = new ArrayList<String>(Arrays.asList(
			  "00000000000",
			  "11111111111",
			  "22222222222",
			  "33333333333",
			  "44444444444",
			  "55555555555",
			  "66666666666",
			  "77777777777",
			  "88888888888",
			  "99999999999"
			));
	
	public static final int CPF_LENGTH = 11;
	
	public static final List<Integer> CHECK_DIGITS = new ArrayList<Integer>(Arrays.asList(9, 10));
	
	private CPFConstants() {		
	}

}
