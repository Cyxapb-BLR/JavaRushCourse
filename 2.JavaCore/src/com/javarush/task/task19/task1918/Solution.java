package com.javarush.task.task19.task1918;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/* 
Знакомство с тегами
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //!!!!!!!!!! задачу можно решить в пару строк используя Jsoup!!!!!!!!! но пока это не изучали
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String tagFileName = reader.readLine();
        //String tagFileName = "e:\\result.txt";
        reader.close();
        String tag = args[0];
        String beginTag = "<" + tag;
        String endTag = "</" + tag + ">";
        String line = "";
        reader = new BufferedReader(new FileReader(tagFileName));
        ArrayList<String> list = new ArrayList<>();
        ArrayList<Integer> listBeginTag = new ArrayList<>();
        ArrayList<Integer> listEndTag = new ArrayList<>();

        while (reader.ready()) {
            line = line + reader.readLine();
            //System.out.println(line);
            for (int i = 0; i < line.length(); i++) {
                if (line.startsWith(beginTag, i)) { //= line.substring(i, i + beginTag.length()).equals(beginTag)
                    listBeginTag.add(i);//если есть открывающийся тэг,то индекс,с которого начинается тэг в строке, помещаем в список
                    i = i + beginTag.length() - 1; // добавляем к индексу длину тэга и отнимаем единицу,
                    // чтобы не перебирать символы в строке, которые уже входят в данный тэг
                }
                if (line.startsWith(endTag, i)) {
                    listEndTag.add(i);//если есть закрывающийся тэг,то индекс,с которого начинается тэг в строке, помещаем в список
                    i = i + endTag.length() - 1;// добавляем к индексу длину тэга и отнимаем единицу,
                    // чтобы не перебирать символы в строке, которые уже входят в данный тэг
                }
                if (listBeginTag.size() == listEndTag.size() && listBeginTag.size() > 1) {// если длина списков для тэгов равна и больше 1цы
                    for (int j = 0; j < listBeginTag.size(); j++) {// первому открывающемуся тэгу соотвествует последний закрывающийся
                        // (сопоставляем с концов и двигаемся в серединуу)
                        int firstIndex = listBeginTag.get(j);
                        int secondIndex = listEndTag.get(listBeginTag.size() - j - 1);
                        list.add(line.substring(firstIndex, secondIndex + endTag.length()));//добавляем нужный тэг в список,вырезая из строки
                    }
                    line = line.substring(listEndTag.get(listEndTag.size() - 1) + endTag.length());// обрезаем строку после последнего закр тэга в списке(тэг включительно отрезаем)
                    i = -1; // обнуляем i , чтобы можно было работать с обрезанной строкой дальше

                    //очищаем листы для работы дальше
                    listBeginTag.clear();
                    listEndTag.clear();
                }
                if (listBeginTag.size() == 1 && listEndTag.size() == 1) {// если нашли в строке 1 откр и 1 закрыв тэг,то добавляем эту пару в список
                    list.add(line.substring(listBeginTag.get(0), listEndTag.get(0) + endTag.length()));//добавляем нужный тэг в список,вырезая из строки
                    line = line.substring(listEndTag.get(0) + endTag.length());// обрезаем строку по закр тэгу(тэг включительно отрезаем)
                    i = -1; // обнуляем, для работы с обрезанной строкой

                    //очищаем листы для работы дальше
                    listBeginTag.clear();
                    listEndTag.clear();
                }
            }
            listBeginTag.clear();
            listEndTag.clear();
        }
        reader.close();
        for (String s : list) { //выводим все тэги
            System.out.println(s);

        }
    }
}
