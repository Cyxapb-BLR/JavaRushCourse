package com.javarush.task.task08.task0811;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* 
Квартет «Методы»
*/

public class Solution {
    public static List getListForGet() {
        ArrayList arrayList = new ArrayList();   // ArrayList работает быстрее для Get
        return arrayList;                           // чем LinkedList
        //напишите тут ваш код

    }

    public static List getListForSet() {
        ArrayList arrayList = new ArrayList();      // ArrayList работает быстрее для Set
        return arrayList;//напишите тут ваш код     // чем LinkedList

    }

    public static List getListForAddOrInsert() {     // LinkedList работает быстрее для Add
        LinkedList linkedList = new LinkedList();   // чем ArrayList
        return linkedList;
        //напишите тут ваш код

    }

    public static List getListForRemove() {         // LinkedList работает быстрее для Remove
        LinkedList linkedList = new LinkedList();   // чем ArrayList
        return linkedList;
        //напишите тут ваш код

    }

    public static void main(String[] args) {

    }
}
