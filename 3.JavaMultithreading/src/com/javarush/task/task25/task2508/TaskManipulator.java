package com.javarush.task.task25.task2508;

public class TaskManipulator implements Runnable, CustomThreadManipulator {
    private Thread thread;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        while (!thread.isInterrupted()) {
            try {
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                break;
                /*сбрасываем цикл, потому что при возникновении исключения при флаге isInterrupted()=true
                 флаг сбрасывается обратно в значение false , а нам нужо обязательно остановить цикл.
                 либо нужно включить interrupt для нити снова
                 либо цикл поместить в try  */
            }
        }
    }

    @Override
    public void start(String threadName) {
        thread = new Thread(this);              //!!!!!
        thread.setName(threadName);
        //System.out.println(thread.getName());
        thread.start();
    }

    @Override
    public void stop() {
        thread.interrupt();
    }
}
