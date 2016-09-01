/**
 * 
 */
package com.yuprojects.utility.CheckDigitUtility;

import org.junit.Assert;
import org.junit.Test;

import com.yuprojects.utility.CheckDigitUtility.AlgorithmImpl.AAdvantgeCheckDigitImpl;

/**
 * @author M1023890
 *
 */
public class AAdvantageCheckDigitImplTest {

	private AAdvantgeCheckDigitImpl aAdvantageCD = new AAdvantgeCheckDigitImpl();

	@Test
	public void testIsValidMemberAccountNumberSuccess() {
		boolean validity = aAdvantageCD.isValidMemberAccountNumber("AX65266");
		Assert.assertTrue(validity);
	}

	@Test
	public void testIsValidMemberAccountNumberFailCase() {
		boolean validity = aAdvantageCD.isValidMemberAccountNumber("");
		Assert.assertFalse(validity);
	}

	@Test
	public void testGetCheckDigitSuccess() {
		int result = aAdvantageCD.getCheckDigit("AX65266");
		Assert.assertEquals(6, result);
	}

	@Test
	public void testIsAccountNumberInAAdvantagePattern() {
		boolean isValid = aAdvantageCD.isAccountNumberValidAAdvantageFormat("AX65266");
		Assert.assertTrue(isValid);
	}

}
