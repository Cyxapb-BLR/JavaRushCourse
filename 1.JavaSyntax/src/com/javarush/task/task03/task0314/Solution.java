package com.javarush.task.task03.task0314;

/* 
Таблица умножения
*/

public class Solution {
    public static void main(String[] args) {
       int x=1, y=1;
       while (x<=10){
        while (y<=10){
        System.out.print(x*y + " ");
        y++;// y++= y+1
        }
        System.out.println();
        x++;
        y=1;}//напишите тут ваш код

    }
}
