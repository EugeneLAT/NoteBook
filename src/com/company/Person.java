package com.company;

public class Person  extends Record{
    private String firstName;
    private String lastName;
    private String phone;
    private String email;

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
        return "Person{" +
                "id=" + getId() +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }


    @Override
    public void askUserData() {
        System.out.println("If your name have 2 words, write your name with: \"\" !");
        System.out.println("Example: \"Test1 Test2\"");
        String firstName = Main.askString("First name: ");
        String lastName = Main.askString("Last name: ");
        String phone = Main.askString("Phone: ");
        String email = Main.askString("E-Mail: ");

        setFirstName(firstName);
        setLastName(lastName);
        setPhone(phone);
        setEmail(email);
    }

    @Override
    public boolean contains(String part) {
    return false;
    }
}
