package com.javarush.task.task25.task2504;

/* 
Switch для нитей
*/

import javax.swing.plaf.nimbus.State;

public class Solution {
    public static void processThreads(Thread... threads) {
        for (Thread thread : threads) {
            Thread.State state = thread.getState();
            switch (state) {
                case NEW:
                    thread.start();
                    break;
                case WAITING:
                case TIMED_WAITING:
                case BLOCKED:
                    thread.interrupt();
                    break;
                case RUNNABLE:
                    // System.out.println(thread.isInterrupted());
                    thread.isInterrupted();
                    break;
                case TERMINATED:
                    System.out.println(thread.getPriority());
                    break;
            }
        }
        //implement this method - реализуйте этот метод
    }

    public static void main(String[] args) {
    }
}
