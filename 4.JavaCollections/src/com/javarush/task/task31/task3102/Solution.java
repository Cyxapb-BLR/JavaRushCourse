package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

/* 
Находим все файлы
*/

public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        Queue<File> fileQueue = new LinkedList<>();
        List<String> list = new ArrayList<>();
        File file = new File(root);

        if (file.isDirectory()) {
            fileQueue.add(file);
            while (!fileQueue.isEmpty()) {
                File poll = fileQueue.poll();
                for (File fileFromPoll : poll.listFiles()) {
                    if (fileFromPoll.isDirectory()) {
                        fileQueue.add(fileFromPoll);
                    } else list.add(fileFromPoll.getAbsolutePath());
                }
            }
            return list;
        }
        return null;
    }

    public static void main(String[] args) throws IOException {
        String path = "E:\\! Учеба Java";
        List<String> fileTree = getFileTree(path);
        for (String fileName : fileTree) {
            System.out.println(fileName);
        }
    }
}
