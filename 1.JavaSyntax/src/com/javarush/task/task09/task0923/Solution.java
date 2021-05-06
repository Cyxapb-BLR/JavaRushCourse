package com.javarush.task.task09.task0923;

/*
Гласные и согласные
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String lane = reader.readLine();
        lane = lane.replace(" ", "");
        char[] laneList = lane.toCharArray(); // преобразую строку в массив символов

        ArrayList<Character> vowelsList = new ArrayList<>(); // для гласных
        ArrayList<Character> consonantList = new ArrayList<>(); // для согласных
        for (int i = 0; i < laneList.length; i++) {
            if (isVowel(laneList[i])) {
                vowelsList.add(laneList[i]);
            } else consonantList.add(laneList[i]);
        }
        for (char s : vowelsList) {
            System.out.print(s + " ");
        }
        System.out.println();
        for (char m : consonantList) {
            System.out.print(m + " ");
        }
        //напишите тут ваш код
    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам
        for (char d : vowels) {  // ищем среди массива гласных
            if (c == d) {
                return true;
            }
        }
        return false;
    }
}