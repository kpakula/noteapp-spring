package com.example.project.controllers;

import com.example.project.exceptions.AUserNotFoundException;
import com.example.project.model.UserA;
import com.example.project.model.LoginModel;
import com.example.project.repository.UserARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class UserAController {

    @Autowired
    private UserARepository UserARepository;

    @GetMapping("/users")
    List<UserA> all() {
        return UserARepository.findAll();
    }

    @PostMapping("/signin")
    @ResponseBody
    public Boolean login(@RequestBody LoginModel model) {
        return UserARepository.existsByLoginAndPassword(model.getLogin(), model.getPassword());
    }

    @PostMapping("/signup")
    @ResponseBody
    public Boolean register(@RequestBody LoginModel model) {
        boolean isUser = UserARepository.existsByLoginAndPassword(model.getLogin(), model.getPassword());
        if (!isUser) {
            UserA user = new UserA(model.getLogin(), model.getPassword());
            UserARepository.save(user);
            return true;
        }
        return false;
    }


    @GetMapping("/users/{id}")
    UserA showSpecific(@PathVariable Long id) {
        return UserARepository.findById(id)
                .orElseThrow(() -> new AUserNotFoundException(id));
    }



}
