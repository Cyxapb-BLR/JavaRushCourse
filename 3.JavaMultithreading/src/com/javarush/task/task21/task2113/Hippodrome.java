package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    private static List<Horse> horses = new ArrayList<>();          //пришлось поставить статик
    static Hippodrome game;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public void move() {
        for (Horse horse : horses) {
            horse.move();
        }
    }

    public void print() {
        for (Horse horse : horses) {
            horse.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Horse horse1 = new Horse("Свинни", 3, 0);
        Horse horse2 = new Horse("Пигги", 3, 0);
        Horse horse3 = new Horse("минисвинни", 3, 0);
        game = new Hippodrome(horses);                              //инициализируем поле game
        horses.add(horse1);
        horses.add(horse2);
        horses.add(horse3);
        game.run();
        game.printWinner();
    }

    public Horse getWinner() {
        Horse horseWinner = null;
        double max = -1;
        for (int i = 0; i < horses.size(); i++) {
            if (horses.get(i).distance > max) {
                max = horses.get(i).distance;
                horseWinner = horses.get(i);
            }
        }
        return horseWinner;
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().name + "!");
    }
}
