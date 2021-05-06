package com.javarush.task.task04.task0417;

/* 
Существует ли пара?
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
       BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
       String line1=reader.readLine(), line2=reader.readLine(),line3=reader.readLine();
       int a=Integer.parseInt(line1), b=Integer.parseInt(line2), c=Integer.parseInt(line3);
        if (a==b && b==c)
            System.out.println(a + " " + b + " " +c);
        else {
            if (a==b)
                System.out.println(a + " " + b);
            else {if (a == c)
                System.out.println(a + " " + c);
            else {if (b == c)
                System.out.println(b + " " + c);
                        }}}//напишите тут ваш код
        }

    }