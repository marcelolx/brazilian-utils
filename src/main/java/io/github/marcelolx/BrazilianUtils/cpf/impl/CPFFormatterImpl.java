package io.github.marcelolx.brazilianutils.cpf.impl;

import static io.github.marcelolx.brazilianutils.cpf.consts.CPFConstants.CPF_LENGTH;

import java.util.stream.Stream;

import io.github.marcelolx.brazilianutils.cpf.CPFFormatter;
import io.github.marcelolx.brazilianutils.cpf.consts.CPFConstants;
import io.github.marcelolx.brazilianutils.helper.IsLastCharHelper;
import io.github.marcelolx.brazilianutils.helper.OnlyNumbersHelper;

public class CPFFormatterImpl implements CPFFormatter {

	private static String numericCPF;
	
	private static int index;	
	
	@Override
	public String format(String cpf) {
		
		if (cpf == null || cpf.isBlank()) {
			return "";
		}
		
		numericCPF = OnlyNumbersHelper.get(cpf);
		
		if (numericCPF.length() > CPF_LENGTH) {
			numericCPF = numericCPF.substring(0, CPF_LENGTH);
		}
		
		Stream<String> stringStreamed = numericCPF.chars().mapToObj(c -> (char) c).map(String::valueOf);
		index = 0;
		return stringStreamed.reduce((a, b) -> {
			index++;
			
			String result = a + b;
			
			if (!IsLastCharHelper.verify(index, numericCPF)) {
				if (CPFConstants.DOT_INDEXES.contains(index)) return result + ".";
				if (CPFConstants.HYPHEN_INDEX == index) return result + "-";
			}
			
			return result;
		}).get();
	}

}
