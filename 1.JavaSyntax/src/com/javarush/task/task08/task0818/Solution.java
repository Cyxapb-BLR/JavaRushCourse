package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*
Только для богачей
*/

public class Solution {
    public static Map<String, Integer> createMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("Smith", 520);
        map.put("Trump", 320);
        map.put("Clinton", 560);
        map.put("Bush", 622);
        map.put("Kenedy", 423);
        map.put("Daisy", 890);
        map.put("Jane", 1070);
        map.put("Agilera", 915);
        map.put("Madonna", 530);
        map.put("Franklin", 440);
        return map;
        //напишите тут ваш код
    }

    public static void removeItemFromMap(Map<String, Integer> map) {
        Iterator<Map.Entry<String ,Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String,Integer> pair = iterator.next();
            if (pair.getValue()<500)
                iterator.remove();
        }return;
        //напишите тут ваш код
    }

    public static void main(String[] args) {

    }
}