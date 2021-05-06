package com.javarush.task.task19.task1914;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Решаем пример
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream defaultStream = System.out;// сохраняем дефолтный System.out в переменную
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(); //создаем массив
        PrintStream stream = new PrintStream(byteArrayOutputStream); // создаем новый,чтобы сохранялось в массив,а не печаталось в консоль
        System.setOut(stream); // теперь System.out будет сохранять в массив
        testString.printSomething(); // сохраняется в массив
        System.setOut(defaultStream); // возврашаем дефолтные настройки
        String line = byteArrayOutputStream.toString();
        String[] strings = line.split(" ", 4);// делаем массив для цифр и знаков
        int result = 0;
        if (strings[1].equals("+")) {
            result = Integer.parseInt(strings[0]) + Integer.parseInt(strings[2]);
        }
        if (strings[1].equals("-")) {
            result = Integer.parseInt(strings[0]) - Integer.parseInt(strings[2]);
        }
        if (strings[1].equals("*")) {
            result = Integer.parseInt(strings[0]) * Integer.parseInt(strings[2]);
        }
        System.out.println(line.trim() + " " + result); //trim удаляет после равно пробелы и переносы строк
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

