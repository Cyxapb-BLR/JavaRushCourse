package com.javarush.task.task19.task1908;

import java.io.*;

/* 
Выделяем числа
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();
        reader = new BufferedReader(new FileReader(fileName1));
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName2));

        while (reader.ready()) {
            String line = reader.readLine(); //читаем первую строку файла
            String[] element = line.split(" "); // делим по пробелу слова/числа и добабвляем в элементы массива
            //System.out.println(Arrays.toString(element));
            for (int i = 0; i < element.length; i++) {
                try {
                    int n = Integer.parseInt(element[i]); //пытаемся парсить строку в числа
                    writer.write(n + " "); // пишем числа через пробел в цикле для каждого элемента,который смогли отпарсить в число
                } catch (NumberFormatException e) {

                }
            }
        }
        reader.close();
        writer.close();
    }
}
