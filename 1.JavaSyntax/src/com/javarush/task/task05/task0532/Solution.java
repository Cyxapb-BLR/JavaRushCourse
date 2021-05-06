package com.javarush.task.task05.task0532;

/* 
Задача по алгоритмам Ӏ Java Syntax: 5 уровень, 12 лекция
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(reader.readLine());
        int maximum = -2147483648;
        if (n>0){

        for ( int i=1; i<=n; i++) {
            int m = Integer.parseInt(reader.readLine());
            if (maximum < m) {
                maximum = m;
            }
        }
        //напишите тут ваш код

        System.out.println(maximum);
    }}
}
