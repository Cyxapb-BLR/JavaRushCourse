package com.javarush.task.task21.task2108;

/* 
Клонирование растений
*/

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Tree tree = new Tree("willow", new String[]{"s1", "s2", "s3", "s4"});
        Tree clone = null;
        try {
            clone = (Tree) tree.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println(tree);
        System.out.println(clone);

        System.out.println(tree.branches);
        System.out.println(clone.branches);
    }

    public static class Plant {
        private String name;

        public Plant(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static class Tree extends Plant implements Cloneable { //добавляем интерфес Cloneable и генерируем методы clone,equals,hashcode
        private String[] branches;

        @Override
        protected Object clone() throws CloneNotSupportedException {
            Tree treeClone = (Tree) super.clone();                  //создаем новый объект,в который будет писаться клон начального
            treeClone.branches = new String[branches.length];       //новый массив,чтобы клонировать каждый элемент Стринг из массива branches клонируемого объекта
            for (int i = 0; i < branches.length; i++) {
                treeClone.branches[i] = branches[i];                //копируем все эдементы массива в массив клона
            }
            return treeClone;                                       //возвращаем полный клон объекта, клонированный с пом глубокого(полного) клонирования
            // можно было в одну строку "return new Tree(getName(), branches.clone());"
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Tree tree = (Tree) o;
            return Arrays.equals(branches, tree.branches);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(branches);
        }

        public Tree(String name, String[] branches) {
            super(name);
            this.branches = branches;
        }

        public String[] getBranches() {
            return branches;
        }
    }
}
