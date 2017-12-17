package com.houseman.housemanbe.controller;

import com.houseman.housemanbe.helper.ResponseMessage;
import com.houseman.housemanbe.model.Organization;
import com.houseman.housemanbe.model.ResponseWrapper;
import com.houseman.housemanbe.model.User;
import com.houseman.housemanbe.service.OrganizationService;
import com.houseman.housemanbe.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.Set;
@Slf4j
@Api(name = "Organization Services",description = "Methods for managing organizations")
@RestController
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    @Autowired
    private UserService userService;


    @ApiMethod(description = "Get User Organizations")
    @RequestMapping(value = "/api/organization/getOrganizationsByUser", method = RequestMethod.GET)
    public @ApiResponseObject ResponseWrapper getByUserId() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = userService.findUserByEmail(auth.getName());
        Set<Organization> result = currentUser.getOrganizations();

        return new ResponseWrapper(result);
    }

    @ApiMethod(description = "Create/Save New Organizations")
    @RequestMapping(value = "/api/organization/save", method = RequestMethod.POST)
    public @ApiResponseObject ResponseWrapper saveOrganization(@Valid Organization targetOrganization) {

        organizationService.save(targetOrganization);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = userService.findUserByEmail(auth.getName());
//        Set<Organization> organizations = currentUser.getOrganizations();
//        organizations.add(targetOrganization);
//        currentUser.setOrganizations(organizations);
        currentUser.getOrganizations().add(targetOrganization);
        userService.save(currentUser);

        ResponseMessage message = new ResponseMessage("Success!","success");

        return new ResponseWrapper(targetOrganization, Arrays.asList(message),false);
    }


}
