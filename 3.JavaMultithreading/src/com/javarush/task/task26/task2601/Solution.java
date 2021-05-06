package com.javarush.task.task26.task2601;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/* 
Почитать в инете про медиану выборки
*/

public class Solution {

    public static void main(String[] args) {
        Integer[] array = {13, 8, 15, 5, 17};
        Integer[] array1 = {8, 15, 5, 17};
        //System.out.println(Arrays.toString(sort(array)));
        //System.out.println(Arrays.toString(sort(array1)));
    }

    public static Integer[] sort(Integer[] array) {
        Arrays.sort(array);                                             //сортируем массив чисел по возрастанию
        //System.out.println(Arrays.toString(array));
        int median;
        if (array.length % 2 != 0)
            median = array[array.length / 2];                          //находим медиану для массива, который имеет нечетную длину
        else {
            median = (array[array.length / 2 ] + array[array.length / 2 - 1]) / 2;        //      -//- четную длину
        }
        //System.out.println(median);
        Comparator<Integer> integerComparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {                //берем модуль |median - o1|, т.к нужно сранивать числа по удалению от медианы
                return Math.abs(median - o1) - Math.abs(median - o2);
            }
        };
        Arrays.sort(array, integerComparator);                          //сортируем массив с учетом работы компаратора
        //System.out.println(Arrays.toString(array));

        //implement logic here
        return array;
    }
}
