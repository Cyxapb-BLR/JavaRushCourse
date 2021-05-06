package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {
        String fileName = args[0];
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        int day = 0, month = 0, year = 0;
        while (reader.ready()) {
            String line = reader.readLine();
            String[] element = line.split(" ");// разбиваем строку по пробелам, последние три элемента - дата
            year = Integer.parseInt(element[element.length - 1]);
            month = Integer.parseInt(element[element.length - 2]);
            day = Integer.parseInt(element[element.length - 3]);
            String name = "";
            for (int i = 0; i < element.length - 3; i++) { //склеиваем ФИО
                name = name + element[i] + " ";// ставим пробелы между ФИО
            }
            Date date = new SimpleDateFormat("dd MM yyyy").parse(day + " " + month + " " + year);
            PEOPLE.add(new Person(name.trim(), date));
        }
        reader.close();
    }
}
