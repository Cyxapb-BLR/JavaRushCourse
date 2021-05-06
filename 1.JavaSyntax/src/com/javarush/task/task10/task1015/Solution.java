package com.javarush.task.task10.task1015;

import java.util.ArrayList;

/*
Массив списков строк
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String>[] arrayOfStringList = createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList() {
        ArrayList<String> list = new ArrayList<>();//создаю и заполняю список строками
        list.add("первая строка");
        list.add("вторая строка");
        list.add("третья строка");
        ArrayList<String>[] arrayLists = new ArrayList[3];// создаю массив для списков
        arrayLists[0] = list; // в каждый элемент массива вставляю список
        arrayLists[1] = list;
        arrayLists[2] = list;
        //напишите тут ваш код

        return arrayLists;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList) {
        for (ArrayList<String> list : arrayOfStringList) {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}