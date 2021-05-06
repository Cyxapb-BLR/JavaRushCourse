package com.javarush.task.task15.task1518;

/*
Статики и котики
*/

public class Solution {
    public static class Cat {
        public String name;
    }
    static {
        cat = new Cat();
        Solution.cat.name="Vaska";
        System.out.println(Solution.cat.name);
    }

    public static Cat cat;

    public static void main(String[] args) {

    }
}