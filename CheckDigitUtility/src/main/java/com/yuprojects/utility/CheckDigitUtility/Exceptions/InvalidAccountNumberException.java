package com.yuprojects.utility.CheckDigitUtility.Exceptions;

public class InvalidAccountNumberException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidAccountNumberException() {
		super();
	}

	public InvalidAccountNumberException(String message) {
		super(message);
	}

	public InvalidAccountNumberException(Throwable cause) {
		super(cause);
	}

}
