package com.houseman.housemanbe.service;

import com.houseman.housemanbe.dto.UserDTO;

public interface UserService {
    public UserDTO findByEmail(String email);
}
