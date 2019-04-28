package io.github.marcelolx.brazilianutils.cpf.impl;

import static io.github.marcelolx.brazilianutils.cpf.consts.CPFConstants.CPF_LENGTH;
import static io.github.marcelolx.brazilianutils.cpf.consts.CPFConstants.HYPHEN_INDEX;
import static io.github.marcelolx.brazilianutils.cpf.consts.CPFConstants.dotIndexes;
import static io.github.marcelolx.brazilianutils.helper.OnlyNumbersHelper.get;

import io.github.marcelolx.brazilianutils.cpf.CPFFormatter;
import io.github.marcelolx.brazilianutils.helper.IsLastCharHelper;

public class CPFFormatterImpl implements CPFFormatter {

	@Override
	public String format(String cpf) {

		if (cpf == null || cpf.isBlank()) {
			return "";
		}

		String numericCPF = get(cpf);

		if (numericCPF.length() > CPF_LENGTH) {
			numericCPF = numericCPF.substring(0, CPF_LENGTH);
		}

		String[] splittedCPF = numericCPF.split("");
		String result = "";

		for (int index = 0; index < splittedCPF.length; index++) {
			result = formatCPF(index, numericCPF, result, splittedCPF[index]);
		}

		return result;
	}

	private String formatCPF(Integer index, String numericCPF, String acumulator, String currentValue) {
		String result = acumulator + currentValue;

		if (!IsLastCharHelper.verify(index, numericCPF)) {
			result = formatToDotHyphenOrDoNothing(index, result);
		}

		return result;
	}

	private String formatToDotHyphenOrDoNothing(Integer index, String cpf) {

		String result = cpf;

		if (dotIndexes().contains(index))
			result += ".";
		if (HYPHEN_INDEX.equals(index))
			result += "-";

		return result;
	}

}
