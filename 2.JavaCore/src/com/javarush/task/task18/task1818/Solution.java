package com.javarush.task.task18.task1818;

import java.io.*;

/* 
Два в одном
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        String fileName3 = reader.readLine();
        reader.close();
        FileInputStream fileInputStream2 = new FileInputStream(fileName2);
        FileInputStream fileInputStream3 = new FileInputStream(fileName3);
        FileOutputStream fileOutputStream = new FileOutputStream(fileName1);
        if (fileInputStream2.available() > 0) {
            //читаем весь файл одним куском
            byte[] buffer = new byte[fileInputStream2.available()];
            int count = fileInputStream2.read(buffer);
            fileOutputStream.write(buffer, 0, count);
        }
        fileInputStream2.close();
        fileOutputStream.close();
        fileOutputStream = new FileOutputStream(fileName1, true);

        if (fileInputStream3.available() > 0) {
            byte[] buffer = new byte[fileInputStream3.available()];
            int count = fileInputStream3.read(buffer);
            fileOutputStream.write(buffer, 0, count);
        }
        fileInputStream3.close();
        fileOutputStream.close();
    }
}
