package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

public class Solution {
    public static void main(String[] args) {
        Human grandfather1= new Human("Alex",true,85 );
        Human grandfather2= new Human("Bob",true,90);
        Human grandmother1 = new Human("Sara", false,87);
        Human grandmother2 = new Human("Jef", false,87);
        Human father = new Human("Sam", true,45,grandfather1,grandmother1);
        Human mother = new Human("Lane", false,37,grandfather2,grandmother2);
        Human child1 = new Human("William", true,15,father,mother);
        Human child2 = new Human("Jon", true,17,father,mother);
        Human child3 = new Human("Jessi",false,11,father,mother);

        System.out.println(grandfather1);
        System.out.println(grandfather2);
        System.out.println(grandmother1);
        System.out.println(grandfather2);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(child1);
        System.out.println(child2);
        System.out.println(child3);

        // напишите тут ваш код
    }

    public static class Human {
        private String name;
        private boolean sex;
        private int age;
        Human father;
        Human mother;

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, boolean sex, int age, Human father, Human mother) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }
        // напишите тут ваш код

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null) {
                text += ", отец: " + this.father.name;
            }

            if (this.mother != null) {
                text += ", мать: " + this.mother.name;
            }

            return text;
        }
    }
}