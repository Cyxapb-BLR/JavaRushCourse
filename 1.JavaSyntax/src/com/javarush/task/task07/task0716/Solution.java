package com.javarush.task.task07.task0716;

import java.util.ArrayList;

/* 
Р или Л
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("роза");
        strings.add("лоза");
        strings.add("лира");
        strings = fix(strings);

        for (String string : strings) {
            System.out.println(string);
        }
    }

    public static ArrayList<String> fix(ArrayList<String> strings) {
        for (int i = 0; i < strings.size();i++) {
            /*
            indexOf("р") - ищет элемент в строке и выдает его индекс,
            если элемент не найден, то выдает индекс равный " -1 "

            if (strings.get(i).indexOf("р") != -1 && strings.get(i).indexOf("л") != -1) {
            } else if (strings.get(i).indexOf("р") != -1) {
                strings.remove(i);
                i--;
            } else if (strings.get(i).indexOf("л") != -1)
                strings.add(++i, strings.get(i-1));
                */

            // contains ищет элемент в строке и выдает результат true, если он есть
            if (strings.get(i).contains("р") && strings.get(i).contains("л")) {

            } else if (strings.get(i).contains("р")) {
                strings.remove(i);
                i=i-1;
            } else if (strings.get(i).contains("л")) {
                strings.add(++i, strings.get(i-1));
            }
        }
        return strings;

        //напишите тут ваш код

    }
}