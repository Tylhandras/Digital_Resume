package com.cooksys.service;

import java.util.List;

import com.cooksys.entity.User;

public interface UserService {
	
	public User newUser(User user);
	
	public User userLogin(User user);
	
	public List<User> getUsersByLocation(Long areaId);

}
