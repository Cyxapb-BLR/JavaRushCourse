package com.javarush.task.task06.task0609;

/* 
Расстояние между двумя точками
*/

public class Util {
    public static double getDistance(int x1, int y1, int x2, int y2) {

        double a = Math.sqrt( Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));
        /*
        Math.sqrt - корень квадратный
        Math.pow( x, y ) - возводит число x в степень y
         */
        return a;//напишите тут ваш код
    }

    public static void main(String[] args) {

    }
}
