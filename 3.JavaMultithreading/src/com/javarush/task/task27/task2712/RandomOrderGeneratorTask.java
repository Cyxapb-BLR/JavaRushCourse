package com.javarush.task.task27.task2712;

import java.util.ArrayList;
import java.util.List;

public class RandomOrderGeneratorTask implements Runnable {
    private List<Tablet> tabletList = new ArrayList<>();
    private int interval;

    public RandomOrderGeneratorTask(List<Tablet> tablets, int interval) {
        this.tabletList = tablets;
        this.interval = interval;
    }

    @Override
    public void run() {

        while (true) {
            int randomTablet = (int) (Math.random() * tabletList.size());
            Tablet currentTablet = tabletList.get(randomTablet);
            currentTablet.createOrder();
            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                //e.printStackTrace();
            }
        }

    }
}
