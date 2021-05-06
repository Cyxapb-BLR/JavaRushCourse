package com.javarush.task.task31.task3106;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Разархивируем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String resultFileName = args[0];
        List<String> fileNameParts = new ArrayList<>(Arrays.asList(args).subList(1, args.length));
        Collections.sort(fileNameParts);
        List<FileInputStream> inputStreamList = new ArrayList<>();
        for (String name : fileNameParts) {
            inputStreamList.add(new FileInputStream(name));
        }

        OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(resultFileName));
        ZipInputStream zipInputStream = new ZipInputStream(new SequenceInputStream(Collections.enumeration(inputStreamList)));

        while (true) {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            if (nextEntry == null) {
                break;
            }
            int bufferSize = 1024;
            byte[] buffer = new byte[bufferSize];
            int readBytes;
            while ((readBytes = zipInputStream.read(buffer, 0, bufferSize)) > -1) {
                outputStream.write(buffer, 0, readBytes);
            }
        }
        outputStream.flush();
        zipInputStream.close();
        outputStream.close();
    }
}
