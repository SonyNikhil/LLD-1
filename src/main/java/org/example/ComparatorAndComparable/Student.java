package org.example.ComparatorAndComparable;


public class Student implements Comparable<Student>
{
    private int age;
    private double psp;
    private String name;
    private double attendance;

    public Student (int age, double psp, String name, double attendance)
    {
        this.age = age;
        this.name = name;
        this.psp = psp;
        this.attendance = attendance;
    }

    public int getAge() { return age; }
    public double getPsp() { return psp; }
    public String getName() { return name; }
    public double getAttendance() { return attendance; }

    // Custom toString method
    @Override
    public String toString()
    {
        return "Student{" +
                "age=" + age +
                ", psp=" + psp +
                ", name='" + name + '\'' +
                ", attendance=" + attendance +
                '}';
    }


    //Sort in descending order of age
    @Override
    public int compareTo(Student other){

        //If i want this object to come first -> return -1
        //If i want other object to come first -> return 1
        //else for equal case -> return 0

        if(this.age > other.age)
        {
            return -1;
        }
        else if(this.age < other.age){
            return 1;
        }
        else{
            return 0;
        }

        // Another way to write this code
        //return this.age-other.age;
    }
}
