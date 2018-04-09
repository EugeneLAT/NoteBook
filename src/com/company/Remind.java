package com.company;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Remind extends Alarm {
    public static final String DATE_FORMAT = "dd/MM/yyyy";
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_FORMAT);
    private LocalDate date;

    public LocalDate getDate() {
        return date;
    }

    public void setData(LocalDate date) {
        this.date = date;
    }


    @Override
    public void askUserData() {

        super.askUserData();
        String strDate = Main.askString("Enter date " + "(Format " + DATE_FORMAT +")" + ": ");
        LocalDate date = LocalDate.parse(strDate, DATE_FORMATTER);
        setData(date);

    }

    @Override
    public boolean contains(String part) {
         String strDate = DATE_FORMATTER.format(date);
        return strDate.contains(part)
                || super.contains(part);
    }

    @Override
    public String toString() {
        String strDate = DATE_FORMATTER.format(date);
        return "Remind{" +
                "id=" + getId() +
                " time='" + getTime() + '\'' +
                ", date='" + strDate + '\'' +
                ", text='" + getText() + '\'' +
                '}';
    }
}
