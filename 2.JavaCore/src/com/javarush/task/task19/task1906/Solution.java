package com.javarush.task.task19.task1906;

import java.io.*;
import java.util.ArrayList;

/* 
Четные символы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = reader.readLine();
        String filename2 = reader.readLine();
        reader.close();
        FileReader fileReader = new FileReader(filename1);
        FileWriter fileWriter = new FileWriter(filename2);
        ArrayList<Integer> list = new ArrayList<>();
        while (fileReader.ready()) {
            int data = fileReader.read();
            list.add(data);
        }
        fileReader.close();
        for (int i = 1; i < list.size(); i = i + 2) {
            fileWriter.write(list.get(i));
        }
        fileWriter.close();
    }
}
