package com.example.project.exceptions;

public class AUserNotFoundException extends RuntimeException {

    public AUserNotFoundException(Long id) {
        super("Could not find user with id: " + id);
    }
}
