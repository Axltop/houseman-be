package com.houseman.housemanbe.controller;

import com.houseman.housemanbe.helper.ResponseMessage;
import com.houseman.housemanbe.helper.ResponseWrapper;
import com.houseman.housemanbe.model.Project;
import com.houseman.housemanbe.service.ProjectService;
import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Api(name = "Project",description = "Methods for managing projects")
@RequestMapping(value = "/api/project")
@RestController
public class ProjectController {

    private ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @ApiMethod(description = "Get Organization projects")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public @ApiResponseObject ResponseWrapper getProjects(@RequestParam("organization") Long organization) {

        List<Project> projects = projectService.getAll(organization);

        ResponseMessage message = new ResponseMessage("Success!","success");

        return new ResponseWrapper(projects, Arrays.asList(message),false);
    }

    @ApiMethod(description = "Save project")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public @ApiResponseObject ResponseWrapper saveProject(Project project) {

        projectService.save(project);

        ResponseMessage message = new ResponseMessage("Success!","success");

        return new ResponseWrapper(project, Arrays.asList(message),false);
    }

    @ApiMethod(description = "Get single project")
    @RequestMapping(value = "/{projectId}", method = RequestMethod.GET)
    public @ApiResponseObject ResponseWrapper saveProject(@PathVariable("projectId") Long projectId) {
        Project project = projectService.get(projectId);

        ResponseMessage message = new ResponseMessage("Success!","success");

        return new ResponseWrapper(project, Arrays.asList(message),false);
    }
}
