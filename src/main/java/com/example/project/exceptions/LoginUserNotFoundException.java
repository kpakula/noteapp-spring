package com.example.project.exceptions;

public class LoginUserNotFoundException extends RuntimeException {

    public LoginUserNotFoundException(Long id) {
        super("Could not find user with id: " + id);
    }
}
