package com.javarush.task.task31.task3105;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        String zipFilePath = args[1];
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        Map<String, ByteArrayOutputStream> map = new HashMap<>();
        ZipEntry newZipEntry = new ZipEntry("new/" + file.getName());       //zipEntry для нового файла
        try (ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(zipFilePath))) { //поток для чтения из архива
            ZipEntry zipEntry = zipInputStream.getNextEntry();
            String entryName;
            byte[] buffer = new byte[1024];
            while (zipEntry != null) {      //читаем каждый файл в архиве и помещаем в мапу имя zipEntry и его byteArrayOutputStream
                if (!zipEntry.getName().equals(newZipEntry.getName())) {
                    entryName = zipEntry.getName();
                    System.out.println(entryName);
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    int length = 0;
                    while ((length = zipInputStream.read(buffer)) > 0) {
                        byteArrayOutputStream.write(buffer, 0, length);
                    }
                    map.put(entryName, byteArrayOutputStream);
                }
                zipEntry = zipInputStream.getNextEntry();
            }
        }
        try (
                ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(zipFilePath));) {    // поток для записи в архив
            ZipEntry zipEntry;
            if (!map.containsKey(file.getName())) {     //если map не содержит записываемый файл,то копируем файл с использованием newZipEntry, в котором добавляется папка new
                zipOutputStream.putNextEntry(newZipEntry);
                Files.copy(file.toPath(), zipOutputStream);
               // System.out.println("Не содержит файл, поэтому добавляем с новой папкой");
            }
            for (Map.Entry<String, ByteArrayOutputStream> pair : map.entrySet()) {
                zipEntry = new ZipEntry(pair.getKey());
                ByteArrayOutputStream value = pair.getValue();
                if (pair.getKey().equals(file.getName())) {     //если ключ в map равен имени файла,который нужно заменить,то
                    zipOutputStream.putNextEntry(newZipEntry);
                   // System.out.println("Содержит файл, поэтому обновляем файл");
                    Files.copy(file.toPath(), zipOutputStream);     //копируем заменяемый файл
                } else {
                    zipOutputStream.putNextEntry(zipEntry);
                    zipOutputStream.write(value.toByteArray());     // иначе записываем значение из map
                }
            }
            zipOutputStream.closeEntry();
            zipOutputStream.flush();
        }
    }
}
