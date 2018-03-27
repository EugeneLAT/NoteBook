package com.company;


import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Record> records = new ArrayList<>();


    public static void main(String[] args) {
        System.out.println("If you want help! Write: Help!");
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
                case "search":
                    search();
                    break;
                case "help":
                    System.out.println("You have command:");
                    System.out.println("1. Create");
                    System.out.println("2. List");
                    System.out.println("3. Search");
                    System.out.println("4. Exit");


                    break;
                default:
                    System.out.println("Unknown command!");
            }
        }
    }

    private static void list() {
        for (Record r : records) {
            System.out.println(r);
        }
    }

    private static void search() {
        String part = askString("Find: ");
        for (Record r : records) {
            if(r.contains(part)){
            System.out.println(r);
            }
        }
        for(Record r : records){

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
                    addRecord(new Person());
                    return;
                case "note":
                    addRecord(new Note());
                    return;
                case "help":
                    System.out.println("You have command:");
                    System.out.println("1. Person");
                    System.out.println("2. Note");
                    break;
                default:
                    System.out.println("Unknown command!");
            }
        }

    }

    private static void addRecord(Record record) {
        record.askUserData();
        records.add(record);
        System.out.println("Created!");
    }

    static String askString(String message) {
        System.out.print(message);
        String str = scanner.next();

        if (str.startsWith("\"")) {
            ArrayList<String> list = new ArrayList<>();
            list.add(str);
            while (!str.endsWith("\"")) {
                str = scanner.next();
                list.add(str);
            }
            str = String.join(" ", list);
            str = str.substring(1, str.length() - 1);
        }
        return str;

    }
}
