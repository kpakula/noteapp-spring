package com.example.project.controllers;

import com.example.project.model.UserA;
import com.example.project.model.Note;
import com.example.project.model.NoteModel;
import com.example.project.repository.UserARepository;
import com.example.project.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class NoteController {

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private UserARepository userRepository;


    @PostMapping("/notes")
    @ResponseBody
    public Note create(@RequestBody NoteModel noteModel) {
        UserA userA = userRepository.findByLogin(noteModel.getLogin());
        Note note = new Note(noteModel.getTitle(), noteModel.getText(), userA);
        noteRepository.save(note);
        return note;
    }


    @GetMapping("/notes/my/{login}")
    public List<Note> myNotes(@PathVariable String login) {
        UserA userA = userRepository.findByLogin(login);
        return noteRepository.findAllByUserA(userA);
    }


    @DeleteMapping("/notes/{id}")
    public boolean deleteNote(@PathVariable Long id) {
        noteRepository.deleteById(id);
        return true;
    }

    @GetMapping("/notes/{id}")
    public Optional<Note> specificNote(@PathVariable Long id) {
        return noteRepository.findById(id);
    }

}
