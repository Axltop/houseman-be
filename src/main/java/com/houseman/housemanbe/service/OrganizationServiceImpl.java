package com.houseman.housemanbe.service;

import com.houseman.housemanbe.model.Organization;
import com.houseman.housemanbe.repository.OrganizationRepository;
import com.houseman.housemanbe.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("organizationSerice")
public class OrganizationServiceImpl implements OrganizationService {

    private OrganizationRepository organizationRepository;

    @Autowired
    public OrganizationServiceImpl(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    @Override
    public void save(Organization organization) {
        organizationRepository.save(organization);
    }

    @Override
    public Organization get(Long organizationId) {
        return organizationRepository.getOne(organizationId);
    }

}
