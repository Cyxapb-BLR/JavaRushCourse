package com.javarush.task.task06.task0611;

/* 
Класс StringHelper
*/

public class StringHelper {
    public static String multiply(String s) {
        String result = "";
        for (int i=1; i<=5;i++){
            result=result+s; } // result+=s
        //напишите тут ваш код
        return result;
    }

    public static String multiply(String s, int count) {
        String result = "";
        for (int i=1; i<=count; i++ ){
            result+=s;} // result = result + s
        //напишите тут ваш код
        return result;
    }

        public static void main(String[] args) {
            System.out.println(multiply("amigo"));
            System.out.println(multiply("Amigo", 18));

        }
    }

