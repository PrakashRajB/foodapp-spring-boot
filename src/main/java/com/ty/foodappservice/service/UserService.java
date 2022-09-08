package com.ty.foodappservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.foodappservice.dao.UserDao;
import com.ty.foodappservice.dto.ResponseStructure;
import com.ty.foodappservice.dto.User;
import com.ty.foodappservice.exception.IdNotFoundException;
import com.ty.foodappservice.exception.InvalidCredentialsException;
import com.ty.foodappservice.exception.InvalidUserException;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	public ResponseEntity<ResponseStructure<User>> saveUser(User user) {
		ResponseStructure<User> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("SUCCESS");
		responseStructure.setData(userDao.saveUser(user));
		return new ResponseEntity<>(responseStructure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<User>> getUserById(int id) {
		ResponseStructure<User> responseStructure = new ResponseStructure<>();

		User user = userDao.getUserById(id);
		if (user != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("SUCCESS");
			responseStructure.setData(user);
			return new ResponseEntity<>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("User ID : "+id+" Not Found");
		}
	}

	public ResponseEntity<ResponseStructure<String>>  deleteUserById(int id) {
		ResponseStructure<String> responseStructure = new ResponseStructure<>();
		if (userDao.deleteUserById(id)) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("SUCCESS");
			responseStructure.setData("User ID : " + id + " Deleted Successfully");
			return new ResponseEntity<>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("User ID : "+id+" Not Found");
		}
	}

	public ResponseEntity<ResponseStructure<User>> validateUserByEmail(String email, String password) {
		ResponseStructure<User> responseStructure = new ResponseStructure<>();

		User user = userDao.findUserByEmail(email);
		if (user != null) {
			if (user.getPassword().equals(password)) {
				responseStructure.setStatus(HttpStatus.OK.value());
				responseStructure.setMessage("Login Successful");
				responseStructure.setData(user);
				return new ResponseEntity<>(responseStructure, HttpStatus.OK);
			} else {
				throw new InvalidCredentialsException("Invalid Password : "+password);
			}

		} else {
			throw new InvalidUserException("Invalid Email Id : "+email);
		}
	}
}
