package com.dylan.ProjectManagementSystem.project;

import com.dylan.ProjectManagementSystem.dto.ProjectRequest;
import com.dylan.ProjectManagementSystem.user.User;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    private final ProjectRepo projectRepo;
    public ProjectService(ProjectRepo projectRepo){
        this.projectRepo = projectRepo;
    }

    public Project createProject(ProjectRequest request, User user){

    }
}
