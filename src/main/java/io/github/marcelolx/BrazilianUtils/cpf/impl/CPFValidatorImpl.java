package io.github.marcelolx.brazilianutils.cpf.impl;

import static io.github.marcelolx.brazilianutils.cpf.consts.CPFConstants.BLACKLIST;
import static io.github.marcelolx.brazilianutils.cpf.consts.CPFConstants.CHECK_DIGITS;
import static io.github.marcelolx.brazilianutils.cpf.consts.CPFConstants.CPF_LENGTH;

import io.github.marcelolx.brazilianutils.cpf.CPFValidator;
import io.github.marcelolx.brazilianutils.helper.OnlyNumbersHelper;

public class CPFValidatorImpl implements CPFValidator {

	public Boolean isValid(String cpf) {

		if (cpf == null) {
			return false;			
		}
		
		String numericCPF = OnlyNumbersHelper.get(cpf);
		
		return isValidLength(numericCPF) && !belongsToBlacklist(numericCPF);
	}
	
	private Boolean isValidLength(String cpf) {
		return cpf.length() == CPF_LENGTH;
	}
	
	private Boolean belongsToBlacklist(String cpf) {
		return BLACKLIST.contains(cpf);
	}
	
	private Boolean isValidChecksum(String cpf) {
		return CHECK_DIGITS.stream().allMatch(verifierPos -> {
			//TODO: Implementar generateChecksum
			
			
			return false;
		});
	}

}
