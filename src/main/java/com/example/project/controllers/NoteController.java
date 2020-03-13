package com.example.project.controllers;

import com.example.project.model.LoginEntity;
import com.example.project.model.Note;
import com.example.project.model.NoteModel;
import com.example.project.repository.LoginRepository;
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
    private LoginRepository userRepository;


    @PostMapping("/notes")
    @ResponseBody
    public Note create(@RequestBody NoteModel noteModel) {
        LoginEntity loginEntity = userRepository.findByLogin(noteModel.getLogin());
        Note note = new Note(noteModel.getTitle(), noteModel.getText(), loginEntity);
        noteRepository.save(note);
        return note;
    }


    @GetMapping("/notes/my/{login}")
    public List<Note> myNotes(@PathVariable String login) {
        LoginEntity loginEntity = userRepository.findByLogin(login);
        return noteRepository.findAllByLoginEntity(loginEntity);
    }

    @PutMapping("/notes/{id}")
    public Optional<Note> changeNote(@RequestBody NoteModel noteModel, @PathVariable Long id) {
        return noteRepository.findById(id)
                .map(note -> {
                    note.setText(noteModel.getText());
                    note.setTitle(noteModel.getTitle());
                    return noteRepository.save(note);
                });
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
