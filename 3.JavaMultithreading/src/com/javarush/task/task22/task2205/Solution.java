package com.javarush.task.task22.task2205;

/* 
МНЕ нравится курс JavaRush
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(String.format(getFormattedString(), "JavaRush", "курс", "мне", "нравится"));
        //должен быть вывод
        //"МНЕ нравится курс JavaRush"
    }

    public static String getFormattedString() {
        /*
        *   %s - означает что будет стринг формат
        *   %3$s - означает что используем третий элемент, который имеет тип стринг
        *   %3$S - " -//- " + слово будет писаться всеми большими буквами
        * */
        return "%3$S %4$s %2$s %1$s";
    }
}
