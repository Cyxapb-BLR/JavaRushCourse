package com.javarush.task.task19.task1919;

import java.io.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/* 
Считаем зарплаты
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // надо было решать через BufferedReader rd = new BufferedReader(new FileReader(fileName)),читать по строке и массив сплитовать по пробелам
        String fileName = args[0];
        FileReader fileReader = new FileReader(fileName);
        ArrayList<String> list = new ArrayList<>();
        String wordOrNumber = "";
        TreeMap<String, Double> treeMap = new TreeMap<>();
        while (fileReader.ready()) {
            int data = fileReader.read();
            wordOrNumber = wordOrNumber + (char) data;//склеиваем байты приведенные к символам в слово/число
            //System.out.println(wordOrNumber);
            if ((char) data == ' ' || (char) data == '\n') { //выделяяем слова/числа по пробелу либо переносу строки
                list.add(wordOrNumber.trim());// дополнительно обрезаем пробелы либо перенос строки
                wordOrNumber = "";
            }

        }
        fileReader.close();
        list.add(wordOrNumber);// последнее слово или число в файле

        for (int i = 0; i < list.size(); i = i + 2) {
            double number = 0;
            for (int j = i; j < list.size(); j = j + 2) {
                if (list.get(i).equals(list.get(j))) { //сравниваем каждое имя с другими именами
                    number = number + Double.parseDouble(list.get(j + 1)); //если имя совпало,то к складывваем значения для этого имени
                }
            }
            if (!treeMap.containsKey(list.get(i))) {// если нет ключа с текущим именем,то создаем его
                treeMap.put(list.get(i), number);
            }
        }
        for (Map.Entry<String, Double> pair : treeMap.entrySet()
        ) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
    }
}
