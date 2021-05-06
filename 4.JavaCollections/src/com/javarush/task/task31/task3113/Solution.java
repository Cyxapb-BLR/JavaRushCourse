package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;


/* 
Что внутри папки?
*/

public class Solution {
    private static int size = 0;
    private static int dirCount = -1;       // -1 т.к. не надо считать исходную папку
    private static int fileCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Path path = Paths.get(reader.readLine());       //считываем путь к папке
        reader.close();
        //Path path = Paths.get("E:\\! Учеба Java\\test files");
        if (!Files.isDirectory(path)) {
            System.out.println(String.format("%s - не папка", path.toString()));
        } else {

            Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
                @Override       //переопределяем для поиска всех папок
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    dirCount++;
                    return super.preVisitDirectory(dir, attrs);
                }
            });
            Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
                @Override //переопределяем метод для поиска всех файлов в папке и подсчета размера файлов
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    fileCount++;
                    size = (int) (size + Files.size(file));
                    return super.visitFile(file, attrs);
                }
            });
            System.out.println("Всего папок - " + dirCount);
            System.out.println("Всего файлов - " + fileCount);
            System.out.println("Общий размер - " + size);


        }
    }
}
