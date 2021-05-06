package com.javarush.task.task04.task0414;

/* 
Количество дней в году
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
       BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
       String line=reader.readLine();
       int year=Integer.parseInt(line);
       int x;
       //можно было заменить все решение тремя строками
        // year%400==0 - деление year на 400 без остатка
       //if (year%400==0 || year%100!=0 && year%4==0 )
       //{x=366;}
       //else {x=365;}
        x=year/400;
        int day=(year-x*400);
        if (day==0){
                x=366;}
        else { {x=year/100;
            day=year-x*100;}
            if (day==0)
                x=365;
            else {{x=year/4;
                day=year-x*4;}
                if (day==0)
                    x=366;
                else x=365;}}

        System.out.println("количество дней в году: "+ x);//напишите тут ваш код
    }
}