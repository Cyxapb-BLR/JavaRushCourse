package com.javarush.task.task31.task3101;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;
import java.util.stream.Stream;

/* 
Проход по дереву файлов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        File path = new File(args[0]);
        File resultFileAbsolutePath = new File(args[1]);
        File renameFile = new File(resultFileAbsolutePath.getParent() + "\\allFilesContent.txt");
        if (FileUtils.isExist(resultFileAbsolutePath)) {
            FileUtils.renameFile(resultFileAbsolutePath, renameFile);
        }
        Queue<File> queue = new LinkedList<>();
        List<File> list = new ArrayList<>();
        queue.offer(path);
        while (!queue.isEmpty()) {
            File files = queue.poll();
            for (File file : files.listFiles()) {
                if (file.isDirectory()) {
                    queue.add(file);
                } else if (file.length() <= 50) {
                    list.add(file);
                }

            }
        }
        Collections.sort(list, new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        try (FileWriter fileWriter = new FileWriter(renameFile, true)
        ) {
            for (File file : list) {
                FileReader fileReader = new FileReader(file);
                while (fileReader.ready()) {
                    fileWriter.write(fileReader.read());
                }
                fileReader.close();
                fileWriter.write("\n");
            }

        }
    }
}
