package com.company;

public class Note extends Record{
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Note: " + "ID= " + getId() + " Text: " + text +"}";
    }

    @Override
    public void askUserData() {
        System.out.println("Write your note with: \"\" !");
        String text = Main.askString("Note: ");

        setText(text);
    }

    @Override
    public boolean contains(String part) {
        return text.contains(part);
    }
}
