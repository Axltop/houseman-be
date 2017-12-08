package com.houseman.housemanbe.repository;

import com.houseman.housemanbe.dto.TaskStatusDTO;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaskStatusRepository extends CrudRepository<TaskStatusDTO, Long> {
    List<TaskStatusDTO> findAll();
}
