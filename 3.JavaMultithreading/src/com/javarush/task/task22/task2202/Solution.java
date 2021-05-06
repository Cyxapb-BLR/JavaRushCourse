package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) throws TooShortStringException {
        if (string != null) {
            String[] words = string.split(" ");              // разбиваем строку на слова по пробелам
            //System.out.println(Arrays.asList(words));

            if (words.length > 4) {                         //если массив имеет больше 4 слов, то он подхожит по условию(т.е. строка имеет минимум 4 пробела)
                String result = "";
                for (int i = 1; i < 4; i++) {               //начинаем склеивать со второго слова,т.к. новая строка должна начинаться с символа после первого пробела
                    result = result + words[i] + " ";
                }
                result = result + words[4];             //добавляем отдельно 6 слово,чтобы не было после него пробела
                return result;
            }
        }
        throw new TooShortStringException();        //бросаем исключение, если строка имеет меньше 4 пробелов либо =null
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
