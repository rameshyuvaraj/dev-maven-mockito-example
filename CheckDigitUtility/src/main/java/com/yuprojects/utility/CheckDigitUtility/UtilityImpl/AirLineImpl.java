/**
 * 
 */
package com.yuprojects.utility.CheckDigitUtility.UtilityImpl;

import java.util.Map;

import com.yuprojects.utility.CheckDigitUtility.CommonUtils.CommonUtil;
import com.yuprojects.utility.CheckDigitUtility.UtilityInterface.AirLineInterface;

/**
 * @author M1023890
 *
 */
public class AirLineImpl implements AirLineInterface {

	/**
	 * CommonUtil class variable contains few utilities.
	 */
	private CommonUtil commonUtil = new CommonUtil();

	/**
	 * Checks if the airline code is valid airline code.
	 * 
	 */
	public boolean isValidAirLineCode(String airlineCode) {
		boolean validity = false;
		Map<String, String> allAirLineCodes = commonUtil.getAllAirLineCode();
		if(allAirLineCodes.containsKey(airlineCode)){
			validity = true;
		}
		return validity;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * aero.sita.utility.CheckDigitUtility.UtilityInterface.AirLineInterface#
	 * getAirlineCheckDigitClass(java.lang.String)
	 */
	public String getAirlineCheckDigitClass(String airlineCode) {
		String className = "";
		Map<String, String> allAirLineCodes = commonUtil.getAllAirLineCode();
		if(allAirLineCodes.containsKey(airlineCode)){
			className = allAirLineCodes.get(airlineCode);
		}
		return className;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * aero.sita.utility.CheckDigitUtility.UtilityInterface.AirLineInterface#
	 * getAllAirLineCode()
	 */


}
