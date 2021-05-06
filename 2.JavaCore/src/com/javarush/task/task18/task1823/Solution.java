package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.*;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = null;

        while (true) {
            fileName = reader.readLine();
            if (fileName.equals("exit")) { // останавливаем программу при вводе exit
                System.out.println("exit");
                break;
            }
            ReadThread thread = new ReadThread(fileName);
            thread.start();
        }
        reader.close();

    }

    public static class ReadThread extends Thread {
        private String fileName;

        public ReadThread(String fileName) {
            this.fileName = fileName;
            //implement constructor body
        }

        @Override
        public void run() {
            ArrayList<Integer> listInput = new ArrayList<>();
            ArrayList<Integer> listTemp;
            ArrayList<Integer> listResult = new ArrayList<>();
            int max = 0;
            int count;

            try {
                FileInputStream fileInputStream = new FileInputStream(fileName);
                while (fileInputStream.available() > 0) {
                    listInput.add(fileInputStream.read()); // добавляем байты из фала в список
                }
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            listTemp = listInput;
            for (int i = 0; i < listInput.size(); i++) {
                count = 0;
                for (int j = 0; j < listTemp.size(); j++) {
                    if (listInput.get(i).equals(listTemp.get(j))) {
                        count++; // счетчик числа повторов байтов
                    }
                }
                if (count == max) { // количество разных байтов может совпадать
                    listResult.add(listInput.get(i));
                }
                if (count > max) {// если повторов оказалось в этом прогоне больше,то задаем новый макс
                    max = count;
                    listResult.clear(); // очищаем список для
                    listResult.add(listInput.get(i)); // закидываем уже новый макс байты
                }
            }
            Collections.sort(listResult); // сортируем байты, остались здесь только байты с макс чилом повторов
            //System.out.print(listResult.get(0));
            resultMap.put(fileName, listResult.get(0)); // закидываем первый макс байт
            for (int i = 0; i < listResult.size() - 1; i++) {
                if (!listResult.get(i).equals(listResult.get(i + 1))) { // ищем следующий максимальный байт
                    //System.out.print(" " + listResult.get(i + 1));
                    resultMap.put(fileName, listResult.get(i + 1));// закидываем и егов список
                }
            }
            //System.out.println(resultMap);

// implement file reading here - реализуйте чтение из файла тут
        }
    }
}

