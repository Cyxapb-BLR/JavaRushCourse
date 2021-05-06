package com.javarush.task.task19.task1911;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Ридер обертка
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;// сохраняем стандартный PrintStream в переменную
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(); //создаем массив,куда будем записыаввать
        PrintStream stream = new PrintStream(byteArrayOutputStream);/*создаем новый Printstrem, который теперь
                                                                    будет писать в массив,а не в консоль*/
        System.setOut(stream);// переназначаем функцию System.out, теперь будет писать в массив,а  не в консоль
        testString.printSomething();/*запускаем метод для нашего объекта, теперь оно записывается в массив,
                                    а не в консоль*/
        String result = byteArrayOutputStream.toString().toUpperCase();// соединяем в строку и приводим к заглавным буквам
        System.setOut(consoleStream);// возвращаем стандартную функцию System.out , теперь снова будет писать в консоль
        System.out.println(result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
