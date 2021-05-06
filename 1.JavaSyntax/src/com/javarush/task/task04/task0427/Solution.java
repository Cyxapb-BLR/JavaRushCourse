package com.javarush.task.task04.task0427;

/* 
Описываем числа
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        int a=Integer.parseInt(reader.readLine());
        if (a>=1 && a<= 999 ) {
            String  x,y;
            if (a/100>0){
                x="трехзначное число";
            }else { if (a/10>0){
                x="двузначное число";}
                else x="однозначное число";
            }
            if (a%2==0){
                y="четное"; }
            else y="нечетное";
            System.out.println(y + " " + x );
        }  //напишите тут ваш код

    }
}
