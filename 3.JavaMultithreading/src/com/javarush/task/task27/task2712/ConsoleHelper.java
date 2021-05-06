package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


    public static void writeMessage(String message) {       // для вывода message в консоль
        System.out.println(message);
    }

    public static String readString() throws IOException {      //для чтения строки с консоли
        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {       //просит пользователя выбрать блюдо и добавляет его в список.
        List<Dish> list = new ArrayList<>();
        writeMessage(Dish.allDishesToString());                           //Выведи список всех блюд и попроси пользователя ввести строку - название блюда.
        ConsoleHelper.writeMessage("Введите название блюда");//попроси пользователя ввести строку - название блюда.
        String dishName = ConsoleHelper.readString();
        while (!dishName.equals("exit")) {
            int size = list.size();
            for (Dish dish : Dish.values()) {
                if (dish.name().equals(dishName)) {
                    list.add(dish);
                }
            }
            if (size == list.size())
                ConsoleHelper.writeMessage("такого блюда нет");
            dishName = ConsoleHelper.readString();
        }
        return list;
    }
}
