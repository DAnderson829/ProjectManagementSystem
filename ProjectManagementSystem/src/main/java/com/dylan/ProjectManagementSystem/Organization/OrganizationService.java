package com.dylan.ProjectManagementSystem.Organization;

import com.dylan.ProjectManagementSystem.dto.OrganizationRequest;
import com.dylan.ProjectManagementSystem.dto.UserRequest;
import com.dylan.ProjectManagementSystem.dto.UserResponse;
import com.dylan.ProjectManagementSystem.enums.OrganizationRole;
import com.dylan.ProjectManagementSystem.exception.OrganizationNameExistsException;
import com.dylan.ProjectManagementSystem.exception.PermissionDeniedException;
import com.dylan.ProjectManagementSystem.exception.UserIsAlreadyInOrgException;
import com.dylan.ProjectManagementSystem.user.User;
import org.springframework.stereotype.Service;

@Service
public class OrganizationService {
    private final OrganizationRepo organizationRepo;
    public OrganizationService(OrganizationRepo organizationRepo){
        this.organizationRepo = organizationRepo;
    }

    public Organization createOrganization(OrganizationRequest request, User user){
        if(!ownerPermission(user)){
            throw new PermissionDeniedException(user.getUsername());
        }

        if(orgNameExists(request.name())){
            throw new OrganizationNameExistsException(request.name());
        }

        if(userIsAlreadyInOrg(user)){
            throw new UserIsAlreadyInOrgException(user.getUsername(), request.name());
        }


    }

    public void deleteOrganization(OrganizationRequest request, User user, String confirmation){

    }

    public Organization updateOrganization(OrganizationRequest request, User user, String confirmation){

    }

    public UserResponse addUser(UserRequest requestedUser, User user){

    }

    public void removeUser(UserRequest requestedUser, User user){

    }

    private boolean ownerPermission(User user){
        return user.getOrganizationRole().equals(OrganizationRole.OWNER);
    }

    private boolean managerPermission(User user){
        return user.getOrganizationRole().equals(OrganizationRole.OWNER) ||
                user.getOrganizationRole().equals(OrganizationRole.MANAGER);
    }

    private boolean orgNameExists(String name){
        return organizationRepo.findByName(name).isPresent();
    }

    private boolean userIsAlreadyInOrg(User user){
        return user.getOrganization() != null;
    }
}
