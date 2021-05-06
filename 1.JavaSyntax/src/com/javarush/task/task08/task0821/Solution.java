package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/*
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleMap();
        printPeopleMap(map);
    }

    public static Map<String, String> createPeopleMap() {
        Map<String,String > map = new HashMap<>();
        map.put("Мацкевич", "Вадим");
        map.put("Хаустова", "Екатерина");
        map.put("Лазука", "Вадим");
        map.put("Мацкевич", "Ольга");
        map.put("Вечер", "Анастасия");
        map.put("Бересневич", "Антон");
        map.put("Устинов", "Александр");
        map.put("Приходько", "Анастасия");
        map.put("Киселев", "Александр");
        map.put("Ламковская", "Анастасия");
        //напишите тут ваш код

        return map;
    }

    public static void printPeopleMap(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
