package com.javarush.task.task22.task2212;

/* 
Проверка номера телефона
*/

public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        //System.out.println(telNumber);
        if (telNumber != null) {
            boolean b = telNumber.matches("\\+\\d{12}|\\+\\d{2}\\(\\d{3}\\)\\d{7}|\\+\\d{8}\\-\\d{2}\\-\\d{2}|\\d{6}\\-\\d{4}");
            /*
            \\+\\d{12}                  для 1-го номера
            или |
            \+\d{2}\(\d{3}\)\d{7}       для 2-го
            или |
            \+\d{8}\-\d{2}\-\d{2}       для 3
            или |
            \d{6}\-\d{4}                для 4
             */
            return b;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkTelNumber("+375298513801"));
        System.out.println(checkTelNumber("+38(050)1234567"));
        System.out.println(checkTelNumber("+38050123-45-67"));
        System.out.println(checkTelNumber("050123-4567"));
        System.out.println(checkTelNumber("+38)050(1234567"));
        System.out.println(checkTelNumber("+38(050)1-23-45-6-7"));
        System.out.println(checkTelNumber("050ххх4567"));
        System.out.println(checkTelNumber("050123456"));
        System.out.println(checkTelNumber("(0)501234567"));
        System.out.println(checkTelNumber(null));
    }
}
