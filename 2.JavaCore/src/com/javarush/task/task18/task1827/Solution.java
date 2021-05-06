package com.javarush.task.task18.task1827;

import java.io.*;

/* 
Прайсы
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileReader fileReader = new FileReader(fileName); //чтение файла
        FileWriter fileWriter = new FileWriter(fileName, true);
        int max = 0;
        int id;
        reader = new BufferedReader(fileReader);//чтение из файла построчно
        String lane;
        if (args.length != 0 && args[0].equals("-c")) {
            String productName = args[1];
            String price = args[2];
            String quantity = args[3];
            while ((lane = reader.readLine()) != null) { //чтение построчно
                id = Integer.parseInt(lane.substring(0, 8).trim());
                if (max < id) {
                    max = id;
                }
                //System.out.println("id=" + id);
            }
            for (int i = productName.length(); i < 30; i++) {// заполняем пробелами в конце до 30 символов
                productName = productName + " ";
            }
            for (int i = price.length(); i < 8; i++) {// заполняем пробелами в конце до 8 символов
                price = price + " ";
            }
            for (int i = quantity.length(); i < 4; i++) {// заполняем пробелами в конце до 8 символов
                quantity = quantity + " ";
            }
            id = max + 1; // новый id для новой строки
            fileWriter.write("\n" + id + productName + price + quantity); // "\n"-перенос на новую строку
            //fileWriter.flush();// без этого не писалось в файл, когда проверял
        }
        fileReader.close();
        reader.close();
        fileWriter.close();
    }
}
