package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.Advertisement;
import com.javarush.task.task27.task2712.ad.StatisticAdvertisementManager;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.util.*;

public class DirectorTablet {
    public void printAdvertisementProfit() {
        StatisticManager statisticManager = StatisticManager.getInstance();
        Map<String, Long> map = statisticManager.getProfitMap();
        List<String> keyList = new ArrayList<>(map.keySet());
        Collections.sort(keyList);

        for (String key : keyList) {
            double amount = 1.0 * map.get(key) / 100;

            // System.out.println(map.get(key));     //!!!!!!!!!!!!!!!!!!!!!
            ConsoleHelper.writeMessage(String.format(Locale.ENGLISH, "%s - %.2f", key, amount));
        }

    }

    public void printCookWorkloading() {
        StatisticManager statisticManager = StatisticManager.getInstance();
        Map<String, Map<String, Integer>> statMap = statisticManager.getCookWorkloadingMap();
        List<String> keyList = new ArrayList<>(statMap.keySet());
        Collections.sort(keyList);

        for (String key : keyList) {
            Map<String, Integer> cookMap = statMap.get(key);
            ConsoleHelper.writeMessage("");
            ConsoleHelper.writeMessage(key);
            List<String> cookNamesList = new ArrayList<>(statMap.keySet());
            Collections.sort(cookNamesList);

           /* for (String cookName : cookNamesList) {
                Integer workTime = cookMap.get(cookName);
                System.out.println("cookName " + cookName);
                System.out.println("workTime " + workTime);
                if (workTime > 0)
                    ConsoleHelper.writeMessage(cookName + " - " + workTime + " min");
            }*/
            for (Map.Entry<String, Integer> pair : cookMap.entrySet()) {
                String cookName = pair.getKey();
                Integer workTime = pair.getValue();
                if (workTime > 0)
                    ConsoleHelper.writeMessage(cookName + " - " + workTime + " min");
            }
        }
    }

    public void printActiveVideoSet() {
        StatisticAdvertisementManager statisticAdvertisementManager = StatisticAdvertisementManager.getInstance();
        List<Advertisement> activeVideoList = statisticAdvertisementManager.getActiveVideoSet();
        TreeMap<String, Integer> treeMap = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        //Collections.sort(activeVideoList);
        for (Advertisement video : activeVideoList) {
            treeMap.put(video.getName(), video.getHits());
        }
        for (Map.Entry<String, Integer> pair : treeMap.entrySet()) {
            ConsoleHelper.writeMessage(pair.getKey() + " - " + pair.getValue());
        }

    }

    public void printArchivedVideoSet() {
        StatisticAdvertisementManager statisticAdvertisementManager = StatisticAdvertisementManager.getInstance();
        List<Advertisement> archivedVideoList = statisticAdvertisementManager.getArchivedVideoSet();
        TreeSet<String> treeSet = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);

        for (Advertisement video : archivedVideoList) {
            treeSet.add(video.getName());
        }
        Collections.sort(archivedVideoList);
        for (String video : treeSet) {
            ConsoleHelper.writeMessage(video);
        }
    }
}
