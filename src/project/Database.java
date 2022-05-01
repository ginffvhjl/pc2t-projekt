package project;

import project.branch.CombinedStudent;
import project.branch.HumaneStudent;
import project.branch.Student;
import project.branch.TechnicalStudent;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public void loadFromFile(String file, Database database) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line;

            while ((line = reader.readLine()) != null) {
                Student student;
                String[] array = line.split(";");
                String schoolBranch = array[0];
                int id = Integer.parseInt(array[1]);
                String surname = array[2];
                String name = array[3];
                int day = Integer.parseInt(array[4]);
                int month = Integer.parseInt(array[5]);
                int year = Integer.parseInt(array[6]);
                ArrayList<Integer> grades = new ArrayList<>();
                Pattern pattern = Pattern.compile("\\d");
                Matcher matcher = pattern.matcher(array[7]);
                while (matcher.find()) {
                    grades.add(Integer.valueOf(matcher.group()));
                }
                if (schoolBranch.equals("class project.branch.HumaneStudent")) {
                    student = new HumaneStudent(id, surname, name, day, month, year);
                    student.setGrades(grades);
                    database.addStudent(student);
                }
                if (schoolBranch.equals("class project.branch.TechnicalStudent")) {
                    student = new TechnicalStudent(id, surname, name, day, month, year);
                    student.setGrades(grades);
                    database.addStudent(student);
                }
                if (schoolBranch.equals("class project.branch.CombinedStudent")) {
                    student = new CombinedStudent(id, surname, name, day, month, year);
                    student.setGrades(grades);
                    database.addStudent(student);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
