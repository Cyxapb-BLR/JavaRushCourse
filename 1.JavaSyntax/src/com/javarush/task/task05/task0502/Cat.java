package com.javarush.task.task05.task0502;

/* 
Реализовать метод fight
*/

public class Cat {
    public int age;
    public int weight;
    public int strength;

    public Cat() {
    }

    public boolean fight(Cat anotherCat) {
        int win=0;

       if (this.age>anotherCat.age){
           win++;
       }
       else if (this.age<anotherCat.age){
           win--;
       }
       if (this.strength>anotherCat.strength){
           win++;
       }
       else if (this.weight<anotherCat.weight) {
           win--;
       }
       if (this.weight>anotherCat.weight){
           win++;
       }
       else if (this.weight<anotherCat.weight) {
           win--;
       }
       if (win>0) {
           return true;
       }else if (win==0)
           return false;
       else return false;

    }    //напишите тут ваш код


        public static void main(String[] args) {
            Cat cat1 = new Cat();
            cat1.age = 5;
            cat1.strength = 10;
            cat1.weight = 3;

            Cat cat2 = new Cat();
            cat2.age = 6;
            cat2.strength = 11;
            cat2.weight = 4;

            System.out.println(cat1.fight(cat2));
            System.out.println(cat2.fight(cat1));

        }
}
