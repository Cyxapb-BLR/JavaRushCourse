package com.javarush.task.task19.task1926;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 
Перевертыши
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(reader.readLine());
        reader.close();
        reader = new BufferedReader(fileReader);
        while (reader.ready()) {
            String line = reader.readLine();//читаю строку
            StringBuilder stringBuilder = new StringBuilder(line);// добавляю строку в StringBuilder
            System.out.println(stringBuilder.reverse()); //вывожу строку в обретном порядке
        }
        fileReader.close();
        reader.close();
    }
}

