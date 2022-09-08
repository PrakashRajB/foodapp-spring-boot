package com.ty.foodappservice.dao;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.foodappservice.dto.User;
import com.ty.foodappservice.repository.UserRepository;

@Repository
public class UserDao {

	@Autowired
	private UserRepository userRepository;

	public User saveUser(User user) {
		return userRepository.save(user);
	}

	public User getUserById(int id) {
		Optional<User> optional = userRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}

	public boolean deleteUserById(int id) {
		Optional<User> optional = userRepository.findById(id);
		if (optional.isPresent()) {
			userRepository.delete(optional.get());
			return true;
		} else {
			return false;
		}
	}

	public User findUserByEmail(String email) {
		Optional<User> optional = userRepository.findByEmail(email);
		if(optional.isPresent()) {
			return optional.get();
		}else {
			return null;
		}
	}

	public User findUserByPhone(long phone) {
		Optional<User> optional = userRepository.findByPhone(phone);
		if(optional.isPresent()) {
			return optional.get();
		}else {
			return null;
		}
	}

}
