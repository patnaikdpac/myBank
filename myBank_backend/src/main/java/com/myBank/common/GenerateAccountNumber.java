package com.myBank.common;

import java.time.Year;
import java.util.Random;

public class GenerateAccountNumber {
	public static String generateAccountNumber() {
		int year = Year.now().getValue();
		Random random = new Random();
		return Integer.toString(year).concat(String.format("%08d", random.nextInt(100000)));
	}
}
