/**
 * 
 */
package com.yuprojects.utility.CheckDigitUtility;

import org.junit.Assert;
import org.junit.Test;

import com.yuprojects.utility.CheckDigitUtility.UtilityImpl.ValidateAccountNumberImpl;
import com.yuprojects.utility.CheckDigitUtility.UtilityInterface.ValidateAccountNumberInterface;

/**
 * @author M1023890
 *
 */
public class ValidateAccountNumberImplTest {

	ValidateAccountNumberInterface validateAccountNumber = new ValidateAccountNumberImpl();

	@Test
	public void testValidateAccountNumberSuccess() {
		boolean result = validateAccountNumber.validateAccountNumber("AA", "AX65266");
		Assert.assertTrue(result);
	}

	@Test
	public void testValidateAccountNumberFailure() {
		boolean result = validateAccountNumber.validateAccountNumber("AA", "GS12345");
		Assert.assertFalse(result);
	}

}
