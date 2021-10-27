package com.javarush.task.task35.task3507;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

/* 
ClassLoader - что это такое?
*/

public class Solution {
    public static void main(String[] args) {
        Set<? extends Animal> allAnimals = getAllAnimals(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + Solution.class.getPackage().getName().replaceAll("[.]", "/") + "/data");
        System.out.println(allAnimals);
    }

    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) {
        //System.out.println("pathToAnimals:" + pathToAnimals + "\n");

        Set<Animal> animals = new HashSet<>();
        MyClassLoader classLoader = new MyClassLoader();

        File[] files = new File(pathToAnimals).listFiles(); //проверяем есть ли по данному пути файлы
        try {
            for (File file : files) {
                //System.out.println("file: " + file);

                Class clazz = classLoader.loadClass(file.getAbsolutePath());    //получаем абсолютный путь файла

                if (Animal.class.isAssignableFrom(clazz)) {     //проверяем наследуется ли класс от Animal

                    Constructor constructor = clazz.getConstructor();   //пытаемся получить публичный конструктор по умолчанию

                    //System.out.println(constructor);

                    animals.add((Animal) constructor.newInstance());
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }

        return animals;
    }

    static class MyClassLoader extends ClassLoader {
       /* @Override
        public Class<?> loadClass(String name) throws ClassNotFoundException {
            return super.loadClass(name);
        }*/

        @Override
        protected Class<?> findClass(String name) {
            Class clazz = null;

            try {
                byte[] bytes = Files.readAllBytes(Paths.get(name));
                clazz = defineClass(null, bytes, 0, bytes.length);
            } catch (IOException e) {
                e.printStackTrace();
            }
            //System.out.println("findClass: " + clazz);
            return clazz;
        }
    }
}
