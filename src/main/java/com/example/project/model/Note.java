package com.example.project.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    private String title;

    @NotNull
    private String text;

    @ManyToOne
    @JoinColumn
    @NotNull
    private AUser aUser;


    public Note() {
    }

    public Note(String title, String text, AUser aUser) {
        this.title = title;
        this.text = text;
        this.aUser = aUser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public AUser getaUser() {
        return aUser;
    }

    public void setaUser(AUser aUser) {
        this.aUser = aUser;
    }
}
