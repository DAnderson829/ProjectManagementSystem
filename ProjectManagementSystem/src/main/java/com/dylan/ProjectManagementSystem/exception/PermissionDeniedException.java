package com.dylan.ProjectManagementSystem.exception;

public class PermissionDeniedException extends RuntimeException {
    public PermissionDeniedException(String username) {

        super("Insufficient permissions: " + username);
    }
}
