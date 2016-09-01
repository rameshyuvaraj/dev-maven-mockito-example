/**
 * 
 */
package com.yuprojects.utility.CheckDigitUtility.AlgorithmImpl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.yuprojects.utility.CheckDigitUtility.UtilityInterface.CheckDigitInterface;

/**
 * @author M1023890
 *
 */
public class AsiaMilesCheckDigitImpl implements CheckDigitInterface {

	/**
	 * Checks if valid asia miles account number.
	 * 
	 * @return true if valid member account
	 */
	public boolean isValidMemberAccountNumber(String accountNumber) {
		boolean isValidAccount = false;
		int checkDigit = -1;
		int remainder = -2;
		if (accountNumber != null && !(accountNumber.isEmpty())) {
			if (isAccountNumberValidAsiaMilesFormat(accountNumber)) {
				checkDigit = getCheckDigit(accountNumber);
				remainder = calculateRemainder(accountNumber);
				if (remainder == checkDigit) {
					isValidAccount = true;
				}
			}
		}
		return isValidAccount;
	}

	/**
	 * Checks if the Account number is in valid Asia miles format.
	 * 
	 * @param accountNumber
	 * @return true if valid
	 */
	public boolean isAccountNumberValidAsiaMilesFormat(String accountNumber) {
		boolean isValid = false;
		Pattern patternFormat = Pattern.compile("[0-9]{10}");
		Matcher matcher = patternFormat.matcher(accountNumber);
		isValid = matcher.matches();
		if (isValid) {
			Pattern gsCharCheck = Pattern.compile("[1-9]{1}");
			Matcher gsmatcher = gsCharCheck.matcher(accountNumber.substring(0, 1));
			isValid = gsmatcher.matches();
		}
		return isValid;
	}

	/**
	 * Return check digit.
	 * 
	 * @return the check digit.
	 */
	public int getCheckDigit(String accountNumber) {
		return Integer.parseInt(accountNumber) % 10;
	}

	/**
	 * Calulates the remainder which is the check digit expected value.
	 * 
	 * @param accNum
	 * @return check digit expected value.
	 */
	private int calculateRemainder(String accNum) {
		int remainder = -2;
		long num = Long.parseLong(accNum);
		long sum = 0;
		for (int i = 1; i < 10; i++) {
			sum += (getNthDigitFromLeft(num, 10, i) * (10 - i));
		}
		remainder = (int) (sum % 10);
		return remainder;
	}

	/**
	 * Gets nth digit
	 * 
	 * @param number
	 * @param base
	 * @param nth
	 * @return the nth digit of the number for the base 10.
	 */
	private int getNthDigitFromLeft(long number, int base, int nth) {
		return (int) ((number / Math.pow(base, nth)) % base);
	}

}
