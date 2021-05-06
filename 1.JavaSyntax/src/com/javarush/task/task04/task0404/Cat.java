package com.javarush.task.task04.task0404;

/* 
Учет котов
*/

public class Cat {
    private static int catsCount = 0;

    public static void addNewCat() {
        Cat.catsCount++;
        //напишите тут ваш код

    }

    public static void main(String[] args) {
        Cat cat1=new Cat(); //создал котов для наглядности
        cat1.addNewCat();
        Cat cat2=new Cat();
        cat2.addNewCat();
        System.out.println(Cat.catsCount);// вывел количество котов для наглядности

    }
}
