package com.example.project.controllers;

import com.example.project.model.UserA;
import com.example.project.model.Note;
import com.example.project.model.NoteModel;
import com.example.project.repository.UserARepository;
import com.example.project.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


    @PostMapping("/notes/my")
    public List<Note> myNotes(@RequestBody String login) {
        UserA userA = userRepository.findByLogin(login);
        return noteRepository.findAllByUserA(userA);
    }
}
