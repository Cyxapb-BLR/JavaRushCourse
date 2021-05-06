package com.javarush.task.task04.task0416;

/* 
Переходим дорогу вслепую
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
       BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
       String lane=reader.readLine();
       double t=Double.parseDouble(lane);
       while (t>=5)
           t=t-5;
       if (0<=t && t<3)
        System.out.println("зелёный");
       else {if (3<=t && t<4)
           System.out.println("жёлтый");
       else if (t<5)
           System.out.println("красный");}//напишите тут ваш код

    }
}