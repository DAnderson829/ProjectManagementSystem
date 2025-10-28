package com.dylan.ProjectManagementSystem.exception;

public class OrganizationNameExistsException extends RuntimeException {
    public OrganizationNameExistsException(String name) {

        super("Organization name already exists: " + name);
    }
}
