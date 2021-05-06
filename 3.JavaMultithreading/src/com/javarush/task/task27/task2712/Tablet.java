package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.AdvertisementManager;
import com.javarush.task.task27.task2712.ad.NoVideoAvailableException;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.TestOrder;

import java.io.IOException;
import java.util.Observable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tablet {
    private final int number;       //это номер планшета, чтобы можно было однозначно установить, откуда поступил заказ
    //    У нас все завязано на работу с консолью. Однако, при возникновении исключений, наше приложение умрет.
//    Чтобы узнать причину - добавим в Tablet статическое поле logger типа java.util.logging.Logger, инициализированное именем класса (Logger.getLogger(Tablet.class.getName())).
    static java.util.logging.Logger logger = Logger.getLogger(Tablet.class.getName());

    private LinkedBlockingQueue queue = new LinkedBlockingQueue();

    public void setQueue(LinkedBlockingQueue queue) {
        this.queue = queue;
    }

    public Tablet(int number) {
        this.number = number;
    }

    public Order createOrder() {
        Order order = null;
        try {
            //new Order(this);
            order = new Order(this);
            createUniversalOrder(order);

        } catch (NoVideoAvailableException e) {
            logger.log(Level.INFO, "No video is available for the order " + order);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
        }
        return order;
    }

    private void createUniversalOrder(Order order) {
        if (!order.isEmpty()) {
            ConsoleHelper.writeMessage(order.toString());
            AdvertisementManager manager = new AdvertisementManager(order.getTotalCookingTime() * 60);
            manager.processVideos();
        }
    }

    @Override
    public String toString() {
        return "Tablet{" +
                "number=" + number +
                '}';
    }

    public void createTestOrder() {
        Order order = null;
        try {
            //new Order(this);
            order = new TestOrder(this);
            createUniversalOrder(order);

        } catch (NoVideoAvailableException e) {
            logger.log(Level.INFO, "No video is available for the order " + order);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
        }
    }

}
