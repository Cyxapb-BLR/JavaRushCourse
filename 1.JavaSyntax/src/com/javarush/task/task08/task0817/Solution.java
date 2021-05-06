package com.javarush.task.task08.task0817;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*
Нам повторы не нужны
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
        map.put("Ламковская", "Анастасия");
        return map;
        //напишите тут ваш код

    }

    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
        Map<String, String> copyMap = new HashMap<>(map);
        Iterator<Map.Entry<String, String>> iterator = copyMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> pair = iterator.next();
            String value = pair.getValue();
            Iterator<Map.Entry<String ,String >> iterator1 = copyMap.entrySet().iterator();
            while (iterator1.hasNext()){
                Map.Entry<String ,String > pair2 = iterator1.next();
                String value1 = pair2.getValue();
                if (value.equals(value1) && !pair.getKey().equals(pair2.getKey())) // ищем одинаковые значения с разными ключами
                    removeItemFromMapByValue(map, value);
            }
        }

        //напишите тут ваш код

    }

    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        Map<String, String> copy = new HashMap<>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value)) {
                map.remove(pair.getKey());
            }
        }
    }

    public static void main(String[] args) {

    }
}