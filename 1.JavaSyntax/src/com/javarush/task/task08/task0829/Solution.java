package com.javarush.task.task08.task0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
Модернизация ПО
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> list = new ArrayList<>();
        while (true) {
            String cityORfamily = reader.readLine();


            if (cityORfamily.isEmpty()) {
                break;
            }
            list.add(cityORfamily);
        }
        // Read the city
        String cityinput = reader.readLine();

        for (int i = 0; i < list.size(); i = i + 2) {
            if (cityinput.equals(list.get(i)))
                System.out.println(list.get(i + 1));
        }


    }
}