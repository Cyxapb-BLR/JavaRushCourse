package com.javarush.task.task13.task1326;

/*
Сортировка четных чисел из файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileInputStream fileInputStream = new FileInputStream(fileName);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
        List<Integer> list = new ArrayList();
        while (bufferedReader.ready()) {
            int data = Integer.parseInt(bufferedReader.readLine());
            if (data % 2 == 0) {
                list.add(data);
            }
        }
        Collections.sort(list);
        for (Integer integer : list) {
            System.out.println(integer);
        }
        reader.close();
        fileInputStream.close();
        bufferedReader.close();
        // напишите тут ваш код
    }
}