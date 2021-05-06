package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.util.Arrays;
import java.util.Collections;

public class AdvertisementManager {
    // у каждого планшета будет свой объект менеджера, который будет подбирать оптимальный набор роликов и их последовательность для каждого заказа.
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() {  // !!!!! ошибка в этом методе

        if (storage.list().isEmpty())
            throw new NoVideoAvailableException();
        Collections.sort(storage.list());
        /*for (Advertisement video : storage.list()
        ) {
            System.out.println(video.getAmountPerOneDisplaying() + " + " + video.getDuration() + " + " + video.getName());
        }*/
        int count = 0;
        long amount = 0;
       /* System.out.println("timeSeconds ( AdMan/ process) " + timeSeconds);
        System.out.println("storage.list().toArray() " + Arrays.toString(storage.list().toArray()));*/
       /* for (Advertisement video : storage.list()) {
            amount += video.getAmountPerOneDisplaying();
        }*/

       //FISH StatisticManager.getInstance().register(new VideoSelectedEventDataRow(storage.list(), amount, timeSeconds));//!!!!второй параметр не storage.list().size()
       /* while (timeSeconds>0 && storage.list().size()>0){
            int duration = storage.list().get(count++).getDuration();
            if (timeSeconds>=duration)
        }*/
        //long amount = 0;
        while (timeSeconds > 0 && count < storage.list().size()) {
            int duration = storage.list().get(count).getDuration();
            if (timeSeconds >= duration && storage.list().get(count).getHits() > 0) {
                amount += storage.list().get(count).getAmountPerOneDisplaying();
                storage.list().get(count).revalidate();
                // System.out.println("проигрывается видео " + storage.list().get(count).getName());
                ConsoleHelper.writeMessage(storage.list().get(count).toString());
                count++;
                timeSeconds = timeSeconds - duration;
            } else count++;
        }
        //System.out.println("amount" + amount);
        StatisticManager.getInstance().register(new VideoSelectedEventDataRow(storage.list(), amount, timeSeconds));
    }
}
