package com.houseman.housemanbe.service;

import com.houseman.housemanbe.model.Task;
import com.houseman.housemanbe.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("taskService")
public class TaskServiceImpl implements TaskService{

    private TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public void save(Task task) {

        taskRepository.save(task);
    }

    @Override
    public List<Task> getAll(Long projectId) {

        return taskRepository.findAllByProject(projectId);
    }

    @Override
    public Task get(Long taskId) {

        return taskRepository.getById(taskId);
    }
}
