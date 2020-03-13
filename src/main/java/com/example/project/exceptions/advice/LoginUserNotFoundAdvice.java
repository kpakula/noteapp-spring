package com.example.project.exceptions.advice;

import com.example.project.exceptions.LoginUserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class LoginUserNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(LoginUserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String loginNotFoundHandler(LoginUserNotFoundException ex) {
        return ex.getMessage();
    }
}
