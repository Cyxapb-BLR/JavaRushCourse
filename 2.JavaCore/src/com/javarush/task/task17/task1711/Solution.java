package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //args = new String[]{"-c", "Иванов", "м", "04/01/1990", "Иванова", "ж", "18/05/1999"};
        //args = new String[]{"-u", "0", "Петров", "м", "04/01/1991", "1", "Петрова", "ж", "18/05/1995"};
        //args = new String[]{"-d", "0", "1"};
        //args = new String[]{"-i", "1", "0"};
        int n;
        switch (args[0]) {
            case "-c":
                synchronized (allPeople) {
                    n = args.length;// количество добавляемых людей
                    for (int i = 1; i < args.length; i = i + 3) {
                        if (args[i + 1].equals("м")) {
                            allPeople.add(Person.createMale(args[i], new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(args[i + 2])));
                            System.out.println(allPeople.size() - 1);
                        }
                        if (args[i + 1].equals("ж")) {
                            allPeople.add(Person.createFemale(args[i], new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(args[i + 2])));
                            System.out.println(allPeople.size() - 1);
                        }
                    }
                }
                break;
            case "-u":
                synchronized (allPeople) {
                    for (int i = 2; i < args.length; i = i + 4) {
                        if (args[i + 1].equals("м")) {
                            allPeople.set(Integer.parseInt(args[i - 1]), Person.createMale(args[i], new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(args[i + 2])));
                        }
                        if (args[i + 1].equals("ж")) {
                            allPeople.set(Integer.parseInt(args[i - 1]), Person.createFemale(args[i], new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(args[i + 2])));
                        }
                    }
                }
                break;
            case "-d":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        allPeople.get(Integer.parseInt(args[i])).setName(null);
                        allPeople.get(Integer.parseInt(args[i])).setSex(null);
                        allPeople.get(Integer.parseInt(args[i])).setBirthDate(null);
                    }
                }
                break;
            case "-i":
                synchronized (allPeople) {
                    String sex = null;
                    for (int i = 0; i < args.length - 1; i++) {
                        if (allPeople.get(Integer.parseInt(args[i + 1])).getSex().equals(Sex.MALE)) {
                            sex = "м";
                        }
                        if (allPeople.get(Integer.parseInt(args[i + 1])).getSex().equals(Sex.FEMALE)) {
                            sex = "ж";
                        }
                        System.out.println(allPeople.get(Integer.parseInt(args[i + 1])).getName() + " " + sex + " " + new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).format(allPeople.get(Integer.parseInt(args[i + 1])).getBirthDate()));
                    }
                }
        }
        /*for (Person person : allPeople) {
            System.out.println(person.getName() + " " + person.getSex() + " " + person.getBirthDate());
        }*/
        //start here - начни тут
    }
}
