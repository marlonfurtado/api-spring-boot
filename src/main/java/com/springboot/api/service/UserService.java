package com.springboot.api.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.api.model.User;
import com.springboot.api.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public Collection<User> findAll() {
		return userRepository.findAll();
	}
	
	public void findById(String id) {
		
	}

	public void save(User user) {
		
	}

	public void delete(User user) {
		
	}
}
