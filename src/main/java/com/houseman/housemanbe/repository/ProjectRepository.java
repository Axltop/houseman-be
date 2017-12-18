package com.houseman.housemanbe.repository;

import com.houseman.housemanbe.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    List<Project> findAllByOrganizationId(Long organizationId);

    Project getById(Long id);
}
