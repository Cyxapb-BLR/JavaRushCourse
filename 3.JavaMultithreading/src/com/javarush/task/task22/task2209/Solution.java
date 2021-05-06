package com.javarush.task.task22.task2209;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/* 
Составить цепочку слов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //...
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
        //BufferedReader fileReader = new BufferedReader(new FileReader("e:\\result.txt"));
        reader.close();
        StringBuilder stringBuilder = new StringBuilder();
        while (fileReader.ready()) {
            stringBuilder.append(fileReader.readLine()).append(" ");
        }
        String[] wordsFromFile = stringBuilder.toString().split(" ");
        StringBuilder result = getLine(wordsFromFile);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        //System.out.println(Arrays.toString(words));

        for (int i = 0; i < words.length; i++) {
            String[] wordsCopy = words.clone();         //клонируем объект,чтобы при неподходящем результате восстановить исходный клон для следубщего круга в цикле
            StringBuilder newLine = new StringBuilder();    //создаем новую строку
            newLine.append(wordsCopy[i]);                   //добавляем текущее слово на первую позицию в строку
            wordsCopy[i] = null;                            //убираем это слово из массива,чтобы больше не мешало
            int count = 1;                                  //счетчик количества слов в строке
            //System.out.println(Arrays.toString(wordsCopy));
            for (int j = 0; j < wordsCopy.length; j++) {    //пытаемся собрать строку по условию
                if (wordsCopy[j] != null) {
                    char lastChar = (char) newLine.codePointAt(newLine.length() - 1);   //последний символ создаваемой строки
                    // сравниваем последний символ строки с первым символом другого слова без учета регистра:
                    if ((lastChar == wordsCopy[j].toUpperCase().codePointAt(0) || lastChar == wordsCopy[j].toLowerCase().codePointAt(0))) {
                        newLine.append(" ").append(wordsCopy[j]);   //добавляем пробел и подходящее слово в строку
                        wordsCopy[j] = null;    //убираем слово из массива,чтобы его больше не проверять
                        j = -1;                 //обнуляем цикл,т.к следующее подходящее слово возможно мы прошли ранее
                        count++;
                    }
                }
            }
            if (count == words.length) {    //если счетчик добавленных слов = количеству слов в файле,то выводим результат
                //System.out.println("RESULT " + newLine.toString());
                return newLine;
            }
        }
        return new StringBuilder();
    }
}
