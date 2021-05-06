package com.javarush.task.task18.task1807;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Подсчет запятых
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());
        reader.close();
        int count = 0;
        while (fileInputStream.available() > 0) {
            int data = fileInputStream.read();
            if (data == (int) ',') { // можно написать data==44, потому что ","=44 в байтах
                count++;
            }
        }fileInputStream.close();
        System.out.println(count);
    }
}
