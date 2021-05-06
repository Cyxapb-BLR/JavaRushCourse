package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.List;

public class StatisticAdvertisementManager {
    private static StatisticAdvertisementManager statisticAdvertisementManager = new StatisticAdvertisementManager();
    private AdvertisementStorage advertisementStorage = AdvertisementStorage.getInstance();

    private StatisticAdvertisementManager() {

    }

    public static StatisticAdvertisementManager getInstance() {
        if (statisticAdvertisementManager == null)
            statisticAdvertisementManager = new StatisticAdvertisementManager();
        return statisticAdvertisementManager;
    }

    public List<Advertisement> getActiveVideoSet() {
        List<Advertisement> list = new ArrayList<>();
        for (Advertisement video : advertisementStorage.list()) {
            if (video.getHits() > 0)
                list.add(video);
        }
        return list;
    }

    public List<Advertisement> getArchivedVideoSet() {
        List<Advertisement> list = new ArrayList<>();
        for (Advertisement video : advertisementStorage.list()) {
            if (video.getHits() <= 0)
                list.add(video);
        }
        return list;
    }
}
