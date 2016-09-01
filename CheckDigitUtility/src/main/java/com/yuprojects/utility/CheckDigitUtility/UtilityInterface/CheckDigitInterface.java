/**
 * 
 */
package com.yuprojects.utility.CheckDigitUtility.UtilityInterface;

/**
 * @author M1023890
 *
 */
public interface CheckDigitInterface{

	public int getCheckDigit(String accountNumber);
	
	public boolean isValidMemberAccountNumber(String accountNumber);

}
