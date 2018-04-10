package com.company;

import java.time.LocalTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Alarm extends Note implements Expirable{
    private LocalTime time;
    private LocalDate date;

    public LocalTime getTime() {
        return time;
    }
    public LocalDate getDate() {
        return date;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public void setData(LocalDate date) {
        this.date = date;
    }

    @Override
    public void askUserData() {
        super.askUserData();
        LocalDate date = Main.askDate("Enter date ");
        LocalTime time = Main.askTime("Enter time ");

        setData(date);
        setTime(time);
    }

    @Override
    public boolean contains(String part) {
        String strTime = Main.TIME_FORMATTER.format(time);
        String strDate = Main.DATE_FORMATTER.format(date);

        return strTime.contains(part)
                || strDate.contains(part)
                || super.contains(part);
    }

    @Override
    public String toString() {
        String strDate = Main.DATE_FORMATTER.format(date);
        return "Alarm{" +
                "id=" + getId() +
                ", text= " + getText() +
                " date= '" + strDate + '\'' +
                " time= '" + time + '\'' +
                '}';
    }

    @Override
    public boolean isExpired() {
        LocalTime nowTime = LocalTime.now();
        LocalDate nowDate = LocalDate.now();
        return time.isBefore(nowTime)
                && date.isBefore(nowDate);
    }
}
