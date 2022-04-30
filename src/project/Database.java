package project;

import project.branch.Student;

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

    public void removeStudent(int id) {
        Student student = this.database.remove(id);
        if (student == null) {
            throw new IllegalArgumentException("Student does not exist.");
        }
    }

    public void printAllStudents() {
        for (int i = 1; i < this.database.size() + 1; i++) {
            System.out.println(getStudent(i));
        }
    }

}
