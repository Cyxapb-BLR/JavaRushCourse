package com.javarush.task.task18.task1822;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/* 
Поиск данных внутри файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName= reader.readLine();
        //String fileName = "e:\\result.txt";
        String productName = "";
        double price;
        int quantity;
        char[] charLine;
        ArrayList<String> list = new ArrayList<>();
        String element;

        int id = Integer.parseInt(args[0]);
        int idInLine; // в файле
        String line;
        FileReader fileReader = new FileReader(fileName);
        reader = new BufferedReader(fileReader);
        while ((line = reader.readLine()) != null) {
            idInLine = Integer.parseInt(line.substring(0, line.indexOf(" ")));// находим id, все символы до первого пробела
            if (id == idInLine) {
                charLine = line.toCharArray();// преобразуем строку в массив символов
                element = ""; // часть строки отделенная пробелом или пробелами( id, название,цена или количество)
                for (int i = 0; i < charLine.length; i++) {

                    element = element + charLine[i];
                    if (charLine[i] == ' ') {
                        list.add(element.trim()); // добавляем нужный элемент и убираем в нем пробелы
                        //System.out.println(element);
                        element = "";// обнуляем
                    }

                }
                list.add(element);// добавляем элемент после последнего пробела в строке
                idInLine = Integer.parseInt(list.get(0));
                quantity = Integer.parseInt(list.get(list.size() - 1));
                price = Double.parseDouble(list.get(list.size() - 2));
                productName = list.get(1);
                if (list.size() > 4) { // если мя продукта состоит из нескольких слов,то добавляем остальные
                    for (int i = 2; i < list.size() - 2; i++) {
                        productName = productName + " " + list.get(i);
                    }
                }
                System.out.println(idInLine + " " + productName + " " + price + " " + quantity);
                break;
            }

        }
        reader.close();
        fileReader.close();
    }
}
