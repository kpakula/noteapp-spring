package com.example.project.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String title;

    @NotNull
    private String text;

    @ManyToOne
    @JoinColumn
    @NotNull
    private UserA userA;


    public Note() {
    }

    public Note(String title, String text, UserA userA) {
        this.title = title;
        this.text = text;
        this.userA = userA;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public UserA getUserA() {
        return userA;
    }

    public void setUserA(UserA userA) {
        this.userA = userA;
    }
}
