package com.javarush.task.task19.task1925;

import java.io.*;


/* 
Длинные слова
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName1 = args[0];
        String fileName2 = args[1];
        BufferedReader reader = new BufferedReader(new FileReader(fileName1));
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName2));
        String result = "";
        while (reader.ready()) {
            String line = reader.readLine();// читаем по строке
            String[] words = line.split(" "); // делим на слова по пробелу
            for (int i = 0; i < words.length; i++) {
                if (words[i].length() > 6) { //если длина слова больше 6 символов,то добавляем его черех хапятую
                    result = result + words[i] + ",";
                }
            }
        }
        writer.write(result.substring(0,result.length()-1));// записывваем в файл без последнего символа
        reader.close();
        writer.close();
    }
}
