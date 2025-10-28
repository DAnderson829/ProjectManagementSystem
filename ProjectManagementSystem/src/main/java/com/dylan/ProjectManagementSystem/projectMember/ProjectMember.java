package com.dylan.ProjectManagementSystem.projectMember;

import com.dylan.ProjectManagementSystem.enums.ProjectRole;
import com.dylan.ProjectManagementSystem.project.Project;
import com.dylan.ProjectManagementSystem.user.User;
import jakarta.persistence.*;

@Entity
public class ProjectMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private Project project;

    @Enumerated(EnumType.STRING)
    private ProjectRole projectRole;
}
