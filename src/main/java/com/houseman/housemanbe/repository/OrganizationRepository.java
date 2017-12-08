package com.houseman.housemanbe.repository;

import com.houseman.housemanbe.dto.OrganizationDTO;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrganizationRepository extends CrudRepository<OrganizationDTO, Long> {
    List<OrganizationDTO> findAll();
}
