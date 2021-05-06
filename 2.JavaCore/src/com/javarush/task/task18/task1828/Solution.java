package com.javarush.task.task18.task1828;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Прайсы 2
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        //String fileName = "e:\\test File for java task.txt";
        FileReader fileReader = new FileReader(fileName);
        ArrayList<String> list = new ArrayList<>();
        reader = new BufferedReader(fileReader);
        String line;
        if (args.length > 0) {
            switch (args[0]) {


                case "-u":
                    while ((line = reader.readLine()) != null) {
                        int id;
                        list.add(line);
                        id = Integer.parseInt(line.substring(0, 8).trim());
                        if (Integer.parseInt(args[1].trim()) == (id)) {
                            String productName = args[2];
                            String price = args[3];
                            String quantity = args[4];
                            String idString = id + "";
                            for (int i = idString.length(); i < 8; i++) {
                                idString = idString + " ";
                            }
                            for (int i = productName.length(); i < 30; i++) {
                                productName = productName + " ";
                            }
                            for (int i = price.length(); i < 8; i++) {
                                price = price + " ";
                            }
                            for (int i = quantity.length(); i < 4; i++) {
                                quantity = quantity + " ";
                            }
                            line = idString + productName + price + quantity;
                            list.set(list.size() - 1, line);
                        }
                    }
                    FileWriter fileWriter = new FileWriter(fileName);
                    for (int i = 0; i < list.size() - 1; i++) {
                        fileWriter.write(list.get(i) + "\n");
                    }
                    fileWriter.write(list.get(list.size() - 1));
                    fileWriter.close();
                    break;
                //***************
                case "-d":
                    while ((line = reader.readLine()) != null) {
                        int id;
                        list.add(line);
                        id = Integer.parseInt(line.substring(0, 8).trim());
                        if (Integer.parseInt(args[1]) == id) {
                            list.remove(list.size() - 1);
                        }
                    }
                    fileWriter = new FileWriter(fileName);
                    for (int i = 0; i < list.size() - 1; i++) {
                        fileWriter.write(list.get(i) + "\n");
                    }
                    fileWriter.write(list.get(list.size() - 1));
                    fileWriter.close();
                    break;
            }
        }
        reader.close();
        fileReader.close();
    }
}
