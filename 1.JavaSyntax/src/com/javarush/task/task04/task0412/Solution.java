package com.javarush.task.task04.task0412;

/* 
Положительное и отрицательное число
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //System.out.println(" введите число");
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String line=reader.readLine();
        int x=Integer.parseInt(line); //преобразуем циры в строке с типом String в число
        //System.out.println(" Ввели число " + x);
        if (x>0)
            x=x*2;
        else if (x<0)
            x=x+1;
        System.out.println(x);// выводим число,которое ввели с клавы//напишите тут ваш код

    }

}