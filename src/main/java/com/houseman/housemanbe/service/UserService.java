package com.houseman.housemanbe.service;

import com.houseman.housemanbe.model.User;

public interface UserService {
	 User findUserByEmail(String email);
	 void saveUser(User user);
}
