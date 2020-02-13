package com.example.project.repository;

import com.example.project.model.UserA;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserARepository extends JpaRepository<UserA, Long> {
    boolean existsByLogin(String login);
    boolean existsByLoginAndPassword(String login, String password);
    UserA findByLogin(String login);
}
