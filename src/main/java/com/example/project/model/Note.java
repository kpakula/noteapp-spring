package com.example.project.model;

import javax.persistence.*;

@Entity
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String title;

    private String text;

    @ManyToOne
    @JoinColumn
    private AUser aUser;


    public Note() {
    }

    public Note(String title, String text) {
        this.title = title;
        this.text = text;
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
