package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());
        reader.close();
        ArrayList<Integer> list = new ArrayList<>();
        while (fileInputStream.available() > 0) {
            int data = fileInputStream.read();
            if (!list.contains(data)) {//если не содержит список считываемый байт,то добавляем его в список
                list.add(data);
            }
        }
        fileInputStream.close();
        Collections.sort(list);
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
    }
}
