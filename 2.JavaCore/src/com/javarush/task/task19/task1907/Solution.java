package com.javarush.task.task19.task1907;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Считаем слово
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        bufferedReader.close();
        FileReader fileReader = new FileReader(fileName);
        String symbols = " .!?,:;-'()-_—[]@{}*<>&#~/\n\\\""; //все знаки препинания
        int count = 0; // счетчик слов "world"
        String s = "";
        while (fileReader.ready()) {
            int data = fileReader.read(); //читаем один байт
            if (symbols.indexOf(data) == -1) { // если байт не содержится в symbols то индекс равен -1
                s = s + (char) data;
                // System.out.println(s);
            }
            if (symbols.indexOf(data) != -1) { //если байт содержит знак препинания
                if (s.equals("world")) { //сравниваем собранное слово с world
                    count++;
                }
                s = "";// сбрасывваем слово
            }
        }
        fileReader.close();
        System.out.println(count);
    }
}
