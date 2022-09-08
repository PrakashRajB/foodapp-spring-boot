package com.ty.foodappservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ty.foodappservice.dto.ResponseStructure;

@ControllerAdvice
public class FoodAppExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> idHandler(IdNotFoundException exception) {

		ResponseStructure<String> responseStructure = new ResponseStructure<>();

		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Not Found");
		responseStructure.setData(exception.getMessage());

		return new ResponseEntity<>(responseStructure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(InvalidUserException.class)
	public ResponseEntity<ResponseStructure<String>> emailHandler(InvalidUserException exception) {

		ResponseStructure<String> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Invalid Email");
		responseStructure.setData(exception.getMessage());

		return new ResponseEntity<>(responseStructure, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InvalidCredentialsException.class)
	public ResponseEntity<ResponseStructure<String>> passwordHandler(InvalidCredentialsException exception) {
		
		ResponseStructure<String> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.UNAUTHORIZED.value());
		responseStructure.setMessage("Invalid password");
		responseStructure.setData(exception.getMessage());

		return new ResponseEntity<>(responseStructure, HttpStatus.UNAUTHORIZED);
	}

}