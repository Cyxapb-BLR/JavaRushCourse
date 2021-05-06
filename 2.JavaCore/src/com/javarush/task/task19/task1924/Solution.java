package com.javarush.task.task19.task1924;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        reader = new BufferedReader(new FileReader(fileName));
        String formatLine = "";
        String newWord = "";
        while (reader.ready()) {
            formatLine = "";
            String line = reader.readLine();
            String[] words = line.split(" ");// делим строку по пробелу на слова
            for (int i = 0; i < words.length; i++) {
                try {
                    int key = Integer.parseInt(words[i]);// слово состоящее из цифр парсим в целое число
                    if (key >= 0 && key <= 12) {// если число от 0 до 12
                        newWord = map.get(key);// значение по ключу
                        formatLine = formatLine + newWord + " ";
                    } else formatLine = formatLine + words[i] + " ";

                } catch (NumberFormatException e) {
                    formatLine = formatLine + words[i] + " ";// если слово не из цифр,то просто его добавляем
                }
            }
            System.out.println(formatLine.substring(0, formatLine.length() - 1));//удаляем последний пробел из строки
        }
        reader.close();
    }
}
