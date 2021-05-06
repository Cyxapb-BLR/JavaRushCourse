package com.javarush.task.task21.task2107;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/* 
Глубокое клонирование карты
*/
/*  добавил классу Solution и User интерфейс Cloneable
*   сгенеррировал для этих классов автоматом мктоды clone,equals, hashcode
*   переделал метод clone в классе Solution */
public class Solution implements Cloneable {

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Solution o = new Solution();                                    //создаем новый объект
        o.users = new LinkedHashMap<>();                                //создаем новый LinkedHashMap<> для этого объекта(необязательно делать)
        for (Map.Entry<String, User> pair : users.entrySet()) {          // получаем пару ключ и значение
            o.users.put(pair.getKey(), (User) pair.getValue().clone());  //добавляем в o.users этот ключ и создаем клон значения по этому ключу
        }
        return o; //возвращаем клонированый объект, который был клонирован методом глубокого клонирования
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Solution solution = (Solution) o;
        return users.equals(solution.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(users);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        Solution clone = null;
        try {
            clone = (Solution) solution.clone();
            System.out.println(solution);
            System.out.println(clone);

            System.out.println(solution.users);
            System.out.println(clone.users);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace(System.err);
        }
    }

    protected Map<String, User> users = new LinkedHashMap();

    public static class User implements Cloneable {
        int age;
        String name;

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return age == user.age &&
                    name.equals(user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(age, name);
        }

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }
}
