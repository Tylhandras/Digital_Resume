package com.cooksys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.entity.User;
import com.cooksys.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {
	
	@Autowired
	private UserService userServ;
	
	@RequestMapping(value = "newUser", method = RequestMethod.POST)
	public User newUser(@RequestBody User user) {
		return userServ.newUser(user);
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public User login(@RequestBody User user) {
		return userServ.userLogin(user);
	}
	
	@RequestMapping(value = "getByLocation/{areaId}", method = RequestMethod.GET)
	public List<User> getByLocation(@PathVariable Long areaId) {
		return userServ.getUsersByLocation(areaId);
	}
	
}
