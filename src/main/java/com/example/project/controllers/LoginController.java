package com.example.project.controllers;

import com.example.project.exceptions.LoginUserNotFoundException;
import com.example.project.model.LoginEntity;
import com.example.project.model.LoginModel;
import com.example.project.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class LoginController {

    @Autowired
    private LoginRepository LoginRepository;

    @GetMapping("/users")
    List<LoginEntity> all() {
        return LoginRepository.findAll();
    }

    @PostMapping("/signin")
    @ResponseBody
    public Boolean login(@RequestBody LoginModel model) {
        return LoginRepository.existsByLoginAndPassword(model.getLogin(), model.getPassword());
    }

    @PostMapping("/signup")
    @ResponseBody
    public Boolean register(@RequestBody LoginModel model) {
        boolean isUser = LoginRepository.existsByLoginAndPassword(model.getLogin(), model.getPassword());
        if (!isUser) {
            LoginEntity user = new LoginEntity(model.getLogin(), model.getPassword());
            LoginRepository.save(user);
            return true;
        }
        return false;
    }


    @GetMapping("/users/{id}")
    LoginEntity showSpecific(@PathVariable Long id) {
        return LoginRepository.findById(id)
                .orElseThrow(() -> new LoginUserNotFoundException(id));
    }



}
