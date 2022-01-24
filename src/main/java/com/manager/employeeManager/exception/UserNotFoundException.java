package com.manager.employeeManager.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String bad) {
        super(bad);
    }
}
