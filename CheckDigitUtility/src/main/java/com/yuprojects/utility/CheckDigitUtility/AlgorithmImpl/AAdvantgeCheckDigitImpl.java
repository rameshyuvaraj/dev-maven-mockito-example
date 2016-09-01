/**
 * 
 */
package com.yuprojects.utility.CheckDigitUtility.AlgorithmImpl;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.yuprojects.utility.CheckDigitUtility.CommonUtils.CommonUtil;
import com.yuprojects.utility.CheckDigitUtility.UtilityInterface.CheckDigitInterface;

/**
 * @author M1023890
 *
 */
public class AAdvantgeCheckDigitImpl implements CheckDigitInterface {

	/**
	 * CommonUtil class variable contains few utilities.
	 */
	private CommonUtil commonUtil = new CommonUtil();

	/**
	 * Checks account number is valid member account.
	 * 
	 * @return true if valid else false.
	 */
	public boolean isValidMemberAccountNumber(String accountNumber) {
		boolean isValidAccount = false;
		int checkDigit = -1;
		int remainder = -2;
		if (accountNumber != null && !(accountNumber.isEmpty())) {
			if (isAccountNumberValidAAdvantageFormat(accountNumber)) {
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
	 * Checks if it is in AAdvantage account number format.
	 * 
	 * @param accountNumber
	 * @return true if it is in AAdvantage account number format, else false
	 */
	public boolean isAccountNumberValidAAdvantageFormat(String accountNumber) {
		boolean isValid = false;
		Pattern patternFormat = Pattern.compile("[A-Z_0-9&&[^IOQZ]]{7}");
		Matcher matcher = patternFormat.matcher(accountNumber);
		isValid = matcher.matches();
		if (isValid) {
			Pattern gsCharCheck = Pattern.compile("[A-Z_0-9&&[^GS]]{6}");
			Matcher gsmatcher = gsCharCheck.matcher(accountNumber.substring(1));
			isValid = gsmatcher.matches();
		}
		return isValid;
	}

	/**
	 * Get the account number's check digit.
	 * 
	 * @return account number's check digit is returned.
	 */
	public int getCheckDigit(String accountNumber) {
		return Integer.parseInt(accountNumber.substring(accountNumber.length() - 1, accountNumber.length()));
	}

	/**
	 * Returns value for the formula (P1+P3) * 2 + (P3+P5) * 2 + (P4+P6) * 2 %
	 * 10. p1=accNum.charAt(0) and respectively.
	 * 
	 * @param accNum
	 * @return value of the above formula.
	 */
	private int calculateRemainder(String accNum) {
		Map<Character, Integer> codeMap = commonUtil.getEBCDICcode();
		int remainder = -2;
		remainder = (((codeMap.get(accNum.charAt(0))) + (codeMap.get(accNum.charAt(2)))) * 2
				+ ((codeMap.get(accNum.charAt(2))) + (codeMap.get(accNum.charAt(4)))) * 2
				+ ((codeMap.get(accNum.charAt(3))) + (codeMap.get(accNum.charAt(5)))) * 2) % 10;
		return remainder;
	}

}
