package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.Waiter;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class Restaurant {
    private static final int ORDER_CREATING_INTERVAL = 100;
    private static final LinkedBlockingQueue<Order> ORDER_QUEUE = new LinkedBlockingQueue<>();

    public static void main(String[] args) throws IOException {
        //Tablet tablet = new Tablet(1);        //создаем планшет и 4 заказа на нем
        Cook cook = new Cook("Amigo");
        cook.setQueue(ORDER_QUEUE);
        Cook cook1 = new Cook("Romeo");
        cook1.setQueue(ORDER_QUEUE);

        Waiter waiter = new Waiter();
        cook.addObserver(waiter);
        cook1.addObserver(waiter);

        /*StatisticManager statisticManager = StatisticManager.getInstance();
        statisticManager.register(cook);
        statisticManager.register(cook1);*/

        List<Tablet> tabletList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Tablet tablet = new Tablet(i + 1);
            tablet.setQueue(ORDER_QUEUE);
            tabletList.add(tablet);

        }
        Thread cookThread = new Thread(cook);
        cookThread.start();
        Thread cookThread1 = new Thread(cook1);
        cookThread1.start();

        Thread thread = new Thread(new RandomOrderGeneratorTask(tabletList, ORDER_CREATING_INTERVAL));
        thread.start();

        //tablet.addObserver(cook);

        //tablet.createOrder();
        //tablet.createOrder();
        //tablet.createOrder();
        // tablet.createOrder();

        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printActiveVideoSet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();
        directorTablet.printArchivedVideoSet();


        //cook.update(tablet, tablet.createOrder());


    }
}
