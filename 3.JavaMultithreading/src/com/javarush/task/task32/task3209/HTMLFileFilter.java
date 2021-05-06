package com.javarush.task.task32.task3209;

import javax.swing.filechooser.FileFilter;
import java.io.File;
import java.util.Locale;

public class HTMLFileFilter extends FileFilter {

    //Переопредели метод accept(File file), чтобы он возвращал true,
    //если переданный файл директория или содержит в конце имени ".html" или ".htm" без учета регистра.
    @Override
    public boolean accept(File f) {
        return f.getName().toLowerCase(Locale.ROOT).endsWith(".html") || f.getName().toLowerCase().endsWith(".htm") || f.isDirectory();
    }

    @Override
    public String getDescription() {
        return "HTML и HTM файлы";
    }
}
