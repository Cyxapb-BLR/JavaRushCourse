package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread {
    private Thread target;

    @Override
    public void run() {
        super.run();
        Thread.State state;                                         //для текущего состояния нити
        Thread.State changeState = null;                            //если состояние нити изменилось
        while ((state = target.getState()) != State.TERMINATED) {   //пока состояние нити не равно TERMINATED(нить завершилась)
            if (state != changeState) {
                changeState = state;                                //присваиваем состояние текущей нити,если оно изменилось
                System.out.println(changeState);
            }
        }
        System.out.println(state);                                  //последнее состояние нити ( = TERMINATED)
    }

    public LoggingStateThread(Thread target) {
        this.target = target;
    }
}
