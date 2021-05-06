package com.javarush.task.task19.task1915;

import java.io.*;
import java.util.Arrays;

/* 
Дублируем текст
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        PrintStream defaultStream = System.out;// сохраняем дефолтный System.out
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();// создаем массив
        PrintStream stream = new PrintStream(byteArrayOutputStream); // новый поток для записи в массив,а не в консоль
        System.setOut(stream);// перенастраиваем System.out ,теперь будет сохраняться в массив,а не печататься в консоль
        testString.printSomething();// сохраняется в массив
        String result = byteArrayOutputStream.toString();// преобразуем массив в строку
        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        fileOutputStream.write(byteArrayOutputStream.toByteArray());// пишет массив в файл
        fileOutputStream.close();
        System.setOut(defaultStream); //возвращаем настройки подефолту
        System.out.println(result);// выводим в консоль
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

