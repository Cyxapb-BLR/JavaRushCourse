package com.javarush.task.task03.task0303;

/* 
Обмен валют
*/

public class Solution {
    public static void main(String[] args) {
       
       System.out.println(convertEurToUsd(25, 0.8));
       System.out.println(convertEurToUsd(100, 0.9));
    }

    public static double convertEurToUsd(int eur, double exchangeRate) {
       
        return eur*exchangeRate;//напишите тут ваш код

    }
}
