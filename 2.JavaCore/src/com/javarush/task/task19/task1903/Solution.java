package com.javarush.task.task19.task1903;

/* 
Адаптация нескольких интерфейсов
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {


    }

    public static class IncomeDataAdapter implements Customer, Contact {
        private IncomeData data;

        public IncomeDataAdapter(IncomeData data) {
            this.data = data;
        }


        @Override
        public String getCompanyName() {
            return data.getCompany();
        }

        @Override
        public String getCountryName() {
            return countries.get(data.getCountryCode());
        }

        @Override
        public String getName() {
            return data.getContactLastName() + ", " + data.getContactFirstName();
        }

        @Override
        public String getPhoneNumber() {
            int count = 0;
            int number = data.getPhoneNumber();
            String s = "";
            while (number > 0) {
                number = number / 10;
                count++;// количество цифр в номере
            }
            int count0 = 10 - count; //по заданию номер после форматирования должен иметь 10 цифр
            if (count != 0) {
                for (int i = 0; i < count0; i++) {//столько раз нужно добавить 0
                    s = s + 0;// добавление 0
                }
            }

            String formatNumber = s + data.getPhoneNumber();// склеиваем полученное количество 0-лей с номером
            //форматируем по заданному формату
            String result = "(" + formatNumber.substring(0, 3) + ")"
                    + formatNumber.substring(3, 6) + "-"
                    + formatNumber.substring(6, 8) + "-"
                    + formatNumber.substring(8);
            return "+" + data.getCountryPhoneCode() + result;// склеиваем номер с кодом страны и ставим + перед номером
        }
    }


    public static interface IncomeData {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        int getCountryPhoneCode();      //For example: 38

        int getPhoneNumber();           //For example: 501234567
    }

    public static interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }

    public static interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example: +38(050)123-45-67
    }
}