package com.example.project.model;

public class NoteModel {
    private String title;
    private String text;
    private String login;

    public NoteModel(String title, String text, String login) {
        this.title = title;
        this.text = text;
        this.login = login;
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
