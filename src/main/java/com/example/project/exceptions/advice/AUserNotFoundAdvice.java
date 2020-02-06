package com.example.project.exceptions.advice;

import com.example.project.exceptions.AUserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class AUserNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(AUserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String auserNotFoundHandler(AUserNotFoundException ex) {
        return ex.getMessage();
    }
}
