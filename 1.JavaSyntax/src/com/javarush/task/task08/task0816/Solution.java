package com.javarush.task.task08.task0816;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/*
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static Map<String, Date> createMap() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);

        Map<String, Date> map = new HashMap<>();
        map.put("Сталлоне", dateFormat.parse("MAY 1 2012"));
        map.put("Кутовская", dateFormat.parse("JUNE 21 1988"));
        map.put("Слаек", dateFormat.parse("JULY 1 1990"));
        map.put("Хаустова", dateFormat.parse("DECEMBER 23 1996"));
        map.put("Яскевич", dateFormat.parse("AUGUST 21 1985"));
        map.put("Киселев", dateFormat.parse("JANUARY 19 1990"));
        map.put("Казакевич", dateFormat.parse("JANUARY 29 1990"));
        map.put("Вороницкий", dateFormat.parse("JUNE 4 1990"));
        map.put("Мацкевич", dateFormat.parse("FEBRUARY 22 1961"));
        map.put("Пура", dateFormat.parse("OCTOBER 10 1989"));
        return map;

        //напишите тут ваш код
    }

    public static void removeAllSummerPeople(Map<String, Date> map) {
        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Date> pair = iterator.next();
            int value = pair.getValue().getMonth();
            if (value >=5 && value <= 7 )
            //(value.contains("JUNE") || value.contains("JULY") || value.contains("AUGUST"))
            {
                iterator.remove();
            }
        }
        //напишите тут ваш код

    }

    public static void main(String[] args) {

    }
}
