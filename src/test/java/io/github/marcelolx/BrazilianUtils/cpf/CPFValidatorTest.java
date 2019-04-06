package io.github.marcelolx.brazilianutils.cpf;

import static io.github.marcelolx.brazilianutils.cpf.consts.CPFConstants.BLACKLIST;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import io.github.marcelolx.brazilianutils.cpf.impl.CPFValidatorImpl;

public class CPFValidatorTest {
	
	private CPFValidator cpfValidator;
	
	@Before
	public void setUp() {
		cpfValidator = new CPFValidatorImpl();
	}

	@Test
	public void testWhenItIsOnTheBlackList() {
		BLACKLIST.forEach(cpf -> assertFalse(cpfValidator.isValid(cpf)));
	}
	
	@Test
	public void testWhenIsAEmptyString() {
		assertFalse(cpfValidator.isValid(""));
	}
	
	@Test
	public void testWhenIsNull() {
		assertFalse(cpfValidator.isValid(null));
	}
	
	@Test
	public void testWhenDontMatchWithCPFLength() {
		assertFalse(cpfValidator.isValid("123456"));
	}
	
	@Test
	public void testWhenContainsOnlyLettersOrSpecialCharacters() {
		assertFalse(cpfValidator.isValid("abcabcabcde"));
	}
	
	@Test
	public void testWhenIsACPFInvalid() {
		assertFalse(cpfValidator.isValid("11257245286"));
	}
	
	@Test
	public void testWhenIsACPFValidWithoutMask() {
		assertTrue(cpfValidator.isValid("40364478829"));
	}
	
	@Test
	public void testWhenIsACPFValidWithMask() {
		assertTrue(cpfValidator.isValid("962.718.458-60"));
	}

}
