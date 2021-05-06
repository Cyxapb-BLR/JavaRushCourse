package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.text.SimpleDateFormat;
import java.util.*;

public class StatisticManager {     //С его помощью будем регистрировать события в хранилище
    //У нас должно быть одно хранилище с одной точкой входа. Поэтому сделаем StatisticManager синглтоном.
    private static StatisticManager statisticManager;
    private StatisticStorage statisticStorage = new StatisticStorage();



    private StatisticManager() {    //приватный конструктор нужен, т.к. класс является синглтоном и нельзя создавать из вне объект через new
    }

    public static StatisticManager getInstance() {
        if (statisticManager == null)
            statisticManager = new StatisticManager();
        return statisticManager;
    }

    private class StatisticStorage {
        private Map<EventType, List<EventDataRow>> storage = new HashMap<>();

        public List<EventDataRow> get(EventType type) {
            if (storage.containsKey(type))
                return storage.get(type);
            else throw new UnsupportedOperationException();
        }

        public StatisticStorage() {
            for (EventType eventType : EventType.values()) {
                storage.put(eventType, new ArrayList<>());
            }
        }

        private void put(EventDataRow data) {
            if (storage.containsKey(data.getType()))
                storage.get(data.getType()).add(data);
        }
    }

    public void register(EventDataRow data) {
        statisticStorage.put(data);
    }

    public Map<String, Long> getProfitMap() {
        Map<String, Long> map = new HashMap<>();
        List<EventDataRow> rowList = statisticStorage.get(EventType.SELECTED_VIDEOS);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        long total = 0l;
        for (EventDataRow row : rowList) {
            VideoSelectedEventDataRow dataRow = (VideoSelectedEventDataRow) row;
            String stringDate = simpleDateFormat.format(dataRow.getDate());

            if (!map.containsKey(stringDate)) {
                map.put(stringDate, 0l);
            }
            total += dataRow.getAmount();
            //System.out.println(" map.get(stringDate) + dataRow.getAmount() " + map.get(stringDate) + " + " + dataRow.getAmount());
            map.put(stringDate, map.get(stringDate) + dataRow.getAmount());

        }
        map.put("Total", total);
        return map;
    }

    public Map<String, Map<String, Integer>> getCookWorkloadingMap() {
        Map<String, Map<String, Integer>> map = new HashMap<>();
        List<EventDataRow> rowList = statisticStorage.get(EventType.COOKED_ORDER);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        for (EventDataRow row : rowList) {
            CookedOrderEventDataRow dataRow = (CookedOrderEventDataRow) row;
            String stringDate = dateFormat.format(row.getDate());
            if (!map.containsKey(stringDate))
                map.put(stringDate, new HashMap<>());
            Map<String, Integer> cookMap = map.get(stringDate);
            String cookName = dataRow.getCookName();
            if (!cookMap.containsKey(cookName))
                cookMap.put(cookName, 0);
            Integer totalTime = cookMap.get(cookName);
            // System.out.println("dataRow.getTime()" + dataRow.getTime());
            cookMap.put(cookName, dataRow.getTime() + totalTime);
            // System.out.println(cookName + " " + cookMap.get(cookName));
        }
        return map;
    }
}
