package com.javarush.task.task19.task1927;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

/* 
Контекстная реклама
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {

        PrintStream defaultStream = System.out;     // сохраняем дефолтные настрйоки для печати в консоль в переменную
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();      //создаем массив
        PrintStream printStream = new PrintStream(byteArrayOutputStream);   // новый потом для записи в массив,а не в консоль
        System.setOut(printStream);     // перенастраиваем Printstream, теперь будет печатьсья в массив,а не выводиться в консоль
        testString.printSomething();    // запускаем метод в котором несколь строк с Println, которые заносятся в массив,а не в вывод консоли

        String result = byteArrayOutputStream.toString();      //сохраняем элементы массива в строку, элементы включают перенос строк
        String[] line = result.split(System.lineSeparator());   //разделяем элементы по разделителю строки(перенос строки)
        //  String[] line = result.split("\n"); //можно было сплитануть этим способом
        System.setOut(defaultStream);// возвращаем дефолтные настройки для System.out

        int count = 0;
        for (int i = 0; i < line.length; i++) {

            if (count == 2) {   // если счетчик = 2, то через каждые две строки будет добавляться следующая фраза
                System.out.println("JavaRush - курсы Java онлайн");
                count = 0;  //сбрасываем счетчик,если фраза уже написана
            }
            System.out.println(line[i]);
            count++;
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
