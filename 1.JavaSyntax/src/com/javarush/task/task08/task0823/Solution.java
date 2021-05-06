package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();
        char[] list = string.toCharArray(); //переносим каждый отдельный символ в массив
        for (int i = 0; i < list.length; i++) {
            if (i == 0 || list[i - 1] == ' ') {
                /*  первую букву переделываем в заглавную.
                    если букве предшествет пробел, то меняем ее на заглавную.
                    пробел выделяется одиночными ' '.
                 */
                list[i] = Character.toUpperCase(list[i]); // замена буквы на заглавную
            }
        }
        System.out.println(list);

        //напишите тут ваш код
    }
}