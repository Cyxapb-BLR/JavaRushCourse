package com.javarush.task.task05.task0520;

/* 
Создать класс прямоугольник (Rectangle)
*/


public class Rectangle {
    private int top, left, width, height;

    public Rectangle(int top, int left, int width, int height){
        this.top=top;
        this.left=left;
        this.width=width;
        this.height=height;
    }
    public Rectangle( int top, int left){
        this.top=top;
        this.left=left;
        width=0;
        height=0;
    }
    public Rectangle(int top, int left, int width){
        this.top=top;
        this.left=left;
        this.width=width;
        height=width;
    }
    public Rectangle( Rectangle rectangle){
        this.top=rectangle.top;
        this.left=rectangle.left;
        this.width=rectangle.width;
        this.height=rectangle.height;
    }

    //напишите тут ваш код

    public static void main(String[] args) {

    }
}
