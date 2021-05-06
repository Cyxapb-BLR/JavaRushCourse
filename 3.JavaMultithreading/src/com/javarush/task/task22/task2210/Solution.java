package com.javarush.task.task22.task2210;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/* 
StringTokenizer
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getTokens("level22.lesson13.task01", ".")));
    }

    public static String[] getTokens(String query, String delimiter) {
        StringTokenizer stringTokenizer = new StringTokenizer(query, delimiter);
        ArrayList<String> token = new ArrayList<>();
        while (stringTokenizer.hasMoreTokens()) {
            token.add(stringTokenizer.nextToken());
        }
        String[] result = new String[token.size()];
        token.toArray(result);                         //копируем элементы списка в массив String[]
        return result;
    }
}
