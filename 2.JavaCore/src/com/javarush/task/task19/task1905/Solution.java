package com.javarush.task.task19.task1905;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Закрепляем адаптер
*/

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {

    }

    public static class DataAdapter implements RowItem {
        private Customer customer;
        private Contact contact;

        public DataAdapter(Customer customer, Contact contact) {
            this.customer = customer;
            this.contact = contact;
        }

        @Override
        public String getCountryCode() {
            String countryName = customer.getCountryName();//нужно по значение найти ключ в countries
            String countryCode = "";
            for (Map.Entry<String, String> entry : countries.entrySet()) {
                if (entry.getValue().equals(countryName)) {
                    countryCode = entry.getKey();
                }
            }
            return countryCode;
        }

        @Override
        public String getCompany() {
            return customer.getCompanyName();
        }

        @Override
        public String getContactFirstName() {
            String[] fullName = contact.getName().split(", ", 2);//создаем массив на 2 элемента для фамилии и имени
            return fullName[1];// имя содержится во втором элементе массива
        }

        @Override
        public String getContactLastName() {
            String[] fullName = contact.getName().split(", ", 2);//создаем массив на 2 элемента для фамилии и имени
            return fullName[0];//вамилия содержится в первом элементе массива
        }

        @Override
        public String getDialString() {
            String contactPhoneNumber = contact.getPhoneNumber(); //формат номера контакта,который нужно привести к виду +380501234567
            contactPhoneNumber = contactPhoneNumber.replace("(", ""); //убираем "("
            contactPhoneNumber = contactPhoneNumber.replace(")", ""); //убираем ")"
            contactPhoneNumber = contactPhoneNumber.replace("-", ""); //убираем "-"

            return "callto://" + contactPhoneNumber; //номер уже содержит "+"
        }
    }

    public static interface RowItem {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        String getDialString();         //For example: callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }

    public static interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example: +38(050)123-45-67 or +3(805)0123-4567 or +380(50)123-4567 or ...
    }
}