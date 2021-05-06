package com.javarush.task.task10.task1019;

/*
Функциональности маловато!
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> map = new HashMap<>();
        try {
            while (true) {
                String s = reader.readLine();
                if (s.isEmpty()) {
                    break;
                }
                int id = Integer.parseInt(s);
                String name = reader.readLine();
                map.put(name, id);
                if (name.isEmpty()) {
                    break;

                }

            }
        } catch (NullPointerException | IOException e) {
            e.printStackTrace();
        }

        for (Map.Entry<String, Integer> pair : map.entrySet()
        ) {
            System.out.println(pair.getValue() + " " + pair.getKey());

        }


    }
}