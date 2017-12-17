package com.houseman.housemanbe.service;

import com.houseman.housemanbe.model.Project;
import com.houseman.housemanbe.repository.ProjectRepository;
import com.houseman.housemanbe.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service("projectService")
public class ProjectServiceImpl implements ProjectService {

    private ProjectRepository projectRepository;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public void save(Project project) {

        projectRepository.save(project);
    }

    @Override
    public List<Project> getAll(Long organizationId) {

        return projectRepository.findAllByOrganizationId(organizationId);
    }

    @Override
    public Project get(Long projectId) {

        return projectRepository.getById(projectId);
    }
}
