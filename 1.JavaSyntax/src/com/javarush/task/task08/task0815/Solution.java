package com.javarush.task.task08.task0815;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*
Перепись населения
*/

public class Solution {
    public static Map<String, String> createMap() {
        Map<String, String> map = new HashMap<>();
        map.put("Мацкевич", "Вадим");
        map.put("Хаустова", "Екатерина");
        map.put("Лазука", "Вадим");
        map.put("Яскевич", "Ольга");
        map.put("Вечер", "Анастасия");
        map.put("Бересневич", "Антон");
        map.put("Устинов", "Александр");
        map.put("Приходько", "Анастасия");
        map.put("Киселев", "Александр");
        map.put("Зайко", "Ядвига");
        return map;
        //напишите тут ваш код

    }

    public static int getCountTheSameFirstName(Map<String, String> map, String name) {
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        int count = 0;
        //можно было решить через сокращенную форму итератора
        while (iterator.hasNext()) {
            Map.Entry<String, String> pair = iterator.next();
            if (pair.getValue().equals(name))
                count++;
        }
        return count;
        //напишите тут ваш код

    }

    public static int getCountTheSameLastName(Map<String, String> map, String lastName) {
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        //можно было решить через сокращенную форму итератора
        int count = 0;
        while (iterator.hasNext()) {
            Map.Entry<String, String> pair = iterator.next();
            if (pair.getKey().equals(lastName))
                count++;
        }
        return count;
        //напишите тут ваш код

    }

    public static void main(String[] args) {

    }
}