package com.javarush.task.task09.task0910;

import java.util.ArrayList;

/*
Исключение при работе с коллекциями List
*/

public class Solution {
    public static void main(String[] args) {
        try {
            ArrayList<String> list = new ArrayList<String>();
            String s = list.get(18);

        }
        //напишите тут ваш код

        catch (IndexOutOfBoundsException e){
            System.out.println(" исключение типа IndexOutOfBoundsException");
        }

        //напишите тут ваш код
    }
}