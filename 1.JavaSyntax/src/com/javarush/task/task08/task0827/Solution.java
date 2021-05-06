package com.javarush.task.task08.task0827;

/*
Работа с датой
*/

import java.util.Date;

public class Solution {
    public static void main(String[] args) {
        System.out.println(isDateOdd("MAY 1 2013"));
    }

    public static boolean isDateOdd(String date) {
        Date date1 = new Date(date);
        Date date2 = new Date("JAN 1 " + date1.getYear());// добавляем такой же год к дате
        long x = date1.getTime() - date2.getTime(); // результат между датами в милисекундах
        int day = 24 * 60 * 60 * 1000;  //количество милисекунд в сутках
        long days = x / day;  //количество суток

        if (days % 2 == 0)  // смотрим четное или нечетное количество суток
            return true;
        else
            return false;

    }
}