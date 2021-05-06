package com.javarush.task.task12.task1204;

/*
То ли птица, то ли лампа
*/

public class Solution {
    public static void main(String[] args) {
        printObjectType(new Cat());
        printObjectType(new Bird());
        printObjectType(new Lamp());
        printObjectType(new Cat());
        printObjectType(new Dog());
    }

    public static void printObjectType(Object o) {
        //сравниваем переданный объект с возможными классами
        if (Cat.class.equals(o.getClass())) { // можно заменить на :**** if (o instanceof Cat)  ***
            System.out.println("Кошка");
        }
        if (Bird.class.equals(o.getClass())) {
            System.out.println("Птица");
        }
        if (Lamp.class.equals(o.getClass())) {
            System.out.println("Лампа");
        }
        if (o.getClass().equals(Dog.class)) {
            System.out.println("Собака");
        }
        //Напишите тут ваше решение
    }

    public static class Cat {
    }

    public static class Dog {
    }

    public static class Bird {
    }

    public static class Lamp {
    }
}