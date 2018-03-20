package com.company;


import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Person> records = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("If you want help! Write: help!");
        commandLoop();

    }

    private static void commandLoop() {
        for (; ; ) {
            String cmd = askString("cmd> ");

            switch (cmd.toLowerCase()) {
                case "exit":
                    return;
                case "create":
                    create();
                    break;
                case "list":
                    list();
                    break;
                case "help":
                    System.out.println("You have command:");
                    System.out.println("1. create");
                    System.out.println("2. list");
                    System.out.println("3. exit");


                    break;
                default:
                    System.out.println("Unknown command!");
            }
        }
    }

    private static void list() {
        for (Person p : records) {
            System.out.println(p);
        }
    }

    private static void create() {
        for (; ; ) {
            System.out.println("What do you want create?");

            String cmdCreate = askString("cmd> ");
            switch (cmdCreate.toLowerCase()) {
                case "back":
                    return;
                case "person":
                    createPerson();
                    return;
                case "help":
                    System.out.println("You have command:");
                    System.out.println("1. person");
                    break;
                default:
                    System.out.println("Unknown command!");
            }
        }

    }

    private static void createPerson() {

        String firstName = askString("First name: ");
        String lastName = askString("Last name: ");
        String phone = askString("Phone: ");
        String email = askString("E-Mail: ");

        Person person = new Person();
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setPhone(phone);
        person.setEmail(email);

        records.add(person);

    }

    private static  String askString(String message){
        System.out.print(message);
        return scanner.next();
    }
}
