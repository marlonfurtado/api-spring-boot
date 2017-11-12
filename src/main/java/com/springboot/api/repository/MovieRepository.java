package com.springboot.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.springboot.api.model.Movie;

public interface MovieRepository extends MongoRepository<Movie, String> {
	
}
