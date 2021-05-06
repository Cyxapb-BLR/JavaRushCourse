package com.javarush.task.task06.task0610;

/* 
Класс ConsoleReader
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ConsoleReader {
    public static String readString() throws Exception {
        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
        String lane=reader.readLine();
        return lane;

        //напишите тут ваш код

    }

    public static int readInt() throws Exception {
        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(reader.readLine());
        return number;

        //напишите тут ваш код

    }

    public static double readDouble() throws Exception {
        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
        double doublenumber = Double.parseDouble(reader.readLine());
        return doublenumber;

        //напишите тут ваш код

    }

    public static boolean readBoolean() throws Exception {
        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
        boolean trueORfalse = Boolean.parseBoolean(reader.readLine());
        return trueORfalse;

        //напишите тут ваш код

    }

    public static void main(String[] args) throws Exception {

    }
}
