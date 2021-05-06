package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());
        reader.close();
        int min = fileInputStream.read();
        int data;
        while (fileInputStream.available() > 0) {
            if ((data = fileInputStream.read()) < min) {
                min = data;
            }
        }
        fileInputStream.close();
        System.out.println(min);
    }
}
