package com.ty.foodappservice.exception;

public class IdNotFoundException extends RuntimeException{
private String message="Given Id Not Found";
	
	public IdNotFoundException() {
		
	}

	public IdNotFoundException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}

}
