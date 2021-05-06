package com.javarush.task.task18.task1817;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/* 
Пробелы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader(args[0]);
        float space = 0;
        int count = 0;
        while (fileReader.ready()) {
            int symbol = fileReader.read();
            count++;
            if (symbol == ' ') {
                space++;
            }
        }
        fileReader.close();
        double result = space / count * 100;
        System.out.printf("%.2f", result); //printf +параметр "%.2f" - округление до второго знака после запятой
    }
}
