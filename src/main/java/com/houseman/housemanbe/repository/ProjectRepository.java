package com.houseman.housemanbe.repository;

import com.houseman.housemanbe.dto.ProjectDTO;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProjectRepository extends CrudRepository<ProjectDTO,Long> {

    List<ProjectDTO> findAll();
}
