package project;

import project.branch.CombinedStudent;
import project.branch.HumaneStudent;
import project.branch.Student;
import project.branch.TechnicalStudent;

import java.util.Scanner;

public class RunApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Database studentDatabase = new Database();

        boolean run = true;

        while (run) {
            System.out.println("\nMenu:");
            System.out.println(" 01  Add student");
            System.out.println(" 02  Add new grade");
            System.out.println(" 03  Delete student");
            System.out.println(" 04  Information about student");
            System.out.println(" 05  Student's abilities");
            System.out.println(" 06  List of all students");
            System.out.println(" 07  Average grade of each school branch");
            System.out.println(" 08  Amount of students in each school branch");
            System.out.println(" 09  Load database from file");
            System.out.println(" 10  Save database in file");
            System.out.println(" 11  Delete database");
            System.out.println(" 00  Exit\n\n");

            int option = Controls.onlyInt(sc);

            switch (option) {
                case 1:
                    int id;
                    String name;
                    String surname;
                    int day;
                    int month;
                    int year;

                    System.out.println("Choose school branch: ");
                    System.out.println(" 1  Technic branch");
                    System.out.println(" 2  Humane branch");
                    System.out.println(" 3  Combined branch");

                    int branch = Controls.onlyInt(sc);

                    System.out.printf(ConsoleColours.CYAN+ "Surname: " + ConsoleColours.RESET);
                    sc.nextLine();
                    surname = sc.nextLine();
                    System.out.printf(ConsoleColours.CYAN + "Name: " + ConsoleColours.RESET);
                    name = sc.nextLine();
                    System.out.printf(ConsoleColours.CYAN + "Date in format DD/MM/YYYY: " +
                            ConsoleColours.RESET);
                    String line = sc.nextLine();
                    String[] array = line.split("/");
                    day = Integer.parseInt(array[0]);
                    month = Integer.parseInt(array[1]);
                    year = Integer.parseInt(array[2]);
                    id = studentDatabase.getNextStudentId();

                    Student student = null;
                    switch (branch) {
                        case 1:
                            student = new TechnicalStudent(id, surname, name, day, month, year);
                            break;
                        case 2:
                            student = new HumaneStudent(id, surname, name, day, month, year);
                            break;
                        case 3:
                            student = new CombinedStudent(id, surname, name, day, month, year);
                            break;
                        default:
                            System.out.println("Incorrect input.");
                            break;
                    }
                    if (student != null) {
                        studentDatabase.addStudent(student);
                        System.out.println(student);
                    }
                    break;
                case 2:
                    int grade;
                    // TODO First check if ID is valid
                    // TODO FIX: initiation of grade
                    // TODO FIX: All students have same grades
                    System.out.printf(ConsoleColours.CYAN + "Student's ID: " + ConsoleColours.RESET);
                    id = Controls.onlyInt(sc);
                    sc.nextLine();
                    System.out.printf(ConsoleColours.CYAN + "Grade: " + ConsoleColours.RESET);
                    grade = Controls.checkGrade(sc);
                    student = studentDatabase.getStudent(id);
                    student.addGrade(grade);
                    break;
                case 3:
                    System.out.printf(ConsoleColours.CYAN + "Student's ID: " + ConsoleColours.RESET);
                    sc.nextLine();
                    id = Controls.onlyInt(sc);
                    studentDatabase.removeStudent(id);
                    break;
                case 4:
                    System.out.printf(ConsoleColours.CYAN + "Student's ID: " + ConsoleColours.RESET);
                    sc.nextLine();
                    id = Controls.onlyInt(sc);
                    student = studentDatabase.getStudent(id);
                    System.out.println(student);
                    break;
                case 11:
                    studentDatabase = new Database();
                    break;
                case 0:
                    run = false;
                    break;
                default:
                    run = true;
                    break;

            }
        }
    }
}
