package org.example.ComparatorAndComparable;

import java.util.Comparator;

public class StudentPspComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return (int)(o1.getPsp() - o2.getPsp());
    }
}
