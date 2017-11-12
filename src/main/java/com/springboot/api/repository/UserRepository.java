package com.springboot.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.springboot.api.model.User;

public interface UserRepository extends MongoRepository<User, String> {
	
}
