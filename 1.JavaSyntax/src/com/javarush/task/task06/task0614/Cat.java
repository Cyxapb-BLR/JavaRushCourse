package com.javarush.task.task06.task0614;
import java.util.*;
/*
Статические коты
*/

public class Cat {
    public static ArrayList<Cat> cats = new ArrayList<Cat>();
    public Cat() {
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            cats.add(new Cat());

        }
        printCats();
    }
    public static void printCats(){
        for (int i = 0; i < cats.size(); i++) { // потому что массив начинается с "0"
            System.out.println(cats.get(i));
        }
    }
}
