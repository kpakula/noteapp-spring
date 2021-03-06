package com.example.project.model;

public class NoteModel {
    private String title;
    private String text;
    private String login;
    private String color;

    public NoteModel(String title, String text, String login, String color) {
        this.title = title;
        this.text = text;
        this.login = login;
        this.color = color;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
