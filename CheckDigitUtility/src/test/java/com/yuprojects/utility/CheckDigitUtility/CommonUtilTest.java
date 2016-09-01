/**
 * 
 */
package com.yuprojects.utility.CheckDigitUtility;

import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.yuprojects.utility.CheckDigitUtility.CommonUtils.CommonUtil;

/**
 * @author M1023890
 *
 */
public class CommonUtilTest {

	private CommonUtil commonUtil = new CommonUtil();

	@Test
	public void testGetAllAirLineCode() {
		Map<String, String> allAirLineCodes = commonUtil.getAllAirLineCode();
		Assert.assertNotNull(allAirLineCodes);
	}
	@Test
	public void testGetEBCDICcode(){
		Map<Character,Integer> codeMap= commonUtil.getEBCDICcode();
		Assert.assertNotNull(codeMap);
	}
}
