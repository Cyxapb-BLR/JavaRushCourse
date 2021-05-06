package com.javarush.task.task14.task1420;

/*
НОД
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(reader.readLine());
        int y = Integer.parseInt(reader.readLine());
        if (x > 0 && y > 0) {
            int nod = 1;
            int minNumber = 1;
            if (x > y) {
                minNumber = y;
            } else if (x < y) {
                minNumber = x;
            } else {
                nod = x;
            }
            for (int i = 1; i <= minNumber; i++) {
                if (x % i == 0 && y % i == 0) {
                    nod = i;
                }
            }
            System.out.println(nod);
        } else throw new NumberFormatException();// создал исключение,если цифры <=0

    }
}