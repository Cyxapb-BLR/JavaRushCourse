package com.javarush.task.task08.task0819;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
Set из котов
*/

public class Solution {
    public static void main(String[] args) {
        Set<Cat> cats = createCats();
        cats.remove(cats.iterator().next()); //удаление первого попавшегося кота через итератор
        /*for (Cat cat : cats) {  второй способ удаления , не проверил,возможно не работает
            cats.remove(cat);
        }*/
        //напишите тут ваш код. step 3 - пункт 3

        //****** через полную запись итератора(работает): ******
        /*Iterator<Cat> iterator = cats.iterator();
        while (iterator.hasNext()){
            iterator.next();
            iterator.remove();
            break;
        }*/

        printCats(cats);
    }

    public static Set<Cat> createCats() {
        Set<Cat> set = new HashSet<>();
        for (int i = 0; i < 3; i++) {   //создаем три кота и помещаем их в set
            Cat cat = new Cat();
            set.add(cat);
        }
        //напишите тут ваш код. step 2 - пункт 2
        return set;
    }

    public static void printCats(Set<Cat> cats) {
        for (Cat text : cats) {
            System.out.println(text);

        }
        // step 4 - пункт 4
    }

    // step 1 - пункт 1
    public static class Cat {

    }
}