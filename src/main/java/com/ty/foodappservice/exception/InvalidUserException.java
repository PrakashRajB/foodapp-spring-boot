package com.ty.foodappservice.exception;

public class InvalidUserException extends RuntimeException{

	private String message="Invalid Email Id";

	public InvalidUserException(String message) {
		this.message = message;
	}
	
	public InvalidUserException() {
		
	}
	
	@Override
	public String getMessage() {
		return message;
	}
	
	
}
