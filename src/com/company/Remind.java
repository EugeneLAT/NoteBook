package com.company;

public class Remind extends Alarm {
    private String time;
    private String data;
    private String text;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public void askUserData() {
        super.askUserData();
        String data = Main.askString("Enter data: ");

        setData(data);
    }

    @Override
    public boolean contains(String part) {
        return getData().contains(part)
                || super.contains(part);
    }

    @Override
    public String toString() {
        return "Remind{" +
                "id=" + getId() +
                "time='" + time + '\'' +
                ", data='" + data + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
