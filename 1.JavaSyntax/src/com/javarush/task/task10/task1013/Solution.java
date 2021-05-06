package com.javarush.task.task10.task1013;

/*
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
        
    }

    public static class Human {
        private String firstName;
        private String lastName;
        private String sex;
        private int age;
        private int height;
        private int weight;

        public Human(String firstName) {
            this.firstName = firstName;
        }

        public Human(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public Human(String firstName, String lastName, String sex) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.sex = sex;
        }

        public Human(String firstName, String lastName, String sex, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.sex = sex;
            this.age = age;
        }

        public Human(String firstName, String lastName, String sex, int age, int height) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.sex = sex;
            this.age = age;
            this.height = height;
        }

        public Human(String firstName, String lastName, String sex, int age, int height, int weight) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.sex = sex;
            this.age = age;
            this.height = height;
            this.weight = weight;
        }

        public Human(String firstName, String sex, int age, int height, int weight) {
            this.firstName = firstName;
            this.sex = sex;
            this.age = age;
            this.height = height;
            this.weight = weight;
        }

        public Human(String firstName, int age) {
            this.firstName = firstName;
            this.age = age;
        }

        public Human(String firstName, String sex, int age) {
            this.firstName = firstName;
            this.sex = sex;
            this.age = age;
        }

        public Human(String firstName, String sex, int height, int weight) {
            this.firstName = firstName;
            this.sex = sex;
            this.height = height;
            this.weight = weight;
        }
// Напишите тут ваши переменные и конструкторы
    }
}