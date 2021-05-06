package com.javarush.task.task07.task0702;

/* 
Массив из строчек в обратном порядке
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String [] array = new String[10];
        for (int i=2 ; i<10 ; i++){
            array[i]=reader.readLine();
        }

        for (int i=array.length-1 ; i>=0 ; i--){
            System.out.println(array[i]);
        }


        //напишите тут ваш код
    }
}