package com.javarush.task.task06.task0612;

/* 
Калькулятор
*/

import javax.swing.*;

public class Calculator {
    public static int plus(int a, int b) {
        int plus=a+b;//напишите тут ваш код
        return plus;
    }

    public static int minus(int a, int b) {
        int minus=a-b;//напишите тут ваш код
        return minus;
    }

    public static int multiply(int a, int b) {
        int multiply=a*b;//напишите тут ваш код
        return multiply;
    }

    public static double division(int a, int b) {
        double division= (double) a/b;
        //напишите тут ваш код
        return division;
    }

    public static double percent(int a, int b) {
        double procent= ( double) a*b/100;
        //напишите тут ваш код
        return procent;
    }

    public static void main(String[] args) {
        System.out.println(plus(2, 5));
        System.out.println(minus(2, 5));
        System.out.println(multiply(2, 5));
        System.out.println(division(5, 2));
        System.out.println(percent(20, 10));

    }
}