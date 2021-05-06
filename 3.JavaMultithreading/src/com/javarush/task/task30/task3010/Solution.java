package com.javarush.task.task30.task3010;

import java.math.BigInteger;
import java.util.regex.Pattern;

/* 
Минимальное допустимое основание системы счисления
*/

public class Solution {
    public static void main(String[] args) {
        String result = "incorrect";
        for (int i = 2; i < 37; i++) {
            try {
                BigInteger bigInteger = new BigInteger(args[0], i);
                result = "" + i;
                break;
            } catch (Exception e) {

            }
        }
        System.out.println(result);
        //напишите тут ваш код
    }
}