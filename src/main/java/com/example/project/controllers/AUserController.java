package com.example.project.controllers;

import com.example.project.exceptions.AUserNotFoundException;
import com.example.project.model.AUser;
import com.example.project.model.LoginModel;
import com.example.project.repository.AUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class AUserController {

    @Autowired
    private AUserRepository AUserRepository;

    @GetMapping("/users")
    List<AUser> all() {
        return AUserRepository.findAll();
    }

    @PostMapping("/signin")
    @ResponseBody
    public Boolean login(@RequestBody LoginModel model) {
        return AUserRepository.existsByLoginAndPassword(model.getLogin(), model.getPassword());
    }

    @PostMapping("/signup")
    @ResponseBody
    public Boolean register(@RequestBody LoginModel model) {
        boolean isUser = AUserRepository.existsByLoginAndPassword(model.getLogin(), model.getPassword());
        if (!isUser) {
            AUser user = new AUser(model.getLogin(), model.getPassword());
            AUserRepository.save(user);
            return true;
        }
        return false;
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
