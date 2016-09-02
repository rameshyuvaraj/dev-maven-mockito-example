/**
 * 
 */
package com.yuprojects.utility.CheckDigitUtility.UtilityImpl;

import com.yuprojects.utility.CheckDigitUtility.UtilityInterface.CheckDigitInterface;
import com.yuprojects.utility.CheckDigitUtility.UtilityInterface.ValidateAccountNumberInterface;

/**
 * @author M1023890
 *
 */
public class ValidateAccountNumberImpl implements ValidateAccountNumberInterface {

	private AirLineImpl airLines;

	public AirLineImpl getAirLines() {
		return airLines;
	}

	public void setAirLines(AirLineImpl airLines) {
		this.airLines = airLines;
	}

	/**
	 * Contains the main funtion to check the given airline code and account
	 * number are authentic.
	 * 
	 * @return true if valid account number for the given airline code.
	 */
	public boolean validateAccountNumber(String airLineCode, String accountNumber) {
		boolean isValidAccoutNumber = false;
		CheckDigitInterface chekDigitObjectInstance = airLines
				.getAirlineCheckDigitClass(airLineCode);
		if (chekDigitObjectInstance != null) {
			isValidAccoutNumber = chekDigitObjectInstance.isValidMemberAccountNumber(accountNumber);
		}
		return isValidAccoutNumber;
	}

}
