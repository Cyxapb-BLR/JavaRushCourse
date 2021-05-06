package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Клубок
*/

public class Solution {

    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new ThreadOne());
        threads.add(new ThreadTwo());
        threads.add(new ThreadThree());
        threads.add(new ThreadFour());
        threads.add(new ThreadFive());
        //threads.get(0).start();
    }

    public static void main(String[] args) {
    }

    public static class ThreadOne extends Thread {
        @Override
        public void run() {
            while (true) {

            }
        }
    }

    public static class ThreadTwo extends Thread {
        @Override
        public void run() {
            try {
                throw new InterruptedException();

            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }
    }

    public static class ThreadThree extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println("Ура");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public static class ThreadFour extends Thread implements Message {
        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {

            }
        }

        @Override
        public void showWarning() {
           interrupt();
        }
    }

    public static class ThreadFive extends Thread {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        @Override
        public void run() {
            try {
                String s = reader.readLine();
                int n = 0;
                while (!s.equals("N")) {
                    n = n + Integer.parseInt(s);
                    s = reader.readLine();
                }
                System.out.println(n);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}