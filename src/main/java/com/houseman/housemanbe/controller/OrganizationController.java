package com.houseman.housemanbe.controller;

import com.houseman.housemanbe.helper.ResponseMessage;
import com.houseman.housemanbe.model.Organization;
import com.houseman.housemanbe.helper.ResponseWrapper;
import com.houseman.housemanbe.model.Project;
import com.houseman.housemanbe.model.User;
import com.houseman.housemanbe.service.OrganizationService;
import com.houseman.housemanbe.service.UserService;
import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.Set;

@Api(name = "Organization", description = "Methods for managing organizations")
@RequestMapping(value = "/api/organization")
@RestController
public class OrganizationController {

    private OrganizationService organizationService;
    private UserService userService;

    @Autowired
    public OrganizationController(OrganizationService organizationService, UserService userService) {
        this.organizationService = organizationService;
        this.userService = userService;
    }

    @ApiMethod(description = "Create/Save New Organizations")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public @ApiResponseObject ResponseWrapper saveOrganization(@Valid Organization targetOrganization) {

        organizationService.save(targetOrganization);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = userService.findUserByEmail(auth.getName());
        currentUser.getOrganizations().add(targetOrganization);
        userService.save(currentUser);

        ResponseMessage message = new ResponseMessage("Success!","success");

        return new ResponseWrapper(targetOrganization, Arrays.asList(message),false);
    }

    @ApiMethod(description = "Get User Organizations")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public @ApiResponseObject ResponseWrapper getByUserId() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = userService.findUserByEmail(auth.getName());
        Set<Organization> result = currentUser.getOrganizations();

        return new ResponseWrapper(result);
    }

    @ApiMethod(description = "Get single organization")
    @RequestMapping(value = "/{organizationId}", method = RequestMethod.GET)
    public @ApiResponseObject ResponseWrapper getOrganization(@PathVariable("organizationId") Long organizationId) {
        Organization organization = organizationService.get(organizationId);

        ResponseMessage message = new ResponseMessage("Success!","success");

        return new ResponseWrapper(organization, Arrays.asList(message),false);
    }


}
