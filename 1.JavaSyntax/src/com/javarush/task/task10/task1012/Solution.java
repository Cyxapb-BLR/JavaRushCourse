package com.javarush.task.task10.task1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Количество букв
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Алфавит
        List<Character> alphabet = Arrays.asList(
                'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж',
                'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о',
                'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц',
                'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я');

        // Ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }


        ArrayList<Character> characterArrayList = new ArrayList<>(); //создаем список
        for (int i = 0; i < list.size(); i++) {
            char[] array = list.get(i).toCharArray();//преобразуем каждую строку в массив символов
            for (int j = 0; j < array.length; j++) {
                characterArrayList.add(array[j]); // добавляем все массивы в список
            }
        }

        for (int i = 0; i < alphabet.size(); i++) {// проходим по каждому элементу алфавита
            int count = 0;
            for (int j = 0; j < characterArrayList.size(); j++) {
                if (alphabet.get(i).equals(characterArrayList.get(j))) // сравниваем каждую букву с алфавитом
                {
                    count++;
                }

            }
            System.out.println(alphabet.get(i) + " " + count);
        }

        // напишите тут ваш код
    }
}