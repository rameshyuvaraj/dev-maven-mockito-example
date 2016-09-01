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
	
	
	
	/**
	 * Contains the main funtion to check the given airline code and account
	 * number are authentic.
	 * 
	 * @return true if valid account number for the given airline code.
	 */
	@SuppressWarnings("unchecked")
	public boolean validateAccountNumber(String airLineCode, String accountNumber) {
		boolean isValidAirLineCode = false;
		boolean isValidAccoutNumber = false;
		isValidAirLineCode = airLines.isValidAirLineCode(airLineCode);
		if (isValidAirLineCode) {
			String className = airLines.getAirlineCheckDigitClass(airLineCode);
			Class<CheckDigitInterface> checkDigitObject = null;
			CheckDigitInterface chekDigitObjectInstance = null;
			try {
				checkDigitObject = (Class<CheckDigitInterface>) Class
						.forName("aero.sita.utility.CheckDigitUtility.AlgorithmImpl." + className + "Impl");
				chekDigitObjectInstance = (CheckDigitInterface) checkDigitObject.newInstance();
			} catch (ClassNotFoundException |InstantiationException| IllegalAccessException e) {
				e.printStackTrace();
			} /*catch () {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}*/
			if (chekDigitObjectInstance != null) {
				isValidAccoutNumber = chekDigitObjectInstance.isValidMemberAccountNumber(accountNumber);
			}
		}
		return isValidAccoutNumber;
	}

}
