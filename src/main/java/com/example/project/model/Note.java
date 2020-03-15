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

    @NotNull
    private String color;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    @NotNull
    private LoginEntity loginEntity;


    public Note() {
    }

    public Note(String title, String text, LoginEntity loginEntity, String color) {
        this.title = title;
        this.text = text;
        this.loginEntity = loginEntity;
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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

    public LoginEntity getLoginEntity() {
        return loginEntity;
    }

    public void setLoginEntity(LoginEntity loginEntity) {
        this.loginEntity = loginEntity;
    }
}
