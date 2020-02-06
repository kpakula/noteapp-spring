package com.example.project.controllers;

import com.example.project.exceptions.AUserNotFoundException;
import com.example.project.model.AUser;
import com.example.project.repository.AUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AUserController {

    @Autowired
    private AUserRepository AUserRepository;


    @CrossOrigin
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

    @GetMapping("/users/{id}")
    AUser showSpecific(@PathVariable Long id) {
        return AUserRepository.findById(id)
                .orElseThrow(() -> new AUserNotFoundException(id));
    }


}
