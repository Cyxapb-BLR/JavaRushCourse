package com.javarush.task.task13.task1318;

/*
Чтение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine()); //считываем название файла
        while (inputStream.available() > 0) {
            System.out.print((char) inputStream .read());// приводим к типу char чтобы видеть символы
        }
        //закрываем потоки:
        reader.close();
        inputStream.close();
        // напишите тут ваш код
    }
}





























