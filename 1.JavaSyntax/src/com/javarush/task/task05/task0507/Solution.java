package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
       BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
       double sum=0, y=0;
       while (true){
           int x=Integer.parseInt(reader.readLine());
           if (x==-1)
               break;
           else { sum=sum+x;
           y++;}//напишите тут ваш код
       }
        System.out.println(sum/y);
    }
}

