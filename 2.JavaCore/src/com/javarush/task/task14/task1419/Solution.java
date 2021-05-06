package com.javarush.task.task14.task1419;

import javax.naming.LimitExceededException;
import javax.transaction.xa.XAException;
import java.awt.*;
import java.nio.file.FileAlreadyExistsException;
import java.security.DigestException;
import java.security.KeyException;
import java.util.ArrayList;
import java.util.List;

/*
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
            exceptions.add(new NumberFormatException());
            exceptions.add(new RuntimeException());
            exceptions.add(new LimitExceededException());
            exceptions.add(new KeyException());
            exceptions.add(new DigestException());
            exceptions.add(new SecurityException());
            exceptions.add(new XAException());
            exceptions.add(new UnsupportedOperationException());
            exceptions.add(new HeadlessException());
        }
        //напишите тут ваш код

    }

}