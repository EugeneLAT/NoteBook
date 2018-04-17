package com.company;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;


public class Main {

    static Scanner scanner = new Scanner(System.in);
    static TreeMap<Integer, Record> recordsMap = new TreeMap<>();


    public static final String TIME_FORMAT = "HH:mm";
    public static final DateTimeFormatter TIME_FORMATTER
            = DateTimeFormatter.ofPattern(TIME_FORMAT);
    public static final String DATE_FORMAT = "dd/MM/yyyy";
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_FORMAT);


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
                case "alarm":
                    addRecord(new Alarm());
                    break;
                case "expired":
                    findExpired();

                    break;
                case "show":
                    try {
                        show();
                    }catch (Exception e){
                        System.out.println("SORRY! Try again!");
                    }

                    break;
                case "help":
                    System.out.println("You have command:");
                    System.out.println("1. Create");
                    System.out.println("2. List");
                    System.out.println("3. Show");
                    System.out.println("4. Alarm");
                    System.out.println("5. Expired");
                    System.out.println("6. Exit");
                    break;
                default:
                    System.out.println("Unknown command!");
            }
        }
    }

    private static void show() {
        System.out.println(">>>Show<<<");
        String cmd = askString("cmd> ");
        switch (cmd.toLowerCase()) {
            case "showid":
                String strID = askString("Enter ID: ");
                int id = Integer.parseInt(strID);
                Record r = recordsMap.get(id);
                System.out.println(r);
                break;
            case "showstr":
                String findStr = askString("Find: ");
                for (Record r1 : recordsMap.values()) {
                    if (r1.contains(findStr)) {
                        System.out.println(r1);
                    }
                }
                break;
            case "back":
                return;
            case "showbirthdays":
                showBirthdays();
                return;
            case "help":
                System.out.println("You have command:");
                System.out.println("1. ShowID");
                System.out.println("2. ShowSTR");
                System.out.println("3. ShowBirthday");
                System.out.println("4. Back");
                break;
            default:
                System.out.println("Unknown command!");
        }
    }

    private static void showBirthdays() {
        LocalDate now = LocalDate.now();
        Month nowMonth = now.getMonth();
        for (Record r : recordsMap.values()) {
            if (r instanceof WithBirthday) {
                WithBirthday rwb = (WithBirthday) r;
                LocalDate birthday = rwb.getBirthday();
                Month birthdayMonth = birthday.getMonth();
                if (nowMonth == birthdayMonth) {
                    System.out.println(r);
                }
            }
        }
    }

    private static void findExpired() {
        for (Record r : recordsMap.values()) {
            if (r instanceof Expirable) {
                Expirable expirable = (Expirable) r;
                if (expirable.isExpired()) {
                    System.out.println(expirable);
                }
            }
        }
    }

    private static void list() {
        for (Record r : recordsMap.values()) {
            System.out.println(r);
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
                case "pet":
                    addRecord(new Pet());
                    return;
                case "help":
                    System.out.println("You have command:");
                    System.out.println("1. Person");
                    System.out.println("2. Pet");
                    System.out.println("3. Note");
                    System.out.println("4. Back");
                    break;
                default:
                    System.out.println("Unknown command!");
            }
        }

    }

    private static void addRecord(Record record) {
        record.askUserData();
        int id = record.getId();
        recordsMap.put(id, record);
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

    public static LocalTime askTime(String message) {
        for (; ; ) {
            String strTime = askString(message + "(" + TIME_FORMAT + "):");
            try {
                LocalTime time = LocalTime.parse(strTime, TIME_FORMATTER);
                return time;
            } catch (DateTimeParseException e) {
                System.out.println("Time isn't in right format!");
            }
        }
    }

    public static LocalDate askDate(String message) {
        for (; ; ) {
            String strDate = askString(message + "(" + DATE_FORMAT + "):");
            try {
                LocalDate date = LocalDate.parse(strDate, DATE_FORMATTER);
                return date;
            } catch (DateTimeParseException e) {
                System.out.println("Date isn't in right format!");
            }
        }
    }


}
