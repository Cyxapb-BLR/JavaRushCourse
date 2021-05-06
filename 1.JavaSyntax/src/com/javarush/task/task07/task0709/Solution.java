package com.javarush.task.task07.task0709;

/* 
Выражаемся покороче
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> arrayList = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            arrayList.add(reader.readLine());
        }
        int min = arrayList.get(0).length();
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).length() < min)
                min = arrayList.get(i).length();
        }
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).length() == min)
                System.out.println(arrayList.get(i));

        }

        //напишите тут ваш код
    }
}
