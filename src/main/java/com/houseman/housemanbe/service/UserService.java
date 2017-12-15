package com.houseman.housemanbe.service;

import com.houseman.housemanbe.model.User;

public interface UserService {
	public User findUserByEmail(String email);
	public void saveUser(User user);
}
