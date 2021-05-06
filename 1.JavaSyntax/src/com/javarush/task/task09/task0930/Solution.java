package com.javarush.task.task09.task0930;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
/*
Задача по алгоритмам Ӏ Java Syntax: 9 уровень, 11 лекция
*/
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) {
                break;
            }
            list.add(s);
        }
        String[] array = list.toArray(new String[0]);
        sort(array);
        for (String x : array) {
            System.out.println(x);
        }
    }
    public static void sort(String[] array) {
        String[] arraySort = new String[array.length];
        ArrayList<String> laneList = new ArrayList<>();
        ArrayList<Integer> numberList = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (isNumber(array[i])) {
                numberList.add(Integer.parseInt(array[i]));
            } else {
                laneList.add(array[i]);
            }
        }
        Collections.sort(numberList);
        Collections.reverse(numberList);
        isGreaterThan("aff", "hsh");
        Collections.sort(laneList);
        for (int i = 0; i < array.length; i++) {
            if (i < numberList.size())
                array[i] = numberList.get(i).toString();
            else array[i] = laneList.get(i + laneList.size() - array.length);
        }
        // напишите тут ваш код
    }
    // Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }
    // Переданная строка - это число?
    public static boolean isNumber(String s) {
        if (s.length() == 0) {
            return false;
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((i != 0 && c == '-') // Строка содержит '-'
                    || (!Character.isDigit(c) && c != '-') // или не цифра и не начинается с '-'
                    || (chars.length == 1 && c == '-')) // или одиночный '-'
            {
                return false;
            }
        }
        return true;
    }
}