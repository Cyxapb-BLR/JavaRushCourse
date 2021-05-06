package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException, ParseException {
            String[] fullName = fileScanner.nextLine().split(" ", 4);
            //размер массива=4, делим по пробелам.
            // первые три элемента массива = фамилия,имя,отчество, 4 элемент - дата
            DateFormat dateFormat = new SimpleDateFormat("dd MM yyyy");// делаем определенный формат
            Date date = dateFormat.parse(fullName[3]);// создаем дату из 4 элемента массива по нужному формату
            return new Person(fullName[1], fullName[2], fullName[0], date); //создаем объект с нужными параметрами как в конструкторе Person
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
