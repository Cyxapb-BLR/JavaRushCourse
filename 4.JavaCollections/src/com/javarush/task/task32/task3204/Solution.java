package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/* 
Генератор паролей
*/

public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        List<Byte> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list.add((byte) rand('A', 'Z'));
            list.add((byte) rand('a', 'z'));
            list.add((byte) rand('0', '9'));
            //System.out.println(list.get(i));
        }
        list.remove(8);
        Collections.shuffle(list);
        for (Byte b : list) {
            byteArrayOutputStream.write(b);
        }
        return byteArrayOutputStream;
    }

    public static char rand(char min, char max) {
        return ((char) (Math.random() * (max - min + 1) + min));
    }
}
