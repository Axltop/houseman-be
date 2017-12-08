package com.houseman.housemanbe.repository;

import com.houseman.housemanbe.dto.TaskDTO;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaskRepository extends CrudRepository<TaskDTO,Long> {

    List<TaskDTO> findAll();
}
