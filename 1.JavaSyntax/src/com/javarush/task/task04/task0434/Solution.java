package com.javarush.task.task04.task0434;

/* 
Таблица умножения Ӏ Java Syntax: 4 уровень, 10 лекция
*/

public class Solution {
    public static void main(String[] args) {
        int x=1, y=1;
        while (x<=10){
            while (y<=10){
                System.out.print(x*y+ " ");
                y++;
            }
            System.out.println();
            x++;
            y=1;
        }   //напишите тут ваш код

    }
}
