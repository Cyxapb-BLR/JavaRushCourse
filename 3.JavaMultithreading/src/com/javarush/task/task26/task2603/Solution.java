package com.javarush.task.task26.task2603;

import java.util.Comparator;

/* 
Убежденному убеждать других не трудно
*/

public class Solution {
    public static class CustomizedComparator<T> implements Comparator<T> {
        private Comparator<T>[] comparators;

        public CustomizedComparator(Comparator<T>... comparators) {
            this.comparators = comparators;
        }

        @Override
        public int compare(T o1, T o2) {
            for (Comparator<T> comparator : comparators) {      //проходимся по всем типам компараторов
                int result = comparator.compare(o1, o2);
                if (result != 0)                                //если сравнение объектов !=0, т.е объекты не равны, то:
                    return result;                              //возвращаем результат сравнения
            }
            return 0;                                           //иначе объекты равны и возаращаем 0
        }
    }

    public static void main(String[] args) {

    }
}
