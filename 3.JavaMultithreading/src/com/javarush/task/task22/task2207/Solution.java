package com.javarush.task.task22.task2207;

import java.io.*;
import java.util.*;

/* 
Обращенные слова
*/

public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());
        //FileInputStream fileInputStream = new FileInputStream("e:\\result.txt");
        reader = new BufferedReader(new InputStreamReader(fileInputStream));

        StringBuilder stringBuilder = new StringBuilder();

        while (reader.ready()) {
            stringBuilder.append(reader.readLine()).append(" ");    //добавляем пробел в конце строки,чтобы между посл и первым словом след строки был пробел
        }
        fileInputStream.close();
        reader.close();

        String[] words = stringBuilder.toString().split(" "); // делим весь текст на слова по пробелам

        for (int i = 0; i < words.length; i++) {
            StringBuilder reverseWord = new StringBuilder();
            reverseWord.append(words[i]);                           //добавляемм слово,которому будем делать реверс
            reverseWord.reverse();                                  //реверс слова
            for (int j = i + 1; j < words.length; j++) {
                if (reverseWord.toString().equals(words[j]) && words[j] != null) {      //если нашли совпадение для реверса
                    result.add(new Pair(words[i], words[j]));       //добавляем исходное слово и найденную реверсивную пару ему
                    words[j] = null;        //заменяем на null, чтобы оно больше не участвовало в создании пары,если есть еще одно reverseWord в массиве
                    break;
                }
            }
        }
        for (Pair pair : result) {
            System.out.println(pair);

        }
    }

    public static class Pair {
        String first;
        String second;

        public Pair() {
        }

        public Pair(String first, String second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null ? second :
                            second == null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
