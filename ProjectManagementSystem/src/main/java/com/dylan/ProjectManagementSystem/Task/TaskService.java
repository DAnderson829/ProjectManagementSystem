package com.dylan.ProjectManagementSystem.Task;

import com.dylan.ProjectManagementSystem.dto.TaskRequest;
import com.dylan.ProjectManagementSystem.enums.ProjectRole;
import com.dylan.ProjectManagementSystem.project.Project;
import com.dylan.ProjectManagementSystem.user.User;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    private final TaskRepo taskRepo;
    public TaskService(TaskRepo taskRepo){
        this.taskRepo = taskRepo;
    }

    public Task createTask(TaskRequest request, Project project, User user){

    }

    public void deleteTask(TaskRequest request, Project project, User user){

    }

    public Task updateTask(TaskRequest request, Project project, User user){

    }

    private boolean userHasPermission(User user){

    }





}
