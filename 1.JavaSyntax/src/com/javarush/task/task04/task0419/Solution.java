package com.javarush.task.task04.task0419;

/* 
Максимум четырех чисел
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String line1=reader.readLine();
        String line2=reader.readLine();
        String line3=reader.readLine();
        String line4=reader.readLine();

        int a=Integer.parseInt(line1);
        int b=Integer.parseInt(line2);
        int c=Integer.parseInt(line3);
        int d=Integer.parseInt(line4);
        if (a>=b && a>=c && a>=d)
            System.out.println(a);
        else if (b>=c && b>=d)
            System.out.println(b);
        else if (c>=d)
            System.out.println(c);
        else System.out.println(d);
        //напишите тут ваш код

    }
}
