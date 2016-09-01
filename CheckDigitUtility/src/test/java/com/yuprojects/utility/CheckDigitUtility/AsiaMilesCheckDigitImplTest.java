/**
 * 
 */
package com.yuprojects.utility.CheckDigitUtility;

import org.junit.Assert;
import org.junit.Test;

import com.yuprojects.utility.CheckDigitUtility.AlgorithmImpl.AsiaMilesCheckDigitImpl;

/**
 * @author M1023890
 *
 */
public class AsiaMilesCheckDigitImplTest {

	AsiaMilesCheckDigitImpl asiaMiles = new AsiaMilesCheckDigitImpl();

	@Test
	public void testGetCheckDigitSuccess() {
		int checkDigit = asiaMiles.getCheckDigit("1282084709");
		Assert.assertEquals(9, checkDigit);
	}

	@Test
	public void testIsValidMemberAccountNumberSuccess() {
		boolean result = asiaMiles.isValidMemberAccountNumber("1282084709");
		Assert.assertTrue(result);
	}

	@Test
	public void testIsValidMemberAccountNumberFailure() {
		boolean result = asiaMiles.isValidMemberAccountNumber("282084709");
		Assert.assertFalse(result);
	}

	@Test
	public void testIsAccountNumberValidAsiaMilesFormatSuccess() {
		boolean result = asiaMiles.isAccountNumberValidAsiaMilesFormat("1282084709");
		Assert.assertTrue(result);
	}

	@Test
	public void testIsAccountNumberValidAsiaMilesFormatFailure() {
		boolean result = asiaMiles.isAccountNumberValidAsiaMilesFormat("82084709");
		Assert.assertFalse(result);
	}
}
