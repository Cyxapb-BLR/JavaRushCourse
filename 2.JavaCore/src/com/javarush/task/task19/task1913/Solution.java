package com.javarush.task.task19.task1913;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Выводим только цифры
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream defaultStream = System.out; // сохраняем дефолтное значение в переменную
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();//создаем массив
        PrintStream stream = new PrintStream(byteArrayOutputStream);// создаем новый путь сохранения
        System.setOut(stream);// переопределяем System.out
        testString.printSomething();//сохраняется в массив,а не выводится в консоль
        System.setOut(defaultStream); //возврашаем дефолтные настройки
        String result = byteArrayOutputStream.toString().replaceAll("[^0-9]", "");
        /*"[0-9]" заменят цифры от 0-9
        если добавить ^ , то наоборот заменят всё, кроме этих цифр*/
        System.out.println(result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's 1 a 23 text 4 f5-6or7 tes8ting");
        }
    }
}
