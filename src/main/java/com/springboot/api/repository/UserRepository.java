package com.springboot.api.repository;

import java.util.Collection;

import com.springboot.api.model.User;

public interface UserRepository {

	Collection<User> findAll();

	void findById(String id);
	
	void save(User user);
	
	void delete(String id);
	
}
