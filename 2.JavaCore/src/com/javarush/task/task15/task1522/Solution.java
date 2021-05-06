package com.javarush.task.task15.task1522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Закрепляем паттерн Singleton
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(thePlanet.getClass().getSimpleName());
    }

    public static Planet thePlanet;

    static {
        try {
            readKeyFromConsoleAndInitPlanet();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //add static block here - добавьте статический блок тут

    public static void readKeyFromConsoleAndInitPlanet() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        if (s.equals(Planet.SUN)) {
            thePlanet =new Sun();
        } else if (s.equals(Planet.EARTH)) {
            thePlanet = new Earth();
        } else if (s.equals(Planet.MOON)) {
            thePlanet = new Moon();
        } else thePlanet = null;
        // implement step #5 here - реализуйте задание №5 тут
    }
}