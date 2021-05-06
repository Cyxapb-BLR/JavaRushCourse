package com.javarush.task.task09.task0927;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
Десять котов
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap() {
        HashMap<String, Cat> catHashMap = new HashMap<>();
        catHashMap.put("Vaska", new Cat("Васька"));
        catHashMap.put("Mashka", new Cat("Машка"));
        catHashMap.put("Dymka", new Cat("Дымка"));
        catHashMap.put("Murka", new Cat("Мурка"));
        catHashMap.put("RyZyk", new Cat("Рыжик"));
        catHashMap.put("Boris", new Cat("Борис"));
        catHashMap.put("Kotleta", new Cat("Котлета"));
        catHashMap.put("Black", new Cat("Черный"));
        catHashMap.put("Belka", new Cat("Белка"));
        catHashMap.put("Tiger", new Cat("Тигр"));
        return catHashMap;
        //напишите тут ваш код
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map) {
        Set<Cat> catSet = new HashSet<>(map.values());
        for (Map.Entry<String , Cat> pair : map.entrySet()) {   //можно было просто написать:
            catSet.add(pair.getValue());                        // Set<Cat> catSet = new HashSet<>(map.values());
        }
        return catSet;

        //напишите тут ваш код
    }

    public static void printCatSet(Set<Cat> set) {
        for (Cat cat : set) {
            System.out.println(cat);
        }
    }

    public static class Cat {
        private String name;

        public Cat(String name) {
            this.name = name;
        }

        public String toString() {
            return "Cat " + this.name;
        }
    }


}