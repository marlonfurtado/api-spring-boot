package com.springboot.api.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.api.model.Movie;
import com.springboot.api.repository.MovieRepository;

@Service
public class MovieService {

	@Autowired
	MovieRepository movieRepository;
	
	public Collection<Movie> findAll() {
		return movieRepository.findAll();
	}
	
	public Movie findById(String id) {
		return movieRepository.findOne(id);
	}
	
	public Movie save(Movie movie) {
		return movieRepository.save(movie);
	}

	public Movie update(Movie movie) {
		return movieRepository.insert(movie);
	}
	
	public void delete(String id) {
		movieRepository.delete(id);
	}
}
