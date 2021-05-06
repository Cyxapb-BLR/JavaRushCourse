package com.javarush.task.task18.task1820;

import java.io.*;


/* 
Округление чисел
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1=reader.readLine();
        String fileName2=reader.readLine();
        //String fileName1 = "e:\\result.txt";
        //String fileName2 = "e:\\result1.txt";

        FileOutputStream fileOutputStream = new FileOutputStream(fileName2);
        FileReader fileReader = new FileReader(fileName1);
        FileWriter fileWriter = new FileWriter(fileName2);
        reader = new BufferedReader(fileReader);// создаем ридер для чтения строк в файле
        String lane;//строка файла
        String space = " ";// делить яисла будем по пробелу

        while ((lane = reader.readLine()) != null) {
            String[] element;// массив для чисел без пробелов
            String newLane; // новая строка с округленными числами
            element = lane.split(space); // делим числа по пробелам и добавляем каждое число в массив
            for (int i = 0; i < element.length; i++) {
                //числоприводим к double и округляем через Math.round
                int intNumber = (int) Math.round(Double.parseDouble(element[i]));
                newLane = intNumber + " "; //добавляем к округленному числу пробел,чтобы числа писались через пробел
                fileOutputStream.write(newLane.getBytes()); //приводим к байтам и записываем в файл по байтам
            }

        }
        fileReader.close();
        reader.close();
        fileWriter.close();

    }
}
