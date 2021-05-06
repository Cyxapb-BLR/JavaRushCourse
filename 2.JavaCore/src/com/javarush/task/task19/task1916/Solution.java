package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();
        BufferedReader reader1 = new BufferedReader(new FileReader(fileName1));
        BufferedReader reader2 = new BufferedReader(new FileReader(fileName2));
        ArrayList<String> list1 = new ArrayList<>(); //лист дляя строк первого файла
        ArrayList<String> list2 = new ArrayList<>();//лист дляя строк второго файла
        while (reader1.ready()) {
            String line1 = reader1.readLine();
            list1.add(line1);// добавляю строки из первого файла
        }
        reader1.close();
        while (reader2.ready()) {
            String line2 = reader2.readLine();
            list2.add(line2);// добавляю строки из второго файла
        }
        reader2.close();
        //System.out.println(list1);
        //System.out.println(list2);
        int count = 0;

        for (int i = 0; i < list1.size() + list2.size(); i++) { // "list1.size() + list2.size()" означает что один из листов существует
            count++;// счетчик чтобы знать какой элемент листа lines был заполнен,чтобы вывести его в консоль для отображения текущего результата
            if (list2.size() == 0) { //если 2й лист уже пуст, это значит что у него удалена текущая строка из первого списка
                lines.add(new LineItem(Type.REMOVED, list1.get(i)));
                list1.remove(i);
                i--;
            } else if (list1.size() == 0) {//если 1й лист уже пуст, это значит что  текущая строка была добавлена во второй лист
                lines.add(new LineItem(Type.ADDED, list2.get(i)));
                list2.remove(i);
                i--;
            } else if (list1.get(i).equals(list2.get(i))) { //
                lines.add(new LineItem(Type.SAME, list1.get(i)));// описал первую строку если они равны
                list1.remove(i);
                list2.remove(i);
                i--;
            } else if (list1.get(i).equals(list2.get(i + 1))) { //если строка 1го листа равна следующей строке 2го листа,то строка была добавлена во второй список
                lines.add(new LineItem(Type.ADDED, list2.get(i)));
                list2.remove(i);
                i--;
            } else {
                lines.add(new LineItem(Type.REMOVED, list1.get(i)));// иначе текущая строка была удалена из 2го листа
                list1.remove(i);
                i--;
            }
            //System.out.println(lines.get(count - 1).type + " " + lines.get(count - 1).line);// результат текущего цикла
        }
        /*for (int i = 0; i < lines.size(); i++) { //вывод всех элементов списка lines
            System.out.println(lines.get(i).type + " " + lines.get(i).line);
        }*/

    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
