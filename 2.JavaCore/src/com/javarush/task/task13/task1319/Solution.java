package com.javarush.task.task13.task1319;

/*
Писатель в файл с консоли
e:\test File for java task.txt
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine(); // считывем имя файла
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));

        while (true) {
            String s = reader.readLine();
            writer.write(s);
            writer.newLine();
            if (s.equals("exit")) {
                break;
            }
        }
        reader.close(); // закрываем потоки
        writer.close();
        // напишите тут ваш код
    }
}