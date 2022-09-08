package com.ty.foodappservice.exception;

public class InvalidCredentialsException extends RuntimeException{
	
	private String message="Invalid Password";

	public InvalidCredentialsException(String message) {
		this.message = message;
	}
	
	public InvalidCredentialsException() {
		
	}
	
	@Override
	public String getMessage() {
		return message;
	}

}
