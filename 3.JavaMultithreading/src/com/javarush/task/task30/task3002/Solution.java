package com.javarush.task.task30.task3002;

/* 
Осваиваем методы класса Integer
*/

import java.math.BigInteger;

public class Solution {

    public static void main(String[] args) {
        System.out.println(convertToDecimalSystem("0x16")); //22
        System.out.println(convertToDecimalSystem("012"));  //10
        System.out.println(convertToDecimalSystem("0b10")); //2
        System.out.println(convertToDecimalSystem("62"));   //62
    }

    public static String convertToDecimalSystem(String s) {
        int numberSystemIntValue;
        String number;
        if (s.startsWith("0x")) {
            numberSystemIntValue = 16;
            number = s.substring(2);

        } else if (s.startsWith("0b")) {
            numberSystemIntValue = 2;
            number = s.substring(2);

        } else if (s.startsWith("0")) {
            numberSystemIntValue = 8;
            number = s.substring(1);

        } else {
            numberSystemIntValue = 10;
            number = s;
        }

        int integer = Integer.parseInt(number, numberSystemIntValue);

        s = Integer.toString(integer);

        //напишите тут ваш код
        return s;
    }
}
