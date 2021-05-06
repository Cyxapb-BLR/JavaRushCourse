package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());
        reader.close();
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> listTemp;
        ArrayList<Integer> listPrint = new ArrayList<>();
        int count = 0;
        int min = Byte.MAX_VALUE;
        int data;
        while (fileInputStream.available() > 0) {
            data = fileInputStream.read();
            list.add(data);
        }
        fileInputStream.close();
        listTemp = list;
        for (int i = 0; i < list.size(); i++) {
            count = 1;
            for (int j = 0; j < listTemp.size(); j++) {
                if (list.get(i).equals(listTemp.get(j))) {
                    count++;
                }
            }
            if (count == min) {
                listPrint.add(list.get(i));
            }
            if (count < min) {
                min = count;
                listPrint.clear();
                listPrint.add(list.get(i));
            }
        }
        for (Integer s : listPrint
        ) {
            System.out.print(s + " ");

        }
    }
}
