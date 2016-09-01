/**
 * 
 */
package com.yuprojects.utility.CheckDigitUtility.CommonUtils;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * @author M1023890
 *
 */
public class CommonUtil {

	/**
	 * Gets all the airline code and corresponding check digit algorithm name.
	 * 
	 * @return  Map<String, String>  airline code and corresponding check digit algorithm name.
	 */
	public Map<String, String> getAllAirLineCode() {
		Map<String, String> allAirLineCodes = new HashMap<String, String>();
		ResourceBundle bundle = ResourceBundle.getBundle("properties.airLineConfig");
		if(bundle !=null){
			Enumeration<String> keys = bundle.getKeys();
			while(keys.hasMoreElements()){
				String key = keys.nextElement();
				String value = bundle.getString(key);
				allAirLineCodes.put(key, value);
			}
		}
		return allAirLineCodes;
	}
	
	/**
	 * Gets all the codes from properties file EBCDIC_Code.
	 * 
	 * @return Map<Character, Integer> codeMap
	 */
	public Map<Character, Integer> getEBCDICcode() {
		Map<Character, Integer> EBCDIC_CODE_MAP = new HashMap<Character, Integer>();
		ResourceBundle bundle = ResourceBundle.getBundle("properties.EBCDIC_Code");
		if (bundle != null) {
			Enumeration<String> keys = bundle.getKeys();
			while (keys.hasMoreElements()) {
				String key = keys.nextElement();
				String value = bundle.getString(key);
				EBCDIC_CODE_MAP.put(key.charAt(0), Integer.parseInt(value));
			}
		}
		return EBCDIC_CODE_MAP;
	}
	
}
