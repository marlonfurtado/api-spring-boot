package com.springboot.api.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.api.model.Movie;
import com.springboot.api.service.MovieService;

@RestController
public class MovieController {

	@Autowired
	MovieService movieService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/movies")
	public ResponseEntity<Collection<Movie>> findAll() {
		Collection<Movie> movies = movieService.findAll();
		return new ResponseEntity<>(movies, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/movies/{id}")
	public ResponseEntity<Movie> findById(@PathVariable String id) {
		Movie movie = movieService.findById(id);
		return new ResponseEntity<>(movie, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/movies", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Movie> save(@RequestBody Movie movie) {
		movieService.save(movie);
		return new ResponseEntity<>(movie, HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/movies/{id}")
	public ResponseEntity<Movie> update(@RequestBody Movie movie) {
		movieService.update(movie);
		return new ResponseEntity<>(movie, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/movies/{id}")
	public ResponseEntity<Movie> delete(@PathVariable String id) {
		Movie movie = movieService.findById(id);
		if(movie == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		movieService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
