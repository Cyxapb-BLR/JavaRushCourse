package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Играем в Jолушку
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> listAll = new ArrayList<>();
        ArrayList<Integer> listDiv3 = new ArrayList<>();
        ArrayList<Integer> listDiv2 = new ArrayList<>();
        ArrayList<Integer> listNoDiv = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 20; i++) {
            listAll.add(Integer.parseInt(reader.readLine()));

            // надо было сдобавить "Integer x = listAll.get(i);" чтобы код выглядел меньше

            if (listAll.get(i) % 3 == 0 && listAll.get(i) % 2 == 0) {
                listDiv3.add(listAll.get(i));
                listDiv2.add(listAll.get(i));
            } else if (listAll.get(i) % 3 == 0) {
                listDiv3.add(listAll.get(i));
            } else if (listAll.get(i) % 2 == 0) {
                listDiv2.add(listAll.get(i));
            } else listNoDiv.add(listAll.get(i));
        }

        printList(listDiv3);
        printList(listDiv2);
        printList(listNoDiv);
        //напишите тут ваш код
    }

    public static void printList(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }
    //напишите тут ваш код
}

