package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileNamePart;
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        int index = 0; // ищем в строчке с какого индекса начинается  ".part"
        int partNumber;

        while (true) {
            fileNamePart = reader.readLine();
            if (fileNamePart.equals("end")) {
                break;
            }
            index = fileNamePart.indexOf(".part");// индекс с которого начинается ".part"
            //System.out.println("index " + index);
            partNumber = Integer.parseInt(fileNamePart.substring(index + 5));//номер части после ".part"
            //System.out.println(("partNumber " + partNumber));
            treeMap.put(partNumber, fileNamePart);

        }
        //System.out.println(treeMap);

        String fileName = treeMap.firstEntry().getValue().substring(0, index);// отрезаем от названия первого файла начало до ".part"
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(fileName));//буффер для записи

        for (int i = treeMap.firstKey(); i <= treeMap.lastKey(); i++) {// //проходимся по всем ключам
            System.out.println(treeMap.get(i)); //знаниче по ключу = название части файла
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(treeMap.get(i))); //буффер для чтения

            while (bufferedInputStream.available() > 0) {
                bufferedOutputStream.write(bufferedInputStream.read());
            }
            bufferedInputStream.close();
        }
        bufferedOutputStream.close();
        reader.close();
    }
}
