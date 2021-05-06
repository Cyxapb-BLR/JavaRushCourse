package com.javarush.task.task20.task2022;

import java.io.*;

/* 
Переопределение сериализации в потоке
*/

public class Solution implements Serializable, AutoCloseable {
    transient private FileOutputStream stream;
    private String fileName;    //создаем переменную

    public Solution(String fileName) throws FileNotFoundException {
        this.fileName = fileName;   //иницилизируем
        this.stream = new FileOutputStream(fileName);
    }


    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.flush();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        stream = new FileOutputStream(fileName, true); //восстанавливаем поток записи в тот же самый файл
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        /*Смысл задачи в том,что мы не можем сериализовать поток,но можем сериализовать название файла,в который пишется поток.
         * При десериализации восстанавливаем название файла и создаем поток,который будет снова записывать в этот файл*/

        Solution solution = new Solution("e:\\result.txt");    // создаем объект Solution  с именем файла
        solution.writeObject("test");                           //записываем строку в файл с именем из объекта solution
        FileOutputStream fileOutputStream = new FileOutputStream("e:\\result1.txt");    //файл для сериализации
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(solution);                       //сериализуем объект в файл: имя первого файла ( stream у нас transient)
        objectOutputStream.close();
        fileOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream("e:\\result1.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Solution newSolution = (Solution) objectInputStream.readObject();   //десериализация
        newSolution.writeObject("test2");                               //пишем строку в файл
        System.out.println(solution.fileName.equals(newSolution.fileName));     //имена файлов совпадают, поэтому строки записаны в один файл,чтд
        fileInputStream.close();
        objectInputStream.close();
    }
}
