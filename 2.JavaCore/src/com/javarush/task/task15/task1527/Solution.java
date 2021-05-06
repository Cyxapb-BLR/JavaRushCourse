package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/*
Парсер реквестов
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        String[] s;
        String s1 = "";
        int index = url.indexOf('?');
        url = url.substring(index + 1);
        s = url.split("&");

        //System.out.println(index);
        //System.out.println(url);
        //System.out.println(Arrays.toString(s));
        //System.out.println(s[0]);
        //System.out.println(s[1]);
        String strvalue;
        double value;
        for (int i = 0; i < s.length; i++) {
            if (s[i].contains("=")) {
                index = s[i].indexOf('=');
                strvalue = s[i].substring(0, index);
                s1 = s1 + strvalue + " ";
            }else s1=s1+s[i]+" ";

        }
        System.out.println(s1.substring(0, s1.length() - 1));
        //System.out.println(s1);

        for (int i = 0; i < s.length; i++) {
            if (s[i].contains("obj")) {
                index = s[i].indexOf('=');
                try {
                    s[i] = s[i].substring(index + 1);
                    value = Double.parseDouble(s[i]);
                    alert(value);
                } catch (NumberFormatException e) {
                    alert(s[i]);
                }
            }
        }

        //add your code here
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}