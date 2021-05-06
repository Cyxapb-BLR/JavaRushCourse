package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/

public class Solution implements Serializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println(new Solution(4));
        String fileName = "e:\\result2.txt";
        FileOutputStream fileOutputStream = new FileOutputStream(fileName);                     //поток записи в файл
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);       //запись объекта в поток
        Solution savedObject = new Solution(20);                                     //создание объекта
        //System.out.println("savedObject " + savedObject);
        objectOutputStream.writeObject(savedObject);                                            //сохранение объекта в файл
        FileInputStream fileInputStream = new FileInputStream(fileName);                        //поток чтения из файла
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Solution loadedObject = (Solution) objectInputStream.readObject();                      //загружаем объект из файла
        //System.out.println("loadedObject " + loadedObject);
        System.out.println(savedObject.string.equals(loadedObject.string));
    }

    transient private final String pattern = "dd MMMM yyyy, EEEE";
    transient private Date currentDate;
    transient private int temperature;
    String string;


    public Solution(int temperature) throws FileNotFoundException {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
