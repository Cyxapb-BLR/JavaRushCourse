package com.javarush.task.task19.task1910;

import java.io.*;

/* 
Пунктуация
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();
        reader = new BufferedReader(new FileReader(fileName1));
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName2));
        String symbols = ".!?,:;-'()-_—[]@{}*<>&#~/\n\\\""; //знаки пунктуации
        while (reader.ready()) {
            int data = reader.read(); //читаем один байт
            if (symbols.indexOf((char) data) == -1) {// если байт не содержится в строке символов,то результат =-1
                writer.write(data);
            }
        }
        reader.close();
        writer.close();
    }
}
