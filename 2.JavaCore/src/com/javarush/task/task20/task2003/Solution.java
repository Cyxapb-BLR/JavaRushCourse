package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/

public class Solution {

    public static Map<String, String> runtimeStorage = new HashMap<>();


    public static void save(OutputStream outputStream) throws Exception {
        PrintWriter writer = new PrintWriter(outputStream);
        Properties properties = new Properties();
        for (Map.Entry<String, String> pair : runtimeStorage.entrySet()) {  //для каждого ключа находим значение
            properties.put(pair.getKey(), pair.getValue());     //записывааем их в properties
        }
        properties.store(outputStream, ""); //записыввем properties в файл
        //System.out.println(properties);
        //напишите тут ваш код
    }

    public static void load(InputStream inputStream) throws IOException {
        Properties properties = new Properties();    // создаем properties
        properties.load(inputStream);   // загружаем properties из файла
        for (String key : properties.stringPropertyNames()) {   //для каждого ключа из properties находим значение
            runtimeStorage.put(key, properties.getProperty(key));   // помещаем каждый ключ и значение для него в HashMap runtimeStorage
        }
        //напишите тут ваш код
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream fos = new FileInputStream(reader.readLine())) {
            load(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(runtimeStorage);
    }
}
