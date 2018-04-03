package com.company;

public class Alarm extends Note {
    private String time;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public void askUserData() {
        super.askUserData();
        String time = Main.askString("Enter time: ");


        setTime(time);

    }

    @Override
    public boolean contains(String part) {
        return getTime().contains(part)
                || super.contains(part);
    }

    @Override
    public String toString() {
        return "Alarm{" +
                "id=" + getId() +
                ", text=" + getText() +
                "time='" + time + '\'' +
                '}';
    }
}
