/**
 * 
 */
package com.yuprojects.utility.CheckDigitUtility;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.yuprojects.utility.CheckDigitUtility.AlgorithmImpl.AAdvantgeCheckDigitImpl;
import com.yuprojects.utility.CheckDigitUtility.AlgorithmImpl.AsiaMilesCheckDigitImpl;
import com.yuprojects.utility.CheckDigitUtility.UtilityImpl.AirLineImpl;
import com.yuprojects.utility.CheckDigitUtility.UtilityImpl.ValidateAccountNumberImpl;
import com.yuprojects.utility.CheckDigitUtility.UtilityInterface.ValidateAccountNumberInterface;

/**
 * @author M1023890
 *
 */
public class ValidateAccountNumberImplTest {

	private ValidateAccountNumberImpl validateAccountNumber;

	AirLineImpl mockAirLines;

	@Before
	public void initialize() {
		validateAccountNumber = new ValidateAccountNumberImpl();
		mockAirLines = Mockito.mock(AirLineImpl.class);
		validateAccountNumber.setAirLines(mockAirLines);
	}

	@Test
	public void testValidateAccountNumberOfAAdvantageValidNumber() {
		Mockito.when(mockAirLines.getAirlineCheckDigitClass(Mockito.anyString()))
				.thenReturn(new AAdvantgeCheckDigitImpl());
		boolean result = validateAccountNumber.validateAccountNumber("AA", "AX65266");
		Assert.assertTrue(result);
	}

	@Test
	public void testValidateAccountNumberOfAAdvantageInvalidNumber() {
		Mockito.when(mockAirLines.getAirlineCheckDigitClass(Mockito.anyString()))
				.thenReturn(new AAdvantgeCheckDigitImpl());
		boolean result = validateAccountNumber.validateAccountNumber("AA", "GS12342");
		Assert.assertFalse(result);
	}

	@Test
	public void testValidateAccountNumberOfAsiaMilesValidNumber() {
		Mockito.when(mockAirLines.getAirlineCheckDigitClass(Mockito.anyString()))
				.thenReturn(new AsiaMilesCheckDigitImpl());
		boolean result = validateAccountNumber.validateAccountNumber("CX", "1282084709");
		Assert.assertTrue(result);
	}

	@Test
	public void testValidateAccountNumberOfAsiaMilesInvalidNumber() {
		Mockito.when(mockAirLines.getAirlineCheckDigitClass(Mockito.anyString()))
				.thenReturn(new AAdvantgeCheckDigitImpl());
		boolean result = validateAccountNumber.validateAccountNumber("CX", "1282094709");
		Assert.assertFalse(result);
	}

}
