/**
 * 
 */
package com.yuprojects.utility.CheckDigitUtility;

import org.junit.Assert;
import org.junit.Test;

import com.yuprojects.utility.CheckDigitUtility.UtilityImpl.AirLineImpl;
import com.yuprojects.utility.CheckDigitUtility.UtilityInterface.AirLineInterface;

/**
 * @author M1023890
 *
 */
public class AirLineImplTest {

	AirLineInterface airLine = new AirLineImpl();
	
	@Test
	public void testIsValidAirLineCodeSuccess(){
		boolean result = airLine.isValidAirLineCode("AA");
		Assert.assertTrue(result);
	}
	
	@Test
	public void testIsValidAirLineCodeFailure(){
		boolean result = airLine.isValidAirLineCode("BA");
		Assert.assertFalse(result);
	}
	
	@Test
	public void testGetAirlineCheckDigitClassSuccess(){
		String result = airLine.getAirlineCheckDigitClass("AA");
		Assert.assertEquals(result, "AAdvantgeCheckDigit");
	}
	
	@Test
	public void testGetAirlineCheckDigitClassFail(){
		String result = airLine.getAirlineCheckDigitClass("BA");
		Assert.assertEquals(result,"");
	}
	
}
