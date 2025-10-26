package com.dylan.ProjectManagementSystem.exception;

public class UsernameAlreadyExistsException extends RuntimeException {
    public UsernameAlreadyExistsException(String username) {
        super("Email already registered: " + username);
    }
}
