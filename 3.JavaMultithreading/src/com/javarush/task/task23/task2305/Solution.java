package com.javarush.task.task23.task2305;

/* 
Inner
*/

public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
        Solution[] result = new Solution[2];

        Solution solutions = new Solution();
        solutions.innerClasses[0] = solutions.new InnerClass();
        solutions.innerClasses[1] = solutions.new InnerClass();

        Solution solutions1 = new Solution();
        solutions1.innerClasses[0] = solutions1.new InnerClass();
        solutions1.innerClasses[1] = solutions1.new InnerClass();

        result[0] = solutions;
        result[1] = solutions1;
        return result;
    }

    public static void main(String[] args) {
        getTwoSolutions();
    }
}
