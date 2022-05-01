package project.branch;

import project.ConsoleColours;

import java.util.ArrayList;

public abstract class Student implements Comparable<Student>{
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

    public ArrayList<Integer> getGrades() {
        return this.grades;
    }

    public float getAvg() {
        if (grades.size() == 0) {
            return 0;
        } else {
            float sum = 0;
            for (Integer num : grades) {
                sum += num;
            }
            float avg = sum / grades.size();
            return avg;
        }
    }

    // TODO school branch
    public String toString() {
        return ConsoleColours.CYAN + "ID: " + this.id + ConsoleColours.RESET + "\nName and surname: " + this.name +
                " " + this.surname + "\nDate of birth: " + this.day + ". " + this.month + ". " + this.year +
                "\nAverage: " + getAvg() + "\n";
    }

    @Override
    public int compareTo(Student otherStudent) {
        String thisName = this.surname + " " + this.name + " " + this.id;
        String otherName = otherStudent.surname + " " + otherStudent.name + " " + this.id;
        return thisName.compareTo(otherName);
    }

    public void addGrade(int grade) {
        grades.add(grade);
    }

    public void setGrades(ArrayList<Integer> grades) {
        this.grades = grades;
    }
}
