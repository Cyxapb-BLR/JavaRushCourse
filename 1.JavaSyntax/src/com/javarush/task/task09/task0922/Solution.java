package com.javarush.task.task09.task0922;

/*
Какое сегодня число?
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(reader.readLine());// в " " указываем в каком виде поступает дата с клавы

        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM d, yyyy", Locale.ENGLISH);// в " " указываем в каком формате хотим смотреть форматированную дату + локализации ENGLISH(без нее тоже работает)
        System.out.println(dateFormat.format(date).toUpperCase()); // выводим дату в нужном формате + название месяца делаем большими буквами

        //напишите тут ваш код
    }
}