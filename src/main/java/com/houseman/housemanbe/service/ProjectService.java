package com.houseman.housemanbe.service;

import com.houseman.housemanbe.model.Project;

import java.util.List;
import java.util.Set;

public interface ProjectService {

    void save(Project project);

    List<Project> getAll(Long organizationId);

    Project get(Long projectId);
}
