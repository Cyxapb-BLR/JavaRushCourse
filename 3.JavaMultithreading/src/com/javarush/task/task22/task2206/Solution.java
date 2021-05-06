package com.javarush.task.task22.task2206;

import java.util.Date;

/* 
Форматирование даты
*/

public class Solution {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(String.format(getFormattedString(), date, date, date, date, date, date));
        //должен быть вывод аналогичный следующему
        //31:10:13 15:59:59
    }

    public static String getFormattedString() {
        /* все можно посмотреть в документации java для format string
        *   %td - получаем день в числовом формате
        *   %tm - получаем месяц в числовом формате
        *   %ty - год в числовом формате
        *   %th - месяц в букв формате(Dec)
        *   %tH:%tM:%tS - часы, минуты и секунды соотвественно
        * */
        return "%td:%tm:%ty %tH:%tM:%tS";
    }
}
