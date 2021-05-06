package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/

public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        detectAllWords(crossword, "home", "same");
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> list = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {    //для массива слов
            String word = words[i];                 //берем слово из массива
            char[] chars = word.toCharArray();      //преобразуем слово в массив символов
            //System.out.println("количество строк и стобцов в кроссворде: " + crossword.length + ", " + crossword[0].length);
            /*for (int j = 0; j < chars.length; j++) { //все буквы из массива
                System.out.println(chars[j]);
            }*/
            for (int j = 0; j < crossword.length; j++) {                            //проходим циклом по строкам кроссворда
                // System.out.println("!!!! " + Arrays.toString(crossword[j]));
                for (int k = 0; k < crossword[j].length; k++) {                     //проходим циклом по стобцам кроссворда
                    //System.out.println("символ кроссворда " + crossword[j][k]);
                    if (crossword[j][k] == chars[0]) {
                        int beginX = k;
                        int beginY = j;
                        //System.out.println("найден первый символ в кроссворде:" + chars[0]);
                        char beginChar = chars[0];                                   //первый символ слова
                        char endChar;
                        String newWord;

                        //теперь нужно пройти по всем направлениям от начальной буквы слова,чтобы найти все подряд буквы из слова в кроссворде

                        try {       // проверяем строку вправо, первым делом ищем последний символ слова:
                            newWord = "" + beginChar;
                            if (crossword[j][k + chars.length - 1] == chars[chars.length - 1]) {
                                int lastX = k + chars.length - 1;
                                int lastY = j;
                                endChar = chars[chars.length - 1];                   //последняя буква в слове

                                for (int l = 1; l < chars.length - 1; l++) {          //исключаем первую и последнюю букву, т.к. они найдены уже
                                    if (chars[l] == crossword[j][k + l]) {
                                        newWord = newWord + chars[l];               //добавляем буквы,если они совпадают в собираемое слово
                                    }
                                }
                                newWord = newWord + endChar;                        //добавляем последний символ
                                if (word.equals(newWord)) {
                                    //System.out.println("YES " + newWord);
                                    list.add(new Word(newWord));                    //добавляем найденное слово в список
                                    //для последнего элемента списка:
                                    list.get(list.size() - 1).setStartPoint(beginX, beginY);  //меняем координатыы начала слова на полученные
                                    list.get(list.size() - 1).setEndPoint(lastX, lastY);    //меняем координаты конца слова на полученные
                                    break;
                                }
                            }
                        } catch (Exception e) {
                            //e.printStackTrace();
                        }

                        try { // проверяем строку влево аналогично
                            newWord = "" + beginChar;
                            if (crossword[j][k - chars.length + 1] == chars[chars.length - 1]) {
                                int lastX = k - chars.length + 1;
                                int lastY = j;
                                endChar = chars[chars.length - 1];
                                //System.out.println("last char " + endChar);
                                for (int l = 1; l < chars.length - 1; l++) {
                                    if (chars[l] == crossword[j][k - l]) {
                                        newWord = newWord + chars[l];
                                    }
                                }
                                newWord = newWord + endChar;
                                if (word.equals(newWord)) {
                                    list.add(new Word(newWord));
                                    list.get(list.size() - 1).setStartPoint(beginX, beginY);
                                    list.get(list.size() - 1).setEndPoint(lastX, lastY);
                                    break;
                                }
                            }
                        } catch (Exception e) {
                            // e.printStackTrace();
                        }

                        try { // проверяем строку вниз аналогично
                            newWord = "" + beginChar;
                            if (crossword[j + chars.length - 1][k] == chars[chars.length - 1]) {
                                int lastX = k;
                                int lastY = j + chars.length - 1;
                                endChar = chars[chars.length - 1];
                                //System.out.println("last char " + endChar);
                                for (int l = 1; l < chars.length - 1; l++) {
                                    if (chars[l] == crossword[j + l][k]) {
                                        newWord = newWord + chars[l];
                                    }
                                }
                                newWord = newWord + endChar;
                                if (word.equals(newWord)) {
                                    list.add(new Word(newWord));
                                    list.get(list.size() - 1).setStartPoint(beginX, beginY);
                                    list.get(list.size() - 1).setEndPoint(lastX, lastY);
                                    break;
                                }
                            }
                        } catch (Exception e) {
                            //e.printStackTrace();
                        }
                        try { // проверяем строку вверх аналогично
                            newWord = "" + beginChar;
                            if (crossword[j - chars.length + 1][k] == chars[chars.length - 1]) {
                                int lastX = k;
                                int lastY = j - chars.length + 1;
                                endChar = chars[chars.length - 1];
                                //System.out.println("last char " + endChar);
                                for (int l = 1; l < chars.length - 1; l++) {
                                    if (chars[l] == crossword[j - l][k]) {
                                        newWord = newWord + chars[l];
                                    }
                                }
                                newWord = newWord + endChar;
                                if (word.equals(newWord)) {
                                    list.add(new Word(newWord));
                                    list.get(list.size() - 1).setStartPoint(beginX, beginY);
                                    list.get(list.size() - 1).setEndPoint(lastX, lastY);
                                    break;
                                }
                            }
                        } catch (Exception e) {
                            // e.printStackTrace();
                        }
                        try { // проверяем диагональ вниз и вправо аналогично
                            newWord = "" + beginChar;
                            if (crossword[j + chars.length - 1][k - chars.length + 1] == chars[chars.length - 1]) {
                                int lastX = k - chars.length + 1;
                                int lastY = j + chars.length - 1;
                                endChar = chars[chars.length - 1];
                                //System.out.println("last char " + endChar);
                                for (int l = 1; l < chars.length - 1; l++) {
                                    if (chars[l] == crossword[j + l][k - l]) {
                                        newWord = newWord + chars[l];
                                    }
                                }
                                newWord = newWord + endChar;
                                if (word.equals(newWord)) {
                                    list.add(new Word(newWord));
                                    list.get(list.size() - 1).setStartPoint(beginX, beginY);
                                    list.get(list.size() - 1).setEndPoint(lastX, lastY);
                                    break;
                                }
                            }
                        } catch (Exception e) {
                            // e.printStackTrace();
                        }
                        try { // проверяем диагональ вниз и влево аналогично
                            newWord = "" + beginChar;
                            if (crossword[j + chars.length - 1][k + chars.length - 1] == chars[chars.length - 1]) {
                                int lastX = k + chars.length - 1;
                                int lastY = j + chars.length - 1;
                                endChar = chars[chars.length - 1];
                                //System.out.println("last char " + endChar);
                                for (int l = 1; l < chars.length - 1; l++) {
                                    if (chars[l] == crossword[j + l][k + l]) {
                                        newWord = newWord + chars[l];
                                    }
                                }
                                newWord = newWord + endChar;
                                if (word.equals(newWord)) {
                                    list.add(new Word(newWord));
                                    list.get(list.size() - 1).setStartPoint(beginX, beginY);
                                    list.get(list.size() - 1).setEndPoint(lastX, lastY);
                                    break;
                                }
                            }
                        } catch (Exception e) {
                            // e.printStackTrace();
                        }
                        try { // проверяем диагональ вверх и вправо аналогично
                            newWord = "" + beginChar;
                            if (crossword[j - chars.length + 1][k + chars.length - 1] == chars[chars.length - 1]) {
                                int lastX = k + chars.length - 1;
                                int lastY = j - chars.length + 1;
                                endChar = chars[chars.length - 1];
                                System.out.println("last char " + endChar);
                                for (int l = 1; l < chars.length - 1; l++) {
                                    if (chars[l] == crossword[j - l][k + l]) {
                                        newWord = newWord + chars[l];
                                    }
                                }
                                newWord = newWord + endChar;
                                if (word.equals(newWord)) {
                                    list.add(new Word(newWord));
                                    list.get(list.size() - 1).setStartPoint(beginX, beginY);
                                    list.get(list.size() - 1).setEndPoint(lastX, lastY);
                                    break;
                                }
                            }
                        } catch (Exception e) {
                            // e.printStackTrace();
                        }
                        try { // проверяем диагональ вверх и влево аналогично
                            newWord = "" + beginChar;
                            if (crossword[j - chars.length + 1][k - chars.length + 1] == chars[chars.length - 1]) {
                                int lastX = k - chars.length + 1;
                                int lastY = j - chars.length + 1;
                                endChar = chars[chars.length - 1];
                                //System.out.println("last char " + endChar);
                                for (int l = 1; l < chars.length - 1; l++) {
                                    if (chars[l] == crossword[j - l][k - l]) {
                                        newWord = newWord + chars[l];
                                    }
                                }
                                newWord = newWord + endChar;
                                if (word.equals(newWord)) {
                                    list.add(new Word(newWord));
                                    list.get(list.size() - 1).setStartPoint(beginX, beginY);
                                    list.get(list.size() - 1).setEndPoint(lastX, lastY);
                                    break;
                                }
                            }
                        } catch (Exception e) {
                            // e.printStackTrace();
                        }
                    }
                }
            }
        }
        System.out.println("list " + list);
        return list;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
