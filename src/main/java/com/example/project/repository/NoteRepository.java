package com.example.project.repository;

import com.example.project.model.UserA;
import com.example.project.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Long> {
    List<Note> findAllByUserA(UserA userA);
}
