package com.dylan.ProjectManagementSystem.project;

import com.dylan.ProjectManagementSystem.Organization.Organization;
import com.dylan.ProjectManagementSystem.Task.Task;
import com.dylan.ProjectManagementSystem.projectMember.ProjectMember;
import com.dylan.ProjectManagementSystem.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@EntityListeners(AuditingEntityListener.class)
@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private User creator;

    private String projectLead;

    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    private Organization organization;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Task> tasks;

    @ManyToMany
    @JoinTable(
            name = "project_users",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProjectMember> members = new ArrayList<>();

    @LastModifiedBy
    private String modifiedBy;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    public void addTask(Task task) {
        tasks.add(task);
        task.setProject(this);
    }
}
