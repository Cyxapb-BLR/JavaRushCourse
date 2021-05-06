package com.javarush.task.task08.task0820;

import java.util.HashSet;
import java.util.Set;

/*
Множество всех животных
*/

public class Solution {
    public static void main(String[] args) {
        Set<Cat> cats = createCats();
        Set<Dog> dogs = createDogs();

        Set<Object> pets = join(cats, dogs);
        printPets(pets);

        removeCats(pets, cats);
        printPets(pets);
    }

    public static Set<Cat> createCats() {
        Set<Cat> result = new HashSet<Cat>();
        for (int i = 0; i < 4; i++) { // создаем 4 кота
            result.add(new Cat());
        }
        //напишите тут ваш код

        return result;
    }

    public static Set<Dog> createDogs() {
        Set<Dog> result2 = new HashSet<>();
        for (int i = 0; i < 3; i++) { //создаем 3 собаки
            result2.add(new Dog());
        }
        //напишите тут ваш код
        return result2;
    }

    public static Set<Object> join(Set<Cat> cats, Set<Dog> dogs) {
        Set<Object> set = new HashSet<>();
        set.addAll(cats); //добавляем сразу всех котов
        set.addAll(dogs); //добавляем сразу всех собак
        //напишите тут ваш код
        return set;
    }

    public static void removeCats(Set<Object> pets, Set<Cat> cats) {
        pets.removeAll(cats); //удаляем из множества всех котов
        //напишите тут ваш код
    }

    public static void printPets(Set<Object> pets) {
        for (Object text : pets) { // сокращенная форма для вывода на экран
            System.out.println(text);
        }
        //напишите тут ваш код
    }

    public static class Dog {
        public Dog() { //конструктор без параметров,можно без него как в Cat
        }
    }

    public static class Cat {

    }

    //напишите тут ваш код
}
