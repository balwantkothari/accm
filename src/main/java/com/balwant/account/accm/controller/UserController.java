package com.balwant.account.accm.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.balwant.account.accm.model.User;
import com.balwant.account.accm.service.IUserService;

@RestController
@RequestMapping(value="/user")
public class UserController {

	static final Logger logger = LogManager.getLogger(UserController.class);
			
	@Autowired
	IUserService service;
	
	@RequestMapping(value="/get", method=RequestMethod.GET)
	public ResponseEntity<List<User>> getUsers() {
		logger.info("Request=GetAllUsers ");
		return new ResponseEntity<List<User>>(service.getUsers(), HttpStatus.OK);
	}

	@RequestMapping(value="/get/{id}", method=RequestMethod.GET)
	public ResponseEntity<User> getUser(@PathVariable("id") int userId) {
		logger.info("Request=GetUserByUserId, UserId=" + userId);
		return new ResponseEntity<User>(service.getUser(userId), HttpStatus.OK);
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public ResponseEntity<Void> updateUser(@RequestBody User user) {
		logger.info("Request=UpdateUser, User=" + user);
		service.updateUser(user);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public ResponseEntity<Void> addUser(@RequestBody User user) {
		logger.info("Request=AddUser, User=" + user);
		service.createUser(user);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

}
