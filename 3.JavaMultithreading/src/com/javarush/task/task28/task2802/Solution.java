package com.javarush.task.task28.task2802;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* 
Пишем свою ThreadFactory
*/

public class Solution {
    public static class AmigoThreadFactory implements ThreadFactory {

        private AtomicInteger threadNumber = new AtomicInteger(1);
        private static AtomicInteger factory = new AtomicInteger(1);
        private int factoryNumber = factory.getAndIncrement();

        @Override
        public Thread newThread(Runnable r) {

            Thread newThread = new Thread();
            newThread.setPriority(Thread.NORM_PRIORITY);
            newThread.setDaemon(false);

            newThread.setName(String.format("%s-pool-%d-thread-%d", Thread.currentThread().getThreadGroup().getName(), factoryNumber, threadNumber.getAndIncrement()));
            System.out.println(newThread.getName());
            return newThread;
        }
    }

    public static void main(String[] args) {
        class EmulatorThreadFactoryTask implements Runnable {
            @Override
            public void run() {
                emulateThreadFactory();
            }
        }

        ThreadGroup group = new ThreadGroup("firstGroup");
        Thread thread = new Thread(group, new EmulatorThreadFactoryTask());

        ThreadGroup group2 = new ThreadGroup("secondGroup");
        Thread thread2 = new Thread(group2, new EmulatorThreadFactoryTask());

        thread.start();
        thread2.start();
    }

    private static void emulateThreadFactory() {
        AmigoThreadFactory factory = new AmigoThreadFactory();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        };
        factory.newThread(r).start();
        factory.newThread(r).start();
        factory.newThread(r).start();
    }
}
