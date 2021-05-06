package com.javarush.task.task19.task1920;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* 
Самый богатый
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = args[0];
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        TreeMap<String, Double> treeMap = new TreeMap<>();// для сортировки по ключу(алфавиту)
        //TreeSet<String> names = new TreeSet<>();//сортировка итогового списка с макс значениями
        double max ;
        while (reader.ready()) {
            String line = reader.readLine(); //читаем по строке
            String[] element = line.split(" ", 2); // делим строку по пробелу на элементы
            double number = Double.parseDouble(element[1]);
            if (treeMap.containsKey(element[0])) { //если есть уже такой ключ,то к значению добавляем новое
                double newValue = treeMap.get(element[0]) + number;// добавляем к текушему значению новое значение для данного ключа
                treeMap.put(element[0], newValue); // обновляем значение ключа
            }
            if (!treeMap.containsKey(element[0])) {//иначе создаем новый ключ со значеним
                treeMap.put(element[0], number);

            }
        }
        reader.close();
        max = Collections.max(treeMap.values());
        //System.out.println(max);
        for (Map.Entry<String, Double> pair : treeMap.entrySet()) {
            if (pair.getValue().equals(max)) { //ищем ключи с макс значением в value
                System.out.println(pair.getKey());
                //names.add(pair.getKey());// добавляем в treeset для сортировки по алфавиту
            }
        }
        /*for (String name : names) {
            System.out.println(name);
        }*/
    }
}
