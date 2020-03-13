package com.example.project.repository;

import com.example.project.model.LoginEntity;
import com.example.project.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
    List<Note> findAllByLoginEntity(LoginEntity loginEntity);
}
