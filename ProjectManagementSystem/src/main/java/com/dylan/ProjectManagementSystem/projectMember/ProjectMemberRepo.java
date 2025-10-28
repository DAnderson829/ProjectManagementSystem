package com.dylan.ProjectManagementSystem.projectMember;

import com.dylan.ProjectManagementSystem.project.Project;
import com.dylan.ProjectManagementSystem.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectMemberRepo extends JpaRepository<ProjectMember, Long> {
    List<ProjectMember> findByProject(Project project);
}