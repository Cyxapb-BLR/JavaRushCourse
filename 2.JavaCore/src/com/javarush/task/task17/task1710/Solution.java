package com.javarush.task.task17.task1710;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws IOException, ParseException {
        ////-с
        if (args[0].equals("-c")) {
            if (args[2].equals("м")) {
                allPeople.add(Person.createMale(args[1], new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(args[3])));
            }
            if (args[2].equals("ж")) {
                allPeople.add(Person.createFemale(args[1], new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(args[3])));
            }
            System.out.println(allPeople.size() - 1);
        }
        ////-u
        if (args[0].equals("-u")) {
            if (args[3].equals("м")) {
                allPeople.set(Integer.parseInt(args[1]), Person.createMale(args[2], new Date(String.valueOf(new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(args[4])))));
            }
        }
        if (args[0].equals("-u")) {
            if (args[3].equals("ж")) {
                allPeople.set(Integer.parseInt(args[1]), Person.createFemale(args[2], new Date(String.valueOf(new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(args[4])))));
            }
        }
        ////-d
        if (args[0].equals("-d")) {
            allPeople.get(Integer.parseInt(args[1])).setName(null);
            allPeople.get(Integer.parseInt(args[1])).setSex(null);
            allPeople.get(Integer.parseInt(args[1])).setBirthDate(null);
            // allPeople.set(Integer.parseInt(args[1]), null);
        }
        ////-i
        if (args[0].equals("-i")) {
            String sex = null;
            if (allPeople.get(Integer.parseInt(args[1])).getSex().equals(Sex.MALE)) {
                sex = "м";
            }
            if (allPeople.get(Integer.parseInt(args[1])).getSex().equals(Sex.FEMALE)) {
                sex = "ж";
            }
            System.out.println(allPeople.get(Integer.parseInt(args[1])).getName() + " " + sex + " " + new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).format(allPeople.get(Integer.parseInt(args[1])).getBirthDate()));
        }
        /*for (Person person : allPeople) {
            System.out.println(person.getName());
        }*/
        //start here - начни тут
    }
}
