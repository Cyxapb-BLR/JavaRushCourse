package com.javarush.task.task08.task0801;

/* 
Set из растений
*/

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("арбуз");
        set.add("банан");
        set.add("вишня");
        set.add("груша");
        set.add("дыня");
        set.add("ежевика");
        set.add("женьшень");
        set.add("земляника");
        set.add("ирис");
        set.add("картофель");

        for (String s : set) {      //это сокращенный вывод через iterator
            System.out.println(s);
        }
        /*     это полная форма вывода через iterator
        Iterator<String> iterator = set.iterator();

        while (iterator.hasNext()) {
            String s = iterator.next();
            System.out.println(s);
        }*/

        //напишите тут ваш код

    }
}
