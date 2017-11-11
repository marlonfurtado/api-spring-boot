package com.springboot.api.repository;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.api.model.User;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public Collection<User> findAll() {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			Collection<User> user = objectMapper.readValue(new File("data/users.json"), new TypeReference<Collection<User>>(){});
			
	        logger.info(user.toString());
			return user;
		} catch (IOException e) {
			logger.error(e.getMessage());
			return null;
		}
	}
	
	public void findById(String id) {

	}

	public void save(User user) {

	}

	public void delete(String id) {

	}
}