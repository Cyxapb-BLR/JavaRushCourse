package com.javarush.task.task20.task2001;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Читаем и пишем в файл: Human
*/

public class Solution {
    public static void main(String[] args) {
        //исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("e:\\result.txt", null);  //создается в папке темп винды
            //String your_file_name = "e:\\result.txt";
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            Human ivanov = new Human("Ivanov", new Asset("home", 999_999.99), new Asset("car", 2999.99)); //создаем объект
            ivanov.save(outputStream);       //записываем лбъект в файл с пом метода save
            outputStream.flush();

            Human somePerson = new Human();     //создаем новый объект
            somePerson.load(inputStream);       //загружаем в него данные из файла методом load
            inputStream.close();
            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны
            System.out.println(ivanov.equals(somePerson)); //сравниваем объекты

            /*System.out.println(ivanov.name.equals(somePerson.name));
            System.out.println(ivanov.assets.get(1).equals(somePerson.assets.get(1)));*/

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Human human = (Human) o;

            if (name != null ? !name.equals(human.name) : human.name != null) return false;
            return assets != null ? assets.equals(human.assets) : human.assets == null;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (assets != null ? assets.hashCode() : 0);
            return result;
        }

        public void save(OutputStream outputStream) throws Exception {
            PrintWriter printWriter = new PrintWriter(outputStream);
            if (this.name != null ) {
                printWriter.println(this.name);
            }
            if (this.assets.size() > 0) {
                for (Asset asset : this.assets) {
                    if (asset != null) {
                        printWriter.println(asset.getName());
                        printWriter.println(asset.getPrice());
                    }
                }
            }
            printWriter.close();
            //implement this method - реализуйте этот метод
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String nameFromFile = reader.readLine();    // имя человека из файла
            if (nameFromFile != null) {
                this.name = nameFromFile;   //присваиваем имя из файла в this.name
            }
            String line;    //прочитанная строка
            String assetName = "";   //иницилизация переменой
            double assetPrice = -1.0;   //иницилизация переменой
            int count = 0; //счетчик
            while ((line = reader.readLine()) != null) {     //читаем строку,если она есть
                if (count % 2 == 0) {       //четная строка соотвествует AssetName
                    assetName = line;
                    //System.out.println(assetName);
                } else {
                    assetPrice = Double.parseDouble(line);      //нечетная строка соотвествует assetPrice
                    //System.out.println(assetPrice);
                }
                count++;
                if (count % 2 == 0 && count > 0) {      //каждые две строки соотвествуют AssetName и assetPrice
                    this.assets.add(new Asset(assetName, assetPrice));  //помещаем AssetName и assetPrice в список
                }
            }
            /*  можно было цикл while записать проще:
            while (reader.ready()) {
                String assetName = reader.readLine();
                double assetPrice = Double.parseDouble(reader.readLine());
                this.assets.add(new Asset(assetName, assetPrice));
            }*/
            reader.close();
            //implement this method - реализуйте этот метод
        }
    }
}
