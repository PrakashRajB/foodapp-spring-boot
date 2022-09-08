package com.ty.foodappservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.foodappservice.dto.ResponseStructure;
import com.ty.foodappservice.dto.User;
import com.ty.foodappservice.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping
	public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody User user) {
		return userService.saveUser(user);
	}

	@GetMapping
	public ResponseEntity<ResponseStructure<User>> getUserById(@RequestParam int id) {
		return userService.getUserById(id);
	}

	@DeleteMapping
	public ResponseEntity<ResponseStructure<String>> deleteUserById(@RequestParam int id) {
		return userService.deleteUserById(id);
	}

	@GetMapping("/{email}/{password}")
	public ResponseEntity<ResponseStructure<User>> validateUserByEmail(@PathVariable String email,@PathVariable String password){
		return userService.validateUserByEmail(email, password);
	}

}
