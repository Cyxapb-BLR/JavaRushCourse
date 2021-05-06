package com.javarush.task.task07.task0703;

/* 
Общение одиноких массивов
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
       int [] arrayNumber = new int[10];
       String [] arrayLane = new String[10];
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        for (int i=0 ; i<arrayLane.length; i++){
            arrayLane[i] = reader.readLine();
            arrayNumber[i] = arrayLane[i].length();
            System.out.println(arrayNumber[i]);}
        //напишите тут ваш код
    }
}
