package com.ty.foodappservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.foodappservice.dto.Customer;
import com.ty.foodappservice.dto.ResponseStructure;
import com.ty.foodappservice.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping
	public ResponseEntity<ResponseStructure<Customer>> saveCustomer(@RequestBody Customer customer) {
		return customerService.saveCustomer(customer);
	}

	@GetMapping("/{email}")
	public ResponseEntity<ResponseStructure<Customer>> findByEmail(@PathVariable String email) {
		return customerService.findByEmail(email);
	}

	@GetMapping
	public ResponseEntity<ResponseStructure<Customer>> findByPhone(@RequestParam long phone) {
		return customerService.findByPhone(phone);
	}

}
