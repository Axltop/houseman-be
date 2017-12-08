package com.houseman.housemanbe.controller;

import com.houseman.housemanbe.dto.*;
import com.houseman.housemanbe.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/dummydata")
public class DummyData {

    private UserRepository userRepository;
    private OrganizationRepository organizationRepository;
    private ProjectRepository projectRepository;
    private TaskRepository taskRepository;
    private TaskStatusRepository taskStatusRepository;


    @Autowired

    public DummyData(
            UserRepository userRepository,
            OrganizationRepository organizationRepository,
            ProjectRepository projectRepository,
            TaskRepository taskRepository,
            TaskStatusRepository taskStatusRepository) {

        this.userRepository = userRepository;
        this.organizationRepository = organizationRepository;
        this.projectRepository = projectRepository;
        this.taskRepository = taskRepository;
        this.taskStatusRepository = taskStatusRepository;

    }

    @RequestMapping("/users")
    public List<UserDTO> listUsers() {return userRepository.findAll();}

    @RequestMapping("/organizations")
    public List<OrganizationDTO> listOrganizations() {return organizationRepository.findAll();}

    @RequestMapping("/projects")
    public List<ProjectDTO> listProjects() {return projectRepository.findAll();}

    @RequestMapping("/tasks")
    public List<TaskDTO> listTasks() {return taskRepository.findAll();}

    @RequestMapping("/taskStatuses")
    public List<TaskStatusDTO> listTaskStatuses() {return taskStatusRepository.findAll();}



}
