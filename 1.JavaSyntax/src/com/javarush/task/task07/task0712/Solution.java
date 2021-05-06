package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<String> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int max, min;

        for (int i = 0; i < 10; i++) {
            list.add(reader.readLine());
        }

        max = list.get(0).length();
        min = list.get(0).length();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() > max)
                max = list.get(i).length();
            if (list.get(i).length() < min)
                min = list.get(i).length();
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() == min || list.get(i).length() == max) {
                System.out.println(list.get(i));
                break;
            }

        }
        //напишите тут ваш код
    }
}
