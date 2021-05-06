package com.javarush.task.task07.task0715;

/* 
Продолжаем мыть раму
*/

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("мама");
        list.add("мыла");
        list.add("раму");

        /*Collections.addAll(list, "мама", "мыла", "раму");
        можно заменить этой строчкой ввод сразу всех значений
         */
        for (int i = 0; i < list.size(); i++) {

            /*if (list.get(i) != "именно")
            list.add(i + 1, "именно"); // решение работает
            if (list.size() == 6)
                break;*/

            list.add(++i, "именно");  //    ++i тоже самое i=i+1;
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        //напишите тут ваш код
    }
}
