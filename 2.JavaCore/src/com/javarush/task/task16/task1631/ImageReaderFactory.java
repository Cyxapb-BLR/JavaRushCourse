package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

public class ImageReaderFactory {

    public static ImageReader getImageReader(ImageTypes imageTypes) {


        if (ImageTypes.BMP.equals(imageTypes)) {
            return new BmpReader();
        }
        if (ImageTypes.JPG.equals(imageTypes)) {
            return new JpgReader();
        }
        if (ImageTypes.PNG.equals(imageTypes)) {
            return new PngReader();
        } else
            throw new IllegalArgumentException("Неизвестный тип картинки");


    }
}

