package com.javarush.task.task08.task0814;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
Больше 10? Вы нам не подходите
*/

public class Solution {
    public static Set<Integer> createSet() {
        Set<Integer> set = new HashSet<>();
        set.add(11);
        set.add(23);
        set.add(5);
        set.add(3);
        set.add(1);
        set.add(7);
        set.add(8);
        set.add(12);
        set.add(10);
        set.add(2);
        set.add(4);
        set.add(9);
        set.add(6);
        set.add(13);
        set.add(25);
        set.add(45);
        set.add(0);
        set.add(21);
        set.add(19);
        set.add(26);
        return set;
        // напишите тут ваш код

    }

    public static Set<Integer> removeAllNumbersGreaterThan10(Set<Integer> set) {
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            Integer number = iterator.next();
            if (number > 10) {
                iterator.remove();
            }
        }
        return set;

        // напишите тут ваш код

    }

    public static void main(String[] args) {

    }
}
