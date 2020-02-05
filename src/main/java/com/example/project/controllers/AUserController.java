package com.example.project.controllers;

import com.example.project.model.AUser;
import com.example.project.repository.AUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AUserController {

    @Autowired
    private AUserRepository AUserRepository;


    @GetMapping("/users")
    List<AUser> all() {
        return AUserRepository.findAll();
    }


    @PostMapping("/users")
    AUser newUser(@RequestBody AUser newAUser) {

        boolean usernameExists = AUserRepository.existsByLogin(newAUser.getLogin().toLowerCase());
        if (!usernameExists) return AUserRepository.save(newAUser);
        return null;
    }


}
