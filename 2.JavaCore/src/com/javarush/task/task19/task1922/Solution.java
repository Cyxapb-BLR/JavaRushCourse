package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        reader = new BufferedReader(new FileReader(fileName));
        int count;
        while (reader.ready()) {
            String line = reader.readLine();
            String[] wordsFromLine = line.split(" ");//делим на слова по пробелу
            count = 0;
            for (int i = 0; i < wordsFromLine.length; i++) {// сравниваем каждое слово со словами из words
                int start = 0;
                for (int j = start; j < words.size(); j++) {
                    if (wordsFromLine[i].equals(words.get(j))) {
                        count++;//считаем количество совпадений
                        break;
                    }
                }
            }
            if (count == 2) {// выводим строку,если совпадений 2
                System.out.println(line);
            }
        }
        reader.close();
    }
}
