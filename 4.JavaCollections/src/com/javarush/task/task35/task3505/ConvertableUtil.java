package com.javarush.task.task35.task3505;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertableUtil {

    public static <K, V extends Convertable> Map convert(List<V> list) {    //оба варианта работают
        Map result = new HashMap();
        for (V value : list) {
            Object key = value.getKey();
            result.put(key, value);
        }
        return result;
    }
    /*public static <K, V extends Convertable<K>> Map convert(List<V> list) {
        Map result = new HashMap();
        for (V value : list) {
            K key = value.getKey();
            result.put(key, value);
        }
        return result;
    }*/
}
