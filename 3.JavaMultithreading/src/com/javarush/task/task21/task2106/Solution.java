package com.javarush.task.task21.task2106;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/* 
Ошибка в equals/hashCode
*/

public class Solution {
    private int anInt;
    private String string;
    private double aDouble;
    private Date date;
    private Solution solution;

    public Solution(int anInt, String string, double aDouble, Date date, Solution solution) {
        this.anInt = anInt;
        this.string = string;
        this.aDouble = aDouble;
        this.date = date;
        this.solution = solution;
    }

    public Solution() {

    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (this == o) return true;
        if (!(o instanceof Solution)) return false;         //поставил !

        Solution solution1 = (Solution) o;

        if (Double.compare(solution1.aDouble, aDouble) != 0) return false;
        if (anInt != solution1.anInt) return false;
        if (date != null ? !date.equals(solution1.date) : solution1.date != null) return false;                 //поставил != в конце
        if (solution != null ? !solution.equals(solution1.solution) : solution1.solution != null) return false; //поставил != в конце
        if (string != null ? !string.equals(solution1.string) : solution1.string != null) return false;         //поставил != в конце

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = anInt;
        temp = aDouble != +0.0d ? Double.doubleToLongBits(aDouble) : 0L;
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (solution != null ? solution.hashCode() : 0);
        return result;
    }

    public static void main(String[] args) throws ParseException {

        /* для проверки
        Set<Solution> set = new HashSet<>();

        Solution solution = new Solution(5, "Ooops!", 2.5d, new SimpleDateFormat("dd.MM.yyyy").parse("24.03.2020"), new Solution());

        set.add(solution);

        System.out.print(set.contains(new Solution(5, "Ooops!", 2.5d, new SimpleDateFormat("dd.MM.yyyy").parse("24.03.2020"), new Solution())));
*/
    }
}
