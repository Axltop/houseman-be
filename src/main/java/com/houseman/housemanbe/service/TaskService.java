package com.houseman.housemanbe.service;

import com.houseman.housemanbe.model.Task;

import java.util.List;

public interface TaskService {

    void save(Task task);

    List<Task> getAll(Long projectId);

    Task get(Long taskId);
}
