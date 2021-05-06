package com.javarush.task.task06.task0622;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 
Числа по возрастанию
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number1 = Integer.parseInt(reader.readLine());
        int number2 = Integer.parseInt(reader.readLine());
        int number3 = Integer.parseInt(reader.readLine());
        int number4 = Integer.parseInt(reader.readLine());
        int number5 = Integer.parseInt(reader.readLine());
        int [] array = { number1,number2, number3, number4, number5};

        Arrays.sort(array); // сортировка элементов массива

        for ( int i=0; i<5; i++ ){


        System.out.println(array[i]);}

        //напишите тут ваш код
    }
}
