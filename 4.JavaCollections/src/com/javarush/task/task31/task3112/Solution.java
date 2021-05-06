package com.javarush.task.task31.task3112;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/* 
Загрузчик файлов
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        Path passwords = downloadFile("https://javarush.ru/testdata/secretPasswords.txt", Paths.get("E:\\! Учеба Java\\test files"));

        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
        URL url = new URL(urlString);                                          //создаем url
        InputStream inputStream = url.openStream();                              //поток считывания из url
        Path tempFile = Files.createTempFile("temp-", ".tmp");      //временный файл
        Path resultFile = Paths.get(url.getFile()).getFileName();              //создаем имя файла из url
        Files.copy(inputStream, tempFile, StandardCopyOption.REPLACE_EXISTING);//пишем из потока во врем файл
        return Files.move(tempFile, downloadDirectory.resolve(resultFile));     //перемещаем временный файл директорию с нужным именем файла
    }
}
