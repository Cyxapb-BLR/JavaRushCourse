package com.javarush.task.task08.task0824;

/*
Собираем семейство
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Human son1 = new Human("Sam", true, 35);
        Human daughter = new Human("Jen", false, 30);
        Human son2 = new Human("Nick", true, 27);
        // далее в парамете children для  всех родителей создаем список со всеми их детьми
        Human father = new Human("William", true, 60, new ArrayList<>(Arrays.asList(son1,daughter,son2)));
        Human mother = new Human("Britni", false, 53, new ArrayList<>(Arrays.asList(son1,daughter,son2)));
        Human grandfather1 = new Human("Bob", true, 95, new ArrayList<>(Arrays.asList(father)));
        Human grandmother1 = new Human("Barbara", false, 83, new ArrayList<>(Arrays.asList(father)));
        Human grandfather2 = new Human("Bil", true, 90, new ArrayList<>(Arrays.asList(mother)));
        Human grandmother2 = new Human("Barbara", false, 80, new ArrayList<>(Arrays.asList(mother)));


        //напишите тут ваш код
    }

    public static class Human {
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children = new ArrayList<>();


        public Human(String name, boolean sex, int age, ArrayList<Human> children) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
            System.out.println(this.toString());// вызов метода для печати
        }

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            System.out.println(this.toString());// вызов метода для печати
        }
//напишите тут ваш код

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }
}