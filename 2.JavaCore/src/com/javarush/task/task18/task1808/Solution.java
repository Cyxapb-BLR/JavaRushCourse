package com.javarush.task.task18.task1808;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/* 
Разделение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());
        FileOutputStream fileOutputStream = new FileOutputStream(reader.readLine());
        FileOutputStream fileOutputStream1 = new FileOutputStream(reader.readLine());
        reader.close();
        ArrayList<Integer> list = new ArrayList<>();
        int fileInputStreamLength = fileInputStream.available();
        while (fileInputStream.available() > 0) {
            list.add(fileInputStream.read());
        }

        if (fileInputStreamLength % 2 == 0) {
            for (int i = 0; i < list.size() / 2; i++) {
                fileOutputStream.write(list.get(i));
            }
            for (int i = list.size() / 2; i < list.size(); i++) {
                fileOutputStream1.write(list.get(i));
            }
        } else {
            for (int i = 0; i < (list.size() / 2) + 1; i++) {
                fileOutputStream.write(list.get(i));
            }
            for (int i = (list.size() / 2) + 1; i < list.size(); i++) {
                fileOutputStream1.write(list.get(i));
            }
        }
        fileInputStream.close();
        fileOutputStream.close();
        fileOutputStream1.close();
    }
}