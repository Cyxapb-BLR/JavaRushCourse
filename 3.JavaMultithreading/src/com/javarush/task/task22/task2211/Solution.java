package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* 
Смена кодировки
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String filename1 = args[0];        //параметр - имя файла,в котором информация хранится в кодировке Windows-1251
        String filename2 = args[1];
        try (       //потоки чтения и записи
                    FileInputStream fileInputStream = new FileInputStream(filename1);
                    FileOutputStream fileOutputStream = new FileOutputStream(filename2)) {
            Charset windows1251 = Charset.forName("Windows-1251");          //кодировка Windows-1251
            byte[] buffer = new byte[1000];                                 //создаем буфер
            fileInputStream.read(buffer);                                   //считываем в буфер
            String s = new String(buffer, windows1251);                     //создаем новую строку из набора байтов из файла с кодировкой Windows-1251
            buffer = s.getBytes(StandardCharsets.UTF_8);                    //передаем байты в буфер, которые преобразованы в кодировку UTF8
            fileOutputStream.write(buffer);                                 //пишем буфер в файл
        }
    }
}
