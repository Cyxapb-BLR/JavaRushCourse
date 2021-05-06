package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University {
    String name;
    int age;
    private List<Student> students = new ArrayList<>();
    private String university;

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public University(String name, int age) {
        //super(name, age, 0);
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        //TODO:
        for (Student student : students) {
            if (student.getAverageGrade() == averageGrade)
                return student;
        }
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        //TODO:
        int index = -1;
        double maxAverageGrade = 0;
        for (int i = 0; i < students.size(); i++) {
            double currentAverageGrade = students.get(i).getAverageGrade();
            if (currentAverageGrade > maxAverageGrade) {
                maxAverageGrade = currentAverageGrade;
                index = i;
            }
        }
        return students.get(index);
    }

    /*public void getStudentWithMinAverageGradeAndExpel() {
        //TODO:
    }*/
    public Student getStudentWithMinAverageGrade() {
        int index = -1;
        double minAverageGrade = Double.MAX_VALUE;
        for (int i = 0; i < students.size(); i++) {
            double currentAverageGrade = students.get(i).getAverageGrade();
            if (currentAverageGrade < minAverageGrade) {
                minAverageGrade = currentAverageGrade;
                index = i;
            }
        }
        return students.get(index);
    }

    public void expel(Student student) {
        students.remove(student);
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }
}