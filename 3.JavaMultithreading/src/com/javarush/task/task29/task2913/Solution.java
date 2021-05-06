package com.javarush.task.task29.task2913;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/* 
Замена рекурсии
*/

public class Solution {
    private static int numberA;
    private static int numberB;

    public static String getAllNumbersBetween(int a, int b) {
        int[] result;
        StringBuilder stringBuilder = new StringBuilder();
        if (a < b) {
            result = new int[b - a + 1];
            //System.out.println(result.length);
            for (int i = 0; i <= b - a; i++) {
                result[i] = a + i;
                stringBuilder.append(result[i]).append(" ");
            }
            //return a + " " + getAllNumbersBetween(a - 1, b);
        } else {
            result = new int[a - b + 1];
            for (int i = 0; i <= a - b; i++) {
                result[i] = a-i;
                stringBuilder.append(result[i]).append(" ");

            }
            /* else {
            if (a == b) {
                return Integer.toString(a);
            }
            return a + " " + getAllNumbersBetween(a + 1, b);*/


        }
        return stringBuilder.toString().trim();
    }

    public static void main(String[] args) {
        Random random = new Random();
        numberA = random.nextInt(1000);
        numberB = random.nextInt(1000);
        System.out.println(getAllNumbersBetween(numberA, numberB));
        System.out.println(getAllNumbersBetween(numberB, numberA));
    }
}