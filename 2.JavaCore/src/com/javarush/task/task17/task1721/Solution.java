package com.javarush.task.task17.task1721;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        FileReader fileReader1 = new FileReader(file1);
        FileReader fileReader2 = new FileReader(file2);
        BufferedReader reader1 = new BufferedReader(fileReader1);
        String line1;
        while ((line1 = reader1.readLine()) != null) {
            allLines.add(line1);
        }
        reader1.close();
        BufferedReader reader2 = new BufferedReader(fileReader2);
        while ((line1 = reader2.readLine()) != null) {
            forRemoveLines.add(line1);
        }
        reader2.close();
        reader.close();
        new Solution().joinData();


    }

    public void joinData() throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);
        } else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
