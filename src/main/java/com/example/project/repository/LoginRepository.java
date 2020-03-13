package com.example.project.repository;

import com.example.project.model.LoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<LoginEntity, Long> {
    boolean existsByLogin(String login);
    boolean existsByLoginAndPassword(String login, String password);
    LoginEntity findByLogin(String login);
}
