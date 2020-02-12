package com.example.project.controllers;

import com.example.project.model.AUser;
import com.example.project.model.Note;
import com.example.project.model.NoteModel;
import com.example.project.repository.AUserRepository;
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
    private AUserRepository userRepository;


    @PostMapping("/notes")
    @ResponseBody
    public Note create(@RequestBody NoteModel noteModel) {
        AUser aUser = userRepository.findByLogin(noteModel.getLogin());
        return new Note(noteModel.getTitle(), noteModel.getText(), aUser);
    }

//    @GetMapping("/notes/my")
//    List<Note> myNotes() {
//
//    }
}
