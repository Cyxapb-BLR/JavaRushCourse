package com.javarush.task.task05.task0529;

/* 
Консоль-копилка
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        int sum=0;
        while (true){
            String lane=reader.readLine();
            if (lane.equals("сумма"))
                break;
            else {
                int number=Integer.parseInt(lane);
                sum=sum+number;}

        }
        System.out.println(sum);
                //напишите тут ваш код
    }
}
