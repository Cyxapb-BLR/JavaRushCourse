package com.javarush.task.task30.task3012;

/* 
Получи заданное число
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.createExpression(74);
    }

    public void createExpression(int number) {
        //74 = - 1 + 3 - 9 + 81
        StringBuilder builder = new StringBuilder(number + "=");
        int countFor3 = 0;
        do {
           int mod = number % 3;       //остаток от деления на 3
            if (mod == 1)
                builder.append("+").append((int) Math.pow(3, countFor3));
            if (mod == 2) {
                builder.append("-").append((int) Math.pow(3, countFor3));
                number++;
            }
            number = number / 3;
            countFor3++;
        } while (number > 0);
        System.out.println(builder);
        //напишите тут ваш код
    }
}