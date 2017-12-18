package com.houseman.housemanbe.controller;

import com.houseman.housemanbe.helper.ResponseMessage;
import com.houseman.housemanbe.helper.ResponseWrapper;
import com.houseman.housemanbe.model.Task;
import com.houseman.housemanbe.service.ProjectService;
import com.houseman.housemanbe.service.TaskService;
import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Api(name = "Task",description = "Methods for managing tasks")
@RequestMapping(value = "/api/task")
@RestController
public class TaskController {

    private TaskService taskService;
    private ProjectService projectService;

    @Autowired
    public TaskController(TaskService taskService, ProjectService projectService) {
        this.taskService = taskService;
        this.projectService = projectService;
    }

    @ApiMethod(description = "Save task")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public @ApiResponseObject
    ResponseWrapper saveTask(Task task) {

        taskService.save(task);
        projectService.get(task.getProject()).getTasks().add(task);

        ResponseMessage message = new ResponseMessage("Success!","success");

        return new ResponseWrapper(task, Arrays.asList(message),false);
    }

    @ApiMethod(description = "Get tasks")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public @ApiResponseObject ResponseWrapper getTasks(@RequestParam("project") Long project) {

        List<Task> tasks = taskService.getAll(project);

        ResponseMessage message = new ResponseMessage("Success!","success");

        return new ResponseWrapper(tasks, Arrays.asList(message),false);
    }

    @ApiMethod(description = "Get single task")
    @RequestMapping(value = "/{tasksId}", method = RequestMethod.GET)
    public @ApiResponseObject ResponseWrapper getProject(@PathVariable("tasksId") Long tasksId) {
        Task task = taskService.get(tasksId);

        ResponseMessage message = new ResponseMessage("Success!","success");

        return new ResponseWrapper(task, Arrays.asList(message),false);
    }
}
