package com.javarush.task.task01.task0132;

/* 
Сумма цифр трехзначного числа
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(sumDigitsInNumber(546));
    }

    public static int sumDigitsInNumber(int number) {
        int x=number/100;
        number=number-x*100;
        int y=number/10;
        number=number-y*10;
        return number+x+y;
        //напишите тут ваш код
    }
}