package project;

import project.branch.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Database {

    public Database() {
        database = new HashMap<>();
    }

    public Map<Integer, Student> database;

    public int getNextStudentId() {
        int id = 0;
        for (int i : this.database.keySet()) {
            if (i > id) {
                id = i;
            }
        }
        return id + 1;
    }

    public void addStudent(Student student) {
        if (database.containsKey(student.getId())) {
            throw new IllegalArgumentException("Student already exists.");
        }
        this.database.put(student.getId(), student);
    }

    public Student getStudent(int id) {
        Student student = this.database.get(id);
        if (student == null) {
            throw new IllegalArgumentException("Student does not exist.");
        }
        return student;
    }

    public void addGrades(int id, int grade) {
        if (database.containsKey(id)) {
            database.get(id).addGrade(grade);
        } else {
            System.out.println(ConsoleColours.RED + "project.branch.Student s ID " + id + " neexistuje" + ConsoleColours.RESET);
        }
    }

    // TODO Write school
    public boolean writeStudent(int id) {
        if (database.containsKey(id)) {
            if (database.get(id).getGpa() == 0) {
                System.out.println(" ID:  " + id);
                System.out.println(" Jméno:  " + database.get(id).getSurname() + " " + database.get(id).getName());
                System.out.println(" Datum narození:  " + database.get(id).getDay() + ". " +
                        database.get(id).getMonth() + ". " + database.get(id).getYear());
                System.out.println(" Průměr:  " + ConsoleColours.RED + "NEZADÁN" + ConsoleColours.RESET);
            } else {
                System.out.println(" ID:  " + id);
                System.out.println(" Jméno:  " + database.get(id).getSurname() + " " + database.get(id).getName());
                System.out.println(" Datum narození:  " + database.get(id).getDay() + ". " +
                        database.get(id).getMonth() + ". " + database.get(id).getYear());
                System.out.println(" Průměr:  " + database.get(id).getGpa());
            }
            return true;
        } else {
            System.out.println(ConsoleColours.RED + "project.branch.Student neexistuje" + ConsoleColours.RESET);
            return false;
        }
    }
}
