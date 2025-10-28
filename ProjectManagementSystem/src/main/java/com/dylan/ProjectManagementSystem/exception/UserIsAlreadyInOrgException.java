package com.dylan.ProjectManagementSystem.exception;

public class UserIsAlreadyInOrgException extends RuntimeException {
    public UserIsAlreadyInOrgException(String username, String org) {
        super("User is already part of an organization: " + username + ", " + org);
    }
}
