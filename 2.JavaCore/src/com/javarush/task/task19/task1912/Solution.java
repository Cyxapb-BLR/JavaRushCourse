package com.javarush.task.task19.task1912;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Ридер обертка 2
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws InterruptedException {
        PrintStream consolStrream = System.out;// запоминаем настоящий PrintStream в переменную
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();// создаем динамический массив
        PrintStream stream = new PrintStream(outputStream);/* создаем адаптер к классу PrintStream,
                                                            Переназначаем наш дефолтный PrintStream System.out на новый.*/
        System.setOut(stream);//устанавливаем как текущий System.out
        testString.printSomething(); /*Вызываем метод printSomething() статического обьекта testString,
                                     который по умолчанию должен был вывести информацию на консоль,
                                     но т.к. мы подменили поток вывода,теперь этот метод записывает информацию
                                     в созданный нами ранее массив outputStream.*/
        String result = outputStream.toString().replace("te", "??");//меняем te на ??
        System.setOut(consolStrream);// возврвщаем стандартный System.out
        System.out.println(result);

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
