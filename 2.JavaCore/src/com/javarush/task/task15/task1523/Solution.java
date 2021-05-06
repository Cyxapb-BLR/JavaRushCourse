package com.javarush.task.task15.task1523;

/*
Перегрузка конструкторов
*/

public class Solution {
    String s;
    int n;
    double d;
    boolean b;

    public Solution(String s, int n, double d, boolean b) {
        this.s = s;
        this.n = n;
        this.d = d;
        this.b = b;
    }

    protected Solution(String s) {
        this.s = s;
    }

    private Solution(String s, int n) {
        this.s = s;
        this.n = n;
    }

    Solution(String s, int n, double d) {
        this.s = s;
        this.n = n;
        this.d = d;
    }

    public static void main(String[] args) {


    }
}