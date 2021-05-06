package com.javarush.task.task04.task0415;

/* 
Правило треугольника
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
       BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
       String line1=reader.readLine();
       String line2=reader.readLine();
       String line3=reader.readLine();

       int a=Integer.parseInt(line1);
       int b=Integer.parseInt(line2);
       int c=Integer.parseInt(line3);
       if ((a+b)>c & (a+c)>b & (b+c)>a)
           System.out.println("Треугольник существует.");
       else System.out.println("Треугольник не существует.");
       //напишите тут ваш код

    }
}