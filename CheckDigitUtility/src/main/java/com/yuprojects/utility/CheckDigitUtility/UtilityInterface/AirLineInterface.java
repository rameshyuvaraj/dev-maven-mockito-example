package com.yuprojects.utility.CheckDigitUtility.UtilityInterface;

public interface AirLineInterface {

	public boolean isValidAirLineCode(String airlineCode);
	
	public String getAirlineCheckDigitClass(String airlineCode);
	
}
