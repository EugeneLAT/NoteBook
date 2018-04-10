package com.company;


import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
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
            System.out.println(">>>Main<<<");
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
                case "alarm":
                    addRecord(new Alarm());
                    break;
                case "expired":
                    findExpired();
                    break;
                case "show":
                    show();
                    break;
                case "help":
                    System.out.println("You have command:");
                    System.out.println("1. Create");
                    System.out.println("2. List");
                    System.out.println("3. Search");
                    System.out.println("4. Alarm");
                    System.out.println("5. Expired");
                    System.out.println("6. Show");
                    System.out.println("7. Exit");
                    break;
                default:
                    System.out.println("Unknown command!");
            }
        }
    }

    private static void show() {
        System.out.print("Enter ID: ");
        String strID = scanner.next();
        for (Record r : records) {
            if(strID == )
            System.out.println(r);
        }

    }

    private static void findExpired() {
        LocalTime now = LocalTime.now();
        LocalDateTime nowDT = LocalDateTime.now();
        for (Record r : records) {
            if (r instanceof Alarm && !(r instanceof Remind)) {
                Alarm a = (Alarm) r;
                if (a.getTime().isBefore(now)) {
                    System.out.println(a);
                }
            }

            if (r instanceof Remind) {
                Remind rem = (Remind) r;
                LocalDateTime dt = rem.getDate().atTime(rem.getTime());
                if (dt.isBefore(nowDT)) {
                    System.out.println(rem);
                }
            }
        }
    }

    private static void list() {
        for (Record r : records) {
            System.out.println(r);
        }
    }

    private static void search() {
        System.out.println(">>>Search<<<");
        String part = askString("Find: ");
        for (Record r : records) {
            if (r.contains(part)) {
                System.out.println(r);
            }
        }

    }

    private static void create() {
        for (; ; ) {
            System.out.println(">>>Create<<<");
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
                case "remind":
                    addRecord(new Remind());
                    break;
                case "help":
                    System.out.println("You have command:");
                    System.out.println("1. Person");
                    System.out.println("2. Note");
                    System.out.println("4. Remind");
                    System.out.println("5. Back");
                    break;
                default:
                    System.out.println("Unknown command!");
            }
        }

    }

    private static void addRecord(Record record) {
        try {
            record.askUserData();
            records.add(record);
            System.out.println("Created!");
        } catch (DateTimeParseException e) {
            System.out.println("Something wrong!");
            System.out.println("Please start again!");
        }

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
