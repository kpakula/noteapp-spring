package com.example.project.repository;

import com.example.project.model.AUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AUserRepository extends JpaRepository<AUser, Long> {
    boolean existsByLogin(String login);
    boolean existsByLoginAndPassword(String login, String password);
    AUser findByLogin(String login);
}
