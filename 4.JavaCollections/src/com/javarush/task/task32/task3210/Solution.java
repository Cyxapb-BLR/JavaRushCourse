package com.javarush.task.task32.task3210;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) {
        String fileName = args[0];
        long number = Long.parseLong(args[1]);
        String text = args[2];
        try (RandomAccessFile raf = new RandomAccessFile(fileName, "rw")) {
            raf.seek(number);
            byte[] readText = new byte[text.length()];
            //raf.read(readText);
            raf.read(readText, 0,  text.length());
            raf.seek(raf.length());
            //System.out.println(new String(readText));
            if (new String(readText).equals(text)) {
                raf.write("true".getBytes(StandardCharsets.UTF_8));
            } else {
                raf.write("false".getBytes(StandardCharsets.UTF_8));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
