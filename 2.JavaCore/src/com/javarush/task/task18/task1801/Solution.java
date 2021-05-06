package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream=new FileInputStream(reader.readLine());
        reader.close();
        int max=fileInputStream.read();
        int data;
        while (fileInputStream.available()>0){
            if ((data=fileInputStream.read())>max){
                max=data;
            }
        }
        fileInputStream.close();
        System.out.println(max);
    }
}
