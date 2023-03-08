package com.bookmyshow.exception;

public class ExceptionHandling extends RuntimeException {

	
	private static final long serialVersionUID = 1L;

	public ExceptionHandling() {

	}
	
	public ExceptionHandling(String message) {
		
		super(message);
	}

}
