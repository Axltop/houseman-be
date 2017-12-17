package com.houseman.housemanbe.service;

import com.houseman.housemanbe.model.Organization;
import com.houseman.housemanbe.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("organizationSerice")
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    private OrganizationRepository organizationRepository;

    @Override
    public void save(Organization organization) {
        organizationRepository.save(organization);
    }
}
