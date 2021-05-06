package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/

public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            //File yourFile = File.createTempFile("your_file_name", null);
            String yourFile = "e:\\result.txt";
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            // создаем объект с параметрами
            User user = new User("Katerina", "Haustovich", new Date(12 / 23 / 2006), false, User.Country.RUSSIA);
            javaRush.users.add(user);   // добавляем созданный объект в список javaRush
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.save(outputStream);    //записываем список javarush в файл с пом метода save
            outputStream.flush();
            JavaRush loadedObject = new JavaRush();     // создаем объект,который будем загружать из файла
            loadedObject.load(inputStream);     //загружаем из файла инфу в объект с пом метода load
            System.out.println(javaRush.equals(loadedObject));
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            PrintWriter writer = new PrintWriter(outputStream);
            if (this.users.size() > 0) { //проверяем сузествует ли список / есть ли объекты в списке
                for (int i = 0; i < this.users.size(); i++) {       // записываем для каждого объекта всю инфу построчно в файл:
                    writer.println(users.get(i).getFirstName());
                    writer.println(users.get(i).getLastName());
                    writer.println(users.get(i).getBirthDate().getTime());  //сохраняем дату в милисекундах
                    writer.println(users.get(i).isMale());
                    writer.println(users.get(i).getCountry());
                }
            }
            writer.close();
            //implement this method - реализуйте этот метод
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            while (reader.ready()) {        //читаем построчно параметры для объекта из файла
                String firstName = reader.readLine();
                String lastName = reader.readLine();
                Date birthDate = new Date(Long.parseLong(reader.readLine()));
                boolean isMale = Boolean.parseBoolean(reader.readLine());
                String country = reader.readLine();
                User user = new User(firstName, lastName, birthDate, isMale, User.Country.valueOf(country)); //создаем объект по параметрам
                this.users.add(user); //добавляем объект в список loadedObject.users

            }
            reader.close();
            //implement this method - реализуйте этот метод
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
