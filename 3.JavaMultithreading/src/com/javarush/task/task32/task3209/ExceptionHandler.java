package com.javarush.task.task32.task3209;

public class ExceptionHandler {     //Это будет наш обработчик исключительных ситуаций, который ты в дальнейшем сможешь переопределить.
    public static void log(Exception e) {       //будет выводить в консоль краткое описание проблемы (используй метод toString у переданного исключения).
        System.out.println(e.toString());
    }
}
