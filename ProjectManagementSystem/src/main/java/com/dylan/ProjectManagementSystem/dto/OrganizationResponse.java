package com.dylan.ProjectManagementSystem.dto;

public record OrganizationResponse(
        String name,
        String description,
        String ownerName
) {
}
