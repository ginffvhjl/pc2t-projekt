package project;

import project.branch.Student;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

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

    public void removeStudent(int id) {
        Student student = this.database.remove(id);
        if (student == null) {
            throw new IllegalArgumentException("Student does not exist.");
        }
    }

    public void printAllStudentsByAlphabet() {

        ArrayList<Student> students = new ArrayList<>(database.values());
        Collections.sort(students);
        students.forEach(System.out::println);
    }

    public float getBranchAvg(Class branch) {
        float sum = 0.0F;
        int count = 0;

        for (Student student : this.database.values()) {
            if (student.getClass() == branch) {
                sum += student.getAvg();
                count += 1;
            }
        }

        if (count == 0) return 0.0F;
        return sum / count;
    }

    public int getBranchSize(Class branch) {
        int count = 0;
        for (Student student : this.database.values()) {
            if (student.getClass() == branch) {
                count += 1;
            }
        }
        return count;
    }

    public void saveToFile(String file) {
        try (PrintWriter writer = new PrintWriter(file)) {
            for (Student student : this.database.values()) {
                writer.append(student.getClass() + ";" + student.getId() + ";" + student.getSurname() + ";" +
                        student.getName() + ";" + student.getDay() + ";" + student.getMonth() + ";" +
                        student.getYear() + ";" + student.getGrades() + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
