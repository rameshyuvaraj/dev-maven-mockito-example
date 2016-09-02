/**
 * 
 */
package com.yuprojects.utility.CheckDigitUtility;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.yuprojects.utility.CheckDigitUtility.AlgorithmImpl.AAdvantgeCheckDigitImpl;
import com.yuprojects.utility.CheckDigitUtility.AlgorithmImpl.AsiaMilesCheckDigitImpl;
import com.yuprojects.utility.CheckDigitUtility.CommonUtils.CommonUtil;
import com.yuprojects.utility.CheckDigitUtility.UtilityImpl.AirLineImpl;
import com.yuprojects.utility.CheckDigitUtility.UtilityInterface.CheckDigitInterface;

/**
 * @author M1023890
 *
 */
public class AirLineImplTest {

	private AirLineImpl airLine;

	@Before
	public void setup() {
		airLine = new AirLineImpl();
		CommonUtil mockCommonUtil = Mockito.mock(CommonUtil.class);
		airLine.setCommonUtil(mockCommonUtil);
		Mockito.when(mockCommonUtil.getAllAirLineCode()).thenReturn(getCodemap());
	}

	@Test
	public void testGetAirlineCheckDigitClassSuccessForAAdvantageImpl() {
		CheckDigitInterface obj = airLine.getAirlineCheckDigitClass("AA");
		boolean result  = false;
		if(obj instanceof AAdvantgeCheckDigitImpl){
			result = true;
		}
		Assert.assertTrue(result);
		
	}

	@Test
	public void testGetAirlineCheckDigitClassSuccessForAsiaMilesImpl() {
		CheckDigitInterface obj = airLine.getAirlineCheckDigitClass("CX");
		boolean result  = false;
		if(obj instanceof AsiaMilesCheckDigitImpl){
			result = true;
		}
		Assert.assertTrue(result);
	}

	@Test
	public void testGetAirlineCheckDigitClassFailCase() {
		CheckDigitInterface result = airLine.getAirlineCheckDigitClass("ABC");
		Assert.assertNull(result);
	}
	
	/**
	 * Mock method to return map containing airline code and corresponding
	 * Algorithm Class.
	 * 
	 * @return
	 */
	private Map<String, String> getCodemap() {
		Map<String, String> codeMap = new HashMap<>();
		codeMap.put("AA", "AAdvantgeCheckDigit");
		codeMap.put("CX", "AsiaMilesCheckDigit");
		return codeMap;
	}

}
