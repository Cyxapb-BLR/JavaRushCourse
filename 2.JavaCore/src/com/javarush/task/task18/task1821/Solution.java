package com.javarush.task.task18.task1821;

import java.io.*;
import java.util.*;

/*
Встречаемость символов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = args[0];
        FileInputStream fileInputStream = new FileInputStream(fileName);

        byte[] buffer;
        ArrayList<Byte> list = new ArrayList<>();

        while (fileInputStream.available() > 0) {
            buffer = new byte[fileInputStream.available()];
            int data = fileInputStream.read(buffer); //читаем файл
            for (int i = 0; i < buffer.length; i++) {
                list.add(buffer[i]); // добавляем каждый считаный байт в лист
            }
        }fileInputStream.close();

        Collections.sort(list); // сортировка байтов по возрастанию
        int count = 0; // счетчик повторов
        for (int i = 0; i < list.size(); ) {
            count = 0;
            for (int j = 0; j < list.size(); j++) {
                if (list.get(i).equals(list.get(j))) {
                    count++;
                }
            }
            i = i + count;

            // (char) list.get(i - 1).byteValue() - преобразую байт обратно в символ char
            System.out.println(((char) list.get(i - 1).byteValue()) + " " + count);
        }
    }
}