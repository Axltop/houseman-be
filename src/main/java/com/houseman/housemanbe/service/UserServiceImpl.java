package com.houseman.housemanbe.service;

import com.houseman.housemanbe.model.Role;
import com.houseman.housemanbe.model.User;
import com.houseman.housemanbe.repository.RoleRepository;
import com.houseman.housemanbe.repository.UserRepository;
import com.houseman.housemanbe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;

@Service("userService")
public class UserServiceImpl implements UserService {


	private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
    	this.userRepository = userRepository;
    	this.roleRepository = roleRepository;
    	this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Override
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public void saveUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        Role userRole = roleRepository.findByRoleName("ADMIN");
        user.getRoles().add(userRole);
		userRepository.save(user);
	}

	@Override
    public  void save(User user){
	    userRepository.save(user);
    }
}
