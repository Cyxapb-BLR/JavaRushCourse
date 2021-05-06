package com.javarush.task.task04.task0422;

/* 
18+
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String lane1=reader.readLine(); // reader.readLine(); можно заменить просто этой строкой
                                                            // так переменная для ввода необязательна

        int age=Integer.parseInt(reader.readLine()); //заменяет следующие две строчки сразу одной
        //String lane2=reader.readLine();
        //  &
        // or int age=Integer.parseInt(lane2);

        if (age<18)
            System.out.println("Подрасти еще");//напишите тут ваш код

    }
}
