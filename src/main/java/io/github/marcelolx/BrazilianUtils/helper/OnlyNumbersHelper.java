package io.github.marcelolx.brazilianutils.helper;

public class OnlyNumbersHelper {

	public static String get(String value) {
		return value.replaceAll("\\D+","");
	}
	
	private OnlyNumbersHelper() {		
	}
	
}
