package com.javarush.task.task07.task0705;

/* 
Один большой массив и два маленьких
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] bigArray = new int[20];
        int[] smallArray1 = new int[10];
        int[] smallArray2 = new int[10];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < bigArray.length; i++) {
            bigArray[i] = Integer.parseInt(reader.readLine());
            if (i < 10) {
                smallArray1[i] = bigArray[i];
            } else {
                smallArray2[i - 10] = bigArray[i];
                System.out.println(smallArray2[i - 10]);
            }

        }//напишите тут ваш код
    }
}
