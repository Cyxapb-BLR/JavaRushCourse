package com.javarush.task.task07.task0701;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 
Массивный максимум
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] array = initializeArray();
        int max = max(array);
        System.out.println(max);
    }

    public static int[] initializeArray() throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        int [] array= new int[20];
        for ( int i=0; i<array.length; i++){
            array[i] = Integer.parseInt(reader.readLine());
        }
        // создай и заполни массив
        return array;
    }

    public static int max(int[] array) {
        /*int max = array[0];
        for (int i = 0; i< array.length;i++){  //сравниваю каждый элемент массива с мах
            if (array[i]>max)                   //присваиваю новое значение для мах, если оно больше
                max = array[i];

        }*/
        Arrays.sort(array);  // сделал сортировку по возрастанию
        int max = array[19]; //вывел последний элемент массивва, который максимальный после сортировки

        // найди максимальное значение
        return max ;
    }
}
