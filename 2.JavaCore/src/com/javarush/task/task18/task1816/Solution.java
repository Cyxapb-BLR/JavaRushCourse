package com.javarush.task.task18.task1816;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* 
Английские буквы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        FileReader fileReader=new FileReader(args[0]);
        int count=0;
        while (fileReader.ready()){
            int s=fileReader.read();
            //сравниваю байт с символом, int можно сравнивать с char при использовании fileReader
            if ((s>='a'&& s<='z')||(s>='A'&&s<='Z')){
                count++;
            }
        }
        fileReader.close();
        System.out.println(count);
    }
}
