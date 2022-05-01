package project;

import project.branch.CombinedStudent;
import project.branch.HumaneStudent;
import project.branch.Student;
import project.branch.TechnicalStudent;

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

    public float getHumaneAvg() {
        ArrayList<HumaneStudent> humaneStudents = new ArrayList<>();

        float humaneBranchAvg = 0;
        for (int i = 1; i < humaneStudents.size() + 1; i++) {
            humaneBranchAvg = (humaneBranchAvg + humaneStudents.get(i).getAvg());
        }
        humaneBranchAvg = humaneBranchAvg / humaneStudents.size();
        return humaneBranchAvg;
    }

    public float getTechnicalAvg() {
        ArrayList<TechnicalStudent> technicalStudents = new ArrayList<>();
        float technicalBranchAvg = 0;
        for (int i = 1; i < technicalStudents.size() + 1; i++) {
            technicalBranchAvg = (technicalBranchAvg + technicalStudents.get(i).getAvg());
        }
        technicalBranchAvg = technicalBranchAvg / technicalStudents.size();
        return technicalBranchAvg;
    }

    public float getCombinedAvg() {
        ArrayList<CombinedStudent> combinedStudents = new ArrayList<>();

        float combinedBranchAvg = 0;
        for (int i = 1; i < combinedStudents.size() + 1; i++) {
            combinedBranchAvg = (combinedBranchAvg + combinedStudents.get(i).getAvg());
        }
        combinedBranchAvg = combinedStudents.size();
        return combinedBranchAvg;
    }
}
