    package com.javarush.task.task05.task0526;

    /*
    Мужчина и женщина
    */

    public class Solution {
        public static void main(String[] args) {
            Man man1 = new Man("Bob", 41, "Brooklyn" );
            Man man2=  new Man("William", 62, "Manhattan");
            Woman woman1 = new Woman("Jennifer", 37, "New Jersey");
            Woman woman2 = new Woman("Jessica", 23, "Chicago");
            System.out.println(man1.name + " " + man1.age + " " + man1.address);
            System.out.println(man2.name + " " + man2.age + " " + man2.address);
            System.out.println(woman1.name + " " + woman1.age + " " + woman1.address);
            System.out.println(woman2.name + " " + woman2.age + " " + woman2.address);
            //напишите тут ваш код
        }

        public static class Man {
            String name;
            int age;
            String address;

            public Man( String name, int age , String address){
                this.name=name;
                this.age=age;
                this.address=address;
            }
        }
        public static class Woman {
            String name;
            int age;
            String address;

            public Woman( String name, int age, String address){
                this.name=name;
                this.age=age;
                this.address=address;
            }
        }
        //напишите тут ваш код
    }
