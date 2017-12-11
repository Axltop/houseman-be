package com.houseman.housemanbe.repository;

import com.houseman.housemanbe.dto.UserDTO;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<UserDTO, Long>{

    List<UserDTO> findAll();

    UserDTO findByEmail(String email);
}
