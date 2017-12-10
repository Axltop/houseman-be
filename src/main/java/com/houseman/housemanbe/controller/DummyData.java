package com.houseman.housemanbe.controller;

import com.houseman.housemanbe.dto.*;
import com.houseman.housemanbe.errors.ValidationErrorMessage;
import com.houseman.housemanbe.helpers.Constants;
import com.houseman.housemanbe.helpers.ResponseMessage;
import com.houseman.housemanbe.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/dummydata")
@Api(name = "Dummy Data", description = "just test data")
public class DummyData extends AbstractRestController<AbstractDTO> {

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

    public  @ApiResponseObject ResponseWrapperDTO listUsers() {
        List<UserDTO> result =  userRepository.findAll();
        ResponseMessage message = new ResponseMessage("Success!", Constants.MessageType.SUCCSESS.getName());
        return new ResponseWrapperDTO(result,0, Arrays.asList(message),false);
    }

    @RequestMapping("/organizations")
    public List<OrganizationDTO> listOrganizations() {return organizationRepository.findAll();}

    @RequestMapping("/projects")
    public List<ProjectDTO> listProjects() {return projectRepository.findAll();}

    @RequestMapping("/tasks")
    public List<TaskDTO> listTasks() {return taskRepository.findAll();}

    @RequestMapping("/taskStatuses")
    public List<TaskStatusDTO> listTaskStatuses() {return taskStatusRepository.findAll();}

    @Override
    protected Map<String, ValidationErrorMessage> validateLogicRules(AbstractDTO value, Class... validationGroups) {
        // TODO Auto-generated method stub
        return null;
    }

}
