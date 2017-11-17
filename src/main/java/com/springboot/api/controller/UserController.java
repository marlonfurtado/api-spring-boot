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

import com.springboot.api.model.User;
import com.springboot.api.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/users")
	public ResponseEntity<Collection<User>> findAll() {
		Collection<User> users = userService.findAll();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/users/{id}")
	public ResponseEntity<User> findById(@PathVariable String id) {
		User user = userService.findById(id);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/users", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> save(@RequestBody User user) {
		userService.save(user);
		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/users/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> update(@RequestBody User user) {
		userService.update(user);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/users/{id}")
	public ResponseEntity<User> delete(@PathVariable String id) {
		User user = userService.findById(id);
		if(user == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		userService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
