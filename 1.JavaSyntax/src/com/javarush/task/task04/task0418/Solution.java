package com.javarush.task.task04.task0418;

/* 
Минимум двух чисел Ӏ Java Syntax: 4 уровень, 6 лекция
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String line1=reader.readLine(), line2=reader.readLine();
        int x=Integer.parseInt(line1),y=Integer.parseInt(line2);
        if(x<=y)
            System.out.println(x);
        else System.out.println(y);//напишите тут ваш код

    }
}