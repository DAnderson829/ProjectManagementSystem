package com.dylan.ProjectManagementSystem.dto;

import com.dylan.ProjectManagementSystem.Organization.Organization;

public record UserResponse(
        String username,
        String firstName,
        String lastName,
        String orgName
) {
}
