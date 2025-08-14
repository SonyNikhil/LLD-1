package org.example.ComparatorAndComparable;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Client
{
    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();

        Student st1 = new Student(19, 56.0, "Alex", 89.0);
        Student st2 = new Student(27, 55.0, "Bob", 90.0);

        students.add(st1);
        students.add(st2);
        students.add(new Student(22, 54.0, "Charlie", 91.0));
        students.add(new Student(20, 53.0, "David", 92.0));
        students.add(new Student(18, 52.0, "Eve", 93.0));

        System.out.println(students.toString());
        Collections.sort(students);

        System.out.println(students);

    }
}
