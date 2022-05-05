package project.sql;

import project.ConsoleColours;
import project.branch.CombinedStudent;
import project.branch.HumaneStudent;
import project.branch.Student;
import project.branch.TechnicalStudent;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SQLOperations {

    public SQLOperations() {
    }

    Connection connection = null;
    Statement statement = null;

    public void getConnection() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:StudentDatabase.db");
        } catch (Exception e) {
            System.out.println(ConsoleColours.RED + "An error occurred." + ConsoleColours.RESET);
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println(ConsoleColours.RED + "An error occurred." + ConsoleColours.RESET);
            e.printStackTrace();
        }
    }

    public void createTable() {
        try {
            statement = connection.createStatement();
            statement.executeUpdate("DROP TABLE IF EXISTS STUDENTS");
            String sql = "CREATE TABLE STUDENTS " +
                    "(ID INT PRIMARY KEY NOT NULL," +
                    "SURNAME TEXT NOT NULL, " +
                    "NAME TEXT NOT NULL, " +
                    "DAY INT NOT NULL, " +
                    "MONTH INT NOT NULL, " +
                    "YEAR INT NOT NULL, " +
                    "GRADES TEXT NOT NULL)" +
                    "BRANCH TEXT NOT NULL)";
            statement.executeUpdate(sql);
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public void insertIntoTable(Student student, String branch) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO STUDENTS(ID,SURNAME,NAME,DAY,MONTH,YEAR,GRADES,BRANCH) VALUES (?,?,?,?,?,?,?,?)"
            );
            preparedStatement.setInt(1, student.getId());
            preparedStatement.setString(2, student.getSurname());
            preparedStatement.setString(3, student.getName());
            preparedStatement.setInt(4, student.getDay());
            preparedStatement.setInt(5, student.getMonth());
            preparedStatement.setInt(6, student.getYear());
            preparedStatement.setString(7, String.valueOf(student.getGrades()));
            preparedStatement.setString(8, branch);

        } catch (Exception e) {
            System.out.println(ConsoleColours.RED + "An error occurred." + ConsoleColours.RESET);
            e.printStackTrace();
        }
    }

    public HashMap<Integer, Student> loadFromTable() {
        HashMap<Integer, Student> studentHashMap = new HashMap<>();
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM STUDENTS");
            while (resultSet.next()) {
                Student student;
                int id = resultSet.getInt("ID");
                String surname = resultSet.getString("Surname");
                String name = resultSet.getString("Name");
                int day = resultSet.getInt("Day");
                int month = resultSet.getInt("Month");
                int year = resultSet.getInt("Year");
                ArrayList<Integer> grades = new ArrayList<>();
                Pattern pattern = Pattern.compile("\\d");
                Matcher matcher = pattern.matcher(resultSet.getString("Grades"));
                while (matcher.find()) {
                    grades.add(Integer.valueOf(matcher.group()));
                }
                String branch = resultSet.getString("Branch");

                switch (branch) {
                    case "Humane":
                        student = new HumaneStudent(id, surname, name, day, month, year);
                        student.setGrades(grades);
                        studentHashMap.put(id, student);
                        break;
                    case "Technic":
                        student = new TechnicalStudent(id, surname, name, day, month, year);
                        student.setGrades(grades);
                        studentHashMap.put(id, student);
                        break;
                    case "Combined":
                        student = new CombinedStudent(id, surname, name, day, month, year);
                        student.setGrades(grades);
                        studentHashMap.put(id, student);
                        break;
                }
            }
            System.out.println(ConsoleColours.GREEN + "Database loaded successfully." + ConsoleColours.RESET);
            return studentHashMap;
        } catch (Exception e) {
            System.out.println(ConsoleColours.RED + "An error occurred." + ConsoleColours.RESET);
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println(ConsoleColours.RED + "An error occurred." + ConsoleColours.RESET);
        return studentHashMap;
    }
}
