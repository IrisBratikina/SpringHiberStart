package org.itstep.controller;

import org.itstep.dao.pojo.User;
import org.itstep.service.UserDAOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	UserDAOService userService;
	
	@PostMapping(value = "")
	public ResponseEntity<User> createUser(@RequestBody User user){
		User userDB = userService.createAndUpdateUser(user);
		return new ResponseEntity<User>(userDB, HttpStatus.CREATED);
	}
	
	@PutMapping(value = "")
	public ResponseEntity<User> updateUser(@RequestBody User user){
		User userDB = userService.getUser(user.getEmail(), user.getPassword());
		if(userDB == null){
			return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
		}
		userService.createAndUpdateUser(user);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@GetMapping(value = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<User> getUser(@RequestParam String email, @RequestParam String password){
		User user = userService.getUser(email, password);
		if(user!=null){
			return new ResponseEntity<User>(user, HttpStatus.OK);
		} else{
			log.warn("User with email "+ email +" and password " + password + " not found!");
			return new ResponseEntity<User>(user, HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity deleteUser(@PathVariable Long userId){
		User userDB = userService.findOne(userId);
		if(userDB == null){
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
		userService.deleteUser(userId);
		return new ResponseEntity(HttpStatus.OK);
	}
}
