/**
 * 
 */
package com.yuprojects.utility.CheckDigitUtility.UtilityImpl;

import java.util.Map;

import com.yuprojects.utility.CheckDigitUtility.CommonUtils.CommonUtil;
import com.yuprojects.utility.CheckDigitUtility.UtilityInterface.AirLineInterface;
import com.yuprojects.utility.CheckDigitUtility.UtilityInterface.CheckDigitInterface;

/**
 * @author M1023890
 *
 */
public class AirLineImpl implements AirLineInterface {

	/**
	 * CommonUtil class variable contains few utilities.
	 */
	private CommonUtil commonUtil;

	public CommonUtil getCommonUtil() {
		return commonUtil;
	}

	public void setCommonUtil(CommonUtil commonUtil) {
		this.commonUtil = commonUtil;
	}

	/**
	 * Returns the instance of Algorithm impl class with respect to the air line
	 * code. 
	 * input: AirlineCode airline code.
	 * @return checkDigitObjectInstance instance of Algorithm impl class.
	 */
	@SuppressWarnings("unchecked")
	public CheckDigitInterface getAirlineCheckDigitClass(String airlineCode) {
		String className = "";
		Class<CheckDigitInterface> checkDigitObject = null;
		CheckDigitInterface checkDigitObjectInstance = null;
		Map<String, String> allAirLineCodes = commonUtil.getAllAirLineCode();
		if (allAirLineCodes.containsKey(airlineCode)) {
			className = allAirLineCodes.get(airlineCode);
			try {
				checkDigitObject = (Class<CheckDigitInterface>) Class.forName(
						"com.yuprojects.utility.CheckDigitUtility.AlgorithmImpl." + className + "Impl");
				checkDigitObjectInstance = (CheckDigitInterface) checkDigitObject.newInstance();
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return checkDigitObjectInstance;
	}
}
