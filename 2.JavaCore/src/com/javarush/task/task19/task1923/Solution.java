package com.javarush.task.task19.task1923;

import java.io.*;


/* 
Слова с цифрами
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName1 = args[0];
        String fileName2 = args[1];
        BufferedReader reader = new BufferedReader(new FileReader(fileName1));
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName2));
        char[] numbers = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        int start = 0, count = 0;
        while (reader.ready()) {
            String line = reader.readLine();// читаем по строкам
            String[] words = line.split(" "); //делим на слова по пробелам
            //System.out.println(Arrays.toString(words));
            for (int i = 0; i < words.length; i++) {
                char[] symbols = words[i].toCharArray();// каждое слово разбиваем на массив символов
                count = 0;
                for (int j = 0; j < symbols.length; j++) {
                    start = 0;
                    for (int k = start; k < numbers.length; k++) {
                        if (symbols[j] == numbers[k]) {// если символ в слове равен цифре, то значит в слове есть цифры
                            count++;
                            break; //можно отсановить цикл,т.к. уже нашли одну цифру,этого достаточно
                        }
                    }
                    if (count > 0) {
                        writer.write(words[i] + " ");// записали слово
                        break; // остановили цикл для проверки остальных символов, потому что уже записали слово, так как оно прошло по условию
                    }
                }

            }
        }
        reader.close();
        writer.close();
    }
}
