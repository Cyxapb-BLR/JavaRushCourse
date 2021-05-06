package com.javarush.task.task05.task0510;

/* 
Кошкоинициация
*/

public class Cat {
    String name=null;
    int age=5;
    int weight=5;
    String address=null;
    String color="black";

    public void initialize(String name){
        this.name=name;
        this.age=age;
        this.weight=weight;
        this.color=color;
        this.address=address;
    }
    public void initialize(String name,int weight,int age){
        this.name=name;
        this.weight=weight;
        this.age=age;
        this.color=color;
    }
    public void initialize(String name, int age){
        this.name=name;
        this.age=age;
        this.weight=weight;
        this.color=color;
    }
    public void initialize(int weight, String color){
        this.name=name;
        this.weight=weight;
        this.address=address;
        this.color=color;
    }
    public void initialize(int weight, String color, String address){
        this.name=name;
        this.age=age;
        this.weight=weight;
        this.color=color;
        this.address=address;
    }

    //напишите тут ваш код

    public static void main(String[] args) {

    }
}
