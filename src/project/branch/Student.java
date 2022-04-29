package project.branch;

import java.util.ArrayList;

public abstract class Student {
    private int id;

    private String surname;
    private String name;

    private int day;
    private int month;
    private int year;

    ArrayList<Integer> grades;

    public Student(int id, String surname, String name, int day, int month, int year) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.day = day;
        this.month = month;
        this.year = year;
        this.grades = new ArrayList<>();
    }

    public Student(int id, String surname, String name, int day, int month, int year, ArrayList<Integer> grades) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.day = day;
        this.month = month;
        this.year = year;
        this.grades = grades;
    }

    public int getId() {
        return this.id;
    }

    public String getSurname() {
        return this.surname;
    }

    public String getName() {
        return this.name;
    }

    public int getDay() {
        return this.day;
    }

    public int getMonth() {
        return this.month;
    }

    public int getYear() {
        return this.year;
    }

    public float getGpa() {
        if (grades.size() == 0) {
            return 0;
        } else {
            //gpa = grades.stream().mapToFloat(num->num).average().getAsFloat();
            float sum = 0;
            for (Integer num : grades) {
                sum += num;
            }
            float gpa = sum / grades.size();
            return gpa;
        }
    }

    // TODO school branch
    public String toString() {
        return "ID: " + this.id + "\nName and surname: " + this.name + " " + this.surname + "\nDate of birth: " +
                this.day + ". " + this.month + ". " + this.year;
    }

    public void addGrade(int grade) {
        grades.add(grade);
    }
}
