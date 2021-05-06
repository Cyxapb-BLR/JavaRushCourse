package com.javarush.task.task22.task2203;

/* 
Между табуляциями
*/

public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        int count = 0;
        int beginIndex = 0;                             //для первого индекса табуляции
        int endIndex = 0;                               //для второго индекса табуляции
        if (string != null) {
            for (int i = 0; i < string.length(); i++) {
                if (string.indexOf("\t", i) >= 0) {     //проверяем содержит ли строка символ табуляции
                    int index = string.indexOf("\t", i);// индекс символа табуляции в строке
                    i = index;                              //присваиваем найденный индекс,чтобы следующий цикл начался со следующего индекса стрки, после найденного индекса табуляции
                    count++;
                    if (count == 1) {
                        beginIndex = index + "\t".length();
                    }
                    if (count == 2) {               //если нашли 2й индекс,то можно возвращать обрезанную строку
                        endIndex = index;
                        return string.substring(beginIndex, endIndex);
                    }
                }
            }
        }
        // если string = null || count<2, то бросаем исключение
        throw new TooShortStringException();
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }
}
