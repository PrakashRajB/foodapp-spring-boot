package com.ty.foodappservice.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.foodappservice.dto.Customer;
import com.ty.foodappservice.repository.CustomerRepository;

@Repository
public class CustomerDao {

	@Autowired
	private CustomerRepository customerRepository;

	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	public Customer findByEmail(String email) {
		return customerRepository.findByEmail(email);
	}

	public Customer findByPhone(long phone) {
		return customerRepository.findByPhone(phone);
	} 

}
