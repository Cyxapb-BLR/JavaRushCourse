package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* 
Формируем WHERE
*/

public class Solution {
    public static void main(String[] args) {
        //сделал для проверки работы все что в main:
        Map<String, String> map = new LinkedHashMap<>();    // если использовать LinkedHashMap<>() вместо HashMap<>(),
                                                            // то остается порядок при выводе такой же как был при вводе
        map.put("name", "Ivanov");
        map.put("country", "Belarus");
        map.put("city", "Minsk");
        map.put("age", null);
        System.out.println(getQuery(map));
    }

    public static String getQuery(Map<String, String> params) {
        if (params.size() > 0) {
            StringBuilder stringBuilder = new StringBuilder();

            for (Map.Entry<String, String> pair : params.entrySet()) {
                String key = pair.getKey();
                String value = pair.getValue();
                if (value != null) {
                    stringBuilder.append(key).append(" = ").append("'").append(value).append("'").append(" and ");
                }
            }
            if (stringBuilder.length() > 0) {
                stringBuilder.delete(stringBuilder.lastIndexOf(" and "), stringBuilder.length());
                return stringBuilder.toString();
            }
        }
        return "";
    }
}
