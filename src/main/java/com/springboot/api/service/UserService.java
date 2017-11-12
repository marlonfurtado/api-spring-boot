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
	
	public User findById(String id) {
		return userRepository.findOne(id);
	}
	
	public User save(User user) {
		return userRepository.save(user);
	}

	public User update(User user) {
		return userRepository.insert(user);
	}
	
	public void delete(String id) {
		userRepository.delete(id);
	}
}
