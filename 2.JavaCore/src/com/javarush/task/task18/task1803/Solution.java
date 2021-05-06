package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());
        reader.close();
        ArrayList<Integer> listInput = new ArrayList<>();
        ArrayList<Integer> listTemp;
        ArrayList<Integer> listPrint = new ArrayList<>();
        int max = 0;
        while (fileInputStream.available() > 0) {
            listInput.add(fileInputStream.read());
        }
        fileInputStream.close();
        listTemp = listInput;
        for (int i = 0; i < listInput.size(); i++) {
            int count = 0;
            for (int j = 0; j < listTemp.size(); j++) {
                if (listInput.get(i).equals(listTemp.get(j))) {
                    count++;
                }
            }
            if (count == max) {
                listPrint.add(listInput.get(i));
            }
            if (count > max) {
                max = count;
                listPrint.clear();
                listPrint.add(listInput.get(i));
            }
        }
        Collections.sort(listPrint);
        System.out.print(listPrint.get(0) + " ");
        for (int i = 0; i < listPrint.size()-1; i++) {
            if (!listPrint.get(i).equals(listPrint.get(i + 1))) {
                System.out.print(listPrint.get(i + 1) + " ");
            }
        }

    }
}
