package com.company;

import java.time.LocalDate;

public class Person extends Record implements WithBirthday{
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private LocalDate birthday;


    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        String strBirthday = Main.DATE_FORMATTER.format(getBirthday());
        return "Person{" +
                "id=" + getId() +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", Birthday='" + strBirthday + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }


    @Override
    public void askUserData() {
        System.out.println("If your name have 2 words, write your name with: \"\" !");
        System.out.println("Example: \"Test1 Test2\"");
        String firstName = Main.askString("First name: ");
        String lastName = Main.askString("Last name: ");
        LocalDate birthday = Main.askDate("Birthday: ");
        String phone = Main.askString("Phone: ");
        String email = Main.askString("E-Mail: ");


        setFirstName(firstName);
        setLastName(lastName);
        setPhone(phone);
        setEmail(email);
        setBirthday(birthday);
    }

    @Override
    public boolean contains(String part) {
        String strBirthday = Main.DATE_FORMATTER.format(getBirthday());
        return firstName.contains(part)
                || lastName.contains(part)
                || strBirthday.contains(part)
                || phone.contains(part)
                || email.contains(part);
    }
}
