package com.javarush.task.task21.task2105;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* 
Исправить ошибку. Сравнение объектов
*/

public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object o) {
        if (o == null)
            return false;
        if (this == o)                       // если объект равен текущему(ссылки на объект равны),то true
            return true;
        if (!(o instanceof Solution))       // проверяем принадлежит ли объект классу Solution
            return false;
        Solution n = (Solution) o;
        return (n.first == (first)) && (n.last == (last));
    }

    @Override
    public int hashCode() {         //переопределили хэшкод, так как при сравнении объектов должен быть равен hashCode прежде чем запустится првоерка в equals
        return Objects.hash(first, last);
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Mickey", "Mouse"));
        System.out.println(s.contains(new Solution("Mickey", "Mouse")));
    }
}
